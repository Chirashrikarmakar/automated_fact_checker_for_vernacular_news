package controller;

import java.util.Scanner;

public class InputController {

    public String getUserInput() {

        Scanner sc = new Scanner(System.in);

        System.out.println("Enter a news statement to verify:");
        String inputNews = sc.nextLine();
         sc.close();

        return inputNews.toLowerCase();
    }
}
