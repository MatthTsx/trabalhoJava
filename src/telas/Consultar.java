package telas;

import java.awt.Color;
import java.awt.Dimension;

import javax.swing.JLabel;
import javax.swing.JPanel;

public class Consultar extends JPanel{
    
    Screen scrn;

    public Consultar(Screen scrn){
        this.scrn = scrn;
        this.setPreferredSize(new Dimension(1064, 680));
        this.setBackground(new Color(255,2,25));

        this.add(new JLabel("aaa"));
    }
}
