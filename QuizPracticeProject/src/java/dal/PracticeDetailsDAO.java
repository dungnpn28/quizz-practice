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
import model.Dimension;
import model.Exam;

/**
 *
 * @author dai
 */
public class PracticeDetailsDAO extends MyDAO {

    public List<Dimension> getSubjectDimension() {
        List<Dimension> t = new ArrayList<>();
        xSql = "select * from dimension";
        try {
            ps = con.prepareStatement(xSql);
            rs = ps.executeQuery();
            int xID;
            String xName;
            int xType_id;
            String xDescription;
            Dimension x;
            while (rs.next()) {
                xID = rs.getInt("id");
                xName = rs.getString("name");
                xType_id = rs.getInt("type_id");
                xDescription = rs.getString("description");
                x = new Dimension(xID, xName, xType_id, xDescription);
                t.add(x);
            }
            rs.close();
            ps.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return (t);
    }

    public String getDimensionName(int dimensionId) {
        xSql = "select name from dimension where id = ?";
        String xName = "";
        try {
            ps = con.prepareStatement(xSql);
            ps.setInt(1, dimensionId);
            rs = ps.executeQuery();

            if (rs.next()) {
                xName = rs.getString("name");
            }
            rs.close();
            ps.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return xName;
    }

//    public List<Exam> getExamByName() {
//        List<Exam> examList = new ArrayList<>();
//        xSql = "SELECT exam.id, subject.name AS subject_name, exam.name, exam.level, exam.number_of_question, exam.duration, exam.pass_rate\n"
//                + "FROM exam\n"
//                + "INNER JOIN exam_user ON exam.id = exam_user.exam_id\n"
//                + "INNER JOIN subject ON exam.subject_id = subject.id\n";
//                
//        int xID;
//        String xSubjectName;
//        String xName;
//        int xLevel;
//        Time xDuration;
//        String xxDuration;
//        double xPass_rate;
//        int xNumQue;
//        Exam x = null;
//        try {
//            ps = con.prepareStatement(xSql);
//
//            rs = ps.executeQuery();
//            while (rs.next()) {
//                xID = rs.getInt("id");
//                xName = rs.getString("name");
//                xSubjectName = rs.getString("subject_name");
//                xLevel = rs.getInt("level");
//                xDuration = rs.getTime("duration");
//                SimpleDateFormat dateFormat = new SimpleDateFormat("HH:mm:ss");
//                xxDuration = dateFormat.format(xDuration);
//                xPass_rate = rs.getDouble("pass_rate");
//                xNumQue = rs.getInt("number_of_question");
//
//                x = new Exam(xID, xName, xLevel, xxDuration, xPass_rate, xNumQue, xSubjectName);
//                examList.add(x);
//            }
//            rs.close();
//            ps.close();
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
//        return (examList);
//    }
    public List<Exam> getExamByName() {
        List<Exam> examList = new ArrayList<>();
        xSql = "SELECT e.id, e.name, e.subject_id, e.level, e.duration, e.pass_rate, e.number_of_question, e.created, e.description, e.mode,\n"
                + "qe.question_id, qe.question_order, qe.marks_allocated,\n"
                + "q.content, q.option_a, q.option_b, q.option_c, q.option_d, q.answer, q.created, q.modified\n"
                + "FROM exam e\n"
                + "JOIN question_exam qe ON e.id = qe.exam_id\n"
                + "JOIN question q ON qe.question_id = q.id;";
        int xID;
        int xExam_id;
        int xQuestion_id;
        int xQuestion_order;
        int xSubject_id;
        String xContent;
        String xOption_a;
        String xOption_b;
        String xOption_c;
        String xOption_d;
        String xAnswer;
        Exam x = null;
        try {
            ps = con.prepareStatement(xSql);

            rs = ps.executeQuery();
            while (rs.next()) {
                xID = rs.getInt("id");
                xExam_id = rs.getInt("exam_id");
                xQuestion_id = rs.getInt("question_id");
                xQuestion_order = rs.getInt("question_order");
                xSubject_id = rs.getInt("subject_id");
                xContent = rs.getString("content");
                xOption_a = rs.getString("option_a");
                xOption_b = rs.getString("option_b");
                xOption_c = rs.getString("option_c");
                xOption_d = rs.getString("option_d");
                xAnswer = rs.getString("answer");

//                x = new Exam(xID, xExam_id, xQuestion_id, xQuestion_order, xSubject_id, xContent, xOption_a,xOption_b,xOption_c,xOption_d,xAnswer);
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
