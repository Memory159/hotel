package com.bean;

public class Goods {
    // 商品名称
    private String username;
    // id
    private int id;
    // 数量
    private String number;
    // 图片
    private String image;
    // 价格
    private String price;

    public Goods(){

    }

    public Goods(String username, int id, String number, String image, String price) {
        this.username = username;
        this.id = id;
        this.number = number;
        this.image = image;
        this.price = price;
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

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    @Override
    public String toString() {
        return "Goods{" +
                "username='" + username + '\'' +
                ", id=" + id +
                ", number='" + number + '\'' +
                ", image='" + image + '\'' +
                ", price='" + price + '\'' +
                '}';
    }
}
