package org.example;

import org.example.utils.EntryDetails;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

public class EntryParser {

    private int currentColumnCount;
    BufferedReader bufferedReader;
    private final DigitTable currentDigit;
    private DigitIdentifier digitIdentifier;

    public EntryParser(BufferedReader bufferedReader) {
        this.currentColumnCount = 0;
        this.bufferedReader = bufferedReader;
        this.digitIdentifier = new DigitIdentifier();
        this.currentDigit = new DigitTable(new char[][]{
                {' ',' ',' '},
                {' ',' ',' '},
                {' ',' ',' '}}
        );

    }

    public boolean endOfEntry() {
        return currentColumnCount == EntryDetails.NB_COLUMNS;
    }

    public void increaseColumnCount(int columns) {
        currentColumnCount += columns;
    }
    public void backToLastMark() throws IOException {
        bufferedReader.reset();
    }

    public String nextLine() throws IOException {
        return this.bufferedReader.readLine();
    }

    public OutputCode parse() throws IOException {
        while (!endOfEntry()) {
            backToLastMark();
            for(int i = 0; i < EntryDetails.DIGIT_HEIGHT; i++) {
                String currentLineValue = nextLine() + " ";
                for(int j = currentColumnCount; j < currentColumnCount + EntryDetails.DIGIT_WEIGHT; j++) {
                    currentDigit.setValue(i,j, currentLineValue);
                }
            }
            increaseColumnCount(EntryDetails.DIGIT_WEIGHT);
            digitIdentifier.identify(currentDigit);
        }
        return digitIdentifier.getOutputCode();
    }
}
