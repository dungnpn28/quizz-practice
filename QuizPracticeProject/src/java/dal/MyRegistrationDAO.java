package dal;

import java.sql.Date;
import java.util.ArrayList;
import java.util.List;
import model.MyRegistration;

/**
 *
 * @author ADMIN
 */
public class MyRegistrationDAO extends MyDAO {

    public List<MyRegistration> getMyRegistration(int user_id) {
        List<MyRegistration> mr = new ArrayList<>();
        String Sql = "select id, subject_id, price_package_id ,user_id, created from registration where user_id = ?";
        try {
            ps = con.prepareStatement(Sql);
            ps.setInt(1, user_id);
            rs = ps.executeQuery();
            while (rs.next()) {
                int id = rs.getInt(1);
                int subjectId = rs.getInt(2);
                int pricePackageId = rs.getInt(3);
                int userId = rs.getInt(4);
                Date created = rs.getDate(5);
                mr.add(new MyRegistration(id, subjectId, pricePackageId, userId, created));
            }
        } catch (Exception e) {
        }
        return mr;
    }
}