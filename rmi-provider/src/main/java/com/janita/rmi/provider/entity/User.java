package com.janita.rmi.provider.entity;

import java.io.Serializable;

/**
 * Created by Janita on 2017-03-23 13:08
 */
public class User implements Serializable {

    private Long userId;

    private String username;

    private Integer age;

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    @Override
    public String toString() {
        return "User{" +
                "userId=" + userId +
                ", username='" + username + '\'' +
                ", age=" + age +
                '}';
    }
}
