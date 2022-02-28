package org.example.utils;

import org.example.AllCodesWriter;
import org.example.GroupCodesWriter;
import org.example.OutputFileWriter;

import java.io.IOException;
import java.util.Map;
import java.util.Objects;

public final class OutputMode {
    
    public final static Map<Integer,String> numberedChoices = Map.of(
            1,"MIXED_CODES",
            2,"GROUPED_CODES");

    public static OutputFileWriter createOutputFileWriter(String outputModeValue) throws IOException {
        return Objects.equals(outputModeValue, "GROUPED_CODES") ? new GroupCodesWriter() : new AllCodesWriter();
    }
}
