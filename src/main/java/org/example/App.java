package org.example;

import java.io.*;

public class App 
{
    public static void main( String[] args ) throws IOException {

        InputFileReader inputFileReader = new InputFileReader("files/input.txt");
        inputFileReader.parse();

        //TODO: Read the output file

    }
}


