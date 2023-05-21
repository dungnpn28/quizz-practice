package model;

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

    public User() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getAccount() {
        return account;
    }

    public void setAccount(String account) {
        this.account = account;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public int getRole_id() {
        return role_id;
    }

    public void setRole_id(int role_id) {
        this.role_id = role_id;
    }
}
