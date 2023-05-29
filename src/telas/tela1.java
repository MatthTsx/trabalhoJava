package telas;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridLayout;

import javax.swing.JPanel;


public class tela1 extends JPanel{
    Screen scrn;
    Object[] buttons = {
        "aaa", 
    };

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
        this.setLayout(new GridLayout(3,2));
    }
    
    public void show(int index){
        this.scrn.setTela(0);
    }
}
