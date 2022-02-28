package org.example;

import org.example.utils.OutputMode;

import java.io.*;
import java.util.Objects;

public class App
{
    public static void main( String[] args ) throws IOException {




        File folder = new File("entries_files");
        FeaturesManagement featuresManagement = new FeaturesManagement(folder);
        int number = featuresManagement.chooseNumberOfFiles();
        featuresManagement.filesSelection(number);
        String outputMode = featuresManagement.chooseOutputMode();
        OutputFileWriter outputFileWriter = OutputMode.createOutputFileWriter(outputMode);
        System.out.println(featuresManagement.getNumberedFiles().toString());
        for(String fileName: featuresManagement.getFilesChosen()) {
            //String inputFileName = featuresManagement.chooseInputFile();


            FileParser fileParser = new FileParser("entries_files/" + fileName, outputMode);
            fileParser.parse(outputFileWriter);
        }
        outputFileWriter.close();
        //System.out.println(FeaturesManagement.listFilesForFolder(folder));


    }


}

//creer des packages pour separer ?
//plusieurs fichiers ?


//combien tu veux
//1 mode / ficher

