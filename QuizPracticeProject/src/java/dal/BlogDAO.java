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
        String xBrief_info;
        int xView;
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
                xBrief_info = rs.getString("brief_info");
                xView = rs.getInt("view");

                x = new Blog(xId, xThumbnail, xAuthor_id, xTitle, xCategory, xFlag, xStatus, xContent, xCreated, xModified, xBrief_info, xView);
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
        String xBrief;
        int xView;
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
                xBrief = rs.getString("brief_info");
                xView = rs.getInt("view");
                x = new Blog(xId, xThumbnail, xAuthor_id, xTitle, xCategory, xFlag, xStatus, xContent, xCreated, xModified, xBrief, xView);
                t.add(x);
            }
        } catch (Exception e) {
        }
        return t;
    }

    public List<Blog> getBlogListOrderByUpdated() {
        List<Blog> t = new ArrayList<>();
        xSql = "select * from [blog] order by [modified] DESC";
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
        String xBrief;
        int xView;
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
                xBrief = rs.getString("brief_info");
                xView = rs.getInt("view");

                x = new Blog(xId, xThumbnail, xAuthor_id, xTitle, xCategory, xFlag, xStatus, xContent, xCreated, xModified, xBrief, xView);
                t.add(x);
            }
        } catch (Exception e) {
        }
        return t;
    }
    
    public List<Blog> getBlogListOrderByView() {
        List<Blog> t = new ArrayList<>();
        xSql = "select * from [blog] order by [view] DESC";
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
        String xBrief;
        int xView;
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
                xBrief = rs.getString("brief_info");
                xView = rs.getInt("view");

                x = new Blog(xId, xThumbnail, xAuthor_id, xTitle, xCategory, xFlag, xStatus, xContent, xCreated, xModified, xBrief, xView);
                t.add(x);
            }
        } catch (Exception e) {
        }
        return t;
    }

    public List<Blog> getBlogListByCategory(int category_id) {
        List<Blog> t = new ArrayList<>();
        xSql = "select * from [blog] where category_id = ?";
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
        String xBrief;
        int xView;
        Blog x = null;
        try {
            ps = con.prepareStatement(xSql);
            ps.setInt(1, category_id);
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
                xBrief = rs.getString("brief_info");
                xView = rs.getInt("view");

                x = new Blog(xId, xThumbnail, xAuthor_id, xTitle, xCategory, xFlag, xStatus, xContent, xCreated, xModified, xBrief, xView);
                t.add(x);
            }
        } catch (Exception e) {
        }
        return t;
    }

    public List<Blog> getBlogListByAuthor(int author_id) {
        List<Blog> t = new ArrayList<>();
        xSql = "select * from [blog] where author_id = ?";
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
        String xBrief;
        int xView;
        Blog x = null;
        try {
            ps = con.prepareStatement(xSql);
            ps.setInt(1, author_id);
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
                xBrief = rs.getString("brief_info");
                xView = rs.getInt("view");

                x = new Blog(xId, xThumbnail, xAuthor_id, xTitle, xCategory, xFlag, xStatus, xContent, xCreated, xModified, xBrief, xView);
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
        xSql = "select * from [blog] where title like ?";
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
        String xBrief;
        int xView;
        Blog x = null;
        try {
            ps = con.prepareStatement(xSql);
            ps.setString(1, "%" + keyword + "%");
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
                xBrief = rs.getString("brief_info");
                xView = rs.getInt("view");

                x = new Blog(xId, xThumbnail, xAuthor_id, xTitle, xCategory, xFlag, xStatus, xContent, xCreated, xModified, xBrief, xView);
                resultPost.add(x);
            }
            rs.close();
            ps.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return (resultPost);
    }

    public void updateBlogWithThumbnail(Blog x) {
        xSql = "UPDATE [dbo].[blog]\n"
                + "   SET [thumbnail] = ?\n"
                + "      ,[title] = ?\n"
                + "      ,[category_id] = ?\n"
                + "      ,[flag] = ?\n"
                + "      ,[status] = ?\n"
                + "      ,[brief_info] = ?\n"
                + "      ,[content] = ?\n"
                + "      ,[modified] = GETDATE()\n"
                + " WHERE id = ?";
        try {
            ps = con.prepareStatement(xSql);
            ps.setString(1, x.getThumbnail());
            ps.setString(2, x.getTitle());
            ps.setInt(3, x.getCategory_id());
            ps.setString(4, x.getFlag());
            ps.setBoolean(5, x.getStatus());
            ps.setString(6, x.getBrief_info());
            ps.setString(7, x.getContent());
            ps.setInt(8, x.getId());
            ps.executeUpdate();
            ps.close();
        } catch (Exception e) {
            System.out.println("update: " + e.getMessage());
        }
    }

    public void updateBlogWithoutThumbnail(Blog x) {
        xSql = "UPDATE [dbo].[blog]\n"
                + "   SET [title] = ?\n"
                + "      ,[category_id] = ?\n"
                + "      ,[flag] = ?\n"
                + "      ,[status] = ?\n"
                + "      ,[brief_info] = ?\n"
                + "      ,[content] = ?\n"
                + "      ,[modified] = GETDATE()\n"
                + " WHERE id = ?";
        try {
            ps = con.prepareStatement(xSql);
            ps.setString(1, x.getTitle());
            ps.setInt(2, x.getCategory_id());
            ps.setString(3, x.getFlag());
            ps.setBoolean(4, x.getStatus());
            ps.setString(5, x.getBrief_info());
            ps.setString(6, x.getContent());
            ps.setInt(7, x.getId());
            ps.executeUpdate();
            ps.close();
        } catch (Exception e) {
            System.out.println("update: " + e.getMessage());
        }
    }

    public int getView(int blogId) {
        int view = 0;
        xSql = "select [view] from blog where id = ?";
        try {
            ps = con.prepareStatement(xSql);
            ps.setInt(1, blogId);
            rs = ps.executeQuery();
            while (rs.next()) {
                view = rs.getInt(1);
            }
        } catch (Exception e) {
        }
        return view;
    }

    public void updateView(int blogId, int view) {
        xSql = "UPDATE [dbo].[blog]\n"
                + "   SET [view] = ?\n"
                + " WHERE id =?";
        try {
            ps = con.prepareStatement(xSql);
            ps.setInt(1, (view+1));
            ps.setInt(2, blogId);
 
            ps.executeUpdate();
            ps.close();
        } catch (Exception e) {
            System.out.println("update: " + e.getMessage());
        }
    }

}
