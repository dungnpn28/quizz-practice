/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

/**
 *
 * @author Acer
 */
public class Question {

    private int id;
    private int subjectId;
    private String content;
    private String optionA;
    private String optionB;
    private String optionC;
    private String optionD;
    private String answer;
    private int questionOrder;
    private double marksAllocated;
    private String explaination;
    private boolean marked;
    private String userAnswer;
    private double score;

    public Question(int id, int subjectId, String content, String optionA, String optionB, String optionC, String optionD, String answer, int questionOrder, double marksAllocated, String explaination, boolean marked, String userAnswer, double score) {
        this.id = id;
        this.subjectId = subjectId;
        this.content = content;
        this.optionA = optionA;
        this.optionB = optionB;
        this.optionC = optionC;
        this.optionD = optionD;
        this.answer = answer;
        this.questionOrder = questionOrder;
        this.marksAllocated = marksAllocated;
        this.explaination = explaination;
        this.marked = marked;
        this.userAnswer = userAnswer;
        this.score = score;
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
    

    public String getExplaination() {
        return explaination;
    }

    public void setExplaination(String explaination) {
        this.explaination = explaination;
    }

    public Question(int id, int subjectId, String content, String optionA, String optionB, String optionC, String optionD, String answer, int questionOrder, double marksAllocated, String explaination) {
        this.id = id;
        this.subjectId = subjectId;
        this.content = content;
        this.optionA = optionA;
        this.optionB = optionB;
        this.optionC = optionC;
        this.optionD = optionD;
        this.answer = answer;
        this.questionOrder = questionOrder;
        this.marksAllocated = marksAllocated;
        this.explaination = explaination;
    }

    public int getQuestionOrder() {
        return questionOrder;
    }

    public void setQuestionOrder(int questionOrder) {
        this.questionOrder = questionOrder;
    }

    public double getMarksAllocated() {
        return marksAllocated;
    }

    public void setMarksAllocated(int marksAllocated) {
        this.marksAllocated = marksAllocated;
    }

    public Question(int id, int subjectId, String content, String optionA, String optionB, String optionC, String optionD, String answer, int questionOrder, double marksAllocated) {
        this.id = id;
        this.subjectId = subjectId;
        this.content = content;
        this.optionA = optionA;
        this.optionB = optionB;
        this.optionC = optionC;
        this.optionD = optionD;
        this.answer = answer;
        this.questionOrder = questionOrder;
        this.marksAllocated = marksAllocated;
    }


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getSubjectId() {
        return subjectId;
    }

    public void setSubjectId(int subjectId) {
        this.subjectId = subjectId;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getOptionA() {
        return optionA;
    }

    public void setOptionA(String optionA) {
        this.optionA = optionA;
    }

    public String getOptionB() {
        return optionB;
    }

    public void setOptionB(String optionB) {
        this.optionB = optionB;
    }

    public String getOptionC() {
        return optionC;
    }

    public void setOptionC(String optionC) {
        this.optionC = optionC;
    }

    public String getOptionD() {
        return optionD;
    }

    public void setOptionD(String optionD) {
        this.optionD = optionD;
    }

    public String getAnswer() {
        return answer;
    }

    public void setAnswer(String answer) {
        this.answer = answer;
    }
}
