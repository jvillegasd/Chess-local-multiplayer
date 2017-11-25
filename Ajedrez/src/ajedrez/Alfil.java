package ajedrez;

import java.awt.Image;

public class Alfil extends Ficha {

    public Alfil(Image imagen, String nombre, int posX, int posY) {
        super(imagen, nombre, posX, posY);
    }

    @Override
    public boolean puedeMoverse(Ficha[][] tablero, int posXFinal, int posYFinal) {
        if (posXFinal - posX == posY - posYFinal && posXFinal > posX && tablero[posYFinal][posXFinal] == null && diagonalDerecha(tablero, posYFinal, "arriba")) { //Diagonal der y arriba si son blancas, diagonal der y abajo si son negras.
            return true;
        }
        if (posXFinal - posX == posYFinal - posY && posXFinal > posX && tablero[posYFinal][posXFinal] == null && diagonalDerecha(tablero, posYFinal, "abajo")) { //Diagonal der y abajo si son blancas, diagonal der y arriba si son negras.
            return true;
        }
        if (posX - posXFinal == posY - posYFinal && posX > posXFinal && tablero[posYFinal][posXFinal] == null && diagonalIzquierda(tablero, posYFinal, "arriba")) { //Diagonal izq y arriba si son blancas, diagonal izq y abajo si son negras.
            return true;
        }
        if (posX - posXFinal == posYFinal - posY && posX > posXFinal && tablero[posYFinal][posXFinal] == null && diagonalIzquierda(tablero, posYFinal, "abajo")) { //Diagonal izq y abajo si son blancas, diagonal izq y arriba si son negras.
            return true;
        }
        return false;
    }

    @Override
    public boolean puedeAtacar(Ficha[][] tablero, int posXFinal, int posYFinal) {
        if (Blanco) { //Fichas blancas, estas se ubican en la parte baja del tablero.
            if (posXFinal - posX == posY - posYFinal && posXFinal > posX && tablero[posYFinal][posXFinal] != null && diagonalDerecha(tablero, posYFinal + 1, "arriba") && !tablero[posYFinal][posXFinal].esBlanco()) { //Diagonal der y arriba.
                return true;
            }
            if (posXFinal - posX == posYFinal - posY && posXFinal > posX && tablero[posYFinal][posXFinal] != null && diagonalDerecha(tablero, posYFinal - 1, "abajo") && !tablero[posYFinal][posXFinal].esBlanco()) { //Diagonal der y abajo.
                return true;
            }
            if (posX - posXFinal == posY - posYFinal && posX > posXFinal && tablero[posYFinal][posXFinal] != null && diagonalIzquierda(tablero, posYFinal + 1, "arriba") && !tablero[posYFinal][posXFinal].esBlanco()) { //Diagonal izq y arriba.
                return true;
            }
            if (posX - posXFinal == posYFinal - posY && posX > posXFinal && tablero[posYFinal][posXFinal] != null && diagonalIzquierda(tablero, posYFinal - 1, "abajo") && !tablero[posYFinal][posXFinal].esBlanco()) { //Diagonal izq y abajo.
                return true;
            }
        } else { //Fichas negras.
            if (posXFinal - posX == posY - posYFinal && posXFinal > posX && tablero[posYFinal][posXFinal] != null && diagonalDerecha(tablero, posYFinal + 1, "arriba") && tablero[posYFinal][posXFinal].esBlanco()) { //Diagonal der y abajo.
                return true;
            }
            if (posXFinal - posX == posYFinal - posY && posXFinal > posX && tablero[posYFinal][posXFinal] != null && diagonalDerecha(tablero, posYFinal - 1, "abajo") && tablero[posYFinal][posXFinal].esBlanco()) { //Diagonal der y arriba.
                return true;
            }
            if (posX - posXFinal == posY - posYFinal && posX > posXFinal && tablero[posYFinal][posXFinal] != null && diagonalIzquierda(tablero, posYFinal + 1, "arriba") && tablero[posYFinal][posXFinal].esBlanco()) { //Diagonal izq y abajo.
                return true;
            }
            if (posX - posXFinal == posYFinal - posY && posX > posXFinal && tablero[posYFinal][posXFinal] != null && diagonalIzquierda(tablero, posYFinal - 1, "abajo") && tablero[posYFinal][posXFinal].esBlanco()) { //Diagonal izq y arriba.
                return true;
            }
        }
        return false;
    }

    //Las diagonales de los alfiles y la reina siempre forman triangulos rectangulos con los catetos de igual magnitud.
    private boolean diagonalDerecha(Ficha[][] tablero, int posYFinal, String direccion) {
        if (direccion.equals("arriba")) {
            for (int i = posY - 1; i >= posYFinal; i--) {
                movimiento[i][posX + (posY - i)] = true;
                if (tablero[i][posX + (posY - i)] != null) {
                    setFalse();
                    return false;
                }
            }
        } else if (direccion.equals("abajo")) {
            for (int i = posY + 1; i <= posYFinal; i++) {
                movimiento[i][posX + (i - posY)] = true;
                if (tablero[i][posX + (i - posY)] != null) {
                    setFalse();
                    return false;
                }
            }
        }
        return true;
    }

    private boolean diagonalIzquierda(Ficha[][] tablero, int posYFinal, String direccion) {
        if (direccion.equals("arriba")) {
            for (int i = posY - 1; i >= posYFinal; i--) {
                movimiento[i][posX - (posY - i)] = true;
                if (tablero[i][posX - (posY - i)] != null) {
                    setFalse();
                    return false;
                }
            }
        } else if (direccion.equals("abajo")) {
            for (int i = posY + 1; i <= posYFinal; i++) {
                movimiento[i][posX - (i - posY)] = true;
                if (tablero[i][posX - (i - posY)] != null) {
                    setFalse();
                    return false;
                }
            }
        }
        return true;
    }
}