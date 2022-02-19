package org.example;

import org.example.utils.ChecksumType;

public class DigitIdentifier {
    private final OutputCode outputCode;

    public DigitIdentifier() {
        this.outputCode = new OutputCode();
    }

    public OutputCode getOutputCode() {
        return outputCode;
    }

    public void identify(DigitTable digitTable) {
        if(digitTable.representsANumber()) {
            Integer result = digitTable.toNumber();
            outputCode.append(result.toString());
        } else {
            outputCode.append("?");
            outputCode.setChecksumType(ChecksumType.ILLISIBLE);
        }
    }


}
