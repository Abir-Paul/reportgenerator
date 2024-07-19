package com.natwest.reportgenerator.writers;


import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.natwest.reportgenerator.readers.OutputData;
import com.opencsv.CSVWriter;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import java.io.FileWriter;
import java.io.IOException;
import java.io.Writer;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;


/**
 * Writes Output To Files
 */
@Component
public class OutputWriter {

    @Value("${output.file.path}")
    private String outputfile;

    public void writeFileInJson(List<OutputData> outputDataList) {
        Gson gson = new GsonBuilder()
                .setPrettyPrinting()
                .create();
        Writer writer;
        try {
            writer = new FileWriter(outputfile + ".json");
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        gson.toJson(outputDataList, writer);
        try {
            writer.flush();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        try {
            writer.close();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    /**
     * @param outputDataList
     */
    public void writeFileInCsv(List<OutputData> outputDataList) {

        try {
            Writer writer = Files.newBufferedWriter(Paths.get(outputfile + ".csv"));

            CSVWriter csvWriter = new CSVWriter(writer,
                    CSVWriter.DEFAULT_SEPARATOR,
                    CSVWriter.NO_QUOTE_CHARACTER,
                    CSVWriter.DEFAULT_ESCAPE_CHARACTER,
                    CSVWriter.DEFAULT_LINE_END);
            if (outputDataList != null) {
                String[] headerRecord = {"outfield1", "outfield2", "outfield3", "outfield4", "outfield5"};
                csvWriter.writeNext(headerRecord);
                for (OutputData outputData : outputDataList) {
                    csvWriter.writeNext(outputData.getArrayRepresentation());
                }
            }
            csvWriter.close();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }


    }
}



