package com.example.LibrarySystem.StackOverflowSystem.Question_Answer_Comment_Bounty;

import lombok.Getter;
import lombok.Setter;

import java.util.Date;

@Getter
@Setter
public class Bounty {
    private int reputationPoints;
    private Date expiryDate;

    public boolean updateReputationPoints(int reputation);
}
