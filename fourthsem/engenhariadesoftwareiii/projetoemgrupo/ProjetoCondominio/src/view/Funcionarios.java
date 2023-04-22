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
import javax.swing.JTextPane;
import javax.swing.border.EmptyBorder;
import model.Funcionario;
import model.Material;

public class Funcionarios extends JFrame {

  private JPanel contentPane;
  private JTextField txtNome;
  private JTextField txtCpf;
  private JTextField txtDataNasc;
  private JTextField txtRg;
  private JTextField txtId;
  private JTextField txtSal;
  private JTextField txtTurno;
  private JTextField txtID;

  public Funcionarios(ArrayList<Funcionario> funcionarios) {
    setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    setBounds(100, 100, 450, 364);
    contentPane = new JPanel();
    contentPane.setForeground(new Color(255, 255, 255));
    contentPane.setBackground(new Color(178, 34, 34));
    contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
    setContentPane(contentPane);
    contentPane.setLayout(null);

    JLabel lblFuncionros = new JLabel("Funcion\u00E1rios");
    lblFuncionros.setForeground(new Color(255, 255, 255));
    lblFuncionros.setBounds(187, 11, 72, 14);
    contentPane.add(lblFuncionros);

    JComboBox<Funcionario> cbFunc = new JComboBox<Funcionario>();
    cbFunc.setBounds(90, 47, 169, 22);
    contentPane.add(cbFunc);

    txtNome = new JTextField();
    txtNome.setColumns(10);
    txtNome.setBounds(90, 118, 100, 20);
    contentPane.add(txtNome);

    txtCpf = new JTextField();
    txtCpf.setColumns(10);
    txtCpf.setBounds(90, 153, 100, 20);
    contentPane.add(txtCpf);

    txtDataNasc = new JTextField();
    txtDataNasc.setColumns(10);
    txtDataNasc.setBounds(298, 118, 100, 20);
    contentPane.add(txtDataNasc);

    txtRg = new JTextField();
    txtRg.setColumns(10);
    txtRg.setBounds(90, 191, 100, 20);
    contentPane.add(txtRg);

    JRadioButton rbRece = new JRadioButton("Recepcionista");
    rbRece.setForeground(new Color(255, 255, 255));
    rbRece.setBackground(new Color(178, 34, 34));
    rbRece.setBounds(24, 250, 109, 23);
    contentPane.add(rbRece);

    JRadioButton rbAuxiliar = new JRadioButton(
      "Auxiliar de Manuten\u00E7\u00E3o"
    );
    rbAuxiliar.setForeground(new Color(255, 255, 255));
    rbAuxiliar.setBackground(new Color(178, 34, 34));
    rbAuxiliar.setBounds(138, 250, 137, 23);
    contentPane.add(rbAuxiliar);

    JRadioButton rbAlmoxarife = new JRadioButton("Almoxarife");
    rbAlmoxarife.setForeground(new Color(255, 255, 255));
    rbAlmoxarife.setBackground(new Color(178, 34, 34));
    rbAlmoxarife.setBounds(281, 250, 109, 23);
    contentPane.add(rbAlmoxarife);

    ButtonGroup group = new ButtonGroup();
    group.add(rbAuxiliar);
    group.add(rbAlmoxarife);
    group.add(rbRece);

    JLabel lblNewLabel_2_2_1 = new JLabel("RG");
    lblNewLabel_2_2_1.setForeground(new Color(255, 255, 255));
    lblNewLabel_2_2_1.setBounds(24, 194, 62, 14);
    contentPane.add(lblNewLabel_2_2_1);

    JLabel lblNewLabel_2_2 = new JLabel("Data Nasc");
    lblNewLabel_2_2.setForeground(new Color(255, 255, 255));
    lblNewLabel_2_2.setBounds(232, 121, 62, 14);
    contentPane.add(lblNewLabel_2_2);

    JLabel lblNewLabel_2_1 = new JLabel("CPF");
    lblNewLabel_2_1.setForeground(new Color(255, 255, 255));
    lblNewLabel_2_1.setBounds(24, 156, 46, 14);
    contentPane.add(lblNewLabel_2_1);

    JLabel lblNewLabel_2 = new JLabel("Nome");
    lblNewLabel_2.setForeground(new Color(255, 255, 255));
    lblNewLabel_2.setBounds(24, 121, 46, 14);
    contentPane.add(lblNewLabel_2);

    JLabel lblNewLabel_1 = new JLabel("Funcion\u00E1rios");
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

          for (int i = 0; i < funcionarios.size(); i++) {
            if (funcionarios.get(i).getIdFuncionario() == id) {
              txtID.setText(
                Integer.toString(funcionarios.get(i).getIdFuncionario())
              );
              txtNome.setText(funcionarios.get(i).getNome());
              txtSal.setText(Double.toString(funcionarios.get(i).getSalario()));
              txtTurno.setText(funcionarios.get(i).getTurno());
              txtRg.setText(Long.toString(funcionarios.get(i).getRg()));
              txtDataNasc.setText(funcionarios.get(i).getDataNasc());
              txtCpf.setText(funcionarios.get(i).getCpf());
              int tipo = funcionarios.get(i).getTipo();
              if (tipo == 1) {
                rbRece.setSelected(true);
              } else if (tipo == 2) {
                rbAuxiliar.setSelected(true);
              } else {
                rbAlmoxarife.setSelected(true);
              }
            }
          }
        }
      }
    );
    btnNewButton.setBounds(280, 76, 89, 23);
    contentPane.add(btnNewButton);

    JLabel lblNewLabel_3 = new JLabel("Sal\u00E1rio");
    lblNewLabel_3.setForeground(new Color(255, 255, 255));
    lblNewLabel_3.setBounds(232, 156, 64, 14);
    contentPane.add(lblNewLabel_3);

    JButton btnExcluir = new JButton("Excluir");
    btnExcluir.addActionListener(
      new ActionListener() {
        public void actionPerformed(ActionEvent e) {
          try {
            int id = Integer.parseInt(txtId.getText());

            for (int i = 0; i < funcionarios.size(); i++) {
              if (funcionarios.get(i).getIdFuncionario() == id) {
                funcionarios.remove(i);
                JOptionPane.showMessageDialog(null, "Funcionario deletado!");
                limpaCaixas();
                group.clearSelection();
                break;
              }
            }
          } catch (NullPointerException | NumberFormatException n) {
            JOptionPane.showMessageDialog(null, "Erro ao deletar!");
          }

          cbFunc.removeAllItems();
          for (Funcionario f : funcionarios) {
            cbFunc.addItem(f);
          }
        }
      }
    );
    btnExcluir.setBounds(321, 296, 89, 23);
    contentPane.add(btnExcluir);

    JButton btnCadastrar = new JButton("Cadastrar");
    btnCadastrar.addActionListener(
      new ActionListener() {
        public void actionPerformed(ActionEvent e) {
          int id = Integer.parseInt(txtID.getText());
          String nome = txtNome.getText();
          String dataNasc = txtDataNasc.getText();
          Long rg = Long.parseLong(txtRg.getText());
          double salario = Double.parseDouble(txtSal.getText());
          String cpf = txtCpf.getText();
          String turno = txtTurno.getText();
          int tipo = 0;

          if (rbRece.isSelected()) {
            tipo = 1;
          } else if (rbAuxiliar.isSelected()) {
            tipo = 2;
          } else if (rbAlmoxarife.isSelected()) {
            tipo = 3;
          }

          Funcionario funcionario = new Funcionario(
            nome,
            cpf,
            dataNasc,
            rg,
            id,
            salario,
            turno,
            tipo
          );
          funcionarios.add(funcionario);
          JOptionPane.showMessageDialog(null, "Funcionario adicionado! ");

          group.clearSelection();
          limpaCaixas();

          cbFunc.removeAllItems();
          for (Funcionario f : funcionarios) {
            cbFunc.addItem(f);
          }
        }
      }
    );
    btnCadastrar.setBounds(222, 296, 89, 23);
    contentPane.add(btnCadastrar);

    JButton btnAlterar = new JButton("Alterar");
    btnAlterar.addActionListener(
      new ActionListener() {
        public void actionPerformed(ActionEvent e) {
          int id = Integer.parseInt(txtID.getText());
          String nome = txtNome.getText();
          String dataNasc = txtDataNasc.getText();
          Long rg = Long.parseLong(txtRg.getText());
          double salario = Double.parseDouble(txtSal.getText());
          String cpf = txtCpf.getText();
          String turno = txtTurno.getText();
          int tipo = 0;

          if (rbRece.isSelected()) {
            tipo = 1;
          } else if (rbAuxiliar.isSelected()) {
            tipo = 2;
          } else {
            tipo = 3;
          }

          for (Funcionario m : funcionarios) {
            if (m.getIdFuncionario() == id) {
              m.setNome(nome);
              m.setDataNasc(dataNasc);
              m.setRg(rg);
              m.setSalario(salario);
              m.setCpf(cpf);
              m.setTurno(turno);
              m.setTipo(tipo);
              break;
            }
          }

          JOptionPane.showMessageDialog(null, "Funcionario atualizado!");
          group.clearSelection();
          limpaCaixas();

          cbFunc.removeAllItems();
          for (Funcionario m : funcionarios) {
            cbFunc.addItem(m);
          }
        }
      }
    );
    btnAlterar.setBounds(123, 296, 89, 23);
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
    btnSair.setBounds(24, 296, 89, 23);
    contentPane.add(btnSair);

    txtSal = new JTextField();
    txtSal.setColumns(10);
    txtSal.setBounds(298, 153, 100, 20);
    contentPane.add(txtSal);

    JLabel lblNewLabel_2_3 = new JLabel("Cargo");
    lblNewLabel_2_3.setForeground(new Color(255, 255, 255));
    lblNewLabel_2_3.setBounds(24, 229, 46, 14);
    contentPane.add(lblNewLabel_2_3);

    JLabel lblNewLabel_3_1 = new JLabel("Turno");
    lblNewLabel_3_1.setForeground(new Color(255, 255, 255));
    lblNewLabel_3_1.setBounds(232, 194, 46, 14);
    contentPane.add(lblNewLabel_3_1);

    txtTurno = new JTextField();
    txtTurno.setColumns(10);
    txtTurno.setBounds(298, 191, 100, 20);
    contentPane.add(txtTurno);

    JLabel lblNewLabel_2_4 = new JLabel("ID");
    lblNewLabel_2_4.setForeground(new Color(255, 255, 255));
    lblNewLabel_2_4.setBounds(24, 83, 46, 14);
    contentPane.add(lblNewLabel_2_4);

    txtID = new JTextField();
    txtID.setColumns(10);
    txtID.setBounds(90, 80, 100, 20);
    contentPane.add(txtID);
  }

  public void limpaCaixas() {
    txtId.setText("");
    txtID.setText("");
    txtNome.setText("");
    txtTurno.setText("");
    txtRg.setText("");
    txtCpf.setText("");
    txtDataNasc.setText("");
    txtSal.setText("");
  }
}
