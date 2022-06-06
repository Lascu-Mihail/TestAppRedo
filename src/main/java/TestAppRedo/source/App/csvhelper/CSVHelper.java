package TestAppRedo.source.App.csvhelper;

import TestAppRedo.source.App.entity.County;
import com.opencsv.CSVParser;
import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVPrinter;
import org.apache.commons.csv.CSVRecord;
import org.apache.commons.csv.QuoteMode;
import org.springframework.web.multipart.MultipartFile;

import java.io.*;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class CSVHelper {

    public static String TYPE = "text/csv";
    static String[] HEADERS = {"Id", "county_name", "county_code", "locality_name", "county_code"};

    public static boolean hasCSVFormat(MultipartFile file) {

        return TYPE.equals(file.getContentType());
    }

    public static List<County> csvToTutorials(InputStream is) {
        try (BufferedReader fileReader = new BufferedReader(new InputStreamReader(is, StandardCharsets.UTF_8));
             CSVParser csvParser = new CSVParser(fileReader,
                     CSVFormat.DEFAULT.withFirstRecordAsHeader().withIgnoreHeaderCase().withTrim();) {

            List<County> counties = new ArrayList<>();

            Iterable<CSVRecord> csvRecords = csvParser.getRecords();

            for (CSVRecord csvRecord : csvRecords) {
                County county = new County(
                        Long.parseLong(csvRecord.get("Id")),
                        csvRecord.get("county_name"),
                        csvRecord.get("county_code"),
                        Boolean.parseBoolean(csvRecord.get("county_code"));

                counties.add(county);
            }
            return counties;
        } catch (
                IOException e) {
            throw new RuntimeException("fail to parse CSV file: " + e.getMessage());
        }
    }

    public static ByteArrayInputStream tutorialsToCSV(List<County> counties) {
        final CSVFormat format = CSVFormat.DEFAULT.withQuoteMode(QuoteMode.MINIMAL);

        try (ByteArrayOutputStream out = new ByteArrayOutputStream();
             CSVPrinter csvPrinter = new CSVPrinter(new PrintWriter(out), format)) {
            for (County county : counties) {
                List<String> data = Arrays.asList(
                        String.valueOf(county.getId(),
                        county.getCountyName(),
                                Integer.parseInt(county.getCountyCode()))
                );
                csvPrinter.printRecord(data);
            }
            csvPrinter.flush();
            return new ByteArrayInputStream(out.toByteArray());
        } catch (IOException e) {
            throw new RuntimeException("fail to import data to CSV file: " + e.getMessage());
        }
    }
}
