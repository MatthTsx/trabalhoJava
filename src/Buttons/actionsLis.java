package Buttons;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import telas.Screen;
import telas.tela1;

public class actionsLis implements ActionListener {
    tela1 tela;
    Screen scrn;
    int index;

    public actionsLis(Screen scrn, int index){
        this.scrn = scrn;
        this.index = index;
    }

    public void actionPerformed(ActionEvent e) {
        this.scrn.setTela(index);
        System.out.println("aa");
    }
}
