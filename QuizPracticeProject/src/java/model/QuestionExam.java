/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

/**
 *
 * @author Acer
 */
public class QuestionExam {
    private int examId;
    private int questionId;
    private int questionOrder;
    private int markAllocated;

    public QuestionExam(int examId, int questionId, int questionOrder, int markAllocated) {
        this.examId = examId;
        this.questionId = questionId;
        this.questionOrder = questionOrder;
        this.markAllocated = markAllocated;
    }

    public int getExamId() {
        return examId;
    }

    public void setExamId(int examId) {
        this.examId = examId;
    }

    public int getQuestionId() {
        return questionId;
    }

    public void setQuestionId(int questionId) {
        this.questionId = questionId;
    }

    public int getQuestionOrder() {
        return questionOrder;
    }

    public void setQuestionOrder(int questionOrder) {
        this.questionOrder = questionOrder;
    }

    public int getMarkAllocated() {
        return markAllocated;
    }

    public void setMarkAllocated(int markAllocated) {
        this.markAllocated = markAllocated;
    }
}
