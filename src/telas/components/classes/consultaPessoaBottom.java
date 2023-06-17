package telas.components.classes;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import java.util.ArrayList;
import java.util.stream.IntStream;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

import Listeners.btnFunc;
import Listeners.textfieldLisOnChange;
import Listeners.textfieldLisOnChange.MyInterface;
import styles.ButtonStyle1;
import telas.Consultar;
import telas.Screen;
import telas.components.ConsultaPessoa;
import utils.Pessoa;

public class consultaPessoaBottom extends JPanel{
    public ArrayList<Object> params = new ArrayList<>();
    Object codigo;
    Screen scrn;
    Object[] TextsFields = {"Código", "Nome", "CPF (sem pontos e traços)", "Cidade", "Estado", "Bairro"};
    int index_p;
    ConsultaPessoa parent;
    ArrayList<JTextField> tx = new ArrayList<>();

    public consultaPessoaBottom(Pessoa p, Screen scrn, ConsultaPessoa parent){
        if(p != null){
            this.codigo = p.Codigo;
        }
        this.parent = parent;
        this.scrn = scrn;
        setLayout(new GridLayout(9,1));
        setPreferredSize(new Dimension(100, 270));
        setOpaque(false);
        setBorder(BorderFactory.createEmptyBorder(4, 4, 4, 4));
        add(new JLabel("<html><p style='font-style:bold;font-size:14px;text-align:center;color:white'>insira as autalizaçãoes nescessarias:</p></html>"));

        for (int i = 0; i < TextsFields.length; i++) {
            params.add(TextsFields[i]);
        }
        this.Add();
    }

    public void Add(){
        for (int i = 0; i < TextsFields.length; i++) {
            JTextField t = new JTextField();
            t.setPreferredSize(new Dimension(50, 15));
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
            this.tx.add(t);
        }

        JButton b = new JButton("Inserir");
        b.setPreferredSize(new Dimension(50, 50));
        btnFunc.funcInterface in = () -> { this.inserir(); };
        b.addActionListener(new btnFunc(in));
        add(b);
        JButton b2 = new JButton("Deletar");
        b2.setPreferredSize(new Dimension(50, 50));
        btnFunc.funcInterface in2 = () -> { this.Delete(); };
        b2.addActionListener(new btnFunc(in2));
        add(b2);
    }

    private void setValue(Object str, int index){
        this.params.set(index, str);
    }

    private void inserir(){
        index_p = IntStream.range(0, scrn.Pessoas.size()).filter(i -> scrn.Pessoas.get(i).Codigo == this.codigo).findFirst().orElse(-1);
        if(index_p == -1) {return;}
        Pessoa pe = scrn.Pessoas.get(index_p);

        for (int i = 0; i < TextsFields.length; i++) {
            if(params.get(i) != null && !this.params.get(i).toString().equals(this.TextsFields[i].toString())){
                pe = change(pe, i, params.get(i));
            }
        }

        scrn.Pessoas.set(index_p, pe);
        parent.getNewPessoa(pe.Codigo);
    }

    private Pessoa change(Pessoa pe,int number, Object newValue){
        switch(number){
            case 0:
                pe.Codigo = newValue;
                break;
            case 1:
                pe.Name = newValue;
                break;
            case 2:
                pe.CPF = newValue;
                break;
            case 3:
                pe.Cidade = newValue;
                break;
            case 4:
                pe.Estado = newValue;
                break;
            case 5:
                pe.Bairro = newValue;
                break;
        }

        return pe;
    }

    public void update(Pessoa pessoa){
        this.codigo = pessoa.Codigo;
        parent.parent._update();
        for (int i = 0; i < TextsFields.length; i++) {
            this.tx.get(i).setText(TextsFields[i].toString());
        }
    }
    
    public void Delete(){
        index_p = IntStream.range(0, scrn.Pessoas.size()).filter(i -> scrn.Pessoas.get(i).Codigo == codigo).findFirst().orElse(-1);
        if(index_p == -1) {return;}
        scrn.Pessoas.remove(index_p);
        this.codigo = null;
        index_p = -1;
        parent.parent._update();
        for (int i = 0; i < TextsFields.length; i++) {
            this.tx.get(i).setText(TextsFields[i].toString());
        }
        parent.getNewPessoa(null);
    }
}
