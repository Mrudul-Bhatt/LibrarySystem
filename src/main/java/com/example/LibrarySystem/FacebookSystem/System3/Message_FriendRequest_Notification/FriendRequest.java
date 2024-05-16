package com.example.LibrarySystem.FacebookSystem.System3.Message_FriendRequest_Notification;

import com.example.LibrarySystem.FacebookSystem.System3.Address_Acc_Person_User_Admin.User;
import com.example.LibrarySystem.FacebookSystem.System3.Enums.FriendInviteStatus;
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
    private FriendInviteStatus status;
    private Date requestSent;
    private Date requestStatusModified;

    public boolean acceptRequest(User user) {
        if (status == FriendInviteStatus.PENDING) {
            status = FriendInviteStatus.ACCEPTED;
            requestStatusModified = new Date(); // Update status modification time
            // Logic to notify sender and recipient about the request acceptance
            return true;
        }
        return false;
    }

    public boolean rejectRequest(User user) {
        if (status == FriendInviteStatus.PENDING) {
            status = FriendInviteStatus.REJECTED;
            requestStatusModified = new Date(); // Update status modification time
            // Logic to notify sender and recipient about the request rejection
            return true;
        }
        return false;
    }
}
