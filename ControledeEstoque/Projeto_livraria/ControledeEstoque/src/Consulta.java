/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
import java.sql.*;
public class Consulta extends javax.swing.JFrame {
    private javax.swing.JButton Botao_buscar;

    private  javax.swing.JTextField ResultadoLabel;
    private javax.swing.JButton botaoVoltar;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JTextField jTextField1;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JTextArea jLabelResultado;

    public static void printSQLException(SQLException ex) {
        for (Throwable e : ex) {
            if (e instanceof SQLException) {
                e.printStackTrace(System.err);
                System.err.println("SQLState: " + ((SQLException) e).getSQLState());
                System.err.println("Error Code: " + ((SQLException) e).getErrorCode());
                System.err.println("Message: " + e.getMessage());
                Throwable t = ex.getCause();
                while (t != null) {
                    System.out.println("Cause: " + t);
                    t = t.getCause();
                }
            }
        }
    }

    public Consulta() {
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
        jLabel4 = new javax.swing.JLabel();
        ResultadoLabel = new javax.swing.JTextField();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Consulta");
        setMinimumSize(new java.awt.Dimension(750, 550));
        getContentPane().setLayout(null);

        jLabelResultado.setFont(new java.awt.Font("Segoe UI", 1, 15)); // NOI18N
        getContentPane().add(jLabelResultado);
        jLabelResultado.setBounds(90, 190, 540, 250);

        jLabel1.setFont(new java.awt.Font("Segoe UI", 1, 40)); // NOI18N
        jLabel1.setText("Consultar");
        getContentPane().add(jLabel1);
        jLabel1.setBounds(40, 34, 191, 54);

        jLabel2.setFont(new java.awt.Font("Segoe UI", 1, 35)); // NOI18N
        jLabel2.setText("Produto");
        getContentPane().add(jLabel2);
        jLabel2.setBounds(40, 106, 135, 47);

        jLabel4.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel4.setText("Resultados");
        getContentPane().add(jLabel4);
        jLabel4.setBounds(470, 40, 120, 40);

        jTextField1.setFont(new java.awt.Font("Segoe UI", 2, 14)); // NOI18N
        jTextField1.setHorizontalAlignment(javax.swing.JTextField.LEFT);
        jTextField1.setToolTipText("");
        jTextField1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField1ActionPerformed(evt);
            }
        });
        getContentPane().add(jTextField1);
        jTextField1.setBounds(193, 124, 284, 33);

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

        ResultadoLabel.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        ResultadoLabel.setVerifyInputWhenFocusTarget(false);
        getContentPane().add(ResultadoLabel);
        ResultadoLabel.setBounds(580, 50, 80, 30);

        pack();
        setResizable(false);
        setLocationRelativeTo(null);
    }// </editor-fold>

    private void jTextField1ActionPerformed(java.awt.event.ActionEvent evt) {
        // TODO add your handling code here:
    }

    private void Botao_buscarActionPerformed(java.awt.event.ActionEvent evt) {
        ConexaoBanco conexao = new ConexaoBanco();
        try {Connection connection = DriverManager.getConnection(conexao.getUrl(),conexao.getUser(),conexao.getPassword());

            String termoBusca = jTextField1.getText();

            String query = "SELECT * FROM cadastro WHERE nome LIKE '%" + termoBusca + "%'";

            PreparedStatement preparedStatement = connection.prepareStatement(query);
            ResultSet resultSet = preparedStatement.executeQuery();

            StringBuilder resultado = new StringBuilder();
            int contador = 0;


            while (resultSet.next()) {
                int id = resultSet.getInt("id_cadastro");
                String nome = resultSet.getString("nome");
                double preco = resultSet.getDouble("quantidade");
                Date data = resultSet.getDate("dta");

                resultado.append("Id do produto: ").append(id).append("\n");
                resultado.append("Nome: ").append(nome).append("\n");
                resultado.append("Quantidade: ").append(preco).append("\n");
                resultado.append("Data do cadastro: ").append(data).append(" \n");
                contador++;

            }
            jLabelResultado.setText(resultado.toString());
            ResultadoLabel.setText(String.valueOf(contador));
            resultSet.close();
            preparedStatement.close();
            connection.close();


        } catch (SQLException e) {
            printSQLException(e);
        }
    }

    private void botaoVoltarActionPerformed(java.awt.event.ActionEvent evt) {

        new TelaInicial().setVisible(true);
        dispose();
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
            java.util.logging.Logger.getLogger(Consulta.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Consulta.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Consulta.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Consulta.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Consulta().setVisible(true);
            }
        });
    }
}
