package telas;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.GridBagLayout;
import java.util.ArrayList;

import javax.swing.JFrame;

import telas.interfaces.Panels;
import utils.Pessoa;

public class Screen extends JFrame{

    public ArrayList<Pessoa> Pessoas;
    Container c = this.getContentPane();
    public ArrayList<Panels> telas;
    GridBagLayout grid;
    public boolean DarkMode = false;

    public Screen(){
        
        this.Pessoas = new ArrayList<>();
        
        Pessoa p1 = new Pessoa();
        p1.setValue(0, "placeholder");
        p1.setValue(1, "placeholder");
        p1.setValue(2, "placeholder");
        p1.setValue(3, "placeholder");
        p1.setValue(4, "placeholder");
        p1.setValue(5, "placeholder");
        this.Pessoas.add(p1);
        
        this.grid = new GridBagLayout();
        
        this.c = this.getContentPane();
        this.setTitle("Claudinei"); //Add the title to this
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); //Terminate program on close button
        this.setBounds(0, 0, 1080, 720); //Sets the position of the this
        this.setLocationRelativeTo(null);
        this.setLayout(grid); //Terminates default flow layout
        // this.setExtendedState(JFrame.MAXIMIZED_BOTH); 
        // this.setUndecorated(true);
        this.setVisible(true); // Exhibit the frame
        this.setMinimumSize(new Dimension(1080, 720));
        this.setResizable(false);

        this.telas = new ArrayList<>();
        this.telas.add(new tela1(this));
        this.telas.add(new inserir(this));
        this.telas.add(new Consultar(this));
        this.telas.add(new Panels(this));
        // this.addComponentListener(new ComponentAdapter() 
        // {  
        //         public void componentResized(ComponentEvent evt) {
        //             Component c = (Component)evt.getSource();
        //             System.out.println(c.getSize());
        //         }
        // });
    }

    public void setTela(int index){
        if(index < telas.size()){
            if(this.getComponentCount() > 0){
                this.c.removeAll();
            }
            this.c.add(telas.get(index));
            telas.get(index).onLoad();
            this.revalidate();
            this.repaint();
        }
    }
}