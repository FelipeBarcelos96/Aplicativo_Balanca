/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.sankhya.view;

import br.com.sankhya.SwingUtils.ManipuladorDeComboBox;
import br.com.sankhya.ConnUtils.IdentificadorDeSeriais;

/**
 *
 * @author Felps
 */
public class TesteDialog extends javax.swing.JDialog {

    /**
     * Creates new form NewJDialog
     */
    
    private BotaoView pai;
    
    public TesteDialog(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        pai = (BotaoView) parent;
        initComponents();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        testeLabel1 = new javax.swing.JLabel();
        simButton = new javax.swing.JButton();
        naoButton = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Verificação de Teste");

        testeLabel1.setFont(new java.awt.Font("Arial Black", 1, 24)); // NOI18N
        testeLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        testeLabel1.setText("Testando?");

        simButton.setText("Sim");
        simButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                simButtonActionPerformed(evt);
            }
        });

        naoButton.setText("Não");
        naoButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                naoButtonActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(56, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(simButton)
                        .addGap(63, 63, 63)
                        .addComponent(naoButton))
                    .addComponent(testeLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 165, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(56, 56, 56))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(testeLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 51, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 26, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(simButton)
                    .addComponent(naoButton))
                .addGap(21, 21, 21))
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void simButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_simButtonActionPerformed
        pai.setIsAmbienteTeste(true);
        ManipuladorDeComboBox.getInstance().listaItens(IdentificadorDeSeriais.getInstance().listarSeriais(true), pai.getJcbCOM()); 
        this.dispose();
    }//GEN-LAST:event_simButtonActionPerformed

    private void naoButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_naoButtonActionPerformed
        pai.setIsAmbienteTeste(false);
        ManipuladorDeComboBox.getInstance().listaItens(IdentificadorDeSeriais.getInstance().listarSeriais(false), pai.getJcbCOM()); 
        this.dispose();
    }//GEN-LAST:event_naoButtonActionPerformed

    /**
     * @param args the command line arguments
     */
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
            java.util.logging.Logger.getLogger(TesteDialog.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(TesteDialog.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(TesteDialog.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(TesteDialog.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the dialog */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                TesteDialog dialog = new TesteDialog(new javax.swing.JFrame(), true);
                dialog.addWindowListener(new java.awt.event.WindowAdapter() {
                    @Override
                    public void windowClosing(java.awt.event.WindowEvent e) {
                        System.exit(0);
                    }
                });
                dialog.setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton naoButton;
    private javax.swing.JButton simButton;
    private javax.swing.JLabel testeLabel1;
    // End of variables declaration//GEN-END:variables
}