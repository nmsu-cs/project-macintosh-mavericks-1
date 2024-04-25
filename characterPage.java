import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.border.EmptyBorder;


public class characterPage{
    randomHandler cHandler = new randomHandler();
    MouseHandler mHandler = new MouseHandler();
    JPanel window;
    JPanel topPanel, first, /*test,*/ weaponPanel, shieldPanel;
    JLabel picLabel;
    boolean weaponPanelToggle, shieldPanelToggle;/* , ssOwned, lsOwned, mwOwned, wsOwned, stsOwned, isOwned;*/
    JButton shortSwordB, longSwordB, magicWandB, comingSoonB, woodShieldB, stoneShieldB, ironShieldB, comingSoonSB;
    Weapon longSword, shortSword, magicWand, comingSoonW, comingSoon;
    Shield woodShield, stoneShield, ironShield, comingSoonS;
    JTextArea test;
    //int xp;
    //JButton button1, button2, button3, button4, words, picture, words2;

    // Not really making use of the constructor?
    public characterPage(){
        weaponPanelToggle = shieldPanelToggle = false; //lsOwned = mwOwned = stsOwned = isOwned = false;
        //ssOwned = wsOwned = true;
    }

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
        window.setMinimumSize(new Dimension(600,400));

        topPanel = new JPanel();
        topPanel.setBackground(Color.green);
        topPanel.setLayout(new GridLayout(1,3));
        topPanel.setSize(topPanel.getWidth(), 20);
        
        window.add(topPanel);
        
        // JButton words = new JButton();
        // words.setFocusPainted(false);
        // topPanel.add(words);
        first = new JPanel();
        topPanel.add(first);

        //ImageIcon pixelGuy = new ImageIcon(getClass().getClassLoader().getResource("test2.png"));

       
        //picLabel = new JLabel(new ImageIcon(getClass().getClassLoader().getResource("test2.png")));
        defaultCharacter();
        topPanel.add(picLabel);
        topPanel.add(picLabel);

        // test = new JPanel();
        // topPanel.add(test);
        test = new JTextArea();
        test.setForeground(Color.white);
        test.setBackground(Color.black);
        test.setLineWrap(true);
        test.setWrapStyleWord(true);
        test.setEditable(false);

        topPanel.add(test);
        
        JPanel itemPanel = new JPanel();
        itemPanel.setBackground(Color.black);
        itemPanel.setLayout(new GridLayout(2,2));
        window.add(itemPanel);


        //BEGINNING OF WEAPON CODE
        weaponPanel = new JPanel();
        weaponPanel.setBackground(Color.black);
        weaponPanel.setLayout(new GridLayout(2,2));

        shortSword = new Weapon(false, true, 5, "Short Sword", 0); 
        longSword = new Weapon(false, false, 10, "Long Sword", 1);
        magicWand = new Weapon(false, false, 15, "Magic Wand", 1);
        comingSoonW = new Weapon(false, false, 0, "Coming Soon", 0);

        shortSwordB = new JButton(new ImageIcon(getClass().getClassLoader().getResource("res/shortSword.png")));
        shortSwordB.setFocusPainted(false);
        shortSwordB.setBackground(Color.BLACK);
        shortSwordB.addActionListener(cHandler);
        shortSwordB.setActionCommand("Short Sword");
        shortSwordB.addMouseListener(mHandler);
        weaponPanel.add(shortSwordB);
        
        longSwordB = new JButton(new ImageIcon(getClass().getClassLoader().getResource("res/longSword.png")));
        longSwordB.setFocusPainted(false);
        longSwordB.setBackground(Color.black);
        longSwordB.addActionListener(cHandler);
        longSwordB.setActionCommand("Long Sword");
        longSwordB.addMouseListener(mHandler);
        weaponPanel.add(longSwordB);

        magicWandB = new JButton(new ImageIcon(getClass().getClassLoader().getResource("res/magicWand.png")));
        magicWandB.setFocusPainted(false);
        magicWandB.setBackground(Color.BLACK);
        magicWandB.addActionListener(cHandler);
        magicWandB.addMouseListener(mHandler);
        magicWandB.setActionCommand("Magic Wand");
        weaponPanel.add(magicWandB);

