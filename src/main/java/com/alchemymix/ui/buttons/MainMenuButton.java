package com.alchemymix.ui.buttons;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ComponentAdapter;
import java.awt.event.ComponentEvent;

/**
 * A JButton that scales its size and font automatically
 * whenever the parent frame is resized.
 */
public class MainMenuButton extends JButton {

    private static final int MIN_WIDTH = 120;
    private static final int MIN_HEIGHT = 40;
    private static final int H_PADDING = 30;
    private static final int V_PADDING = 15;

    public MainMenuButton(String text, JFrame parentFrame) {
        super(text);
        setFocusPainted(false);

        parentFrame.addComponentListener(new ComponentAdapter() {
            @Override
            public void componentResized(ComponentEvent e) {
                resizeToFit(parentFrame);
            }
        });

        resizeToFit(parentFrame);
    }

    private void resizeToFit(JFrame frame) {
        int frameWidth = frame.getWidth();
        int frameHeight = frame.getHeight();

        // font smaller scaling
        int fontSize = Math.max(14, Math.min(frameWidth, frameHeight) / 25);
        Font font = new Font("SansSerif", Font.BOLD, fontSize);
        setFont(font);

        FontMetrics fm = getFontMetrics(font);
        int textWidth = fm.stringWidth(getText());
        int textHeight = fm.getHeight();

        int buttonWidth = Math.max(textWidth + H_PADDING, MIN_WIDTH);
        int buttonHeight = Math.max(textHeight + V_PADDING, MIN_HEIGHT);

        Dimension size = new Dimension(buttonWidth, buttonHeight);
        setPreferredSize(size);
        setMinimumSize(size);
        setMaximumSize(size);

        revalidate();
    }
}
