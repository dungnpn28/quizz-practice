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

    public List<Subject> getSubjectsWithPaging(int index, String category, String status, String search, int id, int role_id) {
        List<Subject> t = new ArrayList<>();
        if (role_id == 5) {

            xSql = "select id,illustration,name,category_id,[status],[description],author_id,[modified],[featured] from subject WHERE 1=1";

            if (!category.equals("all")) {
                xSql += " and [category_id]= ?";
            }
            if (!status.equals("all")) {
                xSql += " and [status]= ?";
            }

            xSql += " and [name] like ? ";
            xSql += " order by [modified] desc offset ? rows fetch next 5 rows only";

            try {
                ps = con.prepareStatement(xSql);
                int i = 1;
                if (!category.equals("all")) {
                    ps.setInt(i, Integer.parseInt(category));
                    i++;
                }

                if (!status.equals("all")) {
                    ps.setInt(i, Integer.parseInt(status));
                    i++;
                }
                ps.setString(i, "%" + search + "%");
                i++;
                ps.setInt(i, (index - 1) * 5);

                rs = ps.executeQuery();
                int xID;
                String xIllustratoin;
//            int xDimesion_id;
                String xName;
                int xCategory;
                boolean xStatus;
                String xDescription;
                Date xModified;
                boolean xFeatured;
                int xAuthor_id;
                Subject x;
                while (rs.next()) {
                    xID = rs.getInt("id");
                    xIllustratoin = rs.getString("illustration");
//                xDimesion_id = rs.getInt("dimension_id");
                    xModified = rs.getDate("modified");
                    xName = rs.getString("name");
                    xCategory = rs.getInt("category_id");
                    xStatus = rs.getBoolean("status");
                    xDescription = rs.getString("description");
                    xFeatured = rs.getBoolean("featured");
                    xAuthor_id = rs.getInt("author_id");
                    x = new Subject(xID, xIllustratoin, xName, xCategory, xStatus, xDescription, xModified, xFeatured, xAuthor_id);
                    t.add(x);
                }
                rs.close();
                ps.close();
            } catch (Exception e) {
                e.printStackTrace();
            }
        } else {

            xSql = "select id,illustration,name,category_id,[status],[description],author_id,[modified],[featured] from subject WHERE 1=1";

            if (!category.equals("all")) {
                xSql += " and [category_id]= ?";
            }
            if (!status.equals("all")) {
                xSql += " and [status]= ?";
            }

            xSql += " and [name] like ? and author_id =? ";
            xSql += " order by [modified] desc offset ? rows fetch next 5 rows only";

            try {
                ps = con.prepareStatement(xSql);
                int i = 1;
                if (!category.equals("all")) {
                    ps.setInt(i, Integer.parseInt(category));
                    i++;
                }

                if (!status.equals("all")) {
                    ps.setInt(i, Integer.parseInt(status));
                    i++;
                }
                ps.setString(i, "%" + search + "%");
                i++;
                ps.setInt(i, id);
                i++;
                ps.setInt(i, (index - 1) * 5);

                rs = ps.executeQuery();
                int xID;
                String xIllustratoin;
//            int xDimesion_id;
                String xName;
                int xCategory;
                boolean xStatus;
                String xDescription;
                Date xModified;
                boolean xFeatured;
                int xAuthor_id;
                Subject x;
                while (rs.next()) {
                    xID = rs.getInt("id");
                    xIllustratoin = rs.getString("illustration");
//                xDimesion_id = rs.getInt("dimension_id");
                    xModified = rs.getDate("modified");
                    xName = rs.getString("name");
                    xCategory = rs.getInt("category_id");
                    xStatus = rs.getBoolean("status");
                    xDescription = rs.getString("description");
                    xFeatured = rs.getBoolean("featured");
                    xAuthor_id = rs.getInt("author_id");
                    x = new Subject(xID, xIllustratoin, xName, xCategory, xStatus, xDescription, xModified, xFeatured, xAuthor_id);
                    t.add(x);
                }
                rs.close();
                ps.close();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return (t);

    }

    public List<Subject> getSubjects() {
        List<Subject> t = new ArrayList<>();
        xSql = "select * from subject";
        try {
            ps = con.prepareStatement(xSql);
            rs = ps.executeQuery();
            int xID;
            String xIllustratoin;
//            int xDimesion_id;
            String xName;
            int xCategory_id;
            boolean xStatus;
            String xDescription;
            int xAuthor_id;
            Date xModified;
            boolean xFeatured;

            Subject x;
            while (rs.next()) {
                xID = rs.getInt("id");
                xIllustratoin = rs.getString("illustration");
//                xDimesion_id = rs.getInt("dimension_id");
                xModified = rs.getDate("modified");
                xName = rs.getString("name");
                xCategory_id = rs.getInt("category_id");
                xStatus = rs.getBoolean("status");
                xAuthor_id = rs.getInt("author_id");
                xDescription = rs.getString("description");
                xFeatured = rs.getBoolean("featured");
                xAuthor_id = rs.getInt("author_id");
                x = new Subject(xID, xIllustratoin, xName, xCategory_id, xStatus, xDescription, xModified, xFeatured, xAuthor_id);
                t.add(x);
            }
            rs.close();
            ps.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return (t);
    }

    public int getTotalSubjectFilter(String category, String status, String search, int id, int role_id) {
        try {

            if (role_id == 5) {
                String strSelect = "select count(*) from subject  WHERE 1=1 ";
                if (!category.equals("all")) {
                    strSelect += " and [category_id]= ?";
                }

                if (!status.equals("all")) {
                    strSelect += " and [status]= ?";

                }
                strSelect += " and [name] like ? ";
                ps = con.prepareStatement(strSelect);
                int i = 1;
                if (!category.equals("all")) {
                    ps.setInt(i, Integer.parseInt(category));
                    i++;
                }

                if (!status.equals("all")) {
                    ps.setInt(i, Integer.parseInt(status));
                    i++;
                }
                ps.setString(i, "%" + search + "%");

                rs = ps.executeQuery();
                while (rs.next()) {
                    return rs.getInt(1);
                }
            } else if (role_id == 4) {
                String strSelect = "select count(*) from subject  WHERE 1=1 ";
                if (!category.equals("all")) {
                    strSelect += " and [category_id]= ?";
                }

                if (!status.equals("all")) {
                    strSelect += " and [status]= ?";

                }
                strSelect += " and [name] like ? and author_id = ?  ";
                ps = con.prepareStatement(strSelect);
                int i = 1;
                if (!category.equals("all")) {
                    ps.setInt(i, Integer.parseInt(category));
                    i++;
                }

                if (!status.equals("all")) {
                    ps.setInt(i, Integer.parseInt(status));
                    i++;
                }
                ps.setString(i, "%" + search + "%");
                i++;
                ps.setInt(i, id);
                rs = ps.executeQuery();
                while (rs.next()) {
                    return rs.getInt(1);
                }
            }

        } catch (Exception e) {
            System.out.println("getTotalSubjectFilter: " + e.getMessage());
        }

        return 0;

    }

    public List<Subject> getSubjectsWithPaging(int page, int PAGE_SIZE) {
        List<Subject> t = new ArrayList<>();
        xSql = "SELECT s.*, (\n"
                + "  SELECT MIN(price) \n"
                + "  FROM subject_price_package spp\n"
                + "  JOIN price_package p ON spp.price_package_id = p.id\n"
                + "  WHERE spp.subject_id = s.id\n"
                + ") AS min_price,\n"
                + "(\n"
                + "  SELECT MIN(sale) \n"
                + "  FROM subject_price_package spp\n"
                + "  JOIN price_package p ON spp.price_package_id = p.id\n"
                + "  WHERE spp.subject_id = s.id\n"
                + ") AS min_sale\n"
                + "FROM subject s\n"
                + "order by s.modified DESC\n"
                + "offset (?-1)*? row fetch next ? rows only";
        try {
            ps = con.prepareStatement(xSql);
            ps.setInt(1, page);
            ps.setInt(2, PAGE_SIZE);
            ps.setInt(3, PAGE_SIZE);
            rs = ps.executeQuery();
            int xID;
            String xIllustratoin;
//            int xDimesion_id;
            String xName;
            int xCategory;
            boolean xStatus;
            String xDescription;
            boolean xFeatured;
            Date xModified;
            double xPrice;
            double xSale;
            Subject x;
            while (rs.next()) {
                xID = rs.getInt("id");
                xIllustratoin = rs.getString("illustration");
//                xDimesion_id = rs.getInt("dimension_id");
                xModified = rs.getDate("modified");
                xName = rs.getString("name");
                xCategory = rs.getInt("category_id");
                xStatus = rs.getBoolean("status");
                xDescription = rs.getString("description");
                xFeatured = rs.getBoolean("featured");
                xPrice = rs.getDouble("min_price");
                xSale = rs.getDouble("min_sale");
                x = new Subject(xID, xIllustratoin, xName, xCategory, xStatus, xDescription, xModified, xFeatured, xPrice, xSale);
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
        xSql = "SELECT s.*, (\n"
                + "  SELECT MIN(price) \n"
                + "  FROM subject_price_package spp\n"
                + "  JOIN price_package p ON spp.price_package_id = p.id\n"
                + "  WHERE spp.subject_id = s.id\n"
                + ") AS min_price,\n"
                + "(\n"
                + "  SELECT MIN(sale) \n"
                + "  FROM subject_price_package spp\n"
                + "  JOIN price_package p ON spp.price_package_id = p.id\n"
                + "  WHERE spp.subject_id = s.id\n"
                + ") AS min_sale\n"
                + "FROM subject s\n"
                + "where s.featured = 1\n"
                + "order by s.modified DESC\n"
                + "offset (?-1)*? row fetch next ? rows only";
        try {
            ps = con.prepareStatement(xSql);
            ps.setInt(1, page);
            ps.setInt(2, PAGE_SIZE);
            ps.setInt(3, PAGE_SIZE);
            rs = ps.executeQuery();
            int xID;
            String xIllustratoin;
//            int xDimesion_id;
            String xName;
            int xCategory;
            boolean xStatus;
            String xDescription;
            Date xModified;
            boolean xFeatured;
            double xPrice;
            double xSale;
            Subject x;
            while (rs.next()) {
                xID = rs.getInt("id");
                xIllustratoin = rs.getString("illustration");
//                xDimesion_id = rs.getInt("dimension_id");
                xModified = rs.getDate("modified");
                xName = rs.getString("name");
                xCategory = rs.getInt("category_id");
                xStatus = rs.getBoolean("status");
                xDescription = rs.getString("description");
                xFeatured = rs.getBoolean("featured");
                xPrice = rs.getDouble("min_price");
                xSale = rs.getDouble("min_sale");
                x = new Subject(xID, xIllustratoin, xName, xCategory, xStatus, xDescription, xModified, xFeatured, xPrice, xSale);
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
        xSql = "SELECT s.*, (\n"
                + "  SELECT MIN(price) \n"
                + "  FROM subject_price_package spp\n"
                + "  JOIN price_package p ON spp.price_package_id = p.id\n"
                + "  WHERE spp.subject_id = s.id\n"
                + ") AS min_price,\n"
                + "(\n"
                + "  SELECT MIN(sale) \n"
                + "  FROM subject_price_package spp\n"
                + "  JOIN price_package p ON spp.price_package_id = p.id\n"
                + "  WHERE spp.subject_id = s.id\n"
                + ") AS min_sale\n"
                + "FROM subject s\n"
                + "JOIN registration r ON s.id = r.subject_id\n"
                + "where r.user_id = ?\n"
                + "order by s.modified DESC";
        try {
            ps = con.prepareStatement(xSql);
            ps.setInt(1, userId);
            rs = ps.executeQuery();
            int xID;
            String xIllustratoin;
//            int xDimesion_id;
            String xName;
            int xCategory;
            boolean xStatus;
            String xDescription;
            Date xModified;
            boolean xFeatured;
            double xPrice;
            double xSale;
            Subject x;
            while (rs.next()) {
                xID = rs.getInt("id");
                xIllustratoin = rs.getString("illustration");
//                xDimesion_id = rs.getInt("dimension_id");
                xModified = rs.getDate("modified");
                xName = rs.getString("name");
                xCategory = rs.getInt("category_id");
                xStatus = rs.getBoolean("status");
                xDescription = rs.getString("description");
                xFeatured = rs.getBoolean("featured");
                xPrice = rs.getDouble("min_price");
                xSale = rs.getDouble("min_sale");
                x = new Subject(xID, xIllustratoin, xName, xCategory, xStatus, xDescription, xModified, xFeatured, xPrice, xSale);
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
        xSql = "SELECT s.*, (\n"
                + "  SELECT MIN(price) \n"
                + "  FROM subject_price_package spp\n"
                + "  JOIN price_package p ON spp.price_package_id = p.id\n"
                + "  WHERE spp.subject_id = s.id\n"
                + ") AS min_price,\n"
                + "(\n"
                + "  SELECT MIN(sale) \n"
                + "  FROM subject_price_package spp\n"
                + "  JOIN price_package p ON spp.price_package_id = p.id\n"
                + "  WHERE spp.subject_id = s.id\n"
                + ") AS min_sale\n"
                + "FROM subject s\n"
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
//            int xDimesion_id;
            String xName;
            int xCategory_id;
            boolean xStatus;
            String xDescription;
            Date xModified;
            boolean xFeatured;
            double xPrice;
            double xSale;
            Subject x;
            while (rs.next()) {
                xId = rs.getInt("id");
                xIllustration = rs.getString("illustration");
//                xDimesion_id = rs.getInt("dimension_id");
                xModified = rs.getDate("modified");
                xName = rs.getString("name");
                xCategory_id = rs.getInt("category_id");
                xStatus = rs.getBoolean("status");
                xDescription = rs.getString("description");
                xFeatured = rs.getBoolean("featured");
                xPrice = rs.getDouble("min_price");
                xSale = rs.getDouble("min_sale");
                x = new Subject(xId, xIllustration, xName, xCategory_id, xStatus, xDescription, xModified, xFeatured, xPrice, xSale);
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
        xSql = "SELECT s.*, (\n"
                + "  SELECT MIN(price) \n"
                + "  FROM subject_price_package spp\n"
                + "  JOIN price_package p ON spp.price_package_id = p.id\n"
                + "  WHERE spp.subject_id = s.id\n"
                + ") AS min_price,\n"
                + "(\n"
                + "  SELECT MIN(sale) \n"
                + "  FROM subject_price_package spp\n"
                + "  JOIN price_package p ON spp.price_package_id = p.id\n"
                + "  WHERE spp.subject_id = s.id\n"
                + ") AS min_sale\n"
                + "FROM subject s\n"
                + "LEFT JOIN registration r ON s.id = r.subject_id AND r.user_id = ?\n"
                + "                WHERE r.subject_id IS NULL\n"
                + "                ORDER BY s.modified DESC\n"
                + "                offset (?-1)*? row fetch next ? rows only";
        try {
            ps = con.prepareStatement(xSql);
            ps.setInt(1, userId);
            ps.setInt(2, page);
            ps.setInt(3, PAGE_SIZE);
            ps.setInt(4, PAGE_SIZE);
            rs = ps.executeQuery();
            String xIllustration;
            int xId;
//            int xDimesion_id;
            String xName;
            int xCategory_id;
            boolean xStatus;
            String xDescription;
            Date xModified;
            boolean xFeatured;
            double xPrice;
            double xSale;
            Subject x;
            while (rs.next()) {
                xId = rs.getInt("id");
                xIllustration = rs.getString("illustration");
//                xDimesion_id = rs.getInt("dimension_id");
                xModified = rs.getDate("modified");
                xName = rs.getString("name");
                xCategory_id = rs.getInt("category_id");
                xStatus = rs.getBoolean("status");
                xDescription = rs.getString("description");
                xFeatured = rs.getBoolean("featured");

                xPrice = rs.getDouble("min_price");
                xSale = rs.getDouble("min_sale");
                x = new Subject(xId, xIllustration, xName, xCategory_id, xStatus, xDescription, xModified, xFeatured, xPrice, xSale);
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
        xSql = "SELECT s.*, (\n"
                + "  SELECT MIN(price) \n"
                + "  FROM subject_price_package spp\n"
                + "  JOIN price_package p ON spp.price_package_id = p.id\n"
                + "  WHERE spp.subject_id = s.id\n"
                + ") AS min_price,\n"
                + "(\n"
                + "  SELECT MIN(sale) \n"
                + "  FROM subject_price_package spp\n"
                + "  JOIN price_package p ON spp.price_package_id = p.id\n"
                + "  WHERE spp.subject_id = s.id\n"
                + ") AS min_sale\n"
                + "FROM subject s\n"
                + "where name like ?\n"
                + "order by s.modified DESC\n"
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
//            int xDimesion_id;
            String xName;
            int xCategory_id;
            boolean xStatus;
            String xDescription;
            Date xModified;
            boolean xFeatured;
            double xPrice;
            double xSale;
            Subject x;
            while (rs.next()) {
                xId = rs.getInt("id");
                xIllustration = rs.getString("illustration");
//                xDimesion_id = rs.getInt("dimension_id");
                xModified = rs.getDate("modified");
                xName = rs.getString("name");
                xCategory_id = rs.getInt("category_id");
                xStatus = rs.getBoolean("status");
                xDescription = rs.getString("description");
                xFeatured = rs.getBoolean("featured");

                xPrice = rs.getDouble("min_price");
                xSale = rs.getDouble("min_sale");
                x = new Subject(xId, xIllustration, xName, xCategory_id, xStatus, xDescription, xModified, xFeatured, xPrice, xSale);
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
        xSql = "SELECT s.*, (\n"
                + "  SELECT MIN(price) \n"
                + "  FROM subject_price_package spp\n"
                + "  JOIN price_package p ON spp.price_package_id = p.id\n"
                + "  WHERE spp.subject_id = s.id\n"
                + ") AS min_price,\n"
                + "(\n"
                + "  SELECT MIN(sale) \n"
                + "  FROM subject_price_package spp\n"
                + "  JOIN price_package p ON spp.price_package_id = p.id\n"
                + "  WHERE spp.subject_id = s.id\n"
                + ") AS min_sale\n"
                + "FROM subject s\n"
                + "where s.featured = 1 and s.name like ?\n"
                + "order by s.modified DESC\n"
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
//            int xDimesion_id;
            String xName;
            int xCategory_id;
            boolean xStatus;
            String xDescription;
            Date xModified;
            boolean xFeatured;
            double xPrice;
            double xSale;
            Subject x;
            while (rs.next()) {
                xId = rs.getInt("id");
                xIllustration = rs.getString("illustration");
//                xDimesion_id = rs.getInt("dimension_id");
                xModified = rs.getDate("modified");
                xName = rs.getString("name");
                xCategory_id = rs.getInt("category_id");
                xStatus = rs.getBoolean("status");
                xDescription = rs.getString("description");
                xFeatured = rs.getBoolean("featured");

                xPrice = rs.getDouble("min_price");
                xSale = rs.getDouble("min_sale");
                x = new Subject(xId, xIllustration, xName, xCategory_id, xStatus, xDescription, xModified, xFeatured, xPrice, xSale);
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
        xSql = "SELECT s.*, (\n"
                + "  SELECT MIN(price) \n"
                + "  FROM subject_price_package spp\n"
                + "  JOIN price_package p ON spp.price_package_id = p.id\n"
                + "  WHERE spp.subject_id = s.id\n"
                + ") AS min_price,\n"
                + "(\n"
                + "  SELECT MIN(sale) \n"
                + "  FROM subject_price_package spp\n"
                + "  JOIN price_package p ON spp.price_package_id = p.id\n"
                + "  WHERE spp.subject_id = s.id\n"
                + ") AS min_sale\n"
                + "FROM subject s\n"
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
//            int xDimesion_id;
            String xName;
            int xCategory_id;
            boolean xStatus;
            String xDescription;
            Date xModified;
            boolean xFeatured;
            double xPrice;
            double xSale;
            Subject x;
            while (rs.next()) {
                xId = rs.getInt("id");
                xIllustration = rs.getString("illustration");
//                xDimesion_id = rs.getInt("dimension_id");
                xModified = rs.getDate("modified");
                xName = rs.getString("name");
                xCategory_id = rs.getInt("category_id");
                xStatus = rs.getBoolean("status");
                xDescription = rs.getString("description");
                xFeatured = rs.getBoolean("featured");
                xPrice = rs.getDouble("min_price");
                xSale = rs.getDouble("min_sale");
                x = new Subject(xId, xIllustration, xName, xCategory_id, xStatus, xDescription, xModified, xFeatured, xPrice, xSale);
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
                + "where r.user_id = ? and s.name like ?";
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
        xSql = "SELECT s.*, (\n"
                + "  SELECT MIN(price) \n"
                + "  FROM subject_price_package spp\n"
                + "  JOIN price_package p ON spp.price_package_id = p.id\n"
                + "  WHERE spp.subject_id = s.id\n"
                + ") AS min_price,\n"
                + "(\n"
                + "  SELECT MIN(sale) \n"
                + "  FROM subject_price_package spp\n"
                + "  JOIN price_package p ON spp.price_package_id = p.id\n"
                + "  WHERE spp.subject_id = s.id\n"
                + ") AS min_sale\n"
                + "FROM subject s\n"
                + "LEFT JOIN registration r ON s.id = r.subject_id AND r.user_id = ?\n"
                + "                WHERE r.subject_id IS NULL and s.name like ?\n"
                + "                ORDER BY s.modified DESC\n"
                + "                offset (?-1)*? row fetch next ? rows only";
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
//            int xDimesion_id;
            String xName;
            int xCategory_id;
            boolean xStatus;
            String xDescription;
            Date xModified;
            boolean xFeatured;
            double xPrice;
            double xSale;
            Subject x;
            while (rs.next()) {
                xId = rs.getInt("id");
                xIllustration = rs.getString("illustration");
//                xDimesion_id = rs.getInt("dimension_id");
                xModified = rs.getDate("modified");
                xName = rs.getString("name");
                xCategory_id = rs.getInt("category_id");
                xStatus = rs.getBoolean("status");
                xDescription = rs.getString("description");
                xFeatured = rs.getBoolean("featured");

                xPrice = rs.getDouble("min_price");
                xSale = rs.getDouble("min_sale");
                x = new Subject(xId, xIllustration, xName, xCategory_id, xStatus, xDescription, xModified, xFeatured, xPrice, xSale);
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
        xSql = "SELECT s.*, (\n"
                + "  SELECT MIN(price) \n"
                + "  FROM subject_price_package spp\n"
                + "  JOIN price_package p ON spp.price_package_id = p.id\n"
                + "  WHERE spp.subject_id = s.id\n"
                + ") AS min_price,\n"
                + "(\n"
                + "  SELECT MIN(sale) \n"
                + "  FROM subject_price_package spp\n"
                + "  JOIN price_package p ON spp.price_package_id = p.id\n"
                + "  WHERE spp.subject_id = s.id\n"
                + ") AS min_sale\n"
                + "FROM subject s\n"
                + "where category_id =?\n"
                + "                order by s.modified DESC\n"
                + "                offset (?-1)*? row fetch next ? rows only";
        try {
            ps = con.prepareStatement(xSql);
            ps.setInt(1, categoryId);
            ps.setInt(2, page);
            ps.setInt(3, PAGE_SIZE);
            ps.setInt(4, PAGE_SIZE);
            rs = ps.executeQuery();
            int xID;
            String xIllustratoin;
//            int xDimesion_id;
            String xName;
            int xCategory;
            boolean xStatus;
            String xDescription;
            boolean xFeatured;
            Date xModified;
            double xPrice;
            double xSale;
            Subject x;
            while (rs.next()) {
                xID = rs.getInt("id");
                xIllustratoin = rs.getString("illustration");
//                xDimesion_id = rs.getInt("dimension_id");
                xModified = rs.getDate("modified");
                xName = rs.getString("name");
                xCategory = rs.getInt("category_id");
                xStatus = rs.getBoolean("status");
                xDescription = rs.getString("description");
                xFeatured = rs.getBoolean("featured");
                xPrice = rs.getDouble("min_price");
                xSale = rs.getDouble("min_sale");
                x = new Subject(xID, xIllustratoin, xName, xCategory, xStatus, xDescription, xModified, xFeatured, xPrice, xSale);
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
        xSql = "SELECT s.*, (\n"
                + "  SELECT MIN(price) \n"
                + "  FROM subject_price_package spp\n"
                + "  JOIN price_package p ON spp.price_package_id = p.id\n"
                + "  WHERE spp.subject_id = s.id\n"
                + ") AS min_price,\n"
                + "(\n"
                + "  SELECT MIN(sale) \n"
                + "  FROM subject_price_package spp\n"
                + "  JOIN price_package p ON spp.price_package_id = p.id\n"
                + "  WHERE spp.subject_id = s.id\n"
                + ") AS min_sale\n"
                + "FROM subject s\n"
                + "where s.featured = 1 and s.category_id =?\n"
                + "                order by s.modified DESC\n"
                + "                offset (?-1)*? row fetch next ? rows only";
        try {
            ps = con.prepareStatement(xSql);
            ps.setInt(1, categoryId);
            ps.setInt(2, page);
            ps.setInt(3, PAGE_SIZE);
            ps.setInt(4, PAGE_SIZE);
            rs = ps.executeQuery();
            int xID;
            String xIllustratoin;
//            int xDimesion_id;
            String xName;
            int xCategory;
            boolean xStatus;
            String xDescription;
            Date xModified;
            boolean xFeatured;
            double xPrice;
            double xSale;

            Subject x;
            while (rs.next()) {
                xID = rs.getInt("id");
                xIllustratoin = rs.getString("illustration");
//                xDimesion_id = rs.getInt("dimension_id");
                xModified = rs.getDate("modified");
                xName = rs.getString("name");
                xCategory = rs.getInt("category_id");
                xStatus = rs.getBoolean("status");
                xDescription = rs.getString("description");
                xFeatured = rs.getBoolean("featured");
                xPrice = rs.getDouble("min_price");
                xSale = rs.getDouble("min_sale");
                x = new Subject(xID, xIllustratoin, xName, xCategory, xStatus, xDescription, xModified, xFeatured, xPrice, xSale);
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
        xSql = "SELECT s.*, (\n"
                + "  SELECT MIN(price) \n"
                + "  FROM subject_price_package spp\n"
                + "  JOIN price_package p ON spp.price_package_id = p.id\n"
                + "  WHERE spp.subject_id = s.id\n"
                + ") AS min_price,\n"
                + "(\n"
                + "  SELECT MIN(sale) \n"
                + "  FROM subject_price_package spp\n"
                + "  JOIN price_package p ON spp.price_package_id = p.id\n"
                + "  WHERE spp.subject_id = s.id\n"
                + ") AS min_sale\n"
                + "FROM subject s\n"
                + "JOIN registration r ON s.id = r.subject_id\n"
                + "                where r.user_id = ? and s.category_id = ?\n"
                + "                order by s.modified DESC\n"
                + "                offset (?-1)*? row fetch next ? rows only";
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
//            int xDimesion_id;
            String xName;
            int xCategory_id;
            boolean xStatus;
            String xDescription;
            Date xModified;
            boolean xFeatured;
            double xPrice;
            double xSale;

            Subject x;
            while (rs.next()) {
                xId = rs.getInt("id");
                xIllustration = rs.getString("illustration");
//                xDimesion_id = rs.getInt("dimension_id");
                xModified = rs.getDate("modified");
                xName = rs.getString("name");
                xCategory_id = rs.getInt("category_id");
                xStatus = rs.getBoolean("status");
                xDescription = rs.getString("description");
                xFeatured = rs.getBoolean("featured");
                xPrice = rs.getDouble("min_price");
                xSale = rs.getDouble("min_sale");
                x = new Subject(xId, xIllustration, xName, xCategory_id, xStatus, xDescription, xModified, xFeatured, xPrice, xSale);
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
        xSql = "SELECT s.*, (\n"
                + "  SELECT MIN(price) \n"
                + "  FROM subject_price_package spp\n"
                + "  JOIN price_package p ON spp.price_package_id = p.id\n"
                + "  WHERE spp.subject_id = s.id\n"
                + ") AS min_price,\n"
                + "(\n"
                + "  SELECT MIN(sale) \n"
                + "  FROM subject_price_package spp\n"
                + "  JOIN price_package p ON spp.price_package_id = p.id\n"
                + "  WHERE spp.subject_id = s.id\n"
                + ") AS min_sale\n"
                + "FROM subject s\n"
                + "LEFT JOIN registration r ON s.id = r.subject_id AND r.user_id = ?\n"
                + "                WHERE r.subject_id IS NULL and s.category_id = ?\n"
                + "                ORDER BY s.modified DESC\n"
                + "                offset (?-1)*? row fetch next ? rows only";
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
//            int xDimesion_id;
            String xName;
            int xCategory_id;
            boolean xStatus;
            String xDescription;
            Date xModified;
            boolean xFeatured;
            double xPrice;
            double xSale;
            Subject x;
            while (rs.next()) {
                xId = rs.getInt("id");
                xIllustration = rs.getString("illustration");
//                xDimesion_id = rs.getInt("dimension_id");
                xModified = rs.getDate("modified");
                xName = rs.getString("name");
                xCategory_id = rs.getInt("category_id");
                xStatus = rs.getBoolean("status");
                xDescription = rs.getString("description");
                xFeatured = rs.getBoolean("featured");
                xPrice = rs.getDouble("min_price");
                xSale = rs.getDouble("min_sale");
                x = new Subject(xId, xIllustration, xName, xCategory_id, xStatus, xDescription, xModified, xFeatured, xPrice, xSale);
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

    public void addNewSubject(String illustration, String name, int category_id, boolean status, String description, boolean featured, int user_id) {
        try {
            String strAdd = "insert into [subject] values(?,?,?,?,?,?,GETDATE(),?)";
            ps = con.prepareStatement(strAdd);
            ps.setString(1, illustration);
            ps.setString(2, name);
            ps.setInt(3, category_id);
            ps.setBoolean(4, status);
            ps.setString(5, description);
            ps.setInt(6, user_id);
            ps.setBoolean(7, featured);
            ps.executeUpdate();
        } catch (Exception e) {
            System.out.println("addNewSubject: " + e.getMessage());
        }
    }

    public List<Subject> getSubjectsSortASCWithPaging(int page, int PAGE_SIZE) {
        List<Subject> t = new ArrayList<>();
        xSql = "SELECT s.*, (\n"
                + "                  SELECT MIN(price) \n"
                + "                FROM subject_price_package spp\n"
                + "                 JOIN price_package p ON spp.price_package_id = p.id\n"
                + "                 WHERE spp.subject_id = s.id\n"
                + "                ) AS min_price,\n"
                + "                (\n"
                + "                 SELECT MIN(sale) \n"
                + "                 FROM subject_price_package spp\n"
                + "                 JOIN price_package p ON spp.price_package_id = p.id\n"
                + "                 WHERE spp.subject_id = s.id\n"
                + "                 ) AS min_sale\n"
                + "                FROM subject s\n"
                + "                order by min_price ASC\n"
                + "                offset (?-1)*? row fetch next ? rows only";
        try {
            ps = con.prepareStatement(xSql);
            ps.setInt(1, page);
            ps.setInt(2, PAGE_SIZE);
            ps.setInt(3, PAGE_SIZE);
            rs = ps.executeQuery();
            int xID;
            String xIllustratoin;
//            int xDimesion_id;
            String xName;
            int xCategory;
            boolean xStatus;
            String xDescription;
            boolean xFeatured;
            Date xModified;
            double xPrice;
            double xSale;
            Subject x;
            while (rs.next()) {
                xID = rs.getInt("id");
                xIllustratoin = rs.getString("illustration");
//                xDimesion_id = rs.getInt("dimension_id");
                xModified = rs.getDate("modified");
                xName = rs.getString("name");
                xCategory = rs.getInt("category_id");
                xStatus = rs.getBoolean("status");
                xDescription = rs.getString("description");
                xFeatured = rs.getBoolean("featured");
                xPrice = rs.getDouble("min_price");
                xSale = rs.getDouble("min_sale");
                x = new Subject(xID, xIllustratoin, xName, xCategory, xStatus, xDescription, xModified, xFeatured, xPrice, xSale);
                t.add(x);
            }
            rs.close();
            ps.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return (t);
    }

    public List<Subject> getSubjectsSortDESCWithPaging(int page, int PAGE_SIZE) {
        List<Subject> t = new ArrayList<>();
        xSql = "SELECT s.*, (\n"
                + "                  SELECT MIN(price) \n"
                + "                FROM subject_price_package spp\n"
                + "                 JOIN price_package p ON spp.price_package_id = p.id\n"
                + "                 WHERE spp.subject_id = s.id\n"
                + "                ) AS min_price,\n"
                + "                (\n"
                + "                 SELECT MIN(sale) \n"
                + "                 FROM subject_price_package spp\n"
                + "                 JOIN price_package p ON spp.price_package_id = p.id\n"
                + "                 WHERE spp.subject_id = s.id\n"
                + "                 ) AS min_sale\n"
                + "                FROM subject s\n"
                + "                order by min_price DESC\n"
                + "                offset (?-1)*? row fetch next ? rows only";
        try {
            ps = con.prepareStatement(xSql);
            ps.setInt(1, page);
            ps.setInt(2, PAGE_SIZE);
            ps.setInt(3, PAGE_SIZE);
            rs = ps.executeQuery();
            int xID;
            String xIllustratoin;
//            int xDimesion_id;
            String xName;
            int xCategory;
            boolean xStatus;
            String xDescription;
            boolean xFeatured;
            Date xModified;
            double xPrice;
            double xSale;
            Subject x;
            while (rs.next()) {
                xID = rs.getInt("id");
                xIllustratoin = rs.getString("illustration");
//                xDimesion_id = rs.getInt("dimension_id");
                xModified = rs.getDate("modified");
                xName = rs.getString("name");
                xCategory = rs.getInt("category_id");
                xStatus = rs.getBoolean("status");
                xDescription = rs.getString("description");
                xFeatured = rs.getBoolean("featured");
                xPrice = rs.getDouble("min_price");
                xSale = rs.getDouble("min_sale");
                x = new Subject(xID, xIllustratoin, xName, xCategory, xStatus, xDescription, xModified, xFeatured, xPrice, xSale);
                t.add(x);
            }
            rs.close();
            ps.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return (t);
    }

    public Subject getSubjectDetailById(int subjectId) {
        Subject x = null;
        xSql = "select illustration,name,category_id,status,description,author_id,modified,featured from subject where id = ?";
        try {
            ps = con.prepareStatement(xSql);
            ps.setInt(1, subjectId);
            rs = ps.executeQuery();
            String xIllustration;
            String xName;
            int xCategory_id;
            boolean xStatus;
            String xDescription;
            int xAuthor_id;

            boolean xFeatured;

            while (rs.next()) {
                xIllustration = rs.getString("illustration");
                xName = rs.getString("name");
                xCategory_id = rs.getInt("category_id");
                xStatus = rs.getBoolean("status");
                xDescription = rs.getString("description");
                xAuthor_id = rs.getInt("author_id");

                xFeatured = rs.getBoolean("featured");
                x = new Subject(subjectId, xIllustration, xName, xCategory_id, xStatus, xDescription, xFeatured, xAuthor_id);
            }
            rs.close();
            ps.close();
        } catch (Exception e) {
            System.out.println("getSubjectDetailById:" + e.getMessage());
        }
        return x;
    }
//        public Subject(int id, String illustration, String name, int category_id, boolean status, String description,boolean featured,int author_id) {

//        public Subject(int id, String illustration, String name, int category_id, boolean status, String description, int author_id, Date modified, boolean featured, int user_id) {
    public Subject getSubjectById(int subjectId) {
        Subject x = null;
        xSql = "SELECT s.*, (\n"
                + "SELECT MIN(price) \n"
                + "FROM subject_price_package spp\n"
                + "JOIN price_package p ON spp.price_package_id = p.id\n"
                + "WHERE spp.subject_id = s.id\n"
                + "                              ) AS min_price,\n"
                + "                               (\n"
                + "                                SELECT MIN(sale) \n"
                + "                                FROM subject_price_package spp\n"
                + "                                 JOIN price_package p ON spp.price_package_id = p.id\n"
                + "                                WHERE spp.subject_id = s.id\n"
                + "                               ) AS min_sale\n"
                + "                                FROM subject s\n"
                + "								where s.id = ?";
        try {
            ps = con.prepareStatement(xSql);
            ps.setInt(1, subjectId);
            rs = ps.executeQuery();
            String xIllustration;
            String xName;
            int xCategory_id;
            boolean xStatus;
            String xDescription;
            double xPrice;
            double xSale;
            while (rs.next()) {
                xIllustration = rs.getString("illustration");
                xName = rs.getString("name");
                xCategory_id = rs.getInt("category_id");
                xStatus = rs.getBoolean("status");
                xDescription = rs.getString("description");
                xPrice = rs.getDouble("min_price");
                xSale = rs.getDouble("min_sale");
                x = new Subject(subjectId, xIllustration, xName, xCategory_id, xStatus, xDescription, xPrice, xSale);
            }
            rs.close();
            ps.close();
        } catch (Exception e) {
            System.out.println("Error: "+e.getMessage());
        }
        return x;
    }
      public void updateSubject(int id,String illustration,String name,int category_id,boolean status,String description,int author_id,boolean featured) {
        try {
            String strAdd = "update subject set illustration = ?, name =?, category_id = ?,status= ?,description= ?,author_id =?,featured= ? where id = ?";
            ps = con.prepareStatement(strAdd);

            ps.setString(1, illustration);
            ps.setString(2, name);
            ps.setInt(3, category_id);
            ps.setBoolean(4, status);
            ps.setString(5, description);
            ps.setInt(6, author_id);
            ps.setBoolean(7, featured);
            ps.setInt(8, id);

            ps.executeUpdate();
        } catch (Exception e) {
            System.out.println("updateSubject: " + e.getMessage());
        }
    }
        public void updateSubjectWithoutImage(int id,String name,int category_id,boolean status,String description,int author_id,boolean featured) {
        try {
            String strAdd = "update subject set name =?, category_id = ?,status= ?,description= ?,author_id =?,featured= ? where id = ?";
            ps = con.prepareStatement(strAdd);

          
            ps.setString(1, name);
            ps.setInt(2, category_id);
            ps.setBoolean(3, status);
            ps.setString(4, description);
            ps.setInt(5, author_id);
            ps.setBoolean(6, featured);
            ps.setInt(7, id);

            ps.executeUpdate();
        } catch (Exception e) {
            System.out.println("updateSubject: " + e.getMessage());
        }
    }
}
