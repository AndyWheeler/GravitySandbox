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
    private boolean vectors = true;
    
    public Canvas() {
        super();
        this.cosm = new Cosm();
    }
    
    public Canvas (Cosm c) {
        super();
        this.cosm = c;
    }
    
    public void update(){
        this.cosm.step();
    }
    
    @Override public void paintComponent(Graphics g){
        super.paintComponent(g);
        this.cosm.step();
        drawCosm(g);
        if(vectors) {
            drawVectors(g);
        }
    }

    public void addBody(Body b) {
        this.cosm.addBody(b);
    }
    
    private void drawCosm(Graphics g) {
        this.setBackground(Color.decode("0x00326E"));
        //TODO add background starfield
        for (Body b : this.cosm.getBodies()) {
            drawBody(b, g);
        }
    }

    private void drawBody(Body b, Graphics g) {
        int rad = b.getR();
        Point corner = b.getCorner();
        g.setColor(b.getColor());
        g.fillOval((int)corner.getX(), (int)corner.getY(), 2*rad, 2*rad);
        g.setColor(Color.BLACK);
        g.drawOval((int)corner.getX(), (int)corner.getY(), 2*rad, 2*rad);
    }
    
    private void drawVectors(Graphics g) {
        for (Body b : this.cosm.getBodies()) {
            //draw velocity and acceleration vectors
            int scale = 20;
            //velocity
            g.setColor(Color.RED);
            g.drawLine( b.getX(), b.getY(),
                        b.getX() + (int) (b.getV().getX() * scale), b.getY() + (int) (b.getV().getY() * scale));
            g.setColor(Color.BLACK);
            String veloText = "v: " + b.getV().toString();
            g.drawString(veloText, b.getX() + 10, b.getY());
            
            //acceleration
            g.setColor(Color.BLUE);
            g.drawLine( b.getX(), b.getY(),
                        b.getX() + (int) (b.getA().getX() * scale), b.getY() + (int) (b.getA().getY() * scale));
            g.setColor(Color.BLACK);
            String accelText = "a: " + b.getA().toString();
            g.drawString(accelText, b.getX() + 10, b.getY() + 15);
        }
    }
}
