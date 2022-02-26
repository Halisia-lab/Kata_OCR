package org.example;

import org.example.utils.EntryDetails;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Objects;

public class FileParser {

    FileReader fileReader;
    BufferedReader bufferedReader;
    private final int fileSize;
    private int currentLineCount;
    private final String outputModeValue;

    FileParser(String filePath, String outputModeValue) throws IOException {
        fileSize = (int) Files.lines(Path.of(filePath)).count();
        File file = new File(filePath);
        fileReader = new FileReader(file);
        bufferedReader = new BufferedReader(fileReader);
        this.outputModeValue = outputModeValue;
        currentLineCount = 0;
    }

    public void nextLine() throws IOException {
        this.bufferedReader.readLine();
    }

    public boolean endOfFile() {
        return currentLineCount == fileSize / EntryDetails.LINE_HEIGHT;
    }

    public OutputFileWriter createOutputFileWriter() throws IOException {
        return Objects.equals(outputModeValue, "GROUPED_CODES") ? new GroupCodesWriter() : new AllCodesWriter();
    }

    public void parse() throws IOException {
       OutputFileWriter outputFileWriter = createOutputFileWriter();
        while(!endOfFile()) {
            currentLineCount++;
            bufferedReader.mark(100);

            EntryParser entryParser = new EntryParser(bufferedReader, outputFileWriter);
            System.out.println(entryParser.parse());
            nextLine();
        }
        outputFileWriter.close();
    }
}
