package telas.components;

import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.GridLayout;

import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JTextField;

import Listeners.btnFunc;
import Listeners.textfieldLisOnChange;
import Listeners.textfieldLisOnChange.MyInterface;
import styles.ButtonStyle1;
import telas.inserir;
import utils.Pessoa;

public class InserirFields extends JPanel{
    Object[] TextsFields = {"Código", "Nome", "CPF", "Cidade", "Estado", "Bairro"};
    inserir parent;

    public InserirFields(inserir parent){
        this.parent = parent;

        this.setLayout(new GridLayout(7,1,0, 15));

        this.setBackground(new Color(0, 0, 0, 0));
        for (int i = 0; i < TextsFields.length; i++) {
            JTextField t = new JTextField();
            t.setPreferredSize(new Dimension(250, 30));
            this.add(t);
            MyInterface a = (Object str, int index) -> { this.setValue(str, index); };
            t.getDocument().addDocumentListener(new textfieldLisOnChange(a, i));
        }

        JButton b = new JButton("Inserir");
        b.setPreferredSize(new Dimension(150, 50));
        btnFunc.funcInterface in = () -> { this.inserir_(); };
        b.addActionListener(new btnFunc(in));
        b.setUI(new ButtonStyle1());

        this.add(b);
    }

    private void setValue(Object value, int index){
        this.parent.params.set(index, value);
    }

    private void inserir_(){
        if(this.parent.params.get(0) == null) { return; }
        Pessoa pes = new Pessoa();
        
        for (int i = 0; i < this.parent.params.size(); i++) {
            Object value = this.parent.params.get(i);
            if(value != null){
                pes.setValue(i, value);
            }
        }
        this.parent.scrn.Pessoas.add(pes);

        for (Component object : this.getComponents()) {
            if(object instanceof JTextField){
                ((JTextField) object).setText(null);
            }
        }

        this.parent.limparParams();
    }
}
