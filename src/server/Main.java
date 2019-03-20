/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package server;

import java.net.MalformedURLException;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.util.ArrayList;
import javax.swing.JOptionPane;


public class Main extends javax.swing.JFrame {

    ArrayList<Integer> listaNumeros = new ArrayList<>();
    String ip = "192.168.43.229", name = "SD";
    
    
    public Main() {
        initComponents();
    }

   
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        txtNumeroAInserir = new javax.swing.JTextField();
        botaoAdicionar = new javax.swing.JButton();
        botaoEnviar = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setResizable(false);

        txtNumeroAInserir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtNumeroAInserirActionPerformed(evt);
            }
        });

        botaoAdicionar.setText("Inserir");
        botaoAdicionar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botaoAdicionarActionPerformed(evt);
            }
        });

        botaoEnviar.setText("Enviar");
        botaoEnviar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botaoEnviarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(59, 59, 59)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(txtNumeroAInserir)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(botaoEnviar, javax.swing.GroupLayout.PREFERRED_SIZE, 74, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(48, 48, 48)
                        .addComponent(botaoAdicionar, javax.swing.GroupLayout.PREFERRED_SIZE, 78, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(141, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(94, 94, 94)
                .addComponent(txtNumeroAInserir, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(30, 30, 30)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(botaoEnviar)
                    .addComponent(botaoAdicionar))
                .addContainerGap(133, Short.MAX_VALUE))
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void botaoAdicionarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botaoAdicionarActionPerformed
        // TODO add your handling code here:
        
        if(txtNumeroAInserir.getText().toString().equals("")){
            JOptionPane.showMessageDialog(null, "Insira um número!");
        } else{
            listaNumeros.add(Integer.parseInt(txtNumeroAInserir.getText().toString()));
            txtNumeroAInserir.setText("");
            JOptionPane.showMessageDialog(null, "Número adicionado com sucesso!");
        }
        
    }//GEN-LAST:event_botaoAdicionarActionPerformed

    private void botaoEnviarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botaoEnviarActionPerformed
        // TODO add your handling code here:
        
                ArrayList<Integer> numerosOrdenados = new ArrayList<>();
		try {
			Cliente<InterfaceOrdena> client = new Cliente<InterfaceOrdena>(ip, name);
			numerosOrdenados = client.getRemoteObj().ordenarNumeros(listaNumeros);
			
			System.out.println("Array Ordenado ");
			for(int i=0; i<numerosOrdenados.size(); i++) {
				System.out.print(numerosOrdenados.get(i) + "   ");
			}
			
		}catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
                
                listaNumeros.clear();
        
    }//GEN-LAST:event_botaoEnviarActionPerformed

    private void txtNumeroAInserirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtNumeroAInserirActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtNumeroAInserirActionPerformed

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
                if ("Windows".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(Main.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Main.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Main.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Main.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Main().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton botaoAdicionar;
    private javax.swing.JButton botaoEnviar;
    private javax.swing.JTextField txtNumeroAInserir;
    // End of variables declaration//GEN-END:variables
}
