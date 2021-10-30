import java.awt.*;

// 2004820

public class Cuboid implements Comparable<Cuboid> {

    private final int id;  // Cuboid id should be a six digit non-negative integer with no leading 0s
    private final int[] pos = {25, 25}; // x, y coords of the top left point of the first face of the cuboid;
    private final int[] dims; // height/width, length of Cuboid
    private final Color c;

    private final Point[] faceOne; // Points array used to store vertices (points) of first face of the cuboid
    private final Point[] faceTwo; // Points array used to store vertices (points) of second  face of the cuboid

    // Constructor accepting an ID, dimensions and Color
    public Cuboid(int id, int[] dims, Color c) {
        // Set values of the object attributes
        this.id = id;
        this.dims = dims;
        this.c = c;
        this.faceOne = getCubeOnePoints();
        this.faceTwo = getCubeTwoPoints();
    }

    // Used to populate the points array with the vertices of the first face of the cuboid
    private Point[] getCubeOnePoints() {
        return new Point[]{
                new Point(pos[0], pos[1]),
                new Point(pos[0] + this.dims[0], pos[1]),
                new Point(pos[0] + this.dims[0], pos[1] + this.dims[0]),
                new Point(pos[0], pos[1] + this.dims[0])
        };
    }

    // Used to populate the points array with the vertices of the second face of the cuboid
    private Point[] getCubeTwoPoints() {
        // Offset the x, y coords by the length
        int newX = pos[0] + this.dims[1];
        int newY = pos[1] + this.dims[1];

        return new Point[]{
                new Point(newX, newY),
                new Point(newX + this.dims[0], newY),
                new Point(newX + this.dims[0], newY + this.dims[0]),
                new Point(newX, newY + this.dims[0])
        };
    }

    public void draw(Graphics g) {
        // Set the color of the lines and draw the faces of the cuboid
        g.setColor(c);
        g.drawRect(pos[0], pos[1], this.dims[0], this.dims[0]);
        g.drawRect(pos[0] + this.dims[1], pos[1] + this.dims[1], this.dims[0], this.dims[0]);

        // Draw connecting lines by looping through both points arrays and using the graphics drawline() method
        for (int i = 0; i < 4; i++) {
            g.drawLine(faceOne[i].x, faceOne[i].y, faceTwo[i].x, faceTwo[i].y);
        }
    }

    // Gets a stored ID
    public int getID() {
        return id;
    }

    @Override
    // Compares Cuboid objects based on stored ids
    public int compareTo(Cuboid o) {
        return id - o.getID();
    }

    // Outputs a string representation of this
    public String toString() {
        return "Cuboid Data:" +
                "\n\tID: " + id +
                "\n\tFace Width/height: " + dims[0] +
                "\n\tLength: " + dims[1] +
                "\n\tColour: " + c.toString() + "\n";
    }
}
