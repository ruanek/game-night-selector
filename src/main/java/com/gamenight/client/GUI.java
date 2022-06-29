package com.gamenight.client;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.util.Random;

public class GUI implements ActionListener {

    private JLabel label;
    private JFrame frame;
    private JPanel panel;

    public GUI() {
        frame = new JFrame();
        label = new JLabel("Choose Players");

        JCheckBox billButton = new JCheckBox("Bill");
        billButton.setMnemonic(KeyEvent.VK_C);
        billButton.setSelected(false);

        JCheckBox bobButton = new JCheckBox("Bob");
        bobButton.setMnemonic(KeyEvent.VK_C);
        bobButton.setSelected(false);

        JCheckBox carrieButton = new JCheckBox("Carrie");
        carrieButton.setMnemonic(KeyEvent.VK_C);
        carrieButton.setSelected(false);

        JCheckBox janeButton = new JCheckBox("Jane");
        janeButton.setMnemonic(KeyEvent.VK_C);
        janeButton.setSelected(false);

        JCheckBox joeButton = new JCheckBox("Joe");
        joeButton.setMnemonic(KeyEvent.VK_C);
        joeButton.setSelected(false);

        JCheckBox josephButton = new JCheckBox("Joseph");
        josephButton.setMnemonic(KeyEvent.VK_C);
        josephButton.setSelected(false);

        JCheckBox robButton = new JCheckBox("Rob");
        robButton.setMnemonic(KeyEvent.VK_C);
        robButton.setSelected(false);

        JCheckBox timButton = new JCheckBox("Tim");
        timButton.setMnemonic(KeyEvent.VK_C);
        timButton.setSelected(false);


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
        String[] games = {"Dune", "Ticket to ride", "Terraforming Mars", "Horrified", "Castle Panic", "Mysterium",
                "Pandemic Legacy", "Pandemic Rapid Response", "Villainous", "Scythe", "Wingspan", "Catan", "Werewolf",
                "Azul", "Codenames", "Powergrid", "Dominion", "Clank", "Runewars", "Brass", "King of Tokyo",
                "Dead of Winter", "Spirit Island", "Scotland Yard", "Dinosaur Island", "Horrified", "Bang", "Secret", "Rising Sun"};

        Random game = new Random();
        int randomGame = game.nextInt(games.length);
        System.out.println(games[randomGame]);

    }

    @Override
    public void actionPerformed(ActionEvent e) {
        new GUI();
    }

}
