package telas;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.plaf.ButtonUI;

import Buttons.actionsLis;
import styles.ButtonStyle1;

public class inserir extends JPanel{
    Screen scrn;
    String[] buttons = {
        "aaa", "baaa"
    };
    GridBagLayout grid = new GridBagLayout();
    GridBagConstraints c = new GridBagConstraints();

    public inserir(Screen Scrn){
        super();
        this.scrn = Scrn;

        this.setPreferredSize(new Dimension(1064, 680));
        this.setSize(this.scrn.getSize());
        this.setBounds(this.scrn.getBounds());
        this.setBackground(new Color(255,2,25));
        this.setLayout(grid);

        JButton b = new JButton("voltar 1");
        b.setPreferredSize(new Dimension(150, 50));
        b.addActionListener(new actionsLis(this.scrn, 0));
        b.setUI(new ButtonStyle1());
        this.c.weightx = 0.5;
        this.c.gridx = 0;
        this.c.gridy = 0;
        this.add(b, this.c);
        
        JLabel l = new JLabel("inserir");
        JTextField f = new JTextField();
        f.setPreferredSize(new Dimension(250, 20));
        this.c.gridx = 1;
        this.c.gridy = 1;
        this.add(l, this.c);
        this.c.gridx = -1;
        this.c.gridy = 2;
        this.add(f,this.c);
        JTextField t = new JTextField();
        t.setPreferredSize(new Dimension(250, 20));
        c.ipady = 40;      //make this component tall
        c.weightx = 0.0;
        c.gridwidth = 3;
        c.gridx = 0;
        c.gridy = 1;
        this.add(t,this.c);
    }
    
    public void show(int index){
        this.scrn.setTela(0);
    }
}
