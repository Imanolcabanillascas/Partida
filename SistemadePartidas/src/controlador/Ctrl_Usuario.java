/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controlador;

import modelo.Usuario;
import java.sql.Connection;
import conexion.conexion;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javax.swing.JOptionPane;

/**
 *
 * @author LENOVO
 */
public class Ctrl_Usuario {

    public boolean loginUser(Usuario objeto) {
        boolean respuesta = false;
        Connection cn = conexion.conectar();
        String sql = "select usuario_name, password from usuario where usuario_name='" + objeto.getUsuario_name() + "' and password = '" + objeto.getPassword() + "';";
        Statement st;
        try {
            st = cn.createStatement();
            ResultSet rs = st.executeQuery(sql);
            while (rs.next()) {
                respuesta = true;
            }
        } catch (SQLException e) {
            System.out.println("Error al iniciar sesión");
            JOptionPane.showMessageDialog(null, "Error al iniciar sesion");
        }
        return respuesta;
    }

    public boolean actualizar(Usuario objeto, int idUsuario) {
        boolean respuesta = false;
        Connection cn = conexion.conectar();

        try {
            PreparedStatement consulta = cn.prepareStatement("UPDATE usuario SET nombre=?, apellido=?, usuario_name=?, password=?,telefono=? WHERE id_Usuario = ?");
            consulta.setString(1, objeto.getNombre());
            consulta.setString(2, objeto.getApellido());
            consulta.setString(3, objeto.getUsuario_name());
            consulta.setString(4, objeto.getPassword());
            consulta.setString(5, objeto.getTelefono());
            consulta.setInt(6, idUsuario); 
            if (consulta.executeUpdate() > 0) {
                respuesta = true;
            }
            cn.close();
        } catch (SQLException e) {
            System.out.println("Error al actualizar partida: " + e);
        }

        return respuesta;
    }
}
