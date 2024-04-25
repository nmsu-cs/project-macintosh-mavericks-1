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
    randomHandler cHandler = new randomHandler();
    JPanel window;
    JPanel topPanel, first, test, weaponPanel, shieldPanel;
    JLabel picLabel;
    boolean weaponPanelToggle, shieldPanelToggle;
    JButton shortSwordB, longSwordB, magicWandB, comingSoonB, woodShieldB, stoneShieldB, ironShieldB, comingSoonSB;
    Weapon longSword, shortSword, magicWand, comingSoonW, comingSoon;
    Shield woodShield, stoneShield, ironShield, comingSoonS;
    //JButton button1, button2, button3, button4, words, picture, words2;

    // Not really making use of the constructor?
    public characterPage(){
        weaponPanelToggle = false;
        shieldPanelToggle = false;
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

        test = new JPanel();
        topPanel.add(test);
        
        JPanel itemPanel = new JPanel();
        itemPanel.setBackground(Color.black);
        itemPanel.setLayout(new GridLayout(2,2));
        window.add(itemPanel);


        //BEGINNING OF WEAPON CODE
        weaponPanel = new JPanel();
        weaponPanel.setBackground(Color.black);
        weaponPanel.setLayout(new GridLayout(2,2));

        shortSword = new Weapon(false, false, 5, "Short Sword"); 
        longSword = new Weapon(false, false, 10, "Long Sword");
        magicWand = new Weapon(false, false, 15, "Magic Wand");
        comingSoonW = new Weapon(false, false, 0, "Coming Soon");

        shortSwordB = new JButton(new ImageIcon(getClass().getClassLoader().getResource("res/shortSword.png")));
        shortSwordB.setFocusPainted(false);
        shortSwordB.setBackground(Color.BLACK);
        shortSwordB.addActionListener(cHandler);
        shortSwordB.setActionCommand("Short Sword");
        weaponPanel.add(shortSwordB);
        
        JButton longSwordB = new JButton(new ImageIcon(getClass().getClassLoader().getResource("res/longSword.png")));
        longSwordB.setFocusPainted(false);
        longSwordB.setBackground(Color.black);
        longSwordB.addActionListener(cHandler);
        longSwordB.setActionCommand("Long Sword");
        weaponPanel.add(longSwordB);

        JButton magicWandB = new JButton(new ImageIcon(getClass().getClassLoader().getResource("res/magicWand.png")));
        magicWandB.setFocusPainted(false);
        magicWandB.setBackground(Color.BLACK);
        magicWandB.addActionListener(cHandler);
        magicWandB.setActionCommand("Magic Wand");
        weaponPanel.add(magicWandB);

        JButton comingSoonB = new JButton(comingSoonW.getName());
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


        woodShield = new Shield(false, false, 5, "Wood Shield"); 
        stoneShield = new Shield(false, false, 10, "Stone Shield");
        ironShield = new Shield(false, false, 15, "Iron Shield");
        comingSoonS = new Shield(false, false, 0, "Coming Soon");

        woodShieldB = new JButton(new ImageIcon(getClass().getClassLoader().getResource("res/woodShield.png")));
        woodShieldB.setFocusPainted(false);
        woodShieldB.setBackground(Color.BLACK);
        woodShieldB.addActionListener(cHandler);
        woodShieldB.setActionCommand("Wood Shield");
        shieldPanel.add(woodShieldB);

        stoneShieldB = new JButton(new ImageIcon(getClass().getClassLoader().getResource("res/stoneShield.png")));
        stoneShieldB.setFocusPainted(false);
        stoneShieldB.setBackground(Color.BLACK);
        stoneShieldB.addActionListener(cHandler);
        stoneShieldB.setActionCommand("Stone Shield");
        shieldPanel.add(stoneShieldB);

        ironShieldB = new JButton(new ImageIcon(getClass().getClassLoader().getResource("res/ironShield.png")));
        ironShieldB.setFocusPainted(false);
        ironShieldB.setBackground(Color.BLACK);
        ironShieldB.addActionListener(cHandler);
        ironShieldB.setActionCommand("Iron Shield");
        shieldPanel.add(ironShieldB);

        comingSoonSB = new JButton(comingSoonW.getName());
        ironShieldB.setFocusPainted(false);
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

        // JButton button4 = new JButton("Test4");
        // button1.setFocusPainted(false);
        // itemPanel.add(button4);
        
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
                        topPanel.add(test);
                        window.revalidate();
                        window.repaint();
                    }
                    break;
                case "Long Sword":
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
                        topPanel.add(test);
                        window.revalidate();
                        window.repaint();
                    }
                    break;
                case "Magic Wand":
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
                        topPanel.add(test);
                        window.revalidate();
                        window.repaint();
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
                        topPanel.add(test);
                        window.revalidate();
                        window.repaint();
                    }
                    break;
                case "Stone Shield":
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
                        topPanel.add(test);
                        window.revalidate();
                        window.repaint();
                    }
                    break;
                case "Iron Shield":
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
                        topPanel.add(test);
                        window.revalidate();
                        window.repaint();
                    }
                    break;

            default:
                break;
            }
        }
    }






            
    // public class MouseHandler implements MouseListener{
    //     @Override
    //     public void mouseClicked(MouseEvent e){

    //     }
    //     @Override
    //     public void mousePressed(MouseEvent e){

    //     }
    //     @Override
    //     public void mouseReleased(MouseEvent e){
            
    //     }
    //     @Override
    //     public void mouseExited(MouseEvent e){
    //         messageText.setText(null);
    //     }
    //     @Override
    //     public void mouseEntered(MouseEvent e) {
    //         //determines which button your mouse hovers over
    //         JButton button = (JButton)e.getSource();

    //         if(button == button1){
    //             messageText.setText("Cursor\n[price: " + cursorPrice + "]\nAutoclicks once every 10 seconds" );
    //         }
    //         else if(button == button2){
    //             if(grandpaUnlocked ==false){
    //                 messageText.setText("This item is currently locked");
    //             }
    //             else{
    //                 messageText.setText("Grandpa\n[price: " + grandpaPrice + "]\nEach grandpa produces 1 cookie per second");
    //             }
    //         }
    //         else if(button == button3){
    //             messageText.setText("This item is currently locked");
    //         }
    //         else if(button == button4){
    //             messageText.setText("This item is currently locked");
    //         }
    //     }
    // }

    class Item {
        protected boolean Equiped;
        protected boolean Bought;
        protected String name;

        public Item(){
            Equiped = false;
            Bought = false;
            name = "No name";
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

        public void setEquipped(boolean equipped){
            this.Equiped = equipped;
        }

        public void setBought(boolean Bought){
            this.Bought = Bought;
        }
    }

    class Weapon extends Item {
        protected int damage;

        public Weapon(Boolean equipped, Boolean Bought, int damage, String name){
            this.damage = damage;
            this.Bought = Bought;
            this.damage = damage;
            this.name = name;
            this.Equiped = equipped;
            
        }

        public int getDamage(){
            return this.damage;
        }





    }

    class Shield extends Item{
        protected int extraHealth;
        public Shield(Boolean equipped, Boolean Bought, int extraHealth, String name){
            this.extraHealth = extraHealth;
            this.Bought = Bought; 
            this.Equiped = equipped;
            this.name = name;
        }
        public int getExtraHealth(){
            return this.extraHealth;
        }
    }    
    
}