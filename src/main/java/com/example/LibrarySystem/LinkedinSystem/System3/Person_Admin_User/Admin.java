package com.example.LibrarySystem.LinkedinSystem.System3.Person_Admin_User;

import com.example.LibrarySystem.LinkedinSystem.System3.Account_Address.Account;
import com.example.LibrarySystem.LinkedinSystem.System3.Account_Address.Address;
import com.example.LibrarySystem.LinkedinSystem.System3.CompanyPage_Job_Group.CompanyPage;
import com.example.LibrarySystem.LinkedinSystem.System3.CompanyPage_Job_Group.Group;
import com.example.LibrarySystem.LinkedinSystem.System3.CompanyPage_Job_Group.Job;
import com.example.LibrarySystem.LinkedinSystem.System3.Enums.AccountStatus;
import com.example.LibrarySystem.LinkedinSystem.System3.Enums.CompanyPageStatus;
import com.example.LibrarySystem.LinkedinSystem.System3.Enums.GroupStatus;
import com.example.LibrarySystem.LinkedinSystem.System3.Post_Comment_Message_Invitation.Comment;
import com.example.LibrarySystem.LinkedinSystem.System3.Post_Comment_Message_Invitation.Post;

public class Admin extends Person {
    public Admin(String name, Address address, String email, String phone, Account account) {
        super(name, address, email, phone, account);
    }

    public boolean blockUser(User user) {
        user.getAccount().setStatus(AccountStatus.BLOCKED);
        return true;
    }

    public boolean unblockUser(User user) {
        user.getAccount().setStatus(AccountStatus.ACTIVE);
        return true;
    }

    public boolean disablePage(CompanyPage page) {
        page.setStatus(CompanyPageStatus.INACTIVE);
        return true;
    }

    public boolean enablePage(CompanyPage page) {
        page.setStatus(CompanyPageStatus.ACTIVE);
        return true;
    }

    public boolean deleteGroup(Group group) {
        // Logic to delete group
        group.setStatus(GroupStatus.DELETED);
        return true;
    }

    // Additional functions
    public boolean removeJobPosting(Job job) {
        job.getCompany().deleteJobPosting(job);
        return true;
    }

    public boolean removePost(Post post) {
        post.getPostOwner().deletePost(post);
        return true;
    }

//    public boolean removeComment(Comment comment) {
//        // Logic to remove comment from post or parent comment
//        if (comment.getParentPost() != null) {
//            comment.getParentPost().removeComment(comment);
//        } else if (comment.getParentComment() != null) {
//            comment.getParentComment().removeReply(comment);
//        }
//        return true;
//    }

    public boolean removeComment(Comment comment) {
        Post parentPost = comment.getParentPost();
        if (parentPost != null) {
            parentPost.getComments().remove(comment);
        } else {
            Comment parentComment = comment.getParentComment();
            if (parentComment != null) {
                parentComment.getComments().remove(comment);
            }
        }
        return true;
    }
}
