import javax.swing.*;
import java.awt.*;
import javax.swing.border.EmptyBorder;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import com.formdev.flatlaf.FlatDarkLaf;
import java.util.ArrayList;

public class TaskQuest extends JPanel {

    //Exposes some of the JComponents to the entire class. 
    private JPanel taskPanel;
    private JPanel playerBar;
    public static JPanel xpBarPanel;
    private JProgressBar xpBar;
    public static int xpProgress = 0;
    public static int xpLevel = 0;
    static JLabel xpLabel = new JLabel("" + xpLevel);
    private ArrayList<String> tasks = new ArrayList<String>();

    public TaskQuest() {
        setLayout(new BorderLayout());
        this.add(this.taskUISetup(), BorderLayout.CENTER);
        this.add(this.playerBar(), BorderLayout.SOUTH);
    }

    //Something in taskUISetup not setting up listeners for xp or task deletion?
    public JPanel taskUISetup(){
        taskPanel = new JPanel();
        taskPanel.setLayout(new GridLayout(0, 1, 10, 20));
        tasks = saveData.loadTasks();

        if (tasks.size() >= 2){
            taskPanel.setLayout(new GridLayout(0, 2, 20, 20));
        }

        for (String task: tasks){
            taskPanel.add(createTile(task));
            revalidate();
        }

        xpLevel = saveData.loadXP()[0];
        xpProgress = saveData.loadXP()[1];
        taskPanel.setBorder(new EmptyBorder(10, 10, 10, 10));
        taskPanel.setBackground(Color.black);
        return taskPanel;
    }

    private JPanel createTile(String title) {
        JPanel tile = new JPanel(new BorderLayout());
        
        tile.setBackground(new Color(240, 240, 240));

        JLabel label = new JLabel(title);
        label.setHorizontalAlignment(JLabel.CENTER);

        label.setForeground(Color.BLACK);
        tile.add(label, BorderLayout.CENTER);

        JPanel buttonPanel = new JPanel(new BorderLayout());
        buttonPanel.setPreferredSize(new Dimension(tile.getWidth()/2, 25));
        buttonPanel.setBorder(new EmptyBorder(5, 10, 5, 10));

        JButton deleteButton = createButton("X", new Color(200, 36, 36));
        JButton completeButton = createButton("✓", new Color(36, 200, 68));

        deleteButton.setPreferredSize(new Dimension(75, buttonPanel.getHeight()));
        completeButton.setPreferredSize(new Dimension(75, buttonPanel.getHeight()));

        completeButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent delete){
                if(xpProgress >= 5){
                    xpProgress = 0;
                    xpLevel++;
                    saveData.saveXP(xpLevel, xpProgress);
                    xpLabel.setText("" + xpLevel);
                } else {
                    xpProgress++;
                    saveData.saveXP(xpLevel, xpProgress);
                }

                xpBar.setValue(xpProgress);

                for (int i = 0; i < tasks.size(); i++){
                    if (tasks.get(i) == title){
                        tasks.remove(i);
                    }
                }

                if (tasks.size() <= 2){
                    taskPanel.setLayout(new GridLayout(0, 1, 20, 20));
                }

                saveData.saveTasks(tasks);
                taskPanel.remove(tile);
                taskPanel.revalidate();
                taskPanel.repaint();
            }
        });

        deleteButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent delete) {

                for(int i = 0; i < tasks.size(); i++) {
                    if(tasks.get(i) == title) {
                        tasks.remove(i); 
                    }
                }  

                if (tasks.size() <= 2){
                    taskPanel.setLayout(new GridLayout(0, 1, 20, 20));
                }

                saveData.saveTasks(tasks);
                taskPanel.remove(tile);
                taskPanel.revalidate();
                taskPanel.repaint();
            }
        });

        buttonPanel.add(deleteButton, BorderLayout.WEST);
        buttonPanel.add(completeButton, BorderLayout.EAST);
        tile.add(buttonPanel, BorderLayout.SOUTH);

        return tile;
    }

    public static JButton createButton(String text, Color color) {
        JButton button = new JButton(text);
        button.setBackground(color);
        button.setForeground(Color.black);
        button.setOpaque(true);
        button.setBorderPainted(false);
        return button;
    }

    public JPanel playerBar(){
        playerBar = new JPanel(new BorderLayout());
        playerBar.setBorder(new EmptyBorder(4, 4, 4, 4));

        int[] playerStat = saveData.loadXP();
        System.out.println(playerStat[0]);
        System.out.println(playerStat[1]);

        xpLabel.setText("" + playerStat[0]);
        xpLabel.setForeground(Color.white);
        xpBarPanel = new JPanel(new BorderLayout());
        xpBarPanel.setBackground(Color.black);
        xpBarPanel.add(xpLabel, BorderLayout.WEST);
        xpBar = new JProgressBar(0,5);// takes 10 tasks to level up
        
        xpBar.setValue(playerStat[1]);
        xpBarPanel.add(xpBar, BorderLayout.CENTER);

        JButton playerButton = createButton("👤", new Color(12,153,255));
        JButton addTask = createButton("➕", new Color(51,153,255));

        addTask.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent addTask){

                String task = JOptionPane.showInputDialog(taskPanel, "Enter task", "Task entry", JOptionPane.INFORMATION_MESSAGE);

                //Adding conditional to check input is valid
                if (task != null && task.length() > 0){
                    tasks.add(task);
                    saveData.saveTasks(tasks);
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
                taskPanel.setBorder(null);
                taskPanel.setLayout(new BorderLayout());
                characterPage page = new characterPage();
                taskPanel.add(page.createUI(), BorderLayout.CENTER);
                taskPanel.revalidate();

                playerBar.setBorder(null);
                playerBar.removeAll();
                playerBar.add(page.characterBar());
                playerBar.revalidate();
            }
        });

        playerBar.add(playerButton, BorderLayout.WEST);
        playerBar.add(addTask, BorderLayout.EAST);
        playerBar.add(xpBarPanel, BorderLayout.CENTER);

        playerBar.setPreferredSize(new Dimension(playerBar.getWidth(), 50));
        return playerBar;
    }

    public static void main(String[] args) {

        //! Comment this out if your app crashes
        FlatDarkLaf.setup();

        SwingUtilities.invokeLater(() -> {
            JFrame frame = new JFrame("TaskQuest");
            frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            frame.setContentPane(new TaskQuest());
            frame.setSize(400, 400);
            frame.setLocationRelativeTo(null);
            frame.setMinimumSize(new Dimension(600, 400));
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
