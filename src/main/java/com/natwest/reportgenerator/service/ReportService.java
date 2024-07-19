package com.natwest.reportgenerator.service;

import com.natwest.reportgenerator.readers.DetectExt;
import com.natwest.reportgenerator.readers.InputData;
import com.natwest.reportgenerator.readers.InputReferenceData;
import com.natwest.reportgenerator.readers.OutputData;
import com.natwest.reportgenerator.writers.OutputWriter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * Service Class for Report
 */
@Service
public class ReportService {

    public String format = "ext";

    /**
     * Autowired detectExt bean
     */
    @Autowired
    private DetectExt detectExt;

    /**
     * Autowired outputWriter bean
     */
    @Autowired
    private OutputWriter outputWriter;

    public String getFormat() {
        return format;
    }

    public void setFormat(String format) {
        this.format = format;
    }

    /**
     * @return
     */
    @Scheduled(fixedDelayString = "${delay.interval}")
    public boolean generateOutputReport() {
        List<InputData> inpData = detectExt.getDataFromInput();
        List<InputReferenceData> refData = detectExt.getDataFromReferenceInput();
        if (inpData == null || refData == null)
            return false;
        List<OutputData> outputDataList = new ArrayList<>();
        Collections.sort(inpData);
        Collections.sort(refData);
        int i = 0;
        boolean generated = false;
        while (i < inpData.size()) {
            if (inpData.get(i).getRefkey1().equals(refData.get(i).getRefkey1()) && inpData.get(i).getRefkey2().equals(refData.get(i).getRefkey2())) {
                String field1 = inpData.get(i).getField1() + inpData.get(i).getField2();
                String field2 = refData.get(i).getRefdata1();
                String field3 = refData.get(i).getRefdata3() + refData.get(i).getRefdata2();
                String field4 = inpData.get(i).getField3() + inpData.get(i).getField5().max(refData.get(i).getRefdata4()).toString();
                BigDecimal field5 = inpData.get(i).getField5().max(refData.get(i).getRefdata4());
                OutputData outputData = new OutputData(field1, field2, field3, field4, field5);
                outputDataList.add(outputData);
                i += 1;
                generated = true;
            } else {
                if (inpData.get(i).getRefkey1().compareToIgnoreCase(refData.get(i).getRefkey1()) > 0) {
                    int j = i + 1;
                    while (j < refData.size()) {
                        if (inpData.get(i).getRefkey1().compareToIgnoreCase(refData.get(j).getRefkey1()) < 0)
                            break;
                        else if (inpData.get(i).getRefkey1().equals(refData.get(j).getRefkey1()) && inpData.get(i).getRefkey2().equals(refData.get(i).getRefkey2())) {
                            String field1 = inpData.get(i).getField1() + inpData.get(i).getField2();
                            String field2 = refData.get(j).getRefdata1();
                            String field3 = refData.get(j).getRefdata3() + refData.get(j).getRefdata2();
                            String field4 = inpData.get(i).getField3() + inpData.get(i).getField5().max(refData.get(i).getRefdata4()).toString();
                            BigDecimal field5 = inpData.get(i).getField5().max(refData.get(j).getRefdata4());
                            OutputData outputData = new OutputData(field1, field2, field3, field4, field5);
                            outputDataList.add(outputData);
                            generated = true;
                        } else
                            j = j + 1;
                    }
                    i += 1;
                }
            }
        }
        if (format.equalsIgnoreCase("Csv") && generated) {
            outputWriter.writeFileInCsv(outputDataList);
        } else if (format.equalsIgnoreCase("JSON") && generated)
            outputWriter.writeFileInJson(outputDataList);
        return generated;
    }
}
