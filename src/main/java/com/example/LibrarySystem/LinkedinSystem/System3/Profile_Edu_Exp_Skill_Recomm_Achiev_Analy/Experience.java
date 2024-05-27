package com.example.LibrarySystem.LinkedinSystem.System3.Profile_Edu_Exp_Skill_Recomm_Achiev_Analy;

import com.example.LibrarySystem.LinkedinSystem.System3.Account_Address.Address;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;

@Getter
@Setter
public class Experience {
    private String experienceId;
    private String title;
    private String company;
    private Address location;
    private Date startDate;
    private Date endDate;
    private String description;
}
