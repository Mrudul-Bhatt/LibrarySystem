package com.example.LibrarySystem.LinkedinSystem.System3.CompanyPage_Job_Group;

import com.example.LibrarySystem.LinkedinSystem.System3.Account_Address.Address;
import com.example.LibrarySystem.LinkedinSystem.System3.Enums.JobStatus;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;

@Getter
@Setter
public class Job {
    private int jobId;
    private String jobTitle;
    private Date dateOfPosting;
    private String description;
    private CompanyPage company;
    private String employmentType;
    private Address location;
    private JobStatus status;

    public Job(int jobId, String jobTitle, Date dateOfPosting, String description, CompanyPage company,
               String employmentType, Address location) {
        this.jobId = jobId;
        this.jobTitle = jobTitle;
        this.dateOfPosting = dateOfPosting;
        this.description = description;
        this.company = company;
        this.employmentType = employmentType;
        this.location = location;
        this.status = JobStatus.OPEN;
    }

    public boolean updateJobTitle(String newJobTitle) {
        this.jobTitle = newJobTitle;
        return true;
    }

    public boolean updateDescription(String newDescription) {
        this.description = newDescription;
        return true;
    }

    public boolean updateEmploymentType(String newEmploymentType) {
        this.employmentType = newEmploymentType;
        return true;
    }

    public boolean updateLocation(Address newLocation) {
        this.location = newLocation;
        return true;
    }

    public boolean closeJobPosting() {
        if (this.status == JobStatus.OPEN) {
            this.status = JobStatus.CLOSED;
            return true;
        }
        return false;
    }

    public boolean reopenJobPosting() {
        if (this.status == JobStatus.CLOSED) {
            this.status = JobStatus.OPEN;
            return true;
        }
        return false;
    }

}
