package telas.interfaces;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;

import javax.swing.JLabel;
import javax.swing.JPanel;

import telas.Screen;
import telas.components.classes.ScrnChanger;

public class Header extends JPanel{

    public Header(Screen scrn){
        setBackground(Color.black);
        setPreferredSize(new Dimension(1064, 50));
        setLayout(new BorderLayout());
        
        ScrnChanger changer = new ScrnChanger("Back", scrn, 0);
        changer.setPreferredSize(new Dimension(80, 10));
        changer.setBackground(Color.white);
        add(changer, BorderLayout.WEST);
    }
}
