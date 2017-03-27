package com.janita.remote.service;


import com.janita.remote.bean.User;

/**
 * Created by Janita on 2017-03-27 10:09
 */
public interface IUserService {

    User findOne(String userId);
}
