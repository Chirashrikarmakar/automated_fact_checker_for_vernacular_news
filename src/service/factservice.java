package service;

import java.util.List;
import model.Fact;

public class FactService {

    public String checkFact(String news, List<Fact> facts) {

        for (Fact fact : facts) {
            if (fact.getFactText().equalsIgnoreCase(news)) {
                return "Likely True";
            }
        }

        return "Needs Verification";
    }
}