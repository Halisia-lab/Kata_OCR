package org.example;

import java.io.IOException;
import java.io.PrintWriter;
import java.nio.charset.StandardCharsets;

public class GroupCodesWriter extends OutputFileWriter{
    private final PrintWriter writerErrored;
    private final PrintWriter writerUnknown;
    private final PrintWriter writerAuthorized;


    public GroupCodesWriter() throws IOException {
        this.writerErrored = new PrintWriter("output/group_codes/ERRORED.txt", StandardCharsets.UTF_8);
        this.writerAuthorized = new PrintWriter("output/group_codes/AUTHORIZED.txt", StandardCharsets.UTF_8);
        this.writerUnknown = new PrintWriter("output/group_codes/UNKNOWN.txt", StandardCharsets.UTF_8);
    }

    public void write(OutputCode outputCode)  {
        switch (outputCode.getChecksumType()) {
            case AUTHORIZED:
                writerAuthorized.append(outputCode.toString());
                writerAuthorized.println();
                break;
            case UNKNOWN:
                writerUnknown.append(outputCode.toString());
                writerUnknown.println();
                break;
            case ERRORED:
                writerErrored.append(outputCode.toString());
                writerErrored.println();
                break;
        }
    }
    public void close() {
        writerAuthorized.close();
        writerUnknown.close();
        writerErrored.close();
    }
}
