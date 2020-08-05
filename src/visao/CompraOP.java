/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package visao;

import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableRowSorter;
import modelo.Compra;
import modelo.CompraDAO;
import modelo.Produto;
import modelo.ProdutoDAO;

/**
 *
 * @author olive
 */
public class CompraOP extends javax.swing.JFrame {

    /**
     * Creates new form Compra
     */
    public CompraOP() {
        initComponents();
         DefaultTableModel modelo = (DefaultTableModel) jTable1.getModel();
        jTable1.setRowSorter(new TableRowSorter(modelo));
        readT();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        CadastraUsuario = new javax.swing.JButton();
        CadastraProduto = new javax.swing.JButton();
        jPanel2 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jCodCliente = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        jCodProduto = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        jQtd = new javax.swing.JTextField();
        jButton3 = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        jPanel3 = new javax.swing.JPanel();
        jButton5 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jButton1 = new javax.swing.JButton();
        jButton4 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("PraConstru");

        jPanel1.setLayout(new java.awt.GridLayout(2, 1));

        CadastraUsuario.setText("Cadastrar Cliente");
        CadastraUsuario.setMaximumSize(new java.awt.Dimension(80, 40));
        CadastraUsuario.setMinimumSize(new java.awt.Dimension(80, 40));
        CadastraUsuario.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                CadastraUsuarioActionPerformed(evt);
            }
        });
        jPanel1.add(CadastraUsuario);

        CadastraProduto.setText("Cadastrar Produto");
        CadastraProduto.setMaximumSize(new java.awt.Dimension(80, 40));
        CadastraProduto.setMinimumSize(new java.awt.Dimension(80, 40));
        CadastraProduto.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                CadastraProdutoActionPerformed(evt);
            }
        });
        jPanel1.add(CadastraProduto);

        jPanel2.setLayout(new java.awt.GridLayout(4, 3));

        jLabel1.setText("Codigo de Cliente");
        jLabel1.setMaximumSize(new java.awt.Dimension(26, 16));
        jLabel1.setMinimumSize(new java.awt.Dimension(26, 16));
        jPanel2.add(jLabel1);
        jPanel2.add(jCodCliente);

        jLabel2.setText("Codigo de Produto");
        jLabel2.setMaximumSize(new java.awt.Dimension(26, 16));
        jLabel2.setMinimumSize(new java.awt.Dimension(26, 16));
        jPanel2.add(jLabel2);
        jPanel2.add(jCodProduto);

        jLabel3.setText("Quatidade");
        jPanel2.add(jLabel3);
        jPanel2.add(jQtd);

        jButton3.setText("Compra");
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });
        jPanel2.add(jButton3);

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Codigo", "Codigo de Cliente", "Codigo de Produto", "Quant. Produtos comprados"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Object.class, java.lang.Integer.class, java.lang.Integer.class, java.lang.Integer.class
            };
            boolean[] canEdit = new boolean [] {
                true, false, true, true
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane1.setViewportView(jTable1);

        jPanel3.setLayout(new java.awt.GridLayout());

        jButton5.setText("Adcionar");
        jButton5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton5ActionPerformed(evt);
            }
        });
        jPanel3.add(jButton5);

        jButton2.setText("Atualizar");
        jPanel3.add(jButton2);

        jButton1.setText("Remover");
        jPanel3.add(jButton1);

        jButton4.setText("Sair");
        jButton4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton4ActionPerformed(evt);
            }
        });
        jPanel3.add(jButton4);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, 361, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addContainerGap())))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 178, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton4ActionPerformed
      dispose();
    }//GEN-LAST:event_jButton4ActionPerformed

    private void CadastraUsuarioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_CadastraUsuarioActionPerformed
       ClienteOP cli = new ClienteOP();
       cli.setVisible(true);
    }//GEN-LAST:event_CadastraUsuarioActionPerformed

    private void CadastraProdutoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_CadastraProdutoActionPerformed
       ProdutoOP p = new ProdutoOP();
       p.setVisible(true);
    }//GEN-LAST:event_CadastraProdutoActionPerformed

    public void readT(){
    CompraDAO am = new CompraDAO();
        DefaultTableModel modelo = (DefaultTableModel) jTable1.getModel();
        modelo.setNumRows(0);
            for (Compra a: am.listar()) {
            modelo.addRow(new Object[]{
            a.getCodigo(), 
            a.getIdCliente(), 
            a.getIdProduto(),
            a.getQtd()
            });
        }    
    }
    
    private void jButton5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton5ActionPerformed
        int codCliente = Integer.parseInt(jCodProduto.getText());
       int codProduto = Integer.parseInt(jCodCliente.getText());
       int qtd = Integer.parseInt(jQtd.getText());
        Compra a = new Compra(codCliente, codProduto, qtd);
        CompraDAO am = new CompraDAO();
        
        jCodCliente.setText("");
        jCodProduto.setText("");
        jQtd.setText("");
        
        am.inserir(a);
        readT(); 
    }//GEN-LAST:event_jButton5ActionPerformed

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        int codCliente = Integer.parseInt(jCodProduto.getText());
       int codProduto = Integer.parseInt(jCodCliente.getText());
       int qtd = Integer.parseInt(jQtd.getText());
        Compra a = new Compra(codCliente, codProduto, qtd);
        CompraDAO am = new CompraDAO();
         am.inserir(a);
        JOptionPane.showMessageDialog(null, ""+am.listarPreco());
    }//GEN-LAST:event_jButton3ActionPerformed

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
            java.util.logging.Logger.getLogger(CompraOP.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(CompraOP.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(CompraOP.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(CompraOP.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new CompraOP().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton CadastraProduto;
    private javax.swing.JButton CadastraUsuario;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButton4;
    private javax.swing.JButton jButton5;
    private javax.swing.JTextField jCodCliente;
    private javax.swing.JTextField jCodProduto;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JTextField jQtd;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTable1;
    // End of variables declaration//GEN-END:variables
}