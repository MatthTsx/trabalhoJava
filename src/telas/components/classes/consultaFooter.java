package telas.components.classes;

import java.awt.Color;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;

import Listeners.btnFunc;
import telas.components.ConsultaContainer;

public class consultaFooter extends JPanel{
    
    public ConsultaContainer parent;
    private GridBagConstraints gbc = new GridBagConstraints();

    public consultaFooter(ConsultaContainer c){
        this.setBackground(new Color(195, 141, 148));
        this.setLayout(new GridBagLayout());
        this.parent = c;
        this.gbc.insets = new Insets(0, 5, 0, 5);

        this.generate();
    }

    public void generate(){
        this.removeAll();
        this.gbc.gridx = 0;
        if(this.parent.index_relative >= 2){
            this.add(this.newMove(this.parent.index_relative - 1, () -> {this.parent.changeIndex(-1);} ), this.gbc );
        }

        this.gbc.gridx = 1;
        this.add(new JLabel(this.parent.index_relative + ""), this.gbc);

        this.gbc.gridx = 2;
        if(this.parent.index_relative * 13 < this.parent.scrn.Pessoas.size()){
            this.add(this.newMove(this.parent.index_relative + 1, () -> {this.parent.changeIndex(1);} ), this.gbc );
        }

        this.repaint();
        this.revalidate();
    }

    public JButton newMove(int number, btnFunc.funcInterface in){
        JButton jb = new JButton(number + "");
        jb.addActionListener(new btnFunc(in));
        return jb;
    }
}
