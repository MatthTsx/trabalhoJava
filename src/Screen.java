import java.util.ArrayList;

import javax.swing.JOptionPane;

public class Screen extends JOptionPane{

    static Screen interface_;
    ArrayList<Pessoa> Pessoas;
    tela1 T1;

    Screen Screen(){
        if(Screen.interface_ != null){
            return (Screen.interface_);
        }
        
        this.T1 = new tela1();
        this.Pessoas = new ArrayList<>();


        Screen.interface_ = this;
        return Screen.interface_;
    }
    
    public void showDefault(){
        int x = this.T1.show();
    }
}