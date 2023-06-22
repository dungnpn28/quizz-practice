/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dal;

import java.util.ArrayList;
import model.Question;

/**
 *
 * @author Acer
 */
public class QuestionDAO extends MyDAO {

    public ArrayList<Question> getListQuestionByExamId(int examId, int page) {
        ArrayList<Question> questionList = new ArrayList<>();
        try {
            String strSelect = "SELECT q.id, q.subject_id, q.content, q.option_a, q.option_b, q.option_c, q.option_d, q.answer, qe.question_order, qe.marks_allocated, q.answer_explaination, q.created, q.modified\n"
                    + "FROM question q\n"
                    + "JOIN question_exam qe ON q.id = qe.question_id\n"
                    + "WHERE qe.exam_id = ?\n"
                    + "ORDER BY qe.question_order \n"
                    + "OFFSET ? ROWS FETCH NEXT 1 ROWS ONLY;";
            ps = con.prepareCall(strSelect);
            ps.setInt(1, examId);
            ps.setInt(2, page - 1);
            rs = ps.executeQuery();
            while (rs.next()) {
                int questionId = rs.getInt(1);
                int subjectId = rs.getInt(2);
                String content = rs.getString(3);
                String optionA = rs.getString(4);
                String optionB = rs.getString(5);
                String optionC = rs.getString(6);
                String optionD = rs.getString(7);
                String answer = rs.getString(8);
                int questionOrder = rs.getInt(9);
                double marksAllocated = rs.getDouble(10);
                String explaination = rs.getString(11);
                questionList.add(new Question(questionId, subjectId, content, optionA, optionB, optionC, optionD, answer, questionOrder, marksAllocated, explaination));
            }
        } catch (Exception e) {
            System.out.println("getListQuestionByExamId: " + e.getMessage());
        }
        return questionList;
    }

    public ArrayList<Question> getListQuestionByExamIdNonPaging(int examId) {
        ArrayList<Question> questionList = new ArrayList<>();
        try {
            String strSelect = "SELECT q.id, q.subject_id, q.content, q.option_a, q.option_b, q.option_c, q.option_d, q.answer, qe.question_order, qe.marks_allocated, q.answer_explaination, q.created, q.modified\n"
                    + "FROM question q\n"
                    + "JOIN question_exam qe ON q.id = qe.question_id\n"
                    + "WHERE qe.exam_id = ?\n"
                    + "ORDER BY qe.question_order;";
            ps = con.prepareCall(strSelect);
            ps.setInt(1, examId);
            rs = ps.executeQuery();
            while (rs.next()) {
                int questionId = rs.getInt(1);
                int subjectId = rs.getInt(2);
                String content = rs.getString(3);
                String optionA = rs.getString(4);
                String optionB = rs.getString(5);
                String optionC = rs.getString(6);
                String optionD = rs.getString(7);
                String answer = rs.getString(8);
                int questionOrder = rs.getInt(9);
                double marksAllocated = rs.getDouble(10);
                String explaination = rs.getString(11);
                questionList.add(new Question(questionId, subjectId, content, optionA, optionB, optionC, optionD, answer, questionOrder, marksAllocated, explaination));
            }
        } catch (Exception e) {
            System.out.println("getListQuestionByExamIdNonPaging: " + e.getMessage());
        }
        return questionList;
    }

    public Question getQuestionById(int questionId) {
        Question q = null;
        try {
            String strSelect = "SELECT q.id, q.subject_id, q.content, q.option_a, q.option_b, q.option_c, q.option_d, q.answer, qe.question_order, qe.marks_allocated, q.answer_explaination, q.created, q.modified\n"
                    + "FROM question q\n"
                    + "JOIN question_exam qe ON q.id = qe.question_id\n"
                    + "WHERE q.id = ?\n"
                    + "ORDER BY qe.question_order \n";
            ps = con.prepareStatement(strSelect);
            ps.setInt(1, questionId);
            rs = ps.executeQuery();
            while (rs.next()) {
                int subjectId = rs.getInt(2);
                String content = rs.getString(3);
                String optionA = rs.getString(4);
                String optionB = rs.getString(5);
                String optionC = rs.getString(6);
                String optionD = rs.getString(7);
                String answer = rs.getString(8);
                int questionOrder = rs.getInt(9);
                double marksAllocated = rs.getDouble(10);
                String explaination = rs.getString(11);
                q = new Question(questionId, subjectId, content, optionA, optionB, optionC, optionD, answer, questionOrder, marksAllocated, explaination);
            }
        } catch (Exception e) {
            System.out.println("getQuestionById:" + e.getMessage());
        }
        return q;
    }

