package com.example.LibrarySystem.JigsawPuzzleSystem.System3;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Side {
    private Edge edge;
    private String curvature; // Assuming curvature is a string that represents the unique shape

    public Side(Edge edge, String curvature) {
        this.edge = edge;
        this.curvature = curvature;
    }
    
    public boolean matches(Side other) {
        if (this.edge == Edge.FLAT || other.edge == Edge.FLAT) {
            return false;
        }
        return (this.edge == Edge.INDENTATION && other.edge == Edge.EXTRUSION &&
                this.curvature.equals(other.curvature)) ||
                (this.edge == Edge.EXTRUSION && other.edge == Edge.INDENTATION &&
                        this.curvature.equals(other.curvature));
    }

}
