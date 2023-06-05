package telas;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.GradientPaint;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.RenderingHints;

import javax.swing.JPanel;

import styles.telaStyle1;
import telas.components.classes.ScrnChanger;


public class tela1 extends JPanel{
    Screen scrn;
    String[] buttons = {
        "inserir", "Consultar", "Excluir",
        "Alterar", "Listar",
    };
    GridBagLayout grid = new GridBagLayout();
    GridBagConstraints c = new GridBagConstraints();

    public tela1(Screen Scrn){
        super();
        this.scrn = Scrn;

        this.setPreferredSize(new Dimension(1064, 680));
        this.setSize(this.scrn.getSize());
        this.setBounds(this.scrn.getBounds());
        this.setBackground(new Color(36, 6, 65));
        this.setLayout(grid);

        for (int i = 0; i < buttons.length; i++) {
            this.c.insets = new Insets(0, 15, 0, 15);
            this.add(new ScrnChanger(buttons[i], this.scrn, i + 1), this.c);
        }

        this.setUI(new telaStyle1());
    }
    
    public void show(int index){
        this.scrn.setTela(0);
    }
}
