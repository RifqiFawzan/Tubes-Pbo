package src.Game;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;

public abstract class AbstractTampilanMenu {
    public abstract void initializeFrame();
    public abstract void configureLayout(JPanel panel);
    public abstract JButton createButton(JPanel panel, String label, Color background, Color foreground, int x, int y, int width, int height, ActionListener actionListener);
    public abstract void addExitActionListener(JButton button);
    public abstract void addScoreActionListener(JButton button);
    public abstract void addPlayActionListener(JButton button);
    public abstract void showMessageDialog(String message);
    public abstract void loadImageAndSetIcon(JLabel label, String imagePath);
}