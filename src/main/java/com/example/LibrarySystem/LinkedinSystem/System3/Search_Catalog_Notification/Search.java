package com.example.LibrarySystem.LinkedinSystem.System3.Search_Catalog_Notification;

import com.example.LibrarySystem.LinkedinSystem.System3.CompanyPage_Job_Group.CompanyPage;
import com.example.LibrarySystem.LinkedinSystem.System3.CompanyPage_Job_Group.Group;
import com.example.LibrarySystem.LinkedinSystem.System3.CompanyPage_Job_Group.Job;
import com.example.LibrarySystem.LinkedinSystem.System3.Person_Admin_User.User;

import java.util.List;


public interface Search {
    public List<User> searchUser(String name);

    public List<CompanyPage> searchCompany(String name);

    public List<Group> searchGroup(String name);

    public List<Job> searchJob(String title);
}
