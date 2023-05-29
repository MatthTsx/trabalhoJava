import java.awt.Container;
import java.awt.GridBagLayout;
import java.util.ArrayList;

import javax.swing.JFrame;
import javax.swing.JPanel;

public class Screen extends JFrame{

    ArrayList<Pessoa> Pessoas;
    Container c = this.getContentPane();
    tela1 T1;
    tela1 T2;
    GridBagLayout grid;

    Screen(){
        this.T1 = new tela1(this);
        this.T2 = new tela1(this);
        this.Pessoas = new ArrayList<>();
    
        this.grid = new GridBagLayout();
    
        this.c = this.getContentPane();
        this.setTitle("Add Image"); //Add the title to this
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); //Terminate program on close button
        this.setBounds(100, 200, 1080, 720); //Sets the position of the this
        this.setLocationRelativeTo(null);
        this.setLayout(grid); //Terminates default flow layout
        //this.setExtendedState(JFrame.MAXIMIZED_BOTH); 
        //this.setUndecorated(true);
        this.setVisible(true); // Exhibit the frame
    }

    public void setTela(JPanel tela){
        if(this.getComponentCount() > 0){
            this.c.removeAll();;
        }
        this.c.add(tela);
        this.revalidate();
    }
}