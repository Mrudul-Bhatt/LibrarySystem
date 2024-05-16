package com.example.LibrarySystem.FacebookSystem.System3;

import com.example.LibrarySystem.FacebookSystem.System3.Address_Acc_Person_User_Admin.User;
import com.example.LibrarySystem.FacebookSystem.System3.Page_Post_Comment.Comment;
import com.example.LibrarySystem.FacebookSystem.System3.Page_Post_Comment.Page;
import com.example.LibrarySystem.FacebookSystem.System3.Page_Post_Comment.Post;

public class Main {
    public static void main(String[] args) {
        // Create some users
        User user1 = new User("User 1", new Address(), "user1@example.com", "1234567890", new Account());
        User user2 = new User("User 2", new Address(), "user2@example.com", "9876543210", new Account());

        // Send friend request from user1 to user2
        user1.sendFriendRequest(user2);

        // User2 accepts the friend request
        user2.acceptFriendRequest(user1.getSentFriendRequests().get(0));

        // Create a page
        Page page = user1.createPage("Page 1");

        // User2 likes the page
        user2.likePage(page);

        // User1 creates a post on the page
        Post post = page.createPost("This is a test post.");

        // User2 likes the post
        user2.likePost(post);

        // User1 creates a comment on the post
        Comment comment = user1.createComment(post, "Nice post!");

        // User2 likes the comment
        user2.likeComment(comment);

        // Print user1's friends
        System.out.println("User 1's friends: " + user1.getFriends());

        // Print user1's pages
        System.out.println("User 1's pages: " + user1.getPagesAdmin());

        // Print user2's liked pages
        System.out.println("User 2's liked pages: " + user2.getProfile().getPagesFollowed());

        // Print page's posts
        System.out.println("Page 1's posts: " + page.getPosts());

        // Print post's comments
        System.out.println("Post 1's comments: " + post.getComments());
    }
}
