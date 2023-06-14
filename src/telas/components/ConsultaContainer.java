package telas.components;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.GridLayout;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JPanel;
import telas.Consultar;
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
    Consultar con;

    public ConsultaContainer(int i, Screen scrn, Consultar con){
        super();
        this.index_relative = i;
        this.scrn = scrn;
        this.con = con;
        this.footer = new consultaFooter(this);
        this.setLayout(new BorderLayout());

        this.container.setBackground(new Color(195, 141, 148));

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
            this.container.add(new cunsultaFields(pessoa, i%2 == 0, this.con));
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
