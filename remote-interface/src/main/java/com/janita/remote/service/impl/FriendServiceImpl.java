package com.janita.remote.service.impl;

import com.janita.remote.bean.Friend;
import com.janita.remote.service.IFriendService;
import org.springframework.stereotype.Service;

/**
 * Created by Janita on 2017-03-27 10:19
 */
@Service("friendService")
public class FriendServiceImpl implements IFriendService {
    @Override
    public Friend findFriendById(String friendId) {
        Friend friend = new Friend();
        friend.setFriendId(friendId);
        friend.setFriendName("GET-Friend");
        return friend;
    }
}
