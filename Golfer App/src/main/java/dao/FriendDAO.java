package dao;

import model.Friend;

import java.util.List;

public interface FriendDAO {
    List<Friend> getFriendsByUserId(int userId);
    void addFriend(Friend friend);
    void removeFriend(Friend friend);
}