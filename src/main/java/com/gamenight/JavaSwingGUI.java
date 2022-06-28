package com.gamenight;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class JavaSwingGUI implements ActionListener {

    private JLabel label;
    private JFrame frame;
    private JPanel panel;

    public JavaSwingGUI() {

        frame = new JFrame();
        label = new JLabel("Tonight's Game");
        JButton button = new JButton("Choose Players");
        button.addActionListener(this);
        button.setBackground(Color.PINK);
        button.setForeground(Color.BLACK);



        panel = new JPanel();
        panel.setBorder(BorderFactory.createEmptyBorder(30, 30, 10, 30));
        panel.setLayout(new GridLayout(0, 1));
        panel.add(button);
        panel.add(label);

        frame.add(panel, BorderLayout.CENTER);
        frame.setTitle("Game Night Selector");
        frame.pack();
        frame.setVisible(true);

    }

    public static void main(String[] args) {
        new JavaSwingGUI();
    }

    @Override
    public void actionPerformed(ActionEvent e) {

    }
}
