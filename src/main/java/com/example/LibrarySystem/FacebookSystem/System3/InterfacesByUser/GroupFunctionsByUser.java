package com.example.LibrarySystem.FacebookSystem.System3.InterfacesByUser;

import com.example.LibrarySystem.FacebookSystem.System3.Group_GroupFunctions.Group;

public interface GroupFunctionsByUser {
    public Group createGroup(String name);

    public void joinGroup(Group group);

    public void leaveGroup(Group group);

    public void sendGroupInvite(Group group);
}
