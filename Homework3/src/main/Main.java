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
        Scanner sc = new Scanner(System.in);
        double[] d = new double[3];
        String color = new String();
        String Fill = new String();
        for (int i = 0; i < 3; i++) {
            d[i] = sc.nextDouble();
        }
        color = sc.next();
        Fill = sc.next();
        boolean isfilled = (Fill.equals("true") ? true : false);
        Triangle T = new Triangle(color, isfilled, d[0], d[1], d[2]);
        System.out.println(T.toString());
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
     *
     * @param color
     * @param filled
     */
    protected GeometricObject(String color, boolean filled) {
        dateCreated = new java.util.Date();
        this.color = color;
        this.filled = filled;
    }

    /**
     * Return color
     *
     * @return
     */
    public String getColor() {
        return color;
    }

    /**
     * Set a new color
     *
     * @param color
     */
    public void setColor(String color) {
        this.color = color;
    }

    /**
     * Return filled. Since filled is boolean, the get method is named isFilled
     *
     * @return
     */
    public boolean isFilled() {
        return filled;
    }

    /**
     * Set a new filled
     *
     * @param filled
     */
    public void setFilled(boolean filled) {
        this.filled = filled;
    }

    /**
     * Get dateCreated
     *
     * @return
     */
    public java.util.Date getDateCreated() {
        return dateCreated;
    }

    /**
     * Return a string representation of this object
     *
     * @return
     */
    @Override
    public String toString() {
        return "created on " + dateCreated + "\ncolor: " + color
                + " and filled: " + filled;
    }

    /**
     * Abstract method getArea
     *
     * @return
     */
    public abstract double getArea();

    /**
     * Abstract method getPerimeter
     *
     * @return
     */
    public abstract double getPerimeter();
}

class Triangle extends GeometricObject {

    private double L1, L2, L3;

    Triangle() {
        super();
    }

    Triangle(String color, boolean filled) {
        super(color, filled);
    }

    Triangle(String color, boolean filled, double L1, double L2, double L3) {
        super(color, filled);
        this.L1 = L1;
        this.L2 = L2;
        this.L3 = L3;
    }

    @Override
    public double getArea() {
        double s = (this.L1 + this.L2 + this.L3) / 2;
        double ret = s * (s - this.L1) * (s - this.L2) * (s - this.L3);
        ret = Math.sqrt(ret);
        return ret;
    }

    @Override
    public double getPerimeter() {
        return this.L1 + this.L2 + this.L3;
    }

    @Override
    public String toString() {
        return "Triangle: side1 = " + this.L1 + " side2 = " + this.L2 + " side3 = " + this.L3 + "\n"
                + "The area is " + this.getArea() + "\n"
                + "The perimeter is " + this.getPerimeter() + "\n"
                + super.getColor() + "\n"
                + super.isFilled();
    }
}
