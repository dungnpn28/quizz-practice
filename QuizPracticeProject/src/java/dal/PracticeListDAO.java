/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dal;

import java.sql.Time;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;
import model.Exam;

/**
 *
 * @author dai
 */
public class PracticeListDAO extends MyDAO{
    public List<Exam> getExamByUserID(int userID) {
        List<Exam> examList = new ArrayList<>();
        xSql = "SELECT exam.id, subject.name AS subject_name, exam.name, exam.level, exam.number_of_question, exam.duration, exam.pass_rate, exam.description\n"
                + "                FROM exam\n"
                + "                INNER JOIN exam_user ON exam.id = exam_user.exam_id\n"
                + "                INNER JOIN subject ON exam.subject_id = subject.id\n"
                + "                WHERE exam_user.user_id = ? and exam.mode = 0";
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

    public List<Exam> getExamByUserIDandSubID(int userID, int subID) {
        List<Exam> examList = new ArrayList<>();
        xSql = "SELECT exam.id, subject.name AS subject_name, exam.name, exam.level, exam.number_of_question, exam.duration, exam.pass_rate\n"
                + "FROM exam\n"
                + "INNER JOIN exam_user ON exam.id = exam_user.exam_id\n"
                + "INNER JOIN subject ON exam.subject_id = subject.id\n"
                + "WHERE exam_user.user_id = ? and exam.mode = 0 and subject_id = ?";;
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
                + "WHERE exam_user.user_id = ? and exam.mode = 0 and exam.name like ?";
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
}
