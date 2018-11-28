package com.example.hamin.myapplication;

public class FriendDTO {
    private int faceId;
    private String friendName = " ";
    private String frinedStatus = " ";

    public FriendDTO(int faceId, String friendName, String frinedStatus) {
        this.faceId = faceId;
        this.friendName = friendName;
        this.frinedStatus = frinedStatus;
    }

    public int getFaceId() {
        return faceId;
    }

    public void setFaceId(int faceId) {
        this.faceId = faceId;
    }

    public String getFriendName() {
        return friendName;
    }

    public void setFriendName(String friendName) {
        this.friendName = friendName;
    }

    public String getFrinedStatus() {
        return frinedStatus;
    }

    public void setFrinedStatus(String frinedStatus) {
        this.frinedStatus = frinedStatus;
    }
}
