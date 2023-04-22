package ex04;

import javax.swing.JOptionPane;
public class Ex04 {
    static int fibo(int a) {
        if (a <= 2) {
            return 1;
        } else {
            return fibo(a-1) + fibo(a-2);
        }
    }
    public static void main(String[] args) {
        String aux;
        int a, r;
        aux = JOptionPane.showInputDialog("Informe a posicao desejada do Fibonacci");
        a = Integer.parseInt(aux);
        r = fibo(a);
        JOptionPane.showMessageDialog(null, "Na posicao " + a + " o valor e de " + r);
    }
    
}
