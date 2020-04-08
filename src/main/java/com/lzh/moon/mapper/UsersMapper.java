package com.lzh.moon.mapper;

import com.lzh.moon.Vo.Users;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * ${Description}
 *
 * @author LiAnGzh
 * @date 2020/3/21 12:01
 */
public interface UsersMapper {
    int deleteByPrimaryKey(Integer userId);

    int insert(Users record);

    int insertSelective(Users record);

    Users selectByPrimaryKey(Integer userId);

    int updateByPrimaryKey(Users record);

    List<Users> selectByUserTelAndUserPassword(@Param("userTel")String userTel, @Param("userPassword")String userPassword);

    List<Users> selectByUserTel(String userTel);
}