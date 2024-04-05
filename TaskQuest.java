import javax.swing.*;

import java.awt.*;

public class TaskQuest extends JPanel {

    public TaskQuest() {
        
        //! Setting frame layout type to BorderLayout
        setLayout(new BorderLayout());
        this.add(this.taskUISetup(), BorderLayout.CENTER);
        this.playerBar();
    }

    private JPanel taskUISetup(){
        JPanel taskPanel = new JPanel();
        taskPanel.setLayout(new GridLayout(2, 2, 20, 20));
        taskPanel.setBackground(new Color(240, 240, 240));

        taskPanel.add(createTile("Task 1"));
        taskPanel.add(createTile("Task 2"));
        taskPanel.add(createTile("Task 3"));
        taskPanel.add(createTile("Task 4"));

        return taskPanel;
    }

    private JPanel createTile(String title) {
        JPanel tile = new JPanel(new BorderLayout());
        tile.setBorder(BorderFactory.createLineBorder(Color.GRAY, 1));
        tile.setBackground(new Color(240, 240, 240));

        JLabel label = new JLabel(title);
        label.setHorizontalAlignment(JLabel.CENTER);
        tile.add(label, BorderLayout.CENTER);

        //! Creates a new JPanel using the BorderLayout()
        JPanel buttonPanel = new JPanel(new BorderLayout());
        buttonPanel.setPreferredSize(new Dimension(tile.getWidth(), 50));

        JButton greenButton = createButton("+", new Color(51,153,255));
        JButton redButton = createButton("x", new Color(255, 84, 84, 255));

        //! Apeends the button 
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

    private void playerBar(){
        JPanel panel = new JPanel(new BorderLayout());

        JButton playerButton = createButton(":)", new Color(12,153,255));
        JButton addTask = createButton("+", new Color(51,153,255));

        panel.add(playerButton, BorderLayout.WEST);
        panel.add(addTask, BorderLayout.EAST);

        panel.setPreferredSize(new Dimension(panel.getWidth(), 50));
        this.add(panel, BorderLayout.SOUTH);
    }

    public static void main(String[] args) {

        //? What is this doing?
        SwingUtilities.invokeLater(() -> {
            JFrame frame = new JFrame("Tile Tasks");
            frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            frame.setContentPane(new TaskQuest());
            frame.setSize(400, 400);
            frame.setLocationRelativeTo(null);
            Image icon = Toolkit.getDefaultToolkit().getImage("res/icon.png");
            frame.setIconImage(icon);

            final Taskbar taskBar = Taskbar.getTaskbar();

            try {
                taskBar.setIconImage(icon);
            } catch (final UnsupportedOperationException e) {
                System.out.println("The os does not support: 'taskbar.setIconImage'");
            }

            frame.setVisible(true);
        });
    }
}
