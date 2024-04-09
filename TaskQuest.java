import javax.swing.*;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class TaskQuest extends JPanel {

    private JPanel taskPanel;

    public TaskQuest() {

        //Sets layout type to BorderLayout
        setLayout(new BorderLayout());

        this.add(this.taskUISetup(), BorderLayout.CENTER);
        this.add(this.playerBar(), BorderLayout.SOUTH);
    }

    private JPanel taskUISetup(){
        taskPanel = new JPanel();
        taskPanel.setLayout(new GridLayout(0, 1, 20, 20));
        taskPanel.setBackground(new Color(240, 240, 240));

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

        JButton deleteButton = createButton("x", new Color(255, 84, 84, 255));

        deleteButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent delete){

                taskPanel.remove(tile);
                taskPanel.revalidate();
                taskPanel.repaint();
            }
        });

        buttonPanel.add(deleteButton, BorderLayout.EAST);
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

    private JPanel playerBar(){
        JPanel panel = new JPanel(new BorderLayout());

        JButton playerButton = createButton("O", new Color(12,153,255));
        JButton addTask = createButton("+", new Color(51,153,255));

        addTask.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent addTask){

                String task = JOptionPane.showInputDialog(panel, "Enter task", null);

                if (task != null){
                    taskPanel.add(createTile(task + "\n"));
                    taskPanel.setLayout(new GridLayout(0, 2, 20, 20));
                    taskPanel.revalidate();
                    taskPanel.repaint();
                }
            }
        });

        panel.add(playerButton, BorderLayout.WEST);
        panel.add(addTask, BorderLayout.EAST);

        panel.setPreferredSize(new Dimension(panel.getWidth(), 50));
        return panel;
    }

    //TODO this could be cleaned up a lot more
    public static void main(String[] args) {

        //? What is this doing
        SwingUtilities.invokeLater(() -> {
            JFrame frame = new JFrame("Tile Tasks");
            frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            frame.setContentPane(new TaskQuest());
            frame.setSize(400, 400);
            frame.setLocationRelativeTo(null);
            frame.setMinimumSize(new Dimension(400, 400));
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
