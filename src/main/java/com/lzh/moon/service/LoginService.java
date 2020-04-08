package com.lzh.moon.service;

import com.lzh.moon.Vo.Users;

import java.util.List;

/**
 * 用户登录服务
 *
 * @author LiAnGzh
 * @date 2020/4/7 15:53
 */
public interface LoginService {
    List<Users> selectByUser(String userTel,String userPassword);
}
