package com.example.LibrarySystem.FacebookSystem.System3.Message_FriendRequest_Notification;

import com.example.LibrarySystem.FacebookSystem.System3.Address_Acc_Person_User_Admin.User;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@AllArgsConstructor
public class Message {
    private int messageId;
    private User sender;
    private String content;
    private List<User> recipients;
    private List<byte[]> multimedia;

    public boolean addRecipient(User user) {
        return recipients.add(user);
    }

    public boolean removeRecipient(User user) {
        return recipients.remove(user);
    }
}
