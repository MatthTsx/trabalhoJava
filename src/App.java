import javax.swing.GroupLayout;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import java.awt.GridLayout;

public class App {
    public static void main(String[] args) throws Exception {
        Screen scr = new Screen();
        scr.T1 = new tela1();
        scr.showDefault();
        
        GridLayout grid = new GridLayout(2, 3, 5, 2);
        JPanel p = new JPanel(grid);
        JTextField fi = new JTextField(10);
        JTextField fi2 = new JTextField(10);

        p.add(new JLabel("User sla oq: "));
        p.add(fi);
        p.add(new JLabel("User sla oq la: "));
        p.add(fi2);
        p.setLayout(grid);

        scr.showMessageDialog(null, p);
        System.out.println(fi.getText() + " " + fi2.getText());
    }
}
