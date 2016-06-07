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

    Vector2(double x, double y) {
        this.x = x;
        this.y = y;
    }
    
    //Computes and returns the magnitude of this vector.
    public double mag() {
        return sqrt(this.x*this.x + this.y*this.y);
    }
    
    //Adds this vector to another and returns the resulting vector.
    public Vector2 add(Vector2 other) {
        return new Vector2(this.getX() + other.getX(), this.getY() + other.getY());
    }
    
    //Subtracts another vector from this vector and returns the resulting vector.
    public Vector2 sub(Vector2 other) {
        return new Vector2(this.getX() - other.getX(), this.getY() - other.getY());
    }
    
    //Computes and returns the dot product of this vector with another.
    public double dot(Vector2 other) {
        return ((this.getX() * other.getX()) + (this.getY() * other.getY()));
    }
    
    public Vector2 mult(double scalar) {
        return new Vector2(this.getX() * scalar, this.getY() * scalar);
    }

    public double getX() {
        return x;
    }

    public double getY() {
        return y;
    }
    
    public String toString() {
        return Double.toString(x) + ", " + Double.toString(y);
    }
}
