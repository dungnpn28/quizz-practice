/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

/**
 *
 * @author dai
 */
public class Lesson {
    private int id;
    private int subject_id;
    private int topic_id;
    private String name;
    private int type_id;
    private int order;
    private String video_link;
    private String html_content;
    private String lesson_type_name;
    private String lesson_topic_name;

    private boolean status;

    public Lesson() {
    }

    public Lesson(int id, int subject_id, int topic_id, String name, int type_id, int order, String video_link, String html_content, boolean status) {
        this.id = id;
        this.subject_id = subject_id;
        this.topic_id = topic_id;
        this.name = name;
        this.type_id = type_id;
        this.order = order;
        this.video_link = video_link;
        this.html_content = html_content;
        this.status = status;
    }

    public Lesson(int id, int subject_id, int topic_id, String name, int type_id) {
        this.id = id;
        this.subject_id = subject_id;
        this.topic_id = topic_id;
        this.name = name;
        this.type_id = type_id;
    }

    public Lesson(int id, int subject_id, int topic_id, String name, int type_id, int order, String video_link, String html_content, String lesson_type_name, String lesson_topic_name, boolean status) {
        this.id = id;
        this.subject_id = subject_id;
        this.topic_id = topic_id;
        this.name = name;
        this.type_id = type_id;
        this.order = order;
        this.video_link = video_link;
        this.html_content = html_content;
        this.lesson_type_name = lesson_type_name;
        this.lesson_topic_name = lesson_topic_name;
        this.status = status;
    }

    public String getLesson_type_name() {
        return lesson_type_name;
    }

    public void setLesson_type_name(String lesson_type_name) {
        this.lesson_type_name = lesson_type_name;
    }

    public String getLesson_topic_name() {
        return lesson_topic_name;
    }

    public void setLesson_topic_name(String lesson_topic_name) {
        this.lesson_topic_name = lesson_topic_name;
    }


    

    public int getOrder() {
        return order;
    }

    public void setOrder(int order) {
        this.order = order;
    }

    public String getVideo_link() {
        return video_link;
    }

    public void setVideo_link(String video_link) {
        this.video_link = video_link;
    }

    public String getHtml_content() {
        return html_content;
    }

    public void setHtml_content(String html_content) {
        this.html_content = html_content;
    }

    public boolean isStatus() {
        return status;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }
    

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getSubject_id() {
        return subject_id;
    }

    public void setSubject_id(int subject_id) {
        this.subject_id = subject_id;
    }

    public int getTopic_id() {
        return topic_id;
    }

    public void setTopic_id(int topic_id) {
        this.topic_id = topic_id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getType_id() {
        return type_id;
    }

    public void setType_id(int type_id) {
        this.type_id = type_id;
    }
    
}
