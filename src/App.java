import javax.swing.GroupLayout;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.*;
import javax.swing.JTextField;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridLayout;

public class App {
    public static void main(String[] args) throws Exception {
        Screen scr = new Screen();
        scr.setTela(scr.T1);

        scr.revalidate();
    }
}
