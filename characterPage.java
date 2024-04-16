import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridLayout;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;


public class characterPage{

    JButton button1,button2,button3,button4,words,picture,words2;
    





    public static void main(String[] args) {
        new characterPage();
    }


    public characterPage(){
        
        //create font needs to but put before createUI otherwise it won't work in UI
      
        //createUI();
    }

    public JPanel appBar(){
        JPanel panel = new JPanel(null);
        panel.setBackground(Color.blue);
        panel.setBounds(0,0,480,45);
        return panel;
    }

    public JPanel createUI(){
        

        //create a new window
        JPanel window = new JPanel();
        //window.setSize(800,600);
        //window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        //window.getContentPane().setBackground(Color.blue);
        window.setLayout(new GridLayout(2,2));
        window.setMinimumSize(new Dimension(400,400));

        
        JPanel topPanel = new JPanel();
        //counterPanel.setBounds(100,100,200,100);
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
        // JButton words2 = new JButton();
        // words2.setFocusPainted(false);
        // topPanel.add(words2);
        
        
        
        
        
        
        
        
        JPanel itemPanel = new JPanel();
        //counterPanel.setBounds(100,100,200,100);
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
}