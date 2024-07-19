package com.natwest.reportgenerator.readers;

import com.opencsv.bean.CsvToBeanBuilder;
import org.springframework.stereotype.Component;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.List;

@Component
public class InputReader {

    public List<InputData> getInputData(String inputFileName) {
        List<InputData> inputData = null;
        try {
            inputData = new CsvToBeanBuilder(new FileReader(inputFileName))
                    .withType(InputData.class)
                    .build()
                    .parse();
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }
        return inputData;
    }

    public List<InputReferenceData> getReferenceInputData(String referenceFileName) {
        String extension = referenceFileName.substring(referenceFileName.indexOf('.'));
        List<InputReferenceData> referenceInputData = null;
        try {
            referenceInputData = new CsvToBeanBuilder(new FileReader(referenceFileName))
                    .withType(InputReferenceData.class)
                    .build()
                    .parse();
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }
        return referenceInputData;
    }

}
