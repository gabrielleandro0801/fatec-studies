package view;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;
import model.Locador;
import model.Locador;

public class Locadores extends JFrame {

  private JPanel contentPane;
  private JTextField txtNome;
  private JTextField txtCpf;
  private JTextField txtDataNasc;
  private JTextField txtRg;
  private JTextField txtId;
  private JTextField txtDataAquisicao;
  private JTextField txtID;

  public Locadores(ArrayList<Locador> locadores) {
    setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    setBounds(100, 100, 450, 316);
    contentPane = new JPanel();
    contentPane.setBackground(new Color(178, 34, 34));
    contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
    setContentPane(contentPane);
    contentPane.setLayout(null);

    JLabel lblFuncionros = new JLabel("Locadores");
    lblFuncionros.setForeground(new Color(255, 255, 255));
    lblFuncionros.setBounds(187, 11, 72, 14);
    contentPane.add(lblFuncionros);

    JComboBox<Locador> cbFunc = new JComboBox<Locador>();
    cbFunc.setBounds(90, 47, 169, 22);
    contentPane.add(cbFunc);

    txtNome = new JTextField();
    txtNome.setColumns(10);
    txtNome.setBounds(90, 156, 100, 20);
    contentPane.add(txtNome);

    txtCpf = new JTextField();
    txtCpf.setColumns(10);
    txtCpf.setBounds(90, 191, 100, 20);
    contentPane.add(txtCpf);

    txtDataNasc = new JTextField();
    txtDataNasc.setColumns(10);
    txtDataNasc.setBounds(300, 156, 100, 20);
    contentPane.add(txtDataNasc);

    txtRg = new JTextField();
    txtRg.setColumns(10);
    txtRg.setBounds(300, 118, 100, 20);
    contentPane.add(txtRg);

    JLabel lblNewLabel_2_2_1 = new JLabel("RG");
    lblNewLabel_2_2_1.setForeground(new Color(255, 255, 255));
    lblNewLabel_2_2_1.setBounds(222, 121, 62, 14);
    contentPane.add(lblNewLabel_2_2_1);

    JLabel lblNewLabel_2_2 = new JLabel("Data Nasc");
    lblNewLabel_2_2.setForeground(new Color(255, 255, 255));
    lblNewLabel_2_2.setBounds(222, 159, 62, 14);
    contentPane.add(lblNewLabel_2_2);

    JLabel lblNewLabel_2_1 = new JLabel("CPF");
    lblNewLabel_2_1.setForeground(new Color(255, 255, 255));
    lblNewLabel_2_1.setBounds(24, 194, 46, 14);
    contentPane.add(lblNewLabel_2_1);

    JLabel lblNewLabel_2 = new JLabel("Nome");
    lblNewLabel_2.setForeground(new Color(255, 255, 255));
    lblNewLabel_2.setBounds(24, 159, 46, 14);
    contentPane.add(lblNewLabel_2);

    JLabel lblNewLabel_1 = new JLabel("Locadores");
    lblNewLabel_1.setForeground(new Color(255, 255, 255));
    lblNewLabel_1.setBounds(24, 51, 62, 14);
    contentPane.add(lblNewLabel_1);

    JLabel lblNewLabel_1_1 = new JLabel("Buscar por ID");
    lblNewLabel_1_1.setForeground(new Color(255, 255, 255));
    lblNewLabel_1_1.setBounds(269, 51, 72, 14);
    contentPane.add(lblNewLabel_1_1);

    txtId = new JTextField();
    txtId.setColumns(10);
    txtId.setBounds(348, 48, 62, 20);
    contentPane.add(txtId);

    JButton btnNewButton = new JButton("Buscar");
    btnNewButton.addActionListener(
      new ActionListener() {
        public void actionPerformed(ActionEvent e) {
          int id = Integer.parseInt(txtId.getText());

          for (int i = 0; i < locadores.size(); i++) {
            if (locadores.get(i).getIdLocador() == id) {
              txtID.setText(Integer.toString(locadores.get(i).getIdLocador()));
              txtNome.setText(locadores.get(i).getNome());
              txtRg.setText(Long.toString(locadores.get(i).getRg()));
              txtDataNasc.setText(locadores.get(i).getDataNasc());
              txtCpf.setText(locadores.get(i).getCpf());
              txtDataAquisicao.setText(
                locadores.get(i).getDataAquisicaoImovel()
              );
            }
          }
        }
      }
    );
    btnNewButton.setBounds(280, 76, 89, 23);
    contentPane.add(btnNewButton);

    JLabel lblNewLabel_3 = new JLabel("Data Aquisi\u00E7\u00E3o");
    lblNewLabel_3.setForeground(new Color(255, 255, 255));
    lblNewLabel_3.setBounds(222, 194, 79, 14);
    contentPane.add(lblNewLabel_3);

    JButton btnExcluir = new JButton("Excluir");
    btnExcluir.addActionListener(
      new ActionListener() {
        public void actionPerformed(ActionEvent e) {
          try {
            int id = Integer.parseInt(txtId.getText());

            for (int i = 0; i < locadores.size(); i++) {
              if (locadores.get(i).getIdLocador() == id) {
                locadores.remove(i);
                JOptionPane.showMessageDialog(null, "Locador deletado!");
                limpaCaixas();
                break;
              }
            }
          } catch (NullPointerException | NumberFormatException n) {
            JOptionPane.showMessageDialog(null, "Erro ao deletar!");
          }

          cbFunc.removeAllItems();
          for (Locador f : locadores) {
            cbFunc.addItem(f);
          }
        }
      }
    );
    btnExcluir.setBounds(321, 244, 89, 23);
    contentPane.add(btnExcluir);

    JButton btnCadastrar = new JButton("Cadastrar");
    btnCadastrar.addActionListener(
      new ActionListener() {
        public void actionPerformed(ActionEvent e) {
          int id = Integer.parseInt(txtID.getText());
          String nome = txtNome.getText();
          String dataNasc = txtDataNasc.getText();
          Long rg = Long.parseLong(txtRg.getText());
          String cpf = txtCpf.getText();
          String dataAquisicao = txtDataAquisicao.getText();

          Locador Locador = new Locador(
            nome,
            cpf,
            dataNasc,
            rg,
            id,
            dataAquisicao
          );
          locadores.add(Locador);
          JOptionPane.showMessageDialog(null, "Locador adicionado! ");

          limpaCaixas();

          cbFunc.removeAllItems();
          for (Locador f : locadores) {
            cbFunc.addItem(f);
          }
        }
      }
    );
    btnCadastrar.setBounds(222, 244, 89, 23);
    contentPane.add(btnCadastrar);

    JButton btnAlterar = new JButton("Alterar");
    btnAlterar.addActionListener(
      new ActionListener() {
        public void actionPerformed(ActionEvent e) {
          int id = Integer.parseInt(txtID.getText());
          String nome = txtNome.getText();
          String dataNasc = txtDataNasc.getText();
          Long rg = Long.parseLong(txtRg.getText());
          String dataAquisicao = txtDataAquisicao.getText();
          String cpf = txtCpf.getText();

          for (Locador m : locadores) {
            if (m.getIdLocador() == id) {
              m.setNome(nome);
              m.setDataNasc(dataNasc);
              m.setRg(rg);
              m.setCpf(cpf);
              m.setDataAquisicaoImovel(dataAquisicao);
              break;
            }
          }

          JOptionPane.showMessageDialog(null, "Locador atualizado!");
          limpaCaixas();

          cbFunc.removeAllItems();
          for (Locador m : locadores) {
            cbFunc.addItem(m);
          }
        }
      }
    );
    btnAlterar.setBounds(123, 244, 89, 23);
    contentPane.add(btnAlterar);

    JButton btnSair = new JButton("Sair");
    btnSair.addActionListener(
      new ActionListener() {
        public void actionPerformed(ActionEvent e) {
          Administracao adm = new Administracao();
          adm.setLocationRelativeTo(null);
          dispose();
          adm.setVisible(true);
        }
      }
    );
    btnSair.setBounds(24, 244, 89, 23);
    contentPane.add(btnSair);

    txtDataAquisicao = new JTextField();
    txtDataAquisicao.setColumns(10);
    txtDataAquisicao.setBounds(300, 191, 100, 20);
    contentPane.add(txtDataAquisicao);

    JLabel lblNewLabel_2_4 = new JLabel("ID");
    lblNewLabel_2_4.setForeground(new Color(255, 255, 255));
    lblNewLabel_2_4.setBounds(24, 121, 46, 14);
    contentPane.add(lblNewLabel_2_4);

    txtID = new JTextField();
    txtID.setColumns(10);
    txtID.setBounds(90, 118, 100, 20);
    contentPane.add(txtID);
  }

  public void limpaCaixas() {
    txtId.setText("");
    txtID.setText("");
    txtNome.setText("");
    txtRg.setText("");
    txtCpf.setText("");
    txtDataNasc.setText("");
    txtDataAquisicao.setText("");
  }
}
