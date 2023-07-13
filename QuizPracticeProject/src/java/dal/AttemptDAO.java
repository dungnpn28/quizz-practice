/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dal;

import java.util.ArrayList;
import model.Attempt;
import model.Question;

/**
 *
 * @author Acer
 */
public class AttemptDAO extends MyDAO {

    public void createAttempt(int attemptId, int examId, int questionId, int userId) {
        try {
            String strAdd = "insert into [attempt]"
                    + "(attempt_id, exam_id, question_id, user_id, marked, created) "
                    + "values(?,"
                    + " ?,"
                    + " ?,"
                    + " ?,"
                    + " 0,"
                    + "GETDATE());";
            ps = con.prepareStatement(strAdd);
            ps.setInt(1, attemptId);
            ps.setInt(2, examId);
            ps.setInt(3, questionId);
            ps.setInt(4, userId);
            ps.execute();

        } catch (Exception e) {
            System.out.println("createAttempt: " + e.getMessage());
        }
    }

    public void saveAnswer(String answer, int attemptId, int examId, int questionId, int userId) {
        try {
            String strAdd = "update [attempt] "
                    + "set user_answer = ? "
                    + "where attempt_id = ? AND "
                    + "exam_id = ? AND "
                    + "question_id = ? AND "
                    + "user_id = ? ;";
            ps = con.prepareStatement(strAdd);
            ps.setString(1, answer);
            ps.setInt(2, attemptId);
            ps.setInt(3, examId);
            ps.setInt(4, questionId);
            ps.setInt(5, userId);
            ps.execute();

        } catch (Exception e) {
            System.out.println("saveAnswer: " + e.getMessage());
        }
    }

    public Attempt getAttempt(int attemptId, int examId, int questionId, int userId) {
        Attempt a = null;
        try {
            String strSelect = "select * from [attempt] "
                    + "where attempt_id=? AND "
                    + "exam_id=? AND "
                    + "question_id=? AND "
                    + "user_id =? ;";
            ps = con.prepareStatement(strSelect);
            ps.setInt(1, attemptId);
            ps.setInt(2, examId);
            ps.setInt(3, questionId);
            ps.setInt(4, userId);
            rs = ps.executeQuery();
            while (rs.next()) {
                boolean marked = true;
                if (rs.getInt(5) == 0) {
                    marked = false;
                }
                String userAnswer = rs.getString(6);
                double score = rs.getDouble(7);
                a = new Attempt(attemptId, userId, questionId, examId, marked, userAnswer, score);
            }
        } catch (Exception e) {
            System.out.println("getAttempt:" + e.getMessage());
        }
        return a;
    }

    public int getTotalAnsweredQuestion(int attemptId, int examId, int userId) {
        try {
            String strSlect = "SELECT COUNT(question_id) AS question_count\n"
                    + "FROM Quiz_Practice.dbo.attempt\n"
                    + "WHERE user_answer IS NOT NULL AND "
                    + "attempt_id = ? AND "
                    + "exam_id = ? AND "
                    + "user_id = ? ;";
            ps = con.prepareCall(strSlect);
            ps.setInt(1, attemptId);
            ps.setInt(2, examId);
            ps.setInt(3, userId);
            rs = ps.executeQuery();
            while (rs.next()) {
                return rs.getInt(1);
            }
        } catch (Exception e) {
            System.out.println("getTotalAnsweredQuestion: " + e.getMessage());
        }
        return 0;
    }

    public void markUnmarkQuestion(boolean marked, int attemptId, int examId, int questionId, int userId) {
        try {
            String strAdd = "update [attempt] "
                    + "set marked = ? "
                    + "where attempt_id = ? AND "
                    + "exam_id = ? AND "
                    + "question_id = ? AND "
                    + "user_id = ? ;";
            ps = con.prepareStatement(strAdd);
            if (marked) {
                ps.setInt(1, 1);
            } else {
                ps.setInt(1, 0);
            }
            ps.setInt(2, attemptId);
            ps.setInt(3, examId);
            ps.setInt(4, questionId);
            ps.setInt(5, userId);
            ps.execute();

        } catch (Exception e) {
            System.out.println("markUnmarkQuestion: " + e.getMessage());
        }
    }

