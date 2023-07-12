/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dal;

import java.util.ArrayList;
import java.util.List;
import model.Dimension_Type;

/**
 *
 * @author Dell
 */
public class Dimension_TypeDAO extends MyDAO {
    public List<Dimension_Type> getDimensionType() {
        List<Dimension_Type> t = new ArrayList<>();
        xSql = "select id, name from dimension_type";
        try {
            ps = con.prepareStatement(xSql);
        
            rs = ps.executeQuery();
            int xID;
            String xName;
         

            Dimension_Type x;
            while (rs.next()) {
                xID = rs.getInt("id");
                xName = rs.getString("name");
              

                x = new Dimension_Type(xID, xName);
                t.add(x);
            }
            rs.close();
            ps.close();
        } catch (Exception e) {
            System.out.println("getDimensionType:" + e.getMessage());
        }
        return (t);
    }

}
