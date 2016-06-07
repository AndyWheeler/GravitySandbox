/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package my.gravitysandbox;

import java.awt.Color;
import java.awt.Point;
import static java.lang.Math.sqrt;

/**
 *
 * @author Andy
 */
public class Body {
    private final double G = 0.1;
    
    private final double m; //mass in units of Earth masses
    private final int r; //radius in units of Earth radii * 2
    private Point pos;
    private Vector2 v;
    private Vector2 a;
    private final Color color;
    
    public Body (double mass, int radius, Point position, Vector2 velocity, Vector2 accel, Color c) {
        this.m = mass;
        this.r = radius;
        this.pos = position;
        this.v = velocity;
        this.a = accel;
        this.color = c;
    }
    
    public Body update(Cosm cosm){
        Body updatedBody = this.copy();
        //update position
        updatedBody.pos.translate((int)Math.ceil(v.getX()), (int)Math.ceil(v.getY()));
        //update velocity
        updatedBody.v = this.v.add(updatedBody.a);
        //update acceleration
        updatedBody.a = this.netForces(cosm);
        return updatedBody;
    }
    
    public Body copy(){
        return new Body(this.m, this.r, this.pos, this.v, this.a, this.color);
    }
    
    private Vector2 netForces(Cosm cosm) {
        //for each other Body in the Cosm,
        //calculate and apply the pull of its gravity
        Vector2 netForces = new Vector2(0,0);
        for (Body b : cosm.getBodies()) {
            if (!this.equals(b)){
                Vector2 g = this.gravityFrom(b);
                netForces = netForces.add(g);
            }
        }
        return netForces;
    }

    private Vector2 gravityFrom(Body b){
        //TODO get gravity from b on this Body
        //calculate gravity
        
        int distanceX = b.getX() - this.getX();
        int distanceY = b.getY() - this.getY();
        double distance = sqrt(distanceX*distanceX + distanceY*distanceY);
        //double distance = this.distanceTo(b);
        
        double g = (G * b.getM()) / (distance * distance);
        double gX = g * (distanceX / distance);
        double gY = g * (distanceY / distance);
        
        return new Vector2(gX, gY);
    }
            
    public double distanceTo(Body b) {
        return this.pos.distance(b.getPos());
    }
    
    public Point getCorner() {
        return new Point(this.getX() - this.r, this.getY() - this.r);
    }

    public double getM() {
        return this.m;
    }

    public int getR() {
        return this.r;
    }

    public Point getPos() {
        return this.pos;
    }
    
    public int getX() {
        return this.pos.x;
    }
    
    public int getY() {
        return this.pos.y;
    }

    public Vector2 getV() {
        return this.v;
    }

    public Vector2 getA() {
        return this.a;
    }

    public Color getColor() {
        return this.color;
    }

    public void setV(Vector2 v) {
        this.v = v;
    }

    public void setA(Vector2 a) {
        this.a = a;
    }
    
}
