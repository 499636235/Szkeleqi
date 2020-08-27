package com.suzhoukeleqi.ServiceImpl;

import com.suzhoukeleqi.Mapper.UserMapper;
import com.suzhoukeleqi.Service.UserService;
import com.suzhoukeleqi.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {
    @Autowired
    UserMapper userMapper;

    @Override
    public User selectUser(int id) {
        return userMapper.selectUser(id);
    }
}
