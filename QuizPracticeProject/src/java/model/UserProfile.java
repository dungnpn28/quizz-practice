/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

/**
 *
 * @author ACER
 */
public class UserProfile {
    private int user_id;
    private String avatar;
    private String full_name;
    private int gender;
    private String phone_number;
    private String dob;
    private String created;
    private String modified;
    private User user;

    public UserProfile() {
    }

    public UserProfile(int user_id, String avatar, String full_name, int gender, String phone_number, String dob, String created, String modified) {
        this.user_id = user_id;
        this.avatar = avatar;
        this.full_name = full_name;
        this.gender = gender;
        this.phone_number = phone_number;
        this.dob = dob;
        this.created = created;
        this.modified = modified;
    }
    public UserProfile(int user_id, String avatar, String full_name, int gender, String phone_number, String dob, String created, String modified,User user) {
        this.user_id = user_id;
        this.avatar = avatar;
        this.full_name = full_name;
        this.gender = gender;
        this.phone_number = phone_number;
        this.dob = dob;
        this.created = created;
        this.modified = modified;
        this.user=user;
    }
    public UserProfile(String full_name, int gender, String phone_number, String dob) {
        this.full_name = full_name;
        this.gender = gender;
        this.phone_number = phone_number;
        this.dob = dob;
    }
    
    public UserProfile(int user_id,String avatar,String full_name, int gender, String dob, String phone_number) {
        this.user_id = user_id;
        this.avatar = avatar;
        this.full_name = full_name;
        this.gender = gender;
        this.dob = dob;
        this.phone_number = phone_number;
    }

    public int getUser_id() {
        return user_id;
    }

    public void setUser_id(int user_id) {
        this.user_id = user_id;
    }

    public String getAvatar() {
        return avatar;
    }

    public void setAvatar(String avatar) {
        this.avatar = avatar;
    }

    public String getFull_name() {
        return full_name;
    }

    public void setFull_name(String fullname) {
        this.full_name = fullname;
    }

    public int getGender() {
        return gender;
    }

    public void setGender(int gender) {
        this.gender = gender;
    }

    public String phone_number() {
        return phone_number;
    }

    public void phone_number(String phone_number) {
        this.phone_number = phone_number;
    }

    public String getDob() {
        return dob;
    }

    public void setDob(String dob) {
        this.dob = dob;
    }

    public String getCreated() {
        return created;
    }

    public void setCreated(String created) {
        this.created = created;
    }

    public String getModified() {
        return modified;
    }

    public void setModified(String modified) {
        this.modified = modified;
    }

    public String getPhone_number() {
        return phone_number;
    }

    public void setPhone_number(String phone_number) {
        this.phone_number = phone_number;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }
    
    
    
}
