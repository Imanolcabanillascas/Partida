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
    public boolean guardar(Libro objeto){
        boolean respuesta=false;
        Connection cn= conexion.conexion.conectar();
        try {
            PreparedStatement consulta=cn.prepareStatement("insert into libro value(?,?)");
       consulta.setInt(1,0);
       consulta.setString(2, objeto.getAnio());
       if(consulta.executeUpdate()>0){
           respuesta=true;
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
}
