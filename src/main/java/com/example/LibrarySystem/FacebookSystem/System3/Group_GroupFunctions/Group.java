package com.example.LibrarySystem.FacebookSystem.System3.Group_GroupFunctions;

import com.example.LibrarySystem.FacebookSystem.System3.Address_Acc_Person_User_Admin.User;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@Builder
public class Group implements GroupFunctions {
    private String groupId;
    private String name;
    private String description;
    private byte[] coverPhoto;
    private int totalMembers;
    private boolean isPrivate;
    private List<User> members;

    public boolean addMember(User user) {
        members.add(user);
        totalMembers++;
        return true;
    }

    public boolean deleteMember(User user) {
        members.remove(user);
        totalMembers--;
        return true;
    }

    public boolean notifyUser(User user) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'addUser'");
    }

    @Override
    public boolean addUser(User user) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'addUser'");
    }

    @Override
    public boolean deleteUser(User user) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'deleteUser'");
    }
}
