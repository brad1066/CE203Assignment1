import java.awt.*;

// Incomplete CuboidContainer class for CE203 Assignment
// Date: 12/10/2021
// Author: F. Doctor

public class Cuboid implements Comparable<Cuboid> {

    int id;  // Cuboid id should be a six digit non-negative integer with no leading 0s
    final int[] pos = {25, 150}; // x, y coords of the top left point of the first face of the cuboid;
    int[] dims; // height/width, length of Cuboid
    Color c;

    Point[] faceOne; // Points array used to store vertices (points) of first face of the cuboid
    Point[] faceTwo; // Points array used to store vertices (points) of second  face of the cuboid

    // constructor currently set the dimensions of the cuboid to be drawn. This should be modifed
    // to set the Id field and the colour. You might need to also include a handle to the top level
    // JFrame object see examples in Unit 2
    public Cuboid(int id, int[] dims, Color c) {
        this.id = id;
        this.dims = dims;
        this.c = c;
        this.faceOne = getCubeOnePoints();
        this.faceTwo = getCubeTwoPoints();
    }

    // used to populate the points array with the vertices (corners/points) of first face of the cuboid
    private Point[] getCubeOnePoints() {
        return new Point[]{
                new Point(pos[0], pos[1]),
                new Point(pos[0] + this.dims[0], pos[1]),
                new Point(pos[0] + this.dims[0], pos[1] + this.dims[0]),
                new Point(pos[0], pos[1] + this.dims[0])
        };
    }

    // used to populate the points array with the vertices of the second face of the cuboid
    // using the example of the first face complete the remainder of the code to produce an
    // output cuboid as shown in the assignment script
    private Point[] getCubeTwoPoints() {
        int newX = pos[0] + this.dims[1];
        int newY = pos[1] + this.dims[1];
        return new Point[]{
                new Point(newX, newY),
                new Point(newX + this.dims[0], newY),
                new Point(newX + this.dims[0], newY + this.dims[0]),
                new Point(newX, newY + this.dims[0])
        };
    }

    // You will need to modify this method to set the colour of the Cuboid to be drawn
    // you will also need to complete the For loop to draw the lines connecting each face of the cuboid
    public void draw(Graphics g) {

        g.drawRect(pos[0], pos[1], this.dims[0], this.dims[0]);
        g.drawRect(pos[0] + this.dims[1], pos[1] + this.dims[1], this.dims[0], this.dims[0]);

        // to complete..., draw connecting lines by looping through both points arrays and using the graphics drawline() method
        for (int i = 0; i < 4; i++) {
            g.drawLine(faceOne[i].x, faceOne[i].y, faceTwo[i].x, faceTwo[i].y);
        }
    }


    // gets a stored ID
    public int getID() {
        return id;
    }


    @Override
    // method used for comparing Cuboid Container objects based on stored ids, you need to complete the method
    public int compareTo(Cuboid o) {
        return 0;
    }


    // outputs a string representation of the cuboid container object which can be used for testing
    public String toString() {
        return "Cuboid Data:" +
                "\n\tFace Width/height: " + dims[0] +
                "\n\tLength: " + dims[1] +
                "\n\tColour: " + c.toString() + "\n";
    }
}
