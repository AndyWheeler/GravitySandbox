/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package my.gravitysandbox;

import static java.lang.Math.sqrt;

/**
 * Two-dimensional vector.
 * Stores x and y components of a 2D vector.
 * Can get magnitude with Vector2.mag();
 * Supports adding, subtracting, and taking the dot product.
 * @author Andy
 */
public class Vector2 {
    
    private final double x;
    private final double y;
    
    Vector2() {
        this.x = 0;
        this.y = 0;
    }

    Vector2(double x, double y) {
        this.x = x;
        this.y = y;
    }
    
    //Computes and returns the magnitude of this vector.
    public double mag() {
        return sqrt(this.x*this.x + this.y*this.y);
    }
    
    //Returns a unit vector in the direction of this vector.
    public Vector2 direction() {
        double mag = this.mag();
        return new Vector2(this.x / mag, this.y / mag);
    }
    
    //Adds this vector to another and returns the resulting vector.
    public Vector2 add(Vector2 other) {
        return new Vector2(this.X() + other.X(), this.Y() + other.Y());
    }
    
    //Subtracts another vector from this vector and returns the resulting vector.
    public Vector2 sub(Vector2 other) {
        return new Vector2(this.X() - other.X(), this.Y() - other.Y());
    }
    
    //Computes and returns the dot product of this vector with another.
    public double dot(Vector2 other) {
        return ((this.X() * other.X()) + (this.Y() * other.Y()));
    }
    
    public Vector2 mult(double scalar) {
        return new Vector2(this.X() * scalar, this.Y() * scalar);
    }

    public double X() {
        return x;
    }

    public double Y() {
        return y;
    }
    
    public String toString() {
        return Double.toString(x) + ", " + Double.toString(y);
    }
}
