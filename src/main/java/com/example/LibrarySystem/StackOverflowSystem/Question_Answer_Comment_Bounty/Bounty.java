package com.example.LibrarySystem.StackOverflowSystem.Question_Answer_Comment_Bounty;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;

@Getter
@Setter
@AllArgsConstructor
public class Bounty {
    private int reputationPoints;
    private Date expiryDate;

    public boolean updateReputationPoints(int reputation) {
        this.reputationPoints += reputation;
        return true; // Example implementation; you might want to add logic to handle invalid updates
    }

}
