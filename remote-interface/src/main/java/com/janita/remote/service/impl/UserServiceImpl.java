package com.janita.remote.service.impl;

import com.janita.remote.bean.User;
import com.janita.remote.service.IUserService;
import org.springframework.stereotype.Service;

/**
 * Created by Janita on 2017-03-27 10:10
 */
@Service("userService")
public class UserServiceImpl implements IUserService {
    @Override
    public User findOne(String userId) {
        User user = new User();
        user.setUserId(userId);
        user.setUsername("Janita-POST");
        return user;
    }
}
