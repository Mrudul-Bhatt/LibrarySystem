package com.example.LibrarySystem.FacebookSystem.System3.Profile_Privacy_Education_Places_Work;

import java.util.List;

import com.example.LibrarySystem.FacebookSystem.System3.Address_Acc_Person_User_Admin.User;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class Profile {
    private String gender;
    private byte[] profilePicture;
    private byte[] coverPhoto;
    private List<User> friends;

    private List<Integer> usersFollowed;
    private List<Integer> pagesFollowed;
    private List<Integer> groupsJoined;

    private List<Work> workExperience;
    private List<Education> educationInfo;
    private List<Place> places;

    public boolean addWorkExperience(Work work);

    public boolean addEducation(Education education);

    public boolean addPlace(Place place);

    public boolean addProfilePicture(byte[] image);

    public boolean addCoverPhoto(byte[] image);

    public boolean addGender(String gender);
}
