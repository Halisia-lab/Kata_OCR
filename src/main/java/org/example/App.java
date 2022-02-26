package org.example;

import java.io.*;

public class App
{
    public static void main( String[] args ) throws IOException {
        String inputFileName = FeaturesManagement.chooseInputFile();
        String outputMode = FeaturesManagement.chooseOutputMode();


        FileParser fileParser = new FileParser("entries_files/" + inputFileName, outputMode);
        fileParser.parse();
    }
}

//creer des packages pour separer ?
//plusieurs fichiers ?


