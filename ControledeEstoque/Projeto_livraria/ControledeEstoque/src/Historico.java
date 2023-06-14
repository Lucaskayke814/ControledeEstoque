/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */


import javax.swing.*;
import java.awt.*;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

/**
 *
 * @author Windows
 */
public class Historico extends javax.swing.JFrame {

    private String lerArquivoTexto(String caminhoArquivo) {
        StringBuilder conteudo = new StringBuilder();
        try (BufferedReader reader = new BufferedReader(new FileReader(caminhoArquivo))) {
            String linha;
            while ((linha = reader.readLine()) != null) {
                conteudo.append(linha).append("\n");
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return conteudo.toString();
    }
    String caminhoArquivo = "erros.txt";
    String conteudoArquivo = lerArquivoTexto(caminhoArquivo);


    public Historico() {
        initComponents();
    }



    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        botaoVoltar = new javax.swing.JButton();
        jLabel3 = new javax.swing.JLabel();
        Log_text = new javax.swing.JTextArea();


        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setTitle("Histórico");
        setPreferredSize(new java.awt.Dimension(750, 550));
        getContentPane().setLayout(null);

        labelTitulo = new JLabel("Histórico");
        labelTitulo.setFont(new Font("Segoe UI", Font.BOLD, 45));
        labelTitulo.setBounds(49, 50, 193, 61);
        getContentPane().add(labelTitulo);

        labelMovimentacoes = new JLabel("Movimentações realizadas:");
        labelMovimentacoes.setFont(new Font("Segoe UI", Font.BOLD, 30));
        labelMovimentacoes.setBounds(49, 129, 378, 41);
        getContentPane().add(labelMovimentacoes);

        botaoVoltar = new JButton("Voltar");
        botaoVoltar.setFont(new Font("Segoe UI", Font.BOLD, 25));
        botaoVoltar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botaoVoltarActionPerformed(evt);
            }
        });
        getContentPane().add(botaoVoltar);
        botaoVoltar.setBounds(580, 460, 120, 41);

        Log_text = new JTextArea();
        Log_text.setColumns(20);
        Log_text.setFont(new Font("Segoe UI", Font.BOLD, 20));
        Log_text.setLineWrap(true);
        Log_text.setRows(5);
        Log_text.setBounds(34, 186, 680, 260);
        Log_text.setText(conteudoArquivo);
        getContentPane().add(Log_text);

        pack();
        setLocationRelativeTo(null);
        setResizable(false);
    }



    private void botaoVoltarActionPerformed(java.awt.event.ActionEvent evt) {
        // TODO add your handling code here:
        new TelaInicial().setVisible(true);
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
            java.util.logging.Logger.getLogger(Historico.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Historico.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Historico.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Historico.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Historico().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify
    private javax.swing.JButton botaoVoltar;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JTextArea Log_text;
    private JLabel labelTitulo;
    private JLabel labelMovimentacoes;


    // End of variables declaration
}
