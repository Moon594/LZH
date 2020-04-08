package com.lzh.moon.service.impl;

import com.lzh.moon.Vo.Users;
import com.lzh.moon.mapper.UsersMapper;
import com.lzh.moon.service.LoginService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author LiAnGzh
 * @date 2020/4/7 16:03
 */
@Service
public class LoginServiceImpl implements LoginService {
    @Autowired
    private UsersMapper usersMapper;

    public LoginServiceImpl(UsersMapper usersMapper) {
        this.usersMapper = usersMapper;
    }

    @Override
    public List<Users> selectByUser(String userTel,String userPassword) {
        List<Users> users = usersMapper.selectByUserTelAndUserPassword(userTel, userPassword);
        return users;
    }
}
