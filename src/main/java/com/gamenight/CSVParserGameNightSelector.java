package com.gamenight;

import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVRecord;

import java.io.FileReader;
import java.io.IOException;
import java.io.Reader;

public class CSVParserGameNightSelector {
    public static void main(String[] args) {

        String path = "src/main/resources/PlayerInfo.csv";

        try (Reader in = new FileReader(path)) {
            for (CSVRecord row : CSVFormat.EXCEL.parse(in)) {
                if (row.get(0).equals("Name")) {
                    continue;
                }
                    String name = row.get(0);
                    String age = row.get(1);
                    String gameType = row.get(2);
                    System.out.println("Name: " + name + ", Age: " + age + ", GameType: " + gameType);

            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
