package view;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;
import model.Material;

public class Almoxarifado extends JFrame {

  private JPanel contentPane;
  private JTextField txtNome;
  private JTextField txtId;
  private JTextField txtTipo;
  private JTextField txtQtd;
  private JTextField txtID;

  public Almoxarifado(ArrayList<Material> mat) {
    setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    setBounds(100, 100, 421, 322);
    contentPane = new JPanel();
    contentPane.setBackground(new Color(178, 34, 34));
    contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
    setContentPane(contentPane);
    contentPane.setLayout(null);

    JLabel lblNewLabel = new JLabel("Materiais");
    lblNewLabel.setForeground(new Color(255, 255, 255));
    lblNewLabel.setBounds(188, 11, 46, 14);
    contentPane.add(lblNewLabel);

    JComboBox<Material> cbMateriais = new JComboBox<Material>();
    cbMateriais.setBounds(63, 48, 150, 22);
    contentPane.add(cbMateriais);

    JLabel lblNewLabel_1 = new JLabel("Materiais");
    lblNewLabel_1.setForeground(new Color(255, 255, 255));
    lblNewLabel_1.setBounds(10, 52, 46, 14);
    contentPane.add(lblNewLabel_1);

    JLabel lblNewLabel_2 = new JLabel("Nome");
    lblNewLabel_2.setForeground(new Color(255, 255, 255));
    lblNewLabel_2.setBounds(10, 133, 46, 14);
    contentPane.add(lblNewLabel_2);

    JLabel lblNewLabel_2_1 = new JLabel("Tipo");
    lblNewLabel_2_1.setForeground(new Color(255, 255, 255));
    lblNewLabel_2_1.setBounds(10, 168, 46, 14);
    contentPane.add(lblNewLabel_2_1);

    JLabel lblNewLabel_2_2 = new JLabel("Quantidade");
    lblNewLabel_2_2.setForeground(new Color(255, 255, 255));
    lblNewLabel_2_2.setBounds(10, 200, 62, 14);
    contentPane.add(lblNewLabel_2_2);

    txtNome = new JTextField();
    txtNome.setBounds(76, 130, 100, 20);
    contentPane.add(txtNome);
    txtNome.setColumns(10);

    JLabel lblNewLabel_1_1 = new JLabel("Buscar por ID");
    lblNewLabel_1_1.setForeground(new Color(255, 255, 255));
    lblNewLabel_1_1.setBounds(235, 52, 72, 14);
    contentPane.add(lblNewLabel_1_1);

    txtId = new JTextField();
    txtId.setColumns(10);
    txtId.setBounds(310, 49, 86, 20);
    contentPane.add(txtId);

    JButton btnNewButton = new JButton("Buscar");
    btnNewButton.addActionListener(
      new ActionListener() {
        public void actionPerformed(ActionEvent e) {
          int id = Integer.parseInt(txtId.getText());

          for (int i = 0; i < mat.size(); i++) {
            if (mat.get(i).getIdMaterial() == id) {
              txtID.setText(Integer.toString(mat.get(i).getIdMaterial()));
              txtNome.setText(mat.get(i).getNomeMaterial());
              txtTipo.setText(mat.get(i).getTipoMaterial());
              txtQtd.setText(Integer.toString(mat.get(i).getQuantidade()));
            }
          }
        }
      }
    );
    btnNewButton.setBounds(266, 77, 89, 23);
    contentPane.add(btnNewButton);

    txtTipo = new JTextField();
    txtTipo.setColumns(10);
    txtTipo.setBounds(76, 165, 100, 20);
    contentPane.add(txtTipo);

    txtQtd = new JTextField();
    txtQtd.setColumns(10);
    txtQtd.setBounds(76, 197, 100, 20);
    contentPane.add(txtQtd);

    JButton btnAlterar = new JButton("Alterar");
    btnAlterar.addActionListener(
      new ActionListener() {
        public void actionPerformed(ActionEvent e) {
          int id = Integer.parseInt(txtId.getText());
          String nome = txtNome.getText();
          String tipo = txtTipo.getText();
          int qtd = Integer.parseInt(txtQtd.getText());

          for (Material m : mat) {
            if (m.getIdMaterial() == id) {
              m.setNomeMaterial(nome);
              m.setQuantidade(qtd);
              m.setTipoMaterial(tipo);
              break;
            }
          }

          limpaCaixas();
          JOptionPane.showMessageDialog(null, "Material atualizado!");

          cbMateriais.removeAllItems();
          for (Material m : mat) {
            cbMateriais.addItem(m);
          }
        }
      }
    );
    btnAlterar.setBounds(109, 249, 89, 23);
    contentPane.add(btnAlterar);

    JButton btnCadastrar = new JButton("Cadastrar");
    btnCadastrar.addActionListener(
      new ActionListener() {
        public void actionPerformed(ActionEvent e) {
          int id = Integer.parseInt(txtID.getText());
          String nome = txtNome.getText();
          String tipo = txtTipo.getText();
          int qtd = Integer.parseInt(txtQtd.getText());
          Material material = new Material(id, tipo, nome, qtd);
          mat.add(material);
          JOptionPane.showMessageDialog(null, "Material adicionado!");
          limpaCaixas();

          cbMateriais.removeAllItems();
          for (Material m : mat) {
            cbMateriais.addItem(m);
          }
        }
      }
    );
    btnCadastrar.setBounds(208, 249, 89, 23);
    contentPane.add(btnCadastrar);

    JButton btnExcluir = new JButton("Excluir");
    btnExcluir.addActionListener(
      new ActionListener() {
        public void actionPerformed(ActionEvent e) {
          int id = Integer.parseInt(txtId.getText());

          for (int i = 0; i < mat.size(); i++) {
            if (mat.get(i).getIdMaterial() == id) {
              mat.remove(i);
              limpaCaixas();

              JOptionPane.showMessageDialog(null, "Material deletado!");
              break;
            }
          }

          cbMateriais.removeAllItems();
          for (Material m : mat) {
            cbMateriais.addItem(m);
          }
        }
      }
    );
    btnExcluir.setBounds(307, 249, 89, 23);
    contentPane.add(btnExcluir);

    JButton btnSair = new JButton("Sair");
    btnSair.addActionListener(
      new ActionListener() {
        public void actionPerformed(ActionEvent e) {
          Login l = new Login();
          l.setLocationRelativeTo(null);
          dispose();
          l.setVisible(true);
        }
      }
    );
    btnSair.setBounds(10, 249, 89, 23);
    contentPane.add(btnSair);

    txtID = new JTextField();
    txtID.setColumns(10);
    txtID.setBounds(76, 96, 100, 20);
    contentPane.add(txtID);

    JLabel lblNewLabel_2_3 = new JLabel("ID");
    lblNewLabel_2_3.setForeground(new Color(255, 255, 255));
    lblNewLabel_2_3.setBounds(10, 99, 46, 14);
    contentPane.add(lblNewLabel_2_3);
  }

  public void limpaCaixas() {
    txtId.setText("");
    txtID.setText("");
    txtNome.setText("");
    txtQtd.setText("");
    txtTipo.setText("");
  }
}
