package com.bean;

public class Admin {
    // 用户名
    private String username;
    // id
    private int id;
    // 密码
    private String password;
    // 身份辨认
    private int isRoot;

    public Admin(){

    }

    public Admin(String username, int id, String password, int isRoot) {
        this.username = username;
        this.id = id;
        this.password = password;
        this.isRoot = isRoot;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public int getIsRoot() {
        return isRoot;
    }

    public void setIsRoot(int isRoot) {
        this.isRoot = isRoot;
    }

    @Override
    public String toString() {
        return "Admin{" +
                "username='" + username + '\'' +
                ", id=" + id +
                ", password='" + password + '\'' +
                ", isRoot=" + isRoot +
                '}';
    }
}
