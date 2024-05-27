package com.example.LibrarySystem.LinkedinSystem.System3.Person_Admin_User;

import com.example.LibrarySystem.LinkedinSystem.System3.Account_Address.Account;
import com.example.LibrarySystem.LinkedinSystem.System3.Account_Address.Address;
import com.example.LibrarySystem.LinkedinSystem.System3.CompanyPage_Job_Group.CompanyPage;
import com.example.LibrarySystem.LinkedinSystem.System3.CompanyPage_Job_Group.Group;
import com.example.LibrarySystem.LinkedinSystem.System3.CompanyPage_Job_Group.Job;
import com.example.LibrarySystem.LinkedinSystem.System3.DesignPatterns.Observer.Observer;
import com.example.LibrarySystem.LinkedinSystem.System3.Enums.CompanyPageStatus;
import com.example.LibrarySystem.LinkedinSystem.System3.Enums.GroupStatus;
import com.example.LibrarySystem.LinkedinSystem.System3.Post_Comment_Message_Invitation.Comment;
import com.example.LibrarySystem.LinkedinSystem.System3.Post_Comment_Message_Invitation.ConnectionInvitation;
import com.example.LibrarySystem.LinkedinSystem.System3.Post_Comment_Message_Invitation.Message;
import com.example.LibrarySystem.LinkedinSystem.System3.Post_Comment_Message_Invitation.Post;
import com.example.LibrarySystem.LinkedinSystem.System3.Profile_Edu_Exp_Skill_Recomm_Achiev_Analy.Profile;
import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Getter
@Setter
public class User extends Person implements Observer {
    private int userId;
    private Date dateOfJoining;
    private Profile profile;
    private List<User> connections = new ArrayList<>();
    private List<User> followsUsers = new ArrayList<>();
    private List<CompanyPage> followCompanies = new ArrayList<>();
    private List<Group> joinedGroups = new ArrayList<>();
    private List<CompanyPage> createdPages = new ArrayList<>();
    private List<Group> createdGroups = new ArrayList<>();

    public User(int userId, String name, Address address, String email, String phone, Account account,
                Date dateOfJoining) {
        super(name, address, email, phone, account);
        this.userId = userId;
        this.dateOfJoining = dateOfJoining;
    }

    @Override
    public void update(String message) {
        // Logic to handle the notification message, e.g., add it to a list of notifications
        System.out.println("User " + userId + " received notification: " + message);
    }

    // Methods to follow/unfollow companies and join/leave groups
    public boolean followCompany(CompanyPage company) {
        followCompanies.add(company);
        company.attach(this);
        return true;
    }

    public boolean unfollowCompany(CompanyPage company) {
        if (followCompanies.remove(company)) {
            company.detach(this);
            return true;
        }
        return false;
    }

    public boolean joinGroup(Group group) {
        joinedGroups.add(group);
        group.attach(this);
        return true;
    }

    public boolean leaveGroup(Group group) {
        if (joinedGroups.remove(group)) {
            group.detach(this);
            return true;
        }
        return false;
    }

    public boolean sendMessage(Message message) {
        return message.getRecipients().add(this);
    }

    public boolean sendInvite(ConnectionInvitation invite) {
        // Logic to send invite
        return true;
    }

    public boolean cancelInvite(ConnectionInvitation invite) {
        // Logic to cancel invite
        return true;
    }

    public boolean createPage(CompanyPage page) {
        createdPages.add(page);
        page.setCreatedBy(this);
        return true;
    }

    public boolean deletePage(CompanyPage page) {
        page.setStatus(CompanyPageStatus.DELETED);
        return createdPages.remove(page);
    }

    public boolean createGroup(Group group) {
        createdGroups.add(group);
        group.setCreatedBy(this);
        return true;
    }

    public boolean deleteGroup(Group group) {
        group.setStatus(GroupStatus.DELETED);
        return createdGroups.remove(group);
    }

    public boolean createPost(Post post) {
        post.setPostOwner(this);
        // Logic to add post to user's post list if exists
        return true;
    }

    public void deletePost(Post post) {
        // Logic to remove post from user's post list if exists
    }

    public boolean createComment(Comment comment) {
        comment.setCommentOwner(this);
        // Logic to add comment to post or parent comment if exists
        return true;
    }

    public boolean deleteComment(Comment comment) {
        // Logic to remove comment from post or parent comment if exists
        return true;
    }

    public boolean react(Post post) {
        post.incrementReacts();
        return true;
    }

    public boolean requestRecommendation(User user) {
        // Logic to request recommendation from another user
        return true;
    }

    public boolean acceptRecommendation(User user) {
        // Logic to accept recommendation from another user
        return true;
    }

    public boolean applyForJob(Job job) {
        // Logic to apply for a job
        return true;
    }

    // Additional functions
    public boolean followUser(User user) {
        return followsUsers.add(user);
    }

    public boolean unfollowUser(User user) {
        return followsUsers.remove(user);
    }

}
