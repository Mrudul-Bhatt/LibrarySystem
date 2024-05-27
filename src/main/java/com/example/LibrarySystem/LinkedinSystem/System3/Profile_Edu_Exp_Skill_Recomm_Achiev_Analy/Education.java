package com.example.LibrarySystem.LinkedinSystem.System3.Profile_Edu_Exp_Skill_Recomm_Achiev_Analy;

import lombok.Getter;
import lombok.Setter;

import java.util.Date;

@Getter
@Setter
public class Education {
    private String educationId;
    private String school;
    private String degree;
    private Date startDate;
    private Date endDate;
    private String description;
}
