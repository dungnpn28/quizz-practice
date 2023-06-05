/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dal;

import java.util.ArrayList;
import model.Question;
import model.QuestionExam;

/**
 *
 * @author Acer
 */
public class QuestionDAO extends MyDAO {

    public ArrayList<Question> getListQuestionByExamId(int examId, int page) {
        ArrayList<Question> questionList = new ArrayList<>();
        try {
            String strSelect = "SELECT q.id, q.subject_id, q.content, q.option_a, q.option_b, q.option_c, q.option_d, q.answer, q.created, q.modified\n"
                    + "FROM question q\n"
                    + "JOIN question_exam qe ON q.id = qe.question_id\n"
                    + "WHERE qe.exam_id = ?\n"
                    + "ORDER BY qe.question_order \n"
                    + "OFFSET ? ROWS FETCH NEXT 1 ROWS ONLY;";
            ps = con.prepareCall(strSelect);
            ps.setInt(1, examId);
            ps.setInt(2, page-1);
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
                questionList.add(new Question(questionId, subjectId, content, optionA, optionB, optionC, optionD, answer));
            }
        } catch (Exception e) {
            System.out.println("getListQuestionByExamId: " + e.getMessage());
        }
        return questionList;
    }
}
