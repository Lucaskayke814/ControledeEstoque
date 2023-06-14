import javax.swing.*;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.*;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;



/**
 *
 * @author Windows
 */
public class Cadastro extends javax.swing.JFrame {

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

    public Cadastro() {
        initComponents();
    }


    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jTextField2 = new javax.swing.JTextField();
        jTextField3 = new javax.swing.JTextField();
        jTextField4 = new javax.swing.JTextField();
        jTextField5 = new javax.swing.JTextField();
        botaoSalvar = new javax.swing.JButton();
        botaoVoltar = new javax.swing.JButton();
        jLabel7 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setBackground(new java.awt.Color(255, 255, 255));
        setMinimumSize(new java.awt.Dimension(750, 550));
        getContentPane().setLayout(null);

        jLabel1.setFont(new java.awt.Font("Segoe UI", 1, 45)); // NOI18N
        jLabel1.setText("Cadastrar");
        getContentPane().add(jLabel1);
        jLabel1.setBounds(35, 6, 218, 87);



        jLabel3.setFont(new java.awt.Font("Segoe UI", 1, 25)); // NOI18N
        jLabel3.setText("Nome:");
        getContentPane().add(jLabel3);
        jLabel3.setBounds(35, 99, 79, 34);

        jLabel4.setFont(new java.awt.Font("Segoe UI", 1, 25)); // NOI18N
        jLabel4.setText("Quantidade (entrada) : ");
        getContentPane().add(jLabel4);
        jLabel4.setBounds(35, 151, 272, 34);

        jLabel5.setFont(new java.awt.Font("Segoe UI", 1, 25)); // NOI18N
        jLabel5.setText("Valor Unitário :");
        getContentPane().add(jLabel5);
        jLabel5.setBounds(35, 203, 178, 34);

        jLabel6.setFont(new java.awt.Font("Segoe UI", 1, 25)); // NOI18N
        jLabel6.setText("Data:");
        getContentPane().add(jLabel6);
        jLabel6.setBounds(35, 255, 61, 34);


        getContentPane().add(jTextField2);
        jTextField2.setBounds(144, 110, 562, 22);
        getContentPane().add(jTextField3);
        jTextField3.setBounds(313, 162, 393, 22);
        getContentPane().add(jTextField4);
        jTextField4.setBounds(231, 214, 475, 22);
        getContentPane().add(jTextField5);
        jTextField5.setBounds(102, 266, 79, 22);

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

        jLabel7.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagens/tela1.jpg"))); // NOI18N
        jLabel7.setMinimumSize(new java.awt.Dimension(770, 650));
        getContentPane().add(jLabel7);
        jLabel7.setBounds(0, 0, 740, 530);

        pack();
        setResizable(false);
        setLocationRelativeTo(null);
    }



    private void botaoVoltarActionPerformed(java.awt.event.ActionEvent evt) {

        new TelaInicial().setVisible(true);
dispose();
        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
    }
    private void botaoSalvarActionPerformed(java.awt.event.ActionEvent evt) throws SQLException {
        ConexaoBanco conexao = new ConexaoBanco();

        String strNome = jTextField2.getText();
        String strQtd = jTextField3.getText();
        String strValor = jTextField4.getText();
        String strData = jTextField5.getText();

        try {
            int Qtd = Integer.parseInt(strQtd);
            float Valor = Float.parseFloat(strValor);

            String formato = "dd-MM-yyyy";
            DateTimeFormatter formatter = DateTimeFormatter.ofPattern(formato);

            LocalDate localDate = LocalDate.parse(strData, formatter);
            Date date = java.sql.Date.valueOf(localDate);

            try (Connection connection = DriverManager.getConnection(conexao.getUrl(), conexao.getUser(), conexao.getPassword());
                 PreparedStatement preparedStatement = connection.prepareStatement(conexao.getInserir_produto())) {

                preparedStatement.setString(1, strNome);
                preparedStatement.setInt(2, Qtd);
                preparedStatement.setFloat(3, Valor);
                preparedStatement.setDate(4, date);

                System.out.println(preparedStatement);
                writeErrorsToFiles("Novo produto cadastrado :Nome do produto: "+strNome+"\nQuantidade: "+Qtd+"\n Valor: "+Valor+"\n Data: "+date);
                JOptionPane.showMessageDialog(null, "Produto cadastrado!!!", "Situação do cadastro", JOptionPane.INFORMATION_MESSAGE);


                preparedStatement.executeUpdate();


                jTextField2.setText("");
                jTextField3.setText("");
                jTextField4.setText("");
                jTextField5.setText("");

                connection.close();
            } catch (SQLException e) {
                printSQLException(e);
            }
        } catch (NumberFormatException e) {
            String errorMessage = "NumberFormatException: " + e.getMessage();
            writeErrorsToFile(errorMessage);
            e.printStackTrace();
            JOptionPane.showMessageDialog(null, "Por favor, preencha todos os campos corretamente", "Erro", JOptionPane.ERROR_MESSAGE);
        }
    }

    public static void main(String args[]) {

        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Windows".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(Cadastro.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Cadastro.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Cadastro.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Cadastro.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }

        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Cadastro().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify

    private javax.swing.JButton botaoSalvar;
    private javax.swing.JButton botaoVoltar;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JTextField jTextField2;
    private javax.swing.JTextField jTextField3;
    private javax.swing.JTextField jTextField4;
    private javax.swing.JTextField jTextField5;
    // End of variables declaration
}
