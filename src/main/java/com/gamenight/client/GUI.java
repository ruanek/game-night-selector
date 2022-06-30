package com.gamenight.client;

import com.gamenight.CSVParserGameNightSelector;
import com.gamenight.GetAGame;
import com.gamenight.PlayerInfo;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class GUI {
    private final JFrame frame = new JFrame();

    public GUI() {
        ArrayList<PlayerInfo> playersArray = CSVParserGameNightSelector.getPlayerInfo();
        ArrayList<PlayerInfo> playersInAttendance = new ArrayList<>();
        Map<String, PlayerInfo> playersMap = new HashMap<>();

        JPanel container = new JPanel();
        container.setBorder(BorderFactory.createEmptyBorder(30, 30, 10, 30));
        container.setLayout(new BoxLayout(container, BoxLayout.Y_AXIS));
        container.add(new JLabel("Choose Players"));

        JPanel panel = new JPanel();
        panel.setLayout(new GridLayout(0, 1));

        // create JButton that we will click and this will filter out the games
        JButton chooseGameButton = new JButton("Choose Game");
        chooseGameButton.setBackground(Color.PINK);
        chooseGameButton.setForeground(Color.BLACK);
        // create chooseGameButton Action Listener with a lambda expression
        chooseGameButton.addActionListener((event) -> {
            StringBuilder printMe = new StringBuilder();
            System.out.printf("PlayersInAttendance Array Size: %d\n", playersInAttendance.size());
            System.out.print("[ ");
            int i = 0;
            for (PlayerInfo playerInfo : playersInAttendance) {
                if (i == playersInAttendance.size() - 1) {
                    System.out.print(playerInfo.getPlayerName());
                    printMe.append(playerInfo.getPlayerName());
                } else {
                    System.out.print(playerInfo.getPlayerName() + ", ");
                    printMe.append(playerInfo.getPlayerName()).append(", ");
                }
                i++;
            }
            printMe.append(" will be playing");
            System.out.print(" ]\n");

            String gameName = GetAGame.pickAGame(playersInAttendance).getGameName();
            JDialog dialog = new JDialog(frame, String.valueOf(printMe), true);
            dialog.setBounds(300, 300, 400, 200);
            dialog.setLocationRelativeTo(frame);
            dialog.add(new JLabel(gameName, JLabel.CENTER));
            dialog.setVisible(true);
            System.out.printf("The game we will be playing is: %s\n", gameName);
        });

        // create all of JCheckBox objects and add them to the panel, set them to unchecked by default
        // add each playersName, PlayerInfo obj reference as (k,v) pairs in a playersMap
        for (PlayerInfo player : playersArray) {
            JCheckBox playerCheckbox = new JCheckBox(player.getPlayerName());
            playerCheckbox.setSelected(false);
            // create playerCheckBox Action Listener with a lambda expression
            playerCheckbox.addActionListener((event) -> {
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
            });
            // add the completed checkbox to the gui and populate the map with it's (k,v)
            panel.add(playerCheckbox, BorderLayout.WEST);
            playersMap.put(player.getPlayerName(), player);
        }

        container.add(panel);
        // add image to panel
        String path = "src/main/resources/game-night-image.jpeg";
        ImageIcon image = new ImageIcon(path);
        JLabel imageLabel = new JLabel(image);
        imageLabel.setPreferredSize(new Dimension(340, 160));
        container.add(imageLabel);

        // add choose game button at the bottom of the gui
        container.add(chooseGameButton);

        frame.add(container, BorderLayout.CENTER);
        frame.setTitle("Game Night Selector");
        frame.pack();
        frame.setSize(400, 800);
        // places the gui in the middle of the screen when it opens
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        container.repaint();
    }

    public static void main(String[] args){
        new GUI();
    }
}
