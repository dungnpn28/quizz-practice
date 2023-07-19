/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dal;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import model.Attempt;
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

    public Question getQuestionDetailById(int questionId) {
        Question q = null;
        try {
            String strSelect = "select id,subject_id,lesson_id,content,option_a,option_b,option_c,option_d,answer,answer_explaination,level,status,created,modified from question where id =?";
            ps = con.prepareStatement(strSelect);
            ps.setInt(1, questionId);
            rs = ps.executeQuery();
            while (rs.next()) {
                int id = rs.getInt(1);
                int subjectId = rs.getInt(2);
                int lessonId = rs.getInt(3);

                String content = rs.getString(4);
                String optionA = rs.getString(5);
                String optionB = rs.getString(6);
                String optionC = rs.getString(7);
                String optionD = rs.getString(8);
                String answer = rs.getString(9);
                String answer_explaination = rs.getString(10);
                String level = rs.getString(11);
                boolean status = rs.getBoolean(12);
                String created = rs.getString(13);
                String modified = rs.getString(14);

                q = new Question(id, subjectId, lessonId, content, optionA, optionB, optionC, optionD, answer, answer_explaination, level, status, created, modified);
            }
        } catch (Exception e) {
            System.out.println("getQuestionDetailById:" + e.getMessage());
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

    public ArrayList<Question> getAllQuestion(int page, int PAGE_SIZE, String subject, String lesson, String level, String search) {
        ArrayList<Question> questionList = new ArrayList<>();
//        String Sql = "select id, subject_id, lesson_id, content, \n"
//                + "                option_a, option_b, option_c,option_d,\n"
//                + "                answer, answer_explaination, level from question\n"
//                + "				order by id ASC\n"
//                + "                offset (?-1)*? row fetch next ? rows only";
        String Sql = "select id, subject_id, lesson_id, content, level,status from question WHERE 1=1";

        if (!subject.equals("all")) {
            Sql += " and [subject_id]= ?";
        }
        if (!lesson.equals("all")) {
            Sql += " and [lesson_id]= ?";
        }
        if (!level.equals("all")) {
            Sql += " and [level] like ?";

        }
        Sql += " and (content like ?) ";
        Sql += " ORDER BY [id] offset (?-1)*? row fetch next ? rows only";
        try {

            ps = con.prepareStatement(Sql);
            int i = 1;
            if (!subject.equals("all")) {
                ps.setInt(i, Integer.parseInt(subject));
                i++;
            }
            if (!lesson.equals("all")) {
                ps.setInt(i, Integer.parseInt(lesson));
                i++;
            }
            if (!level.equals("all")) {
                ps.setString(i, "%" + level + "%");
                i++;
            }
            ps.setString(i, "%" + search + "%");
            i++;
            ps.setInt(i, page);
            i++;
            ps.setInt(i, PAGE_SIZE);
            i++;
            ps.setInt(i, PAGE_SIZE);

            rs = ps.executeQuery();
            while (rs.next()) {
                int id = rs.getInt(1);
                int subject_id = rs.getInt(2);
                int lesson_id = rs.getInt(3);
                String content = rs.getString(4);
                String Level = rs.getString(5);
                Boolean status = rs.getBoolean(6);
                questionList.add(new Question(id, subject_id, lesson_id, content, Level, status));
            }

        } catch (Exception e) {
            System.out.println("getAllListQuestion: " + e.getMessage());
        }
        return questionList;
    }

    public int getTotalQuestion(String subject, String lesson, String level, String search) {
        xSql = "select count(id) from question WHERE 1=1";

        if (!subject.equals("all")) {
            xSql += " and [subject_id]= ?";
        }
        if (!lesson.equals("all")) {
            xSql += " and [lesson_id]= ?";
        }
        if (!level.equals("all")) {
            xSql += " and [level] like ?";

        }
        xSql += " and (content like ?) ";

        int totalQuestion = 0;
        try {
            ps = con.prepareStatement(xSql);
            int i = 1;
            if (!subject.equals("all")) {
                ps.setInt(i, Integer.parseInt(subject));
                i++;
            }
            if (!lesson.equals("all")) {
                ps.setInt(i, Integer.parseInt(lesson));
                i++;
            }
            if (!level.equals("all")) {
                ps.setString(i, "%" + level + "%");
                i++;
            }
            ps.setString(i, "%" + search + "%");
            rs = ps.executeQuery();
            while (rs.next()) {
                return rs.getInt(1);
            }
            rs.close();
            ps.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return (totalQuestion);
    }

    public List<Question> DelOneQuestion(int id) {
        String Sql = "delete from question where id = ?";
        List<Question> QuestionList = new ArrayList<Question>();
        try {
            PreparedStatement ps = con.prepareStatement(Sql);
            ps.setInt(1, id);
            ps.executeUpdate();
            QuestionList = getAllQuestion(id, id, Sql, Sql, Sql, Sql);
        } catch (Exception e) {
        }
        return QuestionList;
    }

    public Question getOneQuestion(int id) {
        String Sql = "select * from question where id = ?";
        Question q = new Question();
        try {
            PreparedStatement ps = con.prepareStatement(Sql);
            ps.setInt(1, id);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                int subjectId = rs.getInt("subjectId");
                int lessonId = rs.getInt("lessonId");
                String content = rs.getString("content");
                String level = rs.getString("level");
                q = new Question(id, subjectId, lessonId, content, level);
            }
        } catch (Exception e) {
        }
        return q;
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

    public void addQuestion(Question q) {
        try {
            String strAdd = "INSERT INTO[question]\n"
                    + "           ([subject_id]\n"
                    + "           ,[lesson_id]\n"
                    + "           ,[content]\n"
                    + "           ,[option_a]\n"
                    + "           ,[option_b]\n"
                    + "           ,[option_c]\n"
                    + "           ,[option_d]\n"
                    + "           ,[answer]\n"
                    + "           ,[answer_explaination]\n"
                    + "           ,[level]\n"
                    + "           ,[status]\n"
                    + "           ,[created])\n"
                    + "     VALUES\n"
                    + "           (?,?,?,?,?,?,?,?,?,?,?, GETDATE())";
            ps = con.prepareStatement(strAdd);
            ps.setInt(1, q.getSubjectId());
            ps.setInt(2, q.getLessonId());
            ps.setString(3, q.getContent());
            ps.setString(4, (String) q.getOptionA());
            ps.setString(5, (String) q.getOptionB());
            ps.setString(6, (String) q.getOptionC());
            ps.setString(7, (String) q.getOptionD());
            ps.setString(8, (String) q.getAnswer());
            ps.setString(9, (String) q.getAnswer_explaination());
            ps.setString(10, (String) q.getLevel());
            if (q.isStatus()) {
                ps.setInt(11, 1);
            } else {
                ps.setInt(11, 0);
            }
            ps.execute();

        } catch (Exception e) {
            System.out.println("addQuestion: " + e.getMessage());
        }
    }

    public List<Integer> getQuestionIdBySubjectId(int subjectId) {
        String Sql = "select id from question where subject_id = ?";
        List<Integer> t = new ArrayList<>();
        int xId;
        try {
            PreparedStatement ps = con.prepareStatement(Sql);
            ps.setInt(1, subjectId);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                xId = rs.getInt("id");
                t.add(xId);
            }
        } catch (Exception e) {
        }
        return t;
    }

    public List<Integer> getQuestionIdBySubjectIdAndQuestionType(int subjectId, int type_id) {
        String Sql = "select question.id from question\n"
                + "inner join question_dimension on question.id = question_dimension.question_id\n"
                + "inner join dimension on dimension.id = question_dimension.dimension_id\n"
                + "where question.subject_id = ? and type_id = ?";
        List<Integer> t = new ArrayList<>();
        int xId;
        try {
            PreparedStatement ps = con.prepareStatement(Sql);
            ps.setInt(1, subjectId);
            ps.setInt(2, type_id);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                xId = rs.getInt("id");
                t.add(xId);
            }
        } catch (Exception e) {
            System.out.println("getQuestionIdBySubjectIdAndQuestionType" + e.getMessage());
        }
        return t;
    }

    public void updateQuestion(int subjectId, String level, String content, String explaination, String optionA, String optionB, String optionC, String optionD, String answer, int id, boolean status) {
        try {
            String strAdd;
            if (explaination.isEmpty() || explaination.equals("")) {
                strAdd = "update question set subject_id=?,level=?,content=?,answer_explaination= null,option_a=?,option_b=?,option_c=?,option_d=?,answer=?,modified=GETDATE(),status=? where id=?";
                ps = con.prepareStatement(strAdd);

                ps.setInt(1, subjectId);
                ps.setString(2, level);
                ps.setString(3, content);

                ps.setString(4, optionA);
                ps.setString(5, optionB);
                ps.setString(6, optionC);
                ps.setString(7, optionD);
                ps.setString(8, answer);
                ps.setBoolean(9, status);
                ps.setInt(10, id);
                ps.executeUpdate();
            } else {
                strAdd = "update question set subject_id=?,level=?,content=?,answer_explaination=?,option_a=?,option_b=?,option_c=?,option_d=?,answer=?,modified=GETDATE(),status=? where id=?";
                ps = con.prepareStatement(strAdd);

                ps.setInt(1, subjectId);
                ps.setString(2, level);
                ps.setString(3, content);
                ps.setString(4, explaination);
                ps.setString(5, optionA);
                ps.setString(6, optionB);
                ps.setString(7, optionC);
                ps.setString(8, optionD);
                ps.setString(9, answer);
                ps.setBoolean(10, status);
                ps.setInt(11, id);
                ps.executeUpdate();
            }

        } catch (Exception e) {
            System.out.println("updateQuestion: " + e.getMessage());
        }
    }
}
