package com.natwest.reportgenerator.readers;

import java.math.BigDecimal;

/**
 * POJO Class for Output.csv file
 */
public class OutputData {


    String outfield1;
    String outfield2;
    String outfield3;
    String outfield4;
    BigDecimal outfield5;

    /**
     * @param outfield1
     * @param outfield2
     * @param outfield3
     * @param outfield4
     * @param outfield5
     */
    public OutputData(String outfield1, String outfield2, String outfield3, String outfield4, BigDecimal outfield5) {
        this.outfield1 = outfield1;
        this.outfield2 = outfield2;
        this.outfield3 = outfield3;
        this.outfield4 = outfield4;
        this.outfield5 = outfield5;
    }

    /**
     * String Array representation of an object
     *
     * @return
     */
    public String[] getArrayRepresentation() {
        return new String[]{this.outfield1, this.outfield2, this.outfield3, this.outfield4, this.outfield5.toString()};
    }

    @Override
    public String toString() {
        return "OutputData{" +
                "outfield1='" + outfield1 + '\'' +
                ", outfield2='" + outfield2 + '\'' +
                ", outfield3='" + outfield3 + '\'' +
                ", outfield4='" + outfield4 + '\'' +
                ", outfield5=" + outfield5 +
                '}';
    }
}
