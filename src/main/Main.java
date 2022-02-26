package org.example;
/*
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

public class Main {
    public static void main( String[] args ) throws IOException {
        Map<Integer, char[][]> mapNumbers = new HashMap<>();
        boolean lisible = true;
        StringBuilder output = new StringBuilder();
        char[][] tab1 =
                {{' ',' ',' '},
                        {' ',' ','|'},
                        {' ',' ','|'}};

        char[][] tab2 =
                {{' ','_',' '},
                        {' ','_','|'},
                        {'|','_',' '}};

        char[][] tab3 =
                {{' ','_',' '},
                        {' ','_','|'},
                        {' ','_','|'}};

        char[][] tab4 =
                {{' ',' ',' '},
                        {'|','_','|'},
                        {' ',' ','|'}};

        char[][] tab5 =
                {{' ','_',' '},
                        {'|','_',' '},
                        {' ','_','|'}};

        char[][] tab6 =
                {{' ','_',' '},
                        {'|','_',' '},
                        {'|','_','|'}};

        char[][] tab7 =
                {{' ','_',' '},
                        {' ',' ','|'},
                        {' ',' ','|'}};

        char[][] tab8 =
                {{' ','_',' '},
                        {'|','_','|'},
                        {'|','_','|'}};

        char[][] tab9 =
                {{' ','_',' '},
                        {'|','_','|'},
                        {' ','_','|'}};

        char[][] tab0 =
                {{' ','_',' '},
                        {'|',' ','|'},
                        {'|','_','|'}};

        mapNumbers.put(0,tab0);
        mapNumbers.put(1,tab1);
        mapNumbers.put(2,tab2);
        mapNumbers.put(3,tab3);
        mapNumbers.put(4,tab4);
        mapNumbers.put(5,tab5);
        mapNumbers.put(6,tab6);
        mapNumbers.put(7,tab7);
        mapNumbers.put(8,tab8);
        mapNumbers.put(9,tab9);
        char[][] current =
                {{' ',' ',' '},
                        {' ',' ',' '},
                        {' ',' ',' '}};


        int y = 0, line = 0;
        String strng;
        File file = new File("files/100_tests.txt");
        FileReader fr = new FileReader(file);
        BufferedReader br = new BufferedReader(fr);

        long nb = Files.lines(Path.of("files/100_tests.txt")).count();
        System.out.println(nb);

        while(nb <= 100 && line < nb/4) {
            line++;
            System.out.println(line);
            output = new StringBuilder();
            lisible = true;
            int x = 0;
            br.mark(100);
            while (x+3 < 30) {
                fr = new FileReader(file);
                //br = new BufferedReader(fr);
                br.reset();
                for(int i = 0; i < 3; i++) {
                    strng = br.readLine() + " ";
                    for(int j = x; j < x+3; j++) {
                        //System.out.print(strng.charAt(j));
                        //System.out.print("*"+j+"*");
                        //if(line<(nb/4))
                        current[i%3][j%3] = strng.charAt(j);
                    }//System.out.println();
                }
                x+=3;
                Optional<char[][]> res = mapNumbers.values().stream().filter(tab -> egal(tab, current)).findFirst();
                if(res.isPresent()) {
                    Optional<Integer> result = mapNumbers.keySet().stream().filter(key-> egal(current, mapNumbers.get(key))).findFirst();
                    output.append(result.get());
                } else {
                    output.append("?");
                    lisible = false;
                }
            }

            br.readLine();

            y+=3;
            if(!lisible) output.append(" ILL");
            System.out.println(output);

        }













        /*for(char[] row: current) {
            for(char ci: row) {
                System.out.print("."+ci);
            }
            System.out.println();
        }
        for(char[] row: tab2) {
            for(char ci: row) {
                System.out.print(ci);
            }
            System.out.println();
        }
    }*/
/*
    public static boolean egal(char[][] tab1, char[][] tab2) {
        if(tab1.length != tab2.length) return false;
        for(int i = 0; i < tab1.length; i++) {
            for(int j = 0; j < tab1.length; j++) {
                if(tab1[i][j] != tab2[i][j]) return false;
            }
        }
        return true;
    }
}
*/