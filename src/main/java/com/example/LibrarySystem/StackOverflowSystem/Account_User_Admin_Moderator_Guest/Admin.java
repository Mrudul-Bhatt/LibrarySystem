package com.example.LibrarySystem.StackOverflowSystem.Account_User_Admin_Moderator_Guest;

import com.example.LibrarySystem.StackOverflowSystem.Badge_Tag_TagList.Badge;
import com.example.LibrarySystem.StackOverflowSystem.Enums.AccountStatus;

import java.util.List;

public class Admin extends User {

    public Admin(int reputationPoints, Account account, List<Badge> badges) {
        super(reputationPoints, account, badges);
    }

    public boolean blockUser(User user) {
        if (user != null) {
            user.getAccount().setStatus(AccountStatus.BLOCKED);
            return true;
        }
        return false;
    }

    public boolean unblockUser(User user) {
        if (user != null) {
            user.getAccount().setStatus(AccountStatus.ACTIVE);
            return true;
        }
        return false;
    }

    public void awardBadge(User user, Badge badge) {
        if (user != null && badge != null) {
            user.getBadges().add(badge);
        }
    }
}
