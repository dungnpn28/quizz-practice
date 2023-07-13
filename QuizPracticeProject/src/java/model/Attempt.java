/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

/**
 *
 * @author Acer
 */
public class Attempt {
    private int attemptId;
    private int userId;
    private int questionId;
    private int exam_id;
    private boolean marked;
    private String userAnswer;
    private double score;
    private String examName;
    private int numberOfQuestion;
    private String duration;

    public int getAttemptId() {
        return attemptId;
    }

    public void setAttemptId(int attemptId) {
        this.attemptId = attemptId;
    }

    public String getExamName() {
        return examName;
    }

    public void setExamName(String examName) {
        this.examName = examName;
    }

    public int getNumberOfQuestion() {
        return numberOfQuestion;
    }

    public void setNumberOfQuestion(int numberOfQuestion) {
        this.numberOfQuestion = numberOfQuestion;
    }

    public String getDuration() {
        return duration;
    }

    public void setDuration(String duration) {
        this.duration = duration;
    }
    
    

    public Attempt(int attemptId, int userId, int exam_id) {
        this.attemptId = attemptId;
        this.userId = userId;
        this.exam_id = exam_id;
    }

    public Attempt(int attemptId, int userId, int exam_id, String examName, int numberOfQuestion, String duration) {
        this.attemptId = attemptId;
        this.userId = userId;
        this.exam_id = exam_id;
        this.examName = examName;
        this.numberOfQuestion = numberOfQuestion;
        this.duration = duration;
    }

    public Attempt(int attemptId, int userId, int questionId, int exam_id, boolean marked, String userAnswer, double score) {
        this.attemptId = attemptId;
        this.userId = userId;
        this.questionId = questionId;
        this.exam_id = exam_id;
        this.marked = marked;
        this.userAnswer = userAnswer;
        this.score = score;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public int getQuestionId() {
        return questionId;
    }

    public void setQuestionId(int questionId) {
        this.questionId = questionId;
    }

    public int getExam_id() {
        return exam_id;
    }

    public void setExam_id(int exam_id) {
        this.exam_id = exam_id;
    }

    public boolean isMarked() {
        return marked;
    }

    public void setMarked(boolean marked) {
        this.marked = marked;
    }

    public String getUserAnswer() {
        return userAnswer;
    }

    public void setUserAnswer(String userAnswer) {
        this.userAnswer = userAnswer;
    }

    public double getScore() {
        return score;
    }

    public void setScore(double score) {
        this.score = score;
    }
    
}
