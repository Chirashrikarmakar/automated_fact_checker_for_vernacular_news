package data;

import java.io.*;
import java.util.*;

public class Dataloader {

    public List<String> loadFacts() {
        List<String> facts = new ArrayList<>();

        try {
            // Use getResource to load from classpath (place facts.txt in src/data/)
            InputStream is = getClass().getResourceAsStream("/data/facts.txt");
            if (is == null) {
                System.out.println("facts.txt not found in classpath");
                return facts;
            }
            Scanner sc = new Scanner(is);

            while (sc.hasNextLine()) {
                String line = sc.nextLine();
                facts.add(line.toLowerCase());
            }

            sc.close();
        } catch (Exception e) {
            System.out.println("Error loading facts: " + e.getMessage());
        }

        return facts;
    }
}
