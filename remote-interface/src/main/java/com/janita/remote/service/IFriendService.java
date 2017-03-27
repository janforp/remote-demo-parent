package com.janita.remote.service;

import com.janita.remote.bean.Friend;

/**
 * Created by Janita on 2017-03-27 10:18
 */
public interface IFriendService {

    Friend findFriendById(String friendId);
}