    public void scoreQuestion(double score, int attemptId, int examId, int questionId, int userId) {
        try {
            String strAdd = "update [attempt] "
                    + "set score = ? "
                    + "where attempt_id = ? AND "
                    + "exam_id = ? AND "
                    + "question_id = ? AND "
                    + "user_id = ? ;";
            ps = con.prepareStatement(strAdd);
            ps.setDouble(1, score);
            ps.setInt(2, attemptId);
            ps.setInt(3, examId);
            ps.setInt(4, questionId);
            ps.setInt(5, userId);
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

    public double getExamScore(int attemptId, int examId, int userId) {
        try {
            String strSl = "SELECT SUM(score) AS total_score\n"
                    + "FROM [attempt]\n"
                    + "WHERE attempt_id = ? AND exam_id = ? AND user_id = ?";
            ps = con.prepareStatement(strSl);
            ps.setInt(1, attemptId);
            ps.setInt(2, examId);
            ps.setInt(3, userId);
            rs = ps.executeQuery();
            while (rs.next()) {
                return rs.getDouble(1);
            }
        } catch (Exception e) {
            System.out.println("getExamScore: " + e.getMessage());
        }
        return 0;
    }

    public ArrayList<Attempt> getAttemptList(int attemptId, int examId, int questionId, int userId) {
        ArrayList<Attempt> attList = new ArrayList<>();
        try {
            String strSelect = "select * from [attempt] "
                    + "where attempt_id = ? AND "
                    + "exam_id=? AND "
                    + "question_id=? AND "
                    + "user_id =? AND user_answer IS NOT NULL";
            ps = con.prepareCall(strSelect);
            ps.setInt(1, attemptId);
            ps.setInt(2, examId);
            ps.setInt(3, questionId);
            ps.setInt(4, userId);
            rs = ps.executeQuery();
            while (rs.next()) {
                boolean marked = true;
                if (rs.getInt(5) == 0) {
                    marked = false;
                }
                String userAnswer = rs.getString(6);
                double score = rs.getDouble(7);
                attList.add(new Attempt(attemptId, userId, questionId, examId, marked, userAnswer, score));
            }
        } catch (Exception e) {
            System.out.println("getAttemptList: " + e.getMessage());
        }
        return attList;
    }

    public int countExamAttempt(int examId, int userId) {
        try {
            String strSlect = "SELECT COUNT(DISTINCT attempt_id) AS unique_attempt_count\n"
                    + "FROM [attempt] "
                    + "where exam_id = ? AND "
                    + "user_id = ? ;";
            ps = con.prepareCall(strSlect);
            ps.setInt(1, examId);
            ps.setInt(2, userId);
            rs = ps.executeQuery();
            while (rs.next()) {
                return rs.getInt(1);
            }
        } catch (Exception e) {
            System.out.println("countExamAttempt: " + e.getMessage());
        }
        return 0;
    }

    public int countMadeAttempt(int attemptId, int examId, int userId) {
        try {
            String strSlect = "SELECT COUNT(attempt_id) AS attempt_count\n"
                    + "FROM [attempt]\n"
                    + "WHERE attempt_id = ? AND exam_id = ? AND user_id = ?";
            ps = con.prepareCall(strSlect);
            ps.setInt(1, attemptId);
            ps.setInt(2, examId);
            ps.setInt(3, userId);
            rs = ps.executeQuery();
            while (rs.next()) {
                return rs.getInt(1);
            }
        } catch (Exception e) {
            System.out.println("countMadeAttempt: " + e.getMessage());
        }
        return 0;
    }

    public boolean checkAttemptExist(int attemptId, int examId, int userId) {
        Attempt a = null;
        try {
            String strSelect = "select * from [attempt] "
                    + "where attempt_id=? AND "
                    + "exam_id=? AND "
                    + "user_id =?;";
            ps = con.prepareStatement(strSelect);
            ps.setInt(1, attemptId);
            ps.setInt(2, examId);
            ps.setInt(3, userId);
            rs = ps.executeQuery();
            while (rs.next()) {
                a = new Attempt(attemptId, userId, examId);
            }
        } catch (Exception e) {
            System.out.println("checkAttemptExist:" + e.getMessage());
        }
        if (a == null) {
            return false;
        }
        return true;
    }

    public void createNullAttempt(int attemptId, int examId, int questionId, int userId) {
        try {
            String strAdd = "insert into [attempt]"
                    + "(attempt_id, exam_id, question_id, user_id, marked, created, user_answer) "
                    + "values(?,"
                    + " ?,"
                    + " ?,"
                    + " ?,"
                    + " 0,"
                    + "GETDATE(),"
                    + "null);";
            ps = con.prepareStatement(strAdd);
            ps.setInt(1, attemptId);
            ps.setInt(2, examId);
            ps.setInt(3, questionId);
            ps.setInt(4, userId);
            ps.execute();

        } catch (Exception e) {
            System.out.println("createNullAttempt: " + e.getMessage());
        }
    }

    public ArrayList<Attempt> getAttemptList(int userId) {
        ArrayList<Attempt> list = new ArrayList<>();
        try {
            String strSel = "SELECT DISTINCT a.attempt_id, a.exam_id, e.name, e.number_of_question, e.duration\n"
                    + "FROM [attempt] a\n"
                    + "JOIN [exam] e ON a.exam_id = e.id\n"
                    + "WHERE user_id = ?;";
            ps = con.prepareStatement(strSel);
            ps.setInt(1, userId);
            rs = ps.executeQuery();
            while (rs.next()) {
                int attemptId = rs.getInt(1);
                int examId = rs.getInt(2);
                String examName = rs.getString(3);
                int numberOfQuestion = rs.getInt(4);
                String duration = (String) rs.getString(5);
                Attempt a = new Attempt(attemptId, userId, examId, examName, numberOfQuestion, duration);
                list.add(a);
            }
        } catch (Exception e) {
            System.out.println("getAttemptList: " + e.getMessage());
        }
        return list;
    }

}
