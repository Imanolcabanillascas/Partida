/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controlador;

import java.sql.PreparedStatement;
import java.sql.Connection;
import java.sql.SQLException;
import modelo.Libro;
import java.sql.ResultSet;

/**
 *
 * @author LENOVO
 */
public class Ctrl_Libro {

    public boolean guardar(Libro objeto) {
        boolean respuesta = false;
        Connection cn = conexion.conexion.conectar();
        try {
            PreparedStatement consulta = cn.prepareStatement("insert into libro value(?,?)");
            consulta.setInt(1, 0);
            consulta.setString(2, objeto.getAnio());
            if (consulta.executeUpdate() > 0) {
                respuesta = true;
            }
        } catch (SQLException e) {
            System.err.println("Error al conectar");
        }
        return respuesta;
    }

    public boolean existeLibroConAnio(String anio) {
        boolean existe = false;
        Connection cn = conexion.conexion.conectar();

        try {
            String consultaSQL = "SELECT * FROM libro WHERE anio = ?";
            PreparedStatement consulta = cn.prepareStatement(consultaSQL);
            consulta.setString(1, anio);

            ResultSet resultado = consulta.executeQuery();
            existe = resultado.next();

        } catch (SQLException e) {
            System.err.println("Error al consultar la existencia del libro");
        }

        return existe;
    }

    public boolean eliminar(int idLibro) {
        boolean respuesta = false;
        Connection cn = conexion.conexion.conectar();
        try {

            PreparedStatement consulta = cn.prepareStatement(
                    "delete from libro where id_Libro ='" + idLibro + "'");
            consulta.executeUpdate();

            if (consulta.executeUpdate() > 0) {
                respuesta = true;
            }

            cn.close();

        } catch (SQLException e) {
            System.out.println("Error al eliminar libro: " + e);
        }

        return respuesta;
    }

    public boolean actualizar(Libro objeto, int idLibro) {
        boolean respuesta = false;
        Connection cn = conexion.conexion.conectar();
        try {

            PreparedStatement consulta = cn.prepareStatement("update libro set anio=? where id_Libro ='" + idLibro + "'");
            consulta.setString(1, objeto.getAnio());

            if (consulta.executeUpdate() > 0) {
                respuesta = true;
            }

            cn.close();

        } catch (SQLException e) {
            System.out.println("Error al actualizar libro: " + e);
        }

        return respuesta;
    }

    public boolean existePartidaConNum(String n_partida) {
        boolean existe = false;
        Connection cn = conexion.conexion.conectar();

        try {
            String consultaSQL = "SELECT * FROM partida WHERE n_partida = ?";
            PreparedStatement consulta = cn.prepareStatement(consultaSQL);
            consulta.setString(1, n_partida);

            ResultSet resultado = consulta.executeQuery();
            existe = resultado.next();

        } catch (SQLException e) {
            System.err.println("Error al consultar la existencia de la partida por Num de Partida");
        }

        return existe;
    }
}
