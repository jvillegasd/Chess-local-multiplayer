package ajedrez;

import java.awt.Image;

public class Caballo extends Ficha {

    public Caballo(Image imagen, String nombre, int posX, int posY) {
        super(imagen, nombre, posX, posY);
    }

    @Override
    public boolean puedeMoverse(Ficha[][] tablero, int posXFinal, int posYFinal) {
        if (posX - posXFinal == 1 && posY - posYFinal == 2 && tablero[posYFinal][posXFinal] == null) { //Arriba e izq si son blancas, abajo e izq si son negras.
            return true;
        }
        if (posXFinal - posX == 1 && posY - posYFinal == 2 && tablero[posYFinal][posXFinal] == null) { //Arriba y der si son blancas, abajo y der si son negras.
            return true;
        }
        if (posXFinal - posX == 2 && posY - posYFinal == 1 && tablero[posYFinal][posXFinal] == null) { //Derecha y arriba si son blancas, derecha y abajo si son negras.
            return true;
        }
        if (posXFinal - posX == 2 && posYFinal - posY == 1 && tablero[posYFinal][posXFinal] == null) { //Derecha y abajo si son blancas, derecha y arriba si son negras.
            return true;
        }
        if (posX - posXFinal == 1 && posYFinal - posY == 2 && tablero[posYFinal][posXFinal] == null) { //Abajo e izquierda si son blancas, arriba e izq si son negras.
            return true;
        }
        if (posXFinal - posX == 1 && posYFinal - posY == 2 && tablero[posYFinal][posXFinal] == null) { //Abajo y derecha si son blancas, arriba y der si son negras.
            return true;
        }
        if (posX - posXFinal == 2 && posY - posYFinal == 1 && tablero[posYFinal][posXFinal] == null) { //Izquierda y arriba si son blancas, izquerda y abajo si son negras.
            return true;
        }
        if (posX - posXFinal == 2 && posYFinal - posY == 1 && tablero[posYFinal][posXFinal] == null) { //Izquierda y abajo si son blancas, izquierda y arriba si son negras.
            return true;
        }
        return false;
    }

    @Override
    public boolean puedeAtacar(Ficha[][] tablero, int posXFinal, int posYFinal) {
        setFalse();
        if (Blanco) { //Fichas blancas, estas se ubican en la parte baja del tablero.
            if (posX - posXFinal == 1 && posY - posYFinal == 2 && tablero[posYFinal][posXFinal] != null && !tablero[posYFinal][posXFinal].esBlanco()) { //Arriba e izquierda.
                movimiento[posYFinal][posXFinal] = true;
                return true;
            }
            if (posXFinal - posX == 1 && posY - posYFinal == 2 && tablero[posYFinal][posXFinal] != null && !tablero[posYFinal][posXFinal].esBlanco()) { //Arriba y derecha.
                movimiento[posYFinal][posXFinal] = true;
                return true;
            }
            if (posXFinal - posX == 2 && posY - posYFinal == 1 && tablero[posYFinal][posXFinal] != null && !tablero[posYFinal][posXFinal].esBlanco()) { //Derecha y arriba.
                movimiento[posYFinal][posXFinal] = true;
                return true;
            }
            if (posXFinal - posX == 2 && posYFinal - posY == 1 && tablero[posYFinal][posXFinal] != null && !tablero[posYFinal][posXFinal].esBlanco()) { //Derecha y abajo.
                movimiento[posYFinal][posXFinal] = true;
                return true;
            }
            if (posX - posXFinal == 1 && posYFinal - posY == 2 && tablero[posYFinal][posXFinal] != null && !tablero[posYFinal][posXFinal].esBlanco()) { //Abajo e izquierda.
                movimiento[posYFinal][posXFinal] = true;
                return true;
            }
            if (posXFinal - posX == 1 && posYFinal - posY == 2 && tablero[posYFinal][posXFinal] != null && !tablero[posYFinal][posXFinal].esBlanco()) { //Abajo y derecha.
                movimiento[posYFinal][posXFinal] = true;
                return true;
            }
            if (posX - posXFinal == 2 && posY - posYFinal == 1 && tablero[posYFinal][posXFinal] != null && !tablero[posYFinal][posXFinal].esBlanco()) { //Izquierda y arriba.
                movimiento[posYFinal][posXFinal] = true;
                return true;
            }
            if (posX - posXFinal == 2 && posYFinal - posY == 1 && tablero[posYFinal][posXFinal] != null && !tablero[posYFinal][posXFinal].esBlanco()) { //Izquierda y abajo.
                movimiento[posYFinal][posXFinal] = true;
                return true;
            }
        } else { //Fichas negras
            if (posX - posXFinal == 1 && posY - posYFinal == 2 && tablero[posYFinal][posXFinal] != null && tablero[posYFinal][posXFinal].esBlanco()) { //Abajo e izquierda.
                movimiento[posYFinal][posXFinal] = true;
                return true;
            }
            if (posXFinal - posX == 1 && posY - posYFinal == 2 && tablero[posYFinal][posXFinal] != null && tablero[posYFinal][posXFinal].esBlanco()) { //Abajo y derecha.
                movimiento[posYFinal][posXFinal] = true;
                return true;
            }
            if (posXFinal - posX == 2 && posY - posYFinal == 1 && tablero[posYFinal][posXFinal] != null && tablero[posYFinal][posXFinal].esBlanco()) { //Derecha y abajo.
                movimiento[posYFinal][posXFinal] = true;
                return true;
            }
            if (posXFinal - posX == 2 && posYFinal - posY == 1 && tablero[posYFinal][posXFinal] != null && tablero[posYFinal][posXFinal].esBlanco()) { //Derecha y arriba.
                movimiento[posYFinal][posXFinal] = true;
                return true;
            }
            if (posX - posXFinal == 1 && posYFinal - posY == 2 && tablero[posYFinal][posXFinal] != null && tablero[posYFinal][posXFinal].esBlanco()) { //Arriba e izquierda.
                movimiento[posYFinal][posXFinal] = true;
                return true;
            }
            if (posXFinal - posX == 1 && posYFinal - posY == 2 && tablero[posYFinal][posXFinal] != null && tablero[posYFinal][posXFinal].esBlanco()) { //Arriba y derecha.
                movimiento[posYFinal][posXFinal] = true;
                return true;
            }
            if (posX - posXFinal == 2 && posY - posYFinal == 1 && tablero[posYFinal][posXFinal] != null && tablero[posYFinal][posXFinal].esBlanco()) { //Izquerda y abajo.
                movimiento[posYFinal][posXFinal] = true;
                return true;
            }
            if (posX - posXFinal == 2 && posYFinal - posY == 1 && tablero[posYFinal][posXFinal] != null && tablero[posYFinal][posXFinal].esBlanco()) { //Izquierda y arriba.
                movimiento[posYFinal][posXFinal] = true;
            }
        }
        return false;
    }
}