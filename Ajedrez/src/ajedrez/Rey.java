package ajedrez;

import java.awt.Image;

public class Rey extends Ficha {

    private Ficha[] ficha = new Ficha[1]; //Variable auxiliar que me contiene una ficha (necesaria en puedeSalvarse()).
    private boolean esPrimerTurno = true;
    private int jaques = -1;

    public Rey(Image imagen, String nombre, int posX, int posY) {
        super(imagen, nombre, posX, posY);
    }

    public int getJaques() {
        return jaques;
    }

    public void setEsPrimerTurno(boolean esPrimerTurno) {
        this.esPrimerTurno = esPrimerTurno;
    }

    public boolean getEsPrimerTurno() {
        return esPrimerTurno;
    }

    @Override
    public boolean puedeMoverse(Ficha[][] tablero, int posXFinal, int posYFinal) {
        if (posXFinal == posX && posY - posYFinal == 1 && tablero[posYFinal][posXFinal] == null && !hayJaque(tablero, posXFinal, posYFinal)) { //Arriba si son blancas, abajo si son negras.
            esPrimerTurno = false;
            return true;
        }
        if (posXFinal == posX && posYFinal - posY == 1 && tablero[posYFinal][posXFinal] == null && !hayJaque(tablero, posXFinal, posYFinal)) { //Abajo si son blancas, arriba si son negras.
            esPrimerTurno = false;
            return true;
        }
        if (posX - posXFinal == 1 && posYFinal == posY && tablero[posYFinal][posXFinal] == null && !hayJaque(tablero, posXFinal, posYFinal)) { //Izquierda.
            esPrimerTurno = false;
            return true;
        }
        if (posXFinal - posX == 1 && posYFinal == posY && tablero[posYFinal][posXFinal] == null && !hayJaque(tablero, posXFinal, posYFinal)) { //Derecha.
            esPrimerTurno = false;
            return true;
        }
        if (posXFinal - posX == 1 && posY - posYFinal == 1 && tablero[posYFinal][posXFinal] == null & !hayJaque(tablero, posXFinal, posYFinal)) { //Diagonal der arriba si son blancas, diagonal der abajo si son negras.
            esPrimerTurno = false;
            return true;
        }
        if (posXFinal - posX == 1 && posYFinal - posY == 1 && tablero[posYFinal][posXFinal] == null & !hayJaque(tablero, posXFinal, posYFinal)) { //Diagonal der abajo si son blancas, diagonal der arriba si son negras.
            esPrimerTurno = false;
            return true;
        }
        if (posX - posXFinal == 1 && posY - posYFinal == 1 && tablero[posYFinal][posXFinal] == null & !hayJaque(tablero, posXFinal, posYFinal)) { //Diagonal izq arriba si son blancas, diagonal izq abajo si son negras.
            esPrimerTurno = false;
            return true;
        }
        if (posX - posXFinal == 1 && posYFinal - posY == 1 && tablero[posYFinal][posXFinal] == null & !hayJaque(tablero, posXFinal, posYFinal)) { //Diagonal izq abajo si son blancas, diagonal izq arriba si son negras.
            esPrimerTurno = false;
            return true;
        }
        return false;
    }

