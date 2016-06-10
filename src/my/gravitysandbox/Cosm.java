/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package my.gravitysandbox;

import java.util.ArrayList;

/**
 * Oversees abstract, non-visual information about our sandbox.
 * @author Andy
 */
public class Cosm {
    private ArrayList<Body> bodies;
    private int steps;
    private final double G = 0.1;
    
    public Cosm() {
        this.bodies = new ArrayList<>();
        this.steps = 0;
    }
    
    public void step() {
        ArrayList<Body> updatedBodies = new ArrayList<>();
        for ( Body b : this.bodies ) {
            updatedBodies.add(b.update(this));
        }
        this.bodies = updatedBodies;
        this.steps++;
    }
    
    public void addBody(Body b) {
        this.bodies.add(b);
    }
    
    public void removeBody(Body b) {
        this.bodies.remove(b);
    }
    
    public void collide(Body b1, Body b2) {
        //TODO add collision effects
    }

    public ArrayList<Body> getBodies() {
        return bodies;
    }
    
}
