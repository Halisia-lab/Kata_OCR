package org.example;

import org.example.utils.OutputMode;

import java.io.File;
import java.util.*;

public class FeaturesManagement {
    private final File folder;
    private List<String> filesChosen;
    private Map<Integer, String> numberedFiles;

    public FeaturesManagement(File folder) {
        this.folder = folder;
        this.filesChosen = new ArrayList<>();
        this.numberedFiles = new HashMap<>();
    }

    public List<String> getFilesChosen() {
        return filesChosen;
    }

    public Map<Integer, String> getNumberedFiles() {
        return numberedFiles;
    }

    public String chooseOutputMode() {
        System.out.println("\nChoose an output mode: ");
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

    public void listInputFiles() {
        int fileCounter = 1;
        for (File fileEntry : Objects.requireNonNull(folder.listFiles())) {
            if (fileEntry.isDirectory()) {
                listInputFiles();
            } else {
                System.out.println(fileCounter + ". "+ fileEntry.getName());
                this.numberedFiles.put(fileCounter, fileEntry.getName());
            }
            fileCounter++;
        }
    }

    public int numberOfInputFiles() {
        return Objects.requireNonNull(folder.listFiles()).length;
    }

    public int chooseNumberOfFiles() {
        System.out.println("How many files do you want to parse ? (" + numberOfInputFiles() + " found)");
        Scanner scanner = new Scanner(System.in);
        boolean isChoiceOk = false;
        while (!isChoiceOk) {
            int choice = scanner.nextInt();
            if(0 < choice && choice <= numberOfInputFiles()) {
                isChoiceOk = true;
                return choice;
            } else {
                System.out.println("Please retry... ");
            }

        }
        return 0;
    }

    public int chooseAFile(int numberOfFilesChosen) {
        Scanner scanner = new Scanner(System.in);
        boolean isChoiceOk = false;
        while (!isChoiceOk) {
            int choice = scanner.nextInt();
            if(0 < choice && choice <= numberOfFilesChosen) {
                isChoiceOk = true;
                return choice;
            } else {
                System.out.println("Please retry... ");
            }
        }
        return 0;
    }

    public void filesSelection(int numberOfFilesChosen) {
        listInputFiles();
        int numberOfFilesLeft = numberOfFilesChosen;
        while(numberOfFilesLeft > 0) {
        //for(int i = 0; i < numberOfFilesChosen; i++) {
            System.out.println("\nEnter the number corresponding to a file (" + numberOfFilesLeft + " left)" );
            String file = this.numberedFiles.get(chooseAFile(numberOfInputFiles()));
            Optional<String> alreadyExistingFile = filesChosen.stream().filter(value -> value.contains(file)).findAny();
            if(alreadyExistingFile.isPresent()) {
                System.out.println("File already token");
            } else {
                this.filesChosen.add(file);
                numberOfFilesLeft--;
            }
        }
    }
}