    @Override
    public boolean puedeAtacar(Ficha[][] tablero, int posXFinal, int posYFinal) {
        setFalse();
        if (Blanco) { //Fichas blancas, estas se ubican en la parte baja del tablero.
            if (posXFinal == posX && posY - posYFinal == 1 && tablero[posYFinal][posXFinal] != null && !tablero[posYFinal][posXFinal].esBlanco()) { //Arriba.
                movimiento[posYFinal][posXFinal] = true;
                esPrimerTurno = false;
                return true;
            }
            if (posXFinal == posX && posYFinal - posY == 1 && tablero[posYFinal][posXFinal] != null && !tablero[posYFinal][posXFinal].esBlanco()) { //Abajo.
                movimiento[posYFinal][posXFinal] = true;
                esPrimerTurno = false;
                return true;
            }
            if (posXFinal - posX == 1 && posYFinal == posY && tablero[posYFinal][posXFinal] != null && !tablero[posYFinal][posXFinal].esBlanco()) { //Derecha.
                movimiento[posYFinal][posXFinal] = true;
                esPrimerTurno = false;
                return true;
            }
            if (posX - posXFinal == 1 & posYFinal == posY && tablero[posYFinal][posXFinal] != null && !tablero[posYFinal][posXFinal].esBlanco()) { //Izquierda.
                movimiento[posYFinal][posXFinal] = true;
                esPrimerTurno = false;
                return true;
            }
            if (posX - posXFinal == 1 && posY - posYFinal == 1 && tablero[posYFinal][posXFinal] != null && !tablero[posYFinal][posXFinal].esBlanco()) { //Diagonal derecha arriba. 
                movimiento[posYFinal][posXFinal] = true;
                esPrimerTurno = false;
                return true;
            }
            if (posXFinal - posX == 1 && posY - posYFinal == 1 && tablero[posYFinal][posXFinal] != null && !tablero[posYFinal][posXFinal].esBlanco()) { //Diagonal izquierda arriba.
                movimiento[posYFinal][posXFinal] = true;
                esPrimerTurno = false;
                return true;
            }
            if (posXFinal - posX == 1 && posYFinal - posY == 1 && tablero[posYFinal][posXFinal] != null && !tablero[posYFinal][posXFinal].esBlanco()) { //Diagonal derecha abajo.
                movimiento[posYFinal][posXFinal] = true;
                esPrimerTurno = false;
                return true;
            }
            if (posX - posXFinal == 1 && posYFinal - posY == 1 & tablero[posYFinal][posXFinal] != null && !tablero[posYFinal][posXFinal].esBlanco()) { //Diagonal izquierda abajo.
                movimiento[posYFinal][posXFinal] = true;
                esPrimerTurno = false;
                return true;
            }
        } else { //Fichas negras.
            if (posXFinal == posX && posY - posYFinal == 1 && tablero[posYFinal][posXFinal] != null && tablero[posYFinal][posXFinal].esBlanco()) { //Abajo.
                movimiento[posYFinal][posXFinal] = true;
                esPrimerTurno = false;
                return true;
            }
            if (posXFinal == posX && posYFinal - posY == 1 && tablero[posYFinal][posXFinal] != null && tablero[posYFinal][posXFinal].esBlanco()) { //Arriba.
                movimiento[posYFinal][posXFinal] = true;
                esPrimerTurno = false;
                return true;
            }
            if (posXFinal - posX == 1 && posYFinal == posY && tablero[posYFinal][posXFinal] != null && tablero[posYFinal][posXFinal].esBlanco()) { //Derecha.
                movimiento[posYFinal][posXFinal] = true;
                esPrimerTurno = false;
                return true;
            }
            if (posX - posXFinal == 1 & posYFinal == posY && tablero[posYFinal][posXFinal] != null && tablero[posYFinal][posXFinal].esBlanco()) { //Izquierda.
                movimiento[posYFinal][posXFinal] = true;
                esPrimerTurno = false;
                return true;
            }
            if (posX - posXFinal == 1 && posY - posYFinal == 1 && tablero[posYFinal][posXFinal] != null && tablero[posYFinal][posXFinal].esBlanco()) { //Diagonal derecha abajo. 
                movimiento[posYFinal][posXFinal] = true;
                esPrimerTurno = false;
                return true;
            }
            if (posXFinal - posX == 1 && posY - posYFinal == 1 && tablero[posYFinal][posXFinal] != null && tablero[posYFinal][posXFinal].esBlanco()) { //Diagonal izquierda abajo.
                movimiento[posYFinal][posXFinal] = true;
                esPrimerTurno = false;
                return true;
            }
            if (posXFinal - posX == 1 && posYFinal - posY == 1 && tablero[posYFinal][posXFinal] != null && tablero[posYFinal][posXFinal].esBlanco()) { //Diagonal derecha arriba.
                movimiento[posYFinal][posXFinal] = true;
                esPrimerTurno = false;
                return true;
            }
            if (posX - posXFinal == 1 && posYFinal - posY == 1 & tablero[posYFinal][posXFinal] != null && tablero[posYFinal][posXFinal].esBlanco()) { //Diagonal izquierda arriba.
                movimiento[posYFinal][posXFinal] = true;
                esPrimerTurno = false;
                return true;
            }
        }
        return false;
    }

