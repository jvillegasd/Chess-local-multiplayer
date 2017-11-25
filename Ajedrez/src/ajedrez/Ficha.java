package ajedrez;

import java.awt.Image;

public abstract class Ficha {

    protected Image imagen;
    protected String nombre;
    protected boolean Blanco;
    protected int posX, posY;
    protected boolean[][] movimiento = new boolean[8][8]; //Movimiento de ataque de una ficha

    public Ficha(Image imagen, String nombre, int posX, int posY) {
        this.imagen = imagen;
        this.nombre = nombre;
        this.posX = posX;
        this.posY = posY;
    }

    public void setImagen(Image imagen) {
        this.imagen = imagen;
    }
    
    public Image getImagen(){
        return imagen;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getPosX() {
        return posX;
    }

    public void setPosX(int posX) {
        this.posX = posX;
    }

    public int getPosY() {
        return posY;
    }

    public void setPosY(int posY) {
        this.posY = posY;
    }

    public boolean esBlanco() {
        return Blanco;
    }

    public void setBlanco(boolean Blanco) {
        this.Blanco = Blanco;
    }

    public boolean[][] getMovimiento() {
        return movimiento;
    }

    public boolean puedeMoverse(Ficha[][] tablero, int posXFinal, int posYFinal) {
        return false;
    }

    public boolean puedeAtacar(Ficha[][] tablero, int posXFinal, int posYFinal) {
        return false;
    }

    protected void setFalse() { //Resetear la matriz de movimiento.
        for (int i = 0; i < 8; i++) {
            for (int j = 0; j < 8; j++) {
                movimiento[i][j] = false;
            }
        }
    }
}
