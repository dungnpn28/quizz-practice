package dal;

import java.sql.Date;
import java.util.ArrayList;
import java.util.List;
import model.Lesson;
import model.MyRegistration;

/**
 *
 * @author ADMIN
 */
public class MyRegistrationDAO extends MyDAO {

    public List<MyRegistration> getMyRegistration(int user_id, int page, int PAGE_SIZE) {
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

    public List<MyRegistration> getMyRegistrationWithPaging(int index, String category, String search, int user_id) {
        List<MyRegistration> t = new ArrayList<>();
        xSql = "select * from registration r\n"
                + "WHERE user_id = ? AND 1=1 ";

        if (!category.equals("all")) {
            xSql += " and [category_id]= ?";
        }

        xSql += " and [subject_name] like ?";
        xSql += " order by [id] desc offset ? rows fetch next 5 rows only";

        try {
            ps = con.prepareStatement(xSql);
            ps.setInt(1, user_id);
            int i = 2;
            if (!category.equals("all")) {
                ps.setInt(i, Integer.parseInt(category));
                i++;
            }
            ps.setString(i, "%" + search + "%");
            i++;
            ps.setInt(i, (index - 1) * 5);

            rs = ps.executeQuery();
            int xID;
            int xSubject_id;
            int xPrice_package_id;
            int xUser_id;
            Date xCreated;
            int xCategory_id;
            String xSubject_name;
            MyRegistration x;
            while (rs.next()) {
                xID = rs.getInt("id");
                xSubject_id = rs.getInt("subject_id");
                xPrice_package_id = rs.getInt("price_package_id");
                xUser_id = rs.getInt("user_id");
                xCreated = rs.getDate("created");
                xCategory_id = rs.getInt("category_id");
                xSubject_name = rs.getString("subject_name");
                x = new MyRegistration(xID, xSubject_id, xPrice_package_id, xUser_id, xCreated, xCategory_id, xSubject_name);
//                x = new MyRegistration(xID, xSubject_id, xPrice_package_id, xUser_id, xCreated);
                t.add(x);
            }
            rs.close();
            ps.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return (t);
    }

    public int getTotalRegistrationFilter(String category, String search, int user_id) {
        try {
            String strSelect = "select count(*) from registration r\n"
                + "WHERE user_id = ? AND 1=1 ";
            if (!category.equals("all")) {
                strSelect += " and [category_id]= ?";
            }

            strSelect += " and [subject_name] like ? ";

            ps = con.prepareStatement(strSelect);
            ps.setInt(1, user_id);
            int i = 2;
            if (!category.equals("all")) {
                ps.setInt(i, Integer.parseInt(category));
                i++;
            }

            ps.setString(i, "%" + search + "%");

            rs = ps.executeQuery();
            while (rs.next()) {
                return rs.getInt(1);
            }
        } catch (Exception e) {
            System.out.println("getTotalLessonFilter: " + e.getMessage());
        }

        return 0;

    }
}
