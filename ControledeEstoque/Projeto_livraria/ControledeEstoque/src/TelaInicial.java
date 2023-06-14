/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
import javax.swing.*;
import java.awt.*;

public class TelaInicial extends javax.swing.JFrame {


    public TelaInicial() {
        initComponents();
    }
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        botaoCadastrar = new javax.swing.JButton();
        botaoConsulta = new javax.swing.JButton();
        botaoEntrada = new javax.swing.JButton();
        BotaoDeletar = new javax.swing.JButton();
        botaoHistorico = new javax.swing.JButton();
        jLabel3 = new javax.swing.JLabel();

        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setTitle("Papelaria LP");
        setMinimumSize(new java.awt.Dimension(700, 550));
        setLayout(null);

        labelTitulo = new JLabel("Papelaria");
        labelTitulo.setFont(new Font("Segoe UI", Font.BOLD, 45));
        labelTitulo.setBounds(37, 14, 266, 61);
        add(labelTitulo);

        labelGestaoEstoque = new JLabel("Gestão de estoque");
        labelGestaoEstoque.setFont(new Font("Segoe UI", Font.BOLD, 25));
        labelGestaoEstoque.setBounds(37, 74, 225, 34);
        add(labelGestaoEstoque);

        botaoCadastrar = new JButton("Cadastrar");
        botaoCadastrar.setFont(new Font("Segoe UI", Font.BOLD, 30));
        botaoCadastrar.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        botaoCadastrar.setCursor(new Cursor(Cursor.HAND_CURSOR));
        botaoCadastrar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botaoCadastrarActionPerformed(evt);
            }
        });
        botaoCadastrar.setBounds(140, 126, 459, 69);
        add(botaoCadastrar);


        botaoConsulta = new JButton("Consultar");
        botaoConsulta.setFont(new Font("Segoe UI", Font.BOLD, 25));
        botaoConsulta.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        botaoConsulta.setCursor(new Cursor(Cursor.HAND_CURSOR));
        botaoConsulta.setPreferredSize(new java.awt.Dimension(200, 50));
        botaoConsulta.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botaoConsultaActionPerformed(evt);
            }
        });
        botaoConsulta.setBounds(391, 213, 208, 56);
        add(botaoConsulta);


        botaoEntrada = new JButton("Editor");
        botaoEntrada.setFont(new Font("Segoe UI", Font.BOLD, 25));
        botaoEntrada.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        botaoEntrada.setCursor(new Cursor(Cursor.HAND_CURSOR));
        botaoEntrada.setPreferredSize(new java.awt.Dimension(200, 50));
        botaoEntrada.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botaoEntradaActionPerformed(evt);
            }
        });
        botaoEntrada.setBounds(140, 213, 245, 56);
        add(botaoEntrada);

        BotaoDeletar.setFont(new java.awt.Font("Segoe UI", 1, 25)); // NOI18N
        BotaoDeletar.setText("Deletar produto");
        BotaoDeletar.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        BotaoDeletar.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        BotaoDeletar.setMaximumSize(new java.awt.Dimension(206, 41));
        BotaoDeletar.setMinimumSize(new java.awt.Dimension(206, 41));
        BotaoDeletar.setPreferredSize(new java.awt.Dimension(200, 50));
        BotaoDeletar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BotaoDeletarActionPerformed(evt);
            }
        });
        getContentPane().add(BotaoDeletar);
        BotaoDeletar.setBounds(140, 281, 245, 65);

        botaoHistorico.setFont(new java.awt.Font("Segoe UI", 1, 25)); // NOI18N
        botaoHistorico.setText("Histórico");
        botaoHistorico.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        botaoHistorico.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        botaoHistorico.setPreferredSize(new java.awt.Dimension(200, 50));
        botaoHistorico.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botaoHistoricoActionPerformed(evt);
            }
        });
        getContentPane().add(botaoHistorico);
        botaoHistorico.setBounds(391, 281, 208, 65);

        jLabel3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagens/tela1.jpg"))); // NOI18N
        getContentPane().add(jLabel3);
        jLabel3.setBounds(0, 0, 730, 510);

        setSize(new java.awt.Dimension(745, 516));
        setLocationRelativeTo(null);
        setResizable(false);
    }// </editor-fold>

    private void botaoCadastrarActionPerformed(java.awt.event.ActionEvent evt) {
        // TODO add your handling code here:
        new Cadastro().setVisible(true);
        dispose();
    }

    private void botaoConsultaActionPerformed(java.awt.event.ActionEvent evt) {
        // TODO add your handling code here:
        new Consulta().setVisible(true);
        dispose();
    }

    private void BotaoDeletarActionPerformed(java.awt.event.ActionEvent evt) {
        // TODO add your handling code here:
        new DeletarProduto().setVisible(true);
        dispose();
    }

    private void botaoHistoricoActionPerformed(java.awt.event.ActionEvent evt) {
        // TODO add your handling code here:
        new Historico().setVisible(true);
        dispose();
    }

    private void botaoEntradaActionPerformed(java.awt.event.ActionEvent evt) {
        // TODO add your handling code here:
        new Editor().setVisible(true);
        dispose();
    }

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
            java.util.logging.Logger.getLogger(TelaInicial.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(TelaInicial.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(TelaInicial.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(TelaInicial.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new TelaInicial().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify
    private javax.swing.JButton BotaoDeletar;
    private javax.swing.JButton botaoCadastrar;
    private javax.swing.JButton botaoConsulta;
    private javax.swing.JButton botaoEntrada;
    private javax.swing.JButton botaoHistorico;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel labelTitulo;
    private javax.swing.JLabel labelGestaoEstoque;
    private javax.swing.JButton botaoDeletar;

    private javax.swing.JLabel labelImagem;
    // End of variables declaration
}
