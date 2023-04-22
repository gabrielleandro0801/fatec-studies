package valoresnumericos;

import javax.swing.JOptionPane;

public class ValoresNumericos {
    public static void main(String[] args) {
        int i;
        double x;
        String aux;
        aux = JOptionPane.showInputDialog("Digite um inteiro");
        i = Integer.parseInt(aux);
        JOptionPane.showMessageDialog(null, "Valor do i = " + i);
        aux = JOptionPane.showInputDialog("Digite um decimal");
        x = Double.parseDouble(aux);
        JOptionPane.showMessageDialog(null, "Valor do x = " + x);
        
        int a;
        a = Integer.parseInt(JOptionPane.showInputDialog("Digite mais um inteiro"));
        JOptionPane.showMessageDialog(null, "Valor de a = " + a);
        
        char c;
        aux = JOptionPane.showInputDialog("Digite uma letra");
        c = aux.charAt(0);
        
        double y = Math.sqrt(x);
    }
    
}
