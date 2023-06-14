package telas;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.util.ArrayList;

import javax.swing.JPanel;

import styles.telaStyle1;
import telas.components.InserirFields;
import telas.components.classes.ScrnChanger;
import telas.interfaces.Panels;

public class inserir extends Panels{
    public Screen scrn;
    GridBagLayout grid = new GridBagLayout();
    GridBagConstraints c = new GridBagConstraints();

    public ArrayList<Object> params = new ArrayList<>(6);
    Object[] TextsFields = {"Código", "Nome", "Bairro", "Cidade", "Estado", "CPF"};

    public inserir(Screen Scrn){
        super(Scrn);
        this.scrn = Scrn;
        JPanel p = new JPanel();

        p.setPreferredSize(new Dimension(1064, 680));
        p.setSize(this.scrn.getSize());
        p.setBounds(this.scrn.getBounds());
        p.setBackground(new Color(255,2,25));
        p.setLayout(grid);

        for (int i = 0; i < TextsFields.length; i++) {
            this.params.add(null);
        }
        this.c.gridx = 0;
        this.c.gridy = 0;

        p.add(new InserirFields(this), this.c);

        p.setUI(new telaStyle1());

        this.add(p);
    }
    
    public void show(int index){
        this.scrn.setTela(0);
    }

    public void limparParams(){
        for (int i = 0; i < this.params.size(); i++) {
            this.params.set(i, null);
        }
    }
}
