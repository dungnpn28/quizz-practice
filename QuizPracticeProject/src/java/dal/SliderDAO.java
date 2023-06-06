/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dal;

import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import model.Slider;

/**
 *
 * @author ADMIN
 */
public class SliderDAO extends MyDAO {

    public List<Slider> getSlider() {
        List<Slider> s = new ArrayList<>();
        try {
            xSql = "select * from slider";
            ps = con.prepareStatement(xSql);
            rs = ps.executeQuery();
            int xID;
            String xTitle;
            String xImage;
            String xBacklink;
            boolean xStatus;
            Date xCreated;
            Date xModified;
            Slider x;
            while (rs.next()) {
                xID = rs.getInt("id");
                xTitle = rs.getString("title");
                xImage = rs.getString("image");
                xBacklink = rs.getString("backlink");
                xStatus = rs.getBoolean("status");
                xCreated = rs.getDate("created");
                xModified = rs.getDate("modified");
                x = new Slider(xID, xTitle, xImage, xBacklink, xStatus, xCreated, xModified);
                s.add(x);
            }
            rs.close();
            ps.close();

        } catch (SQLException ex) {
            Logger.getLogger(SliderDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return (s);
    }

    public List<Slider> getSliderByStatus(boolean status) {
        List<Slider> sliders = new ArrayList<>();
        try {
            String query = "SELECT * FROM slider WHERE status = ?";
            ps = con.prepareStatement(query);
            ps.setBoolean(1, status);
            rs = ps.executeQuery();
            while (rs.next()) {
                int id = rs.getInt("id");
                String title = rs.getString("title");
                String image = rs.getString("image");
                String backlink = rs.getString("backlink");
                boolean xStatus = rs.getBoolean("status");
                Date created = rs.getDate("created");
                Date modified = rs.getDate("modified");
                Slider slider = new Slider(id, title, image, backlink, xStatus, created, modified);
                sliders.add(slider);
            }
            rs.close();
            ps.close();
        } catch (SQLException ex) {
            Logger.getLogger(SliderDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return sliders;
    }

    public List<Slider> delete(int id) {
        String sql = "delete from slider where id = ?";
        List<Slider> sliders = new ArrayList<Slider>();
        try {          
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setInt(1, id);
            ps.executeUpdate();
            sliders = getSlider();          
        } catch (Exception e) {
        }
        return sliders;
    }

}
