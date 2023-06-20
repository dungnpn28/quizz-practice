/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dal;

import java.util.ArrayList;
import java.util.List;
import model.Lesson;
import model.Lesson_Topic;
import model.Lesson_Type;

/**
 *
 * @author dai
 */
public class LessonDAO extends MyDAO {

    public List<Lesson> getLesson() {
        List<Lesson> t = new ArrayList<>();
        xSql = " select l.*, lt.name as 'lesson_type_name', lp.name as 'lesson_topic_name'\n"
                + "  from lesson l\n"
                + "  join lesson_type lt on l.type_id = lt.id\n"
                + "  join lesson_topic lp on l.topic_id = lp.id";
        try {
            ps = con.prepareStatement(xSql);
            rs = ps.executeQuery();
            int xID;
            int xSubject_id;
            int xTopic_id;
            String xName;
            int xType_id;
            int xOrder;
            String xVideo_link;
            String xHtml_content;
            String xLesson_type_name;
            String xLesson_topic_name;

            boolean xStatus;
            Lesson x;
            while (rs.next()) {
                xID = rs.getInt("id");
                xSubject_id = rs.getInt("subject_id");
                xTopic_id = rs.getInt("topic_id");
                xName = rs.getString("name");
                xType_id = rs.getInt("type_id");
                xOrder = rs.getInt("order");
                xVideo_link = rs.getString("video_link");
                xHtml_content = rs.getString("html_content");
                xLesson_type_name = rs.getString("lesson_type_name");
                xLesson_topic_name = rs.getString("lesson_topic_name");
                xStatus = rs.getBoolean("status");
                x = new Lesson(xID, xSubject_id, xTopic_id, xName, xType_id, xOrder, xVideo_link, xHtml_content, xLesson_type_name, xLesson_topic_name, xStatus);
                t.add(x);
            }
            rs.close();
            ps.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return (t);
    }
    public List<Lesson_Type> getLessonType() {
        List<Lesson_Type> t = new ArrayList<>();
        xSql = "select * from lesson_type";
        try {
            ps = con.prepareStatement(xSql);
            rs = ps.executeQuery();
            int xID;
            String xName;
            Lesson_Type x;
            while (rs.next()) {
                xID = rs.getInt("id");

                xName = rs.getString("name");
               
                x = new Lesson_Type(xID, xName);
                t.add(x);
            }
            rs.close();
            ps.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return (t);
    }
    public List<Lesson_Topic> getLessonTopic() {
        List<Lesson_Topic> t = new ArrayList<>();
        xSql = "select * from lesson_topic";
        try {
            ps = con.prepareStatement(xSql);
            rs = ps.executeQuery();
            int xID;
            String xName;
            Lesson_Topic x;
            while (rs.next()) {
                xID = rs.getInt("id");

                xName = rs.getString("name");
               
                x = new Lesson_Topic(xID, xName);
                t.add(x);
            }
            rs.close();
            ps.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return (t);
    }
    
    
}
