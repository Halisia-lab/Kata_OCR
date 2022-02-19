package org.example.utils;

import java.util.Map;
import java.util.Set;

public final class DigitsDefinition {

    public final static int PATTERN_SIZE = 3;
    public final static Map<Integer, char[][]> patterns = Map.of(

            0, new char[][]{
                    {' ', '_', ' '},
                    {'|', ' ', '|'},
                    {'|', '_', '|'}},

            1, new char[][]{
                    {' ', ' ', ' '},
                    {' ', ' ', '|'},
                    {' ', ' ', '|'}},

            2, new char[][]{
                    {' ', '_', ' '},
                    {' ', '_', '|'},
                    {'|', '_', ' '}},

            3, new char[][]{
                    {' ', '_', ' '},
                    {' ', '_', '|'},
                    {' ', '_', '|'}},

            4, new char[][]{
                    {' ', ' ', ' '},
                    {'|', '_', '|'},
                    {' ', ' ', '|'}},

            5, new char[][]{
                    {' ', '_', ' '},
                    {'|', '_', ' '},
                    {' ', '_', '|'}},

            6, new char[][]{
                    {' ', '_', ' '},
                    {'|', '_', ' '},
                    {'|', '_', '|'}},

            7, new char[][]{
                    {' ', '_', ' '},
                    {' ', ' ', '|'},
                    {' ', ' ', '|'}},

            8, new char[][]{
                    {' ', '_', ' '},
                    {'|', '_', '|'},
                    {'|', '_', '|'}},

            9, new char[][]{
                    {' ', '_', ' '},
                    {'|', '_', '|'},
                    {' ', '_', '|'}}
    );

    public static Set<Integer> possibleResults = patterns.keySet();
}
