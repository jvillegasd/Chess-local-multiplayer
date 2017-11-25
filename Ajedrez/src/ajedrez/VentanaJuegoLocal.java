package ajedrez;

import java.awt.Color;
import java.awt.GridLayout;
import java.awt.Image;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;
import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

public class VentanaJuegoLocal extends javax.swing.JFrame  {

    JLabel[][] tableroVisual = new JLabel[8][8];
    JPanel tableroPanel = new JPanel();
    
    Ficha[][] tablero = new Ficha[8][8];
    Ficha[] reyes = new Ficha[2];
    private int posX = 0, posY = 0; //Posiciones en (X,Y) de la ficha tocada por el usuario
    public boolean turnoBlanco = true, clickFicha = false;
    private Ficha[] fichaClickeada = new Ficha[1]; //Ficha en movimiento
    private JLabel labelClickeado = null; //Label de la ficha en movimiento

    public VentanaJuegoLocal() {
        initComponents();
        this.setTitle("Ajedrez - Partida en curso");
        this.setResizable(false);
        this.setSize(308, 330);
        this.setLocationRelativeTo(null);
        try {
            generarTablero();
        } catch (IOException e) {
        };
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 400, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 300, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void generarTablero() throws IOException {
        tableroPanel.setLayout(new GridLayout(8, 8)); //El GridLayout me garantiza de que todo los espacios son
        tableroPanel.setBounds(0, 0, 300, 300);      //del mismo tamaño y facilita la creacion del tablero.
        tableroPanel.setBorder(BorderFactory.createLineBorder(Color.BLACK)); //Aplicar un borde al JPanel.
        BufferedImage imagenO = ImageIO.read(new File("fichas.png")); //Abro con BufferedImage para aprovechar un metodo.
        for (int i = 0; i < 8; i++) {
            for (int j = 0; j < 8; j++) {
                tablero[i][j] = null;
                tableroVisual[i][j] = new JLabel(); //Crear el JLabel en esa posicion de la matriz.
                tableroPanel.add(tableroVisual[i][j]); //Agregarlo al panel.
                tableroVisual[i][j].setOpaque(true);
                tableroVisual[i][j].addMouseListener(new MouseListener() { //Asignarle un MouseListener al JLabel.
                    @Override
                    public void mouseClicked(MouseEvent e) {
                    }

                    @Override
                    public void mousePressed(MouseEvent e) {
                    }

                    @Override
                    public void mouseReleased(MouseEvent e) {
                        for (int k = 0; k < 8; k++) { //Cuando el JLabel es clickeado se busca en la matriz
                            for (int l = 0; l < 8; l++) { //para encontrar su posicion en ella.
                                if (tableroVisual[k][l] == e.getSource()) { //Con e.getSource() obtengo el objeto (de GUI/Palette) clickeado.
                                    posX = l;
                                    posY = k;
                                    moverFicha(tablero[k][l], tableroVisual[k][l]);
                                }
                            }
                        }
                    }

                    @Override
                    public void mouseEntered(MouseEvent e) {
                    }

                    @Override
                    public void mouseExited(MouseEvent e) {
                    }
                });
                if (i % 2 == 0) { //Pintar el tablero.
                    if (j % 2 == 0) {
                        tableroVisual[i][j].setBackground(Color.WHITE);
                    } else {
                        tableroVisual[i][j].setBackground(Color.BLACK);
                    }
                } else {
                    if (j % 2 != 0) {
                        tableroVisual[i][j].setBackground(Color.WHITE);
                    } else {
                        tableroVisual[i][j].setBackground(Color.BLACK);
                    }
                }
                if (i == 1) {
                    Image imagen = imagenO.getSubimage(323, 1, 60, 60); //<--Este metodo devuelve una parte de la img.
                    imagen = imagen.getScaledInstance(38, 38, Image.SCALE_SMOOTH); //Reescalar la imagen obtenida.
                    tableroVisual[i][j].setIcon(new ImageIcon(imagen));
                    tablero[i][j] = new Peon(imagen, "peon", i, j);
                    tablero[i][j].setBlanco(false);
                    tablero[i][j].setPosX(j);
                    tablero[i][j].setPosY(i);
                }
                if (i == 6) {
                    Image imagen = imagenO.getSubimage(323, 65, 60, 60); //<--Este metodo devuelve una parte de la img.
                    imagen = imagen.getScaledInstance(38, 38, Image.SCALE_SMOOTH); //Reescalar la imagen obtenida.
                    tableroVisual[i][j].setIcon(new ImageIcon(imagen));
                    tablero[i][j] = new Peon(imagen, "peon", i, j);
                    tablero[i][j].setBlanco(true);
                    tablero[i][j].setPosX(j);
                    tablero[i][j].setPosY(i);
                }
                if (i == 0) {
                    if (j == 0 || j == 7) {
                        Image imagen = imagenO.getSubimage(130, 1, 60, 60); //<--Este metodo devuelve una parte de la img.
                        imagen = imagen.getScaledInstance(38, 38, Image.SCALE_SMOOTH); //Reescalar la imagen obtenida.
                        tableroVisual[i][j].setIcon(new ImageIcon(imagen));
                        tablero[i][j] = new Torre(imagen, "torre", i, j);
                        tablero[i][j].setBlanco(false);
                        tablero[i][j].setPosX(j);
                        tablero[i][j].setPosY(i);
                    }
                    if (j == 1 || j == 6) {
                        Image imagen = imagenO.getSubimage(195, 1, 60, 60); //<--Este metodo devuelve una parte de la img.
                        imagen = imagen.getScaledInstance(38, 38, Image.SCALE_SMOOTH); //Reescalar la imagen obtenida.
                        tableroVisual[i][j].setIcon(new ImageIcon(imagen));
                        tablero[i][j] = new Caballo(imagen, "caballo", i, j);
                        tablero[i][j].setBlanco(false);
                        tablero[i][j].setPosX(j);
                        tablero[i][j].setPosY(i);
                    }
                    if (j == 2 || j == 5) {
                        Image imagen = imagenO.getSubimage(258, 1, 60, 60); //<--Este metodo devuelve una parte de la img.
                        imagen = imagen.getScaledInstance(38, 38, Image.SCALE_SMOOTH); //Reescalar la imagen obtenida.
                        tableroVisual[i][j].setIcon(new ImageIcon(imagen));
                        tablero[i][j] = new Alfil(imagen, "alfil", i, j);
                        tablero[i][j].setBlanco(false);
                        tablero[i][j].setPosX(j);
                        tablero[i][j].setPosY(i);
                    }
                    if (j == 4) {
                        Image imagen = imagenO.getSubimage(3, 1, 60, 60); //<--Este metodo devuelve una parte de la img.
                        imagen = imagen.getScaledInstance(38, 38, Image.SCALE_SMOOTH); //Reescalar la imagen obtenida.
                        tableroVisual[i][j].setIcon(new ImageIcon(imagen));
                        tablero[i][j] = new Rey(imagen, "rey", i, j);
                        tablero[i][j].setBlanco(false);
                        tablero[i][j].setPosX(j);
                        tablero[i][j].setPosY(i);
                    }
                    if (j == 3) {
                        Image imagen = imagenO.getSubimage(67, 1, 60, 60); //<--Este metodo devuelve una parte de la img.
                        imagen = imagen.getScaledInstance(38, 38, Image.SCALE_SMOOTH); //Reescalar la imagen obtenida.
                        tableroVisual[i][j].setIcon(new ImageIcon(imagen));
                        tablero[i][j] = new Reina(imagen, "reina", i, j);
                        tablero[i][j].setBlanco(false);
                        tablero[i][j].setPosX(j);
                        tablero[i][j].setPosY(i);
                    }
                }
                if (i == 7) {
                    if (j == 0 || j == 7) {
                        Image imagen = imagenO.getSubimage(130, 65, 60, 60); //<--Este metodo devuelve una parte de la img.
                        imagen = imagen.getScaledInstance(38, 38, Image.SCALE_SMOOTH); //Reescalar la imagen obtenida.
                        tableroVisual[i][j].setIcon(new ImageIcon(imagen));
                        tablero[i][j] = new Torre(imagen, "torre", i, j);
                        tablero[i][j].setBlanco(true);
                        tablero[i][j].setPosX(j);
                        tablero[i][j].setPosY(i);
                    }
                    if (j == 1 || j == 6) {
                        Image imagen = imagenO.getSubimage(195, 65, 60, 60); //<--Este metodo devuelve una parte de la img.
                        imagen = imagen.getScaledInstance(38, 38, Image.SCALE_SMOOTH); //Reescalar la imagen obtenida.
                        tableroVisual[i][j].setIcon(new ImageIcon(imagen));
                        tablero[i][j] = new Caballo(imagen, "caballo", i, j);
                        tablero[i][j].setBlanco(true);
                        tablero[i][j].setPosX(j);
                        tablero[i][j].setPosY(i);
                    }
                    if (j == 2 || j == 5) {
                        Image imagen = imagenO.getSubimage(258, 65, 60, 60); //<--Este metodo devuelve una parte de la img.
                        imagen = imagen.getScaledInstance(38, 38, Image.SCALE_SMOOTH); //Reescalar la imagen obtenida.
                        tableroVisual[i][j].setIcon(new ImageIcon(imagen));
                        tablero[i][j] = new Alfil(imagen, "alfil", i, j);
                        tablero[i][j].setBlanco(true);
                        tablero[i][j].setPosX(j);
                        tablero[i][j].setPosY(i);
                    }
                    if (j == 4) {
                        Image imagen = imagenO.getSubimage(3, 65, 60, 60); //<--Este metodo devuelve una parte de la img.
                        imagen = imagen.getScaledInstance(38, 38, Image.SCALE_SMOOTH); //Reescalar la imagen obtenida.
                        tableroVisual[i][j].setIcon(new ImageIcon(imagen));
                        tablero[i][j] = new Rey(imagen, "rey", i, j);
                        tablero[i][j].setBlanco(true);
                        tablero[i][j].setPosX(j);
                        tablero[i][j].setPosY(i);
                    }
                    if (j == 3) {
                        Image imagen = imagenO.getSubimage(67, 65, 60, 60); //<--Este metodo devuelve una parte de la img.
                        imagen = imagen.getScaledInstance(38, 38, Image.SCALE_SMOOTH); //Reescalar la imagen obtenida.
                        tableroVisual[i][j].setIcon(new ImageIcon(imagen));
                        tablero[i][j] = new Reina(imagen, "reina", i, j);
                        tablero[i][j].setBlanco(true);
                        tablero[i][j].setPosX(j);
                        tablero[i][j].setPosY(i);
                    }
                }
            }
        }
        this.getContentPane().add(tableroPanel);
    }

    private void moverFicha(Ficha ficha, JLabel labelActual) {
        if (!algunJaqueMate()) {
            if (turnoBlanco) {
                System.out.println("Turno blanco");
                if (ficha != null && ficha.esBlanco() && !clickFicha) {
                    clickFicha = true;
                    fichaClickeada[0] = ficha;
                    labelClickeado = labelActual;
                }
                if (ficha == null && clickFicha && fichaClickeada[0].puedeMoverse(tablero, posX, posY)) {

                    ubicarFicha(labelActual, false);
                    turnoBlanco = false;
                    clickFicha = false;
                }
                if (ficha != null && clickFicha) {
                    if (fichaClickeada[0].getNombre().equals("rey") && ((Rey) fichaClickeada[0]).puedeEnroque(tablero, posX, posY)) {
                        ubicarFicha(labelActual, true);
                        turnoBlanco = false;
                        clickFicha = false;
                    }
                }
                if (ficha != null && !ficha.esBlanco() && clickFicha && fichaClickeada[0].puedeAtacar(tablero, posX, posY)) {
                    ubicarFicha(labelActual, false);
                    turnoBlanco = false;
                    clickFicha = false;
                }
                if (ficha != null && ficha.esBlanco() && clickFicha) {
                    fichaClickeada[0] = ficha;
                    labelClickeado = labelActual;
                }
            } else {
                System.out.println("Turno negro");
                if (ficha != null && !ficha.esBlanco() && !clickFicha) {
                    clickFicha = true;
                    fichaClickeada[0] = ficha;
                    labelClickeado = labelActual;
                }
                if (ficha == null && clickFicha && fichaClickeada[0].puedeMoverse(tablero, posX, posY)) {
                    ubicarFicha(labelActual, false);
                    turnoBlanco = true;
                    clickFicha = false;
                }
                if (ficha != null && clickFicha) {
                    if (fichaClickeada[0].getNombre().equals("rey") && ((Rey) fichaClickeada[0]).puedeEnroque(tablero, posX, posY)) {
                        ubicarFicha(labelActual, true);
                        turnoBlanco = true;
                        clickFicha = false;
                    }
                }
                if (ficha != null && ficha.esBlanco() && clickFicha && fichaClickeada[0].puedeAtacar(tablero, posX, posY)) {
                    ubicarFicha(labelActual, false);
                    turnoBlanco = true;
                    clickFicha = false;
                }
                if (ficha != null && !ficha.esBlanco() && clickFicha) {
                    fichaClickeada[0] = ficha;
                    labelClickeado = labelActual;
                }
            }
        } else {
            pintarJaqueMate();
        }
        tableroPanel.revalidate();
        tableroPanel.repaint();
    }

    private boolean algunJaqueMate() {
        for (int i = 0; i < 8; i++) {
            for (int j = 0; j < 8; j++) {
                if (tablero[i][j] != null && turnoBlanco && tablero[i][j].esBlanco() && tablero[i][j].getNombre().equals("rey")) {
                    reyes[0] = tablero[i][j];
                    if (!((Rey) reyes[0]).hayJaqueMate(tablero, turnoBlanco, clickFicha) && ((Rey) reyes[0]).getJaques() < 2) {
                        return false;
                    }
                }
                if (tablero[i][j] != null && !turnoBlanco && !tablero[i][j].esBlanco() && tablero[i][j].getNombre().equals("rey")) {
                    reyes[1] = tablero[i][j];
                    if (!((Rey) reyes[1]).hayJaqueMate(tablero, turnoBlanco, clickFicha) && ((Rey) reyes[1]).getJaques() < 2) {
                        return false;
                    }
                }
            }
        }
        return true;
    }

    private void pintarJaqueMate() {
        String ganador = "";
        for (int i = 0; i < 8; i++) {
            for (int j = 0; j < 8; j++) {
                if (turnoBlanco) {
                    ganador = "negras";
                    if (tablero[i][j] != null && !tablero[i][j].esBlanco() && tablero[i][j].puedeAtacar(tablero, reyes[0].getPosX(), reyes[0].getPosY())) {
                        for (int k = 0; k < 8; k++) {
                            for (int l = 0; l < 8; l++) {
                                if (tablero[i][j].getMovimiento()[k][l]) {
                                    tableroVisual[k][l].setBackground(Color.lightGray);
                                }
                            }
                        }
                        break;
                    }
                } else {
                    ganador = "blancas";
                    if (tablero[i][j] != null && tablero[i][j].esBlanco() && tablero[i][j].puedeAtacar(tablero, reyes[1].getPosX(), reyes[1].getPosY())) {
                        for (int k = 0; k < 8; k++) {
                            for (int l = 0; l < 8; l++) {
                                if (tablero[i][j].getMovimiento()[k][l]) {
                                    tableroVisual[k][l].setBackground(Color.lightGray);
                                }
                            }
                        }
                        break;
                    }
                }
            }
        }
        JOptionPane.showMessageDialog(null, "El ganador son las fichas " + ganador);
    }

    private void ubicarFicha(JLabel labelActual, boolean enroque) {
        if (enroque) { //Caso del enroque
            Torre torreAux = ((Torre) tablero[posY][posX]);
            int nuevaPosXTorre = fichaClickeada[0].getPosX(); //Vieja posX del rey.
            int nuevaPosYTorre = fichaClickeada[0].getPosY(); //Vieja posY del rey.
            int nuevaPosXRey = posX; //Vieja posX de la torre.
            int nuevaPosYRey = posY; //Vieja posY de la torre.
            tablero[nuevaPosYRey][nuevaPosXRey] = null; //Volver nulo ese espacio porque no habran fichas ahi.
            tablero[nuevaPosYTorre][nuevaPosXTorre] = null; //Volver nulo ese espacio porque no habran fichas ahi.
            if (torreAux.getPosX() > fichaClickeada[0].getPosX()) { //Enroque corto.
                nuevaPosXTorre++;
                nuevaPosXRey--;
            } else { //Enroque largo.
                nuevaPosXTorre--;
                nuevaPosXRey = nuevaPosXRey + 2;
            }
            System.out.println("Xrey = " + nuevaPosXRey + " Yrey = " + nuevaPosYRey);
            System.out.println("XTorre = " + nuevaPosXTorre + " YTorre = " + nuevaPosYTorre);
            tablero[nuevaPosYRey][nuevaPosXRey] = fichaClickeada[0];
            tablero[nuevaPosYTorre][nuevaPosXTorre] = torreAux;
            torreAux.setPosX(nuevaPosXTorre);
            torreAux.setPosY(nuevaPosYTorre);
            fichaClickeada[0].setPosX(nuevaPosXRey);
            fichaClickeada[0].setPosY(nuevaPosYRey);
            tableroVisual[nuevaPosYRey][nuevaPosXRey].setIcon(new ImageIcon(fichaClickeada[0].getImagen()));
            tableroVisual[nuevaPosYTorre][nuevaPosXTorre].setIcon(new ImageIcon(torreAux.getImagen()));
            labelActual.setIcon(null); //Label viejo de la torre.
            labelClickeado.setIcon(null); //Label viejo del rey.
            torreAux = null;
        } else { //Caso normal
            int viejaPosX = fichaClickeada[0].getPosX();
            int viejaPosY = fichaClickeada[0].getPosY();
            if (fichaClickeada[0].getNombre().equals("peon") && fichaClickeada[0].esBlanco()) { //Caso peon ataque al paso
                if (tablero[posY + 1][posX] != null && tablero[posY + 1][posX].getNombre().equals("peon") && !tablero[posY + 1][posX].esBlanco() && tablero[posY][posX] == null) {
                    tablero[posY + 1][posX] = null;
                    tableroVisual[posY + 1][posX].setIcon(null);
                }
            } else if (fichaClickeada[0].getNombre().equals("peon") && !fichaClickeada[0].esBlanco()) {
                if (tablero[posY - 1][posX] != null && tablero[posY - 1][posX].getNombre().equals("peon") && tablero[posY - 1][posX].esBlanco() && tablero[posY][posX] == null) {
                    tablero[posY - 1][posX] = null;
                    tableroVisual[posY - 1][posX].setIcon(null);
                }
            }
            tablero[posY][posX] = fichaClickeada[0];
            tablero[viejaPosY][viejaPosX] = null;
            fichaClickeada[0].setPosX(posX);
            fichaClickeada[0].setPosY(posY);
            labelActual.setIcon(new ImageIcon(fichaClickeada[0].getImagen()));
            labelClickeado.setIcon(null);

        }
    }

    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(VentanaJuegoLocal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(VentanaJuegoLocal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(VentanaJuegoLocal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(VentanaJuegoLocal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new VentanaJuegoLocal().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    // End of variables declaration//GEN-END:variables
}
