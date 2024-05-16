package com.example.LibrarySystem.FacebookSystem.System3.Profile_Privacy_Education_Places_Work;

public class ProfilePrivacy {
    public void changeFriendsListVisibility(Profile profile, boolean visible) {
        // Logic to change the visibility of the friends list in the profile
        profile.setFriendsListVisible(visible);
    }

    public void lockProfile(Profile profile) {
        // Logic to lock the profile, making it private
        profile.setProfileLocked(true);
    }

    public void lockProfilePicture(Profile profile) {
        // Logic to lock the profile picture, making it visible only to friends or private
        profile.setProfilePictureLocked(true);
    }
}
