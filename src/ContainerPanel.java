import javax.swing.*;
import java.awt.*;

// ContainerPanel class for CE203 Assignment to use and modify if needed
// Date: 12/10/2021
// Author: F. Doctor

public class ContainerPanel extends JPanel{

    CuboidContainer cuboid;   // Cuboid container object instance

    public ContainerPanel() {

        // When you modify the Cuboid container constructor this line will need to be changed
        // The values for the width/height and length of the cuboid are hard coded below
        // These should be input from the application text fields where the user would type them in.
        cuboid = new CuboidContainer(1, new int[]{100, 200}, Color.red);
    }


    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        cuboid.drawCuboid(g);
    }
}
