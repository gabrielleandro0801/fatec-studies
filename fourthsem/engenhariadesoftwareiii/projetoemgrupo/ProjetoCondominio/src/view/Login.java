package view;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;
import model.Material;
import model.Visitante;
import util.Estilo;

public class Login extends JFrame {

  private JPanel contentPane;
  private JTextField txtCod;

  /**
   * Launch the application.
   */
  public static void main(String[] args) {
    EventQueue.invokeLater(
      new Runnable() {
        public void run() {
          try {
            Login frame = new Login();
            frame.setLocationRelativeTo(null);
            frame.setVisible(true);
          } catch (Exception e) {
            e.printStackTrace();
          }
        }
      }
    );
  }

  /**
   * Create the frame.
   */
  public Login() {
    Estilo.setaEstilo();

    setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    setBounds(100, 100, 230, 294);
    contentPane = new JPanel();
    contentPane.setBackground(new Color(178, 34, 34));
    contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
    setContentPane(contentPane);
    contentPane.setLayout(null);

    JRadioButton rbAdmin = new JRadioButton("Administra\u00E7\u00E3o");
    rbAdmin.setForeground(new Color(255, 255, 255));
    rbAdmin.setBackground(new Color(178, 34, 34));
    rbAdmin.setBounds(52, 58, 109, 23);
    contentPane.add(rbAdmin);

    JRadioButton rbRece = new JRadioButton("Recep\u00E7\u00E3o");
    rbRece.setForeground(new Color(255, 255, 255));
    rbRece.setBackground(new Color(178, 34, 34));
    rbRece.setBounds(52, 94, 109, 23);
    contentPane.add(rbRece);

    JRadioButton rbAlmox = new JRadioButton("Almoxarifado");
    rbAlmox.setForeground(new Color(255, 255, 255));
    rbAlmox.setBackground(new Color(178, 34, 34));
    rbAlmox.setBounds(52, 131, 109, 23);
    contentPane.add(rbAlmox);

    ButtonGroup group = new ButtonGroup();
    group.add(rbAdmin);
    group.add(rbAlmox);
    group.add(rbRece);

    JLabel lblNewLabel = new JLabel("C\u00F3digo de Acesso:");
    lblNewLabel.setForeground(new Color(255, 255, 255));
    lblNewLabel.setBackground(new Color(178, 34, 34));
    lblNewLabel.setBounds(10, 180, 103, 14);
    contentPane.add(lblNewLabel);

    txtCod = new JTextField();
    txtCod.setBounds(106, 177, 94, 20);
    contentPane.add(txtCod);
    txtCod.setColumns(10);

    JLabel lblNewLabel_1 = new JLabel("ClienteCondominio");
    lblNewLabel_1.setForeground(new Color(255, 255, 255));
    lblNewLabel_1.setBackground(new Color(178, 34, 34));
    lblNewLabel_1.setBounds(67, 11, 94, 14);
    contentPane.add(lblNewLabel_1);

    JButton btnAcessar = new JButton("Acessar");
    btnAcessar.addActionListener(
      new ActionListener() {
        public void actionPerformed(ActionEvent e) {
          if (rbAlmox.isSelected() && txtCod.getText().equals("123")) {
            ArrayList<Material> mat = new ArrayList<Material>();
            Almoxarifado a = new Almoxarifado(mat);
            dispose();
            a.setLocationRelativeTo(null);
            a.setVisible(true);
          } else if (rbAdmin.isSelected() && txtCod.getText().equals("123")) {
            Administracao adm = new Administracao();
            dispose();
            adm.setLocationRelativeTo(null);
            adm.setVisible(true);
          } else if (rbRece.isSelected() && txtCod.getText().equals("123")) {
            ArrayList<Visitante> visitantes = new ArrayList<Visitante>();
            Recepcao r = new Recepcao(visitantes);
            dispose();
            r.setLocationRelativeTo(null);
            r.setVisible(true);
          }
        }
      }
    );
    btnAcessar.setBounds(60, 217, 89, 23);
    contentPane.add(btnAcessar);
  }
}
