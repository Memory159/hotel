package com.bean;

public class BookingList {

    // 预约时间
    public String bookingTime;
    // 离店时间
    public String leaveTime;
    // 点击预约时间
    public String nowTime;
    // 房间图片
    public String roomImg;
    // 房间价格
    public String price;
    // 房间类型
    public String type;
    // 房间id
    public int id;
    // 用户名
    public String username;
    // 顾客名称
    public String customerName;
    // 用户电话
    public String telephone;
    // 用户身份证号
    public String identity;
    // 房间状态
    public String state;

    public BookingList(){

    }

    public BookingList(String bookingTime, String leaveTime, String nowTime, String roomImg, String price, String type, int id, String username, String customerName, String telephone, String identity, String state) {
        this.bookingTime = bookingTime;
        this.leaveTime = leaveTime;
        this.nowTime = nowTime;
        this.roomImg = roomImg;
        this.price = price;
        this.type = type;
        this.id = id;
        this.username = username;
        this.customerName = customerName;
        this.telephone = telephone;
        this.identity = identity;
        this.state = state;
    }
    public String getBookingTime() {
        return bookingTime;
    }

    public void setBookingTime(String bookingTime) {
        this.bookingTime = bookingTime;
    }

    public String getLeaveTime() {
        return leaveTime;
    }

    public void setLeaveTime(String leaveTime) {
        this.leaveTime = leaveTime;
    }

    public String getNowTime() {
        return nowTime;
    }

    public void setNowTime(String nowTime) {
        this.nowTime = nowTime;
    }

    public String getRoomImg() {
        return roomImg;
    }

    public void setRoomImg(String roomImg) {
        this.roomImg = roomImg;
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

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getCustomerName() {
        return customerName;
    }

    public void setCustomerName(String customerName) {
        this.customerName = customerName;
    }

    public String getTelephone() {
        return telephone;
    }

    public void setTelephone(String telephone) {
        this.telephone = telephone;
    }

    public String getIdentity() {
        return identity;
    }

    public void setIdentity(String identity) {
        this.identity = identity;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    @Override
    public String toString() {
        return "BookingList{" +
                "bookingTime='" + bookingTime + '\'' +
                ", leaveTime='" + leaveTime + '\'' +
                ", nowTime='" + nowTime + '\'' +
                ", roomImg='" + roomImg + '\'' +
                ", price='" + price + '\'' +
                ", type='" + type + '\'' +
                ", id=" + id +
                ", username='" + username + '\'' +
                ", customerName='" + customerName + '\'' +
                ", telephone='" + telephone + '\'' +
                ", identity='" + identity + '\'' +
                ", state='" + state + '\'' +
                '}';
    }
}
