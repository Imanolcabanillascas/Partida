/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package modelo;

/**
 *
 * @author LENOVO
 */
public class TipoPartida {
      private int id_tipoPartida;
    private String tipoPartida;

    public int getId_tipoPartida() {
        return id_tipoPartida;
    }

    public void setId_tipoPartida(int id_tipoPartida) {
        this.id_tipoPartida = id_tipoPartida;
    }

    public String getTipoPartida() {
        return tipoPartida;
    }

    public void setTipoPartida(String tipoPartida) {
        this.tipoPartida = tipoPartida;
    }

    public TipoPartida() {
        this.id_tipoPartida = id_tipoPartida;
        this.tipoPartida = tipoPartida;
    }
}
