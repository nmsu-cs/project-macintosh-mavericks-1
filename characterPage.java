import java.awt.Color;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class characterPage {

    JLabel counterLabel, perSecLabel;
    int randomCounter;
    Font font1,font2;

    randomHandler cHandler = new randomHandler();



    JButton button1,button2,button3,button4;
    public static void main(String[] args) {
        new characterPage();
    }


    public characterPage(){
        randomCounter = 0;
        //create font needs to but put before createUI otherwise it won't work in UI
        createFont();
        createUI();
    }

    public void createFont(){
        // new font("font name", font style, font size)
        font1 = new Font("Comic Sans MS", Font.PLAIN, 32 );
        font1 = new Font("Comic Sans MS", Font.PLAIN, 15 );
    }

    public void createUI(){
        //create a new window
        JFrame window = new JFrame();
        window.setSize(800,600);
        window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        window.getContentPane().setBackground(Color.BLACK);
        window.setLayout(null);

        //area where character will be
        JPanel characterPanel = new JPanel();
        characterPanel.setBounds(280,220,200,200);
        characterPanel.setBackground(Color.black);
        window.add(characterPanel);

        //get image as an image in javaFX
        ImageIcon pixelGuy = new ImageIcon(getClass().getClassLoader().getResource("test2.png"));

        //creates character button
        JButton pixelButton = new JButton();
        pixelButton.setBackground(Color.black);
        pixelButton.setFocusPainted(false);
        pixelButton.setBorder(null);
        pixelButton.setIcon(pixelGuy);
        pixelButton.addActionListener(cHandler);
        characterPanel.add(pixelButton);
        
        //new panel where labels will be located
        JPanel counterPanel = new JPanel();
        counterPanel.setBounds(100,100,200,100);
        counterPanel.setBackground(Color.black);
        counterPanel.setLayout(new GridLayout(2,1));
        window.add(counterPanel);

        //how to create labels
        counterLabel = new JLabel(randomCounter + " Number");
        counterLabel.setForeground(Color.white);
        counterLabel.setFont(font1);
        counterPanel.add(counterLabel);

        perSecLabel = new JLabel();
        perSecLabel.setForeground(Color.white);
        perSecLabel.setFont(font2);
        counterPanel.add(perSecLabel);


       

        JPanel itemPanel = new JPanel();
        itemPanel.setBounds(100,450,600,100);
        itemPanel.setBackground(Color.blue);
        itemPanel.setLayout(new GridLayout(1,3));
        window.add(itemPanel);


        button1 = new JButton("Armor");
        button1.setFont(font1);
        button1.setFocusPainted(false);
        button1.addActionListener(cHandler);
        itemPanel.add(button1);

        button2 = new JButton("Weapon");
        button2.setFont(font1);
        button2.setFocusPainted(false);
        button2.addActionListener(cHandler);
        itemPanel.add(button2);

        button3 = new JButton("Buff");
        button3.setFont(font1);
        button3.setFocusPainted(false);
        button3.addActionListener(cHandler);
        button3.setActionCommand("");
        itemPanel.add(button3);
        
        
        window.setVisible(true);
    }

    public class randomHandler implements ActionListener{
        public void actionPerformed(ActionEvent event){
            randomCounter++;
            counterLabel.setText(randomCounter + " Number");
        }
    }

  
}