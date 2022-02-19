package org.example;

import org.example.utils.ChecksumType;

import java.util.Map;


public class Checksum {
    public final static Map<ChecksumType, String> outputValues = Map.of(
            ChecksumType.AUTHORIZED, "",
            ChecksumType.UNKNOWN, "ERR",
            ChecksumType.ILLISIBLE, "ILL"
    );



}
