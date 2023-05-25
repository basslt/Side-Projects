package dao;

import model.Follower;

import java.util.List;

public interface FollowerDAO {
    List<Follower> getFollowersByUserId(int userId);
    void addFollower(Follower follower);
    void removeFollower(Follower follower);
}
