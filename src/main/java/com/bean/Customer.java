package com.bean;

public class Customer {
    // alt + insert 可以快速生成

    // 用户名
    private String username;
    // id
    private int id;
    // 密码
    private String password;
    // 身份辨认
    private int isRoot;
    // 电话号码
    private String  telephone;
    // 性别
    private String gender;
    // 身份证号
    private String identity;

    public Customer(){

    }

    public Customer(String username, int id, String password, int isRoot, String telephone, String gender, String identity) {
        this.username = username;
        this.id = id;
        this.password = password;
        this.isRoot = isRoot;
        this.telephone = telephone;
        this.gender = gender;
        this.identity = identity;
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

    public String getTelephone() {
        return telephone;
    }

    public void setTelephone(String telephone) {
        this.telephone = telephone;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getIdentity() {
        return identity;
    }

    public void setIdentity(String identity) {
        this.identity = identity;
    }

    @Override
    public String toString() {
        return "Customer{" +
                "username='" + username + '\'' +
                ", id=" + id +
                ", password='" + password + '\'' +
                ", isRoot=" + isRoot +
                ", telephone='" + telephone + '\'' +
                ", gender='" + gender + '\'' +
                ", identity='" + identity + '\'' +
                '}';
    }
}
