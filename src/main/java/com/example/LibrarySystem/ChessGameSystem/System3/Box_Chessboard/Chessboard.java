package com.example.LibrarySystem.ChessGameSystem.System3.Box_Chessboard;

import java.util.Date;
import java.util.List;

import com.example.LibrarySystem.ChessGameSystem.System3.Acc_Player_Admin_Person.Player;
import com.example.LibrarySystem.ChessGameSystem.System3.Move.Move;
import com.example.LibrarySystem.ChessGameSystem.System3.Piece_Types.Piece;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Chessboard {
    private Box[][] boxes;
    private Date creationDate;

    public Chessboard(int rows, int columns) {
        this.boxes = new Box[rows][columns];
        initializeBoard();
    }

    private void initializeBoard() {
        for (int i = 0; i < boxes.length; i++) {
            for (int j = 0; j < boxes[i].length; j++) {
                boxes[i][j] = new Box(null, i, j);
            }
        }
    }

    public void resetBoard() {
        initializeBoard();
    }

    public void updateBoard() {
        // Update the graphical representation of the board (not implemented)
    }

    public Box getBox(int x, int y) {
        return boxes[x][y];
    }

    public void setPieceAt(Box box, Piece piece) {
        box.setPiece(piece);
    }

    public void removePieceAt(Box box) {
        box.setPiece(null);
    }

    public List<Piece> getPieces() {
    }

    public boolean makeMove(Move move, Player player) {
        Box start = move.getStart();
        Box end = move.getEnd();
        Piece pieceMoved = move.getPieceMoved();
        Piece pieceKilled = move.getPieceKilled();

        // Validate the move
        if (!isValidMove(move, player)) {
            return false;
        }

        // Make the move
        end.setPiece(pieceMoved);
        start.setPiece(null);

        // Check if the move resulted in a capture
        if (pieceKilled != null) {
            pieceKilled.setKilled(true);
        }

        return true;
    }
}
