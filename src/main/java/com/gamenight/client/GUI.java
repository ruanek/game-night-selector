package com.gamenight.client;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Random;

public class GUI implements ActionListener {

    private JLabel label;
    private JFrame frame;
    private JPanel panel;
    // TODO declare a set that will hold selected players

    public GUI() {
        frame = new JFrame();
        label = new JLabel("Choose Players");
        // TODO initialize set of player
        ActionListener checkboxListener = (event) -> {
            JCheckBox source = (JCheckBox) event.getSource();
            System.out.println(source.isSelected()); // FIXME remove this output
            System.out.println(source.getText()); //FIXME remove this output
            // TODO Add or remove player associated with button from the set of selected players
        };


        JCheckBox billButton = new JCheckBox("Bill");
        billButton.setSelected(false);
        billButton.addActionListener(checkboxListener);

        JCheckBox bobButton = new JCheckBox("Bob");
        bobButton.setSelected(false);
        bobButton.addActionListener(checkboxListener);


        JCheckBox carrieButton = new JCheckBox("Carrie");
        carrieButton.setSelected(false);
        carrieButton.addActionListener(checkboxListener);


        JCheckBox janeButton = new JCheckBox("Jane");
        janeButton.setSelected(false);
        janeButton.addActionListener(checkboxListener);


        JCheckBox joeButton = new JCheckBox("Joe");
        joeButton.setSelected(false);
        joeButton.addActionListener(checkboxListener);


        JCheckBox josephButton = new JCheckBox("Joseph");
        josephButton.setSelected(false);
        josephButton.addActionListener(checkboxListener);


        JCheckBox robButton = new JCheckBox("Rob");
        robButton.setSelected(false);
        robButton.addActionListener(checkboxListener);


        JCheckBox timButton = new JCheckBox("Tim");
        timButton.setSelected(false);
        timButton.addActionListener(checkboxListener);



        JButton button = new JButton("Choose Game");
        button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JDialog dialog = new JDialog(frame, "This is tonight's game!", true);
                dialog.setLocationRelativeTo(frame);
                dialog.setVisible(true);
            }
        });
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
