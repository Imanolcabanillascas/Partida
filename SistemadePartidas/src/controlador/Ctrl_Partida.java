/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controlador;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import modelo.Partida;

/**
 *
 * @author LENOVO
 */
public class Ctrl_Partida {

    public boolean guardar(Partida objeto) {
        boolean respuesta = false;
        Connection cn = conexion.conexion.conectar();
        try {
            PreparedStatement consulta = cn.prepareStatement("insert into partida values(?,?,?,?,?,?,?,?)");
            consulta.setInt(1, 0);
            consulta.setString(2, objeto.getN_partida());
            consulta.setString(3, objeto.getNombres());
            consulta.setString(4, objeto.getApellido_pat());
            consulta.setString(5, objeto.getApellido_mat());
            consulta.setString(6, objeto.getFolio());
            consulta.setInt(7, objeto.getId_Libro());
            consulta.setInt(8, objeto.getId_tipoPartida());
            if (consulta.executeUpdate() > 0) {
                respuesta = true;
            }
        } catch (SQLException e) {
            System.err.println("Error al conectar");
        }
        return respuesta;
    }

    public boolean existePartidaNum(String n_partida) {
        boolean existe = false;
        Connection cn = conexion.conexion.conectar();
        try {
            String consultaSQL = "SELECT * FROM partida WHERE n_partida = ?";
            PreparedStatement consulta = cn.prepareStatement(consultaSQL);
            consulta.setString(1, n_partida);
            ResultSet resultado = consulta.executeQuery();
            existe = resultado.next();
        } catch (SQLException e) {
            System.err.println("Error al consultar la existencia del Numero de Partida");
        }

        return existe;
    }

    public boolean eliminar(int idPartida) {
        boolean respuesta = false;
        Connection cn = conexion.conexion.conectar();
        try {

            PreparedStatement consulta = cn.prepareStatement(
                    "delete from partida where id_Partida ='" + idPartida + "'");
            consulta.executeUpdate();

            if (consulta.executeUpdate() > 0) {
                respuesta = true;
            }

            cn.close();

        } catch (SQLException e) {
            System.out.println("Error al eliminar partida: " + e);
        }

        return respuesta;
    }

    public boolean actualizar(Partida objeto, int idPartida) {
        boolean respuesta = false;
        Connection cn = conexion.conexion.conectar();

        try {
            PreparedStatement consulta = cn.prepareStatement("UPDATE partida SET nombres=?, apellido_pat=?, apellido_mat=?, folio=?, id_Libro=?, id_tipoPartida=? WHERE id_Partida = ?");
            consulta.setString(1, objeto.getNombres());
            consulta.setString(2, objeto.getApellido_pat());
            consulta.setString(3, objeto.getApellido_mat());
            consulta.setString(4, objeto.getFolio());
            consulta.setInt(5, objeto.getId_Libro());  // Actualiza el id_Libro
            consulta.setInt(6, objeto.getId_tipoPartida());
            consulta.setInt(7, idPartida);  // Establece el idPartida en la condición WHERE
            if (consulta.executeUpdate() > 0) {
                respuesta = true;
            }
            cn.close();
        } catch (SQLException e) {
            System.out.println("Error al actualizar partida: " + e);
        }

        return respuesta;
    }

    public ResultSet buscarPartidaPorParametros(String parametro, String tipoPartida) {
        ResultSet resultado = null;
        Connection cn = conexion.conexion.conectar();

        try {
            // Dividir el parámetro en nombres, apellido paterno y apellido materno
            String[] parametros = parametro.split("\\s+"); // Dividir por espacios
            String nombres = null;
            String apellidoPat = null;
            String apellidoMat = null;

            if (parametros.length >= 3) {
                nombres = parametros[0];
                apellidoPat = parametros[1];
                apellidoMat = parametros[2];
            } else if (parametros.length == 2) {
                nombres = parametros[0];
                apellidoPat = parametros[1];
            } else if (parametros.length == 1) {
                // Si solo se proporciona un parámetro, asumir que es el apellido paterno o los nombres
                if (parametro.contains(" ")) {
                    String[] nombresYApellido = parametro.split(" ", 2);
                    nombres = nombresYApellido[0];
                    apellidoPat = nombresYApellido[1];
                } else {
                    apellidoPat = parametros[0];
                }
            }

            // Construir la consulta SQL
            StringBuilder consultaSQL = new StringBuilder("SELECT * FROM partida p ");
            consultaSQL.append("JOIN tipopartida t ON p.id_tipoPartida = t.id_tipoPartida ");
            consultaSQL.append("WHERE ");

            boolean condicionAgregada = false;

            if (nombres != null) {
                consultaSQL.append("p.nombres LIKE ?");
                condicionAgregada = true;
            }

            if (apellidoPat != null) {
                if (condicionAgregada) {
                    consultaSQL.append(" AND ");
                }
                consultaSQL.append("p.apellido_pat LIKE ?");
                condicionAgregada = true;
            }

            if (apellidoMat != null) {
                if (condicionAgregada) {
                    consultaSQL.append(" AND ");
                }
                consultaSQL.append("p.apellido_mat LIKE ?");
            }

            if (tipoPartida != null && !tipoPartida.equals("Todos")) {
                if (condicionAgregada) {
                    consultaSQL.append(" AND ");
                }
                consultaSQL.append("t.tipoPartida = ?");
            }

            PreparedStatement consulta = cn.prepareStatement(consultaSQL.toString());

            int index = 1;
            if (nombres != null) {
                consulta.setString(index++, "%" + nombres + "%");
            }
            if (apellidoPat != null) {
                consulta.setString(index++, "%" + apellidoPat + "%");
            }
            if (apellidoMat != null) {
                consulta.setString(index++, "%" + apellidoMat + "%");
            }
            if (tipoPartida != null && !tipoPartida.equals("Todos")) {
                consulta.setString(index, tipoPartida);
            }

            resultado = consulta.executeQuery();
        } catch (SQLException e) {
            System.err.println("Error al buscar la partida por parámetros: " + e);
        }

        return resultado;
    }

}
