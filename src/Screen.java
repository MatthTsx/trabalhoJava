import java.awt.Container;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.util.ArrayList;

import javax.swing.JFrame;

public class Screen extends JFrame{

    static Screen interface_;
    ArrayList<Pessoa> Pessoas;
    Container c = this.getContentPane();
    tela1 T1;
    tela1 T2;

    Screen Screen(){
        if(Screen.interface_ != null){
            return (Screen.interface_);
        }
        
        Screen.interface_ = this;
        return Screen.interface_;
    }
    
    public void load(){
        this.T1 = new tela1(this);
        this.T2 = new tela1(this);
        this.Pessoas = new ArrayList<>();
    
        this.c = this.getContentPane();
        this.setTitle("Add Image"); //Add the title to this
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); //Terminate program on close button
        this.setBounds(100, 200, 1080, 720); //Sets the position of the this
        this.setLocationRelativeTo(null);
        this.setLayout(new FlowLayout()); //Terminates default flow layout
        //this.setExtendedState(JFrame.MAXIMIZED_BOTH); 
        //this.setUndecorated(true);
        this.setVisible(true); // Exhibit the frame
    }
    
    public void showDefault(){
        this.T1.show();
        this.T2.show();
    }
}