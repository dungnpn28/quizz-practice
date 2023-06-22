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
    private int id;
    private String name;
    private String description;
    private int duration;
    private double price;
    private double sale;
    private int status;

    public Price_Package() {
    }

    public Price_Package(int id, int duration, double price, double sale, int status) {
        this.id = id;
        this.duration = duration;
        this.price = price;
        this.sale = sale;
        this.status = status;
    }

    public Price_Package(int id,String name, int duration, double price, double sale, int status) {
        this.name = name;
        this.id = id;
        this.duration = duration;
        this.price = price;
        this.sale = sale;
        this.status = status;
    }

    public Price_Package(String name, int duration, double price, double sale, int status) {
        this.name = name;
        this.duration = duration;
        this.price = price;
        this.sale = sale;
        this.status = status;
    }

    public Price_Package(int id, String name, String description, int duration, double price, double sale, int status) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.duration = duration;
        this.price = price;
        this.sale = sale;
        this.status = status;
    }

    public Price_Package(String name, String description, int duration, double price, double sale, int status) {
        this.name = name;
        this.description = description;
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

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public int getDuration() {
        return duration;
    }

    public void setDuration(int duration) {
        this.duration = duration;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
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