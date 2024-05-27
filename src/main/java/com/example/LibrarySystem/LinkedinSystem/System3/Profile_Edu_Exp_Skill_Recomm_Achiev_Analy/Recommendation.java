package com.example.LibrarySystem.LinkedinSystem.System3.Profile_Edu_Exp_Skill_Recomm_Achiev_Analy;

import lombok.Getter;
import lombok.Setter;

import java.util.Date;

@Getter
@Setter
public class Recommendation {
    private String recommendationId;
    private int userId;
    private Date createdOn;
    private String description;
    private boolean isAccepted;

    public boolean acceptRecommendation() {
        if (!isAccepted) {
            this.isAccepted = true;
            return true;
        }
        return false;
    }

    public boolean rejectRecommendation() {
        if (isAccepted) {
            this.isAccepted = false;
            return true;
        }
        return false;
    }
}
