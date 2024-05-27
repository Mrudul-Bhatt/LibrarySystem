package com.example.LibrarySystem.LinkedinSystem.System3;

import com.example.LibrarySystem.LinkedinSystem.System3.Account_Address.Account;
import com.example.LibrarySystem.LinkedinSystem.System3.Account_Address.Address;
import com.example.LibrarySystem.LinkedinSystem.System3.CompanyPage_Job_Group.CompanyPage;
import com.example.LibrarySystem.LinkedinSystem.System3.CompanyPage_Job_Group.Group;
import com.example.LibrarySystem.LinkedinSystem.System3.CompanyPage_Job_Group.Job;
import com.example.LibrarySystem.LinkedinSystem.System3.Enums.AccountStatus;
import com.example.LibrarySystem.LinkedinSystem.System3.Enums.JobStatus;
import com.example.LibrarySystem.LinkedinSystem.System3.Person_Admin_User.User;
import com.example.LibrarySystem.LinkedinSystem.System3.Post_Comment_Message_Invitation.Post;

import java.util.Date;

public class Main {
    public static void main(String[] args) {
        // Create Address objects
        Address address1 = new Address(12345, "123 Main St", "Springfield", "IL", "USA");
        Address address2 = new Address(67890, "456 Elm St", "Metropolis", "NY", "USA");

        // Create Account objects
        Account account1 = new Account("acc1", "password1", "user1", "user1@example.com", AccountStatus.ACTIVE);
        Account account2 = new Account("acc2", "password2", "user2", "user2@example.com", AccountStatus.ACTIVE);

        // Create User objects
        User user1 = new User(1, "John Doe", address1, "john.doe@example.com", "123-456-7890",
                account1, new Date());
        User user2 = new User(2, "Jane Smith", address2, "jane.smith@example.com", "098-765-4321",
                account2, new Date());

        // Create CompanyPage objects
        CompanyPage companyPage1 = new CompanyPage(1, "TechCorp", "Innovative tech solutions", "Technology", 500,
                user1);
        CompanyPage companyPage2 = new CompanyPage(2, "HealthPlus", "Healthcare services",
                "Healthcare", 300, user2);

        // Create Group objects
        Group group1 = new Group(1, "Tech Enthusiasts", "Group for technology enthusiasts");
        Group group2 = new Group(2, "Healthcare Professionals", "Group for healthcare " +
                "professionals");

        // Simulate users following companies
        user1.followCompany(companyPage1);
        user2.followCompany(companyPage1);
        user1.followCompany(companyPage2);

        // Simulate users joining groups
        user1.joinGroup(group1);
        user2.joinGroup(group1);
        user1.joinGroup(group2);

        // Simulate posting a job on a company page
        Job job1 = new Job(1, "Software Engineer", new Date(), "Develop software solutions",
                companyPage1, "Full-time",
                address1, JobStatus.OPEN);
        companyPage1.createJobPosting(job1);

        // Simulate updating group description
        group1.updateDescription("Updated description for Tech Enthusiasts");

        // Simulate adding a post in a group
        Post post1 = new Post(1, user1, "Welcome to the Tech Enthusiasts group!");
        user1.createPost(post1);

        // Users should receive notifications for the activities they are subscribed to
        // Output will be shown on the console
    }
}
