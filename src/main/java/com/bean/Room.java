package com.bean;

public class Room {
    // 房间号
    private String roomImage;
    // 价格
    private String price;
    // 类型
    private String type;
    // 状态
    private String state;
    // 描述
    private String des;
    // 房间人数
    private String peopleNumber;
    // 房间床数
    private String bedNumber;
    //房间id
    private int id;
    // 房间总数
    private String sumRoom;
    // 已经预约房间数
    private String reserveRoom;

    public Room() {

    }

    public Room(String roomImage, String price, String type, String state, String des, String peopleNumber, String bedNumber, int id, String sumRoom, String reserveRoom) {
        this.roomImage = roomImage;
        this.price = price;
        this.type = type;
        this.state = state;
        this.des = des;
        this.peopleNumber = peopleNumber;
        this.bedNumber = bedNumber;
        this.id = id;
        this.sumRoom = sumRoom;
        this.reserveRoom = reserveRoom;
    }

    public String getRoomImage() {
        return roomImage;
    }

    public void setRoomImage(String roomImage) {
        this.roomImage = roomImage;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public String getDes() {
        return des;
    }

    public void setDes(String des) {
        this.des = des;
    }

    public String getPeopleNumber() {
        return peopleNumber;
    }

    public void setPeopleNumber(String peopleNumber) {
        this.peopleNumber = peopleNumber;
    }

    public String getBedNumber() {
        return bedNumber;
    }

    public void setBedNumber(String bedNumber) {
        this.bedNumber = bedNumber;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getSumRoom() {
        return sumRoom;
    }

    public void setSumRoom(String sumRoom) {
        this.sumRoom = sumRoom;
    }

    public String getReserveRoom() {
        return reserveRoom;
    }

    public void setReserveRoom(String reserveRoom) {
        this.reserveRoom = reserveRoom;
    }

    @Override
    public String toString() {
        return "Room{" +
                "roomImage='" + roomImage + '\'' +
                ", price='" + price + '\'' +
                ", type='" + type + '\'' +
                ", state='" + state + '\'' +
                ", des='" + des + '\'' +
                ", peopleNumber='" + peopleNumber + '\'' +
                ", bedNumber='" + bedNumber + '\'' +
                ", id=" + id +
                ", sumRoom='" + sumRoom + '\'' +
                ", reserveRoom='" + reserveRoom + '\'' +
                '}';
    }
}