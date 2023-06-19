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
import model.Exam;

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
}
