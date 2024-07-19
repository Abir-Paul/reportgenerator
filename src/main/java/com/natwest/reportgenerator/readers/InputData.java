package com.natwest.reportgenerator.readers;

import com.opencsv.bean.CsvBindByName;

import java.math.BigDecimal;

/**
 * POJO Class for InputData.csv file
 */
public class InputData implements Comparable<InputData> {

    @CsvBindByName(column = "field1")
    String field1;

    @CsvBindByName(column = "field2")
    String field2;

    @CsvBindByName(column = "field3")
    String field3;

    @CsvBindByName(column = "field4")
    String field4;

    @CsvBindByName(column = "refkey1")
    String refkey1;

    @CsvBindByName(column = "refkey2")
    String refkey2;

    @CsvBindByName(column = "field5")
    BigDecimal field5;

    public String getField1() {
        return field1;
    }

    public void setField1(String field1) {
        this.field1 = field1;
    }

    public String getField2() {
        return field2;
    }

    public void setField2(String field2) {
        this.field2 = field2;
    }

    public String getField3() {
        return field3;
    }

    public void setField3(String field3) {
        this.field3 = field3;
    }

    public String getField4() {
        return field4;
    }

    public void setField4(String field4) {
        this.field4 = field4;
    }

    public String getRefkey1() {
        return refkey1;
    }

    public void setRefkey1(String refkey1) {
        this.refkey1 = refkey1;
    }

    public String getRefkey2() {
        return refkey2;
    }

    public void setRefkey2(String refkey2) {
        this.refkey2 = refkey2;
    }

    public BigDecimal getField5() {
        return field5;
    }

    public void setField5(BigDecimal field5) {
        this.field5 = field5;
    }

    /**
     * @return
     */
    @Override
    public String toString() {
        return "InputData{" +
                "field1='" + field1 + '\'' +
                ", field2='" + field2 + '\'' +
                ", field3='" + field3 + '\'' +
                ", field4='" + field4 + '\'' +
                ", refkey1='" + refkey1 + '\'' +
                ", refkey2='" + refkey2 + '\'' +
                ", field5=" + field5 +
                '}';
    }

    /**
     * @param o the object to be compared.
     * @return
     */
    @Override
    public int compareTo(InputData o) {
        if (this.getRefkey1().compareTo(o.getRefkey1()) > 0)
            return 1;
        else if (this.getRefkey1().compareTo(o.getRefkey1()) < 0)
            return -1;
        else
            return 0;
    }
}
