/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package main;

import java.util.Scanner;

/**
 *
 * @author USER
 */
public class Main {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        Scanner sc = new Scanner(System.in);
        double d1, d2;
        d1 = sc.nextDouble();
        d2 = sc.nextDouble();
        Rectangle r1 = new Rectangle(d1, d2);
        d1 = sc.nextDouble();
        d2 = sc.nextDouble();
        Rectangle r2 = new Rectangle(d1, d2);
        if(r1.equals(r2)){
            System.out.println("true");
        }else{
            System.out.println("false");
        }
    }

    private static int Bin2Dec(String s) throws NumberFormatException {
        int ret = 0;
        for (int i = 0; i < s.length(); i++) {
            char ch = (char) s.charAt(i);
            if (ch != '0' && ch != '1') {
                throw new NumberFormatException();
            }
            ret *= 2;
            ret += (ch - '0');
        }
        return ret;
    }

}

abstract class GeometricObject {

    private String color = "white";
    private boolean filled;
    private java.util.Date dateCreated;

    /**
     * Construct a default geometric object
     */
    protected GeometricObject() {
        dateCreated = new java.util.Date();
    }

    /**
     * Construct a geometric object with color and filled value
     */
    protected GeometricObject(String color, boolean filled) {
        dateCreated = new java.util.Date();
        this.color = color;
        this.filled = filled;
    }

    /**
     * Return color
     */
    public String getColor() {
        return color;
    }

    /**
     * Set a new color
     */
    public void setColor(String color) {
        this.color = color;
    }

    /**
     * Return filled. Since filled is boolean, the get method is named isFilled
     */
    public boolean isFilled() {
        return filled;
    }

    /**
     * Set a new filled
     */
    public void setFilled(boolean filled) {
        this.filled = filled;
    }

    /**
     * Get dateCreated
     */
    public java.util.Date getDateCreated() {
        return dateCreated;
    }

    /**
     * Return a string representation of this object
     */
    public String toString() {
        return "created on " + dateCreated + "\ncolor: " + color
                + " and filled: " + filled;
    }

    /**
     * Abstract method getArea
     */
    public abstract double getArea();

    /**
     * Abstract method getPerimeter
     */
    public abstract double getPerimeter();
}

class Rectangle extends GeometricObject implements Comparable<Rectangle> {

    private double width;
    private double height;

    public Rectangle() {
    }

    public Rectangle(double width, double height) {
        this.width = width;
        this.height = height;
    }

    /**
     * Return width
     */
    public double getWidth() {
        return width;
    }

    /**
     * Set a new width
     */
    public void setWidth(double width) {
        this.width = width;
    }

    /**
     * Return height
     */
    public double getHeight() {
        return height;
    }

    /**
     * Set a new height
     */
    public void setHeight(double height) {
        this.height = height;
    }

    @Override
    /**
     * Return area
     */
    public double getArea() {
        return width * height;
    }

    @Override
    /**
     * Return perimeter
     */
    public double getPerimeter() {
        return 2 * (width + height);
    }

    @Override
    public boolean equals(Object o) {
        return (this.compareTo((Rectangle) o)) == 0;
    }

    @Override
    public int compareTo(Rectangle o) {
        double rhs = this.getArea();
        double lhs = o.getArea();
        if (lhs < rhs) {
            return -1;
        }
        if (lhs == rhs) {
            return 0;
        }
        return 1;
    }
}
