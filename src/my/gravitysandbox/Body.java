/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package my.gravitysandbox;

import java.awt.Color;
import java.awt.Point;

/**
 *
 * @author Andy
 */
public class Body {
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
    
    public void move (Point d) {
        this.pos = new Point(this.pos.x + d.x, this.pos.y + d.y);
    }

    public double getM() {
        return m;
    }

    public int getR() {
        return r;
    }

    public Point getPos() {
        return pos;
    }

    public Vector2 getV() {
        return v;
    }

    public Vector2 getA() {
        return a;
    }

    public Color getColor() {
        return color;
    }

    public void setV(Vector2 v) {
        this.v = v;
    }

    public void setA(Vector2 a) {
        this.a = a;
    }
    
}
