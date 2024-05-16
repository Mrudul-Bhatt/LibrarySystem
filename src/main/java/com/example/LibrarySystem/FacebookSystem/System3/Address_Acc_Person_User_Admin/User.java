package com.example.LibrarySystem.FacebookSystem.System3.Address_Acc_Person_User_Admin;

import com.example.LibrarySystem.FacebookSystem.System3.Group_GroupFunctions.Group;
import com.example.LibrarySystem.FacebookSystem.System3.InterfacesByUser.CommentFunctionsByUser;
import com.example.LibrarySystem.FacebookSystem.System3.InterfacesByUser.GroupFunctionsByUser;
import com.example.LibrarySystem.FacebookSystem.System3.InterfacesByUser.PageFunctionsByUser;
import com.example.LibrarySystem.FacebookSystem.System3.Message_FriendRequest_Notification.FriendRequest;
import com.example.LibrarySystem.FacebookSystem.System3.Message_FriendRequest_Notification.Message;
import com.example.LibrarySystem.FacebookSystem.System3.Page_Post_Comment.Comment;
import com.example.LibrarySystem.FacebookSystem.System3.Page_Post_Comment.Page;
import com.example.LibrarySystem.FacebookSystem.System3.Page_Post_Comment.Post;
import com.example.LibrarySystem.FacebookSystem.System3.Profile_Privacy_Education_Places_Work.Profile;
import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Getter
@Setter
public class User extends Person implements PageFunctionsByUser, CommentFunctionsByUser, GroupFunctionsByUser {
    private int userId;
    private String name;
    private Date dateOfJoining;

    // The following lists contain the pages and groups that a user is admin of
    private List<Page> pagesAdmin;
    private List<Group> groupsAdmin;

    private Profile profile;

    private List<User> friends;
    private List<FriendRequest> receivedFriendRequests;
    private List<FriendRequest> sentFriendRequests;
    private List<Message> messages;

    public User(String name, Address address, String email, String phone, Account account) {
        super(name, address, email, phone, account);
        this.pagesAdmin = new ArrayList<>();
        this.groupsAdmin = new ArrayList<>();
        this.friends = new ArrayList<>();
        this.receivedFriendRequests = new ArrayList<>();
        this.sentFriendRequests = new ArrayList<>();
        this.messages = new ArrayList<>();
    }

    @Override
    public Group createGroup(String name) {
        Group group = Group.builder().groupId("random").name(name).build();
        group.addMember(this);
        groupsAdmin.add(group);
        return group;
    }

    @Override
    public void joinGroup(Group group) {
        group.addMember(this);
    }

    @Override
    public void leaveGroup(Group group) {
        group.deleteMember(this);
    }

    @Override
    public void sendGroupInvite(Group group) {
        // group.inviteUser(this);
    }

    @Override
    public Comment createComment(Post post, String content) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'createComment'");
    }

    @Override
    public void likeComment(Comment comment) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'likeComment'");
    }

    @Override
    public Page createPage(String name) {
        Page page = Page.builder().pageId(1).name(name).build();
        page.setOwner(this);
        pagesAdmin.add(page);
        return page;
    }

    @Override
    public Page sharePage(Page page) {
        return page;
    }

    @Override
    public void likePage(Page page) {
        page.incrementLikes();
    }

    @Override
    public void followPage(Page page) {
        page.addFollower(this);
    }

    @Override
    public void unLikePage(Page page) {
        page.decrementLikes();
    }

    @Override
    public void unFollowPage(Page page) {
        page.removeFollower(this);
    }

    public boolean sendMessage(User recipient, String content) {
        Message message = Message.builder().sender(this).content(content).recipients(List.of(recipient)).build();
        return recipient.receiveMessage(message);
    }

    public boolean receiveMessage(Message message) {
        return messages.add(message);
    }

    // public boolean sendRecommendation(Page page, Group group, User user);

    // public boolean sendFriendRequest(User user);

    // public boolean unfriendUser(User user);

    // public boolean blockUser(User user);

    // public boolean followUser(User user);
}
