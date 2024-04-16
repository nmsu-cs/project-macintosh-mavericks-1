
import javax.swing.*;
import java.awt.*;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;



public class Taskxp extends JPanel{

      JFrame window;
      JPanel xpBarPanel, buttonPanel;
      Container con;
      JProgressBar xpBar;
      JButton button;
      JLabel progress;
      int xp;
      int level;
      
      XpHandler xpHandler = new XpHandler();
      
      
      public static void main(String[] args){
         new Taskxp();
         
         
      }
      
      public Taskxp(){
      
      
         window = new JFrame("XP Status");
         
         window.setSize(800,600);
         window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
         //window.getContentPane().setBackground(Color.black);
         window.setLayout(null);
         con = window.getContentPane();
         progress =new JLabel();  
    progress.setBounds(50,100, 100,30);  
    
    progress.setText(String.valueOf(level));
  

         
         xpBarPanel = new JPanel();
         xpBarPanel.setBounds(250, 250, 300, 30);
         //xpBarPanel.setBackground(Color.black);
         con.add(xpBarPanel);
         
         xpBar = new JProgressBar(0, 10);
         xpBar.setPreferredSize(new Dimension(300,30));
         xpBar.setValue(0);
         xpBarPanel.add(xpBar);
         
         buttonPanel = new JPanel();
         buttonPanel.setBounds(250, 300, 300, 40);
         //buttonPanel.setBackground(Color.black);
         con.add(buttonPanel);
          xp = 0;
         level = 0;
         
         button = new JButton("Press if task is complete: " + level);
           
         
         
         button.setBackground(Color.black);
         button.setFocusPainted(false);
         button.addActionListener(xpHandler);
         
         button.addActionListener(e -> {
            revalidate();
            repaint();
         });
         
         buttonPanel.add(button);
         
         
         
        
         
         
         
         window.setVisible(true);
         
         
         
      }
      
      public void xpRecieved(){
      
         xp = xp + 1;
         xpBar.setValue(xp);
         if(xp >= 10) {
         xpBar.setValue(0);
         level = level + 1;
         xp = 0;}
         
      
      }
      
      
      public class XpHandler implements ActionListener{
      
         public void actionPerformed(ActionEvent event){
            xpRecieved();
            //! commenting as it causes crashes
            //button.setLabel("Press if task is complete: " + level);
         
         }
      
      }
      
      
}//End of class Game    