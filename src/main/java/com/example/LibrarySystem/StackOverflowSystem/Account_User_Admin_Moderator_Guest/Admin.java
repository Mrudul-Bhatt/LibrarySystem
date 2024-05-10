package com.example.LibrarySystem.StackOverflowSystem.Account_User_Admin_Moderator_Guest;

import com.example.LibrarySystem.StackOverflowSystem.Badge_Tag_TagList.Badge;

public class Admin extends User {
    public boolean blockUser(User user);

    public boolean unblockUser(User user);

    public void awardBadge(User user, Badge badge);
}
