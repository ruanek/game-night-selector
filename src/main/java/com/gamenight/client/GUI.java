package com.gamenight.client;

import com.gamenight.CSVParserGameNightSelector;
import com.gamenight.PlayerInfo;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class GUI implements ActionListener {
    private JLabel label;
    private JFrame frame;
    private JPanel panel;

    public GUI() {
        ArrayList<PlayerInfo> playersArray = CSVParserGameNightSelector.getPlayerInfo();
        ArrayList<PlayerInfo> playersInAttendance = new ArrayList<>();
        Map<String, PlayerInfo> playersMap = new HashMap<>();

        label = new JLabel("Choose Players");
        panel = new JPanel();
        frame = new JFrame();

        JButton chooseGameButton = new JButton("Choose Game");
        chooseGameButton.setBackground(Color.PINK);
        chooseGameButton.setForeground(Color.BLACK);
        panel.setBorder(BorderFactory.createEmptyBorder(30, 30, 10, 30));
        panel.setLayout(new GridLayout(0, 1));

        chooseGameButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
//                JDialog dialog = new JDialog(frame, "This is tonight's game!", true);
//                dialog.setBounds(300, 300, 300, 300);
//                dialog.setLocationRelativeTo(frame);
//                dialog.setVisible(true);
                JOptionPane.showMessageDialog(frame,
                        "Tonight's Lucky Game is...",
                        "Game Night Selector",
                        JOptionPane.PLAIN_MESSAGE);
            }
        });

        ActionListener checkboxListener = (event) -> {
            JCheckBox source = (JCheckBox) event.getSource();
            System.out.printf("Checkbox %s is selected: %s\n", source.getText(), source.isSelected());
            // if the JCheckBox isSelected, add that player to the playersInAttendance array
            // else JCheckBox isSelected is false, remove that player from the array
            if (source.isSelected()) {
                playersInAttendance.add(playersMap.get(source.getText()));
                System.out.printf("Player %s was added to the playersInAttendance Array\n\n", playersMap.get(source.getText()).getPlayerName());
            } else {
                playersInAttendance.remove(playersMap.get(source.getText()));
                System.out.printf("Player %s was removed from the playersInAttendance Array\n\n", playersMap.get(source.getText()).getPlayerName());
            }
        };

        panel.add(label);
        // create all of JCheckBox objects and add them to the panel, set them to unchecked by default
        // add each playersName, PlayerInfo obj reference as (k,v) pairs in a playersMap
        for (PlayerInfo player : playersArray) {
            JCheckBox playerCheckbox = new JCheckBox(player.getPlayerName());
            playerCheckbox.setSelected(false);
            playerCheckbox.addActionListener(checkboxListener);
            panel.add(playerCheckbox);
            playersMap.put(player.getPlayerName(), player);
        }
        // add choose game button at the bottom of the gui
        panel.add(chooseGameButton);

        frame.add(panel, BorderLayout.CENTER);
        frame.setTitle("Game Night Selector");
        frame.pack();
        frame.setVisible(true);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    public static void main(String[] args) {
        new GUI();
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        new GUI();
    }
}
