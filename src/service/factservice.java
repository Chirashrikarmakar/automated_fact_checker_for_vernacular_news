package service;

import java.util.List;
import model.Fact;
import java.net.HttpURLConnection;
import java.net.URL;
import java.io.*;

public class FactService {

    // 🔑 Paste your ScaleDown API key here
    private static final String API_KEY = "dfok5YrHSg3HJp3TmJ8n7JJ8MxwrpQY6wX2Tx5Jc";

    public String checkFact(String news, List<Fact> facts) {

        try {
            URL url = new URL("https://api.scaledown.ai/v1/chat/completions");
            HttpURLConnection conn = (HttpURLConnection) url.openConnection();

            conn.setRequestMethod("POST");
            conn.setRequestProperty("Authorization", "Bearer " + API_KEY);
            conn.setRequestProperty("Content-Type", "application/json");
            conn.setDoOutput(true);

            String input = "{ \"model\": \"gpt-3.5-turbo\", \"messages\": [{\"role\": \"user\", \"content\": \"Check if this statement is true or false in one line: " + news + "\"}] }";

            OutputStream os = conn.getOutputStream();
            os.write(input.getBytes());
            os.flush();
            os.close();

            BufferedReader br = new BufferedReader(
                    new InputStreamReader(conn.getInputStream())
            );

            StringBuilder response = new StringBuilder();
            String line;

            while ((line = br.readLine()) != null) {
                response.append(line);
            }

            br.close();

            return "AI Result: " + response.toString();

        } catch (Exception e) {

            
            for (Fact fact : facts) {

                    String newsLower = news.toLowerCase();
                    String factLower = fact.getFactText().toLowerCase();

                    if (newsLower.contains(factLower)) {

                        return "Likely True (Confidence: 90%)\nMatched Fact: " + fact.getFactText();
    }
}
            }

           return "Needs Verification (Confidence: 40%)";
        }
    }
