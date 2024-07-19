package com.natwest.reportgenerator.readers;

import com.opencsv.bean.CsvBindByName;

import java.math.BigDecimal;

/**
 * POJO class for reference.csv file
 */
public class InputReferenceData implements Comparable<InputReferenceData> {

    @CsvBindByName(column = "refkey1")
    String refkey1;

    @CsvBindByName(column = "refdata1")
    String refdata1;

    @CsvBindByName(column = "refkey2")
    String refkey2;

    @CsvBindByName(column = "refdata2")
    String refdata2;

    @CsvBindByName(column = "refdata3")
    String refdata3;

    @CsvBindByName(column = "refdata4")
    BigDecimal refdata4;

    @Override
    public String toString() {
        return "InputReferenceData{" +
                "refkey1='" + refkey1 + '\'' +
                ", refdata1='" + refdata1 + '\'' +
                ", refkey2='" + refkey2 + '\'' +
                ", refdata2='" + refdata2 + '\'' +
                ", refdata3='" + refdata3 + '\'' +
                ", refdata4=" + refdata4 +
                '}';
    }

    public String getRefkey1() {
        return refkey1;
    }

    public void setRefkey1(String refkey1) {
        this.refkey1 = refkey1;
    }

    public String getRefdata1() {
        return refdata1;
    }

    public void setRefdata1(String refdata1) {
        this.refdata1 = refdata1;
    }

    public String getRefkey2() {
        return refkey2;
    }

    public void setRefkey2(String refkey2) {
        this.refkey2 = refkey2;
    }

    public String getRefdata2() {
        return refdata2;
    }

    public void setRefdata2(String refdata2) {
        this.refdata2 = refdata2;
    }

    public String getRefdata3() {
        return refdata3;
    }

    public void setRefdata3(String refdata3) {
        this.refdata3 = refdata3;
    }

    public BigDecimal getRefdata4() {
        return refdata4;
    }

    public void setRefdata4(BigDecimal refdata4) {
        this.refdata4 = refdata4;
    }

    @Override
    public int compareTo(InputReferenceData o) {
        if (this.getRefkey1().compareTo(o.getRefkey1()) > 0)
            return 1;
        else if (this.getRefkey1().compareTo(o.getRefkey1()) < 0)
            return -1;
        else
            return 0;
    }
}
