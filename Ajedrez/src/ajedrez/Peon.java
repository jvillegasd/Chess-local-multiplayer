package ajedrez;

import java.awt.Image;

public class Peon extends Ficha {

    private boolean esPrimerTurno = true;
    private int turnos = 0; //Me ayuda para saber si un peon enemigo puede matarlo al paso.

    public Peon(Image imagen, String nombre, int posX, int posY) {
        super(imagen ,nombre, posX, posY);
    }
    
    public int getTurnos(){
        return turnos;
    }

    public boolean getEsPrimerTurno() {
        return esPrimerTurno;
    }

    public void setEsPrimerTurno(boolean turno) {
        esPrimerTurno = turno;
    }

    @Override
    public boolean puedeMoverse(Ficha[][] tablero, int posXFinal, int posYFinal) {
        if (Blanco) { //Fichas blancas, estas se ubican en la parte baja del tablero.
            if (esPrimerTurno) {
                if (posX == posXFinal && posY - posYFinal == 2 && tablero[posYFinal][posXFinal] == null) {
                    esPrimerTurno = false;
                    turnos++;
                    return true;
                }
            }
            if (posX == posXFinal && posY - posYFinal == 1 && posY - 1 >= 0 && tablero[posYFinal][posXFinal] == null) {
                esPrimerTurno = false;
                if (turnos == 1) {
                    turnos++;
                }
                return true;
            }
        } else { //Fichas negras.
            if (esPrimerTurno) {
                if (posX == posXFinal && posYFinal - posY == 2 && tablero[posYFinal][posXFinal] == null) {
                    esPrimerTurno = false;
                    turnos++;
                    return true;
                }
            }
            if (posX == posXFinal && posYFinal - posY == 1 && posY + 1 < 8 && tablero[posYFinal][posXFinal] == null) {
                esPrimerTurno = false;
                if (turnos == 1) {
                    turnos++;
                }
                return true;
            }
        }
        return false;
    }

    @Override
    public boolean puedeAtacar(Ficha[][] tablero, int posXFinal, int posYFinal) {
        setFalse();
        if (Blanco) { //Fichas blancas, estas se ubican en la parte baja del tablero.
            if (posXFinal - posX == 1 && posY - posYFinal == 1 && tablero[posYFinal][posXFinal] != null && !tablero[posYFinal][posXFinal].esBlanco()) { //Diagonal derecha.
                movimiento[posYFinal][posXFinal] = true;
                esPrimerTurno = false;
                return true;
            }
            if (posX - posXFinal == 1 && posY - posYFinal == 1 && tablero[posYFinal][posXFinal] != null && !tablero[posYFinal][posXFinal].esBlanco()) { //Diagonal izquierda.
                movimiento[posYFinal][posXFinal] = true;
                esPrimerTurno = false;
                return true;
            }
            if (posY == 3) {
                return puedeAtacarAlPaso(tablero, posXFinal, posYFinal);
            }
        } else { //Fichas negras.
            if (posXFinal - posX == 1 && posYFinal - posY == 1 && tablero[posYFinal][posXFinal] != null && tablero[posYFinal][posXFinal].esBlanco()) { //Diagonal derecha.
                movimiento[posYFinal][posXFinal] = true;
                esPrimerTurno = false;
                return true;
            }
            if (posX - posXFinal == 1 && posYFinal - posY == 1 && tablero[posYFinal][posXFinal] != null && tablero[posYFinal][posXFinal].esBlanco()) { //Diagonal izquierda.
                movimiento[posYFinal][posXFinal] = true;
                esPrimerTurno = false;
                return true;
            }
            if (posY == 4) {
                return puedeAtacarAlPaso(tablero, posXFinal, posYFinal);
            }
        }
        return false;
    }
    
    private boolean puedeAtacarAlPaso(Ficha[][] tablero, int posXFinal, int posYFinal){
        if (Blanco) { //Fichas blancas.
            if (posXFinal - posX == 1 && posY - posYFinal == 1 && posX + 1 < 8 && tablero[posYFinal][posXFinal] == null && tablero[posY][posX + 1] != null && !tablero[posY][posX + 1].esBlanco() && tablero[posY][posX + 1].getNombre().equals("peon") && ((Peon) tablero[posY][posX + 1]).getTurnos() == 1) {
                return true;
            }
            if (posX - posXFinal == 1 && posY - posYFinal == 1 && posX - 1 >= 0 && tablero[posYFinal][posXFinal] == null && tablero[posY][posX - 1] != null && !tablero[posY][posX - 1].esBlanco() && tablero[posY][posX - 1].getNombre().equals("peon") && ((Peon) tablero[posY][posX - 1]).getTurnos() == 1) {
                return true;
            }
        }else{ //Fichas negras.
            if (posXFinal - posX == 1 && posYFinal - posY == 1 && posX + 1 < 8 && tablero[posYFinal][posXFinal] == null && tablero[posY][posX + 1] != null && tablero[posY][posX + 1].esBlanco() && tablero[posY][posX + 1].getNombre().equals("peon") && ((Peon) tablero[posY][posX + 1]).getTurnos() == 1) {
                return true;
            }
            if (posX - posXFinal == 1 && posYFinal - posY == 1 && posX - 1 >= 0 && tablero[posYFinal][posXFinal] == null && tablero[posY][posX - 1] != null && tablero[posY][posX - 1].esBlanco() && tablero[posY][posX - 1].getNombre().equals("peon") && ((Peon) tablero[posY][posX - 1]).getTurnos() == 1) {
                return true;
            }
        }
        return false;
    }
    
    public boolean puedeCoronarse(){
        return false;
    }
}