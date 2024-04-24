import javax.swing.*;
import javax.swing.plaf.basic.BasicButtonUI;
import java.awt.*;

class RoundedButtonUI extends BasicButtonUI {
    private final int cornerRadius;
    private static final Color BORDER_COLOR = Color.DARK_GRAY; // Constant for border color

    public RoundedButtonUI(int cornerRadius) {
        this.cornerRadius = cornerRadius;
    }

    @Override
    public void installUI(JComponent c) {
        super.installUI(c);
        AbstractButton button = (AbstractButton) c;
        button.setOpaque(false);
        button.setBorder(BorderFactory.createEmptyBorder(5, 10, 5, 10));
    }

    @Override
    public void paint(Graphics g, JComponent c) {
        Graphics2D g2 = (Graphics2D) g.create();
        g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);

        AbstractButton b = (AbstractButton) c;
        int width = b.getWidth();
        int height = b.getHeight();

        g2.setColor(b.getBackground());
        g2.fillRoundRect(0, 0, width, height, cornerRadius, cornerRadius);

        // Draw the border
        g2.setColor(BORDER_COLOR); // Use the constant border color
        g2.drawRoundRect(0, 0, width - 1, height - 1, cornerRadius, cornerRadius);

        g2.dispose();
    }
}