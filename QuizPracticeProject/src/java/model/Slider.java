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
public class Slider {
    private int id;
    private String title;
    private String image;
    private String backlink;
    private boolean status;
    private Date created;
    private Date modified;

    public Slider() {
    }

    public Slider(int id, String title, String image, String backlink, boolean status, Date created, Date modified) {
        this.id = id;
        this.title = title;
        this.image = image;
        this.backlink = backlink;
        this.status = status;
        this.created = created;
        this.modified = modified;
    }
    
    public Slider(int id, String title, String image, String backlink){
        this.id = id;
        this.title = title;
        this.image = image;
        this.backlink = backlink;
    }
    
    public Slider(int id, String title, String image, String backlink, boolean status){
        this.id = id;
        this.title = title;
        this.image = image;
        this.backlink = backlink;
        this.status = status;
    }
    
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public String getBacklink() {
        return backlink;
    }

    public void setBacklink(String backlink) {
        this.backlink = backlink;
    }

    public boolean isStatus() {
        return status;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }

    public Date getCreated() {
        return created;
    }

    public void setCreated(Date created) {
        this.created = created;
    }

    public Date getModified() {
        return modified;
    }

    public void setModified(Date modified) {
        this.modified = modified;
    }
    
    
    
    
    
}