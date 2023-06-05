package telas;

import java.awt.Color;
import java.awt.Dimension;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;

import Listeners.btnFunc;
import Listeners.btnFunc.funcInterface;
import styles.telaStyle1;
import telas.components.ConsultaContainer;
import telas.components.classes.ScrnChanger;

public class Consultar extends JPanel{
    
    Screen scrn;
    ConsultaContainer c;

    public Consultar(Screen scrn){
        this.scrn = scrn;
        this.setPreferredSize(new Dimension(1064, 680));
        this.setBackground(new Color(255,2,25));

        this.c = new ConsultaContainer(1, scrn);
        this.add(new JLabel("aaa"));
        this.add(new ScrnChanger("Voltar", this.scrn, 0));

        JButton btn = new JButton();
        this.add(btn);
        funcInterface func = () -> { c.Generate(); };
        btn.addActionListener(new btnFunc(func));
        this.add(c);

        this.setUI(new telaStyle1());
    }

    public void _update(){
        c.Generate();
    }
}
