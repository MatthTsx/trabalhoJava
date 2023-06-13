package telas.components;

import java.awt.Color;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Graphics;
import java.awt.GridLayout;
import java.util.ArrayList;
import java.util.List;

import javax.swing.BorderFactory;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;

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
        this.setLayout(new GridLayout(16,1, 5, 0));
        
        this.Generate();
    }

    public void Generate(){
        List<Pessoa> ps = new ArrayList<Pessoa>();
        if(this.index_relative > this.scrn.Pessoas.size()){ return; }
        int index_max = Math.min(this.index_relative * 15, this.scrn.Pessoas.size());
        ps = scrn.Pessoas.subList( (this.index_relative - 1) * 15, index_max);
        
        this.removeAll(); //se lembre disso seu jumento quadrado
        
        for (int i = 0; i < ps.size(); i++) {
            Pessoa pessoa = ps.get(i);
            JPanel pa = new JPanel(new FlowLayout(FlowLayout.CENTER, 0, 0));
            pa.setPreferredSize(new Dimension(700, 41));
            //TODO: Mudar a cor
            pa.setBackground(i%2 == 0 ? Color.gray : Color.gray.brighter());
            pa.setAlignmentX(SwingConstants.CENTER);

            JPanel p = new JPanel(new FlowLayout(FlowLayout.CENTER, 0, 0));
            p.setPreferredSize(new Dimension(675, 40));
            //p.setLayout(new GridLayout(1, 5, 5, 0));
            p.setOpaque(false);

            for (Object obj : new Object[]{pessoa.Codigo, pessoa.CPF, pessoa.Name}) {
                JLabel atrb = new JLabel( obj != null ? obj.toString() : "", SwingConstants.CENTER);
                // atrb.setOpaque(true);
                atrb.setPreferredSize(new Dimension(125, 40));
                atrb.setBorder(BorderFactory.createEmptyBorder(0, 20, 0, 20));
                p.add(atrb);
            }
            p.add(new JLabel("up"));
            p.add(new JLabel("del"));
            pa.setBorder(BorderFactory.createMatteBorder(0, 0, 1, 0, Color.black));
            pa.add(p);
            this.add(pa);
        }
        this.revalidate();
        this.repaint();
    }
}
