import javax.swing.*;
import javax.swing.plaf.basic.BasicButtonUI;
import java.awt.*;

public class ModuleComponent extends JPanel {
    public ModuleComponent() {
        setLayout(new BorderLayout());
        setBackground(new Color(240, 240, 240)); // Light gray background color
        setBorder(BorderFactory.createLineBorder(Color.GRAY, 5)); // Gray border
        setPreferredSize(new Dimension(300, 200));

        // Create the content box
        JPanel contentBox = new JPanel();
        contentBox.setBackground(Color.WHITE);
        contentBox.setBorder(BorderFactory.createLineBorder(Color.LIGHT_GRAY, 2)); // Small gray border
        contentBox.setPreferredSize(new Dimension(280, 90));

        // Create the button box
        JPanel buttonBox = new JPanel();
        buttonBox.setLayout(new GridLayout(1, 2, 8, 0)); // 1 row, 2 columns, horizontal gap of 10 pixels
        buttonBox.setBorder(BorderFactory.createEmptyBorder(0, 10, 0, 10)); // Add padding to the button box

        // Create the buttons
        JButton greenButton = new JButton();
        greenButton.setBackground(Color.GREEN);
        greenButton.setOpaque(true); // Make the button opaque to show the background color
        greenButton.setBorderPainted(false); // Remove button border
        greenButton.setBorder(BorderFactory.createLineBorder(Color.DARK_GRAY, 2, true)); // Add a dark gray rounded border
        greenButton.setUI(new RoundedButtonUI(10)); // Set the corner radius to 10 pixels
        greenButton.setPreferredSize(new Dimension(150, 40));
    

        JButton redButton = new JButton();
        redButton.setBackground(Color.RED);
        redButton.setOpaque(true); // Make the button opaque to show the background color
        redButton.setBorderPainted(false); // Remove button border
        redButton.setBorder(BorderFactory.createLineBorder(Color.DARK_GRAY, 2, true)); // Add a dark gray rounded border
        redButton.setUI(new RoundedButtonUI(10)); // Set the corner radius to 10 pixels
        redButton.setPreferredSize(new Dimension(140, 50));

        buttonBox.add(greenButton);
        buttonBox.add(redButton);

        add(contentBox, BorderLayout.NORTH);
        add(buttonBox, BorderLayout.CENTER);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            JFrame frame = new JFrame("Module Component");
            frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            frame.setContentPane(new ModuleComponent());
            frame.pack();
            frame.setLocationRelativeTo(null); // Center the frame
            frame.setVisible(true);
        });
    }
}

class RoundedButtonUI extends BasicButtonUI {
    private int cornerRadius;
    private static final Color BORDER_COLOR = Color.DARK_GRAY; // Constant for border color

    public RoundedButtonUI(int cornerRadius) {
        this.cornerRadius = cornerRadius;
    }

    @Override
    public void installUI(JComponent c) {
        super.installUI(c);
        AbstractButton button = (AbstractButton) c;
        button.setOpaque(false);
        button.setBorder(BorderFactory.createEmptyBorder(5, 10, 5, 10));
    }

    @Override
    public void paint(Graphics g, JComponent c) {
        Graphics2D g2 = (Graphics2D) g.create();
        g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);

        AbstractButton b = (AbstractButton) c;
        int width = b.getWidth();
        int height = b.getHeight();

        // Draw the rounded button shape
        g2.setColor(b.getBackground());
        g2.fillRoundRect(0, 0, width, height, cornerRadius, cornerRadius);

        // Draw the border
        g2.setColor(BORDER_COLOR); // Use the constant border color
        g2.drawRoundRect(0, 0, width - 1, height - 1, cornerRadius, cornerRadius);

        g2.dispose();
    }
}