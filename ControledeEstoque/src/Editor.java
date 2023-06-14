import javax.swing.*;
import java.sql.*;

import static javax.swing.JOptionPane.showInputDialog;

public class Editor extends javax.swing.JFrame {
    ConexaoBanco conexao = new ConexaoBanco();
    private javax.swing.JButton Voltar_button;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JTextField jTextField1;
    private javax.swing.JTextArea jLabelResultado;
    private javax.swing.JButton Botao_buscar;
    private javax.swing.JButton Editar_button;


    public Editor() {
        initComponents();
    }


    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        Voltar_button = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabelResultado =  new javax.swing.JTextArea();
        jTextField1 = new javax.swing.JTextField();
        Botao_buscar = new javax.swing.JButton();
        Editar_button = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Editor");
        setMaximumSize(new java.awt.Dimension(750, 550));
        setMinimumSize(new java.awt.Dimension(750, 550));
        setPreferredSize(new java.awt.Dimension(750, 550));
        getContentPane().setLayout(null);

        jLabelResultado.setFont(new java.awt.Font("Segoe UI", 1, 15)); // NOI18N
        getContentPane().add(jLabelResultado);
        jLabelResultado.setBounds(90, 190, 540, 250);

        jLabel3.setFont(new java.awt.Font("Segoe UI", 1, 30)); // NOI18N
        jLabel3.setText("ID Produto");
        getContentPane().add(jLabel3);
        jLabel3.setBounds(30, 110, 190, 41);



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


        Editar_button.setFont(new java.awt.Font("Segoe UI", 1, 25)); // NOI18N
        Editar_button.setText("Editar");
        Editar_button.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Editar_buttonActionPerformed(evt);
            }
        });
        getContentPane().add(Editar_button);
        Editar_button.setBounds(40, 450, 150, 40);



        jLabel1.setFont(new java.awt.Font("Segoe UI", 1, 48)); // NOI18N
        jLabel1.setText("Editar Produto");
        getContentPane().add(jLabel1);
        jLabel1.setBounds(42, 28, 410, 64);

        Voltar_button.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        Voltar_button.setText("Voltar");
        Voltar_button.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Voltar_buttonActionPerformed(evt);
            }
        });
        getContentPane().add(Voltar_button);
        Voltar_button.setBounds(490, 450, 150, 40);



        jLabel2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagens/tela1.jpg"))); // NOI18N
        getContentPane().add(jLabel2);
        jLabel2.setBounds(-3, -4, 750, 550);

        pack();
        setLocationRelativeTo(null);
        setResizable(false);
    }// </editor-fold>
    public void Botao_buscarActionPerformed(java.awt.event.ActionEvent evt) {
        try {
            Connection connection = DriverManager.getConnection(conexao.getUrl(), conexao.getUser(), conexao.getPassword());

            String termoBusca = jTextField1.getText();

            // Constrói a consulta SQL com a cláusula LIKE para busca parcial
            String query = "SELECT * FROM produto WHERE id_produto = '" + termoBusca + "'";

            PreparedStatement preparedStatement = connection.prepareStatement(query);
            ResultSet resultSet = preparedStatement.executeQuery();

            StringBuilder resultado = new StringBuilder();


            // Itera sobre os resultados da consulta
            while (resultSet.next()) {
                int id = resultSet.getInt("id_produto");
                String nome = resultSet.getString("nome_produto");
                double quantidade = resultSet.getDouble("quantidade");
                double preco = resultSet.getDouble("valor");
                Date data = resultSet.getDate("dta");

                resultado.append("Id do produto: ").append(id).append("\n");
                resultado.append("Nome: ").append(nome).append("\n");
                resultado.append("Quantidade: ").append(quantidade).append("\n");
                resultado.append("Preço: ").append(preco).append("\n");
                resultado.append("Data do cadastro: ").append(data).append(" \n");


            }
            jLabelResultado.setText(resultado.toString());
            resultSet.close();
            preparedStatement.close();
            connection.close();


        } catch (SQLException e) {
            Consulta.printSQLException(e);
        }
    }

    private void Editar_buttonActionPerformed(java.awt.event.ActionEvent evt) {
        String termoBusca = jTextField1.getText();
       int editar = Integer.parseInt(showInputDialog(null, "1 : Editar nome do produto \n"+ "2 : Editar preço\n"+ "3 : Editar quantidade do produto","Editar produto",JOptionPane.QUESTION_MESSAGE));

             if(editar == 1){
                String NovoNome = showInputDialog("Qual sera o novo nome do produto?");
                 String Editar_nome = "update produto set nome_produto = ' "+ NovoNome+" ' where id_produto = "+ termoBusca+";";

                 try(Connection connection = DriverManager.getConnection(conexao.getUrl(), conexao.getUser(), conexao.getPassword());
                     PreparedStatement preparedStatement = connection.prepareStatement(Editar_nome)){
                     System.out.println(preparedStatement);

                     preparedStatement.executeUpdate();
                     jTextField1.setText("");
                     jLabelResultado.setText("");
                     connection.close();

                 }catch (SQLException e) {
                     Consulta.printSQLException(e);
                 }
             }
             if (editar == 2 ){
                float NovoPreco = Float.parseFloat(showInputDialog("Qual sera o novo preço do produto?"));
                 String Editar_preco = "update produto set valor = ' "+ NovoPreco+" ' where id_produto = "+ termoBusca+";";

                 try(Connection connection = DriverManager.getConnection(conexao.getUrl(), conexao.getUser(), conexao.getPassword());
                     PreparedStatement preparedStatement = connection.prepareStatement(Editar_preco)){
                     System.out.println(preparedStatement);

                     preparedStatement.executeUpdate();
                     jTextField1.setText("");
                     jLabelResultado.setText("");
                     connection.close();

                 }catch (SQLException e) {
                     Consulta.printSQLException(e);
                 }


             }
             if (editar == 3){
                 int NovaQuantidade = Integer.parseInt(showInputDialog("Qual sera a nova quantidade do produto?"));
                 String Editar_quantidade = "update produto set quantidade = ' "+  NovaQuantidade+" ' where id_produto = "+ termoBusca+";";

                 try(Connection connection = DriverManager.getConnection(conexao.getUrl(), conexao.getUser(), conexao.getPassword());
                     PreparedStatement preparedStatement = connection.prepareStatement(Editar_quantidade)){
                     System.out.println(preparedStatement);

                     preparedStatement.executeUpdate();
                     jTextField1.setText("");
                     jLabelResultado.setText("");
                     connection.close();

                 }catch (SQLException e) {
                     Consulta.printSQLException(e);
                 }


             }
    }


    private void jTextField1ActionPerformed(java.awt.event.ActionEvent evt) {
        // TODO add your handling code here:
    }

    private void Voltar_buttonActionPerformed(java.awt.event.ActionEvent evt) {
        new TelaInicial().setVisible(true);
        dispose();
    }

    }
