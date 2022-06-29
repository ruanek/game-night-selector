package com.gamenight.client;

import com.gamenight.CSVParserGameNightSelector;
import com.gamenight.PlayerInfo;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class GUI implements ActionListener {
    private JLabel label;
    private JFrame frame;
    private JPanel panel;

    public GUI() {
        ArrayList<PlayerInfo> playersArray = CSVParserGameNightSelector.getPlayerInfo();
        frame = new JFrame();
        label = new JLabel("Choose Players");
        panel = new JPanel();

        JButton chooseGameButton = new JButton("Choose Game");
        chooseGameButton.setBackground(Color.PINK);
        chooseGameButton.setForeground(Color.BLACK);
        panel.setBorder(BorderFactory.createEmptyBorder(30, 30, 10, 30));
        panel.setLayout(new GridLayout(0, 1));

        chooseGameButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JDialog dialog = new JDialog(frame, "This is tonight's game!", true);
                dialog.setBounds(500,500,500,500);
                dialog.setLocationRelativeTo(frame);
                dialog.setVisible(true);
            }
        });

        ActionListener checkboxListener = (event) -> {
            JCheckBox source = (JCheckBox) event.getSource();
            System.out.printf("Checkbox %s is selected: %s\n", source.getText(), source.isSelected());
            // TODO Add or remove player associated with button from the set of selected players
        };
        panel.add(label);
        for(PlayerInfo player : playersArray) {
            JCheckBox playerCheckbox = new JCheckBox(player.getPlayerName());
            playerCheckbox.setSelected(false);
            playerCheckbox.addActionListener(checkboxListener);
            panel.add(playerCheckbox);
        }
        panel.add(chooseGameButton);


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
        new GUI();
    }
}
