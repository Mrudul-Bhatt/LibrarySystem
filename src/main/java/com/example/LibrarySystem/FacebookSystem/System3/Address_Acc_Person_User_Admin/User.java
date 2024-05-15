package com.example.LibrarySystem.FacebookSystem.System3.Address_Acc_Person_User_Admin;

import java.util.Date;
import java.util.List;

import com.example.LibrarySystem.FacebookSystem.System3.Group_GroupFunctions.Group;
import com.example.LibrarySystem.FacebookSystem.System3.Page_Post_Comment.Page;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import org.apache.logging.log4j.message.Message;
import org.springframework.context.annotation.Profile;

import com.example.LibrarySystem.FacebookSystem.System3.InterfacesByUser.PageFunctionsByUser;

@Getter
@Setter
public class User extends Person implements PageFunctionsByUser {
    private int userId;
    private String name;
    private Date dateOfJoining;
    // The following lists contain the pages and groups that a user is admin of
    private List<Page> pagesAdmin;
    private List<Group> groupsAdmin;

    private Profile profile;

    public boolean sendMessage(Message message);

    public boolean sendRecommendation(Page page, Group group, User user);

    public boolean sendFriendRequest(User user);

    public boolean unfriendUser(User user);

    public boolean blockUser(User user);

    public boolean followUser(User user);

    // The functions of the different interfaces will also be present here
    public Page createPage(String name) {
        // functionality
    }

    public void likePage(Page page) {
        // functionality
    }

    public void followPage(Page page) {
        // functionality
    }

    public void unLikePage(Page page) {
        // functionality
    }

    public void unFollowPage(Page page) {
        // functionality
    }

    public Page sharePage(Page page) {
        // functionality
    }
}
