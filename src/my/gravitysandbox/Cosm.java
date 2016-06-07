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
    
    public Cosm() {
        this.bodies = new ArrayList<>();
        this.steps = 0;
    }
    
    /*
    public Cosm step() {
        //calculate forces on each body from every other body
        //then update each body's position, velocity, acceleration
        Cosm updatedCosm = new Cosm();
        for ( Body b : this.bodies ) {
            updatedCosm.addBody(b.update(this));
        }
        updatedCosm.steps = this.steps + 1;
        return updatedCosm;
    }
    */
    
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
