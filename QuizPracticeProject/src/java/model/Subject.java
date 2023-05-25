/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

/**
 *
 * @author LENOVO
 */
public class Subject {
    private int id;
    private int dimension_id;
    private String name;
    private String category;
    private boolean status;
    private String description;

    public Subject() {
    }

    public Subject(int id, int dimension_id, String name, String category, boolean status, String description) {
        this.id = id;
        this.dimension_id = dimension_id;
        this.name = name;
        this.category = category;
        this.status = status;
        this.description = description;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
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

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
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
