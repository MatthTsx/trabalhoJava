package telas.components;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.util.stream.IntStream;

import javax.swing.JLabel;
import javax.swing.JPanel;

import styles.telaStyle1;
import telas.Consultar;
import utils.Pessoa;

public class ConsultaPessoa extends JPanel {
    Pessoa pessoa;
    JPanel content = new JPanel(new GridLayout(6,2));
    Consultar parent;

    public ConsultaPessoa(Consultar parent){
        this.setPreferredSize(new Dimension(1064 - 700, 10));
        this.parent = parent;
        this.setUI(new telaStyle1());
        this.add(this.content);
    }


    public void generate(){
        this.content.removeAll();
        if(pessoa == null){
        }else{
            this.content.add(new JLabel(pessoa.Name.toString()));
        }

        this.content.repaint();
        this.content.revalidate();
    }

    public void getNewPessoa(Object cod){
        Pessoa p = parent.scrn.Pessoas.stream().filter(i -> i.Codigo == cod).findFirst().orElse(null);
        if(p == null) {return;}
        this.pessoa = p;
        this.generate();
    }
}
