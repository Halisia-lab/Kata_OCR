package org.example.utils;

import org.example.utils.ChecksumType;

import java.util.Map;


public class ChecksumStatus {
    public final static Map<ChecksumType, String> outputValues = Map.of(
            ChecksumType.AUTHORIZED, "",
            ChecksumType.UNKNOWN, "ILL",
            ChecksumType.ERRORED, "ERR"
    );





}
