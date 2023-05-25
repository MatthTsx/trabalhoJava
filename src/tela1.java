import java.awt.Color;
import java.awt.Dimension;

import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class tela1 extends JPanel{
    Screen scrn;

    public tela1(Screen Scrn){
        super();
        this.scrn = Scrn;

        this.setPreferredSize(new Dimension(500, 200));
        JLabel a = new JLabel("aaaa");
        a.setBounds(0, 0, 120, 20);
        this.add(a);
        this.setBackground(new Color(255,2,25));
        this.setBounds(0, 0, 350, 300);
        this.scrn.revalidate();
    }
    
    public void showww(){

    }
    public void show(){
        this.showww();
        System.out.println(this);
        this.scrn.add( this );
        scrn.revalidate();
    }
}
