package telas;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridBagLayout;
import java.awt.GridLayout;

import javax.swing.JButton;
import javax.swing.JPanel;


public class tela1 extends JPanel{
    Screen scrn;
    String[] buttons = {
        "aaa", "baaa"
    };
    GridBagLayout grid = new GridBagLayout();

    public void waaea(){
        System.out.println("aaa");
    }

    public tela1(Screen Scrn){
        super();
        this.scrn = Scrn;

        this.setPreferredSize(new Dimension(1064, 680));
        this.setSize(this.scrn.getSize());
        this.setBounds(this.scrn.getBounds());
        this.setBackground(new Color(255,2,25));
        this.setLayout(grid);

        for (String button : buttons) {
            JButton b = new JButton(button);
            this.add(b);
        }
    }
    
    public void show(int index){
        this.scrn.setTela(0);
    }
}
