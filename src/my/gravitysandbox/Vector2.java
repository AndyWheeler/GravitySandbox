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
        return sqrt((int)x^2 + (int)y^2);
    }
    
    //Adds this vector to another and returns the resulting vector.
    public Vector2 add(Vector2 other) {
        return new Vector2(this.x + other.x, this.y + other.y);
    }
    
    //Subtracts another vector from this vector and returns the resulting vector.
    public Vector2 sub(Vector2 other) {
        return new Vector2(this.x - other.x, this.y - other.y);
    }
    
    //Computes and returns the dot product of this vector with another.
    public double dot(Vector2 other) {
        return ((this.x * other.x) + (this.y * other.y));
    }
    
    public Vector2 mult(double scalar) {
        return new Vector2(this.x * scalar, this.y * scalar);
    }
}
