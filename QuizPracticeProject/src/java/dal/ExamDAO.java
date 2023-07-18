/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dal;

import java.sql.Date;
import java.sql.Time;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;
import model.Attempt;
import model.Dimension_Type;
import model.Exam;
import model.Subject;

/**
 *
 * @author LENOVO
 */
public class ExamDAO extends MyDAO {

    public List<Exam> getExamByUserID(int userID) {
        List<Exam> examList = new ArrayList<>();
        xSql = "SELECT exam.id, subject.name AS subject_name, exam.name, exam.level, exam.number_of_question, exam.duration, exam.pass_rate, exam.description\n"
                + "                FROM exam\n"
                + "                INNER JOIN exam_user ON exam.id = exam_user.exam_id\n"
                + "                INNER JOIN subject ON exam.subject_id = subject.id\n"
                + "                WHERE exam_user.user_id = ? and exam.mode = 1";
        int xID;
        String xSubjectName;
        String xName;
        int xLevel;
        Time xDuration;
        String xxDuration;
        double xPass_rate;
        int xNumQue;
        String xDescription;
        Exam x = null;
        try {
            ps = con.prepareStatement(xSql);
            ps.setInt(1, userID);
            rs = ps.executeQuery();
            while (rs.next()) {
                xID = rs.getInt("id");
                xName = rs.getString("name");
                xSubjectName = rs.getString("subject_name");
                xName = rs.getString("name");
                xLevel = rs.getInt("level");
                xDuration = rs.getTime("duration");
                SimpleDateFormat dateFormat = new SimpleDateFormat("HH:mm:ss");
                xxDuration = dateFormat.format(xDuration);
                xPass_rate = rs.getDouble("pass_rate");
                xNumQue = rs.getInt("number_of_question");
                xDescription = rs.getString("description");
                x = new Exam(xID, xName, xLevel, xxDuration, xPass_rate, xNumQue, xSubjectName, xDescription);
                examList.add(x);
            }
            rs.close();
            ps.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return (examList);
    }

    public List<Exam> getExamByUserIDwithPaging(int userID, int page, int PAGE_SIZE) {
        List<Exam> examList = new ArrayList<>();
        xSql = "SELECT exam.id, subject.name AS subject_name, exam.name, exam.level, exam.number_of_question, exam.duration, exam.pass_rate, exam.description \n"
                + "                              FROM exam \n"
                + "                              INNER JOIN exam_user ON exam.id = exam_user.exam_id\n"
                + "                             INNER JOIN subject ON exam.subject_id = subject.id\n"
                + "                               WHERE exam_user.user_id = ? and exam.mode = 1\n"
                + "							   order by exam.id\n"
                + "							   offset (?-1)*? row fetch next ? rows only";
        int xID;
        String xSubjectName;
        String xName;
        int xLevel;
        Time xDuration;
        String xxDuration;
        double xPass_rate;
        int xNumQue;
        String xDescription;
        Exam x = null;
        try {
            ps = con.prepareStatement(xSql);
            ps.setInt(1, userID);
            ps.setInt(2, page);
            ps.setInt(3, PAGE_SIZE);
            ps.setInt(4, PAGE_SIZE);
            rs = ps.executeQuery();
            while (rs.next()) {
                xID = rs.getInt("id");
                xName = rs.getString("name");
                xSubjectName = rs.getString("subject_name");
                xName = rs.getString("name");
                xLevel = rs.getInt("level");
                xDuration = rs.getTime("duration");
                SimpleDateFormat dateFormat = new SimpleDateFormat("HH:mm:ss");
                xxDuration = dateFormat.format(xDuration);
                xPass_rate = rs.getDouble("pass_rate");
                xNumQue = rs.getInt("number_of_question");
                xDescription = rs.getString("description");
                x = new Exam(xID, xName, xLevel, xxDuration, xPass_rate, xNumQue, xSubjectName, xDescription);
                examList.add(x);
            }
            rs.close();
            ps.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return (examList);
    }

    public int getTotalExam() {
        xSql = "select count(id)  from Exam";
        int totalExam = 0;
        try {
            ps = con.prepareStatement(xSql);
            rs = ps.executeQuery();
            while (rs.next()) {
                return rs.getInt(1);
            }
            rs.close();
            ps.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return (totalExam);
    }

    public int getTotalExamByUserid(int userId) {
        xSql = "select count(exam.id)  from Exam \n"
                + "inner join exam_user ON exam.id = exam_user.exam_id\n"
                + "where exam_user.user_id = ? and exam.mode = 1";
        int totalExam = 0;
        try {
            ps = con.prepareStatement(xSql);
            ps.setInt(1, userId);
            rs = ps.executeQuery();
            while (rs.next()) {
                return rs.getInt(1);
            }
            rs.close();
            ps.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return (totalExam);
    }

    public int getTotalExamByUseridAndName(int userId, String keyword) {
        xSql = "select count(exam.id)  from Exam \n"
                + "                inner join exam_user ON exam.id = exam_user.exam_id\n"
                + "                where exam_user.user_id = ? and exam.mode = 1 and exam.name like ?";
        int totalExam = 0;
        try {
            ps = con.prepareStatement(xSql);
            ps.setInt(1, userId);
            ps.setString(2, "%" + keyword + "%");

            rs = ps.executeQuery();
            while (rs.next()) {
                return rs.getInt(1);
            }
            rs.close();
            ps.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return (totalExam);
    }

    public List<Exam> getExamByUserIDandSubID(int userID, int subID) {
        List<Exam> examList = new ArrayList<>();
        xSql = "SELECT exam.id, subject.name AS subject_name, exam.name, exam.level, exam.number_of_question, exam.duration, exam.pass_rate\n"
                + "FROM exam\n"
                + "INNER JOIN exam_user ON exam.id = exam_user.exam_id\n"
                + "INNER JOIN subject ON exam.subject_id = subject.id\n"
                + "WHERE exam_user.user_id = ? and exam.mode = 1 and subject_id = ?";;
        int xID;
        String xSubjectName;
        String xName;
        int xLevel;
        Time xDuration;
        String xxDuration;
        double xPass_rate;
        int xNumQue;
        Exam x = null;
        try {
            ps = con.prepareStatement(xSql);
            ps.setInt(1, userID);
            ps.setInt(2, subID);

            rs = ps.executeQuery();
            while (rs.next()) {
                xID = rs.getInt("id");
                xName = rs.getString("name");
                xSubjectName = rs.getString("subject_name");
                xName = rs.getString("name");
                xLevel = rs.getInt("level");
                xDuration = rs.getTime("duration");
                SimpleDateFormat dateFormat = new SimpleDateFormat("HH:mm:ss");
                xxDuration = dateFormat.format(xDuration);
                xPass_rate = rs.getDouble("pass_rate");
                xNumQue = rs.getInt("number_of_question");
                x = new Exam(xID, xName, xLevel, xxDuration, xPass_rate, xNumQue, xSubjectName);
                examList.add(x);
            }
            rs.close();
            ps.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return (examList);
    }

    public List<Exam> getExamByName(String keyword, int id) {
        List<Exam> examList = new ArrayList<>();
        xSql = "SELECT exam.id, subject.name AS subject_name, exam.name, exam.level, exam.number_of_question, exam.duration, exam.pass_rate\n"
                + "FROM exam\n"
                + "INNER JOIN exam_user ON exam.id = exam_user.exam_id\n"
                + "INNER JOIN subject ON exam.subject_id = subject.id\n"
                + "WHERE exam_user.user_id = ? and exam.mode = 1 and exam.name like ?";
        int xID;
        String xSubjectName;
        String xName;
        int xLevel;
        Time xDuration;
        String xxDuration;
        double xPass_rate;
        int xNumQue;
        Exam x = null;
        try {
            ps = con.prepareStatement(xSql);
            ps.setInt(1, id);
            ps.setString(2, "%" + keyword + "%");

            rs = ps.executeQuery();
            while (rs.next()) {
                xID = rs.getInt("id");
                xName = rs.getString("name");
                xSubjectName = rs.getString("subject_name");
                xLevel = rs.getInt("level");
                xDuration = rs.getTime("duration");
                SimpleDateFormat dateFormat = new SimpleDateFormat("HH:mm:ss");
                xxDuration = dateFormat.format(xDuration);
                xPass_rate = rs.getDouble("pass_rate");
                xNumQue = rs.getInt("number_of_question");

                x = new Exam(xID, xName, xLevel, xxDuration, xPass_rate, xNumQue, xSubjectName);
                examList.add(x);
            }
            rs.close();
            ps.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return (examList);
    }

    public List<Exam> getExamByNameWithPaging(String keyword, int id, int page, int PAGE_SIZE) {
        List<Exam> examList = new ArrayList<>();
        xSql = "SELECT exam.id, subject.name AS subject_name, exam.name, exam.level, exam.number_of_question, exam.duration, exam.pass_rate\n"
                + "                FROM exam\n"
                + "                INNER JOIN exam_user ON exam.id = exam_user.exam_id\n"
                + "                INNER JOIN subject ON exam.subject_id = subject.id\n"
                + "                WHERE exam_user.user_id = ? and exam.mode = 1 and exam.name like ?\n"
                + "				order by exam.id\n"
                + "                		offset (?-1)*? row fetch next ? rows only";
        int xID;
        String xSubjectName;
        String xName;
        int xLevel;
        Time xDuration;
        String xxDuration;
        double xPass_rate;
        int xNumQue;
        Exam x = null;
        try {
            ps = con.prepareStatement(xSql);
            ps.setInt(1, id);
            ps.setString(2, "%" + keyword + "%");
            ps.setInt(3, page);
            ps.setInt(4, PAGE_SIZE);
            ps.setInt(5, PAGE_SIZE);
            rs = ps.executeQuery();
            while (rs.next()) {
                xID = rs.getInt("id");
                xName = rs.getString("name");
                xSubjectName = rs.getString("subject_name");
                xLevel = rs.getInt("level");
                xDuration = rs.getTime("duration");
                SimpleDateFormat dateFormat = new SimpleDateFormat("HH:mm:ss");
                xxDuration = dateFormat.format(xDuration);
                xPass_rate = rs.getDouble("pass_rate");
                xNumQue = rs.getInt("number_of_question");

                x = new Exam(xID, xName, xLevel, xxDuration, xPass_rate, xNumQue, xSubjectName);
                examList.add(x);
            }
            rs.close();
            ps.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return (examList);
    }

    public String getExamDurationById(int examId) {
        try {
            String strSelect = "select * from [exam] "
                    + "where id =? ";
            ps = con.prepareStatement(strSelect);
            ps.setInt(1, examId);
            rs = ps.executeQuery();
            while (rs.next()) {
                return rs.getString(5);
            }
        } catch (Exception e) {
            System.out.println("getExamDurationById:" + e.getMessage());
        }
        return null;
    }

    public List<Exam> getAllExam() {
        List<Exam> examList = new ArrayList<>();
        xSql = "SELECT * from exam";
        int xID;
        String xName;
        int xSubject_id;
        int xLevel;
        Time xDuration;
        double xPass_rate;
        int xNumQue;
        String xDescription;
        Date xCreated;
        int xMode;
        Exam x = null;
        try {
            ps = con.prepareStatement(xSql);
            rs = ps.executeQuery();
            while (rs.next()) {
                xID = rs.getInt("id");
                xName = rs.getString("name");
                xSubject_id = rs.getInt("subject_id");
                xLevel = rs.getInt("level");
                xDuration = rs.getTime("duration");
                SimpleDateFormat dateFormat = new SimpleDateFormat("HH:mm:ss");
                xPass_rate = rs.getDouble("pass_rate");
                xNumQue = rs.getInt("number_of_question");
                xDescription = rs.getString("description");
                xCreated = rs.getDate("created");
                xMode = rs.getInt("mode");
                x = new Exam(xID, xName, xSubject_id, xID, xLevel, xDescription, xPass_rate, xNumQue, xCreated);
                examList.add(x);
            }
            rs.close();
            ps.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return (examList);
    }

//    public static void main(String[] args) {
//        ExamDAO eDAO = new ExamDAO();
//        List<Exam> lExam = eDAO.getAllExam();
//        for (Exam exam : lExam) {
//            System.out.println(exam.getName());
//        }
//    }
    public String getExamNameById(int examId) {
        try {
            String strSelect = "select name from [exam] "
                    + "where id=?;";
            ps = con.prepareStatement(strSelect);
            ps.setInt(1, examId);
            rs = ps.executeQuery();
            while (rs.next()) {
                return rs.getString(1);
            }
        } catch (Exception e) {
            System.out.println("getExamNameById:" + e.getMessage());
        }
        return null;
    }

    public void insertExam(String name, int subject_id, int level, int hour, int minute, double pass_rate, int number_of_question, String description, boolean mode) {
        xSql = "INSERT INTO [dbo].[exam]\n"
                + "           ([name]\n"
                + "           ,[subject_id]\n"
                + "           ,[level]\n"
                + "           ,[duration]\n"
                + "           ,[pass_rate]\n"
                + "           ,[number_of_question]\n"
                + "           ,[description]\n"
                + "           ,[created]\n"
                + "           ,[mode]\n"
                + "           )\n"
                + "     VALUES\n"
                + "           (?\n"
                + "           ,?\n"
                + "           ,?\n"
                + "           ,?\n"
                + "           ,?\n"
                + "           ,?\n"
                + "           ,?\n"
                + "           ,GETDATE()\n"
                + "           ,?\n"
                + "           )";
        try {
            ps = con.prepareStatement(xSql);

            ps.setString(1, name);
            ps.setInt(2, subject_id);
            ps.setInt(3, level);
            Time duration = new Time(hour, minute, 0);
            ps.setTime(4, duration);
            ps.setDouble(5, pass_rate);
            ps.setInt(6, number_of_question);
            ps.setString(7, description);
            ps.setBoolean(8, mode);

            ps.executeUpdate();
            ps.close();
        } catch (Exception e) {
            System.out.println("insertExam:" + e.getMessage());
        }
    }
    
    public List<Integer> getExamIdBySubjectId(String subjectId) {
        List<Integer> t = new ArrayList<>();
        int xExam_id;
        try {
            String strSelect = "select id from [exam] "
                    + "where subject_id=?;";
            ps = con.prepareStatement(strSelect);
            ps.setString(1, subjectId);
            rs = ps.executeQuery();
            while (rs.next()) {
                xExam_id = rs.getInt("id");
                t.add(xExam_id);
            }
        } catch (Exception e) {
            System.out.println("getExamIdBySubjectId:" + e.getMessage());
        }
        return t;
    }

    public int getTotalExamFilter(String category, String search) {
        try {
            String strSelect = "select count(*) from exam WHERE mode = 1 AND 1=1 ";
            if (!category.equals("all")) {
                strSelect += " and [subject_id]= ?";
            }

            strSelect += " and [name] like ? ";

            ps = con.prepareStatement(strSelect);

            int i = 1;
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
            System.out.println("getTotalExamFilter: " + e.getMessage());
        }

        return 0;

    }

    public List<Exam> getExamWithPaging(int index, String category, String search) {
        List<Exam> t = new ArrayList<>();
        xSql = "select * from exam WHERE mode = 1 AND 1=1";

        if (!category.equals("all")) {
            xSql += " and [subject_id]= ?";
        }

        xSql += " and [name] like ? ";
        xSql += " order by [id] offset ? rows fetch next 5 rows only";

        try {
            ps = con.prepareStatement(xSql);

            int i = 1;
            if (!category.equals("all")) {
                ps.setInt(i, Integer.parseInt(category));
                i++;
            }

            ps.setString(i, "%" + search + "%");
            i++;
            ps.setInt(i, (index - 1) * 5);

            rs = ps.executeQuery();
            int xID;
            String xName;
            int xSubject_id;
            int xLevel;
            Time xDuration;
            double xPass_rate;
            int xNumber_of_question;
            String xDescription;
            Date xCreated;
            int xMode;
            String xxDuration;
            Exam x;
            while (rs.next()) {
                xID = rs.getInt("id");
                xName = rs.getString("name");
                xSubject_id = rs.getInt("subject_id");
                xLevel = rs.getInt("level");
                xDuration = rs.getTime("duration");
                SimpleDateFormat dateFormat = new SimpleDateFormat("HH:mm:ss");
                xxDuration = dateFormat.format(xDuration);
                xPass_rate = rs.getDouble("pass_rate");
                xNumber_of_question = rs.getInt("number_of_question");
                xDescription = rs.getString("description");
                xCreated = rs.getDate("created");
                xMode = rs.getInt("mode");
                x = new Exam(xID, xName, xSubject_id, xLevel, xxDuration, xPass_rate, xNumber_of_question, xCreated, xDescription);
                t.add(x);
            }
            rs.close();
            ps.close();
        } catch (Exception e) {
            System.out.println("getExamWithPaging: " + e.getMessage());
        }
        return (t);
    }

public Exam getExamById(int examId) {
    try {
        String strSelect = "select * from [exam] "
                + "where id=?;";
        int xID;
        String xName;
        int xSubject_id;
        int xLevel;
        Time xDuration;
        String xxDuration;
        double xPass_rate;
        int xNumQue;
        String xDescription;
        Date xCreated;
        int xMode;
        Exam x = null;
        ps = con.prepareStatement(strSelect);
        ps.setInt(1, examId);
        rs = ps.executeQuery();
        while (rs.next()) {
            xName = rs.getString("name");
            xSubject_id = rs.getInt("subject_id");
            xLevel = rs.getInt("level");
            xDuration = rs.getTime("duration");
            SimpleDateFormat dateFormat = new SimpleDateFormat("HH:mm:ss");
            xxDuration = dateFormat.format(xDuration);
            xPass_rate = rs.getDouble("pass_rate");
                xNumQue = rs.getInt("number_of_question");
                xDescription = rs.getString("description");
                xCreated = rs.getDate("created");
                xMode = rs.getInt("mode");
                boolean xxMode = (xMode == 1) ? true : false;
                x = new Exam(examId, xName, xSubject_id, xLevel, xxDuration, xPass_rate, xNumQue, xDescription, xCreated, xxMode);
                return x;
            }
        } catch (Exception e) {
            System.out.println("getExamNameById:" + e.getMessage());
        }
        return null;
    }

//    public static void main(String[] args) {
//        ExamDAO eDAO = new ExamDAO();
//        Exam lExam = eDAO.getExamById(5);
//        System.out.println(lExam.isMode());
//    }
    public void update(String name, int subjectId, int level, int hour, int minute, Double pass_rate, int number_of_question, String description, boolean mode, int dimension_type_id, int examId) {
        xSql = "UPDATE [dbo].[exam]\n"
                + "   SET [name] = ?\n"
                + "      ,[subject_id] = ?\n"
                + "      ,[level] = ?\n"
                + "      ,[duration] = ?\n"
                + "      ,[pass_rate] = ?\n"
                + "      ,[number_of_question] = ?\n"
                + "      ,[description] = ?\n"
                + "      ,[mode] = ?\n"
                + "      ,[dimension_type_id] = ?\n"
                + " WHERE [id] = ?";
        try {
            ps = con.prepareStatement(xSql);
            ps.setString(1, name);
            ps.setInt(2, subjectId);
            ps.setInt(3, level);
            Time duration = new Time(hour, minute, 0);
            ps.setTime(4, duration);
            ps.setDouble(5, pass_rate);
            ps.setInt(6, number_of_question);
            ps.setString(7, description);
            ps.setBoolean(8, mode);
            ps.setInt(9, dimension_type_id);
            ps.setInt(10, examId);
            ps.executeUpdate();
            ps.close();
        } catch (Exception e) {
            System.out.println("update: " + e.getMessage());
        }
    }

    public void updateSubject(Subject x) {
        xSql = "UPDATE [dbo].[Subject]\n"
                + "   SET [name] = ?\n"
                + " WHERE [id] = ?";
        try {
            ps = con.prepareStatement(xSql);
            ps.setString(1, x.getName());;
            ps.setInt(2, x.getId());
            ps.executeUpdate();
            ps.close();
        } catch (Exception e) {
            System.out.println("update: " + e.getMessage());
        }
    }

    public void updateDimensionType(Dimension_Type x) {
        xSql = "UPDATE [dbo].[dimension_type]\n"
                + "   SET [name] = ?\n"
                + " WHERE [id] = ?";
        try {
            ps = con.prepareStatement(xSql);
            ps.setString(1, x.getName());;
            ps.setInt(2, x.getId());
            ps.executeUpdate();
            ps.close();
        } catch (Exception e) {
            System.out.println("update: " + e.getMessage());
        }
    }

    public void insertPracticeDetail(int subject_id, int number_of_question) {
        xSql = "INSERT INTO [dbo].[exam]([name],[subject_id],[level],[duration],[pass_rate],[number_of_question],[description],[created],[mode])\n"
                + "     VALUES (?,?,?,?,?,?,?,GETDATE(),?)";
        try {
            ps = con.prepareStatement(xSql);

            ps.setString(1, "practice " + "GETDATE()");
            ps.setInt(2, subject_id);
            ps.setInt(3, 1);
            Time duration = new Time(0, number_of_question * 5, 0);
            ps.setTime(4, duration);
            ps.setDouble(5, 1);
            ps.setInt(6, number_of_question);
            ps.setString(7, "this is new practice for practice GETDATE()");
            ps.setBoolean(8, false);
            
            ps.executeUpdate();
            ps.close();
        } catch (Exception e) {
            System.out.println("insert exam: " + e.getMessage());
        }
    }

    public int getMaxIdFromExam() {
        xSql = "select MAX(id) as id from exam ";
        int xId = 0;
        try {
            ps = con.prepareStatement(xSql);
            rs = ps.executeQuery();
            if(rs.next()) {
                xId = rs.getInt("id");
            }
            ps.close();

        }catch (Exception e) {
            System.out.println("get max id: " + e.getMessage());
        }
        return xId;
    }
}
