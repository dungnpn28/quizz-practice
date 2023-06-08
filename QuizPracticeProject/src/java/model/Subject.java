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
    private int dimension_id;
    private String name;
    private int category_id;
    private boolean status;
    private String description;
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
        this.dimension_id = dimension_id;
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

    public Subject(int id, String illustration, int dimension_id, String name, int category_id, boolean status, String description, boolean featured, int user_id) {
        this.id = id;
        this.illustration = illustration;
        this.dimension_id = dimension_id;
        this.name = name;
        this.category_id = category_id;
        this.status = status;
        this.description = description;
        this.featured = featured;
        this.user_id = user_id;
    }

    public Date getModified() {
        return modified;
    }

    public void setModified(Date modified) {
        this.modified = modified;
    }

    public int getUser_id() {
        return user_id;
    }

    public void setUser_id(int user_id) {
        this.user_id = user_id;
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

    public int getDimension_id() {
        return dimension_id;
    }

    public void setDimension_id(int dimension_id) {
        this.dimension_id = dimension_id;
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

}
