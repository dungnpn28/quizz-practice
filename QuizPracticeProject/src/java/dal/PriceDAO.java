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
            int xDuration;
            String xPrice;
            double xSale;
            int xStatus;
            Price_Package x;
            while (rs.next()) {
                xID = rs.getInt("id");
                xName = rs.getString("name");
                xDuration = rs.getInt("duration");
                xPrice = rs.getString("price");
                xSale = rs.getDouble("sale");
                xStatus = rs.getInt("status");
                x = new Price_Package(xID, xName, xDuration, xPrice, xSale, xStatus);
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
                + "      [name]= ?\n"
                + "      ,[duration]= ?\n"
                + "      ,[price] = ? \n"
                + "      ,[sale] = ? \n"
                + "      ,[status] = ? \n"
                + " WHERE [id] = ?";
        try {
            ps = con.prepareStatement(xSql);
            ps.setString(1, x.getName());
            ps.setInt(2, x.getDuration());
            ps.setString(3, x.getPrice());
            ps.setDouble(4, x.getSale());
            ps.setInt(5, x.getStatus());
            ps.setInt(6, x.getId());
            ps.executeUpdate();
            ps.close();
        } catch (Exception e) {
            System.out.println("update: " + e.getMessage());
        }
    }
}
