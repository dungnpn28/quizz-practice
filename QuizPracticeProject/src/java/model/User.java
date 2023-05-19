/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

/**
 *
 * @author Dell
 */
public class User {
    private int id;
    private String account;
    private String password;
    private int role_id;

    public User(int id, String account, String password, int role_id) {
        this.id = id;
        this.account = account;
        this.password = password;
        this.role_id = role_id;
    }
    
}
