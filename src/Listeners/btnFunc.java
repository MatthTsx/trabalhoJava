package Listeners;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class btnFunc implements ActionListener {
    public interface funcInterface{
        void doFunc();
    }
    funcInterface interfaceF;

    public btnFunc(funcInterface in){
        this.interfaceF = in;
    }

    public void actionPerformed(ActionEvent e) {
        this.interfaceF.doFunc();
    }
}
