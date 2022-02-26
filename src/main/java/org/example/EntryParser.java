package org.example;

import org.example.utils.ChecksumType;
import org.example.utils.EntryDetails;

import java.io.BufferedReader;
import java.io.IOException;
import java.util.Objects;

public class EntryParser {

    private int currentColumnCount;
    BufferedReader bufferedReader;
    private final DigitTable currentDigitResult;
    private final DigitIdentifier digitIdentifier;
    private final OutputFileWriter outputFileWriter;

    public EntryParser(BufferedReader bufferedReader, OutputFileWriter outputFileWriter) {
        this.currentColumnCount = 0;
        this.bufferedReader = bufferedReader;
        this.currentDigitResult = new DigitTable(new char[][]{
                {' ',' ',' '},
                {' ',' ',' '},
                {' ',' ',' '}}
        );
        this.digitIdentifier = new DigitIdentifier();
        this.outputFileWriter = outputFileWriter;

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
                    currentDigitResult.setValue(i,j, currentLineValue);
                }
            }
            increaseColumnCount(EntryDetails.DIGIT_WEIGHT);
            digitIdentifier.identify(currentDigitResult);
        }

            digitIdentifier.calculateChecksum();
            outputFileWriter.write(digitIdentifier.getOutputCode());
        return digitIdentifier.getOutputCode();
    }
}
