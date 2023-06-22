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
            //boolean xStatus;
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
           System.out.println("getLesson():"+e.getMessage());
        }
        return (t);
    }
    public List<Lesson> getLessonBySubjectId(int subjectId) {
        List<Lesson> t = new ArrayList<>();
        xSql = " select l.*, lt.name as 'lesson_type_name', lp.name as 'lesson_topic_name'\n"
                + "                 from lesson l\n"
                + "                  join lesson_type lt on l.type_id = lt.id\n"
                + "                  join lesson_topic lp on l.topic_id = lp.id\n"
                + "				  where l.subject_id = ?";
        try {
            ps = con.prepareStatement(xSql);
            ps.setInt(1, subjectId);
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
            System.out.println("abcasknclas" + e.getMessage());
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

    public void insert(int subjectId, int topicId, String name, int type_id, int order, String video_link, String htmlContent, boolean Status) {
        xSql = "INSERT INTO [dbo].[lesson]\n"
                + "           ([subject_id]\n"
                + "           ,[topic_id]\n"
                + "           ,[name]\n"
                + "           ,[type_id]\n"
                + "           ,[order]\n"
                + "           ,[video_link]\n"
                + "           ,[html_content]\n"
                + "           ,[status])\n"
                + "     VALUES\n"
                + "           (?\n"
                + "           ,?\n"
                + "           ,?\n"
                + "           ,?\n"
                + "           ,?\n"
                + "           ,?\n"
                + "           ,?\n"
                + "           ,?)";
        try {
            ps = con.prepareStatement(xSql);

            ps.setInt(1, subjectId);
            ps.setInt(2, topicId);
            ps.setString(3, name);
            ps.setInt(4, type_id);
            ps.setInt(5, order);
            ps.setString(6, video_link);
            ps.setString(7, htmlContent);
            ps.setBoolean(8, Status);
            ps.executeUpdate();
            ps.close();
        } catch (Exception e) {
            System.out.println("insert:" + e.getMessage());
        }
    }

    public void insertType(Lesson_Type x) {
        xSql = "insert into [dbo].[lesson] (id,[name]) values(?,?)";
        try {
            ps = con.prepareStatement(xSql);
            ps.setInt(1, x.getId());
            ps.setString(2, x.getName());
            ps.executeUpdate();
            ps.close();
        } catch (Exception e) {
            System.out.println("insert:" + e.getMessage());
        }
    }

    public void insertTopic(Lesson_Topic x) {
        xSql = "insert into [dbo].[lesson] (id,[name]) values(?,?)";
        try {
            ps = con.prepareStatement(xSql);
            ps.setInt(1, x.getId());
            ps.setString(2, x.getName());
            ps.executeUpdate();
            ps.close();
        } catch (Exception e) {
            System.out.println("insert:" + e.getMessage());
        }
    }

    public void update(int subjectId, int topicId, String name, int type_id, int order, String video_link, String htmlContent, boolean Status, int lessonId) {
        xSql = "UPDATE [dbo].[lesson]\n"
                + "   SET [subject_id] = ?\n"
                + "      ,[topic_id] = ?\n"
                + "      ,[name] = ?\n"
                + "      ,[type_id] = ?\n"
                + "      ,[order] = ?\n"
                + "      ,[video_link] = ?\n"
                + "      ,[html_content] = ?\n"
                + "      ,[status] = ?\n"
                + " WHERE [id] = ?";
        try {
            ps = con.prepareStatement(xSql);
            ps.setInt(1, subjectId);
            ps.setInt(2, topicId);
            ps.setString(3, name);
            ps.setInt(4, type_id);
            ps.setInt(5, order);
            ps.setString(6, video_link);
            ps.setString(7, htmlContent);
            ps.setBoolean(8, Status);
            ps.setInt(9, lessonId);
            ps.executeUpdate();
            ps.close();
        } catch (Exception e) {
            System.out.println("update: " + e.getMessage());
        }
    }

    public void updateType(Lesson_Type x) {
        xSql = "UPDATE [dbo].[lesson_type]\n"
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

    public void updateTopic(Lesson_Topic x) {
        xSql = "UPDATE [dbo].[lesson_topic]\n"
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

    public Lesson getLessonById(String lessonId) {
        xSql = "select * from lesson where id = ?";
        int xID;
        int xSubject_id;
        int xTopic_id;
        String xName;
        int xType_id;
        int xOrder;
        String xVideo_link;
        String xHtml_content;

        boolean xStatus;
        Lesson x = null;
        try {
            ps = con.prepareStatement(xSql);
            ps.setString(1, lessonId);
            rs = ps.executeQuery();
            if (rs.next()) {
                xID = rs.getInt("id");
                xSubject_id = rs.getInt("subject_id");
                xTopic_id = rs.getInt("topic_id");
                xName = rs.getString("name");
                xType_id = rs.getInt("type_id");
                xOrder = rs.getInt("order");
                xVideo_link = rs.getString("video_link");
                xHtml_content = rs.getString("html_content");
                xStatus = rs.getBoolean("status");
                x = new Lesson(xID, xSubject_id, xTopic_id, xName, xType_id, xOrder, xVideo_link, xHtml_content, xStatus);
            }
            rs.close();
            ps.close();
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return (x);
    }
    
    public void insertQuizlesson(int subjectId, int topicId, String name, int type_id, int order, String video_link, String htmlContent, boolean Status,int exam_id) {
        xSql = "INSERT INTO [dbo].[lesson]\n"
                + "           ([subject_id]\n"
                + "           ,[topic_id]\n"
                + "           ,[name]\n"
                + "           ,[type_id]\n"
                + "           ,[order]\n"
                + "           ,[video_link]\n"
                + "           ,[html_content]\n"
                + "           ,[status]\n"
                + "           ,[exam_id])\n"
                + "     VALUES\n"
                + "           (?\n"
                + "           ,?\n"
                + "           ,?\n"
                + "           ,?\n"
                + "           ,?\n"
                + "           ,?\n"
                + "           ,?\n"
                + "           ,?\n"
                + "           ,?)";
        try {
            ps = con.prepareStatement(xSql);

            ps.setInt(1, subjectId);
            ps.setInt(2, topicId);
            ps.setString(3, name);
            ps.setInt(4, type_id);
            ps.setInt(5, order);
            ps.setString(6, video_link);
            ps.setString(7, htmlContent);
            ps.setBoolean(8, Status);
            ps.setInt(9, exam_id);
            ps.executeUpdate();
            ps.close();
        } catch (Exception e) {
            System.out.println("insert:" + e.getMessage());
        }
    }
    
    public void updateQuizlesson(int subjectId, int topicId, String name, int type_id, int order, String video_link, String htmlContent, boolean Status,int examId, int lessonId) {
        xSql = "UPDATE [dbo].[lesson]\n"
                + "   SET [subject_id] = ?\n"
                + "      ,[topic_id] = ?\n"
                + "      ,[name] = ?\n"
                + "      ,[type_id] = ?\n"
                + "      ,[order] = ?\n"
                + "      ,[video_link] = ?\n"
                + "      ,[html_content] = ?\n"
                + "      ,[status] = ?\n"
                + "      ,[exam_id] = ?\n"
                + " WHERE [id] = ?";
        try {
            ps = con.prepareStatement(xSql);
            ps.setInt(1, subjectId);
            ps.setInt(2, topicId);
            ps.setString(3, name);
            ps.setInt(4, type_id);
            ps.setInt(5, order);
            ps.setString(6, video_link);
            ps.setString(7, htmlContent);
            ps.setBoolean(8, Status);
            ps.setInt(9, examId);
            ps.setInt(10, lessonId);
            ps.executeUpdate();
            ps.close();
        } catch (Exception e) {
            System.out.println("update: " + e.getMessage());
        }
    }
//    public static void main(String[] args) {
//        LessonDAO lDAO = new LessonDAO();
//        lDAO.updateQuizlesson(2, 2, "asdasd", 2, 2, "https://www.youtube.com/", "lewlew", true, 2, 2);
//    }
}
