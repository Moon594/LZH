package com.lzh.moon.service.impl;

import com.lzh.moon.Vo.Users;
import com.lzh.moon.common.DefaultResult;
import com.lzh.moon.common.ResultCode;
import com.lzh.moon.mapper.UsersMapper;
import com.lzh.moon.service.RegisteredService;
import com.lzh.moon.utils.RedisUtil;
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
    @Autowired
    private RedisUtil redisUtil;

    public RegisteredServiceImpl(UsersMapper usersMapper) {
        this.usersMapper = usersMapper;
    }

    @Override
    public DefaultResult insertUser(Users user, String code) {
        List<Users> users = usersMapper.selectByUserTel(user.getUserTel());
        if (users != null && users.size() > 0) {
            return new DefaultResult(301, "该用户已存在");
        }
        if (code.equals(redisUtil.get(user.getUserTel()))) {
            if (usersMapper.insert(user) > 0) {
                return new DefaultResult(ResultCode.SUCCESS);
            }
            return new DefaultResult(ResultCode.FAIL);
        }
        return new DefaultResult(302, "验证码错误!");
    }
}
