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
                x = new Price_Package(xID, xName,xDescription, xDuration, xPrice, xSale, xStatus);
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
            ps.setInt(1,page);
            ps.setInt(2,page_size);
            ps.setInt(3,page_size);
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
                x = new Price_Package(xID, xName,xDescription, xDuration, xPrice, xSale, xStatus);
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

    public void insert(Price_Package x) {
        xSql = "insert into [dbo].[price_package] ([name],[description], duration, price, sale, [status]) values(?,?,?,?,?,?)";
        try {
            ps = con.prepareStatement(xSql);
            ps.setString(1, x.getName());
            ps.setString(2, x.getDescription());
            ps.setInt(3, x.getDuration());
            ps.setDouble(4, x.getPrice());
            ps.setDouble(5, x.getSale());
            ps.setInt(6, x.getStatus());
            ps.executeUpdate();
            ps.close();
        } catch (Exception e) {
            System.out.println("insert:" + e.getMessage());
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
    public static void main(String[] args) {
        PriceDAO pd = new PriceDAO();
        Price_Package x = new Price_Package(6, "Unlimited", "life access", 0, 11111, 100000, 0);
        pd.update(x);
    }
}