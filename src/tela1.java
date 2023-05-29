import java.awt.Color;
import java.awt.Dimension;

import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class tela1 extends JPanel{
    Screen scrn;
    Object[] buttons = {
        "aaa", 
    };

    public tela1(Screen Scrn){
        super();
        this.scrn = Scrn;

        this.setPreferredSize(new Dimension(1080/2, 720));
        JLabel a = new JLabel("aaaa");
        a.setBounds(0, 0, 120, 20);
        this.add(a);
        this.setBackground(new Color(255,2,25));

        this.scrn.revalidate();
    }
    
    public void show(){
        System.out.println("a");
        this.scrn.setTela(this);
    }
}
