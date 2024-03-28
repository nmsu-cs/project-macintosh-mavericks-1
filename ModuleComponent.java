import javax.swing.*;
import javax.swing.plaf.basic.BasicButtonUI;

import java.awt.*;

public class ModuleComponent extends JPanel {

    Dimension size = Toolkit.getDefaultToolkit().getScreenSize();

    public ModuleComponent() {
        setLayout(new BorderLayout());
        setBackground(new Color(240, 240, 240));
        setBorder(BorderFactory.createLineBorder(Color.GRAY, 5));
        setPreferredSize(new Dimension((int) size.getWidth(), (int) size.getHeight()));

        JPanel contentBox = new JPanel();
        contentBox.setBackground(Color.WHITE);
        contentBox.setBorder(BorderFactory.createLineBorder(Color.LIGHT_GRAY, 2)); //Small gray border
        contentBox.setPreferredSize(new Dimension((int) size.getWidth()/2, (int) size.getHeight()/2));

        //TASK Box
        JLabel contentLabel = new JLabel("Task");
        contentLabel.setForeground(Color.BLACK);
        contentLabel.setHorizontalAlignment(JLabel.CENTER);
        contentBox.setLayout(new BorderLayout());

        // Create the button box
        JPanel buttonBox = new JPanel();
        buttonBox.setLayout(new GridLayout(1, 2, 8, 0)); // 1 row, 2 columns, horizontal gap of 10 pixels
        buttonBox.setBorder(BorderFactory.createEmptyBorder(0, 5, 0, 5)); // Add padding to the button box
        contentBox.add(buttonBox);
        contentBox.add(contentLabel);

        addButtons(contentBox);

        add(contentBox, BorderLayout.NORTH);
        add(buttonBox, BorderLayout.CENTER);
    }

    public static void addButtons(JPanel panel){
        // Create the buttons
        JButton greenButton = new JButton();
        greenButton.setBackground(Color.GREEN);
        greenButton.setOpaque(true); // Make the button opaque to show the background color
        greenButton.setBorderPainted(false); // Remove button border
        greenButton.setBorder(BorderFactory.createLineBorder(Color.DARK_GRAY, 2, true)); // Add a dark gray rounded border
        greenButton.setUI(new RoundedButtonUI(10)); // Set the corner radius to 10 pixels
        greenButton.setPreferredSize(new Dimension(getWidthPanel(panel)/2, getLengthPanel(panel)/2));

        //Creates text within Green box
        JLabel greenLabel = new JLabel("Complete");
        greenLabel.setForeground(Color.BLACK);
        greenLabel.setHorizontalAlignment(JLabel.CENTER);
        greenButton.setLayout(new BorderLayout());
        greenButton.add(greenLabel);

        JButton redButton = new JButton();
        redButton.setBackground(Color.RED);
        redButton.setOpaque(true); // Make the button opaque to show the background color
        redButton.setBorderPainted(false); // Remove button border
        redButton.setBorder(BorderFactory.createLineBorder(Color.DARK_GRAY, 2, true)); // Add a dark gray rounded border
        redButton.setUI(new RoundedButtonUI(10)); // Set the corner radius to 10 pixels
        redButton.setPreferredSize(new Dimension(getWidthPanel(panel)/2, getLengthPanel(panel)/2));

        //Create Incomplete text within box
        JLabel redLabel = new JLabel("Incomplete");
        redLabel.setForeground(Color.BLACK);
        redLabel.setHorizontalAlignment(JLabel.CENTER);
        redButton.setLayout(new BorderLayout());
        redButton.add(redLabel);

        //Adds both buttonsEAST
        panel.add(redButton, BorderLayout.SOUTH);
        panel.add(greenButton, BorderLayout.NORTH);
    }

    public static int getWidthPanel(JPanel panel){
        return panel.getWidth();
    }

    public static int getLengthPanel(JPanel panel){
        return panel.getHeight();
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            JFrame frame = new JFrame("Task Quest");
            frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            frame.setContentPane(new ModuleComponent());
            frame.pack();
            frame.setLocationRelativeTo(null); // Center the frame
            frame.setVisible(true);
        });
    }
}