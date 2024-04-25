package com.example.LibrarySystem.ChessGameSystem.System3.Piece_Types;

import com.example.LibrarySystem.ChessGameSystem.System3.Box_Chessboard.Box;
import com.example.LibrarySystem.ChessGameSystem.System3.Box_Chessboard.Chessboard;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public abstract class Piece {
    private boolean killed = false;
    private boolean white = false;

    public Piece(boolean white) {
        this.white = white;
    }

    public abstract boolean canMove(Chessboard board, Box start, Box end);
}
