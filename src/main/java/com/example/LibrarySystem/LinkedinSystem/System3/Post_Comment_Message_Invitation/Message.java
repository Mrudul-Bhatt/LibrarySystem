package com.example.LibrarySystem.LinkedinSystem.System3.Post_Comment_Message_Invitation;

import com.example.LibrarySystem.LinkedinSystem.System3.Person_Admin_User.User;
import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
public class Message {
    private int messageId;
    private User sender;
    private List<User> recipients = new ArrayList<>();
    private String text;
    private List<Byte> media;

    public Message(int messageId, User sender, String text, List<Byte> media) {
        this.messageId = messageId;
        this.sender = sender;
        this.text = text;
        this.media = media;
    }

    public boolean addRecipients(List<User> newRecipients) {
        return recipients.addAll(newRecipients);
    }

    public boolean removeRecipient(User recipient) {
        return recipients.remove(recipient);
    }

    public boolean updateText(String newText) {
        this.text = newText;
        return true;
    }

    public boolean addMedia(Byte mediaItem) {
        return media.add(mediaItem);
    }

    public boolean removeMedia(Byte mediaItem) {
        return media.remove(mediaItem);
    }
}
