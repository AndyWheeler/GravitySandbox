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
    private final ArrayList<Body> bodies;
    
    public Cosm(){
        this.bodies = new ArrayList<>();
    }
    
    public void step(){
        //calculate forces on each body from every other body
        //then update each body's position, velocity, acceleration
    }
    
    public void addBody(Body b){
        this.bodies.add(b);
    }
    
    public void removeBody(Body b){
        this.bodies.remove(b);
    }
    
    public void collide(Body b1, Body b2){
        //TODO add collision effects
    }

    public ArrayList<Body> getBodies() {
        return bodies;
    }
    
    
    
    
    
}
