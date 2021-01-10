package com.suzhoukeleqi.Service;

public interface UserService {
    Integer userLogin(String username, String password);

    Integer selectUserByUsername(String username);
}
