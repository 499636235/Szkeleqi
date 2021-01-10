package com.suzhoukeleqi.Mapper;

import org.springframework.stereotype.Repository;

@Repository
public interface UserMapper {
    Integer userLogin(String username, String password);

    Integer selectUserByUsername(String username);
}
