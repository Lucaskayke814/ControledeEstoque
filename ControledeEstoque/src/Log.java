
import javax.swing.*;
import java.awt.*;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class Log extends javax.swing.JFrame {
    private javax.swing.JButton botaoVoltar;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JTextArea Log_text;
    private JLabel labelTitulo;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollBar jScrollBar1;


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

    String conteudoArquivo = lerArquivoTexto("erros.txt");


    public Log() {
        initComponents();
    }


    @SuppressWarnings("unchecked")
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        botaoVoltar = new javax.swing.JButton();
        jLabel3 = new javax.swing.JLabel();
        Log_text = new javax.swing.JTextArea();
        jScrollPane1 = new javax.swing.JScrollPane();
        jScrollBar1 = new javax.swing.JScrollBar();



        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setTitle("Histórico");
        setPreferredSize(new java.awt.Dimension(750, 550));
        getContentPane().setLayout(null);

        labelTitulo = new JLabel("Log");
        labelTitulo.setFont(new Font("Segoe UI", Font.BOLD, 55));
        labelTitulo.setBounds(60, 60, 210, 80);
        getContentPane().add(labelTitulo);

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
        Log_text.setRows(5);
        Log_text.setText(conteudoArquivo);
        Log_text.setWrapStyleWord(true);
        Log_text.setLineWrap(true);
        jScrollPane1.setViewportView(Log_text);

        getContentPane().add(jScrollPane1);
        jScrollPane1.setBounds(34, 186, 680, 260);

        jScrollBar1.setBounds(600, 190, 10, 210);

        pack();
        setLocationRelativeTo(null);
        setResizable(false);

        jLabel3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagens/tela1.jpg"))); // NOI18N
        getContentPane().add(jLabel3);
        jLabel3.setBounds(0, 0, 730, 510);


    }


    private void botaoVoltarActionPerformed(java.awt.event.ActionEvent evt) {

        new TelaInicial().setVisible(true);
        dispose();
    }
}