        comingSoonB = new JButton(comingSoonW.getName());
        comingSoonB.addMouseListener(mHandler);
        comingSoonB.setFocusPainted(false);
        weaponPanel.add(comingSoonB);
        
        JButton weaponButton = new JButton("Weapon");
        weaponButton.setFocusPainted(false);
        weaponButton.addActionListener(cHandler);
        weaponButton.setActionCommand("Weapon");
        itemPanel.add(weaponButton);
        // END OF WEAPON CODE
        

        //BEGINNING OF SHIELD CODE
        shieldPanel = new JPanel();
        shieldPanel.setBackground(Color.black);
        shieldPanel.setLayout(new GridLayout(2,2));


        woodShield = new Shield(false, true, 5, "Wood Shield", 0); 
        stoneShield = new Shield(false, false, 10, "Stone Shield", 5);
        ironShield = new Shield(false, false, 15, "Iron Shield", 10);
        comingSoonS = new Shield(false, false, 0, "Coming Soon", 0);

        woodShieldB = new JButton(new ImageIcon(getClass().getClassLoader().getResource("res/woodShield.png")));
        woodShieldB.setFocusPainted(false);
        woodShieldB.setBackground(Color.BLACK);
        woodShieldB.addActionListener(cHandler);
        woodShieldB.setActionCommand("Wood Shield");
        woodShieldB.addMouseListener(mHandler);
        shieldPanel.add(woodShieldB);

        stoneShieldB = new JButton(new ImageIcon(getClass().getClassLoader().getResource("res/stoneShield.png")));
        stoneShieldB.setFocusPainted(false);
        stoneShieldB.setBackground(Color.BLACK);
        stoneShieldB.addActionListener(cHandler);
        stoneShieldB.setActionCommand("Stone Shield");
        stoneShieldB.addMouseListener(mHandler);
        shieldPanel.add(stoneShieldB);

        ironShieldB = new JButton(new ImageIcon(getClass().getClassLoader().getResource("res/ironShield.png")));
        ironShieldB.setFocusPainted(false);
        ironShieldB.setBackground(Color.BLACK);
        ironShieldB.addActionListener(cHandler);
        ironShieldB.setActionCommand("Iron Shield");
        ironShieldB.addMouseListener(mHandler);
        shieldPanel.add(ironShieldB);

        comingSoonSB = new JButton(comingSoonW.getName());
        ironShieldB.setFocusPainted(false);
        comingSoonB.addMouseListener(mHandler);
        shieldPanel.add(comingSoonSB);



        JButton shieldButton = new JButton("Shield");
        shieldButton.setFocusPainted(false);
        shieldButton.addActionListener(cHandler);
        shieldButton.setActionCommand("Shield");
        itemPanel.add(shieldButton);
        // END OF SHIELD CODE




        JButton buffButton = new JButton("Buff");
        buffButton.setFocusPainted(false);
        itemPanel.add(buffButton);

        JButton clothButton = new JButton("Shirt");
        clothButton.setFocusPainted(false);
        itemPanel.add(clothButton);

        
        
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
        playerBar.add(TaskQuest.xpBarPanel, BorderLayout.CENTER);
        return playerBar;
    }


