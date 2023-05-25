/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dal;

import dal.DBContext;
import dal.MyDAO;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import model.Blog;
import model.User;

/**
 *
 * @author ACER
 */
public class BlogDAO extends MyDAO{

    public Blog getBlogDetail(String id) {
        xSql = "select * from [blog]\n"
                + "where id = ?";
        try {
            ps = con.prepareStatement(xSql);
            ps.setString(1, id);
            rs = ps.executeQuery();
            while (rs.next()) {
                return new Blog(rs.getInt(1),//id
                        rs.getString(2),//thumbnail
                        rs.getInt(3),//author id
                        rs.getString(4),//title
                        rs.getInt(5),//category
                        rs.getString(6),//flag
                        rs.getString(7),//status
                        rs.getString(8),//content
                        rs.getDate(9),//created
                        rs.getDate(10)//modified
                );
            }
        } catch (Exception e) {
        }
        return null;
    }
    
    public List<Blog> getBlogList() {
        List<Blog> list = new ArrayList<>();
        xSql = "select * from [blog]";
        try {
            ps = con.prepareStatement(xSql);
            rs = ps.executeQuery();
            while (rs.next()) {
                list.add(new Blog(rs.getInt(1),//id
                        rs.getString(2),//thumbnail
                        rs.getInt(3),//author id
                        rs.getString(4),//title
                        rs.getInt(5),//category
                        rs.getString(6),//flag
                        rs.getString(7),//status
                        rs.getString(8),//content
                        rs.getDate(9),//created
                        rs.getDate(10)//modified
                ));
            }
        } catch (Exception e) {
        }
        return null;
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
    
    public String getCategoryName(int id){
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
}
