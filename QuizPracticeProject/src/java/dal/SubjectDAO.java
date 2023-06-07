/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dal;

import java.sql.Date;
import java.util.ArrayList;
import java.util.List;
import model.Subject;

/**
 *
 * @author LENOVO
 */
public class SubjectDAO extends MyDAO {

    public List<Subject> getSubjects() {
        List<Subject> t = new ArrayList<>();
        xSql = "select * from subject";
        try {
            ps = con.prepareStatement(xSql);
            rs = ps.executeQuery();
            int xID;
            String xIllustratoin;
            int xDimesion_id;
            String xName;
            int xCategory;
            boolean xStatus;
            String xDescription;
            Date xModified;
            boolean xFeatured;
            Subject x;
            while (rs.next()) {
                xID = rs.getInt("id");
                xIllustratoin = rs.getString("illustration");
                xDimesion_id = rs.getInt("dimension_id");
                xModified = rs.getDate("modified");
                xName = rs.getString("name");
                xCategory = rs.getInt("category_id");
                xStatus = rs.getBoolean("status");
                xDescription = rs.getString("description");
                xFeatured = rs.getBoolean("featured");
                x = new Subject(xID, xIllustratoin, xDimesion_id, xName, xCategory, xStatus, xDescription, xModified, xFeatured);
                t.add(x);
            }
            rs.close();
            ps.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return (t);
    }

    public List<Subject> getSubjectsWithPaging(int page, int PAGE_SIZE) {
        List<Subject> t = new ArrayList<>();
        xSql = "select * from subject"
                + "							   order by subject.modified DESC\n"
                + "							   offset (?-1)*? row fetch next ? rows only";
        try {
            ps = con.prepareStatement(xSql);
            ps.setInt(1, page);
            ps.setInt(2, PAGE_SIZE);
            ps.setInt(3, PAGE_SIZE);
            rs = ps.executeQuery();
            int xID;
            String xIllustratoin;
            int xDimesion_id;
            String xName;
            int xCategory;
            boolean xStatus;
            String xDescription;
            boolean xFeatured;
            Date xModified;
            Subject x;
            while (rs.next()) {
                xID = rs.getInt("id");
                xIllustratoin = rs.getString("illustration");
                xDimesion_id = rs.getInt("dimension_id");
                xModified = rs.getDate("modified");
                xName = rs.getString("name");
                xCategory = rs.getInt("category_id");
                xStatus = rs.getBoolean("status");
                xDescription = rs.getString("description");
                xFeatured = rs.getBoolean("featured");
                x = new Subject(xID, xIllustratoin, xDimesion_id, xName, xCategory, xStatus, xDescription, xModified, xFeatured);
                t.add(x);
            }
            rs.close();
            ps.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return (t);
    }

    public int getTotalSubject() {
        xSql = "select count(id)  from subject";
        int totalSubject = 0;
        try {
            ps = con.prepareStatement(xSql);
            rs = ps.executeQuery();
            while (rs.next()) {
                return rs.getInt(1);
            }
            rs.close();
            ps.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return (totalSubject);
    }

    public List<Subject> getFeaturedSubjectsWithPaging(int page, int PAGE_SIZE) {
        List<Subject> t = new ArrayList<>();
        xSql = "Select * from subject\n"
                + "where featured = 1\n"
                + "order by modified DESC\n"
                + "offset (?-1)*? row fetch next ? rows only";
        try {
            ps = con.prepareStatement(xSql);
            ps.setInt(1, page);
            ps.setInt(2, PAGE_SIZE);
            ps.setInt(3, PAGE_SIZE);
            rs = ps.executeQuery();
            int xID;
            String xIllustratoin;
            int xDimesion_id;
            String xName;
            int xCategory;
            boolean xStatus;
            String xDescription;
            Date xModified;
            boolean xFeatured;
            Subject x;
            while (rs.next()) {
                xID = rs.getInt("id");
                xIllustratoin = rs.getString("illustration");
                xDimesion_id = rs.getInt("dimension_id");
                xModified = rs.getDate("modified");
                xName = rs.getString("name");
                xCategory = rs.getInt("category_id");
                xStatus = rs.getBoolean("status");
                xDescription = rs.getString("description");
                xFeatured = rs.getBoolean("featured");
                x = new Subject(xID, xIllustratoin, xDimesion_id, xName, xCategory, xStatus, xDescription, xModified, xFeatured);
                t.add(x);
            }
            rs.close();
            ps.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return (t);
    }

    public int getTotalFeaturedSubject() {
        xSql = "select count(id) from subject where featured = 1";
        int totalSubject = 0;
        try {
            ps = con.prepareStatement(xSql);
            rs = ps.executeQuery();
            while (rs.next()) {
                return rs.getInt(1);
            }
            rs.close();
            ps.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return (totalSubject);
    }

    public List<Subject> getSubjectsByID(int id) {
        List<Subject> t = new ArrayList<>();
        xSql = "select * from subject where id = ?";
        try {
            ps = con.prepareStatement(xSql);
            ps.setInt(1, id);
            rs = ps.executeQuery();
            String xIllustration;
            int xDimesion_id;
            String xName;
            int xCategory_id;
            boolean xStatus;
            String xDescription;

            Subject x;
            while (rs.next()) {
                xIllustration = rs.getString("illustration");
                xDimesion_id = rs.getInt("dimension_id");

                xName = rs.getString("name");
                xCategory_id = rs.getInt("xCategory_id");
                xStatus = rs.getBoolean("status");
                xDescription = rs.getString("description");
                x = new Subject(id, xIllustration, xDimesion_id, xName, xCategory_id, xStatus, xDescription);
                t.add(x);
            }
            rs.close();
            ps.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return (t);
    }

    public List<Subject> getSubjectsByUserID(int userId) {
        List<Subject> t = new ArrayList<>();
        xSql = "SELECT s.*\n"
                + "                FROM subject s \n"
                + "                JOIN registration r ON s.id = r.subject_id\n"
                + "                where r.user_id = ?\n"
                + "                order by s.modified DESC";
        try {
            ps = con.prepareStatement(xSql);
            ps.setInt(1, userId);
            rs = ps.executeQuery();
            String xIllustration;
            int xId;
            int xDimesion_id;
            String xName;
            int xCategory_id;
            boolean xStatus;
            String xDescription;
            Subject x;
            while (rs.next()) {
                xId = rs.getInt("id");
                xIllustration = rs.getString("illustration");
                xDimesion_id = rs.getInt("dimension_id");

                xName = rs.getString("name");
                xCategory_id = rs.getInt("category_id");
                xStatus = rs.getBoolean("status");
                xDescription = rs.getString("description");

                x = new Subject(xId, xIllustration, xDimesion_id, xName, xCategory_id, xStatus, xDescription);
                t.add(x);
            }
            rs.close();
            ps.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return (t);
    }

    public List<Subject> getSubjectsByUserIDWithPaging(int userId, int page, int PAGE_SIZE) {
        List<Subject> t = new ArrayList<>();
        xSql = "SELECT s.*\n"
                + "FROM subject s \n"
                + "JOIN registration r ON s.id = r.subject_id\n"
                + "where r.user_id = ?\n"
                + "order by s.modified DESC\n"
                + "offset (?-1)*? row fetch next ? rows only";
        try {
            ps = con.prepareStatement(xSql);
            ps.setInt(1, userId);
            ps.setInt(2, page);
            ps.setInt(3, PAGE_SIZE);
            ps.setInt(4, PAGE_SIZE);
            rs = ps.executeQuery();
            String xIllustration;
            int xId;
            int xDimesion_id;
            String xName;
            int xCategory_id;
            boolean xStatus;
            String xDescription;
            Date xModified;
            boolean xFeatured;
            Subject x;
            while (rs.next()) {
                xId = rs.getInt("id");
                xIllustration = rs.getString("illustration");
                xDimesion_id = rs.getInt("dimension_id");
                xModified = rs.getDate("modified");
                xName = rs.getString("name");
                xCategory_id = rs.getInt("category_id");
                xStatus = rs.getBoolean("status");
                xDescription = rs.getString("description");
                xFeatured = rs.getBoolean("featured");
                x = new Subject(xId, xIllustration, xDimesion_id, xName, xCategory_id, xStatus, xDescription, xModified, xFeatured);
                t.add(x);
            }
            rs.close();
            ps.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return (t);
    }

    public int getTotalRegistedSubject(int userId) {
        xSql = "select count(s.id) \n"
                + "from subject s\n"
                + "JOIN registration r ON s.id = r.subject_id\n"
                + "where r.user_id = ?";
        int totalSubject = 0;
        try {
            ps = con.prepareStatement(xSql);
            ps.setInt(1, userId);

            rs = ps.executeQuery();
            while (rs.next()) {
                return rs.getInt(1);
            }
            rs.close();
            ps.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return (totalSubject);
    }

    public List<Subject> getSubjectsNotRegistedByUserIDWithPaging(int userId, int page, int PAGE_SIZE) {
        List<Subject> t = new ArrayList<>();
        xSql = "SELECT s.*\n"
                + "FROM subject s\n"
                + "LEFT JOIN registration r ON s.id = r.subject_id AND r.user_id = ?\n"
                + "WHERE r.subject_id IS NULL\n"
                + "ORDER BY s.modified DESC\n"
                + "offset (?-1)*? row fetch next ? rows only";
        try {
            ps = con.prepareStatement(xSql);
            ps.setInt(1, userId);
            ps.setInt(2, page);
            ps.setInt(3, PAGE_SIZE);
            ps.setInt(4, PAGE_SIZE);
            rs = ps.executeQuery();
            String xIllustration;
            int xId;
            int xDimesion_id;
            String xName;
            int xCategory_id;
            boolean xStatus;
            String xDescription;
            Date xModified;
            boolean xFeatured;
            Subject x;
            while (rs.next()) {
                xId = rs.getInt("id");
                xIllustration = rs.getString("illustration");
                xDimesion_id = rs.getInt("dimension_id");
                xModified = rs.getDate("modified");
                xName = rs.getString("name");
                xCategory_id = rs.getInt("category_id");
                xStatus = rs.getBoolean("status");
                xDescription = rs.getString("description");
                xFeatured = rs.getBoolean("featured");

                x = new Subject(xId, xIllustration, xDimesion_id, xName, xCategory_id, xStatus, xDescription, xModified, xFeatured);
                t.add(x);
            }
            rs.close();
            ps.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return (t);
    }

    public int getTotalNotRegistedSubject(int userId) {
        xSql = "select count(s.id) \n"
                + "from subject s\n"
                + "LEFT JOIN registration r ON s.id = r.subject_id AND r.user_id = ?\n"
                + "WHERE r.subject_id IS NULL";
        int totalSubject = 0;
        try {
            ps = con.prepareStatement(xSql);
            ps.setInt(1, userId);

            rs = ps.executeQuery();
            while (rs.next()) {
                return rs.getInt(1);
            }
            rs.close();
            ps.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return (totalSubject);
    }

    public List<Subject> searchInAllSubject(String keyword, int page, int PAGE_SIZE) {
        List<Subject> t = new ArrayList<>();
        xSql = "select * from subject\n"
                + "where name like ?\n"
                + "order by subject.modified DESC\n"
                + "offset (?-1)*? row fetch next ? rows only";
        try {
            ps = con.prepareStatement(xSql);
            ps.setString(1, "%" + keyword + "%");
            ps.setInt(2, page);
            ps.setInt(3, PAGE_SIZE);
            ps.setInt(4, PAGE_SIZE);
            rs = ps.executeQuery();
            String xIllustration;
            int xId;
            int xDimesion_id;
            String xName;
            int xCategory_id;
            boolean xStatus;
            String xDescription;
            Date xModified;
            boolean xFeatured;
            Subject x;
            while (rs.next()) {
                xId = rs.getInt("id");
                xIllustration = rs.getString("illustration");
                xDimesion_id = rs.getInt("dimension_id");
                xModified = rs.getDate("modified");
                xName = rs.getString("name");
                xCategory_id = rs.getInt("category_id");
                xStatus = rs.getBoolean("status");
                xDescription = rs.getString("description");
                xFeatured = rs.getBoolean("featured");

                x = new Subject(xId, xIllustration, xDimesion_id, xName, xCategory_id, xStatus, xDescription, xModified, xFeatured);
                t.add(x);
            }
            rs.close();
            ps.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return (t);
    }

    public int getTotalSubjectWithKeyword(String keyword) {
        xSql = "select count(id)\n"
                + "from subject\n"
                + "where name like ?";
        int totalSubject = 0;
        try {
            ps = con.prepareStatement(xSql);
            ps.setString(1, "%" + keyword + "%");
            rs = ps.executeQuery();
            while (rs.next()) {
                return rs.getInt(1);
            }
            rs.close();
            ps.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return (totalSubject);
    }

    public List<Subject> searchInFeatturedSubject(String keyword, int page, int PAGE_SIZE) {
        List<Subject> t = new ArrayList<>();
        xSql = "select * from subject\n"
                + "where featured = 1 and name like ?\n"
                + "order by subject.modified DESC\n"
                + "offset (?-1)*? row fetch next ? rows only";
        try {
            ps = con.prepareStatement(xSql);
            ps.setString(1, "%" + keyword + "%");
            ps.setInt(2, page);
            ps.setInt(3, PAGE_SIZE);
            ps.setInt(4, PAGE_SIZE);
            rs = ps.executeQuery();
            String xIllustration;
            int xId;
            int xDimesion_id;
            String xName;
            int xCategory_id;
            boolean xStatus;
            String xDescription;
            Date xModified;
            boolean xFeatured;
            Subject x;
            while (rs.next()) {
                xId = rs.getInt("id");
                xIllustration = rs.getString("illustration");
                xDimesion_id = rs.getInt("dimension_id");
                xModified = rs.getDate("modified");
                xName = rs.getString("name");
                xCategory_id = rs.getInt("category_id");
                xStatus = rs.getBoolean("status");
                xDescription = rs.getString("description");
                xFeatured = rs.getBoolean("featured");

                x = new Subject(xId, xIllustration, xDimesion_id, xName, xCategory_id, xStatus, xDescription, xModified, xFeatured);
                t.add(x);
            }
            rs.close();
            ps.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return (t);
    }

    public int getTotalFeaturedSubjectWithKeyword(String keyword) {
        xSql = "select count(id)\n"
                + "from subject\n"
                + "where featured = 1 and name like ?";
        int totalSubject = 0;
        try {
            ps = con.prepareStatement(xSql);
            ps.setString(1, "%" + keyword + "%");
            rs = ps.executeQuery();
            while (rs.next()) {
                return rs.getInt(1);
            }
            rs.close();
            ps.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return (totalSubject);
    }

    public List<Subject> searchSubjectsByUserIDWithPaging(String keyword, int userId, int page, int PAGE_SIZE) {
        List<Subject> t = new ArrayList<>();
        xSql = "SELECT s.*\n"
                + "FROM subject s \n"
                + "JOIN registration r ON s.id = r.subject_id\n"
                + "where r.user_id = ? and s.name like ?\n"
                + "order by s.modified DESC\n"
                + "offset (?-1)*? row fetch next ? rows only";
        try {
            ps = con.prepareStatement(xSql);
            ps.setInt(1, userId);
            ps.setString(2, "%" + keyword + "%");
            ps.setInt(3, page);
            ps.setInt(4, PAGE_SIZE);
            ps.setInt(5, PAGE_SIZE);
            rs = ps.executeQuery();
            String xIllustration;
            int xId;
            int xDimesion_id;
            String xName;
            int xCategory_id;
            boolean xStatus;
            String xDescription;
            Date xModified;
            boolean xFeatured;
            Subject x;
            while (rs.next()) {
                xId = rs.getInt("id");
                xIllustration = rs.getString("illustration");
                xDimesion_id = rs.getInt("dimension_id");
                xModified = rs.getDate("modified");
                xName = rs.getString("name");
                xCategory_id = rs.getInt("category_id");
                xStatus = rs.getBoolean("status");
                xDescription = rs.getString("description");
                xFeatured = rs.getBoolean("featured");
                x = new Subject(xId, xIllustration, xDimesion_id, xName, xCategory_id, xStatus, xDescription, xModified, xFeatured);
                t.add(x);
            }
            rs.close();
            ps.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return (t);
    }

    public int getTotalRegistedSubjectWithKeyword(int userId, String keyword) {
        xSql = "select count(s.id) \n"
                + "from subject s\n"
                + "JOIN registration r ON s.id = r.subject_id\n"
                + "where r.user_id = ? and a.name like ?";
        int totalSubject = 0;
        try {
            ps = con.prepareStatement(xSql);
            ps.setInt(1, userId);
            ps.setString(2, "%" + keyword + "%");
            rs = ps.executeQuery();
            while (rs.next()) {
                return rs.getInt(1);
            }
            rs.close();
            ps.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return (totalSubject);
    }

    public List<Subject> searchSubjectsNotRegistedByUserIDWithPaging(String keyword, int userId, int page, int PAGE_SIZE) {
        List<Subject> t = new ArrayList<>();
        xSql = "SELECT s.*\n"
                + "FROM subject s\n"
                + "LEFT JOIN registration r ON s.id = r.subject_id AND r.user_id = ?\n"
                + "WHERE r.subject_id IS NULL and s.name like ?\n"
                + "ORDER BY s.modified DESC\n"
                + "offset (?-1)*? row fetch next ? rows only";
        try {
            ps = con.prepareStatement(xSql);
            ps.setInt(1, userId);
            ps.setString(2, "%" + keyword + "%");
            ps.setInt(3, page);
            ps.setInt(4, PAGE_SIZE);
            ps.setInt(5, PAGE_SIZE);
            rs = ps.executeQuery();
            String xIllustration;
            int xId;
            int xDimesion_id;
            String xName;
            int xCategory_id;
            boolean xStatus;
            String xDescription;
            Date xModified;
            boolean xFeatured;
            Subject x;
            while (rs.next()) {
                xId = rs.getInt("id");
                xIllustration = rs.getString("illustration");
                xDimesion_id = rs.getInt("dimension_id");
                xModified = rs.getDate("modified");
                xName = rs.getString("name");
                xCategory_id = rs.getInt("category_id");
                xStatus = rs.getBoolean("status");
                xDescription = rs.getString("description");
                xFeatured = rs.getBoolean("featured");

                x = new Subject(xId, xIllustration, xDimesion_id, xName, xCategory_id, xStatus, xDescription, xModified, xFeatured);
                t.add(x);
            }
            rs.close();
            ps.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return (t);
    }

    public int getTotalNotRegistedSubjectWithKeyword(int userId, String keyword) {
        xSql = "select count(s.id) \n"
                + "from subject s\n"
                + "LEFT JOIN registration r ON s.id = r.subject_id AND r.user_id = ?\n"
                + "WHERE r.subject_id IS NULL and s.name like ?";
        int totalSubject = 0;
        try {
            ps = con.prepareStatement(xSql);
            ps.setInt(1, userId);
            ps.setString(2, "%" + keyword + "%");
            rs = ps.executeQuery();
            while (rs.next()) {
                return rs.getInt(1);
            }
            rs.close();
            ps.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return (totalSubject);
    }

    public List<Subject> getSubjectsByCategoryAndPaging(int categoryId, int page, int PAGE_SIZE) {
        List<Subject> t = new ArrayList<>();
        xSql = "select * from subject\n"
                + "where category_id =?\n"
                + "order by subject.modified DESC\n"
                + "offset (?-1)*? row fetch next ? rows only";
        try {
            ps = con.prepareStatement(xSql);
            ps.setInt(1, categoryId);
            ps.setInt(2, page);
            ps.setInt(3, PAGE_SIZE);
            ps.setInt(4, PAGE_SIZE);
            rs = ps.executeQuery();
            int xID;
            String xIllustratoin;
            int xDimesion_id;
            String xName;
            int xCategory;
            boolean xStatus;
            String xDescription;
            boolean xFeatured;
            Date xModified;
            Subject x;
            while (rs.next()) {
                xID = rs.getInt("id");
                xIllustratoin = rs.getString("illustration");
                xDimesion_id = rs.getInt("dimension_id");
                xModified = rs.getDate("modified");
                xName = rs.getString("name");
                xCategory = rs.getInt("category_id");
                xStatus = rs.getBoolean("status");
                xDescription = rs.getString("description");
                xFeatured = rs.getBoolean("featured");
                x = new Subject(xID, xIllustratoin, xDimesion_id, xName, xCategory, xStatus, xDescription, xModified, xFeatured);
                t.add(x);
            }
            rs.close();
            ps.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return (t);
    }

    public int getTotalSubjectByCategory(int categoryId) {
        xSql = "select count(id) from subject\n"
                + "where category_id = ?";
        int totalSubject = 0;
        try {
            ps = con.prepareStatement(xSql);
            ps.setInt(1, categoryId);
            rs = ps.executeQuery();
            while (rs.next()) {
                return rs.getInt(1);
            }
            rs.close();
            ps.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return (totalSubject);
    }

    public List<Subject> getFeaturedSubjectsWithCategoryAndPaging(int categoryId, int page, int PAGE_SIZE) {
        List<Subject> t = new ArrayList<>();
        xSql = "Select * from subject\n"
                + "where featured = 1 and category_id = ?\n"
                + "order by modified DESC\n"
                + "offset (?-1)*? row fetch next ? rows only";
        try {
            ps = con.prepareStatement(xSql);
            ps.setInt(1, categoryId);
            ps.setInt(2, page);
            ps.setInt(3, PAGE_SIZE);
            ps.setInt(4, PAGE_SIZE);
            rs = ps.executeQuery();
            int xID;
            String xIllustratoin;
            int xDimesion_id;
            String xName;
            int xCategory;
            boolean xStatus;
            String xDescription;
            Date xModified;
            boolean xFeatured;
            Subject x;
            while (rs.next()) {
                xID = rs.getInt("id");
                xIllustratoin = rs.getString("illustration");
                xDimesion_id = rs.getInt("dimension_id");
                xModified = rs.getDate("modified");
                xName = rs.getString("name");
                xCategory = rs.getInt("category_id");
                xStatus = rs.getBoolean("status");
                xDescription = rs.getString("description");
                xFeatured = rs.getBoolean("featured");
                x = new Subject(xID, xIllustratoin, xDimesion_id, xName, xCategory, xStatus, xDescription, xModified, xFeatured);
                t.add(x);
            }
            rs.close();
            ps.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return (t);
    }

    public int getTotalFeaturedSubjectByCategory(int categoryId) {
        xSql = "select count(id) from subject where featured = 1 and category_id = ?";
        int totalSubject = 0;
        try {
            ps = con.prepareStatement(xSql);
            ps.setInt(1, categoryId);
            rs = ps.executeQuery();
            while (rs.next()) {
                return rs.getInt(1);
            }
            rs.close();
            ps.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return (totalSubject);
    }

    public List<Subject> getSubjectsByCategoryAndUserIDWithPaging(int userId, int categoryId, int page, int PAGE_SIZE) {
        List<Subject> t = new ArrayList<>();
        xSql = "SELECT s.*\n"
                + "FROM subject s \n"
                + "JOIN registration r ON s.id = r.subject_id\n"
                + "where r.user_id = ? and s.category_id = ?\n"
                + "order by s.modified DESC\n"
                + "offset (?-1)*? row fetch next ? rows only";
        try {
            ps = con.prepareStatement(xSql);
            ps.setInt(1, userId);
            ps.setInt(2, categoryId);
            ps.setInt(3, page);
            ps.setInt(4, PAGE_SIZE);
            ps.setInt(5, PAGE_SIZE);
            rs = ps.executeQuery();
            String xIllustration;
            int xId;
            int xDimesion_id;
            String xName;
            int xCategory_id;
            boolean xStatus;
            String xDescription;
            Date xModified;
            boolean xFeatured;
            Subject x;
            while (rs.next()) {
                xId = rs.getInt("id");
                xIllustration = rs.getString("illustration");
                xDimesion_id = rs.getInt("dimension_id");
                xModified = rs.getDate("modified");
                xName = rs.getString("name");
                xCategory_id = rs.getInt("category_id");
                xStatus = rs.getBoolean("status");
                xDescription = rs.getString("description");
                xFeatured = rs.getBoolean("featured");
                x = new Subject(xId, xIllustration, xDimesion_id, xName, xCategory_id, xStatus, xDescription, xModified, xFeatured);
                t.add(x);
            }
            rs.close();
            ps.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return (t);
    }

    public int getTotalRegistedSubjectWithCategory(int userId, int categoryId) {
        xSql = "select count(s.id) \n"
                + "from subject s\n"
                + "JOIN registration r ON s.id = r.subject_id\n"
                + "where r.user_id = ? and s.category_id = ?";
        int totalSubject = 0;
        try {
            ps = con.prepareStatement(xSql);
            ps.setInt(1, userId);
            ps.setInt(2, categoryId);
            rs = ps.executeQuery();
            while (rs.next()) {
                return rs.getInt(1);
            }
            rs.close();
            ps.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return (totalSubject);
    }

    public List<Subject> getSubjectsNotRegistedByCategoryAndUserIDWithPaging(int userId, int categoryId, int page, int PAGE_SIZE) {
        List<Subject> t = new ArrayList<>();
        xSql = "SELECT s.*\n"
                + "FROM subject s\n"
                + "LEFT JOIN registration r ON s.id = r.subject_id AND r.user_id = ?\n"
                + "WHERE r.subject_id IS NULL and s.category_id = ?\n"
                + "ORDER BY s.modified DESC\n"
                + "offset (?-1)*? row fetch next ? rows only";
        try {
            ps = con.prepareStatement(xSql);
            ps.setInt(1, userId);
            ps.setInt(2, categoryId);
            ps.setInt(3, page);
            ps.setInt(4, PAGE_SIZE);
            ps.setInt(5, PAGE_SIZE);
            rs = ps.executeQuery();
            String xIllustration;
            int xId;
            int xDimesion_id;
            String xName;
            int xCategory_id;
            boolean xStatus;
            String xDescription;
            Date xModified;
            boolean xFeatured;
            Subject x;
            while (rs.next()) {
                xId = rs.getInt("id");
                xIllustration = rs.getString("illustration");
                xDimesion_id = rs.getInt("dimension_id");
                xModified = rs.getDate("modified");
                xName = rs.getString("name");
                xCategory_id = rs.getInt("category_id");
                xStatus = rs.getBoolean("status");
                xDescription = rs.getString("description");
                xFeatured = rs.getBoolean("featured");

                x = new Subject(xId, xIllustration, xDimesion_id, xName, xCategory_id, xStatus, xDescription, xModified, xFeatured);
                t.add(x);
            }
            rs.close();
            ps.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return (t);
    }
    
     public int getTotalNotRegistedSubjectWithCategory(int userId, int categoryId) {
        xSql = "select count(s.id) \n"
                + "from subject s\n"
                + "LEFT JOIN registration r ON s.id = r.subject_id AND r.user_id = ?\n"
                + "WHERE r.subject_id IS NULL and s.category_id = ?";
        int totalSubject = 0;
        try {
            ps = con.prepareStatement(xSql);
            ps.setInt(1, userId);
            ps.setInt(2, categoryId);

            rs = ps.executeQuery();
            while (rs.next()) {
                return rs.getInt(1);
            }
            rs.close();
            ps.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return (totalSubject);
    }
}
