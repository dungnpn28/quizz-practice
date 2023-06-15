/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

/**
 *
 * @author dai
 */
public class Price_Package {
    private String name;
    private int id;
    private int duration;
    private int price;
    private double sale;
    private boolean status;

    public Price_Package() {
    }

    public Price_Package(int id, int duration, int price, double sale, boolean status) {
        this.id = id;
        this.duration = duration;
        this.price = price;
        this.sale = sale;
        this.status = status;
    }

    public Price_Package(String name, int id, int duration, int price, double sale, boolean status) {
        this.name = name;
        this.id = id;
        this.duration = duration;
        this.price = price;
        this.sale = sale;
        this.status = status;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getDuration() {
        return duration;
    }

    public void setDuration(int duration) {
        this.duration = duration;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public double getSale() {
        return sale;
    }

    public void setSale(double sale) {
        this.sale = sale;
    }

    public boolean isStatus() {
        return status;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }
    
    
}
