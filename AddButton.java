import javax.swing.*; // Import the Swing library for GUI components
import java.awt.*; // Import the AWT library for graphics and layouts

class AddButton { // Define a class named AddButton
    public static void main(String[] args) { // Main method, entry point of the program
        JFrame frame = new JFrame(); // Create a new JFrame (window)
        JButton button = new JButton(); // Create a new JButton (button)

        // Load the original icon
        ImageIcon originalIcon = new ImageIcon("images/plus.png"); // Load an icon from the specified file

        // Resize the icon
        Image image = originalIcon.getImage(); // Convert the ImageIcon to an Image
        Image newimg = image.getScaledInstance(20, 20, java.awt.Image.SCALE_SMOOTH); // Scale it smoothly to the new size (20x20 pixels)
        ImageIcon resizedIcon = new ImageIcon(newimg); // Convert it back to an ImageIcon

        // Set the resized icon to the button
        button.setIcon(resizedIcon); // Set the resized icon as the button's icon

        frame.add(button); // Add the button to the frame
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); // Set the default close operation (close the application when the window is closed)
        frame.setSize(50, 75); // Set the size of the frame (50x75 pixels)
        frame.setLocationRelativeTo(null); // Center the frame on the screen
        frame.setVisible(true); // Make the frame visible
    }
}
