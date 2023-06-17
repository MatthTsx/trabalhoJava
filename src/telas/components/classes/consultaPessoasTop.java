package telas.components.classes;

import java.awt.GridLayout;

import javax.swing.JLabel;
import javax.swing.JPanel;

import utils.Pessoa;

public class consultaPessoasTop extends JPanel{
    private Pessoa p;

    public consultaPessoasTop(Pessoa p){
        setLayout(new GridLayout(6,1));
        this.setOpaque(false);
        this.p = p;
        this.addAll();
    }
    
    public void addAll(){
        if(this.p.Name != null){
            this.add(this.newLabel(p.Name.toString(), "Nome"));
        }
        if(this.p.CPF != null){
            this.add(this.newLabel(p.CPF.toString(), "CPF"));
        }
        if(this.p.Codigo != null){
            this.add(this.newLabel(p.Codigo.toString(), "Codigo"));
        }
        if(this.p.Estado != null){
            this.add(this.newLabel(p.Estado.toString(), "Estado"));
        }
        if(this.p.Cidade != null){
            this.add(this.newLabel(p.Cidade.toString(), "Cidade"));
        }
        if(this.p.Bairro != null){
            this.add(this.newLabel(p.Bairro.toString(), "Bairro"));
        }
    }

    public JLabel newLabel(String text, String type){
        JLabel jl = new JLabel(String.format(
            "<html><p color='red'>%s: <span style='font-size: 10px;' color='#e6ffec'>%s</span></p></html>",
            type,
            text
        ));
        return jl;
    }
}
