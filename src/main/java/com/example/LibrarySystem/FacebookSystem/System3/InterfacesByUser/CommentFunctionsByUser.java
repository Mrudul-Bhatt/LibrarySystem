package com.example.LibrarySystem.FacebookSystem.System3.InterfacesByUser;

import com.example.LibrarySystem.FacebookSystem.System3.Page_Post_Comment.Comment;
import com.example.LibrarySystem.FacebookSystem.System3.Page_Post_Comment.Post;

public interface CommentFunctionsByUser {
    public Comment createComment(Post post, String content);

    public void likeComment(Comment comment);
}
