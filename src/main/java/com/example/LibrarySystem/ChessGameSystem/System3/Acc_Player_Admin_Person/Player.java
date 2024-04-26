package com.example.LibrarySystem.ChessGameSystem.System3.Acc_Player_Admin_Person;


import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Player {
    //    private Person person;
    private String name;
    private boolean whiteSide = false;
    private int totalGamesPlayed;

    public Player(String name, boolean whiteSide) {
        this.name = name;
        this.whiteSide = whiteSide;
    }

//    public boolean isWhiteSide();

//    public boolean isChecked();
}
