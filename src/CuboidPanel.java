import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

public class CuboidPanel extends JPanel {

    private final ArrayList<Cuboid> cuboids = new ArrayList<>();   // Cuboid container object instance
    private final Set<Integer> usedIDs = new HashSet<>();   // A set of the used IDs for checking against when adding new cuboids
    private Cuboid cur = null;  // The Cuboid that is currently displayed

    public boolean addCuboid(int id, int[] dims, Color c) {
        // Cuboid has already been used, then return a boolean false flag
        if (usedIDs.contains(id)) {
            System.out.println("A cuboid with an ID of "+id+" already exists, so a new one wasn't added.");
            return false;
        }

        // Add a cuboid given the provided parameters to the list, add the ID to the usedID set
        cuboids.add(new Cuboid(id, dims, c));
        usedIDs.add(id);

        // Set the current cuboid to the one with the given ID, and display a message
        setCur(id);
        System.out.println("Cuboid added successfully with ID: " + id);

        // Return a true flag once everything has been completed with no errors
        return true;
    }

    public Cuboid getCuboid(int id) {
        // If the ID has been used, search the list and return the cuboid with the matching ID
        if (usedIDs.contains(id)) {
            for (Cuboid cuboid : cuboids) {
                if (cuboid.getID() == id) return cuboid;
            }
        }

        // If no ID has been found, then return false
        System.out.println("No cuboid with an ID of "+id+" was found");
        return null;
    }

    public void listCuboids() {
        // Lists the cuboids in a meaningful way
        System.out.print("List of Cuboids: (");

        for (Cuboid c : cuboids) {
            System.out.print(c.getID()+", ");
        }
        System.out.println(")");
    }

    public void sortCuboids() {
        // Sorts the cuboids list
        Collections.sort(cuboids);
        System.out.println("List of Cuboids has been sorted:");
        System.out.println(cuboids);
    }

    public boolean setCur(int id) {
        // Attempt to retrieve a cuboid with the given ID
        Cuboid tmp = getCuboid(id);
        // If the id was invalid (tmp == null), return a false flag to signal this
        if (tmp == null) {
            System.out.println("As the provided ID was invalid, the current cuboid hasn't been changed");
            return false;
        }

        // Set the current cuboid to the temporary one, update the UI, print a message and return a true flag to signal success
        cur = tmp;
        updateUI();
        System.out.println("Cuboid with ID: " + id + " has been set");
        return true;
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        // If there is a cuboid associated with cur, draw it
        if (cur != null) cur.draw(g);
    }
}
