/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dal;
import java.sql.Date;
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
    public List<Slider> getSlider(){
        List<Slider> s = new ArrayList<>();
        try { 
            xSql = "select * from slider";
            ps = con.prepareStatement(xSql);
            rs = ps.executeQuery();
            int xID;
//            int xPublisher_id;
            String xTitle;
            String xImage;
            String xBacklink;
            boolean xStatus;
            Date xCreated;
            Date xModified;
            Slider x;
            while(rs.next()){
                xID = rs.getInt("id");
//                xPublisher_id = rs.getInt("publisher_id");
                xTitle = rs.getString("title");
                xImage = rs.getString("image");
                xBacklink = rs.getString("backlink");
                xStatus = rs.getBoolean("status");
                xCreated = rs.getDate("created");
                xModified = rs.getDate("modified");
                x = new Slider(xID,xTitle,xImage,xBacklink,xStatus,xCreated,xModified);
                s.add(x);
            }
            rs.close();
            ps.close();
           
        } catch (SQLException ex) {
            Logger.getLogger(SliderDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return (s);
    }
}
