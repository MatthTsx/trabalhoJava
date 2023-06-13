package telas.interfaces;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;

import javax.swing.JPanel;

import telas.Screen;

public class Panels extends JPanel{
    public Color mainColor;
    public Color subColor;
    public Screen scrn;

    public Panels(Screen scrn){
        this.setLayout(new BorderLayout());
        this.setPreferredSize(new Dimension(1064, 680));

        this.scrn = scrn;
        this.mainColor = this.scrn.DarkMode? Color.black : Color.white;

        this.setBackground(mainColor);
        this.add(new Header(this.scrn), BorderLayout.NORTH);
    }
}