    public ArrayList<Question> getAllListQuestionByExamId(int examId) {
        ArrayList<Question> questionList = new ArrayList<>();
        try {
            String strSelect = "SELECT q.id, q.subject_id, q.content, q.option_a, q.option_b, q.option_c, q.option_d, q.answer, qe.question_order, qe.marks_allocated, q.answer_explaination, q.created, q.modified\n"
                    + "FROM question q\n"
                    + "JOIN question_exam qe ON q.id = qe.question_id\n"
                    + "WHERE qe.exam_id = ?\n"
                    + "ORDER BY qe.question_order;\n";
            ps = con.prepareCall(strSelect);
            ps.setInt(1, examId);
            rs = ps.executeQuery();
            while (rs.next()) {
                int questionId = rs.getInt(1);
                int subjectId = rs.getInt(2);
                String content = rs.getString(3);
                String optionA = rs.getString(4);
                String optionB = rs.getString(5);
                String optionC = rs.getString(6);
                String optionD = rs.getString(7);
                String answer = rs.getString(8);
                int questionOrder = rs.getInt(9);
                double marksAllocated = rs.getDouble(10);
                String explaination = rs.getString(11);
                questionList.add(new Question(questionId, subjectId, content, optionA, optionB, optionC, optionD, answer, questionOrder, marksAllocated, explaination));
            }
        } catch (Exception e) {
            System.out.println("getAllListQuestionByExamId: " + e.getMessage());
        }
        return questionList;
    }

    public ArrayList<Question> getQuestionListByExamAttempt(int examId, int attemptId, int userId) {
        ArrayList<Question> questionList = new ArrayList<>();
        try {
            String strSelect = "SELECT q.id, q.subject_id, q.content, q.option_a, q.option_b, q.option_c, q.option_d, q.answer, q.answer_explaination,\n"
                    + "       a.marked, a.user_answer, a.score,\n"
                    + "       qe.exam_id, qe.question_order, qe.marks_allocated\n"
                    + "FROM question q\n"
                    + "LEFT JOIN attempt a ON q.id = a.question_id\n"
                    + "LEFT JOIN question_exam qe ON a.exam_id = qe.exam_id AND q.id = qe.question_id\n"
                    + "WHERE a.user_id = ? AND a.exam_id = ? AND a.attempt_id =?";
            ps = con.prepareCall(strSelect);
            ps.setInt(1, userId);
            ps.setInt(2, examId);
            ps.setInt(3, attemptId);
            rs = ps.executeQuery();
            while (rs.next()) {
                int questionId = rs.getInt(1);
                int subjectId = rs.getInt(2);
                String content = rs.getString(3);
                String optionA = rs.getString(4);
                String optionB = rs.getString(5);
                String optionC = rs.getString(6);
                String optionD = rs.getString(7);
                String answer = rs.getString(8);
                String explaination = rs.getString(9);
                boolean marked = true;
                if (rs.getInt(10) == 0) {
                    marked = false;
                }
                String userAnswer = rs.getString(11);
                double score = rs.getDouble(12);
                int questionOrder = rs.getInt(14);
                double marksAllocated = rs.getDouble(15);
                questionList.add(new Question(questionId, subjectId, content, optionA, optionB, optionC, optionD, answer, questionOrder, marksAllocated, explaination, marked, userAnswer, score));
            }
        } catch (Exception e) {
            System.out.println("getAllListQuestionByExamId: " + e.getMessage());
        }
        return questionList;
    }

}
