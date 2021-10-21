import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

// ContainerPanel class for CE203 Assignment to use and modify if needed
// Date: 12/10/2021
// Author: F. Doctor

public class ContainerPanel extends JPanel{

    ArrayList<Cuboid> cuboids;   // Cuboid container object instance
    Cuboid cur = null;
    int count = 0;

    public ContainerPanel() {

        // When you modify the Cuboid container constructor this line will need to be changed
        // The values for the width/height and length of the cuboid are hard coded below
        // These should be input from the application text fields where the user would type them in.
        cuboids = new ArrayList<>();
    }

    public void addCuboid(int id, int[] dims, Color c) {
        Cuboid tmp = new Cuboid(id, dims, c);
        cuboids.add(tmp);
    }

    public Cuboid getCuboid(int id) {
        if (id >= count || id < 0) return null;
        for (Cuboid cuboid : cuboids) {
            if (cuboid.getID() == id) return cuboid;
        }
        return null;
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        if (cur != null) cur.draw(g);
    }
}
