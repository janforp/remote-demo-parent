package com.janita.rmi.provider.service;

import com.janita.rmi.provider.entity.User;

import java.rmi.Remote;
import java.rmi.RemoteException;

/**
 * Created by Janita on 2017-03-23 13:09
 */
public interface IUserService extends Remote {

    /**
     * Remote 接口是一个标识接口，用于标识所包含的方法可以从非本地虚拟机上调用的接口
     * @param userId
     * @return
     * @throws RemoteException
     */
    User getUserById(Long userId) throws RemoteException;
}
