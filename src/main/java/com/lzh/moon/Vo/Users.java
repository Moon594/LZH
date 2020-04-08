package com.lzh.moon.Vo;

import java.io.Serializable;

/**
 * ${Description}
 *
 * @author LiAnGzh
 * @date 2020/3/21 12:01
 */
public class Users implements Serializable {
    /**
     * 用户ID
     */
    private Integer userId;

    /**
     * 昵称
     */
    private String userName;

    /**
     * 电话号码
     */
    private String userTel;

    /**
     * 密码
     */
    private String userPassword;

    /**
     * 性别
     */
    private String userSex;

    /**
     * 年龄
     */
    private Integer userAge;

    /**
     * 头像
     */
    private String userPhoto;

    /**
     * 个性签名
     */
    private String userSign;

    private static final long serialVersionUID = 1L;

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getUserTel() {
        return userTel;
    }

    public void setUserTel(String userTel) {
        this.userTel = userTel;
    }

    public String getUserPassword() {
        return userPassword;
    }

    public void setUserPassword(String userPassword) {
        this.userPassword = userPassword;
    }

    public String getUserSex() {
        return userSex;
    }

    public void setUserSex(String userSex) {
        this.userSex = userSex;
    }

    public Integer getUserAge() {
        return userAge;
    }

    public void setUserAge(Integer userAge) {
        this.userAge = userAge;
    }

    public String getUserPhoto() {
        return userPhoto;
    }

    public void setUserPhoto(String userPhoto) {
        this.userPhoto = userPhoto;
    }

    public String getUserSign() {
        return userSign;
    }

    public void setUserSign(String userSign) {
        this.userSign = userSign;
    }
}