package telas;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;

import javax.swing.JPanel;

import styles.telaStyle1;
import telas.components.ConsultaContainer;
import telas.interfaces.Panels;

public class Consultar extends Panels{
    
    ConsultaContainer c;
    GridBagConstraints con = new GridBagConstraints();
    JPanel content;

    public Consultar(Screen scrn){
        super(scrn);
        this.content = new JPanel();
        this.content.setLayout(new FlowLayout(FlowLayout.CENTER,2,0));

        this.c = new ConsultaContainer(1, scrn);

        // JButton btn = new JButton("reload");
        // this.content.add(btn, this.con);
        // funcInterface func = () -> { c.Generate(); };
        // btn.addActionListener(new btnFunc(func));

        this.content.add(c, this.con);
        
        this.content.setUI(new telaStyle1());
        this.add(content, BorderLayout.EAST);
    }
    
    public void _update(){
        c.Generate();
    }
}
