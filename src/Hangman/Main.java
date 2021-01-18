package Hangman;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws FileNotFoundException {
        System.out.println("Welcome to Hangman!");
        File dictionary = new File("C:/Users/Chrobakx/IdeaProjects/Hangman/src/Hangman/dictionary.txt");

        Scanner textScanner = new Scanner(dictionary);
        Scanner inputUser = new Scanner(System.in);

        List<String> words = new ArrayList<>();
        while (textScanner.hasNextLine()) {
            words.add(textScanner.nextLine());
        }

        String hiddenText = words.get((int)(Math.random() * words.size()));
        char[] textArray = hiddenText.toCharArray();

        char[] myAnswers = new char[textArray.length];
        for (int i = 0; i < textArray.length; i++) {
            myAnswers[i] = '?';
        }

        boolean isFinished = false;
        int lives = 6;

        while (!isFinished) {
            System.out.println("**************************************");
            System.out.println("Please enter the letter: ");
            String letter = inputUser.next();
            //checks fr valid input
            while (letter.length() != 1 || Character.isDigit(letter.charAt(0))) {
                System.out.println("Error Input - Try again");
                letter = inputUser.next();
            }

            //checks if letter is in the word
            boolean isFound = false;
            for (int i = 0; i < textArray.length; i++) {
                if (letter.charAt(0) == textArray[i]) {
                    myAnswers[i] = textArray[i];
                    isFound = true;
                }
            }

            if (!isFound) {
                lives--;
                System.out.println("Wrong letter");
            }
            boolean isDone = true;
            for (char myAnswer : myAnswers) {
                if (myAnswer == '?') {
                    System.out.print(" _");
                    isDone = false;
                } else {
                    System.out.print(" " + myAnswer);
                }
            }

            System.out.println("\n" + "Lives left: " + lives);
            drawHangman(lives);

            //checks if the game ends
            if (isDone) {
                System.out.println("Congrats You found the word");
                isFinished = true;
            }

            if (lives <= 0) {
                System.out.println("You are dead! Study your English");
                isFinished = true;
            }
        }

        System.out.println("The search word was: " + hiddenText);
    }

    public static void drawHangman(int l) {
        if(l == 6) {
            System.out.println("|----------");
            System.out.println("|");
            System.out.println("|");
            System.out.println("|");
            System.out.println("|");
            System.out.println("|");
            System.out.println("|");
        }
        else if(l == 5) {
            System.out.println("|----------");
            System.out.println("|    O");
            System.out.println("|");
            System.out.println("|");
            System.out.println("|");
            System.out.println("|");
            System.out.println("|");
        }
        else if(l == 4) {
            System.out.println("|----------");
            System.out.println("|    O");
            System.out.println("|    |");
            System.out.println("|");
            System.out.println("|");
            System.out.println("|");
            System.out.println("|");
        }
        else if(l == 3) {
            System.out.println("|----------");
            System.out.println("|    O");
            System.out.println("|   -|");
            System.out.println("|");
            System.out.println("|");
            System.out.println("|");
            System.out.println("|");
        }
        else if(l == 2) {
            System.out.println("|----------");
            System.out.println("|    O");
            System.out.println("|   -|-");
            System.out.println("|");
            System.out.println("|");
            System.out.println("|");
            System.out.println("|");
        }
        else if(l == 1) {
            System.out.println("|----------");
            System.out.println("|    O");
            System.out.println("|   -|-");
            System.out.println("|   /");
            System.out.println("|");
            System.out.println("|");
            System.out.println("|");
        }
        else{
            System.out.println("|----------");
            System.out.println("|    O");
            System.out.println("|   -|-");
            System.out.println("|   /|");
            System.out.println("|");
            System.out.println("|");
            System.out.println("|");
        }
    }
}
