package com.example.LibrarySystem.JigsawPuzzleSystem.System3;

import lombok.Getter;
import lombok.Setter;

import java.util.Arrays;
import java.util.List;

@Getter
@Setter
public class Piece {
    private List<Side> sides;

    public Piece(Side top, Side right, Side bottom, Side left) {
        sides = Arrays.asList(top, right, bottom, left);
    }

    public boolean checkCorner() {
        int flatCount = (int) sides.stream().filter(side -> side.getEdge() == Edge.FLAT).count();
        return flatCount == 2;
    }

    public boolean checkEdge() {
        int flatCount = (int) sides.stream().filter(side -> side.getEdge() == Edge.FLAT).count();
        return flatCount == 1;
    }

    public boolean checkMiddle() {
        int flatCount = (int) sides.stream().filter(side -> side.getEdge() == Edge.FLAT).count();
        return flatCount == 0;
    }

    public boolean fitsWith(Piece other, int sideIndex) {
        Side thisSide = this.sides.get(sideIndex);
        Side otherSide = other.sides.get((sideIndex + 2) % 4);
        return thisSide.matches(otherSide);
    }
}
