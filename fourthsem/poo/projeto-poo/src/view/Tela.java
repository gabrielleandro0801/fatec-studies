package view;

import control.ConnectionFactory;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.ParseException;
import javax.swing.JButton;
import javax.swing.JFormattedTextField;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;
import javax.swing.text.MaskFormatter;
import javax.swing.text.MaskFormatter;
import model.Produto;
import util.Estilo;

public class Tela extends JFrame {

  private JPanel contentPane;
  private JTextField txtID;
  private JTextField txtNome;
  private JTextField txtPreco;
  private JFormattedTextField txtDataValidade;
  MaskFormatter data;

  public static void main(String[] args) {
    EventQueue.invokeLater(
      new Runnable() {
        public void run() {
          try {
            JOptionPane.showMessageDialog(
              null,
              "Bem vindo ao sistema!\nEste sistema tera como funcao ajudar no gerenciamento de estoque de uma mercearia chamado Mercearia Palestra!",
              "Mensagem",
              JOptionPane.INFORMATION_MESSAGE
            );
            Tela frame = new Tela();
            frame.setLocationRelativeTo(null);
            frame.setVisible(true);
          } catch (Exception e) {
            e.printStackTrace();
          }
        }
      }
    );
  }

  public Tela() {
    Estilo.setaEstilo();

    ConnectionFactory conexaoBanco = new ConnectionFactory();
    conexaoBanco.conectar();
    if (!conexaoBanco.estaConectado()) {
      JOptionPane.showMessageDialog(
        null,
        "Erro ao conectar ao Banco de Dados MySQL!",
        "Erro",
        JOptionPane.ERROR_MESSAGE
      );
    }

    setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    setBounds(100, 100, 521, 274);
    contentPane = new JPanel();
    contentPane.setBackground(new Color(0, 102, 51));
    contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
    setContentPane(contentPane);
    contentPane.setLayout(null);

    try {
      data = new MaskFormatter("##/##/####");
      data.setValidCharacters("0123456789");
    } catch (ParseException e) {
      e.printStackTrace();
    }

    JLabel lblNewLabel = new JLabel("Mercearia Palestra");
    lblNewLabel.setBackground(Color.WHITE);
    lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
    lblNewLabel.setBounds(133, 11, 250, 30);
    contentPane.add(lblNewLabel);
    lblNewLabel.setFont(new Font("MV Boli", Font.PLAIN, 28));
    lblNewLabel.setForeground(Color.WHITE);

    JButton btnCadastrarProduto = new JButton("Cadastrar Produto");
    btnCadastrarProduto.addActionListener(
      new ActionListener() {
        public void actionPerformed(ActionEvent e) {
          if (
            txtID.getText().equals("") ||
            txtPreco.getText().equals("") ||
            txtDataValidade.getText().equals("") ||
            txtNome.getText().equals("")
          ) {
            JOptionPane.showMessageDialog(
              null,
              "Preencha todos os campos!",
              "Erro",
              JOptionPane.ERROR_MESSAGE
            );
            return;
          }

          Produto produto = new Produto(
            Integer.parseInt(txtID.getText()),
            txtNome.getText(),
            Double.parseDouble(txtPreco.getText()),
            txtDataValidade.getText()
          );

          int status = conexaoBanco.cadastrarProduto(produto);
          if (status == 1) {
            JOptionPane.showMessageDialog(
              null,
              "Produto cadastrado com sucesso!",
              "Sucesso",
              JOptionPane.INFORMATION_MESSAGE
            );
          } else {
            JOptionPane.showMessageDialog(
              null,
              "Erro ao cadastrar produto!",
              "Erro",
              JOptionPane.ERROR_MESSAGE
            );
          }
          limparCaixas();
        }
      }
    );
    btnCadastrarProduto.setBounds(360, 101, 131, 30);
    contentPane.add(btnCadastrarProduto);

    JButton btnAlterarProduto = new JButton("Alterar Produto");
    btnAlterarProduto.addActionListener(
      new ActionListener() {
        public void actionPerformed(ActionEvent e) {
          if (
            txtID.getText().equals("") ||
            txtPreco.getText().equals("") ||
            txtDataValidade.getText().equals("") ||
            txtNome.getText().equals("")
          ) {
            JOptionPane.showMessageDialog(
              null,
              "Preencha todos os campos!",
              "Erro",
              JOptionPane.ERROR_MESSAGE
            );
            return;
          }

          Produto produto = new Produto(
            Integer.parseInt(txtID.getText()),
            txtNome.getText(),
            Double.parseDouble(txtPreco.getText()),
            txtDataValidade.getText()
          );

          int status = conexaoBanco.alterarProduto(produto);
          if (status == 1) {
            JOptionPane.showMessageDialog(
              null,
              "Produto alterado com sucesso!",
              "Sucesso",
              JOptionPane.INFORMATION_MESSAGE
            );
          } else {
            JOptionPane.showMessageDialog(
              null,
              "Erro ao alterar produto!",
              "Erro",
              JOptionPane.ERROR_MESSAGE
            );
          }
          limparCaixas();
        }
      }
    );
    btnAlterarProduto.setBounds(360, 183, 131, 30);
    contentPane.add(btnAlterarProduto);

    JButton btnExcluirProduto = new JButton("Excluir Produto");
    btnExcluirProduto.addActionListener(
      new ActionListener() {
        public void actionPerformed(ActionEvent e) {
          if (txtID.getText().equals("")) {
            JOptionPane.showMessageDialog(
              null,
              "Digite o ID do produto!",
              "Erro",
              JOptionPane.ERROR_MESSAGE
            );
            return;
          }

          int status = conexaoBanco.excluirProduto(
            Integer.parseInt(txtID.getText())
          );
          if (status == 1) {
            JOptionPane.showMessageDialog(
              null,
              "Produto excluido com sucesso!",
              "Sucesso",
              JOptionPane.INFORMATION_MESSAGE
            );
          } else {
            JOptionPane.showMessageDialog(
              null,
              "Erro ao excluir produto!",
              "Erro",
              JOptionPane.ERROR_MESSAGE
            );
          }
          limparCaixas();
        }
      }
    );
    btnExcluirProduto.setBounds(360, 142, 131, 30);
    contentPane.add(btnExcluirProduto);

    JButton btnBuscarProduto = new JButton("Buscar Produto");
    btnBuscarProduto.addActionListener(
      new ActionListener() {
        public void actionPerformed(ActionEvent e) {
          if (txtID.getText().equals("")) {
            JOptionPane.showMessageDialog(
              null,
              "Digite o ID do produto!",
              "Erro",
              JOptionPane.ERROR_MESSAGE
            );
            return;
          }

          Produto produto = conexaoBanco.consultarProduto(
            Integer.parseInt(txtID.getText())
          );
          if (produto.getId() == 0) {
            JOptionPane.showMessageDialog(
              null,
              "Nao ha algum produto cadastrado com esse ID!",
              "Erro",
              JOptionPane.ERROR_MESSAGE
            );
          } else {
            txtID.setText(Integer.toString(produto.getId()));
            txtNome.setText(produto.getNome());
            txtPreco.setText(Double.toString(produto.getPreco()));
            txtDataValidade.setText(produto.getDataValidade());
          }
        }
      }
    );
    btnBuscarProduto.setBounds(360, 60, 131, 30);
    contentPane.add(btnBuscarProduto);

    JLabel lblId = new JLabel("ID");
    lblId.setFont(new Font("Tahoma", Font.PLAIN, 16));
    lblId.setHorizontalAlignment(SwingConstants.RIGHT);
    lblId.setForeground(Color.WHITE);
    lblId.setBounds(61, 66, 46, 14);
    contentPane.add(lblId);

    JLabel lblNome = new JLabel("Nome");
    lblNome.setFont(new Font("Tahoma", Font.PLAIN, 16));
    lblNome.setHorizontalAlignment(SwingConstants.RIGHT);
    lblNome.setForeground(Color.WHITE);
    lblNome.setBounds(61, 109, 46, 14);
    contentPane.add(lblNome);

    JLabel lblDataValidade = new JLabel("Data Validade");
    lblDataValidade.setFont(new Font("Tahoma", Font.PLAIN, 16));
    lblDataValidade.setHorizontalAlignment(SwingConstants.RIGHT);
    lblDataValidade.setForeground(Color.WHITE);
    lblDataValidade.setBounds(10, 148, 97, 24);
    contentPane.add(lblDataValidade);

    JLabel lblPreco = new JLabel("Pre\u00E7o (R$)");
    lblPreco.setFont(new Font("Tahoma", Font.PLAIN, 16));
    lblPreco.setHorizontalAlignment(SwingConstants.RIGHT);
    lblPreco.setForeground(Color.WHITE);
    lblPreco.setBounds(0, 194, 107, 19);
    contentPane.add(lblPreco);

    txtID = new JTextField();
    txtID.setFont(new Font("Tahoma", Font.PLAIN, 16));
    txtID.setBounds(133, 61, 189, 24);
    contentPane.add(txtID);
    txtID.setColumns(10);

    txtNome = new JTextField();
    txtNome.setFont(new Font("Tahoma", Font.PLAIN, 16));
    txtNome.setColumns(10);
    txtNome.setBounds(133, 102, 189, 24);
    contentPane.add(txtNome);

    txtDataValidade = new JFormattedTextField(data);
    txtDataValidade.setFont(new Font("Tahoma", Font.PLAIN, 16));
    txtDataValidade.setColumns(10);
    txtDataValidade.setBounds(133, 145, 189, 24);
    contentPane.add(txtDataValidade);

    txtPreco = new JTextField();
    txtPreco.setFont(new Font("Tahoma", Font.PLAIN, 16));
    txtPreco.setColumns(10);
    txtPreco.setBounds(133, 189, 189, 24);
    contentPane.add(txtPreco);
  }

  public void limparCaixas() {
    this.txtID.setText("");
    this.txtNome.setText("");
    this.txtDataValidade.setText("");
    this.txtPreco.setText("");
  }
}
