/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dal;

import dal.DBContext;
import dal.MyDAO;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import model.Blog;
import model.User;

/**
 *
 * @author ACER
 */
public class BlogDAO extends MyDAO {

    public Blog getBlogDetail(String id) {
        xSql = "select * from [blog]\n"
                + "where id = ?";
        
        int xId;
        String xThumbnail;
        int xAuthor_id;
        String xTitle;
        int xCategory;
        String xFlag;
        boolean xStatus;
        String xContent;
        Date xCreated;
        Date xModified;
        Blog x = null;
        try {
            ps = con.prepareStatement(xSql);
            ps.setString(1, id);
            rs = ps.executeQuery();
            if (rs.next()) {
                xId = rs.getInt("id");
                xThumbnail = rs.getString("thumbnail");
                xAuthor_id = rs.getInt("author_id");
                xTitle = rs.getString("title");
                xCategory = rs.getInt("category_id");
                xFlag = rs.getString("flag");
                xStatus = rs.getBoolean("status");
                xContent = rs.getString("content");
                xCreated = rs.getDate("created");
                xModified = rs.getDate("modified");

                x = new Blog(xId, xThumbnail, xAuthor_id, xTitle, xCategory, xFlag, xStatus, xContent, xCreated, xModified);
            }
        } catch (Exception e) {
        }
        return x;
    }

    public List<Blog> getBlogList() {
        List<Blog> t = new ArrayList<>();
        xSql = "select * from [blog]";
        int xId;
        String xThumbnail;
        int xAuthor_id;
        String xTitle;
        int xCategory;
        String xFlag;
        boolean xStatus;
        String xContent;
        Date xCreated;
        Date xModified;
        Blog x = null;
        try {
            ps = con.prepareStatement(xSql);
            rs = ps.executeQuery();
            while (rs.next()) {
                xId = rs.getInt("id");
                xThumbnail = rs.getString("thumbnail");
                xAuthor_id = rs.getInt("author_id");
                xTitle = rs.getString("title");
                xCategory = rs.getInt("category_id");
                xFlag = rs.getString("flag");
                xStatus = rs.getBoolean("status");
                xContent = rs.getString("content");
                xCreated = rs.getDate("created");
                xModified = rs.getDate("modified");

                x = new Blog(xId, xThumbnail, xAuthor_id, xTitle, xCategory, xFlag, xStatus, xContent, xCreated, xModified);
                t.add(x);
            }
        } catch (Exception e) {
        }
        return t;
    }

    public String getAuthor(int id) {
        xSql = "select full_name from [user_profile]\n"
                + "where user_id = ?";
        try {
            ps = con.prepareStatement(xSql);
            ps.setInt(1, id);
            rs = ps.executeQuery();
            while (rs.next()) {
                return rs.getString(1);
            }
        } catch (Exception e) {
        }
        return null;
    }

    public String getCategoryName(int id) {
        xSql = "select name from [blog_category]\n"
                + "where id = ?";
        try {
            ps = con.prepareStatement(xSql);
            ps.setInt(1, id);
            rs = ps.executeQuery();
            while (rs.next()) {
                return rs.getString(1);
            }
        } catch (Exception e) {
        }
        return null;
    }

    public List<Blog> searchPost(String keyword) {
        List<Blog> resultPost = new ArrayList<>();
        xSql = "select * from [blog] where content like ?";
        int xId;
        String xThumbnail;
        int xAuthorId;
        String xTitle;
        int xCategory_id;
        String xContent;
        Date xCreated;
        Blog x = null;
        try {
            ps = con.prepareStatement(xSql);
            ps.setString(1, "%" + keyword + "%");
            rs = ps.executeQuery();
            while (rs.next()) {
                xId = rs.getInt("id");
                xThumbnail = rs.getString("thumbnail");
                xAuthorId = rs.getInt("author_id");
                xTitle = rs.getString("title");
                xCategory_id = rs.getInt("category_id");
                xContent = rs.getString("content");
                xCreated = rs.getDate("created");

                x = new Blog(xId, xThumbnail, xAuthorId, xTitle, xCategory_id, xContent, xCreated);
                resultPost.add(x);
            }
            rs.close();
            ps.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return (resultPost);

    }
}
