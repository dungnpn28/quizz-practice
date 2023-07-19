/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dal;

import java.util.List;

/**
 *
 * @author Acer
 */
public class QuestionExamDAO extends MyDAO {

    public int getQuestionIdByExamId(int examId, int page) {
        try {
            String strSlect = "select * from question_exam "
                    + "where exam_id=? AND question_order=?";
            ps = con.prepareCall(strSlect);
            ps.setInt(1, examId);
            ps.setInt(2, page);
            rs = ps.executeQuery();
            while (rs.next()) {
                return rs.getInt(2);
            }
        } catch (Exception e) {
            System.out.println("getQuestionIdByExamId: " + e.getMessage());
        }
        return 0;
    }

    public int countExamQuestion(int examId) {
        try {
            String strCount = "SELECT COUNT(*) AS question_count\n"
                    + "FROM question_exam\n"
                    + "WHERE exam_id = ?";
            ps = con.prepareCall(strCount);
            ps.setInt(1, examId);
            rs = ps.executeQuery();
            while (rs.next()) {
                return rs.getInt(1);
            }
        } catch (Exception e) {
            System.out.println("countExamQuestion: " + e.getMessage());
        }
        return 0;
    }

    public void insertQuestionExam(int exam_id, List<Integer> randomQusetionId, List<Integer> randomOrderList,double mark) {
        xSql = "INSERT INTO [dbo].[question_exam]\n"
                + "           ([exam_id],[question_id],[question_order],[marks_allocated])\n"
                + "     VALUES\n"
                + "           (?,?,?,?)";
        try {
            ps = con.prepareStatement(xSql);
            for (int i = 0; i < randomOrderList.size(); i++) {
                ps.setInt(1, exam_id);
                ps.setInt(2, randomQusetionId.get(i));
                ps.setInt(3, randomOrderList.get(i));
                ps.setDouble(4, mark);
                ps.executeUpdate();
            }
            ps.close();
        } catch (Exception e) {
            System.out.println("insert question exam: " + e.getMessage());
        }
    }

}
