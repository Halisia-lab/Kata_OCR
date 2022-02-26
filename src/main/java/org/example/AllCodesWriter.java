package org.example;

import org.example.utils.ChecksumType;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.PrintWriter;
import java.io.UnsupportedEncodingException;
import java.nio.charset.StandardCharsets;
import java.time.LocalDate;
import java.time.LocalDateTime;

public class AllCodesWriter extends OutputFileWriter {
    private final PrintWriter writer;

    public AllCodesWriter() throws IOException {
       super();
       String outputFileName = LocalDate.now().toString() + LocalDateTime.now().getHour() + LocalDateTime.now().getMinute() + LocalDateTime.now().getSecond();
       this.writer = new PrintWriter("output/all_codes/" + outputFileName + ".txt", StandardCharsets.UTF_8);

    }

    @Override
    public void write(OutputCode outputCode) {
        writer.append(outputCode.toString());
        writer.println();
    }

    @Override
    public void close() {
        writer.close();
    }
}
