import javax.swing.JOptionPane;

public class TestaMedico {

  public static void main(String[] args) {
    String nome, cpf, dataNascimento, crm, especialidade;

    nome = JOptionPane.showInputDialog(null, "Informe o Nome");
    cpf = JOptionPane.showInputDialog(null, "Informe o CPF");
    dataNascimento = JOptionPane.showInputDialog(null, "Informe a Data de Nascimento");
    crm = JOptionPane.showInputDialog(null, "Informe a CRM");
    especialidade = JOptionPane.showInputDialog(null, "Informe a Especialidade");
    Medico medico1 = new Medico(nome, cpf, dataNascimento, crm, especialidade);

    nome = JOptionPane.showInputDialog(null, "Informe o Nome");
    cpf = JOptionPane.showInputDialog(null, "Informe o CPF");
    dataNascimento = JOptionPane.showInputDialog(null, "Informe a Data de Nascimento");
    crm = JOptionPane.showInputDialog(null, "Informe a CRM");
    especialidade = JOptionPane.showInputDialog(null, "Informe a Especialidade");
    Medico medico2 = new Medico(nome, cpf, dataNascimento, crm, especialidade);

    String paciente1;
    paciente1 = JOptionPane.showInputDialog(null, "Informe o Nome do Paciente");
    medico1.examinarPaciente(paciente1);
    medico1.agendarRetorno(paciente1);

    String paciente2;
    paciente2 = JOptionPane.showInputDialog(null, "Informe o Nome do Paciente");
    medico2.examinarPaciente(paciente2);
    medico2.agendarRetorno(paciente2);
  }
}
