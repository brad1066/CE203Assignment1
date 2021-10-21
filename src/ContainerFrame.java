import javax.swing.*;
import java.awt.*;

// ContainerFrame class for CE203 Assignment to use and modify if needed
// Date: 12/10/2021
// Author: F. Doctor

// A skeleton JFrame class has been provided which you would need to modifiy to include the other GUI components
// and functionality specified in the assignment specification
public class ContainerFrame extends JFrame{

    public void createComponents() {

        JPanel panel = new ContainerPanel();
        add(panel, BorderLayout.CENTER);
        setSize(400, 400);
        setVisible(true);
        setDefaultCloseOperation( JFrame.EXIT_ON_CLOSE );	// Close action.
    }

    public static void main(String[] args) {

        ContainerFrame cFrame = new ContainerFrame();
        cFrame.createComponents();
    }

}