public void defaultCharacter(){
    picLabel = new JLabel(new ImageIcon(getClass().getClassLoader().getResource("test2.png")));
}
    public class randomHandler implements ActionListener{
        public void actionPerformed(ActionEvent event){
            String action = event.getActionCommand();

            switch (action) {
                //what happens when the weapon button is pressed.
                case "Weapon":
                    if(!weaponPanelToggle){
                        weaponPanelToggle = true;
                        shieldPanelToggle = false;
                        topPanel.removeAll();
                        topPanel.add(weaponPanel);
                        topPanel.add(picLabel);
                        topPanel.add(test);
                        window.revalidate();
                        window.repaint();
                    }
                    else{
                        weaponPanelToggle = false;
                        topPanel.removeAll();
                        topPanel.add(first);
                        topPanel.add(picLabel);
                        topPanel.add(test);
                        window.revalidate();
                        window.repaint();

                    }
                    break;
                case "Short Sword":
                    if(shortSword.getEquipped() != true){
                        shortSword.setEquipped(true);
                        longSword.setEquipped(false);
                        magicWand.setEquipped(false);
                        topPanel.removeAll();
                        if(woodShield.getEquipped()) picLabel = new JLabel(new ImageIcon(getClass().getClassLoader().getResource("res/wSsSMan.png")));
                        else if(stoneShield.getEquipped()) picLabel = new JLabel(new ImageIcon(getClass().getClassLoader().getResource("res/sSsSMan.png")));
                        else if(ironShield.getEquipped()) picLabel = new JLabel(new ImageIcon(getClass().getClassLoader().getResource("res/iSsSMan.png")));
                        else picLabel = new JLabel(new ImageIcon(getClass().getClassLoader().getResource("res/ssMan.png")));
                        topPanel.add(weaponPanel);
                        topPanel.add(picLabel);
                        test.setText("Short Sword (Owned)\nEquipped: YES\nDamage: " + shortSword.getDamage());
                        topPanel.add(test);
                        window.revalidate();
                        window.repaint();
                    }
                    else{
                        shortSword.setEquipped(false);
                        topPanel.removeAll();
                        if(woodShield.getEquipped()) picLabel = new JLabel(new ImageIcon(getClass().getClassLoader().getResource("res/wsMan.png")));
                        else if(stoneShield.getEquipped()) picLabel = new JLabel(new ImageIcon(getClass().getClassLoader().getResource("res/stsMan.png")));
                        else if(ironShield.getEquipped()) picLabel = new JLabel(new ImageIcon(getClass().getClassLoader().getResource("res/isMan.png")));
                        else defaultCharacter();
                        topPanel.add(weaponPanel);
                        topPanel.add(picLabel);
                        test.setText("Short Sword (Owned)\nEquipped: NO\nDamage: " + shortSword.getDamage());
                        topPanel.add(test);
                        window.revalidate();
                        window.repaint();
                    }
                    break;
                case "Long Sword":
                    if(longSword.getBought()){
                        if(longSword.getEquipped() != true){
                            longSword.setEquipped(true);
                            shortSword.setEquipped(false);
                            magicWand.setEquipped(false);
                            topPanel.removeAll();
                            if(woodShield.getEquipped()) picLabel = new JLabel(new ImageIcon(getClass().getClassLoader().getResource("res/wSlSMan.png")));
                            else if(stoneShield.getEquipped()) picLabel = new JLabel(new ImageIcon(getClass().getClassLoader().getResource("res/sSlSMan.png")));
                            else if(ironShield.getEquipped()) picLabel = new JLabel(new ImageIcon(getClass().getClassLoader().getResource("res/iSlSMan.png")));
                            else picLabel = new JLabel(new ImageIcon(getClass().getClassLoader().getResource("res/lsMan.png")));
                            topPanel.add(weaponPanel);
                            topPanel.add(picLabel);
                            test.setText("Long Sword (Owned)\nEquipped: YES\nThis item has been bought!\nDamage: " + longSword.getDamage());
                            topPanel.add(test);
                            window.revalidate();
                            window.repaint();
                        }
                        else{
                            longSword.setEquipped(false);
                            topPanel.removeAll();
                            if(woodShield.getEquipped()) picLabel = new JLabel(new ImageIcon(getClass().getClassLoader().getResource("res/wsMan.png")));
                            else if(stoneShield.getEquipped()) picLabel = new JLabel(new ImageIcon(getClass().getClassLoader().getResource("res/stsMan.png")));
                            else if(ironShield.getEquipped()) picLabel = new JLabel(new ImageIcon(getClass().getClassLoader().getResource("res/isMan.png")));
                            else defaultCharacter();
                            topPanel.add(weaponPanel);
                            topPanel.add(picLabel);
                            test.setText("Long Sword (Owned)\nEquipped: NO\nThis item has been bought!\nDamage: " + longSword.getDamage());
                            topPanel.add(test);
                            window.revalidate();
                            window.repaint();
                        }
                    }
                    else{
                        if(TaskQuest.xpLevel >= longSword.getCost()){
                            TaskQuest.xpLevel -= longSword.getCost();
                            TaskQuest.xpLabel.setText("" + TaskQuest.xpLevel);
                            longSword.setBought(true);
                            longSword.setEquipped(true);
                            shortSword.setEquipped(false);
                            magicWand.setEquipped(false);
                            topPanel.removeAll();
                            if(woodShield.getEquipped()) picLabel = new JLabel(new ImageIcon(getClass().getClassLoader().getResource("res/wSlSMan.png")));
                            else if(stoneShield.getEquipped()) picLabel = new JLabel(new ImageIcon(getClass().getClassLoader().getResource("res/sSlSMan.png")));
                            else if(ironShield.getEquipped()) picLabel = new JLabel(new ImageIcon(getClass().getClassLoader().getResource("res/iSlSMan.png")));
                            else picLabel = new JLabel(new ImageIcon(getClass().getClassLoader().getResource("res/lsMan.png")));
                            topPanel.add(weaponPanel);
                            topPanel.add(picLabel);
                            test.setText("Long Sword (Owned)\nEquipped: YES\nThis item has been bought!\nDamage: " + longSword.getDamage());
                            topPanel.add(test);
                            window.revalidate();
                            window.repaint();
                        }
                        else test.setText("Long Sword (not Owned)\nYou need more xp to buy a long sword!");
                    }
                    break;
                case "Magic Wand":
                    if(magicWand.getBought()){
                        if(magicWand.getEquipped() != true){
                            magicWand.setEquipped(true);
                            shortSword.setEquipped(false);
                            longSword.setEquipped(false);
                            topPanel.removeAll();
                            if(woodShield.getEquipped()) picLabel = new JLabel(new ImageIcon(getClass().getClassLoader().getResource("res/wSmWMan.png")));
                            else if(stoneShield.getEquipped()) picLabel = new JLabel(new ImageIcon(getClass().getClassLoader().getResource("res/sSmWMan.png")));
                            else if(ironShield.getEquipped()) picLabel = new JLabel(new ImageIcon(getClass().getClassLoader().getResource("res/iSmWMan.png")));
                            else picLabel = new JLabel(new ImageIcon(getClass().getClassLoader().getResource("res/mwMan.png")));
                            topPanel.add(weaponPanel);
                            topPanel.add(picLabel);
                            test.setText("Magic Wand (Owned)\nEquipped: YES\nThis item has been bought!\nDamage: " + magicWand.getDamage());
                            topPanel.add(test);
                            window.revalidate();
                            window.repaint();
                        }
                        else{
                            magicWand.setEquipped(false);
                            topPanel.removeAll();
                            if(woodShield.getEquipped()) picLabel = new JLabel(new ImageIcon(getClass().getClassLoader().getResource("res/wsMan.png")));
                            else if(stoneShield.getEquipped()) picLabel = new JLabel(new ImageIcon(getClass().getClassLoader().getResource("res/stsMan.png")));
                            else if(ironShield.getEquipped()) picLabel = new JLabel(new ImageIcon(getClass().getClassLoader().getResource("res/isMan.png")));
                            else defaultCharacter();
                            topPanel.add(weaponPanel);
                            topPanel.add(picLabel);
                            test.setText("Magic Wand (Owned)\nEquipped: NO\nThis item has been bought!\nDamage: " + magicWand.getDamage());
                            topPanel.add(test);
                            window.revalidate();
                            window.repaint();
                        }
                    }
                    else{
                        if(TaskQuest.xpLevel >= magicWand.getCost()){
                            TaskQuest.xpLevel -= magicWand.getCost();
                            TaskQuest.xpLabel.setText("" + TaskQuest.xpLevel);
                            magicWand.setEquipped(true);
                            magicWand.setBought(true);
                            shortSword.setEquipped(false);
                            longSword.setEquipped(false);
                            topPanel.removeAll();
                            if(woodShield.getEquipped()) picLabel = new JLabel(new ImageIcon(getClass().getClassLoader().getResource("res/wSmWMan.png")));
                            else if(stoneShield.getEquipped()) picLabel = new JLabel(new ImageIcon(getClass().getClassLoader().getResource("res/sSmWMan.png")));
                            else if(ironShield.getEquipped()) picLabel = new JLabel(new ImageIcon(getClass().getClassLoader().getResource("res/iSmWMan.png")));
                            else picLabel = new JLabel(new ImageIcon(getClass().getClassLoader().getResource("res/mwMan.png")));
                            topPanel.add(weaponPanel);
                            topPanel.add(picLabel);
                            test.setText("Magic Wand (Owned)\nEquipped: YES\nThis item has been bought!\nDamage: " + magicWand.getDamage());
                            topPanel.add(test);
                            window.revalidate();
                            window.repaint();
                        }
                        else test.setText("Magic Wand (not Owned)\nYou need more xp to buy a Magic Wand!");
                    }
                    break;
                case "Shield":
                    if(!shieldPanelToggle){
                        shieldPanelToggle = true;
                        weaponPanelToggle = false;
                        topPanel.removeAll();
                        topPanel.add(shieldPanel);
                        topPanel.add(picLabel);
                        topPanel.add(test);
                        window.revalidate();
                        window.repaint();
                    }
                    else{
                        shieldPanelToggle = false;
                        topPanel.removeAll();
                        topPanel.add(first);
                        topPanel.add(picLabel);
                        topPanel.add(test);
                        window.revalidate();
                        window.repaint();

                    }
                    break;
                case "Wood Shield":
                    if(woodShield.getEquipped() != true){
                        woodShield.setEquipped(true);
                        stoneShield.setEquipped(false);
                        ironShield.setEquipped(false);
                        topPanel.removeAll();
                        if(shortSword.getEquipped()) picLabel = new JLabel(new ImageIcon(getClass().getClassLoader().getResource("res/wSsSMan.png")));
                        else if(longSword.getEquipped()) picLabel = new JLabel(new ImageIcon(getClass().getClassLoader().getResource("res/wSlSMan.png")));
                        else if(magicWand.getEquipped()) picLabel = new JLabel(new ImageIcon(getClass().getClassLoader().getResource("res/wSmWMan.png")));
                        else picLabel = new JLabel(new ImageIcon(getClass().getClassLoader().getResource("res/wsMan.png")));
                        topPanel.add(shieldPanel);
                        topPanel.add(picLabel);
                        test.setText("Wood Shield (Owned)\nEquipped: YES\nExtra Health: " + woodShield.getExtraHealth());
                        topPanel.add(test);
                        window.revalidate();
                        window.repaint();
                    }
                    else{
                        woodShield.setEquipped(false);
                        topPanel.removeAll();
                        if(shortSword.getEquipped()) picLabel = new JLabel(new ImageIcon(getClass().getClassLoader().getResource("res/ssMan.png")));
                        else if(longSword.getEquipped()) picLabel = new JLabel(new ImageIcon(getClass().getClassLoader().getResource("res/lsMan.png")));
                        else if(magicWand.getEquipped()) picLabel = new JLabel(new ImageIcon(getClass().getClassLoader().getResource("res/mwMan.png")));
                        else defaultCharacter();
                        topPanel.add(shieldPanel);
                        topPanel.add(picLabel);
                        test.setText("Wood Shield (Owned)\nEquipped: NO\nExtra Health: " + woodShield.getExtraHealth());
                        topPanel.add(test);
                        window.revalidate();
                        window.repaint();
                    }
                    break;
                case "Stone Shield":
                    if(stoneShield.getBought()){
                        if(stoneShield.getEquipped() != true){
                            stoneShield.setEquipped(true);
                            ironShield.setEquipped(false);
                            woodShield.setEquipped(false);
                            topPanel.removeAll();
                            if(shortSword.getEquipped()) picLabel = new JLabel(new ImageIcon(getClass().getClassLoader().getResource("res/sSsSMan.png")));
                            else if(longSword.getEquipped()) picLabel = new JLabel(new ImageIcon(getClass().getClassLoader().getResource("res/sSlSMan.png")));
                            else if(magicWand.getEquipped()) picLabel = new JLabel(new ImageIcon(getClass().getClassLoader().getResource("res/sSmWMan.png")));
                            else picLabel = new JLabel(new ImageIcon(getClass().getClassLoader().getResource("res/stsMan.png")));
                            topPanel.add(shieldPanel);
                            topPanel.add(picLabel);
                            test.setText("Stone Shield (Owned)\nEquipped: YES\nExtra Health: " + stoneShield.getExtraHealth());
                            topPanel.add(test);
                            window.revalidate();
                            window.repaint();
                        }
                        else{
                            stoneShield.setEquipped(false);
                            topPanel.removeAll();
                            if(shortSword.getEquipped()) picLabel = new JLabel(new ImageIcon(getClass().getClassLoader().getResource("res/ssMan.png")));
                            else if(longSword.getEquipped()) picLabel = new JLabel(new ImageIcon(getClass().getClassLoader().getResource("res/lsMan.png")));
                            else if(magicWand.getEquipped()) picLabel = new JLabel(new ImageIcon(getClass().getClassLoader().getResource("res/mwMan.png")));
                            else defaultCharacter();
                            topPanel.add(shieldPanel);
                            topPanel.add(picLabel);
                            test.setText("Stone Shield (Owned)\nEquipped: NO\nExtra Health: " + stoneShield.getExtraHealth());
                            topPanel.add(test);
                            window.revalidate();
                            window.repaint();
                        }
                    }
                    else {
                        if(TaskQuest.xpLevel >= stoneShield.getCost()){
                            TaskQuest.xpLevel -= stoneShield.getCost();
                            TaskQuest.xpLabel.setText("" + TaskQuest.xpLevel);
                            stoneShield.setEquipped(true);
                            ironShield.setEquipped(false);
                            woodShield.setEquipped(false);
                            topPanel.removeAll();
                            if(shortSword.getEquipped()) picLabel = new JLabel(new ImageIcon(getClass().getClassLoader().getResource("res/sSsSMan.png")));
                            else if(longSword.getEquipped()) picLabel = new JLabel(new ImageIcon(getClass().getClassLoader().getResource("res/sSlSMan.png")));
                            else if(magicWand.getEquipped()) picLabel = new JLabel(new ImageIcon(getClass().getClassLoader().getResource("res/sSmWMan.png")));
                            else picLabel = new JLabel(new ImageIcon(getClass().getClassLoader().getResource("res/stsMan.png")));
                            topPanel.add(shieldPanel);
                            topPanel.add(picLabel);
                            test.setText("Stone Shield (Owned)\nEquipped: YES\nExtra Health: " + stoneShield.getExtraHealth());
                            topPanel.add(test);
                            window.revalidate();
                            window.repaint();   
                        }
                        else test.setText("Stone Shield (not Owned)\nYou need more xp to buy a Stone Shield!");
                    }
                    break;
                case "Iron Shield":
                    if(ironShield.getBought()){
                        if(ironShield.getEquipped() != true){
                            ironShield.setEquipped(true);
                            stoneShield.setEquipped(false);
                            woodShield.setEquipped(false);
                            topPanel.removeAll();
                            if(shortSword.getEquipped()) picLabel = new JLabel(new ImageIcon(getClass().getClassLoader().getResource("res/iSsSMan.png")));
                            else if(longSword.getEquipped()) picLabel = new JLabel(new ImageIcon(getClass().getClassLoader().getResource("res/iSlSMan.png")));
                            else if(magicWand.getEquipped()) picLabel = new JLabel(new ImageIcon(getClass().getClassLoader().getResource("res/iSmWMan.png")));
                            else picLabel = new JLabel(new ImageIcon(getClass().getClassLoader().getResource("res/isMan.png")));
                            topPanel.add(shieldPanel);
                            topPanel.add(picLabel);
                            test.setText("Iron Shield (Owned)\nEquipped: YES\nExtra Health: " + ironShield.getExtraHealth());
                            topPanel.add(test);
                            window.revalidate();
                            window.repaint();
                        }
                        else{
                            ironShield.setEquipped(false);
                            topPanel.removeAll();
                            if(shortSword.getEquipped()) picLabel = new JLabel(new ImageIcon(getClass().getClassLoader().getResource("res/ssMan.png")));
                            else if(longSword.getEquipped()) picLabel = new JLabel(new ImageIcon(getClass().getClassLoader().getResource("res/lsMan.png")));
                            else if(magicWand.getEquipped()) picLabel = new JLabel(new ImageIcon(getClass().getClassLoader().getResource("res/mwMan.png")));
                            else defaultCharacter();
                            topPanel.add(shieldPanel);
                            topPanel.add(picLabel);
                            test.setText("Iron Shield (Owned)\nEquipped: NO\nExtra Health: " + ironShield.getExtraHealth());
                            topPanel.add(test);
                            window.revalidate();
                            window.repaint();
                        }
                    }
                    
                    else {
                        if(TaskQuest.xpLevel >= ironShield.getCost()){
                            TaskQuest.xpLevel -= ironShield.getCost();
                            TaskQuest.xpLabel.setText("" + TaskQuest.xpLevel);
                            ironShield.setEquipped(true);
                            stoneShield.setEquipped(false);
                            woodShield.setEquipped(false);
                            topPanel.removeAll();
                            if(shortSword.getEquipped()) picLabel = new JLabel(new ImageIcon(getClass().getClassLoader().getResource("res/iSsSMan.png")));
                            else if(longSword.getEquipped()) picLabel = new JLabel(new ImageIcon(getClass().getClassLoader().getResource("res/iSlSMan.png")));
                            else if(magicWand.getEquipped()) picLabel = new JLabel(new ImageIcon(getClass().getClassLoader().getResource("res/iSmWMan.png")));
                            else picLabel = new JLabel(new ImageIcon(getClass().getClassLoader().getResource("res/isMan.png")));
                            topPanel.add(shieldPanel);
                            topPanel.add(picLabel);
                            test.setText("Iron Shield (Owned)\nEquipped: YES\nExtra Health: " + ironShield.getExtraHealth());
                            topPanel.add(test);
                            window.revalidate();
                            window.repaint();
                        }
                        else test.setText("Iron Shield (not Owned)\nYou need more xp to buy a Iron Shield!");
                    }
                    break;

            default:
                break;
            }
        }
    }






            
    public class MouseHandler implements MouseListener{
        @Override
        public void mouseClicked(MouseEvent e){

        }
        @Override
        public void mousePressed(MouseEvent e){

        }
        @Override
        public void mouseReleased(MouseEvent e){
            
        }
        @Override
        public void mouseExited(MouseEvent e){
            test.setText(null);
        }
        @Override
        public void mouseEntered(MouseEvent e) {
            //determines which button your mouse hovers over
            JButton button = (JButton)e.getSource();

            if(button == shortSwordB){
                if(shortSword.getEquipped()) test.setText("Short Sword (Owned)\nEquipped: YES\nDamage: " + shortSword.getDamage());
                else test.setText("Short Sword (Owned)\nEquipped: NO\nDamage: " + shortSword.getDamage());
            }
            else if(button == longSwordB){
                if(longSword.getBought() == false){
                    test.setText("Long Sword (Locked)\nThis item is currently locked!\nCost: " + longSword.getCost() + "\nDamage: " + longSword.getDamage());
                }
                else{
                    if(longSword.getEquipped()) test.setText("Long Sword (Owned)\nEquipped: YES\nThis item has been bought!\nDamage: " + longSword.getDamage());
                    else test.setText("Long Sword (Owned)\nEquipped: NO\nThis item has been bought!\nDamage: " + longSword.getDamage());
                }
            }
            else if(button == magicWandB){
                if(magicWand.getBought() == false){
                    test.setText("Magic Wand (Locked)\nThis item is currently locked!\nCost: " + magicWand.getCost() + "\nDamage: " + magicWand.getDamage());
                }
                else{
                    if(magicWand.getEquipped()) test.setText("Magic Wand (Owned)\nEquipped: YES\nThis item has been bought!\nDamage: " + magicWand.getDamage());
                    else test.setText("Long Sword (Owned)\nEquipped: No\nThis item has been bought!\nDamage: " + magicWand.getDamage());
                }
            }
            else if(button == comingSoonB){
                test.setText("More Items coming soon!");
            }
            else if(button == woodShieldB){
                if(woodShield.getEquipped()) test.setText("Wood Shield (Owned)\nEquipped: YES\nExtra Health: " + woodShield.getExtraHealth());
                else test.setText("Wood Shield (Owned)\nEquipped: NO\nExtra Health: " + woodShield.getExtraHealth());
            }

            else if(button == stoneShieldB){
                if(stoneShield.getBought() == false){
                    test.setText("Stone Shield (Locked)\nThis item is currently locked!\nCost: " + stoneShield.getCost() + "\nExtra Health: " + stoneShield.getExtraHealth());
                }
                else{
                    if(stoneShield.getEquipped()) test.setText("Stone Shield (Owned)\nEquipped: YES\nExtra Health: " + stoneShield.getExtraHealth());
                    else test.setText("Stone Shield (Owned)\nEquipped: NO\nExtra Health: " + stoneShield.getExtraHealth());
                }
            }
            else if(button == ironShieldB){
                if(ironShield.getBought() == false){
                    test.setText("Iron Shield (Locked)\nThis item is currently locked!\nCost: " + ironShield.getCost() + "\nExtra Health: " + ironShield.getExtraHealth());
                }
                else{
                    if(ironShield.getEquipped()) test.setText("Iron Shield (Owned)\nEquipped: YES\nExtra Health: " + ironShield.getExtraHealth());
                    else test.setText("Iron Shield (Owned)\nEquipped: NO\nExtra Health: " + ironShield.getExtraHealth());
                }
            }
            else if(button == comingSoonSB){
                test.setText("More Items coming soon!");
            }
        }
    }

    class Item {
        protected boolean Equiped;
        protected boolean Bought;
        protected String name;
        protected int cost;

        public Item(){
            Equiped = false;
            Bought = false;
            name = "No name";
            cost = 0;
        }

        public boolean getEquipped(){
            return this.Equiped;
        }

        public boolean getBought(){
            return this.Bought;
        }

        public String getName(){
            return this.name;
        }

        public int getCost(){
            return this.cost;
        }

        public void setEquipped(boolean equipped){
            this.Equiped = equipped;
        }

        public void setBought(boolean Bought){
            this.Bought = Bought;
        }
    }

    class Weapon extends Item {
        protected int damage;

        public Weapon(Boolean equipped, Boolean Bought, int damage, String name, int cost){
            this.damage = damage;
            this.Bought = Bought;
            this.damage = damage;
            this.name = name;
            this.Equiped = equipped;
            this.cost = cost;
            
        }

        public int getDamage(){
            return this.damage;
        }





    }

    class Shield extends Item{
        protected int extraHealth;
        public Shield(Boolean equipped, Boolean Bought, int extraHealth, String name, int cost){
            this.extraHealth = extraHealth;
            this.Bought = Bought; 
            this.Equiped = equipped;
            this.name = name;
            this.cost = cost;
        }
        public int getExtraHealth(){
            return this.extraHealth;
        }
    }    
    
}