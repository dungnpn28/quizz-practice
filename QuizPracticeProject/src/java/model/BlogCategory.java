/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

import java.sql.Date;

/**
 *
 * @author ADMIN
 */
public class BlogCategory {
    private int id;
    private String name;

    public BlogCategory() {
    }

    public BlogCategory(int id, String name) {
        this.id = id;
        this.name = name;
    }

    public BlogCategory(int xId, String xThumbnail, int xAuthor_id, String xTitle, int xCategory_id, boolean xFlag, boolean xStatus, String xContent, Date xCreated, Date xModified) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
    
    
}
