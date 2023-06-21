/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dal;

import java.util.ArrayList;
import java.util.List;
import model.User;
import model.UserProfile;

/**
 *
 * @author ADMIN
 */
public class UserProfileDAO extends MyDAO {

    public String getUserName(int id) {
        xSql = "select full_name \n"
                + "from user_profile where user_id = ?";
        String x = null;
        try {
            ps = con.prepareStatement(xSql);
            ps.setInt(1, id);
            rs = ps.executeQuery();
            String xFull_name;

            if (rs.next()) {
                xFull_name = rs.getString("full_name");

                x = xFull_name;
            }
            rs.close();
            ps.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return (x);
    }

    public void update(UserProfile x) {
        xSql = "UPDATE [dbo].[user_profile]\n"
                + "   SET \n"
                + "      [avatar]= ?\n"
                + "      ,[full_name]= ?\n"
                + "      ,[gender] = ? \n"
                + "      ,[dob] = ? \n"
                + "      ,[phone_number] = ? \n"
                + "      ,[modified] = GETDATE()\n"
                + " WHERE [user_id] = ?";
        try {
            ps = con.prepareStatement(xSql);
            ps.setString(1, x.getAvatar());
            ps.setString(2, x.getFull_name());
            ps.setInt(3, x.getGender());
            ps.setString(4, x.getDob());
            ps.setString(5, x.phone_number());
            ps.setInt(6, x.getUser_id());
            ps.executeUpdate();
            ps.close();
        } catch (Exception e) {
            System.out.println("update: " + e.getMessage());
        }
    }

    public UserProfile getUserProfilefull(int userId) {
       
        try {
            String strSelect = "select [user_id],avatar,full_name,gender,phone_number,dob,created,modified \n"
                    + "                                        FROM user_profile LEFT JOIN [user] ON [user].id = [user_profile].[user_id] where id = ?";
            ps = con.prepareStatement(strSelect);
            ps.setInt(1, userId);
            rs = ps.executeQuery();
            UserDAO u = new UserDAO();

            while (rs.next()) {
                int user_id = rs.getInt(1);
                String avatar = rs.getString(2);
                String full_name = rs.getString(3);
                int gender = rs.getInt(4);
                String phone_number = rs.getString(5);
                String dob = rs.getString(6);
                String created = rs.getString(7);
                String modified = rs.getString(8);
                User user = u.getUserById(user_id);
                UserProfile up = new UserProfile(user_id, avatar, full_name, gender, phone_number, dob, created, modified, user);
                return up;
            }
        } catch (Exception e) {
            System.out.println("getUserProfilefull:" + e.getMessage());
        }
        return null;
    }

    public UserProfile getUserProfile(int userId) {
        UserProfile u = null;
        try {
            String strSelect = "select * from [user_profile] "
                    + "where user_id= ?";
            ps = con.prepareStatement(strSelect);
            ps.setInt(1, userId);
            rs = ps.executeQuery();
            while (rs.next()) {
                int user_id = rs.getInt("user_id");
                String avatar = rs.getString("avatar");
                String full_name = rs.getString("full_name");
                int gender = rs.getInt("gender");
                String dob = rs.getString("dob");
                String phone_number = rs.getString("phone_number");
                u = new UserProfile(user_id, avatar, full_name, gender, dob, phone_number);
            }
        } catch (Exception e) {
            System.out.println("getUP:" + e.getMessage());
        }
        return u;
    }

    public List<UserProfile> getListUserProfile() {
        List<UserProfile> data = new ArrayList<>();
        try {
            String strSelect = "select [user_id],avatar,full_name,gender,phone_number,dob,created,modified from user_profile";
            ps = con.prepareStatement(strSelect);
            rs = ps.executeQuery();
            UserDAO u = new UserDAO();
            while (rs.next()) {
                int id = rs.getInt(1);
                String avatar = rs.getString(2);
                String full_name = rs.getString(3);
                int gender = rs.getInt(4);
                String phone_number = rs.getString(5);
                String dob = rs.getString(6);

                String created = rs.getString(7);
                String modified = rs.getString(8);
                User user = u.getUserById(id);
                UserProfile up = new UserProfile(id, avatar, full_name, gender, phone_number, dob, created, modified, user);
                data.add(up);
            }
        } catch (Exception e) {
            System.out.println("getAllAccount: " + e.getMessage());
        }
        return data;
    }
    public List<UserProfile> getListUserProfileByRole(int aid) {
        List<UserProfile> data = new ArrayList<>();
        try {
            String strSelect = "select [user_id],avatar,full_name,gender,phone_number,dob,created,modified"+
                                                       " FROM user_profile LEFT JOIN [user] ON [user].id = [user_profile].[user_id] where role_id = ?";
            ps = con.prepareStatement(strSelect);
            ps.setInt(1, aid);
            rs = ps.executeQuery();
            UserDAO u = new UserDAO();
            while (rs.next()) {
                int id = rs.getInt(1);
                String avatar = rs.getString(2);
                String full_name = rs.getString(3);
                int gender = rs.getInt(4);
                String phone_number = rs.getString(5);
                String dob = rs.getString(6);

                String created = rs.getString(7);
                String modified = rs.getString(8);
                User user = u.getUserById(id);
                UserProfile up = new UserProfile(id, avatar, full_name, gender, phone_number, dob, created, modified, user);
                data.add(up);
            }
        } catch (Exception e) {
            System.out.println("getListUserProfileByRole " + e.getMessage());
        }
        return data;
    }

    public List<UserProfile> pagingUserList(int index, String search) {
        List<UserProfile> data = new ArrayList<>();
        try {
            String strSelect = "select [user_id],avatar,full_name,gender,phone_number,dob,created,modified \n"
                    + "                    FROM user_profile LEFT JOIN [user] ON [user].id = [user_profile].[user_id] where full_name like ? or account like ? or phone_number like ? \n"
                    + "                    order by [user_id]\n"
                    + "                    offset ? rows fetch next 5 rows only";
            ps = con.prepareStatement(strSelect);
            ps.setString(1, "%" + search + "%");
            ps.setString(2, "%" + search + "%");
            ps.setString(3, "%" + search + "%");
            ps.setInt(4, (index - 1) * 5);
            rs = ps.executeQuery();
            UserDAO u = new UserDAO();
            while (rs.next()) {
                int id = rs.getInt(1);
                String avatar = rs.getString(2);
                String full_name = rs.getString(3);
                int gender = rs.getInt(4);
                String phone_number = rs.getString(5);
                String dob = rs.getString(6);

                String created = rs.getString(7);
                String modified = rs.getString(8);
                User user = u.getUserById(id);
                UserProfile up = new UserProfile(id, avatar, full_name, gender, phone_number, dob, created, modified, user);
                data.add(up);
            }
        } catch (Exception e) {
            System.out.println("getAllAccount: " + e.getMessage());
        }
        return data;
    }

    public List<UserProfile> filterUserList(int index, String gender, String role, String status, String search) {
        List<UserProfile> data = new ArrayList<>();
        try {
//            String strSelect = "select [user_id],avatar,full_name,gender,phone_number,dob,created,modified from user_profile left join [user] on [user].id = [user_profile].[user_id]\n"
//                    + "			    where role_id = ? and gender = ? and [status] = ?\n"
//                    + "                     order by [user_id]\n"
//                    + "                     offset ? rows fetch next 5 rows only";
            String strSelect = "SELECT [user_id], avatar, full_name, gender, phone_number, dob, created, modified FROM user_profile LEFT JOIN [user] ON [user].id = [user_profile].[user_id] WHERE 1=1";

            if (!role.equals("all")) {
                strSelect += " and [role_id]= ?";
            }
            if (!gender.equals("all")) {
                strSelect += " and [gender]= ?";
            }
            if (!status.equals("all")) {
                strSelect += " and [status]= ?";

            }
            strSelect += " and (full_name like ? or account like ? or phone_number like ?) ";
            strSelect += " ORDER BY [user_id] OFFSET ? ROWS FETCH NEXT 5 ROWS ONLY";
            ps = con.prepareStatement(strSelect);
            int i = 1;
            if (!role.equals("all")) {
                ps.setInt(i, Integer.parseInt(role));
                i++;
            }
            if (!gender.equals("all")) {
                ps.setInt(i, Integer.parseInt(gender));
                i++;
            }
            if (!status.equals("all")) {
                ps.setInt(i, Integer.parseInt(status));
                i++;
            }
            ps.setString(i, "%" + search + "%");
            i++;
            ps.setString(i, "%" + search + "%");
            i++;
            ps.setString(i, "%" + search + "%");
            i++;
            ps.setInt(i, (index - 1) * 5);
            rs = ps.executeQuery();
            UserDAO u = new UserDAO();
            while (rs.next()) {
                int id = rs.getInt(1);
                String avatar = rs.getString(2);
                String full_name = rs.getString(3);
                int genders = rs.getInt(4);
                String phone_number = rs.getString(5);
                String dob = rs.getString(6);

                String created = rs.getString(7);
                String modified = rs.getString(8);
                User user = u.getUserById(id);
                UserProfile up = new UserProfile(id, avatar, full_name, genders, phone_number, dob, created, modified, user);
                data.add(up);
            }
        } catch (Exception e) {
            System.out.println("filterUserList: " + e.getMessage());
        }
        return data;
    }

    public int getTotalUserProfile(String search) {
        try {
            String strSelect = "select count(*) FROM user_profile LEFT JOIN [user] ON [user].id = [user_profile].[user_id] where full_name like ? or account like ? or phone_number like ? ";
            ps = con.prepareStatement(strSelect);
            ps.setString(1, "%" + search + "%");
            ps.setString(2, "%" + search + "%");
            ps.setString(3, "%" + search + "%");
            rs = ps.executeQuery();
            UserDAO u = new UserDAO();
            while (rs.next()) {
                return rs.getInt(1);
            }
        } catch (Exception e) {
            System.out.println("getTotalUserProfile: " + e.getMessage());
        }

        return 0;
    }

    public int getTotalUserProfileFilter(String gender, String role, String status, String search) {
        try {
            String strSelect = "select count(*) from user_profile left join [user] on [user].id = [user_profile].[user_id]  WHERE 1=1 ";
            if (!role.equals("all")) {
                strSelect += " and [role_id]= ?";
            }
            if (!gender.equals("all")) {
                strSelect += " and [gender]= ?";
            }
            if (!status.equals("all")) {
                strSelect += " and [status]= ?";

            }
            strSelect += " and (full_name like ? or account like ? or phone_number like ?) ";

            ps = con.prepareStatement(strSelect);
            int i = 1;
            if (!role.equals("all")) {
                ps.setInt(i, Integer.parseInt(role));
                i++;
            }
            if (!gender.equals("all")) {
                ps.setInt(i, Integer.parseInt(gender));
                i++;
            }
            if (!status.equals("all")) {
                ps.setInt(i, Integer.parseInt(status));
                i++;
            }
            ps.setString(i, "%" + search + "%");
            i++;
            ps.setString(i, "%" + search + "%");
            i++;
            ps.setString(i, "%" + search + "%");

            rs = ps.executeQuery();
            UserDAO u = new UserDAO();
            while (rs.next()) {
                return rs.getInt(1);
            }
        } catch (Exception e) {
            System.out.println("getTotalUserProfileFilter: " + e.getMessage());
        }

        return 0;
    }
    
     public void changeUser(int id) {
        try {
            String strAdd = "update [user_profile] set [modified] = GETDATE() where user_id = ?";
            ps = con.prepareStatement(strAdd);
            
           
            ps.setInt(1, id);

            ps.executeUpdate();
        } catch (Exception e) {
            System.out.println("changeUser: " + e.getMessage());
        }
    }
}
