/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

/**
 *
 * @author dai
 */
public class Question_Exam {
    private int exam_id;
    private int question_id;
    private int question_order;
    double marks_allocated;

    public Question_Exam() {
    }

    public Question_Exam(int exam_id, int question_id, int question_order, double marks_allocated) {
        this.exam_id = exam_id;
        this.question_id = question_id;
        this.question_order = question_order;
        this.marks_allocated = marks_allocated;
    }

    public int getExam_id() {
        return exam_id;
    }

    public void setExam_id(int exam_id) {
        this.exam_id = exam_id;
    }

    public int getQuestion_id() {
        return question_id;
    }

    public void setQuestion_id(int question_id) {
        this.question_id = question_id;
    }

    public int getQuestion_order() {
        return question_order;
    }

    public void setQuestion_order(int question_order) {
        this.question_order = question_order;
    }

    public double getMarks_allocated() {
        return marks_allocated;
    }

    public void setMarks_allocated(double marks_allocated) {
        this.marks_allocated = marks_allocated;
    }
    
}
