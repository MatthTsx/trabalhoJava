package styles;

import java.awt.Color;
import java.awt.GradientPaint;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;

import javax.swing.JComponent;
import javax.swing.plaf.basic.BasicPanelUI;

public class telaStyle1 extends BasicPanelUI {

    @Override
    public void paint (Graphics g, JComponent c) {
        JComponent b = (JComponent) c;
        paintBackground(g, b);
        super.paint(g, c);
    }

    private void paintBackground (Graphics g, JComponent c) {
        Graphics2D g2d = (Graphics2D) g;
        Color co = new Color(36, 6, 65);
        g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING, // n sei oq faz, n muda nada visualmente
                RenderingHints.VALUE_ANTIALIAS_ON);
        GradientPaint gp = new GradientPaint(0, 0,
                co.brighter().brighter(), 0, c.getHeight(),
                co.darker().darker());
        g2d.setPaint(gp);
        g2d.fillRect(0, 0, c.getWidth(), c.getHeight()); 

    }
}
