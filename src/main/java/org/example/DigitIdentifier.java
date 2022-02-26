package org.example;

import org.example.utils.ChecksumCalculation;
import org.example.utils.ChecksumType;

public class DigitIdentifier {
    private final OutputCode outputCode;

    public DigitIdentifier() {
        this.outputCode = new OutputCode();
    }

    public OutputCode getOutputCode()  {
        return outputCode;
    }

    public void identify(DigitTable digitTable) {
        if(digitTable.representsANumber()) {
            Integer result = digitTable.toNumber();
            outputCode.append(result.toString());
        } else {
            outputCode.append("?");
        }
    }

    public void calculateChecksum() {
        if(this.outputCode.getChecksumType() != ChecksumType.UNKNOWN) {
            int sum = 0;
            for(int i = 0; i < outputCode.getValues().size() ; i++) {
                sum += Integer.parseInt(outputCode.getValues().get(i))*(ChecksumCalculation.indexPositionHelper.get(i));
            }
            if(sum % ChecksumCalculation.MODULO_VALUE != 0) outputCode.setChecksumType(ChecksumType.ERRORED);
        }
    }


}
