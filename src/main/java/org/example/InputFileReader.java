package org.example;

import org.example.utils.EntryDetails;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

public class InputFileReader {

    FileReader fileReader;
    BufferedReader bufferedReader;
    private final int fileSize;
    private int currentLineCount;

    public InputFileReader(String filePath) throws IOException {
        fileSize = (int) Files.lines(Path.of(filePath)).count();
        File file = new File(filePath);
        fileReader = new FileReader(file);
        bufferedReader = new BufferedReader(fileReader);
        currentLineCount = 0;
    }

     public void nextLine() throws IOException {
        this.bufferedReader.readLine();
    }

    public boolean endOfFile() {
        return currentLineCount == fileSize / EntryDetails.LINE_HEIGHT;
    }

    public void parse() throws IOException {
        while(!endOfFile()) {
            currentLineCount++;
            bufferedReader.mark(100);

            EntryParser entryParser = new EntryParser(bufferedReader);

            //TODO: Create an output writer
            System.out.println(entryParser.parse());
            nextLine();
        }
    }
}
