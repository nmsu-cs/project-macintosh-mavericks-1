import java.awt.Color;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class characterPage {
    JButton button1,button2,button3,button4;
    public static void main(String[] args) {
        new characterPage();
    }


    public characterPage(){
        createUI();
    }

    public void createUI(){
        JFrame window = new JFrame();
        window.setSize(800,600);
        window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        window.getContentPane().setBackground(Color.BLACK);
        window.setLayout(null);

        JPanel characterPanel = new JPanel();
        characterPanel.setBounds(280,220,200,200);
        characterPanel.setBackground(Color.blue);
        window.add(characterPanel);

        ImageIcon pixelGuy = new ImageIcon(getClass().getClassLoader().getResource("test2.png"));

        JButton pixelButton = new JButton();
        pixelButton.setBackground(Color.black);
        pixelButton.setFocusPainted(false);
        pixelButton.setBorder(null);
        pixelButton.setIcon(pixelGuy);
        characterPanel.add(pixelButton);
        

        button1 = new JButton();
        
        
        window.setVisible(true);
    }

  
}