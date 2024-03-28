



package taskquest;

import javax.swing.*;
import java.awt.*;

public class TaskQuest_XP{

 
    
        public static void main(String[] args) {
        
      
      int score = 12;
      
      JFrame f= new JFrame("Task Quest");  
    JLabel l1,l2;  
    l1=new JLabel("Current XP");  
    l1.setBounds(50,50, 100,30);  
    l2=new JLabel();  
    l2.setBounds(50,100, 100,30);  
    
    l2.setText(String.valueOf(score));

    f.add(l1); f.add(l2);  
    f.setSize(300,300);  
    f.setLayout(null);  
    f.setVisible(true); 
      
      
        
} //end main

} //end of class main
    
    
 
