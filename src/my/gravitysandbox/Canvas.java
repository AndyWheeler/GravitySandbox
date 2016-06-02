package my.gravitysandbox;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Point;

/**
 * Oversees visual aspects of our sandbox.
 * @author Andy
 */
public class Canvas extends javax.swing.JPanel {
    private final Cosm cosm;
    
    public Canvas() {
        super();
        this.cosm = new Cosm();
    }
    
    public Canvas (Cosm c) {
        super();
        this.cosm = c;
    }
    
    @Override public void paintComponent(Graphics g){
        super.paintComponent(g);
        drawCosm(g);
    }

    public void addBody(Body b) {
        this.cosm.addBody(b);
    }
    
    public void drawCosm(Graphics g) {
        this.setBackground(Color.decode("0x00326E"));
        //TODO add background starfield
        for (Body b : this.cosm.getBodies()) {
            drawBody(b, g);
        }
    }

    private void drawBody(Body b, Graphics g) {
        int rad = b.getR();
        Point pos = b.getPos();
        g.setColor(b.getColor());
        g.fillOval((int)pos.getX(), (int)pos.getY(), rad, rad);
        g.setColor(Color.BLACK);
        g.drawOval((int)pos.getX(), (int)pos.getY(), rad, rad);
    }
}
