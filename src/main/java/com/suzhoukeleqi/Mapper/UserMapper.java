package com.suzhoukeleqi.Mapper;

import com.suzhoukeleqi.entity.User;
import org.springframework.stereotype.Repository;

@Repository
public interface UserMapper {
    User selectUser(int id);
}
