import javax.swing.*;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import com.formdev.flatlaf.FlatDarkLaf;
import java.util.ArrayList;

public class TaskQuest extends JPanel {

    //Exposes some of the JComponents to the entire class. 
    private JPanel taskPanel;
    private JPanel playerBar;
    private ArrayList<String> tasks = new ArrayList<String>();

    public TaskQuest() {
        setLayout(new BorderLayout());
        this.add(this.taskUISetup(), BorderLayout.CENTER);
        this.add(this.playerBar(), BorderLayout.SOUTH);
    }

    private JPanel taskUISetup(){
        taskPanel = new JPanel();
        taskPanel.setLayout(new GridLayout(0, 1, 20, 20));
        tasks = saveData.load();

        for (String task: tasks){
            System.out.println(task);
            this.createTile(task);
        }

        //taskPanel.setBackground(new Color(240, 240, 240));
        taskPanel.setBackground(Color.black);
        return taskPanel;
    }

    private JPanel createTile(String title) {
        JPanel tile = new JPanel(new BorderLayout());
        //tile.setBorder(BorderFactory.createLineBorder(Color.BLACK, 1));
        JPanel test = new JPanel();
        JPanel test1 = new JPanel();
        JPanel test2 = new JPanel();
        
        tile.setBackground(new Color(240, 240, 240));

        JLabel label = new JLabel(title);
        label.setHorizontalAlignment(JLabel.CENTER);
        label.setBorder(getBorder());
        tile.add(label, BorderLayout.CENTER);

        JPanel buttonPanel = new JPanel(new BorderLayout());
        buttonPanel.setPreferredSize(new Dimension(tile.getWidth()/2, 50));

        JButton completeButton = createButton("✓", new Color(0, 200, 0));

        completeButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent delete){
                //tasks.remove(tile);
                taskPanel.remove(tile);
                taskPanel.revalidate();
                taskPanel.repaint();
            }
        });


        buttonPanel.add(completeButton, BorderLayout.EAST);
        tile.add(test, BorderLayout.NORTH);
        tile.add(test1, BorderLayout.EAST);
        tile.add(test2, BorderLayout.WEST);
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
        playerBar = new JPanel(new BorderLayout());
        playerBar.setBorder(BorderFactory.createLineBorder(Color.BLACK, 1));

        JButton playerButton = createButton("👤", new Color(12,153,255));
        JButton addTask = createButton("➕", new Color(51,153,255));

        addTask.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent addTask){

                //Temp solution as we should add ability to input other details
                String task = JOptionPane.showInputDialog(taskPanel, "Enter task", "Task entry", JOptionPane.INFORMATION_MESSAGE);

                //Adding conditional to check input is valid
                if (task != null && task.length() > 0){
                    tasks.add(task);
                    saveData.save(tasks);
                    taskPanel.add(createTile(task + "\n"));
                    taskPanel.setLayout(new GridLayout(0, 2, 20, 20));
                    taskPanel.revalidate();
                    taskPanel.repaint();
                } else {
                    JOptionPane.showMessageDialog(taskPanel, "No task added!");
                }
            }
        });

        playerButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent characterPage){
    
                taskPanel.removeAll();
                taskPanel.setLayout(new BorderLayout());
                playerBar.setVisible(false);
                characterPage page = new characterPage();
                taskPanel.add(page.createUI(), BorderLayout.CENTER);
                taskPanel.revalidate();
            }
        });

        playerBar.add(playerButton, BorderLayout.WEST);
        playerBar.add(addTask, BorderLayout.EAST);

        playerBar.setPreferredSize(new Dimension(playerBar.getWidth(), 50));
        return playerBar;
    }

    public static void main(String[] args) {

        //! This needs to be called before making any UI components. 
        FlatDarkLaf.setup();

        SwingUtilities.invokeLater(() -> {
            JFrame frame = new JFrame("TaskQuest");
            frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            frame.setContentPane(new TaskQuest());
            frame.setSize(400, 400);
            frame.setLocationRelativeTo(null);
            frame.setMinimumSize(new Dimension(400, 400));
            Image icon = Toolkit.getDefaultToolkit().getImage("res/icon.png");
            frame.setIconImage(icon);
            frame.setBackground(Color.black);

            //! Comment this out if your app crashes
            try {
                final Taskbar taskBar = Taskbar.getTaskbar();
                taskBar.setIconImage(icon);
            } catch (final UnsupportedOperationException e) {
                System.out.println("The os does not support: 'taskbar.setIconImage'");
            }

            frame.setVisible(true);
        });
    }
}
