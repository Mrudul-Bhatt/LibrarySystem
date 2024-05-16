package com.example.LibrarySystem.FacebookSystem.System3.Profile_Privacy_Education_Places_Work;

import com.example.LibrarySystem.FacebookSystem.System3.Address_Acc_Person_User_Admin.User;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@AllArgsConstructor
public class Profile {
    private String gender;
    private byte[] profilePicture;
    private byte[] coverPhoto;
    private List<User> friends;

    private boolean friendsListVisible;
    private boolean profileLocked;
    private boolean profilePictureLocked;
    
    private List<Integer> usersFollowed;
    private List<Integer> pagesFollowed;
    private List<Integer> groupsJoined;

    private List<Work> workExperience;
    private List<Education> educationInfo;
    private List<Place> places;

    public boolean addWorkExperience(Work work) {
        return workExperience.add(work);
    }

    public boolean addEducation(Education education) {
        return educationInfo.add(education);
    }

    public boolean addPlace(Place place) {
        return places.add(place);
    }

}
