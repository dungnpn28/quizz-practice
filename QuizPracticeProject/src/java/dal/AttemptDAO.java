/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dal;

import model.Attempt;

/**
 *
 * @author Acer
 */
public class AttemptDAO extends MyDAO {

    public void createAttempt(int examId, int questionId, int userId) {
        try {
            String strAdd = "insert into [attempt]"
                    + "(exam_id, question_id, user_id, marked, created) "
                    + "values(?,"
                    + " ?,"
                    + " ?,"
                    + " 0,"
                    + "GETDATE());";
            ps = con.prepareStatement(strAdd);
            ps.setInt(1, examId);
            ps.setInt(2, questionId);
            ps.setInt(3, userId);
            ps.execute();

        } catch (Exception e) {
            System.out.println("createAttempt: " + e.getMessage());
        }
    }


    public void saveAnswer(String answer, int examId, int questionId, int userId) {
        try {
            String strAdd = "update [attempt] "
                    + "set user_answer = ? "
                    + "where exam_id = ? AND "
                    + "question_id = ? AND "
                    + "user_id = ? ;";
            ps = con.prepareStatement(strAdd);
            ps.setString(1, answer);
            ps.setInt(2, examId);
            ps.setInt(3, questionId);
            ps.setInt(4, userId);
            ps.execute();

        } catch (Exception e) {
            System.out.println("saveAnswer: " + e.getMessage());
        }
    }

    public Attempt getAttempt(int examId, int questionId, int userId) {
        Attempt a = null;
        try {
            String strSelect = "select * from [attempt] "
                    + "where exam_id=? AND "
                    + "question_id=? AND "
                    + "user_id =? ;";
            ps = con.prepareStatement(strSelect);
            ps.setInt(1, examId);
            ps.setInt(2, questionId);
            ps.setInt(3, userId);
            rs = ps.executeQuery();
            while (rs.next()) {
                boolean marked = true;
                if (rs.getInt(4) == 0) {
                    marked = false;
                }
                String userAnswer = rs.getString(5);
                double score = rs.getDouble(6);
                a = new Attempt(userId, questionId, examId, marked, userAnswer, score);
            }
        } catch (Exception e) {
            System.out.println("getAttempt:" + e.getMessage());
        }
        return a;
    }

    public int getTotalAnsweredQuestion(int examId, int userId) {
        try {
            String strSlect = "SELECT COUNT(question_id) AS question_count\n"
                    + "FROM Quiz_Practice.dbo.attempt\n"
                    + "WHERE user_answer IS NOT NULL AND "
                    + "exam_id = ? AND "
                    + "user_id = ? ;";
            ps = con.prepareCall(strSlect);
            ps.setInt(1, examId);
            ps.setInt(2, userId);
            rs = ps.executeQuery();
            while (rs.next()) {
                return rs.getInt(1);
            }
        } catch (Exception e) {
            System.out.println("getTotalAnsweredQuestion: " + e.getMessage());
        }
        return 0;
    }

    public void markUnmarkQuestion(boolean marked, int examId, int questionId, int userId) {
        try {
            String strAdd = "update [attempt] "
                    + "set marked = ? "
                    + "where exam_id = ? AND "
                    + "question_id = ? AND "
                    + "user_id = ? ;";
            ps = con.prepareStatement(strAdd);
            if (marked) {
                ps.setInt(1, 1);
            } else {
                ps.setInt(1, 0);
            }
            ps.setInt(2, examId);
            ps.setInt(3, questionId);
            ps.setInt(4, userId);
            ps.execute();

        } catch (Exception e) {
            System.out.println("markUnmarkQuestion: " + e.getMessage());
        }
    }
    
    public void scoreQuestion(double score, int examId, int questionId, int userId) {
        try {
            String strAdd = "update [attempt] "
                    + "set score = ? "
                    + "where exam_id = ? AND "
                    + "question_id = ? AND "
                    + "user_id = ? ;";
            ps = con.prepareStatement(strAdd);
            ps.setDouble(1, score);
            ps.setInt(2, examId);
            ps.setInt(3, questionId);
            ps.setInt(4, userId);
            ps.execute();

        } catch (Exception e) {
            System.out.println("scoreQuestion: " + e.getMessage());
        }
    }
    
    public void deleteExamAttempt(int examId) {
        try {
            String strDel = "delete from [attempt] where exam_id = ?;";
            ps = con.prepareStatement(strDel);
            ps.setInt(1, examId);
            ps.execute();

        } catch (Exception e) {
            System.out.println("deleteAttempt: " + e.getMessage());
        }
    }
}
