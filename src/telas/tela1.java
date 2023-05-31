package telas;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;

import javax.swing.JButton;
import javax.swing.JPanel;

import Buttons.actionsLis;
import styles.ButtonStyle1;


public class tela1 extends JPanel{
    Screen scrn;
    String[] buttons = {
        "inserir", "Consultar", "Excluir",
        "Alterar", "Listar",
    };
    GridBagLayout grid = new GridBagLayout();
    GridBagConstraints c = new GridBagConstraints();

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

        for (int i = 0; i < buttons.length; i++) {
            JButton b = new JButton(buttons[i]);
            b.setPreferredSize(new Dimension(100, 40));
            b.setUI(new ButtonStyle1());
            b.addActionListener(new actionsLis(this.scrn, i + 1));
            // this.c.gridwidth = 2;
            this.c.gridx = GridBagConstraints.RELATIVE;
            // this.c.gridy = (int) Math.floor(i / 5);
            this.c.weighty = 1;
            this.c.insets = new Insets(0, 15, 0, 15);
            this.add(b, this.c);
        }
    }
    
    public void show(int index){
        this.scrn.setTela(0);
    }
}
