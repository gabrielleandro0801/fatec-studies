package view;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import model.Funcionario;
import model.Locador;
import model.Locatario;

public class Administracao extends JFrame {

  private JPanel contentPane;

  public Administracao() {
    setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    setBounds(100, 100, 220, 288);
    contentPane = new JPanel();
    contentPane.setBackground(new Color(178, 34, 34));
    contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
    setContentPane(contentPane);
    contentPane.setLayout(null);

    JLabel lblNewLabel = new JLabel("Administra\u00E7\u00E3o");
    lblNewLabel.setForeground(new Color(255, 255, 255));
    lblNewLabel.setBounds(72, 11, 75, 14);
    contentPane.add(lblNewLabel);

    JButton btnFunc = new JButton("Funcion\u00E1rios");
    btnFunc.addActionListener(
      new ActionListener() {
        public void actionPerformed(ActionEvent e) {
          ArrayList<Funcionario> funcionarios = new ArrayList<Funcionario>();
          Funcionarios f = new Funcionarios(funcionarios);
          f.setLocationRelativeTo(null);
          dispose();
          f.setVisible(true);
        }
      }
    );
    btnFunc.setBounds(30, 72, 143, 23);
    contentPane.add(btnFunc);

    JButton btnImoveis = new JButton("Im\u00F3veis & Negocia\u00E7\u00F5es");
    btnImoveis.addActionListener(
      new ActionListener() {
        public void actionPerformed(ActionEvent e) {
          Imoveis f = new Imoveis();
          f.setLocationRelativeTo(null);
          dispose();
          f.setVisible(true);
        }
      }
    );
    btnImoveis.setBounds(30, 106, 143, 23);
    contentPane.add(btnImoveis);

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
    btnSair.setBounds(30, 208, 143, 23);
    contentPane.add(btnSair);

    JButton btnLocador = new JButton("Locadores");
    btnLocador.addActionListener(
      new ActionListener() {
        public void actionPerformed(ActionEvent e) {
          ArrayList<Locador> locador = new ArrayList<Locador>();
          Locadores l = new Locadores(locador);
          l.setLocationRelativeTo(null);
          dispose();
          l.setVisible(true);
        }
      }
    );
    btnLocador.setBounds(30, 140, 143, 23);
    contentPane.add(btnLocador);

    JButton btnLocatarios = new JButton("Locat\u00E1rios");
    btnLocatarios.addActionListener(
      new ActionListener() {
        public void actionPerformed(ActionEvent e) {
          ArrayList<Locatario> locatarios = new ArrayList<Locatario>();
          Locatarios l = new Locatarios(locatarios);
          l.setLocationRelativeTo(null);
          dispose();
          l.setVisible(true);
        }
      }
    );
    btnLocatarios.setBounds(30, 174, 143, 23);
    contentPane.add(btnLocatarios);
  }
}
