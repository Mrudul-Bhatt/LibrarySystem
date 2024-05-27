package com.example.LibrarySystem.LinkedinSystem.System3.Post_Comment_Message_Invitation;

import com.example.LibrarySystem.LinkedinSystem.System3.Enums.ConnectionInviteStatus;
import com.example.LibrarySystem.LinkedinSystem.System3.Person_Admin_User.User;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;

@Getter
@Setter
public class ConnectionInvitation {
    private User sender;
    private User recipient;
    private Date dateCreated;
    private ConnectionInviteStatus status;

    public ConnectionInvitation(User sender, User recipient) {
        this.sender = sender;
        this.recipient = recipient;
        this.dateCreated = new Date();
        this.status = ConnectionInviteStatus.PENDING;
    }

    public boolean acceptConnection() {
        if (this.status == ConnectionInviteStatus.PENDING) {
            this.status = ConnectionInviteStatus.ACCEPTED;
            // Logic to add the connection to both users' connections lists
            sender.getConnections().add(recipient);
            recipient.getConnections().add(sender);
            return true;
        }
        return false;
    }

    public boolean rejectConnection() {
        if (this.status == ConnectionInviteStatus.PENDING) {
            this.status = ConnectionInviteStatus.IGNORED;
            return true;
        }
        return false;
    }

    public boolean cancelInvitation() {
        if (this.status == ConnectionInviteStatus.PENDING) {
            // Logic to handle cancellation
            this.status = ConnectionInviteStatus.IGNORED;
            return true;
        }
        return false;
    }
}
