/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dal;

import java.sql.PreparedStatement;
import java.util.List;

/**
 *
 * @author LENOVO
 */
public class User_ExamDAO extends MyDAO{
    public void addNewUser_Exam(int UserId, List<Integer> exam_ids) {
    xSql = "INSERT INTO [dbo].[exam_user] ([user_id], [exam_id]) VALUES (?, ?)";
    try {
        ps = con.prepareStatement(xSql);
        for (int examId : exam_ids) {
            ps.setInt(1, UserId);
            ps.setInt(2, examId);
            ps.executeUpdate();
        }
        ps.close();
    } catch (Exception e) {
        System.out.println("insert: " + e.getMessage());
    }
}
}
