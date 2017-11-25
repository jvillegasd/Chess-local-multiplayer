package ajedrez;

import java.awt.Image;

public class Reina extends Ficha {

    public Reina(Image imagen, String nombre, int posX, int posY) {
        super(imagen, nombre, posX, posY);
    }

    //Los movimientos de la reina son la combinacion de los movimientos del alfil y la torre.
    @Override
    public boolean puedeMoverse(Ficha[][] tablero, int posXFinal, int posYFinal) {
        if (posYFinal == posY && posXFinal > posX) { //Derecha.
            return caminoHorizontal(tablero, posXFinal, "derecha");
        }
        if (posYFinal == posY && posX > posXFinal) { //Izquierda.
            return caminoHorizontal(tablero, posXFinal, "izquierda");
        }
        if (posXFinal == posX && posYFinal > posY) { //Arriba si son negras, hacia abajo si son blancas.
            return caminoVertical(tablero, posYFinal, "arriba");
        }
        if (posXFinal == posX && posY > posYFinal) { //Abajo si son negras, hacia arriba si son blancas.
            return caminoVertical(tablero, posYFinal, "abajo");
        }
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
        setFalse();
        if (Blanco) { //Fichas blancas, estas se ubican en la parte baja del tablero.
            if (posYFinal == posY && posXFinal > posX) { //Derecha.
                if (caminoHorizontal(tablero, posXFinal - 1, "derecha") && tablero[posYFinal][posXFinal] != null && !tablero[posYFinal][posXFinal].esBlanco()) {
                    return true;
                }
            }
            if (posYFinal == posY && posX > posXFinal) { //Izquierda.
                if (caminoHorizontal(tablero, posXFinal + 1, "izquierda") && tablero[posYFinal][posXFinal] != null && !tablero[posYFinal][posXFinal].esBlanco()) {
                    return true;
                }
            }
            if (posXFinal == posX && posY > posYFinal) { //Arriba.
                if (caminoVertical(tablero, posYFinal + 1, "abajo") && tablero[posYFinal][posXFinal] != null && !tablero[posYFinal][posXFinal].esBlanco()) {
                    return true;
                }
            }
            if (posXFinal == posX && posYFinal > posY) { //Abajo.
                if (caminoVertical(tablero, posYFinal - 1, "arriba") && tablero[posYFinal][posXFinal] != null && !tablero[posYFinal][posXFinal].esBlanco()) {
                    return true;
                }
            }
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
            if (posYFinal == posY && posXFinal > posX) { //Derecha.
                if (caminoHorizontal(tablero, posXFinal - 1, "derecha") && tablero[posYFinal][posXFinal] != null && tablero[posYFinal][posXFinal].esBlanco()) {
                    return true;
                }
            }
            if (posYFinal == posY && posX > posXFinal) { //Izquierda.
                if (caminoHorizontal(tablero, posXFinal + 1, "izquierda") && tablero[posYFinal][posXFinal] != null && tablero[posYFinal][posXFinal].esBlanco()) {
                    return true;
                }
            }
            if (posXFinal == posX && posYFinal > posY) { //Arriba.
                if (caminoVertical(tablero, posYFinal - 1, "arriba") && tablero[posYFinal][posXFinal] != null && tablero[posYFinal][posXFinal].esBlanco()) {
                    return true;
                }
            }
            if (posXFinal == posX && posY > posYFinal) { //Abajo.
                if (caminoVertical(tablero, posYFinal + 1, "abajo") && tablero[posYFinal][posXFinal] != null && tablero[posYFinal][posXFinal].esBlanco()) {
                    return true;
                }
            }
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

    private boolean caminoHorizontal(Ficha[][] tablero, int posXFinal, String direccion) {
        if (direccion.equals("derecha")) {
            for (int i = posX + 1; i <= posXFinal; i++) {
                movimiento[posY][i] = true;
                if (tablero[posY][i] != null) {
                    setFalse();
                    return false;
                }
            }
        } else if (direccion.equals("izquierda")) {
            for (int i = posX - 1; i >= posXFinal; i--) {
                movimiento[posY][i] = true;
                if (tablero[posY][i] != null) {
                    setFalse();
                    return false;
                }
            }
        }
        return true;
    }

    private boolean caminoVertical(Ficha[][] tablero, int posYFinal, String direccion) {
        if (direccion.equals("arriba")) {
            for (int i = posY + 1; i <= posYFinal; i++) {
                movimiento[i][posX] = true;
                if (tablero[i][posX] != null) {
                    setFalse();
                    return false;
                }
            }
        } else if (direccion.equals("abajo")) {
            for (int i = posY - 1; i >= posYFinal; i--) {
                movimiento[i][posX] = true;
                if (tablero[i][posX] != null) {
                    setFalse();
                    return false;
                }
            }
        }
        return true;
    }

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