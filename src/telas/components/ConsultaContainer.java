package telas.components;

import java.awt.Color;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JLabel;
import javax.swing.JPanel;

import telas.Screen;
import utils.Pessoa;

public class ConsultaContainer extends JPanel{
    int index_relative;
    Screen scrn;

    public ConsultaContainer(int i, Screen scrn){
        super();
        this.index_relative = i;
        this.scrn = scrn;

        this.setBackground(new Color(255,255,255));
        this.setLayout(new GridLayout(10,1, 5, 5));
        this.Generate();
    }

    public void Generate(){
        List<Pessoa> ps = new ArrayList<Pessoa>();
        System.out.println(this.index_relative);
        if(this.index_relative > this.scrn.Pessoas.size()){ return; }
        int index_max = Math.min(this.index_relative * 10, this.scrn.Pessoas.size());
        ps = scrn.Pessoas.subList( (this.index_relative - 1) * 10, index_max);
        
        this.removeAll();

        for (Pessoa pessoa : ps) {
            JPanel p = new JPanel();
            p.setLayout(new GridLayout(1, 3, 5, 0));
            p.setPreferredSize(new Dimension(200, 10));
            p.add(new JLabel( pessoa.Codigo.toString() ));
            p.add(new JLabel( pessoa.CPF != null ? pessoa.CPF.toString() : "" ));
            p.add(new JLabel( pessoa.Name!= null ? pessoa.Name.toString(): "" ));
            this.add(p);
        }
        this.revalidate();
        this.repaint();
    }
}
