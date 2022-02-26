package org.example;

import org.example.utils.OutputMode;

import java.io.File;
import java.util.Scanner;

public class FeaturesManagement {

    public static String chooseOutputMode() {
        System.out.println("Choose a output : ");
        System.out.println("1. All codes in a file");
        System.out.println("2. Group codes");

        Scanner scanner = new Scanner(System.in);
        boolean isChoiceOk = false;
        while (!isChoiceOk) {
            int choice = scanner.nextInt();
            if(1 <= choice && choice <= 2) {
                isChoiceOk = true;
                return OutputMode.numberedChoices.get(choice);
            } else {
                System.out.println("Please retry... ");
            }
        }
        return null;
    }

    public static String chooseInputFile() {
        System.out.println("Enter the file name : ");

        Scanner scanner = new Scanner(System.in);
        boolean isChoiceOk = false;
        while (!isChoiceOk) {
            String choice = scanner.nextLine();
            File f = new File("entries_files/" + choice);
            if(f.exists() && !f.isDirectory()) {
                isChoiceOk = true;
                return choice;
            } else {
                System.out.println("Please retry... ");
            }
        }
        return null;
    }
}
