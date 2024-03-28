import javax.swing.*;
import java.awt.*;

public class TaskQuest extends JPanel {

    public TaskQuest() {

        //TODO: implement responsive grid layout using variables.
        setLayout(new GridLayout(2, 2, 20, 20));
        setBackground(new Color(240, 240, 240));

        add(createTile("Task 1"));
        add(createTile("Task 2"));
        add(createTile("Task 3"));
        add(createTile("Task 4"));
    }

    private JPanel createTile(String title) {
        JPanel tile = new JPanel(new BorderLayout());
        tile.setBorder(BorderFactory.createLineBorder(Color.GRAY, 5));
        tile.setBackground(new Color(240, 240, 240));

        JLabel label = new JLabel(title);
        label.setHorizontalAlignment(JLabel.CENTER);
        tile.add(label, BorderLayout.CENTER);

        JPanel buttonPanel = new JPanel(new BorderLayout());
        buttonPanel.setPreferredSize(new Dimension(tile.getWidth(), 50));

        JButton greenButton = createButton("+", new Color(51,153,255));
        JButton redButton = createButton("x", new Color(255, 84, 84, 255));

        buttonPanel.add(redButton, BorderLayout.WEST);
        buttonPanel.add(greenButton, BorderLayout.EAST);

        tile.add(buttonPanel, BorderLayout.SOUTH);

        return tile;
    }

    private JButton createButton(String text, Color color) {
        JButton button = new JButton(text);
        button.setBackground(color);
        button.setForeground(color);
        button.setOpaque(true);
        button.setBorderPainted(true);
        return button;
    }

    public static void main(String[] args) {

        //What is this doing???
        SwingUtilities.invokeLater(() -> {
            JFrame frame = new JFrame("Tile Tasks");
            frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            frame.setContentPane(new TaskQuest());
            frame.setSize(400, 400);
            frame.setLocationRelativeTo(null);
            frame.setVisible(true);
        });
    }
}
