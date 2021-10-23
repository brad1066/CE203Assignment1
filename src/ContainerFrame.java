import javax.swing.*;
import java.awt.*;

public class ContainerFrame extends JFrame {

    private JTextField idInput;
    private JTextField colorInput;
    private JTextField heightWidthInput;
    private JTextField lengthInput;

    public void createComponents() {

        // Create Panels for Inputs, Cuboids and Panels
        JPanel inputsPanel = new JPanel(new GridLayout(2, 4));
        CuboidPanel cuboidPanel = new CuboidPanel();
        JPanel buttonsPanel = new JPanel();

        // Create Inputs
        idInput = new JTextField();
        colorInput = new JTextField();
        heightWidthInput = new JTextField();
        lengthInput = new JTextField();

        // Create buttons
        JButton addCuboidButton = new JButton("Add Cuboid");
        JButton displayCuboidsButton = new JButton("Display Cuboid data");
        JButton searchCuboidButton = new JButton("Recall Cuboid with ID");
        JButton sortCuboidsButton = new JButton("Sort cuboids by ID");

        // Add action listeners to each button
        addCuboidButton.addActionListener(e -> {
            // Check all the ways that a cuboid can fail being added, and throw an error if any are found
            try {
                if (idInput.getText().equals("")
                        || colorInput.getText().equals("")
                        || heightWidthInput.getText().equals("")
                        || lengthInput.getText().equals("")
                        || Integer.toString(getID()).length() != 6
                        || getID() < 0
                        || !cuboidPanel.addCuboid(getID(), getDims(), getColor())) {
                    throw new NumberFormatException();
                }
            } catch (NumberFormatException ex) {
                // On an error being found, return a dialog box to the user
                JOptionPane.showMessageDialog(null, "There was a problem adding your cuboid. Double check your inputs for any errors");
            }

        });
        displayCuboidsButton.addActionListener(e -> {
            // Make a call to the cuboidPanel to list cuboid data
            cuboidPanel.listCuboids();
        });
        searchCuboidButton.addActionListener(e -> {
            // Search for a cuboid with ID that is in the field. If found, display, otherwise, show message
            if (!cuboidPanel.setCur(getID())) {
                JOptionPane.showMessageDialog(null, "There was a problem finding your cuboid. Double check the ID, and try again");
            }
        });
        sortCuboidsButton.addActionListener(e -> {
            // Make a call to the cuboidPanel to sort the cuboids
            cuboidPanel.sortCuboids();
        });


        // Add labels and inputs to the input panel
        inputsPanel.add(new JLabel("ID (######):"));
        inputsPanel.add(idInput);
        inputsPanel.add(new JLabel("Color (RGB):"));
        inputsPanel.add(colorInput);
        inputsPanel.add(new JLabel("Height/Width (integer):"));
        inputsPanel.add(heightWidthInput);
        inputsPanel.add(new JLabel("Length (integer):"));
        inputsPanel.add(lengthInput);

        // Add buttons to the button panel
        buttonsPanel.add(addCuboidButton);
        buttonsPanel.add(displayCuboidsButton);
        buttonsPanel.add(searchCuboidButton);
        buttonsPanel.add(sortCuboidsButton);

        // Add Panels for Inputs, Cuboids and Panels
        add(inputsPanel, BorderLayout.NORTH);
        add(cuboidPanel, BorderLayout.CENTER);
        add(buttonsPanel, BorderLayout.SOUTH);

        // Set Application attributes
        setSize(600, 400);
        setVisible(true);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);    // Close action.
    }

    public static void main(String[] args) {
        ContainerFrame cFrame = new ContainerFrame();
        cFrame.createComponents();
    }

    private int getID() throws NumberFormatException {
        // Returns the ID of the idInput textfield as an int
        return Integer.parseInt(idInput.getText().replace(" ", ""));
    }

    private Color getColor() throws NumberFormatException {
        // Split the colorInput by commas, and removing spaces
        String[] rgbVals = colorInput.getText().replace(" ", "").split(",");
        // If there aren't three elements, throw an error
        if (rgbVals.length != 3) throw new NumberFormatException();
        // Extract the rbg vals to an int array of rgb values
        int[] rgb = new int[]{
                Integer.parseInt(rgbVals[0]),
                Integer.parseInt(rgbVals[1]),
                Integer.parseInt(rgbVals[2]),
        };
        // Return the color that has been parsed
        return new Color(rgb[0], rgb[1], rgb[2]);
    }

    private int[] getDims() throws NumberFormatException {
        // Return an int array that uses the height/width and length inputs as values
        return new int[]{
                Integer.parseInt(heightWidthInput.getText().replace(" ", "")),
                Integer.parseInt(lengthInput.getText().replace(" ", ""))
        };
    }

}
