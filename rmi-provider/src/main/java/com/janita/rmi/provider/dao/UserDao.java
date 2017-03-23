package com.janita.rmi.provider.dao;

import com.janita.rmi.provider.entity.User;
import org.springframework.stereotype.Repository;

/**
 * Created by Janita on 2017-03-23 13:16
 */
@Repository
public class UserDao {

    public User findUserById(Long userId){
        User user = new User();
        user.setUserId(userId);
        if (userId == 1){
            user.setUsername("Janita");
            user.setAge(18);
        }else if (userId == 2){
            user.setUsername("张三");
            user.setAge(22);
        }else if (userId ==  3){
            user.setUsername("李四");
            user.setAge(15);
        }
        return user;
    }
}
