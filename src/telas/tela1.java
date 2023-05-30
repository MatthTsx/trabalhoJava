package telas;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import java.awt.Insets;

import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.border.Border;

import Buttons.actionsLis;


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
            b.setPreferredSize(new Dimension(150, 50));
            b.setBackground(new Color(0x2dce98));
            b.setForeground(Color.white);
            b.setMargin(new Insets(10,20,0,0));
            b.setBorder(null);
            b.setFont(new Font("Calibri", Font.PLAIN, 14));
            b.addActionListener(new actionsLis(this));
            this.add(b);
        }
    }
    
    public void show(int index){
        this.scrn.setTela(0);
    }
}
