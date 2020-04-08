package com.lzh.moon.service.impl;

import com.lzh.moon.Vo.Users;
import com.lzh.moon.common.DefaultResult;
import com.lzh.moon.common.ResultCode;
import com.lzh.moon.mapper.UsersMapper;
import com.lzh.moon.service.RegisteredService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author LiAnGzh
 * @date 2020/4/7 15:42
 */
@Service
public class RegisteredServiceImpl implements RegisteredService {

    @Autowired
    private UsersMapper usersMapper;

    public RegisteredServiceImpl(UsersMapper usersMapper) {
        this.usersMapper = usersMapper;
    }

    @Override
    public DefaultResult insertUser(Users user) {

        List<Users> users = usersMapper.selectByUserTel(user.getUserTel());
        if (users!=null && users.size()>0){
            return new DefaultResult(ResultCode.FAIL);
        }
        if(usersMapper.insert(user)>0){
            return new DefaultResult(ResultCode.SUCCESS);
        }
        return new DefaultResult(ResultCode.FAIL);
    }
}
