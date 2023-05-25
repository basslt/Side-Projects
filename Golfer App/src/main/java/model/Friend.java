package model;

public class Friend {
    private int friendshipId;
    private int userId1;
    private int userId2;

    public Friend(int friendshipId, int userId1, int userId2) {
        this.friendshipId = friendshipId;
        this.userId1 = userId1;
        this.userId2 = userId2;
    }

    public int getFriendshipId() {
        return friendshipId;
    }

    public void setFriendshipId(int friendshipId) {
        this.friendshipId = friendshipId;
    }

    public int getUserId1() {
        return userId1;
    }

    public void setUserId1(int userId1) {
        this.userId1 = userId1;
    }

    public int getUserId2() {
        return userId2;
    }

    public void setUserId2(int userId2) {
        this.userId2 = userId2;
    }

    @Override
    public String toString() {
        return "Friend{" +
                "friendshipId=" + friendshipId +
                ", userId1=" + userId1 +
                ", userId2=" + userId2 +
                '}';
    }
}