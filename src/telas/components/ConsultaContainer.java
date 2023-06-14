package telas.components;

import java.awt.BorderLayout;
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

import Listeners.btnFunc;
import telas.Screen;
import telas.components.classes.consultaFooter;
import telas.components.classes.consultaHeader;
import telas.components.classes.cunsultaFields;
import utils.Pessoa;

public class ConsultaContainer extends JPanel{

    
    public int index_relative;
    public Screen scrn;
    consultaFooter footer;
    JPanel container = new JPanel(new GridLayout(13,1, 5, 0));

    public ConsultaContainer(int i, Screen scrn){
        super();
        this.index_relative = i;
        this.scrn = scrn;
        this.footer = new consultaFooter(this);
        this.setBackground(new Color(255,255,255));
        this.setLayout(new BorderLayout());

        this.add(new consultaHeader(), BorderLayout.NORTH); 
        this.add(this.container);
        this.add(this.footer, BorderLayout.SOUTH);

        this.Generate();
    }

    public void Generate(){
        List<Pessoa> ps = new ArrayList<Pessoa>();
        if(this.index_relative > this.scrn.Pessoas.size()){ return; }
        int index_max = Math.min(this.index_relative * 13, this.scrn.Pessoas.size());
        ps = scrn.Pessoas.subList( (this.index_relative - 1) * 13, index_max);
        
        this.container.removeAll(); //se lembre disso seu jumento quadrado


        for (int i = 0; i < ps.size(); i++) {
            Pessoa pessoa = ps.get(i);
            this.container.add(new cunsultaFields(pessoa, i%2 == 0));
        }

        this.container.revalidate();
        this.container.repaint();
    }

    public void changeIndex(int value){
        this.index_relative += value;
        this.footer.generate();
        this.Generate();
    }
}
