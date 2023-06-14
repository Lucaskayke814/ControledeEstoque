/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */


import javax.swing.*;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.*;

/**
 *
 * @author Windows
 */
public class DeletarProduto extends javax.swing.JFrame {

ConexaoBanco conexao = new ConexaoBanco();
    private void writeErrorsToFile(String errorMessage) {
        try (PrintWriter writer = new PrintWriter(new FileWriter("erros.txt", true))) {
            writer.println(errorMessage);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    private void writeErrorsToFiles(String Erros) {
        try (PrintWriter writer = new PrintWriter(new FileWriter("cadastros.txt", true))) {
            writer.println(Erros);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }



    public void printSQLException(SQLException ex) {
        for (Throwable e : ex) {
            if (e instanceof SQLException) {
                e.printStackTrace(System.err);
                String errorMessage = "SQLState: " + ((SQLException) e).getSQLState()
                        + "\nError Code: " + ((SQLException) e).getErrorCode()
                        + "\nMessage: " + e.getMessage();
                writeErrorsToFile(errorMessage);

                Throwable t = ex.getCause();
                while (t != null) {
                    System.out.println("Cause: " + t);
                    t = t.getCause();
                }
            }
        }
    }

    private static final String DELETE_USERS_SQL = "delete from cadastro where id_cadastro = ?;";



    public DeletarProduto() {
        initComponents();
    }


    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jLabelResultado =  new javax.swing.JTextArea();
        jLabel2 = new javax.swing.JLabel();
        jTextField1 = new javax.swing.JTextField();
        Botao_buscar = new javax.swing.JButton();
        botaoVoltar = new javax.swing.JButton();
        jLabel3 = new javax.swing.JLabel();
        Deletar_button = new javax.swing.JButton();


        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Deletar Produto");
        setMinimumSize(new java.awt.Dimension(750, 550));
        getContentPane().setLayout(null);

        jLabelResultado.setFont(new java.awt.Font("Segoe UI", 1, 15)); // NOI18N
        getContentPane().add(jLabelResultado);
        jLabelResultado.setBounds(90, 190, 540, 250);

        jLabel1.setFont(new java.awt.Font("Segoe UI", 1, 40)); // NOI18N
        jLabel1.setText("Deletar Produto");
        getContentPane().add(jLabel1);
        jLabel1.setBounds(40, 34, 400, 54);

        jLabel2.setFont(new java.awt.Font("Segoe UI", 1, 30)); // NOI18N
        jLabel2.setText("ID Produto");
        getContentPane().add(jLabel2);
        jLabel2.setBounds(30, 110, 190, 41);

        Deletar_button.setFont(new java.awt.Font("Segoe UI", 1, 25)); // NOI18N
        Deletar_button.setText("Deletar");
        Deletar_button.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Deletar_buttonActionPerformed(evt);
            }
        });
        getContentPane().add(Deletar_button);
        Deletar_button.setBounds(40, 450, 150, 40);



        jTextField1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField1ActionPerformed(evt);
            }
        });
        getContentPane().add(jTextField1);
        jTextField1.setBounds(250, 110, 220, 39);

        Botao_buscar.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        Botao_buscar.setText("Buscar");
        Botao_buscar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Botao_buscarActionPerformed(evt);
            }
        });
        getContentPane().add(Botao_buscar);
        Botao_buscar.setBounds(551, 120, 136, 37);

        botaoVoltar.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        botaoVoltar.setText("Voltar");
        botaoVoltar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botaoVoltarActionPerformed(evt);
            }
        });
        getContentPane().add(botaoVoltar);
        botaoVoltar.setBounds(560, 460, 150, 40);

        jLabel3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagens/tela1.jpg"))); // NOI18N
        getContentPane().add(jLabel3);
        jLabel3.setBounds(-3, -4, 740, 520);



        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>

    private void jTextField1ActionPerformed(java.awt.event.ActionEvent evt) {
        // TODO add your handling code here:
    }

    private void Botao_buscarActionPerformed(java.awt.event.ActionEvent evt) {
        try {
            Connection connection = DriverManager.getConnection(conexao.getUrl(), conexao.getUser(), conexao.getPassword());

            String termoBusca = jTextField1.getText();

            // Constrói a consulta SQL com a cláusula LIKE para busca parcial
            String query = "SELECT * FROM cadastro WHERE id_cadastro = '" + termoBusca + "'";

            PreparedStatement preparedStatement = connection.prepareStatement(query);
            ResultSet resultSet = preparedStatement.executeQuery();

            StringBuilder resultado = new StringBuilder();


            // Itera sobre os resultados da consulta
            while (resultSet.next()) {
                int id = resultSet.getInt("id_cadastro");
                String nome = resultSet.getString("nome");
                double preco = resultSet.getDouble("quantidade");
                Date data = resultSet.getDate("dta");

                resultado.append("Id do produto: ").append(id).append("\n");
                resultado.append("Nome: ").append(nome).append("\n");
                resultado.append("Quantidade: ").append(preco).append("\n");
                resultado.append("Data do cadastro: ").append(data).append(" \n");


            }
            jLabelResultado.setText(resultado.toString());
            resultSet.close();
            preparedStatement.close();
            connection.close();


        } catch (SQLException e) {
            printSQLException(e);
        }
    }
    private void Deletar_buttonActionPerformed(java.awt.event.ActionEvent evt) {
        int resposta = JOptionPane.showOptionDialog(null, "Deseja continuar?", "Confirmação",
                JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE, null, null, null);

        if (resposta == JOptionPane.YES_OPTION) {
            String id = jTextField1.getText();
            try(Connection connection = DriverManager.getConnection(conexao.getUrl(), conexao.getUser(), conexao.getPassword());
            PreparedStatement preparedStatement = connection.prepareStatement(DELETE_USERS_SQL)) {

                preparedStatement.setInt(1, Integer.parseInt(id));

                writeErrorsToFiles("O Produto com id: "+ id+" ,Deletado com sucesso!!");
                System.out.println(preparedStatement);

                preparedStatement.executeUpdate();
                jTextField1.setText("");
                jLabelResultado.setText("");
                connection.close();

            }catch (SQLException e) {
                printSQLException(e);
            }
        }
    }


    private void botaoVoltarActionPerformed(java.awt.event.ActionEvent evt) {
        // TODO add your handling code here:
        new TelaInicial().setVisible(true);
        dispose();
    }

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
            java.util.logging.Logger.getLogger(Consulta.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Consulta.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Consulta.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Consulta.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new DeletarProduto().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify
    private javax.swing.JButton Botao_buscar;


    private javax.swing.JButton botaoVoltar;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JTextField jTextField1;
    private javax.swing.JButton Deletar_button;
    private javax.swing.JTextArea jLabelResultado;
    // End of variables declaration
}
