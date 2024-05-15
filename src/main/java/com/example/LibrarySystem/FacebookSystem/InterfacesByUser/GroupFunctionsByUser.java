package com.example.LibrarySystem.FacebookSystem.InterfacesByUser;

public interface GroupFunctionsByUser {
    public Group createGroup(String name);

    public void joinGroup(Group group);

    public void leaveGroup(Group group);

    public void sendGroupInvite(Group group);
}
