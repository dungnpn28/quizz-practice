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
public class SubjectDetailsDAO extends MyDAO{
    public List<Price_Package> getPrice_Package() {
        List<Price_Package> t = new ArrayList<>();
        xSql = "select * from price_package";
        try {
            ps = con.prepareStatement(xSql);
            rs = ps.executeQuery();
            int xID;
            int xDuration;
            double xPrice;
            double xSale;
            int xStatus;
            Price_Package x;
            while (rs.next()) {
                xID = rs.getInt("id");
                xDuration = rs.getInt("duration");
                xPrice = rs.getDouble("price");
                xSale = rs.getDouble("sale");
                xStatus = rs.getInt("status");
                x = new Price_Package(xID, xDuration, xPrice, xSale, xStatus);
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
}
