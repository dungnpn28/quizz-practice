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
    private String price;
    private double sale;
    private int status;

    public Price_Package() {
    }

    public Price_Package(int id, int duration, String price, double sale, int status) {
        this.id = id;
        this.duration = duration;
        this.price = price;
        this.sale = sale;
        this.status = status;
    }

    public Price_Package(int id,String name, int duration, String price, double sale, int status) {
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

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    public double getSale() {
        return sale;
    }

    public void setSale(double sale) {
        this.sale = sale;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }
    
    
}
