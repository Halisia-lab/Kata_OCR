package org.example;

import org.example.utils.ChecksumStatus;
import org.example.utils.ChecksumType;

import java.util.ArrayList;
import java.util.List;

public class OutputCode {

    private final List<String> values;
    private ChecksumType checksumType;

    public OutputCode() {
        this.values = new ArrayList<>();
        this.checksumType = ChecksumType.AUTHORIZED;
    }

    public ChecksumType getChecksumType() {
        return checksumType;
    }

    public void append(String value) {
        this.values.add(value);
        if(value.equals("?")) this.checksumType = ChecksumType.UNKNOWN;
    }

    public void setChecksumType(ChecksumType checksumType) {
        this.checksumType = checksumType;
    }

    public List<String> getValues() {
        return values;
    }

    @Override
    public String toString() {
        StringBuilder stringValues = new StringBuilder();
        for(String outputNumber: this.values ) {
            stringValues.append(outputNumber);
        }
        return stringValues + " " + ChecksumStatus.outputValues.get(this.checksumType);
    }
}
