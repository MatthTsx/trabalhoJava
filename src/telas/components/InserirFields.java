package telas.components;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import java.util.ArrayList;

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
    Object[] TextsFields = {"Código", "Nome", "CPF (sem pontos e/ou traços)", "Cidade", "Estado", "Bairro"};
    inserir parent;
    ArrayList<JTextField> tx = new ArrayList<>();

    public InserirFields(inserir parent){
        this.parent = parent;

        this.setLayout(new GridLayout(7,1,0, 15));

        this.setBackground(new Color(0, 0, 0, 0));
        for (int i = 0; i < TextsFields.length; i++) {
            JTextField t = new JTextField();
            t.setPreferredSize(new Dimension(250, 30));
            t.setText(TextsFields[i].toString());
            final int inderx = i;
            t.addFocusListener(new FocusListener() {
            @Override
            public void focusGained(FocusEvent e) {
                if (t.getText().equals(TextsFields[inderx].toString())) {
                    t.setText("");
                    t.setForeground(Color.BLACK);
                }
            }
            @Override
            public void focusLost(FocusEvent e) {
                if (t.getText().isEmpty()) {
                    t.setForeground(Color.GRAY);
                    t.setText(TextsFields[inderx].toString());
                }
            }
            });
            this.add(t);
            MyInterface a = (Object str, int index) -> { this.setValue(str, index); };
            t.getDocument().addDocumentListener(new textfieldLisOnChange(a, i));
            tx.add(t);
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
        if(this.parent.params.get(0) == null || this.parent.params.get(0) == TextsFields[0]) { return; }
        Pessoa pes = new Pessoa();
        
        for (int i = 0; i < this.parent.params.size(); i++) {
            Object value = this.parent.params.get(i);
            if(value != null && value != TextsFields[i]){
                pes.setValue(i, value);
            }
        }
        this.parent.scrn.Pessoas.add(pes);

        // for (Component object : this.getComponents()) {
        //     if(object instanceof JTextField){
        //         ((JTextField) object).setText(null);
        //     }
        // }

        for (int i = 0; i < TextsFields.length; i++) {
            tx.get(i).setText(TextsFields[i].toString());
        }

        this.parent.limparParams();
    }
}
