import java.awt.*;

// Incomplete CuboidContainer class for CE203 Assignment
// Date: 12/10/2021
// Author: F. Doctor

public class CuboidContainer implements Comparable<CuboidContainer> {

    int id;  // Cuboid id should be a six digit non-negative integer with no leading 0s
    final int[] pos = {25, 25}; // x, y coords of the top left point of the first face of the cuboid;
    int[] dims; // height/width, length of Cuboid
    Color c;

    Point[] faceOnePoints; // Points array used to store vertices (points) of first face of the cuboid
    Point[] faceTwoPoints; // Points array used to store vertices (points) of second  face of the cuboid

    // constructor currently set the dimensions of the cuboid to be drawn. This should be modifed
    // to set the Id field and the colour. You might need to also include a handle to the top level
    // JFrame object see examples in Unit 2
    public CuboidContainer(int id, int[] dims, Color c) {
        this.id = id;
        this.dims = dims;
        this.c = c;
        faceOnePoints = getCubeOnePoints();
        faceTwoPoints = getCubeTwoPoints();
    }

    // used to populate the points array with the vertices (corners/points) of first face of the cuboid
    private Point[] getCubeOnePoints() {
        return new Point[]{
                new Point(pos[0], pos[1]),
                new Point(pos[0] + this.dims[0], pos[1]),
                new Point(pos[0] + this.dims[0], pos[1] + this.dims[0]),
                new Point(pos[0], pos[1] + this.dims[1])
        };
    }

    // used to populate the points array with the vertices of the second face of the cuboid
    // using the example of the first face complete the remainder of the code to produce an
    // output cuboid as shown in the assignment script
    private Point[] getCubeTwoPoints() {
        int newX = pos[0] + this.dims[0];
        int newY = pos[1] + this.dims[0];
        return new Point[]{
                new Point(pos[0], pos[1]),
                new Point(pos[0] + this.dims[0], pos[1]),
                new Point(pos[0] + this.dims[0], pos[1] + this.dims[0]),
                new Point(pos[0], pos[1] + this.dims[1])
        };
    }

    // You will need to modify this method to set the colour of the Cuboid to be drawn
    // you will also need to complete the For loop to draw the lines connecting each face of the cuboid
    public void drawCuboid(Graphics g) {

        g.drawRect(pos[0], pos[1], this.dims[0], this.dims[0]);
        g.drawRect(pos[0] + this.dims[1], pos[1] + this.dims[1], this.dims[0], this.dims[0]);

        // to complete..., draw connecting lines by looping through both points arrays and using the graphics drawline() method

    }


    // gets a stored ID
    public int getID() {
        return id;
    }


    @Override
    // method used for comparing Cuboid Container objects based on stored ids, you need to complete the method
    public int compareTo(CuboidContainer o) {
        return 0;
    }


    // outputs a string representation of the cuboid container object which can be used for testing
    public String toString() {
        return "Cuboid Data:\n\tFace Width/height: " + dims[0] + "\n\tLength: " + dims[1] + "\n\tColour: " + c.toString()+"\n";
    }
}
