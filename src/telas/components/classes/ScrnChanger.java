package telas.components.classes;

import java.awt.Dimension;

import javax.swing.JButton;

import Listeners.actionsLis;
import styles.ButtonStyle1;
import telas.Screen;

public class ScrnChanger extends JButton{

    public ScrnChanger(String text, Screen scrn, int index){
        this.setText(text);
        this.setPreferredSize(new Dimension(150, 50));
        this.addActionListener(new actionsLis(scrn, index));
        this.setUI(new ButtonStyle1());
    }
}
