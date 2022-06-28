package com.gamenight;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;

public class GUI implements ActionListener {

    private JLabel label;
    private JFrame frame;
    private JPanel panel;

    public GUI() {
        frame = new JFrame();
        label = new JLabel("Choose Players");

        JCheckBox billButton = new JCheckBox("Bill");
        billButton.setMnemonic(KeyEvent.VK_C);
        billButton.setSelected(true);

        JCheckBox bobButton = new JCheckBox("Bob");
        bobButton.setMnemonic(KeyEvent.VK_C);
        bobButton.setSelected(true);

        JCheckBox carrieButton = new JCheckBox("Carrie");
        carrieButton.setMnemonic(KeyEvent.VK_C);
        carrieButton.setSelected(true);

        JCheckBox janeButton = new JCheckBox("Jane");
        janeButton.setMnemonic(KeyEvent.VK_C);
        janeButton.setSelected(true);

        JCheckBox joeButton = new JCheckBox("Joe");
        joeButton.setMnemonic(KeyEvent.VK_C);
        joeButton.setSelected(true);

        JCheckBox josephButton = new JCheckBox("Joseph");
        josephButton.setMnemonic(KeyEvent.VK_C);
        josephButton.setSelected(true);

        JCheckBox robButton = new JCheckBox("Rob");
        robButton.setMnemonic(KeyEvent.VK_C);
        robButton.setSelected(true);

        JCheckBox timButton = new JCheckBox("Tim");
        timButton.setMnemonic(KeyEvent.VK_C);
        timButton.setSelected(true);


        JButton button = new JButton("Choose Game");
        button.addActionListener(this);
        button.setBackground(Color.PINK);
        button.setForeground(Color.BLACK);



        panel = new JPanel();
        panel.setBorder(BorderFactory.createEmptyBorder(30, 30, 10, 30));
        panel.setLayout(new GridLayout(0, 1));
        panel.add(label);
        panel.add(billButton);
        panel.add(bobButton);
        panel.add(carrieButton);
        panel.add(janeButton);
        panel.add(joeButton);
        panel.add(josephButton);
        panel.add(robButton);
        panel.add(timButton);
        panel.add(button);

        frame.add(panel, BorderLayout.CENTER);
        frame.setTitle("Game Night Selector");
        frame.pack();
        frame.setVisible(true);

    }

    public static void main(String[] args) {
        new GUI();
    }

    @Override
    public void actionPerformed(ActionEvent e) {

    }
}
