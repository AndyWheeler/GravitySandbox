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
    private final double G = 1;
    
    private final double m; //mass in units of Earth masses
    private final int r; //radius in units of Earth radii * 2
    private Point pos;
    private Vector2 v;
    private Vector2 a;
    private final Color color;
    
    public Body (double mass, int radius, Color c, Point position, Vector2 velocity, Vector2 accel) {
        this.m = mass;
        this.r = radius;
        this.pos = position;
        this.v = velocity;
        this.a = accel;
        this.color = c;
    }
    
    public Body update(Cosm cosm) {
        Body updatedBody = this.copy();
        //update acceleration
        updatedBody.applyForces(cosm);
        //update velocity
        updatedBody.changeV(); 
        //update position
        updatedBody.move();
        return updatedBody;
    }
    
    public Body copy() {
        return new Body(this.m, this.r, this.color, this.pos, this.v, this.a);
    }
    
    public void move() {
        this.pos.translate( (int)Math.ceil(this.v.X()), (int)Math.ceil(this.v.Y()) );
    }
    
    public void changeV() {
        this.v = this.v.add(this.a);
    }
    
    public void applyForces(Cosm cosm) {
        Vector2 netForces = new Vector2();
        for( Body b : cosm.getBodies() ) {
            netForces = netForces.add(this.gravityFrom(b));
        }
        this.a = netForces;
    }
    
    //Returns the gravitational pull from Body b on this Body.
    private Vector2 gravityFrom(Body b){
        
        int distanceX = b.getX() - this.getX();
        int distanceY = b.getY() - this.getY();
        if (distanceX == 0 && distanceY == 0) {
            return new Vector2();
        }
        double distance = sqrt(distanceX*distanceX + distanceY*distanceY);
        
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
