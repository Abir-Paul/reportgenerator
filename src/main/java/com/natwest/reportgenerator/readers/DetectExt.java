package com.natwest.reportgenerator.readers;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.io.ResourceLoader;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * Class for getting data as per extension
 */
@Component
public class DetectExt {

    private static final Logger log = LoggerFactory.getLogger(DetectExt.class);
    @Autowired
    private ResourceLoader resourceLoader;

    @Autowired
    private InputReader inputReader;

    @Value("${input.file.fullpath}")
    private String inputfilepath;

    @Value("${reference.file.fullpath}")
    private String referencefilepath;

    /**
     * returns data from input file
     *
     * @return
     */
    public List<InputData> getDataFromInput() {
        List<InputData> x = null;
        x = inputReader.getInputData(inputfilepath);
        return x;
    }

    /**
     * returns data from reference file
     *
     * @return
     */
    public List<InputReferenceData> getDataFromReferenceInput() {
        List<InputReferenceData> x = null;
        x = inputReader.getReferenceInputData(referencefilepath);
        return x;
    }
}
