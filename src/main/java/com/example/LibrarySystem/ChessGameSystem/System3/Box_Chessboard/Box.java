package com.example.LibrarySystem.ChessGameSystem.System3.Box_Chessboard;

import com.example.LibrarySystem.ChessGameSystem.System3.Piece_Types.Piece;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Box {
    private Piece piece;
    private int x;
    private int y;

    public Box(Piece piece, int x, int y) {
        this.piece = piece;
        this.x = x;
        this.y = y;
    }
}
