/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package modelo;

/**
 *
 * @author LENOVO
 */
public class Usuario {

    private int id_Usuario;
    private String nombre;
    private String apellido;
    private String usuario_name;
    private String password;
    private String telefono;


    public int getId_Usuario() {
        return id_Usuario;
    }

    public void setId_Usuario(int id_Usuario) {
        this.id_Usuario = id_Usuario;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public String getUsuario_name() {
        return usuario_name;
    }

    public void setUsuario_name(String usuario_name) {
        this.usuario_name = usuario_name;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

  

   

    public Usuario() {
        this.id_Usuario = 0;
        this.nombre = "";
        this.apellido = "";
        this.usuario_name = "";
        this.password = "";
        this.telefono = "";
    }


}
