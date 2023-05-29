package Buttons;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


import telas.tela1;

public class actionsLis implements ActionListener {
    tela1 tela;

    public actionsLis(tela1 tela){
        this.tela = tela;
    }

    public void actionPerformed(ActionEvent e) {
        tela.waaea();
    }
}
