package com.example.LibrarySystem.FacebookSystem.System3.Message_FriendRequest_Notification;

import com.example.LibrarySystem.FacebookSystem.System3.Address_Acc_Person_User_Admin.User;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;

@Getter
@Setter
@AllArgsConstructor
public class FriendRequest {
    private User recipient;
    private User sender;
    private FriendRequest status;
    private Date requestSent;
    private Date requestStatusModified;

    public boolean acceptRequest(User user);

    public boolean rejectRequest(User user);
}
