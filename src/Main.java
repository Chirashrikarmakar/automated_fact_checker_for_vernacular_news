import controller.InputController;
import controller.ResultController;
import service.FactService;
import data.dataloader;
import model.Fact;

import java.util.ArrayList;
import java.util.List;

public class Main {

    public static void main(String[] args) {

        // Step 1: Take input
        InputController inputController = new InputController();
        String news = inputController.getUserInput();

        // Step 2: Load facts (List<String>)
        dataloader loader = new dataloader();
        List<String> factStrings = loader.loadFacts();

        // Step 3: Convert String facts → Fact objects
        List<Fact> facts = new ArrayList<>();

        for (String factText : factStrings) {
            facts.add(new Fact(factText));
        }

        // Step 4: Check fact
        FactService factService = new FactService();
        String result = factService.checkFact(news, facts);

        // Step 5: Show result
        ResultController resultController = new ResultController();
        resultController.showResult(result);
    }
}
