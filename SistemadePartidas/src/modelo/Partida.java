/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package modelo;


import java.util.Date;

/**
 *
 * @author LENOVO
 */
public class Partida {

    private int id_Partida;
    private String n_partida;
    private String nombres;
    private String apellido_pat;
    private String apellido_mat;
    private String folio;
    private int id_Libro;
    private int id_tipoPartida;
    private Date fecha_partida;

    public int getId_Partida() {
        return id_Partida;
    }

    public void setId_Partida(int id_Partida) {
        this.id_Partida = id_Partida;
    }

    public String getN_partida() {
        return n_partida;
    }

    public void setN_partida(String n_partida) {
        this.n_partida = n_partida;
    }

    public String getNombres() {
        return nombres;
    }

    public void setNombres(String nombres) {
        this.nombres = nombres;
    }

    public String getApellido_pat() {
        return apellido_pat;
    }

    public void setApellido_pat(String apellido_pat) {
        this.apellido_pat = apellido_pat;
    }

    public String getApellido_mat() {
        return apellido_mat;
    }

    public void setApellido_mat(String apellido_mat) {
        this.apellido_mat = apellido_mat;
    }

    public String getFolio() {
        return folio;
    }

    public void setFolio(String folio) {
        this.folio = folio;
    }

    public int getId_Libro() {
        return id_Libro;
    }

    public void setId_Libro(int id_Libro) {
        this.id_Libro = id_Libro;
    }

    public int getId_tipoPartida() {
        return id_tipoPartida;
    }

    public void setId_tipoPartida(int id_tipoPartida) {
        this.id_tipoPartida = id_tipoPartida;
    }

    public Date getFecha_partida() {
        return fecha_partida;
    }

    public void setFecha_partida(Date fecha_partida) {
        this.fecha_partida = fecha_partida;
    }

    public Partida() {
        this.id_Partida = id_Partida;
        this.n_partida = n_partida;
        this.nombres = nombres;
        this.apellido_pat = apellido_pat;
        this.apellido_mat = apellido_mat;
        this.folio = folio;
        this.id_Libro = id_Libro;
        this.id_tipoPartida = id_tipoPartida;
        this.fecha_partida = fecha_partida;
    }

}
