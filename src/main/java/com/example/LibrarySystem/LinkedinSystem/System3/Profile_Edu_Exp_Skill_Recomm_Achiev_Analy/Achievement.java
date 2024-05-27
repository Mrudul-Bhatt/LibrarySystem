package com.example.LibrarySystem.LinkedinSystem.System3.Profile_Edu_Exp_Skill_Recomm_Achiev_Analy;

import lombok.Getter;
import lombok.Setter;

import java.util.Date;

@Getter
@Setter
public class Achievement {
    private String achievementId;
    private String title;
    private Date dateAwarded;
    private String description;
}
