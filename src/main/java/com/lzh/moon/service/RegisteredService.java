package com.lzh.moon.service;

import com.lzh.moon.Vo.Users;
import com.lzh.moon.common.DefaultResult;


/**
 * 用户资料数据库增删改查
 *
 * @author LiAnGzh
 * @date 2020/3/21 15:34
 */
public interface RegisteredService {
    DefaultResult insertUser(Users user,String code);
}
