import javax.swing.*;
import java.awt.*;

public class taskGUI {

    //device width and length variables that are passed to constructor
    private final Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();

    taskGUI(){
        int length = (int) screenSize.getHeight();
        int width = (int) screenSize.getWidth();
    }

    public int getWidth(){
        return (int) screenSize.getWidth();
    }

    public int getLength(){
        return (int) screenSize.getHeight();
    }

    public void genUI(){
        JFrame frame = new JFrame();
        frame.setSize(this.getWidth(), this.getLength());
        frame.setLayout(null);
        frame.setVisible(true);

        addButtonWithListener(frame, "test");
    }

    //TODO: add function for button listeners
    public static void addButtonWithListener(JFrame frame, String text) {
        JButton button = new JButton(text);
        button.setBounds(frame.getWidth() / 2, frame.getHeight() / 2, 200, 100);
        button.addActionListener(e -> testButtonPressed(frame));
        frame.add(button);
    }

    //BUTTONS  ACTIONS SECTION
    private static void testButtonPressed(JFrame frame) {
        String taskInput = JOptionPane.showInputDialog("Enter task...");

        JLabel task = new JLabel(taskInput);
        frame.add(task);
        task.setVisible(true);
    }


}
