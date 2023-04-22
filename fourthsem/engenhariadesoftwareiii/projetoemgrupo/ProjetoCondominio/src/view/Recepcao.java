package view;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.JTextPane;
import javax.swing.border.EmptyBorder;
import model.Material;
import model.Visitante;

public class Recepcao extends JFrame {

  private JPanel contentPane;
  private JTextField txtId;
  private JTextField txtDataNasc;
  private JTextField txtCPF;
  private JTextField txtNome;
  private JTextField txtRG;
  private JTextField txtID;
  private JTextField txtMotivo;

  public Recepcao(ArrayList<Visitante> visitantes) {
    setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    setBounds(100, 100, 419, 346);
    contentPane = new JPanel();
    contentPane.setBackground(new Color(178, 34, 34));
    contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
    setContentPane(contentPane);
    contentPane.setLayout(null);

    JComboBox<Visitante> cbVisitante = new JComboBox<Visitante>();
    cbVisitante.setBounds(63, 48, 150, 22);
    contentPane.add(cbVisitante);

    JLabel lblNewLabel = new JLabel("Recep\u00E7\u00E3o");
    lblNewLabel.setForeground(new Color(255, 255, 255));
    lblNewLabel.setBounds(188, 11, 57, 14);
    contentPane.add(lblNewLabel);

    JLabel lblNewLabel_1 = new JLabel("Visitantes");
    lblNewLabel_1.setForeground(new Color(255, 255, 255));
    lblNewLabel_1.setBounds(10, 51, 46, 14);
    contentPane.add(lblNewLabel_1);

    JLabel lblNewLabel_1_1 = new JLabel("Buscar por ID");
    lblNewLabel_1_1.setForeground(new Color(255, 255, 255));
    lblNewLabel_1_1.setBounds(235, 51, 72, 14);
    contentPane.add(lblNewLabel_1_1);

    txtId = new JTextField();
    txtId.setColumns(10);
    txtId.setBounds(310, 48, 86, 20);
    contentPane.add(txtId);

    JButton btnBuscar = new JButton("Buscar");
    btnBuscar.addActionListener(
      new ActionListener() {
        public void actionPerformed(ActionEvent e) {
          int id = Integer.parseInt(txtId.getText());

          for (int i = 0; i < visitantes.size(); i++) {
            if (visitantes.get(i).getIdVisitante() == id) {
              txtID.setText(
                Integer.toString(visitantes.get(i).getIdVisitante())
              );
              txtNome.setText(visitantes.get(i).getNome());
              txtDataNasc.setText(visitantes.get(i).getDataNasc());
              txtCPF.setText(visitantes.get(i).getCpf());
              txtRG.setText(Long.toString(visitantes.get(i).getRg()));
              txtMotivo.setText(visitantes.get(i).getMotivo());
            }
          }
        }
      }
    );
    btnBuscar.setBounds(266, 76, 89, 23);
    contentPane.add(btnBuscar);

    JLabel lblNewLabel_2 = new JLabel("Nome");
    lblNewLabel_2.setForeground(new Color(255, 255, 255));
    lblNewLabel_2.setBounds(10, 133, 46, 14);
    contentPane.add(lblNewLabel_2);

    JLabel lblNewLabel_2_1 = new JLabel("CPF");
    lblNewLabel_2_1.setForeground(new Color(255, 255, 255));
    lblNewLabel_2_1.setBounds(10, 168, 46, 14);
    contentPane.add(lblNewLabel_2_1);

    JLabel lblNewLabel_2_2 = new JLabel("Data Nasc");
    lblNewLabel_2_2.setForeground(new Color(255, 255, 255));
    lblNewLabel_2_2.setBounds(10, 200, 62, 14);
    contentPane.add(lblNewLabel_2_2);

    txtDataNasc = new JTextField();
    txtDataNasc.setColumns(10);
    txtDataNasc.setBounds(76, 197, 100, 20);
    contentPane.add(txtDataNasc);

    txtCPF = new JTextField();
    txtCPF.setColumns(10);
    txtCPF.setBounds(76, 165, 100, 20);
    contentPane.add(txtCPF);

    txtNome = new JTextField();
    txtNome.setColumns(10);
    txtNome.setBounds(76, 130, 100, 20);
    contentPane.add(txtNome);

    JButton btnAlterar = new JButton("Alterar");
    btnAlterar.addActionListener(
      new ActionListener() {
        public void actionPerformed(ActionEvent e) {
          int id = Integer.parseInt(txtId.getText());
          String nome = txtNome.getText();
          String cpf = txtCPF.getText();
          String dtNasc = txtDataNasc.getText();
          Long rg = Long.parseLong(txtRG.getText());
          String motivo = txtMotivo.getText();

          for (Visitante f : visitantes) {
            if (f.getIdVisitante() == id) {
              f.setNome(nome);
              f.setCpf(cpf);
              f.setDataNasc(dtNasc);
              f.setRg(rg);
              f.setMotivo(motivo);
              break;
            }
          }

          limpaCaixas();
          JOptionPane.showMessageDialog(null, "Visitante atualizado!");

          cbVisitante.removeAllItems();
          for (Visitante v : visitantes) {
            cbVisitante.addItem(v);
          }
        }
      }
    );
    btnAlterar.setBounds(109, 273, 89, 23);
    contentPane.add(btnAlterar);

    JButton btnCadastrar = new JButton("Cadastrar");
    btnCadastrar.addActionListener(
      new ActionListener() {
        public void actionPerformed(ActionEvent e) {
          int id = Integer.parseInt(txtID.getText());
          String nome = txtNome.getText();
          String cpf = txtCPF.getText();
          String dtNasc = txtDataNasc.getText();
          Long rg = Long.parseLong(txtRG.getText());
          String motivo = txtMotivo.getText();
          Visitante visitante = new Visitante(
            nome,
            cpf,
            dtNasc,
            rg,
            id,
            motivo
          );
          visitantes.add(visitante);
          JOptionPane.showMessageDialog(null, "Visitante adicionado!");
          limpaCaixas();

          cbVisitante.removeAllItems();
          for (Visitante v : visitantes) {
            cbVisitante.addItem(v);
          }
        }
      }
    );
    btnCadastrar.setBounds(208, 273, 89, 23);
    contentPane.add(btnCadastrar);

    JButton btnExcluir = new JButton("Excluir");
    btnExcluir.addActionListener(
      new ActionListener() {
        public void actionPerformed(ActionEvent e) {
          int id = Integer.parseInt(txtId.getText());

          for (int i = 0; i < visitantes.size(); i++) {
            if (visitantes.get(i).getIdVisitante() == id) {
              visitantes.remove(i);
              limpaCaixas();
              JOptionPane.showMessageDialog(null, "Visitante deletado!");
              break;
            }
          }

          cbVisitante.removeAllItems();
          for (Visitante v : visitantes) {
            cbVisitante.addItem(v);
          }
        }
      }
    );
    btnExcluir.setBounds(307, 273, 89, 23);
    contentPane.add(btnExcluir);

    JLabel lblNewLabel_2_2_1 = new JLabel("RG");
    lblNewLabel_2_2_1.setForeground(new Color(255, 255, 255));
    lblNewLabel_2_2_1.setBounds(10, 231, 62, 14);
    contentPane.add(lblNewLabel_2_2_1);

    txtRG = new JTextField();
    txtRG.setColumns(10);
    txtRG.setBounds(76, 228, 100, 20);
    contentPane.add(txtRG);

    JLabel lblNewLabel_3 = new JLabel("Motivo Visita");
    lblNewLabel_3.setForeground(new Color(255, 255, 255));
    lblNewLabel_3.setBounds(208, 168, 64, 14);
    contentPane.add(lblNewLabel_3);

    JButton btnSair = new JButton("Sair");
    btnSair.addActionListener(
      new ActionListener() {
        public void actionPerformed(ActionEvent e) {
          Login l = new Login();
          dispose();
          l.setLocationRelativeTo(null);
          l.setVisible(true);
        }
      }
    );
    btnSair.setBounds(10, 273, 89, 23);
    contentPane.add(btnSair);

    txtID = new JTextField();
    txtID.setColumns(10);
    txtID.setBounds(76, 95, 100, 20);
    contentPane.add(txtID);

    JLabel lblNewLabel_2_3 = new JLabel("ID");
    lblNewLabel_2_3.setForeground(new Color(255, 255, 255));
    lblNewLabel_2_3.setBounds(10, 98, 46, 14);
    contentPane.add(lblNewLabel_2_3);

    txtMotivo = new JTextField();
    txtMotivo.setBounds(208, 183, 150, 20);
    contentPane.add(txtMotivo);
    txtMotivo.setColumns(10);
  }

  public void limpaCaixas() {
    txtId.setText("");
    txtID.setText("");
    txtNome.setText("");
    txtCPF.setText("");
    txtDataNasc.setText("");
    txtRG.setText("");
    txtMotivo.setText("");
  }
}
