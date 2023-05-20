/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

/**
 *
 * @author Acer
 */
public class User {
    private int id;
    private String account;
    private String password;
    private int role_id;

    public User() {
    }

    //constructor account and password
    public User(String account, String password) {
        this.account = account;
        this.password = password;
    }

    //get set
    public int getId() {
        return id;
    }

    public String getAccount() {
        return account;
    }

    public String getPassword() {
        return password;
    }

    public int getRole_id() {
        return role_id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setAccount(String account) {
        this.account = account;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
