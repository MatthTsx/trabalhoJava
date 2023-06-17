package telas.components;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import java.awt.Insets;

import javax.swing.BorderFactory;
import javax.swing.JPanel;

import styles.telaStyle1;
import telas.Consultar;
import telas.components.classes.consultaPessoaBottom;
import telas.components.classes.consultaPessoasTop;
import utils.Pessoa;

public class ConsultaPessoa extends JPanel {
    Pessoa pessoa;
    JPanel content = new JPanel(new GridLayout(6,2));
    public Consultar parent;
    GridBagConstraints gbc = new GridBagConstraints();
    consultaPessoaBottom cpb;

    public ConsultaPessoa(Consultar parent){
        this.setPreferredSize(new Dimension(1064 - 704, 600));
        this.parent = parent;
        this.setLayout(new BorderLayout());
        setBackground(Color.pink);
        setUI(new telaStyle1());

        this.content.setLayout(new GridBagLayout());
        // this.content.setBackground(new Color(0,0,0,0)); //buga td

        this.content.setPreferredSize(new Dimension(1064 - 702, 602 / 2));
        this.content.setOpaque(false);
        this.content.setBorder(BorderFactory.createEmptyBorder(0, 10, 0, 10));
        gbc.insets = new Insets(40, 0, 20, 0);
        // this.setUI(new telaStyle1());
        this.add(this.content, BorderLayout.NORTH);
        this.cpb = new consultaPessoaBottom(pessoa, parent.scrn, this);
        this.add(cpb, BorderLayout.SOUTH);
    }


    public void generate(){
        this.content.removeAll();
        this.cpb.update(pessoa);
        if(this.pessoa == null){
        }else{
            this.content.add(new consultaPessoasTop(pessoa));
        }
        this.content.revalidate();
        this.content.repaint();
    }

    public void getNewPessoa(Object cod){
        if(cod == null){
            this.content.removeAll();
            this.content.revalidate();
            this.content.repaint();
            return;
        }
        Pessoa p = parent.scrn.Pessoas.stream().filter(i -> i.Codigo == cod).findFirst().orElse(null);
        if(p == null) {return;}
        this.pessoa = p;
        this.generate();
    }
}
