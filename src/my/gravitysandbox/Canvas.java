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
    private static boolean vectors = true;
    private static boolean wrapping = true;
    
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
        if (wrapping) {
            int width = this.getWidth();
            int height = this.getHeight();
            g.setColor(b.getColor());
            g.fillOval((int)corner.getX()%width, (int)corner.getY()%height, 2*rad, 2*rad);
            g.setColor(Color.BLACK);
            g.drawOval((int)corner.getX()%width, (int)corner.getY()%height, 2*rad, 2*rad);
        }
            
        g.setColor(b.getColor());
        g.fillOval((int)corner.getX(), (int)corner.getY(), 2*rad, 2*rad);
        g.setColor(Color.BLACK);
        g.drawOval((int)corner.getX(), (int)corner.getY(), 2*rad, 2*rad);
    }
    
    private void drawVectors(Graphics g) {
        int scale = 15;
        for (Body b : this.cosm.getBodies()) {
            int bX = b.getX();
            int bY = b.getY();
            //draw velocity and acceleration vectors
            
            //velocity
            g.setColor(Color.RED);
            g.drawLine( bX, bY,
                        bX + (int) (b.getV().X() * scale), bY + (int) (b.getV().Y() * scale));
            g.setColor(Color.BLACK);
            String veloText = "v: " + b.getV().toString();
            g.drawString(veloText, bX + 10, bY);
            
            //acceleration
            g.setColor(Color.BLUE);
            g.drawLine( bX, bY,
                        bX + (int) (b.getA().X() * scale), bY + (int) (b.getA().Y() * scale));
            g.setColor(Color.BLACK);
            String accelText = "a: " + b.getA().toString();
            g.drawString(accelText, bX + 10, bY + 15);
        }
    }

    public Cosm getCosm() {
        return this.cosm;
    }
}
