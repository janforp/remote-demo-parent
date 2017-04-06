package com.janita.remote.bean;

/**
 * Created by Janita on 2017-03-27 10:17
 */
public class Friend {
    //TODO

    private String friendId;

    private String friendName;

    public String getFriendId() {
        return friendId;
    }

    public void setFriendId(String friendId) {
        this.friendId = friendId;
    }


    public String getFriendName() {
        return friendName;
    }

    public void setFriendName(String friendName) {
        this.friendName = friendName;
    }

    @Override
    public String toString() {
        return "Friend{" +
                "friendId='" + friendId + '\'' +
                ", friendName='" + friendName + '\'' +
                '}';
    }
}
