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
        xSql = "SELECT \n"
                + "    r.*,\n"
                + "    p.duration,\n"
                + "    DATEADD(DAY, p.duration, r.created) AS expired\n"
                + "FROM [registration] r \n"
                + "join price_package p on r.price_package_id = p.id\n"
                + "where r.user_id = ? AND 1=1";

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
            Date xExpired;
            int xStatus;
            MyRegistration x;
            while (rs.next()) {
                xID = rs.getInt("id");
                xSubject_id = rs.getInt("subject_id");
                xPrice_package_id = rs.getInt("price_package_id");
                xUser_id = rs.getInt("user_id");
                xCreated = rs.getDate("created");
                xCategory_id = rs.getInt("category_id");
                xSubject_name = rs.getString("subject_name");
                xExpired = rs.getDate("expired");
                xStatus = rs.getInt("status");
                x = new MyRegistration(xID, xSubject_id, xPrice_package_id, xUser_id, xCreated, xCategory_id, xSubject_name, xExpired, xStatus);
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

    public void addNewRegistration(String subjectId, String price_package_id, int userId, int category_id, String subjectName, int registedStatus) {
        xSql = "INSERT INTO [dbo].[registration]\n"
                + "           ([subject_id]\n"
                + "           ,[price_package_id]\n"
                + "           ,[user_id]\n"
                + "           ,[created]\n"
                + "           ,[category_id]\n"
                + "           ,[subject_name]\n"
                + "           ,[status])\n"
                + "     VALUES\n"
                + "           (?\n"
                + "           ,?\n"
                + "           ,?\n"
                + "           ,GETDATE()\n"
                + "           ,?\n"
                + "           ,?\n"
                + "           ,?)";
        try {
            ps = con.prepareStatement(xSql);
            ps.setString(1, subjectId);
            ps.setString(2, price_package_id);
            ps.setInt(3, userId);
            ps.setInt(4, category_id);
            ps.setString(5, subjectName);
            ps.setInt(6, registedStatus);
            ps.executeUpdate();
            ps.close();
        } catch (Exception e) {
            System.out.println("insert: " + e.getMessage());
        }
    }

    public void updateRegistration(String registrationId, String pricePackage, int registedstatus) {
        xSql = "UPDATE [dbo].[registration]\n"
                + "   SET [price_package_id] = ?\n"
                + "      ,[status] = ?\n"
                + " WHERE id = ?";
        try {
            ps = con.prepareStatement(xSql);
            ps.setString(1, pricePackage);
            ps.setInt(2, registedstatus);
            ps.setString(3, registrationId);
            ps.executeUpdate();
            ps.close();
        } catch (Exception e) {
            System.out.println("update: " + e.getMessage());
        }
    }

    public List<MyRegistration> getAllRegistrationWithPaging(int index, String category, String search, String status) {
        List<MyRegistration> t = new ArrayList<>();
        xSql = "SELECT \n"
                + "    r.*,\n"
                + "    p.duration,\n"
                + "    DATEADD(DAY, p.duration, r.created) AS expired,\n"
                + "    FORMAT(created, 'HH:mm:ss') AS time_only\n"
                + "FROM [registration] r \n"
                + "join price_package p on r.price_package_id = p.id\n"
                + "where 1=1";

        if (!category.equals("all")) {
            xSql += " and [category_id]= ?";
        }
        if (!status.equals("all")) {
            xSql += " and r.[status]= ?";
        }

        xSql += " and [subject_name] like ?";
        xSql += " order by [id] asc offset ? rows fetch next 5 rows only";

        try {
            ps = con.prepareStatement(xSql);

            int i = 1;
            if (!category.equals("all")) {
                ps.setInt(i, Integer.parseInt(category));
                i++;
            }
            if (!status.equals("all")) {
                ps.setInt(i, Integer.parseInt(status));
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
            Date xExpired;
            int xStatus;
            String xTime;
            MyRegistration x;
            while (rs.next()) {
                xID = rs.getInt("id");
                xSubject_id = rs.getInt("subject_id");
                xPrice_package_id = rs.getInt("price_package_id");
                xUser_id = rs.getInt("user_id");
                xCreated = rs.getDate("created");
                xCategory_id = rs.getInt("category_id");
                xSubject_name = rs.getString("subject_name");
                xExpired = rs.getDate("expired");
                xStatus = rs.getInt("status");
                xTime = rs.getString("time_only");
                x = new MyRegistration(xID, xSubject_id, xPrice_package_id, xUser_id, xCreated, xCategory_id, xSubject_name, xExpired, xStatus, xTime);
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

    public int getTotalAllRegistrationFilter(String category, String search, String status) {
        try {
            String strSelect = "select count(*) from registration r\n"
                    + "WHERE 1=1 ";
            if (!category.equals("all")) {
                strSelect += " and [category_id]= ?";
            }
            if (!status.equals("all")) {
                strSelect += " and [status]= ?";
            }

            strSelect += " and [subject_name] like ? ";

            ps = con.prepareStatement(strSelect);

            int i = 1;
            if (!category.equals("all")) {
                ps.setInt(i, Integer.parseInt(category));
                i++;
            }
            if (!status.equals("all")) {
                ps.setInt(i, Integer.parseInt(status));
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
    
    public List<MyRegistration> getAllRegistration(int user_id) {
        List<MyRegistration> mr = new ArrayList<>();
        String Sql = "select * from registration where user_id = ?";
        try {
            ps = con.prepareStatement(Sql);
            ps.setInt(1, user_id);
            rs = ps.executeQuery();
            while (rs.next()) {
                int id = rs.getInt("id");
                int subjectId = rs.getInt("subject_id");
                int pricePackgeId = rs.getInt("price_package_id");
                int userId = rs.getInt("user_id");
                Date created = rs.getDate("created");
                int categoryId = rs.getInt("category_id"); 
                String subjectName = rs.getString("subject_name");
                int status = rs.getInt("status");
                mr.add(new MyRegistration(id, subjectId, pricePackgeId, userId, created, categoryId, subjectName, status));
            }
        } catch (Exception e) {
                        System.out.println("getAllRegistration: " + e.getMessage());

        }
        return mr;
    }
    public void deleteRegistration(String registrationId) {
        xSql = "DELETE FROM [dbo].[registration]\n"
                + "      WHERE id = ?";
        try {
            ps = con.prepareStatement(xSql);
            ps.setString(1, registrationId);

            ps.executeUpdate();
            ps.close();
        } catch (Exception e) {
            System.out.println("delete: " + e.getMessage());
        }
    }

    public MyRegistration checkMyRegistration(int id, int user_id) {

        try {
            String strSelect = "select registration.id,subject_id,price_package_id,user_id,created,category_id,subject_name,registration.status from registration\n"
                    + "inner join price_package on price_package_id = price_package.id\n"
                    + "\n"
                    + "where DATEADD(DAY,price_package.duration,registration.created) >GETDATE()\n"
                    + "and subject_id = ? and user_id = ? and registration.status = 1";
            ps = con.prepareStatement(strSelect);
            ps.setInt(1, id);
            ps.setInt(2, user_id);
            rs = ps.executeQuery();
            int xID;
            int xSubject_id;
            int xPrice_package_id;
            int xUser_id;
            Date xCreated;
            int xCategory_id;
            String xSubject_name;
            int xStatus;
            MyRegistration x;
            while (rs.next()) {
                xID = rs.getInt("id");
                xSubject_id = rs.getInt("subject_id");
                xPrice_package_id = rs.getInt("price_package_id");
                xUser_id = rs.getInt("user_id");
                xCreated = rs.getDate("created");
                xCategory_id = rs.getInt("category_id");
                xSubject_name = rs.getString("subject_name");
                xStatus = rs.getInt("status");
                return new MyRegistration(xID, xSubject_id, xPrice_package_id, xUser_id, xCreated, xCategory_id, xSubject_name, xStatus);
//                x = new MyRegistration(xID, xSubject_id, xPrice_package_id, xUser_id, xCreated);

            }
        } catch (Exception e) {
            System.out.println("checkMyRegistration: " + e.getMessage());
        }

        return null;
    }
}