    public boolean puedeEnroque(Ficha[][] tablero, int posXFinal, int posYFinal) {
        if (Blanco && esPrimerTurno) {
            if (tablero[posYFinal][posXFinal] != null && tablero[posYFinal][posXFinal].esBlanco() && tablero[posYFinal][posXFinal].getNombre().equals("torre")) {
                if (((Torre) tablero[posYFinal][posXFinal]).getEsPrimerTurno() && (tablero[posYFinal][posXFinal].puedeMoverse(tablero, posX - 1, posY) || tablero[posYFinal][posXFinal].puedeMoverse(tablero, posX + 1, posY))) {
                    if (!hayJaque(tablero, posX + 1, posY) && !hayJaque(tablero, posX, posY - 1)) {
                        if (!hayJaque(tablero, posX + 1, posY - 1) && !hayJaque(tablero, posX - 1, posY)) {
                            if (!hayJaque(tablero, posX - 1, posY - 1)) {
                                esPrimerTurno = false;
                                ((Torre) tablero[posYFinal][posXFinal]).setEsPrimerTurno(false);
                                return true;
                            }
                        }
                    }
                }
            }
        } else if (!Blanco && esPrimerTurno) {
            if (tablero[posYFinal][posXFinal] != null && !tablero[posYFinal][posXFinal].esBlanco() && tablero[posYFinal][posXFinal].getNombre().equals("torre")) {
                if (((Torre) tablero[posYFinal][posXFinal]).getEsPrimerTurno() && (tablero[posYFinal][posXFinal].puedeMoverse(tablero, posX - 1, posY) || tablero[posYFinal][posXFinal].puedeMoverse(tablero, posX + 1, posY))) {
                    if (!hayJaque(tablero, posX, posY + 1) && !hayJaque(tablero, posX + 1, posY)) {
                        if (!hayJaque(tablero, posX - 1, posY) && !hayJaque(tablero, posX + 1, posY + 1)) {
                            if (!hayJaque(tablero, posX - 1, posY + 1)) {
                                esPrimerTurno = false;
                                ((Torre) tablero[posYFinal][posXFinal]).setEsPrimerTurno(false);
                                return true;
                            }
                        }
                    }
                }
            }
        }
        return false;
    }

    private boolean hayJaque(Ficha[][] tablero, int posXFinal, int posYFinal) {
        tablero[posYFinal][posXFinal] = this;
        for (int i = 0; i < 8; i++) {
            for (int j = 0; j < 8; j++) {
                if (Blanco) { 
                    if (tablero[i][j] != null && tablero[i][j].puedeAtacar(tablero, posXFinal, posYFinal) && !tablero[i][j].esBlanco()) {
                        tablero[posYFinal][posXFinal] = null;
                        return true;
                    }
                } else {
                    if (tablero[i][j] != null && tablero[i][j].puedeAtacar(tablero, posXFinal, posYFinal) && tablero[i][j].esBlanco()) {
                        tablero[posYFinal][posXFinal] = null;
                        return true;
                    }
                }
                
            }
        }
        return false;
    }

    public boolean hayJaqueMate(Ficha[][] tablero, boolean turnoBlanco, boolean click) {
        if (puedeSalvarse(tablero, turnoBlanco, click)) {
            return false;
        }
        return true;
    }

