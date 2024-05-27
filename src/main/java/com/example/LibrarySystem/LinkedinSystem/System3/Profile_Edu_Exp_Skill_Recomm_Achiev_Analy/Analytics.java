package com.example.LibrarySystem.LinkedinSystem.System3.Profile_Edu_Exp_Skill_Recomm_Achiev_Analy;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Analytics {
    private int searchAppearances;
    private int profileViews;
    private int postImpressions;
    private int totalConnections;

    public void incrementSearchAppearances() {
        this.searchAppearances++;
    }

    public void incrementProfileViews() {
        this.profileViews++;
    }

    public void incrementPostImpressions() {
        this.postImpressions++;
    }

    public void updateTotalConnections(int newTotalConnections) {
        this.totalConnections = newTotalConnections;
    }

    public void resetAnalytics() {
        this.searchAppearances = 0;
        this.profileViews = 0;
        this.postImpressions = 0;
        this.totalConnections = 0;
    }
}
