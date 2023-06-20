package dal;

import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
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
            xSql = "select * from slider where status = 1";
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

    public Slider getOneSlider(int id) {
        String sql = "select * from slider where id = ?";
        Slider s = new Slider();
        try {
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setInt(1, id);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                String title = rs.getString("title");
                String image = rs.getString("image");
                String backlink = rs.getString("backlink");
                boolean xStatus = rs.getBoolean("status");
                Date created = rs.getDate("created");
                Date modified = rs.getDate("modified");
                s = new Slider(id, title, image, backlink, xStatus, created, modified);
            }
        } catch (Exception e) {
        }
        return s;
    }

    public void updateSliderWithImage(String title, String image, int id, String backlink, boolean status) {
        String sql = "update Slider set [title] = ?, [image] = ?, [backlink]= ?, [status] = ?, [modified] = GETDATE() where id = ?";

        try {
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setString(1, title);
            ps.setString(2, image);
            ps.setString(3, backlink);
            ps.setBoolean(4, status);
            ps.setInt(5, id);
            ps.executeUpdate();

        } catch (Exception e) {
        }
    }

    public void updateSliderWithoutImage(String title, int id, String backlink, boolean status) {
        String sql = "update Slider set [title] = ?, [backlink] = ?, [status] = ?, [modified] = GETDATE() where id = ?";

        try {
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setString(1, title);
            ps.setString(2, backlink);
            ps.setBoolean(3, status);
            ps.setInt(4, id);
            ps.executeUpdate();

        } catch (Exception e) {
        }
    }

    public List<Slider> searchSlider(String keyword) {
        List<Slider> searchs = new ArrayList<>();
        xSql = "select * from [slider] where title like ? ";
        int xId;
        String xTitle;
        String xImage;
        String xBacklink;
        Slider x = null;
        try {
            ps = con.prepareStatement(xSql);
            ps.setString(1, "%" + keyword + "%");
            rs = ps.executeQuery();
            while (rs.next()) {
                xId = rs.getInt("id");
                xTitle = rs.getString("title");
                xImage = rs.getString("image");
                xBacklink = rs.getString("backlink");

                x = new Slider(xId, xTitle, xImage, xBacklink);
                searchs.add(x);
            }
            rs.close();
            ps.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return searchs;
    }

    public int getTotalSlider() {
        xSql = "select count(*)  from slider";
        try {
            ps = con.prepareStatement(xSql);
            rs = ps.executeQuery();
            while (rs.next()) {
                int total = rs.getInt(1);
                int countPage = 0;
                countPage = total / 5;
                if (total % 5 != 0) {
                    countPage++;
                }
                return countPage;
            }
            rs.close();
            ps.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return 0;
    }

    public List<Slider> getPaging(int index) {
        String Sql = "select * from slider\n"
                + "order by id\n"
                + "offset ? rows\n"
                + "fetch first 5 rows only;";
        List<Slider> list = new ArrayList<>();
        try {
            ps = con.prepareStatement(Sql);
            ps.setInt(1, (index - 1) * 5);
            rs = ps.executeQuery();
            while (rs.next()) {
                list.add(new Slider(rs.getInt(1),
                        rs.getString(2),
                        rs.getString(3),
                        rs.getString(4),
                        rs.getBoolean(5)));
            }
        } catch (Exception e) {
        }
        return list;
    }
}
