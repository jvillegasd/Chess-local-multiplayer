package ajedrez;

public class VentanaMain extends javax.swing.JFrame {

    public VentanaMain() {
        initComponents();
        opcionesJd.setResizable(false);
        ingresarIPJd.setResizable(false);
        lobbyJd.setResizable(false);
        opcionesJd.setSize(360, 147);
        ingresarIPJd.setSize(320, 148);
        lobbyJd.setSize(216, 140);
        esperandoLb.setVisible(false);
        this.setLocationRelativeTo(null);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        opcionesJd = new javax.swing.JDialog();
        crearPartidaBt = new javax.swing.JButton();
        unirseBt = new javax.swing.JButton();
        ingresarIPJd = new javax.swing.JDialog();
        IPtf = new javax.swing.JTextField();
        aceptarIPBt = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        puertoSalaLb = new javax.swing.JLabel();
        puertoSalaTF = new javax.swing.JTextField();
        lobbyJd = new javax.swing.JDialog();
        esperandoLb = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        muestraIPLb = new javax.swing.JLabel();
        puertoLb = new javax.swing.JLabel();
        puertoTF = new javax.swing.JTextField();
        aceptarPuertoBt = new javax.swing.JButton();
        localBt = new javax.swing.JButton();
        multiBt = new javax.swing.JButton();
        TituloLb = new javax.swing.JLabel();
        nombresLb = new javax.swing.JLabel();

        crearPartidaBt.setText("Crear Partida");
        crearPartidaBt.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                crearPartidaBtActionPerformed(evt);
            }
        });

        unirseBt.setText("Unirse a una partida");
        unirseBt.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                unirseBtActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout opcionesJdLayout = new javax.swing.GroupLayout(opcionesJd.getContentPane());
        opcionesJd.getContentPane().setLayout(opcionesJdLayout);
        opcionesJdLayout.setHorizontalGroup(
            opcionesJdLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, opcionesJdLayout.createSequentialGroup()
                .addContainerGap(55, Short.MAX_VALUE)
                .addComponent(crearPartidaBt)
                .addGap(39, 39, 39)
                .addComponent(unirseBt)
                .addGap(40, 40, 40))
        );
        opcionesJdLayout.setVerticalGroup(
            opcionesJdLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(opcionesJdLayout.createSequentialGroup()
                .addGap(56, 56, 56)
                .addGroup(opcionesJdLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(crearPartidaBt)
                    .addComponent(unirseBt))
                .addContainerGap(62, Short.MAX_VALUE))
        );

        aceptarIPBt.setText("Aceptar");
        aceptarIPBt.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                aceptarIPBtActionPerformed(evt);
            }
        });

        jLabel1.setText("Ingrese la IP de la sala: ");

        puertoSalaLb.setText("Ingrese el puerto de la sala: ");

        javax.swing.GroupLayout ingresarIPJdLayout = new javax.swing.GroupLayout(ingresarIPJd.getContentPane());
        ingresarIPJd.getContentPane().setLayout(ingresarIPJdLayout);
        ingresarIPJdLayout.setHorizontalGroup(
            ingresarIPJdLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(ingresarIPJdLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(ingresarIPJdLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(ingresarIPJdLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addGroup(ingresarIPJdLayout.createSequentialGroup()
                            .addComponent(puertoSalaLb)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addComponent(puertoSalaTF))
                        .addGroup(ingresarIPJdLayout.createSequentialGroup()
                            .addComponent(jLabel1)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addComponent(IPtf, javax.swing.GroupLayout.PREFERRED_SIZE, 128, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addComponent(aceptarIPBt))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        ingresarIPJdLayout.setVerticalGroup(
            ingresarIPJdLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(ingresarIPJdLayout.createSequentialGroup()
                .addGap(17, 17, 17)
                .addGroup(ingresarIPJdLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(IPtf, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(ingresarIPJdLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(puertoSalaLb)
                    .addComponent(puertoSalaTF, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(41, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, ingresarIPJdLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(aceptarIPBt)
                .addContainerGap())
        );

        esperandoLb.setText("Esperando jugadores...");

        jLabel3.setText("IP del Servidor:");

        muestraIPLb.setText("LABEL");

        puertoLb.setText("Puerto del servidor:");

        aceptarPuertoBt.setText("Buscar Jugadores");
        aceptarPuertoBt.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                aceptarPuertoBtActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout lobbyJdLayout = new javax.swing.GroupLayout(lobbyJd.getContentPane());
        lobbyJd.getContentPane().setLayout(lobbyJdLayout);
        lobbyJdLayout.setHorizontalGroup(
            lobbyJdLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, lobbyJdLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(lobbyJdLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(lobbyJdLayout.createSequentialGroup()
                        .addComponent(jLabel3)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(muestraIPLb, javax.swing.GroupLayout.PREFERRED_SIZE, 108, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(lobbyJdLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                        .addComponent(aceptarPuertoBt)
                        .addGroup(lobbyJdLayout.createSequentialGroup()
                            .addComponent(puertoLb)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addComponent(puertoTF, javax.swing.GroupLayout.PREFERRED_SIZE, 69, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addGap(18, 18, 18))
            .addGroup(lobbyJdLayout.createSequentialGroup()
                .addGap(42, 42, 42)
                .addComponent(esperandoLb)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        lobbyJdLayout.setVerticalGroup(
            lobbyJdLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(lobbyJdLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(esperandoLb)
                .addGap(18, 18, 18)
                .addGroup(lobbyJdLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(muestraIPLb, javax.swing.GroupLayout.PREFERRED_SIZE, 14, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(lobbyJdLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(puertoLb)
                    .addComponent(puertoTF, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(aceptarPuertoBt)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        localBt.setText("Local");
        localBt.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                localBtActionPerformed(evt);
            }
        });

        multiBt.setText("Multijugador");
        multiBt.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                multiBtActionPerformed(evt);
            }
        });

        TituloLb.setFont(new java.awt.Font("Verdana", 0, 18)); // NOI18N
        TituloLb.setText("Ajedrez");

        nombresLb.setText("por Johnny Villegas y Javier Valencia");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(50, 50, 50)
                        .addComponent(multiBt)
                        .addGap(49, 49, 49)
                        .addComponent(localBt))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(53, 53, 53)
                        .addComponent(nombresLb))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(126, 126, 126)
                        .addComponent(TituloLb)))
                .addContainerGap(53, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(TituloLb)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(nombresLb)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 21, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(multiBt)
                    .addComponent(localBt))
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void multiBtActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_multiBtActionPerformed
        opcionesJd.setVisible(true);
    }//GEN-LAST:event_multiBtActionPerformed

    private void unirseBtActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_unirseBtActionPerformed
        ingresarIPJd.setVisible(true);
    }//GEN-LAST:event_unirseBtActionPerformed

    private void aceptarIPBtActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_aceptarIPBtActionPerformed
        VentanaJuegoCliente negras = new VentanaJuegoCliente();
        int puerto = Integer.parseInt(puertoSalaTF.getText());
        String IP = IPtf.getText();
        negras.iniciarConexion(IP, puerto);
        ingresarIPJd.dispose();
    }//GEN-LAST:event_aceptarIPBtActionPerformed

    private void crearPartidaBtActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_crearPartidaBtActionPerformed
        lobbyJd.setVisible(true);
    }//GEN-LAST:event_crearPartidaBtActionPerformed

    private void aceptarPuertoBtActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_aceptarPuertoBtActionPerformed
        VentanaJuegoServer blancas = new VentanaJuegoServer();
        int puerto = Integer.parseInt(puertoTF.getText());
        blancas.iniciarConexion(puerto);
        esperandoLb.setVisible(true);
        puertoTF.setEnabled(false);
        aceptarPuertoBt.setEnabled(false);
        muestraIPLb.setText(blancas.getIp());
    }//GEN-LAST:event_aceptarPuertoBtActionPerformed

    private void localBtActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_localBtActionPerformed
        VentanaJuegoLocal local = new VentanaJuegoLocal();
        local.setVisible(true);
    }//GEN-LAST:event_localBtActionPerformed

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
            java.util.logging.Logger.getLogger(VentanaMain.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(VentanaMain.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(VentanaMain.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(VentanaMain.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new VentanaMain().setVisible(true);
            }
        });

    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextField IPtf;
    private javax.swing.JLabel TituloLb;
    private javax.swing.JButton aceptarIPBt;
    private javax.swing.JButton aceptarPuertoBt;
    private javax.swing.JButton crearPartidaBt;
    private javax.swing.JLabel esperandoLb;
    private javax.swing.JDialog ingresarIPJd;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JDialog lobbyJd;
    private javax.swing.JButton localBt;
    private javax.swing.JLabel muestraIPLb;
    private javax.swing.JButton multiBt;
    private javax.swing.JLabel nombresLb;
    private javax.swing.JDialog opcionesJd;
    private javax.swing.JLabel puertoLb;
    private javax.swing.JLabel puertoSalaLb;
    private javax.swing.JTextField puertoSalaTF;
    private javax.swing.JTextField puertoTF;
    private javax.swing.JButton unirseBt;
    // End of variables declaration//GEN-END:variables
}