    private boolean puedeSalvarse(Ficha[][] tablero, boolean turnoBlanco, boolean click) {
        int amenazas = 0;
        for (int i = 0; i < 8; i++) {
            for (int j = 0; j < 8; j++) {
                if (turnoBlanco) { //Fichas blancas.
                    if (tablero[i][j] != null && !tablero[i][j].esBlanco() && tablero[i][j].puedeAtacar(tablero, posX, posY)) { //Buscar fichas enemigas
                        amenazas++;                                                                   //que tengan en jaque al rey.
                        ficha[0] = tablero[i][j];
                    }
                } else if (!turnoBlanco) { //Fichas negras.
                    if (tablero[i][j] != null && tablero[i][j].esBlanco() && tablero[i][j].puedeAtacar(tablero, posX, posY)) {
                        amenazas++;
                        ficha[0] = tablero[i][j];
                    }
                }
            }
        }
        if (amenazas > 1 && !puedeMoverse(tablero, posX + 1, posY) && !puedeMoverse(tablero, posX - 1, posY)) {
            if (!puedeMoverse(tablero, posX, posY + 1) && !puedeMoverse(tablero, posX, posY - 1)) {
                if (!puedeMoverse(tablero, posX + 1, posY - 1) && !puedeMoverse(tablero, posX + 1, posY + 1)) {
                    if (!puedeMoverse(tablero, posX - 1, posY - 1) && !puedeMoverse(tablero, posX - 1, posY + 1)) {
                        if (!puedeMoverse(tablero, posX + 1, posY) && !puedeMoverse(tablero, posX - 1, posY)) {
                            return false;
                        }
                    }
                }
            }
        }
        if (amenazas == 1 && !salvadorTentativo(tablero, ficha[0], click)) {
            return false;
        }
        return true;
    }

    private boolean salvadorTentativo(Ficha[][] tablero, Ficha fichaEnemiga, boolean click) { //Sirve para buscar alguna ficha aliada que le
        for (int i = 0; i < 8; i++) {                                         //quite el jaque al rey (si es posible).
            for (int j = 0; j < 8; j++) {
                if (Blanco) { //Fichas blancas.
                    if (tablero[i][j] != null && tablero[i][j].esBlanco() && tablero[i][j] != this && !fichaEnemiga.getNombre().equals("caballo")) {
                        if (puedeLlegar(tablero, tablero[i][j], fichaEnemiga.getMovimiento())) {
                            if (jaques < 2 && !click) {
                                jaques++;
                            }
                            return true;
                        }
                    }
                    if (tablero[i][j] != null && tablero[i][j].esBlanco() && tablero[i][j] != this && fichaEnemiga.getNombre().equals("caballo")) {
                        if (casoCaballo(fichaEnemiga, tablero[i][j], tablero)) {
                            if (jaques < 2 && !click) {
                                jaques++;
                            }
                            return true;
                        }
                    }
                } else { //Fichas negras.
                    if (tablero[i][j] != null && !tablero[i][j].esBlanco() && tablero[i][j] != this && !fichaEnemiga.getNombre().equals("caballo")) {
                        if (puedeLlegar(tablero, tablero[i][j], fichaEnemiga.getMovimiento())) {
                            if (jaques < 2 && !click) {
                                jaques++;
                            }
                            return true;
                        }
                    }
                    if (tablero[i][j] != null && !tablero[i][j].esBlanco() && tablero[i][j] != this && fichaEnemiga.getNombre().equals("caballo")) {
                        if (casoCaballo(fichaEnemiga, tablero[i][j], tablero)) {
                            if (jaques < 2 && !click) {
                                jaques++;
                            }
                            return true;
                        }
                    }
                }
            }
        }
        return false;
    }

    private boolean puedeLlegar(Ficha[][] tablero, Ficha ficha, boolean[][] movimiento) { //Verifica que la ficha si sea un salvador
        for (int i = 0; i < 8; i++) {                                                     //(si puede bloquear el paso de la ficha enemiga).
            for (int j = 0; j < 8; j++) {
                if (movimiento[i][j] && ficha.puedeMoverse(tablero, j, i)) {
                    return true;
                }
            }
        }
        return false;
    }

    //El caballo es un caso especial ya que el salta directo a un puesto, y como se evalua un jaque mate, el caballo
    //debe de poder saltar directamente al rey, la unica forma de evitarlo es que alguna ficha aliada pueda matarla.
    private boolean casoCaballo(Ficha caballoEnemigo, Ficha fichaSalvadora, Ficha[][] tablero) {
        return fichaSalvadora.puedeAtacar(tablero, caballoEnemigo.getPosX(), caballoEnemigo.getPosY());
    }
}
