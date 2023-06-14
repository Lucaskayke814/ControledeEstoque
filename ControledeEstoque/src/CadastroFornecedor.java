import javax.swing.*;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.math.BigInteger;

import static java.lang.Integer.parseInt;

/**
 *
 * @author Windows
 */
public class CadastroFornecedor extends javax.swing.JFrame {

    private javax.swing.JLabel CadastrarFornecedor;
    private javax.swing.JTextField Nome_Fornecedor;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JTextField jTextField1;
    private javax.swing.JButton botaoSalvar;
    private javax.swing.JButton botaoVoltar;



    private void writeErrorsToFile(String errorMessage) {
        try (PrintWriter writer = new PrintWriter(new FileWriter("erros.txt", true))) {
            writer.println(errorMessage);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    private void writeErrorsToFiles(String cadastros) {
        try (PrintWriter writer = new PrintWriter(new FileWriter("cadastros.txt", true))) {
            writer.println(cadastros);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


    public void printSQLException(SQLException ex) {
        for (Throwable e : ex) {
            if (e instanceof SQLException) {
                String errorMessage = "SQLState: " + ((SQLException) e).getSQLState()
                        + "\nError Code: " + ((SQLException) e).getErrorCode()
                        + "\nMessage: " + e.getMessage() + "\n-----------------------------------------";
                writeErrorsToFile(errorMessage);

                Throwable t = ex.getCause();
                while (t != null) {
                    System.out.println("Cause: " + t+ " \n-----------------------------------------");
                    t = t.getCause();
                }
            }
        }
    }
    public CadastroFornecedor() {
        initComponents();


    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">
    private void initComponents() {

        CadastrarFornecedor = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        Nome_Fornecedor = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        jTextField1 = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        botaoSalvar = new javax.swing.JButton();
        botaoVoltar = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setBackground(new java.awt.Color(255, 255, 255));
        setMinimumSize(new java.awt.Dimension(750, 550));
        getContentPane().setLayout(null);

        CadastrarFornecedor.setFont(new java.awt.Font("Segoe UI", 1, 40)); // NOI18N
        CadastrarFornecedor.setText("Cadastrar Fornecedor");
        getContentPane().add(CadastrarFornecedor);
        CadastrarFornecedor.setBounds(30, 50, 600, 54);

        jLabel1.setFont(new java.awt.Font("Segoe UI", 1, 30)); // NOI18N
        jLabel1.setText("Nome do Fornecedor :");
        getContentPane().add(jLabel1);
        jLabel1.setBounds(30, 150, 340, 50);

        Nome_Fornecedor.setFont(new java.awt.Font("Segoe UI", 1, 13)); // NOI18N
        Nome_Fornecedor.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Nome_FornecedorActionPerformed(evt);
            }
        });
        getContentPane().add(Nome_Fornecedor);
        Nome_Fornecedor.setBounds(360, 150, 350, 40);

        jLabel2.setFont(new java.awt.Font("Segoe UI", 1, 30)); // NOI18N
        jLabel2.setText("CNPJ :");
        getContentPane().add(jLabel2);
        jLabel2.setBounds(30, 230, 180, 50);

        jTextField1.setFont(new java.awt.Font("Segoe UI", 1, 13)); // NOI18N
        getContentPane().add(jTextField1);
        jTextField1.setBounds(210, 232, 500, 40);



        botaoSalvar.setFont(new java.awt.Font("Segoe UI", 1, 20)); // NOI18N
        botaoSalvar.setText("Salvar");
        botaoSalvar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                try {
                    botaoSalvarActionPerformed(evt);
                } catch (SQLException e) {
                    throw new RuntimeException(e);
                }
            }
        });
        getContentPane().add(botaoSalvar);
        botaoSalvar.setBounds(410, 351, 112, 43);

        botaoVoltar.setFont(new java.awt.Font("Segoe UI", 1, 20)); // NOI18N
        botaoVoltar.setText("Voltar");
        botaoVoltar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botaoVoltarActionPerformed(evt);
            }
        });
        getContentPane().add(botaoVoltar);
        botaoVoltar.setBounds(564, 351, 116, 43);

        jLabel3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagens/tela1.jpg"))); // NOI18N
        getContentPane().add(jLabel3);
        jLabel3.setBounds(0, 0, 730, 510);

        pack();
        setResizable(false);
        setLocationRelativeTo(null);
    }// </editor-fold>

    private void Nome_FornecedorActionPerformed(java.awt.event.ActionEvent evt) {
        // TODO add your handling code here:
    }
    private void botaoVoltarActionPerformed(java.awt.event.ActionEvent evt) {

        new TelaInicial().setVisible(true);
        dispose();
        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
    }
    private void botaoSalvarActionPerformed(java.awt.event.ActionEvent evt) throws SQLException {


        ConexaoBanco conexao = new ConexaoBanco();

        String strNome = Nome_Fornecedor.getText();
        String strCnpj= jTextField1.getText();
        strCnpj = strCnpj.replaceAll("[.\\-/]", "");

        try{


            try (Connection connection = DriverManager.getConnection(conexao.getUrl(), conexao.getUser(), conexao.getPassword());
                 PreparedStatement preparedStatement = connection.prepareStatement(conexao.getInserir_Fornecedor())) {

                preparedStatement.setString(1, strNome);
                preparedStatement.setString(2, strCnpj);

                System.out.println(preparedStatement);
                writeErrorsToFiles("Novo Fornecedor cadastrado :Nome do fornecedor: "+strNome+"\nCNPJ : "+strCnpj+"\n-----------------------------------");
                JOptionPane.showMessageDialog(null, "Fornecedor cadastrado!!!", "Situação do cadastro", JOptionPane.INFORMATION_MESSAGE);


                preparedStatement.executeUpdate();
                Nome_Fornecedor.setText("");
                jTextField1.setText("");

        } catch (SQLException e) {
            printSQLException(e);
                JOptionPane.showMessageDialog(null, "Por favor, preencha todos os campos corretamente", "Erro", JOptionPane.ERROR_MESSAGE);

            }
    } catch (NumberFormatException e) {
        String errorMessage = "NumberFormatException: " + e.getMessage() +"\n-----------------------------------------";
        writeErrorsToFile(errorMessage);
        e.printStackTrace();
            JOptionPane.showMessageDialog(null, "Por favor, preencha todos os campos corretamente", "Erro", JOptionPane.ERROR_MESSAGE);

        }
}





}
