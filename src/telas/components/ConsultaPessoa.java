package telas.components;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import java.util.stream.IntStream;

import javax.swing.BorderFactory;
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
        this.setPreferredSize(new Dimension(1064 - 705, 600));
        this.parent = parent;
        this.setLayout(new BorderLayout());

        this.content.setLayout(new GridBagLayout());
        // this.content.setBackground(new Color(0,0,0,0)); //buga td

        this.content.setPreferredSize(new Dimension(1064 - 702 -50, 40));
        this.content.setOpaque(false);
        this.content.setBorder(BorderFactory.createEmptyBorder(0, 10, 0, 10));

        // this.setUI(new telaStyle1());
        this.add(this.content, BorderLayout.CENTER);
    }


    public void generate(){
        this.content.removeAll();
        if(this.pessoa == null){
        }else{
            this.content.add(new JLabel(pessoa.Name != null ? pessoa.Name.toString() : pessoa.Codigo.toString()));
        }

        this.content.revalidate();
        this.content.repaint();
    }

    public void getNewPessoa(Object cod){
        Pessoa p = parent.scrn.Pessoas.stream().filter(i -> i.Codigo == cod).findFirst().orElse(null);
        if(p == null) {return;}
        this.pessoa = p;
        this.generate();
    }
}
