/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controlador;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

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
            PreparedStatement consulta = cn.prepareStatement("insert into partida values(?,?,?,?,?,?,?)");
            consulta.setInt(1, 0);
            consulta.setString(2, objeto.getDni());
            consulta.setString(3, objeto.getNombres());
            consulta.setString(4, objeto.getApellido_pat());
            consulta.setString(5, objeto.getApellido_mat());
            consulta.setString(6, objeto.getFolio());
            consulta.setInt(7, objeto.getId_Libro());
            if (consulta.executeUpdate() > 0) {
                respuesta = true;
            }
        } catch (SQLException e) {
            System.err.println("Error al conectar");
        }
        return respuesta;
    }

    public boolean existePartidaDni(String dni) {
        boolean existe = false;
        Connection cn = conexion.conexion.conectar();

        try {
            String consultaSQL = "SELECT * FROM partida WHERE dni = ?";
            PreparedStatement consulta = cn.prepareStatement(consultaSQL);
            consulta.setString(1, dni);
            ResultSet resultado = consulta.executeQuery();
            existe = resultado.next();
        } catch (SQLException e) {
            System.err.println("Error al consultar la existencia del dni");
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

            PreparedStatement consulta = cn.prepareStatement("update partida set dni=?,nombres=?,apellido_pat=?,apellido_mat=?,folio=?,id_Libro=? where id_Partida ='" + idPartida + "'");
            consulta.setString(1, objeto.getDni());
            consulta.setString(2, objeto.getNombres());
            consulta.setString(3, objeto.getApellido_pat());
            consulta.setString(4, objeto.getApellido_mat());
            consulta.setString(5, objeto.getFolio());
            consulta.setInt(6, objeto.getId_Libro());

            if (consulta.executeUpdate() > 0) {
                respuesta = true;
            }

            cn.close();

        } catch (SQLException e) {
            System.out.println("Error al actualizar libro: " + e);
        }

        return respuesta;
    }
}
