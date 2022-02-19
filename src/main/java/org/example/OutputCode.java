package org.example;

import org.example.utils.ChecksumType;

public class OutputCode {
    private final StringBuilder value;
    private ChecksumType checksumType;

    public OutputCode() {
        this.value = new StringBuilder();
        this.checksumType = ChecksumType.AUTHORIZED;
    }

    public void append(String value) {
        this.value.append(value);
    }

    public void setChecksumType(ChecksumType checksumType) {
        this.checksumType = checksumType;
    }

    @Override
    public String toString() {
        return this.value + " " + Checksum.outputValues.get(this.checksumType);
    }
}
