package com.janita.rmi.provider.service.impl;

import com.janita.rmi.provider.dao.UserDao;
import com.janita.rmi.provider.entity.User;
import com.janita.rmi.provider.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;

/**
 * Created by Janita on 2017-03-23 13:11
 */
@Service
public class UserServiceImpl extends UnicastRemoteObject implements IUserService {

    @Autowired
    private UserDao userDao;

    public UserServiceImpl() throws RemoteException {
        super();
    }
    @Override
    public User getUserById(Long userId) throws RemoteException{
       return userDao.findUserById(userId);
    }
}
