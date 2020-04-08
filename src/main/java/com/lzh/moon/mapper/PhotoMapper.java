package com.lzh.moon.mapper;

import com.lzh.moon.Vo.Photo;

/**
 *${Description}
 *@author LiAnGzh
 *@date 2020/3/20 17:38
 */
public interface PhotoMapper {
    int deleteByPrimaryKey(Integer photoId);

    int insert(Photo record);

    int insertSelective(Photo record);

    Photo selectByPrimaryKey(Integer photoId);

    int updateByPrimaryKeySelective(Photo record);

    int updateByPrimaryKey(Photo record);
}