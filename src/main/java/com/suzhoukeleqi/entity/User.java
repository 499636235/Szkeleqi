package com.suzhoukeleqi.entity;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class User {
    private Integer id;
    private String userName;
    private String passWord;
    private String userGroup;

//    public Integer getId() {
//        return id;
//    }
//
//    public void setId(Integer id) {
//        this.id = id;
//    }
//
//    public String getUserName() {
//        return userName;
//    }
//
//    public void setUserName(String userName) {
//        this.userName = userName;
//    }
//
//    public String getPassWord() {
//        return passWord;
//    }
//
//    public void setPassWord(String passWord) {
//        this.passWord = passWord;
//    }
//
//    public String getUserGroup() {
//        return userGroup;
//    }
//
//    public void setUserGroup(String userGroup) {
//        this.userGroup = userGroup;
//    }
//
//    public User() {
//    }
//
//    public User(Integer id, String userName, String passWord, String userGroup) {
//        this.id = id;
//        this.userName = userName;
//        this.passWord = passWord;
//        this.userGroup = userGroup;
//    }
}
