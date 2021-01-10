package com.suzhoukeleqi.ServiceImpl;

import com.suzhoukeleqi.Mapper.UserMapper;
import com.suzhoukeleqi.Service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {
    @Autowired
    UserMapper userMapper;

    @Override
    public Integer userLogin(String username, String password) {
        return userMapper.userLogin(username, password);
    }

    @Override
    public Integer selectUserByUsername(String username) {
        return userMapper.selectUserByUsername(username);
    }

}
