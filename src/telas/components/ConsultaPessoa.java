package telas.components;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import java.awt.TextField;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import java.util.stream.IntStream;

import javax.swing.BorderFactory;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

import styles.telaStyle1;
import telas.Consultar;
import utils.Pessoa;

public class ConsultaPessoa extends JPanel {
    Pessoa pessoa;
    JPanel content = new JPanel(new GridLayout(6,2));
    Consultar parent;
    GridBagConstraints gbc = new GridBagConstraints();

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

        JTextField tf = new JTextField("Search");

        tf.addFocusListener(new FocusListener() {
            @Override
            public void focusGained(FocusEvent e) {
                if (tf.getText().equals("Search")) {
                    tf.setText("");
                    tf.setForeground(Color.BLACK);
                }
            }
            @Override
            public void focusLost(FocusEvent e) {
                if (tf.getText().isEmpty()) {
                    tf.setForeground(Color.GRAY);
                    tf.setText("Search");
                }
            }
            });
        content.add(tf);

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
