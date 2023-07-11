/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dal;

import java.util.ArrayList;
import java.util.List;
import model.Price_Package;

/**
 *
 * @author dai
 */
public class PriceDAO extends MyDAO {

    public List<Price_Package> getPrice_Package() {
        List<Price_Package> t = new ArrayList<>();
        xSql = "select * from price_package";
        try {
            ps = con.prepareStatement(xSql);
            rs = ps.executeQuery();
            int xID;
            String xName;
            String xDescription;
            int xDuration;
            double xPrice;
            double xSale;
            int xStatus;
            Price_Package x;
            while (rs.next()) {
                xID = rs.getInt("id");
                xName = rs.getString("name");
                xDescription = rs.getString("description");
                xDuration = rs.getInt("duration");
                xPrice = rs.getDouble("price");
                xSale = rs.getDouble("sale");
                xStatus = rs.getInt("status");
                x = new Price_Package(xID, xName, xDescription, xDuration, xPrice, xSale, xStatus);
                t.add(x);
            }
            rs.close();
            ps.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return (t);
    }

    public List<Price_Package> getPrice_PackageWithPaging(int page, int page_size) {
        List<Price_Package> t = new ArrayList<>();
        xSql = "select * from price_package\n"
                + "order by id\n"
                + "offset (?-1)* ? row fetch next ? rows only";
        try {
            ps = con.prepareStatement(xSql);
            ps.setInt(1, page);
            ps.setInt(2, page_size);
            ps.setInt(3, page_size);
            rs = ps.executeQuery();
            int xID;
            String xName;
            String xDescription;
            int xDuration;
            double xPrice;
            double xSale;
            int xStatus;
            Price_Package x;
            while (rs.next()) {
                xID = rs.getInt("id");
                xName = rs.getString("name");
                xDescription = rs.getString("description");
                xDuration = rs.getInt("duration");
                xPrice = rs.getDouble("price");
                xSale = rs.getDouble("sale");
                xStatus = rs.getInt("status");
                x = new Price_Package(xID, xName, xDescription, xDuration, xPrice, xSale, xStatus);
                t.add(x);
            }
            rs.close();
            ps.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return (t);
    }

    public String getPrice(int price_packageId) {
        xSql = "select price from price_package where id = ?";
        String xPrice = "";
        try {
            ps = con.prepareStatement(xSql);
            ps.setInt(1, price_packageId);
            rs = ps.executeQuery();

            if (rs.next()) {
                xPrice = rs.getString("price");
            }
            rs.close();
            ps.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return xPrice;
    }

    public void update(Price_Package x) {
        xSql = "UPDATE [dbo].[price_package]\n"
                + "   SET \n"
                + "      [name] = ?\n"
                + "      ,[description] = ?\n"
                + "      ,[duration] = ?\n"
                + "      ,[price] = ? \n"
                + "      ,[sale] = ? \n"
                + "      ,[status] = ? \n"
                + " WHERE [id] = ?";
        try {
            ps = con.prepareStatement(xSql);
            ps.setString(1, x.getName());
            ps.setString(2, x.getDescription());
            ps.setInt(3, x.getDuration());
            ps.setDouble(4, x.getPrice());
            ps.setDouble(5, x.getSale());
            ps.setInt(6, x.getStatus());
            ps.setInt(7, x.getId());
            ps.executeUpdate();
            ps.close();
        } catch (Exception e) {
            System.out.println("update: " + e.getMessage());
        }
    }
     public void updateStatus(int price,int subjectId,int status) {
        xSql = "update subject_price_package set status = ? where subject_id = ? and price_package_id = ?";
        try {
            ps = con.prepareStatement(xSql);
            ps.setInt(1, status);
            ps.setInt(2, subjectId);
            ps.setInt(3, price);
       

           
            ps.executeUpdate();
            ps.close();
        } catch (Exception e) {
            System.out.println("updateStatus: " + e.getMessage());
        }
    }
    public void updatedetail(Price_Package x) {
        xSql = "UPDATE [dbo].[price_package] \n"
                + "   SET \n"
                + "      [name] = ?\n"
                + "      ,[description] = ?\n"
                + "      ,[duration] = ?\n"
                + "      ,[price] = ? \n"
                + "      ,[sale] = ? \n"
                + " WHERE [id] = ?";
        try {
            ps = con.prepareStatement(xSql);
            ps.setString(1, x.getName());
            ps.setString(2, x.getDescription());
            ps.setInt(3, x.getDuration());
            ps.setDouble(4, x.getPrice());
            ps.setDouble(5, x.getSale());

            ps.setInt(6, x.getId());
            ps.executeUpdate();
            ps.close();
        } catch (Exception e) {
            System.out.println("update: " + e.getMessage());
        }
    }

    public void updatedetail2(int subjectId, int pricepackage, int status) {
        xSql = "UPDATE [dbo].[subject_price_package] \n"
                + "   SET \n"
                + "      [status] = ? \n"
                + " WHERE [subject_id] = ? and price_package_id = ?";
        try {
            ps = con.prepareStatement(xSql);

            ps.setInt(1, status);
            ps.setInt(2, subjectId);
            ps.setInt(3, pricepackage);
            ps.executeUpdate();
            ps.close();
        } catch (Exception e) {
            System.out.println("update2: " + e.getMessage());
        }
    }

    public int findPricePackage() {
        xSql = "select max(id) from price_package";
        try {
            ps = con.prepareStatement(xSql);

            rs = ps.executeQuery();
            while (rs.next()) {
                return rs.getInt(1);
            }
        } catch (Exception e) {
        }
        return 0;
    }

    public void insert(Price_Package x) {
        xSql = "insert into [dbo].[price_package] ([name],[description], duration, price, sale, [status]) values(?,?,?,?,?,1)";
        try {
            ps = con.prepareStatement(xSql);
            ps.setString(1, x.getName());
            ps.setString(2, x.getDescription());
            ps.setInt(3, x.getDuration());
            ps.setDouble(4, x.getPrice());
            ps.setDouble(5, x.getSale());

            ps.executeUpdate();
            ps.close();
        } catch (Exception e) {
            System.out.println("insert:" + e.getMessage());
        }
    }

    public void insert1(int pricepackage, int subject, int status) {
        xSql = "insert into [dbo].[subject_price_package] ([subject_id],[price_package_id],[status]) values(?,?,?)";
        try {
            ps = con.prepareStatement(xSql);
            ps.setInt(1, subject);
            ps.setInt(2, pricepackage);
            ps.setInt(3, status);

            ps.executeUpdate();
            ps.close();
        } catch (Exception e) {
            System.out.println("insert1:" + e.getMessage());
        }
    }

    public int getTotalPricePackage() {
        xSql = "select count(id)  from price_package \n";
        int totalPricePackage = 0;
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
        return (totalPricePackage);
    }

    public List<Price_Package> getPricePackageAvailable() {
        List<Price_Package> t = new ArrayList<>();
        xSql = "select id,name,description,duration,price,sale,status from price_package \n"
                + "                where price_package.status =1 ";
        try {
            ps = con.prepareStatement(xSql);
            rs = ps.executeQuery();
            int xID;
            String xName;
            String xDescription;
            int xDuration;
            double xPrice;
            double xSale;
            int xStatus;
            Price_Package x;
            while (rs.next()) {
                xID = rs.getInt("id");
                xName = rs.getString("name");
                xDescription = rs.getString("description");
                xDuration = rs.getInt("duration");
                xPrice = rs.getDouble("price");
                xSale = rs.getDouble("sale");
                xStatus = rs.getInt("status");
                x = new Price_Package(xID, xName, xDescription, xDuration, xPrice, xSale, xStatus);
                t.add(x);
            }
            rs.close();
            ps.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return (t);
    }

    public int countPricePackageBySubjectIdWithPaging(int subjectid) {
        try {
            String strSelect = "select count(*) from subject_price_package inner join price_package on subject_price_package.price_package_id = price_package.id "
                    + "where subject_price_package.subject_id=? "
                    + "and price_package.status =1";
            ps = con.prepareStatement(strSelect);
            ps.setInt(1, subjectid);
            rs = ps.executeQuery();
            UserDAO u = new UserDAO();
            while (rs.next()) {
                return rs.getInt(1);
            }
        } catch (Exception e) {
            System.out.println("countPricePackageBySubjectIdWithPaging: " + e.getMessage());
        }

        return 0;
    }

    public List<Price_Package> getPricePackageBySubjectIdWithPaging(int index, int subjectid) {
        List<Price_Package> t = new ArrayList<>();

        xSql = "select id,name,description,duration,price,sale,subject_price_package.status from subject_price_package inner join price_package on subject_price_package.price_package_id = price_package.id \n"
                + "                where subject_price_package.subject_id= ? \n"
                + "               and price_package.status =1 order by id offset ? rows fetch next 5 rows only";
        try {
            ps = con.prepareStatement(xSql);
            ps.setInt(1, subjectid);
            ps.setInt(2, (index - 1) * 5);
            rs = ps.executeQuery();
            int xID;
            String xName;
            String xDescription;
            int xDuration;
            double xPrice;
            double xSale;
            int xStatus;
            Price_Package x;
            while (rs.next()) {
                xID = rs.getInt("id");
                xName = rs.getString("name");
                xDescription = rs.getString("description");
                xDuration = rs.getInt("duration");
                xPrice = rs.getDouble("price");
                xSale = rs.getDouble("sale");
                xStatus = rs.getInt("status");
                x = new Price_Package(xID, xName, xDescription, xDuration, xPrice, xSale, xStatus);
                t.add(x);
            }
            rs.close();
            ps.close();
        } catch (Exception e) {
            System.out.println("getPricePackageBySubjectIdWithPaging:" + e.getMessage());
        }
        return (t);
    }

    public List<Price_Package> getPricePackageBySubjectId(int subjectid) {
        List<Price_Package> t = new ArrayList<>();
        xSql = "select id,name,description,duration,price,sale,subject_price_package.status from subject_price_package inner join price_package on subject_price_package.price_package_id = price_package.id "
                + "where subject_price_package.subject_id=? "
                + "and price_package.status =1";
        try {
            ps = con.prepareStatement(xSql);
            ps.setInt(1, subjectid);
            rs = ps.executeQuery();
            int xID;
            String xName;
            String xDescription;
            int xDuration;
            double xPrice;
            double xSale;
            int xStatus;
            Price_Package x;
            while (rs.next()) {
                xID = rs.getInt("id");
                xName = rs.getString("name");
                xDescription = rs.getString("description");
                xDuration = rs.getInt("duration");
                xPrice = rs.getDouble("price");
                xSale = rs.getDouble("sale");
                xStatus = rs.getInt("status");
                x = new Price_Package(xID, xName, xDescription, xDuration, xPrice, xSale, xStatus);
                t.add(x);
            }
            rs.close();
            ps.close();
        } catch (Exception e) {
            System.out.println("getPricePackageBySubjectId:" + e.getMessage());
        }
        return (t);
    }

    public static void main(String[] args) {
        PriceDAO pd = new PriceDAO();
        Price_Package x = new Price_Package(6, "Unlimited", "life access", 0, 11111, 100000, 0);
        pd.update(x);
    }

    public List<Price_Package> getAllPricePackage() {
        List<Price_Package> t = new ArrayList<>();
        xSql = "select id,subject_id,name,description,duration,price,sale,subject_price_package.status from subject_price_package inner join price_package on subject_price_package.price_package_id = price_package.id \n"
                + "                where price_package.status =1";

        try {
            ps = con.prepareStatement(xSql);

            rs = ps.executeQuery();
            int xID;
            int xSubject_id;
            String xName;
            String xDescription;
            int xDuration;
            double xPrice;
            double xSale;
            int xStatus;
            Price_Package x;
            while (rs.next()) {
                xID = rs.getInt("id");
                xSubject_id = rs.getInt("subject_id");
                xName = rs.getString("name");
                xDescription = rs.getString("description");
                xDuration = rs.getInt("duration");
                xPrice = rs.getDouble("price");
                xSale = rs.getDouble("sale");
                xStatus = rs.getInt("status");
                x = new Price_Package(xID,xSubject_id, xName, xDescription, xDuration, xPrice, xSale, xStatus);
                t.add(x);
            }
            rs.close();
            ps.close();
        } catch (Exception e) {
            System.out.println("getPricePackageBySubjectId:" + e.getMessage());
        }
        return (t);
    }
}
