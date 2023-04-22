package view;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

public class Imoveis extends JFrame {

  private JPanel contentPane;
  private JTextField textField;
  private JTextField textField_1;
  private JTextField textField_2;

  public Imoveis() {
    setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    setBounds(100, 100, 450, 419);
    contentPane = new JPanel();
    contentPane.setBackground(new Color(178, 34, 34));
    contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
    setContentPane(contentPane);
    contentPane.setLayout(null);

    JLabel lblImveis = new JLabel("Im\u00F3veis");
    lblImveis.setForeground(new Color(255, 255, 255));
    lblImveis.setBounds(190, 11, 52, 14);
    contentPane.add(lblImveis);

    JComboBox cbLocatarios = new JComboBox();
    cbLocatarios.setModel(
      new DefaultComboBoxModel(
        new String[] { "1 - Jose Silva", "2 - Gabriel Sousa" }
      )
    );
    cbLocatarios.setBounds(120, 52, 189, 22);
    contentPane.add(cbLocatarios);

    JLabel lblNewLabel = new JLabel("Locatarios");
    lblNewLabel.setForeground(new Color(255, 255, 255));
    lblNewLabel.setBounds(120, 36, 66, 14);
    contentPane.add(lblNewLabel);

    JComboBox cbLocadores = new JComboBox();
    cbLocadores.setModel(
      new DefaultComboBoxModel(
        new String[] { "1 - Henrique Silva", "2 - Matheus Silva" }
      )
    );
    cbLocadores.setBounds(120, 101, 189, 22);
    contentPane.add(cbLocadores);

    JLabel lblLocadores = new JLabel("Locadores");
    lblLocadores.setForeground(new Color(255, 255, 255));
    lblLocadores.setBounds(120, 85, 66, 14);
    contentPane.add(lblLocadores);

    JLabel Imoveis = new JLabel("Imoveis");
    Imoveis.setForeground(new Color(255, 255, 255));
    Imoveis.setBounds(120, 134, 66, 14);
    contentPane.add(Imoveis);

    JComboBox cbImoveis = new JComboBox();
    cbImoveis.setModel(
      new DefaultComboBoxModel(
        new String[] {
          "1 | 1\u00BA andar | n\u00BA 9",
          "2 | 1\u00BA andar | n\u00BA 8",
          "3 | 2\u00BA andar | n\u00BA 10",
        }
      )
    );
    cbImoveis.setBounds(120, 150, 189, 22);
    contentPane.add(cbImoveis);

    JLabel lblRealizarNegocio = new JLabel("Realizar negocio");
    lblRealizarNegocio.setForeground(new Color(255, 255, 255));
    lblRealizarNegocio.setBounds(176, 196, 87, 14);
    contentPane.add(lblRealizarNegocio);

    textField = new JTextField();
    textField.setBounds(136, 232, 58, 20);
    contentPane.add(textField);
    textField.setColumns(10);

    JLabel lblNewLabel_1 = new JLabel("ID Locador");
    lblNewLabel_1.setForeground(new Color(255, 255, 255));
    lblNewLabel_1.setBounds(69, 235, 66, 14);
    contentPane.add(lblNewLabel_1);

    JLabel lblNewLabel_1_1 = new JLabel("ID Locatario");
    lblNewLabel_1_1.setForeground(new Color(255, 255, 255));
    lblNewLabel_1_1.setBounds(69, 273, 66, 14);
    contentPane.add(lblNewLabel_1_1);

    textField_1 = new JTextField();
    textField_1.setColumns(10);
    textField_1.setBounds(136, 270, 58, 20);
    contentPane.add(textField_1);

    JLabel lblNewLabel_1_1_1 = new JLabel("ID Imovel");
    lblNewLabel_1_1_1.setForeground(new Color(255, 255, 255));
    lblNewLabel_1_1_1.setBounds(69, 310, 66, 14);
    contentPane.add(lblNewLabel_1_1_1);

    textField_2 = new JTextField();
    textField_2.setColumns(10);
    textField_2.setBounds(136, 307, 58, 20);
    contentPane.add(textField_2);

    JButton btnFinalizarNegocio = new JButton("Finalizar Negocio");
    btnFinalizarNegocio.addActionListener(
      new ActionListener() {
        public void actionPerformed(ActionEvent e) {
          JOptionPane.showMessageDialog(
            null,
            "Negocio finalizado com sucesso!"
          );
        }
      }
    );
    btnFinalizarNegocio.setBounds(204, 231, 123, 42);
    contentPane.add(btnFinalizarNegocio);

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
    btnSair.setBounds(163, 346, 110, 23);
    contentPane.add(btnSair);

    JButton btnCancelarNegocio = new JButton("Cancelar Negocio");
    btnCancelarNegocio.addActionListener(
      new ActionListener() {
        public void actionPerformed(ActionEvent e) {
          JOptionPane.showMessageDialog(null, "Negocio desfeito com sucesso!");
        }
      }
    );
    btnCancelarNegocio.setBounds(204, 286, 123, 42);
    contentPane.add(btnCancelarNegocio);
  }
}
