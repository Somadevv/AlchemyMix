package com.alchemymix.ui;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ComponentAdapter;
import java.awt.event.ComponentEvent;

/**
 * A JButton that scales its size and font automatically
 * whenever the parent frame is resized.
 */
public class MainMenuButton extends JButton {

    // Constants (shared across all buttons)
    private static final int MIN_WIDTH = 100;
    private static final int MIN_HEIGHT = 40;
    private static final int H_PADDING = 40;
    private static final int V_PADDING = 20;

    public MainMenuButton(String text, JFrame parentFrame) {
        super(text);

        // Listen for frame resize
        parentFrame.addComponentListener(new ComponentAdapter() {
            @Override
            public void componentResized(ComponentEvent e) {
                resizeToFit(parentFrame);
            }
        });

        // Initial sizing
        resizeToFit(parentFrame);
    }

    private void resizeToFit(JFrame frame) {
        int frameWidth = frame.getWidth();
        int frameHeight = frame.getHeight();

        // Scale font based on smaller dimension
        int fontSize = Math.max(12, Math.min(frameWidth, frameHeight) / 20);
        Font font = new Font("Arial", Font.BOLD, fontSize);
        setFont(font);

        // Measure text size with new font
        FontMetrics fm = getFontMetrics(font);
        int textWidth = fm.stringWidth(getText());
        int textHeight = fm.getHeight();

        // Add padding
        int buttonWidth = textWidth + H_PADDING;
        int buttonHeight = textHeight + V_PADDING;

        // Prevent tiny button
        buttonWidth = Math.max(buttonWidth, MIN_WIDTH);
        buttonHeight = Math.max(buttonHeight, MIN_HEIGHT);

        // Apply dimensions
        Dimension size = new Dimension(buttonWidth, buttonHeight);
        setPreferredSize(size);
        setMinimumSize(size);
        setMaximumSize(size);

        revalidate();
    }
}
