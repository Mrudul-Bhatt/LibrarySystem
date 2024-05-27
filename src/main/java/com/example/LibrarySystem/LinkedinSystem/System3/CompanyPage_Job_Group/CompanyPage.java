package com.example.LibrarySystem.LinkedinSystem.System3.CompanyPage_Job_Group;

import com.example.LibrarySystem.LinkedinSystem.System3.DesignPatterns.Observer.Observer;
import com.example.LibrarySystem.LinkedinSystem.System3.DesignPatterns.Observer.Subject;
import com.example.LibrarySystem.LinkedinSystem.System3.Enums.CompanyPageStatus;
import com.example.LibrarySystem.LinkedinSystem.System3.Enums.JobStatus;
import com.example.LibrarySystem.LinkedinSystem.System3.Person_Admin_User.User;
import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
public class CompanyPage implements Subject {
    private int pageId;
    private String name;
    private String description;
    private String type;
    private int companySize;
    private User createdBy;
    private List<Job> jobs = new ArrayList<>();
    private CompanyPageStatus status;
    private List<Observer> subscribers = new ArrayList<>();

    public CompanyPage(int pageId, String name, String description, String type, int companySize, User createdBy) {
        this.pageId = pageId;
        this.name = name;
        this.description = description;
        this.type = type;
        this.companySize = companySize;
        this.createdBy = createdBy;
    }

    @Override
    public void attach(Observer observer) {
        subscribers.add(observer);
    }

    @Override
    public void detach(Observer observer) {
        subscribers.remove(observer);
    }

    @Override
    public void notifyObservers(String message) {
        for (Observer subscriber : subscribers) {
            subscriber.update(message);
        }
    }

    public boolean createJobPosting(Job job) {
        jobs.add(job);
        notifyObservers("New job posted: " + job.getJobTitle());
        return true;
    }

    public void deleteJobPosting(Job job) {
        jobs.remove(job);
    }

    public boolean updateDescription(String newDescription) {
        this.description = newDescription;
        return true;
    }

    public Job getJobById(int jobId) {
        for (Job job : jobs) {
            if (job.getJobId() == jobId) {
                return job;
            }
        }
        return null;
    }

    public List<Job> getAllOpenJobs() {
        List<Job> openJobs = new ArrayList<>();
        for (Job job : jobs) {
            if (job.getStatus() == JobStatus.OPEN) {
                openJobs.add(job);
            }
        }
        return openJobs;
    }

}
