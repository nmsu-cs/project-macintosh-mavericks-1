import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;


public class characterPage{

    JPanel window;
    JButton button1, button2, button3, button4, words, picture, words2;

    // Not really making use of the constructor?
    public characterPage(){}

    //? What is this doing. Waiting for ok to delete
    public JPanel appBar(){
        JPanel panel = new JPanel(null);
        panel.setBackground(Color.blue);
        panel.setBounds(0,0,480,45);
        return panel;
    }

    public JPanel createUI(){
        
        window = new JPanel();
        window.setLayout(new GridLayout(2,2));
        window.setMinimumSize(new Dimension(400,400));

        JPanel topPanel = new JPanel();
        topPanel.setBackground(Color.green);
        topPanel.setLayout(new GridLayout(1,3));
        topPanel.setSize(topPanel.getWidth(), 20);
        
        window.add(topPanel);
        
        // JButton words = new JButton();
        // words.setFocusPainted(false);
        // topPanel.add(words);
        JPanel first = new JPanel();
        topPanel.add(first);

        //ImageIcon pixelGuy = new ImageIcon(getClass().getClassLoader().getResource("test2.png"));

       
        JLabel picLabel = new JLabel(new ImageIcon(getClass().getClassLoader().getResource("test2.png")));
        topPanel.add(picLabel);
        //creates character button
        // JButton pixelButton = new JButton();
        // pixelButton.setBackground(Color.black);
        // pixelButton.setFocusPainted(false);
        // pixelButton.setBorder(null);
        // pixelButton.setIcon(pixelGuy);
        // topPanel.add(pixelButton);
        topPanel.add(picLabel);

        JPanel test = new JPanel();
        topPanel.add(test);
        
        JPanel itemPanel = new JPanel();
        itemPanel.setBackground(Color.black);
        itemPanel.setLayout(new GridLayout(2,2));
        window.add(itemPanel);
        
        JButton button1 = new JButton("Test");
        button1.setFocusPainted(false);
        itemPanel.add(button1);
        
        JButton button2 = new JButton("Test2");
        button1.setFocusPainted(false);
        itemPanel.add(button2);

        JButton button3 = new JButton("Test3");
        button1.setFocusPainted(false);
        itemPanel.add(button3);

        JButton button4 = new JButton("Test4");
        button1.setFocusPainted(false);
        itemPanel.add(button4);
        
        window.setVisible(true);
        return window;
    }

    public JPanel characterBar(){
        JPanel playerBar = new JPanel(new BorderLayout());
        playerBar.setBorder(new EmptyBorder(4, 4, 4, 4));
        JButton taskButton = TaskQuest.createButton("📌", new Color(12,153,255));

        taskButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent taskPage){
                TaskQuest temp = new TaskQuest();
                window.removeAll();
                window.setLayout(new BorderLayout());
                window.add(temp.taskUISetup());
                window.revalidate();
                
                playerBar.removeAll();
                playerBar.setBorder(null);
                playerBar.add(temp.playerBar());
                playerBar.revalidate();
            }
        });

        playerBar.add(taskButton, BorderLayout.WEST);
        return playerBar;
    }

    
}