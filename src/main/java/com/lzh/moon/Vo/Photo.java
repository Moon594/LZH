package com.lzh.moon.Vo;

import java.io.Serializable;

/**
 *${Description}
 *@author LiAnGzh
 *@date 2020/3/20 17:38
 */
public class Photo implements Serializable {
    /**
    * 图片ID
    */
    private Integer photoId;

    private Integer userId;

    /**
    * 图片路径
    */
    private String photoPath;

    /**
    * 图片组数
    */
    private String photoGroup;

    private static final long serialVersionUID = 1L;

    public Integer getPhotoId() {
        return photoId;
    }

    public void setPhotoId(Integer photoId) {
        this.photoId = photoId;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public String getPhotoPath() {
        return photoPath;
    }

    public void setPhotoPath(String photoPath) {
        this.photoPath = photoPath;
    }

    public String getPhotoGroup() {
        return photoGroup;
    }

    public void setPhotoGroup(String photoGroup) {
        this.photoGroup = photoGroup;
    }
}