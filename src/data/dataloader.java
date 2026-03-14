package service;

import java.io.*;
import java.util.*;

public class dataloader {

    public List<String> loadFacts() {
        List<String> facts = new ArrayList<>();

        try {
            File file = new File("src/data/facts.txt");
            Scanner sc = new Scanner(file);

            while (sc.hasNextLine()) {
                String line = sc.nextLine();
                facts.add(line.toLowerCase());
            }

            sc.close();
        } catch (FileNotFoundException e) {
            System.out.println("facts.txt file not found");
        }

        return facts;
    }
}
