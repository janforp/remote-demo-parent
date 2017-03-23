package com.janita.rmi.provider;

import com.janita.rmi.provider.service.IUserService;
import com.janita.rmi.provider.service.impl.UserServiceImpl;

import javax.naming.Context;
import javax.naming.InitialContext;

/**
 * Created by Janita on 2017-03-23 13:31
 */
public class Server {

    public static void main(String[] args){

        try {
            IUserService userService = new UserServiceImpl();
            Context namingContext = new InitialContext();
            namingContext.rebind("rmi://192.168.100.75/userService",userService);

        }catch (Exception e){
            e.printStackTrace();
        }
    }
}
