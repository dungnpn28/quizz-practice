/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

import dal.BlogDAO;
import java.sql.Date;

/**
 *
 * @author ACER
 */
public class Blog {
    private int id;
    private String thumbnail;
    private int author_id;
    private String title;
    private int category_id;
    private String flag;
    private boolean status;
    private String content;
    private Date created;
    private Date modified;
    private String brief_info;
    public Blog() {
    }

    public Blog(int id, String thumbnail, int author_id, String title, int category_id, String flag, boolean status, String content, Date created, Date modified, String brief_info) {
        this.id = id;
        this.thumbnail = thumbnail;
        this.author_id = author_id;
        this.title = title;
        this.category_id = category_id;
        this.flag = flag;
        this.status = status;
        this.content = content;
        this.created = created;
        this.modified = modified;
        this.brief_info = brief_info;
    }

    public Blog(int id, String thumbnail, int author_id, String title, int category_id, String flag, boolean status, String content, Date created, Date modified) {
        this.id = id;
        this.thumbnail = thumbnail;
        this.author_id = author_id;
        this.title = title;
        this.category_id = category_id;
        this.flag = flag;
        this.status = status;
        this.content = content;
        this.created = created;
        this.modified = modified;
    }
    
    public Blog(int id, String thumbnail, int author_id,String title, int category_id, String content, Date created){
        this.id = id;
        this.thumbnail = thumbnail;
        this.author_id = author_id;
        this.title = title;
        this.category_id = category_id;
        this.content = content;
        this.created = created;
    }

    public Blog(int id, String title, int category_id, String flag, boolean status, String content, String brief_info) {
        this.id = id;
        this.title = title;
        this.category_id = category_id;
        this.flag = flag;
        this.status = status;
        this.content = content;
        this.brief_info = brief_info;
    }

    public Blog(int id, String thumbnail, String title, int category_id, String flag, boolean status, String content, String brief_info) {
        this.id = id;
        this.thumbnail = thumbnail;
        this.title = title;
        this.category_id = category_id;
        this.flag = flag;
        this.status = status;
        this.content = content;
        this.brief_info = brief_info;
    }

    public String getBrief_info() {
        return brief_info;
    }

    public void setBrief_info(String brief_info) {
        this.brief_info = brief_info;
    }
    
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getThumbnail() {
        return thumbnail;
    }

    public void setThumbnail(String thumbnail) {
        this.thumbnail = thumbnail;
    }

    public int getAuthor_id() {
        return author_id;
    }

    public void setAuthor_id(int author_id) {
        this.author_id = author_id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public int getCategory_id() {
        return category_id;
    }

    public void setCategory_id(int category_id) {
        this.category_id = category_id;
    }

    public String getFlag() {
        return flag;
    }

    public void setFlag(String flag) {
        this.flag = flag;
    }

    public boolean getStatus() {
        return status;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
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
