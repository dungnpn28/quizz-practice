package model;

import java.sql.Date;

/**
 *
 * @author ADMIN
 */
public class MyRegistration {
    private int id;
    private int subjectId;
    private int pricePackageId;
    private int userId;
    private Date created;
    private int category_id;
    private String subject_name;
    private Date expired;
    private int status;
    private String time;

    public MyRegistration() {
    }

    public MyRegistration(int id, int subjectId, int pricePackageId, int userId, Date created, int category_id, String subject_name, int status) {
        this.id = id;
        this.subjectId = subjectId;
        this.pricePackageId = pricePackageId;
        this.userId = userId;
        this.created = created;
        this.category_id = category_id;
        this.subject_name = subject_name;
        this.status = status;
    }
    
    public MyRegistration(int id, int subjectId, int pricePackageId, int userId, Date created, int category_id, String subject_name) {
        this.id = id;
        this.subjectId = subjectId;
        this.pricePackageId = pricePackageId;
        this.userId = userId;
        this.created = created;
        this.category_id = category_id;
        this.subject_name = subject_name;
    }

    public MyRegistration(int id, int subjectId, int pricePackageId, int userId, Date created) {
        this.id = id;
        this.subjectId = subjectId;
        this.pricePackageId = pricePackageId;
        this.userId = userId;
        this.created = created;
    }

    public MyRegistration(int id, int subjectId, int pricePackageId, int userId, Date created, int category_id, String subject_name, Date expired, int status) {
        this.id = id;
        this.subjectId = subjectId;
        this.pricePackageId = pricePackageId;
        this.userId = userId;
        this.created = created;
        this.category_id = category_id;
        this.subject_name = subject_name;
        this.expired = expired;
        this.status = status;
    }

    public MyRegistration(int id, int subjectId, int pricePackageId, int userId, Date created, int category_id, String subject_name, Date expired, int status, String time) {
        this.id = id;
        this.subjectId = subjectId;
        this.pricePackageId = pricePackageId;
        this.userId = userId;
        this.created = created;
        this.category_id = category_id;
        this.subject_name = subject_name;
        this.expired = expired;
        this.status = status;
        this.time = time;
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

    public int getPricePackageId() {
        return pricePackageId;
    }

    public void setPricePackageId(int pricePackageId) {
        this.pricePackageId = pricePackageId;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public Date getCreated() {
        return created;
    }

    public void setCreated(Date created) {
        this.created = created;
    }

    public int getCategory_id() {
        return category_id;
    }

    public void setCategory_id(int category_id) {
        this.category_id = category_id;
    }

    public String getSubject_name() {
        return subject_name;
    }

    public void setSubject_name(String subject_name) {
        this.subject_name = subject_name;
    }

    public Date getExpired() {
        return expired;
    }

    public void setExpired(Date expired) {
        this.expired = expired;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }
    
    
    
}