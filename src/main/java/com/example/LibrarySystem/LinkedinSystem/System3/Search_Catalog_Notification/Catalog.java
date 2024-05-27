package com.example.LibrarySystem.LinkedinSystem.System3.Search_Catalog_Notification;

import com.example.LibrarySystem.LinkedinSystem.System3.CompanyPage_Job_Group.CompanyPage;
import com.example.LibrarySystem.LinkedinSystem.System3.CompanyPage_Job_Group.Group;
import com.example.LibrarySystem.LinkedinSystem.System3.CompanyPage_Job_Group.Job;
import com.example.LibrarySystem.LinkedinSystem.System3.Person_Admin_User.User;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Catalog implements Search {
    private final Map<String, List<User>> users = new HashMap<>();
    private final Map<String, List<CompanyPage>> companies = new HashMap<>();
    private final Map<String, List<Group>> groups = new HashMap<>();
    private final Map<String, List<Job>> jobs = new HashMap<>();

    public void addNewUser(User user) {
        String name = user.getName().toLowerCase();
        users.computeIfAbsent(name, k -> new ArrayList<>()).add(user);
    }

    public void removeUser(User user) {
        String name = user.getName().toLowerCase();
        List<User> userList = users.get(name);
        if (userList != null) {
            userList.remove(user);
            if (userList.isEmpty()) {
                users.remove(name);
            }
        }
    }

    public void addNewCompany(CompanyPage company) {
        String name = company.getName().toLowerCase();
        companies.computeIfAbsent(name, k -> new ArrayList<>()).add(company);
    }

    public void removeCompany(CompanyPage company) {
        String name = company.getName().toLowerCase();
        List<CompanyPage> companyList = companies.get(name);
        if (companyList != null) {
            companyList.remove(company);
            if (companyList.isEmpty()) {
                companies.remove(name);
            }
        }
    }

    public void addNewGroup(Group group) {
        String name = group.getName().toLowerCase();
        groups.computeIfAbsent(name, k -> new ArrayList<>()).add(group);
    }

    public void removeGroup(Group group) {
        String name = group.getName().toLowerCase();
        List<Group> groupList = groups.get(name);
        if (groupList != null) {
            groupList.remove(group);
            if (groupList.isEmpty()) {
                groups.remove(name);
            }
        }
    }

    public void addNewJob(Job job) {
        String title = job.getJobTitle().toLowerCase();
        jobs.computeIfAbsent(title, k -> new ArrayList<>()).add(job);
    }

    public void removeJob(Job job) {
        String title = job.getJobTitle().toLowerCase();
        List<Job> jobList = jobs.get(title);
        if (jobList != null) {
            jobList.remove(job);
            if (jobList.isEmpty()) {
                jobs.remove(title);
            }
        }
    }

    @Override
    public List<User> searchUser(String name) {
        return users.getOrDefault(name.toLowerCase(), new ArrayList<>());
    }

    @Override
    public List<CompanyPage> searchCompany(String name) {
        return companies.getOrDefault(name.toLowerCase(), new ArrayList<>());
    }

    @Override
    public List<Group> searchGroup(String name) {
        return groups.getOrDefault(name.toLowerCase(), new ArrayList<>());
    }

    @Override
    public List<Job> searchJob(String title) {
        return jobs.getOrDefault(title.toLowerCase(), new ArrayList<>());
    }

    public List<User> searchUserByPartialName(String partialName) {
        List<User> result = new ArrayList<>();
        String lowerPartialName = partialName.toLowerCase();
        for (String key : users.keySet()) {
            if (key.contains(lowerPartialName)) {
                result.addAll(users.get(key));
            }
        }
        return result;
    }

    public List<CompanyPage> searchCompanyByPartialName(String partialName) {
        List<CompanyPage> result = new ArrayList<>();
        String lowerPartialName = partialName.toLowerCase();
        for (String key : companies.keySet()) {
            if (key.contains(lowerPartialName)) {
                result.addAll(companies.get(key));
            }
        }
        return result;
    }

    public List<Group> searchGroupByPartialName(String partialName) {
        List<Group> result = new ArrayList<>();
        String lowerPartialName = partialName.toLowerCase();
        for (String key : groups.keySet()) {
            if (key.contains(lowerPartialName)) {
                result.addAll(groups.get(key));
            }
        }
        return result;
    }

    public List<Job> searchJobByPartialTitle(String partialTitle) {
        List<Job> result = new ArrayList<>();
        String lowerPartialTitle = partialTitle.toLowerCase();
        for (String key : jobs.keySet()) {
            if (key.contains(lowerPartialTitle)) {
                result.addAll(jobs.get(key));
            }
        }
        return result;
    }
}
