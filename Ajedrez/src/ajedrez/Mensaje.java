/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ajedrez;

import java.io.Serializable;

/**
 *
 * @author Usuario
 */
public class Mensaje implements Serializable {
    private static final long serialVersionUID = 5950169519310163575L;
    private String chat;
    private boolean turno;
    private String movimiento;
    private Ficha[][] tablero;
    private Ficha[] reyes;

    public Mensaje(String chat, boolean turno, String movimiento, Ficha[][] tablero, Ficha[] reyes) {
        this.chat = chat;
        this.turno = turno;
        this.movimiento = movimiento;
        this.tablero = tablero;
        this.reyes = reyes;
    }

    public String getChat() {
        return chat;
    }

    public void setChat(String chat) {
        this.chat = chat;
    }

    public boolean isTurno() {
        return turno;
    }

    public void setTurno(boolean turno) {
        this.turno = turno;
    }

    public String getMovimiento() {
        return movimiento;
    }

    public void setMovimiento(String movimiento) {
        this.movimiento = movimiento;
    }

    public Ficha[][] getTablero() {
        return tablero;
    }

    public void setTablero(Ficha[][] tablero) {
        this.tablero = tablero;
    }

    public Ficha[] getReyes() {
        return reyes;
    }

    public void setReyes(Ficha[] reyes) {
        this.reyes = reyes;
    }
    
    
}
