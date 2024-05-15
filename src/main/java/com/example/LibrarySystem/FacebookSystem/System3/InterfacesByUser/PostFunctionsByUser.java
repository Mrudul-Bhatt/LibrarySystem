package com.example.LibrarySystem.FacebookSystem.System3.InterfacesByUser;

import com.example.LibrarySystem.FacebookSystem.System3.Page_Post_Comment.Post;

public interface PostFunctionsByUser {
    public Post createPost(String content);

    public Post sharePost(Post post);

    public void commentOnPost(Post post);

    public void likePost(Post post);
}
