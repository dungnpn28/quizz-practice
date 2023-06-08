/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

import java.sql.Date;

/**
 *
 * @author LENOVO
 */
public class Subject {
    private int id;
    private String illustration;
    private String name;
    private int category_id;
    private boolean status;
    private String description;
    private int author_id;
    private Date modified;
    private boolean featured;
    private int user_id;
    private double min_price;
    private double min_sale;
    public Subject() {
    }

    public Subject(int id, String illustration, String name, int category_id, boolean status, String description, Date modified, boolean featured) {
        this.id = id;
        this.illustration = illustration;
        this.name = name;
        this.category_id = category_id;
        this.status = status;
        this.description = description;
        this.modified = modified;
        this.featured = featured;
    }

    public Subject(int id, String illustration, int dimension_id, String name, int category_id, boolean status, String description) {
        this.id = id;
        this.illustration = illustration;
        this.name = name;
        this.category_id = category_id;
        this.status = status;
        this.description = description;
    }

    public Subject(int id, String illustration, String name, int category_id, boolean status, String description,Date modified, boolean featured, double min_price, double min_sale) {
        this.id = id;
        this.illustration = illustration;
        this.name = name;
        this.category_id = category_id;
        this.status = status;
        this.description = description;
        this.modified = modified;
        this.featured = featured;
        this.min_price = min_price;
        this.min_sale = min_sale;
    }

    public Subject(int id, String illustration, String name, int category_id, boolean status, String description, int author_id, Date modified, boolean featured) {
        this.id = id;
        this.illustration = illustration;
        this.name = name;
        this.category_id = category_id;
        this.status = status;
        this.description = description;
        this.author_id = author_id;
        this.modified = modified;
        this.featured = featured;
    }

    public Subject(int id, String illustration, int dimension_id, String name, int category_id, boolean status, String description, boolean featured) {
        this.id = id;
        this.illustration = illustration;
        this.name = name;
        this.category_id = category_id;
        this.status = status;
        this.description = description;
        this.featured = featured;
    }

    public Subject(int id, String illustration, String name, int category_id, boolean status, String description, double min_price, double min_sale) {
        this.id = id;
        this.illustration = illustration;
        this.name = name;
        this.category_id = category_id;
        this.status = status;
        this.description = description;
        this.min_price = min_price;
        this.min_sale = min_sale;
    }
    

    public double getMin_price() {
        return min_price;
    }

    public void setMin_price(double min_price) {
        this.min_price = min_price;
    }

    public double getMin_sale() {
        return min_sale;
    }

    public void setMin_sale(double min_sale) {
        this.min_sale = min_sale;
    }

    public Date getModified() {
        return modified;
    }

    public void setModified(Date modified) {
        this.modified = modified;
    }

    public boolean isFeatured() {
        return featured;
    }

    public void setFeatured(boolean featured) {
        this.featured = featured;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getIllustration() {
        return illustration;
    }

    public void setIllustration(String illustration) {
        this.illustration = illustration;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getCategory_id() {
        return category_id;
    }

    public void setCategory_id(int category_id) {
        this.category_id = category_id;
    }

    public boolean isStatus() {
        return status;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public int getAuthor_id() {
        return author_id;
    }

    public void setAuthor_id(int author_id) {
        this.author_id = author_id;
    }

}
