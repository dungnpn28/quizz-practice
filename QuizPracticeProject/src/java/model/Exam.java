/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

import java.sql.Date;

/**
 *
 * @author LENOVO
 */
public class Exam {

    private int id;
    private String name;
    private int subject_id;
    private int user_id;
    private int level;
    private String duration;
    private double pass_rate;
    private int number_of_question;
    private Date created;
    private String description;
    private String subjectName;

    public Exam() {
    }

    public Exam(int id, String name, int subject_id, int user_id, int level, String duration, double pass_rate, int number_of_question, Date created) {
        this.id = id;
        this.name = name;
        this.subject_id = subject_id;
        this.user_id = user_id;
        this.level = level;
        this.duration = duration;
        this.pass_rate = pass_rate;
        this.number_of_question = number_of_question;
        this.created = created;
    }

    public Exam(int id, String name, int level, String duration, double pass_rate, int number_of_question, String subjectName) {
        this.id = id;
        this.name = name;
        this.level = level;
        this.duration = duration;
        this.pass_rate = pass_rate;
        this.number_of_question = number_of_question;
        this.subjectName = subjectName;
    }

    public Exam(int id, String name, int level, String duration, double pass_rate, int number_of_question, String subjectName, String description) {
        this.id = id;
        this.name = name;
        this.level = level;
        this.duration = duration;
        this.pass_rate = pass_rate;
        this.number_of_question = number_of_question;
        this.subjectName = subjectName;
        this.description = description;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getSubjectName() {
        return subjectName;
    }

    public void setSubjectName(String subjectName) {
        this.subjectName = subjectName;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getUser_id() {
        return user_id;
    }

    public void setUser_id(int user_id) {
        this.user_id = user_id;
    }

    public int getSubject_id() {
        return subject_id;
    }

    public void setSubject_id(int subject_id) {
        this.subject_id = subject_id;
    }

    public int getLevel() {
        return level;
    }

    public void setLevel(int level) {
        this.level = level;
    }

    public String getDuration() {
        return duration;
    }

    public void setDuration(String duration) {
        this.duration = duration;
    }

    public double getPass_rate() {
        return pass_rate;
    }

    public void setPass_rate(double pass_rate) {
        this.pass_rate = pass_rate;
    }

    public int getNumber_of_question() {
        return number_of_question;
    }

    public void setNumber_of_question(int number_of_question) {
        this.number_of_question = number_of_question;
    }

    public Date getCreated() {
        return created;
    }

    public void setCreated(Date created) {
        this.created = created;
    }

}
