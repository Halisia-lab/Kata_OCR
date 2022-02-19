package org.example;

import org.example.utils.DigitsDefinition;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

public class DigitTable {
    private char[][] values;

    public DigitTable(char[][] values) {
        this.values = values;
    }

    public char[][] getValues() {
        return values;
    }

    public void setValues(char[][] values) {
        this.values = values;
    }

    public void setValue(int line, int column, String currentLineValue) {
        values[line % DigitsDefinition.PATTERN_SIZE][column % DigitsDefinition.PATTERN_SIZE] = currentLineValue.charAt(column);
    }

    public boolean matches(char[][] tab2) {
        //if(values.length != tab2.length) return false;
        for(int i = 0; i < values.length; i++) {
            for(int j = 0; j < values.length; j++) {
                if(values[i][j] != tab2[i][j]) return false;
            }
        }
        return true;
    }

    public boolean representsANumber() {
        Optional<char[][]> res = DigitsDefinition.patterns.values().stream().filter(this::matches).findAny();
        return res.isPresent();
    }

    public Integer toNumber() {
        List<Integer> number = DigitsDefinition.possibleResults.stream()
                .filter(key-> matches(DigitsDefinition.patterns.get(key))).collect(Collectors.toList());
        return number.get(0);
    }
}
