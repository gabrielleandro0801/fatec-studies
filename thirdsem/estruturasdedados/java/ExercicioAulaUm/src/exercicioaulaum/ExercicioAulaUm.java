// package exercicioaulaum;

import javax.swing.JOptionPane;

public class ExercicioAulaUm {
    static void media(int a, int b) {
        int r;
        r = (a+b)/2;
        JOptionPane.showMessageDialog(null, "A media e: " + r);
    }
    static void maior(int a, int b) {
        if (a > b) {
            JOptionPane.showMessageDialog(null, "O maior e " + a);
        } else {
            JOptionPane.showMessageDialog(null, "O maior e " + b);
        }
    }
    static void menor(int a, int b) {
        if (a < b) {
            JOptionPane.showMessageDialog(null, "O menor e " + a);
        } else {
            JOptionPane.showMessageDialog(null, "O menor e " + b);
        }
    }
    public static void main(String[] args) {
        String caixa;
        int opcao, a, b;
        
        do{
            caixa = JOptionPane.showInputDialog("Digite sua opcao:\n1 - Calcular Media\n2 - Verificar Maior\n3 - Verificar Menor\n0 - Sair");
            opcao = Integer.parseInt(caixa);
            switch(opcao) {
                case 1:
                    a = Integer.parseInt(JOptionPane.showInputDialog("Digite um numero"));
                    b = Integer.parseInt(JOptionPane.showInputDialog("Digite outro numero"));
                    media(a, b);
                    break;
                case 2:
                    a = Integer.parseInt(JOptionPane.showInputDialog("Digite um numero"));
                    b = Integer.parseInt(JOptionPane.showInputDialog("Digite outro numero"));
                    maior(a, b);
                    break;
                case 3:
                    a = Integer.parseInt(JOptionPane.showInputDialog("Digite um numero"));
                    b = Integer.parseInt(JOptionPane.showInputDialog("Digite outro numero"));
                    menor(a, b);
                    break;
                case 0:
                    break;
                default:
                    JOptionPane.showMessageDialog(null, "Opcao invalida!");
                    break;
            }
        }while(opcao != 0);
    }
    
}
