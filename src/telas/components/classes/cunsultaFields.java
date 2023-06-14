package telas.components.classes;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.GridLayout;

import javax.swing.BorderFactory;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;

import Listeners.MouseClick;
import telas.Consultar;
import utils.Pessoa;

public class cunsultaFields extends JPanel{
    

    public cunsultaFields(Pessoa pessoa, boolean odd, Consultar con){
        this.addMouseListener(new MouseClick(() -> {con.cp.getNewPessoa(pessoa.Codigo);}));

        this.setLayout(new FlowLayout(FlowLayout.CENTER, 0, 0));
        this.setPreferredSize(new Dimension(700, 41));
        //TODO: Mudar a cor
        this.setBackground(odd ? new Color(241, 250, 238) : new Color(168, 218, 220));
        this.setAlignmentX(SwingConstants.CENTER);

        JPanel p = new JPanel(new FlowLayout(FlowLayout.CENTER, 0, 0));
        p.setPreferredSize(new Dimension(675, 40));
        p.setLayout(new GridLayout(1, 6, 2, 0));
        p.setOpaque(false);

        for (Object obj : new Object[]{pessoa.Codigo, pessoa.CPF, pessoa.Name, pessoa.Estado, pessoa.Cidade, pessoa.Bairro}) {
            JLabel atrb = new JLabel( obj != null ? obj.toString() : "", SwingConstants.CENTER);
            // atrb.setOpaque(true);
            atrb.setHorizontalAlignment(SwingConstants.LEFT);
            atrb.setPreferredSize(new Dimension(75, 40));
            atrb.setBorder(BorderFactory.createEmptyBorder(0, 5, 0, 5));
            p.add(atrb);
        }
        // this.setBorder(BorderFactory.createMatteBorder(0, 0, 1, 0, Color.black));
        this.add(p);
    }
}
