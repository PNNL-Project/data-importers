import com.opencsv.CSVReader;
import com.opencsv.CSVWriter;

import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.*;

public class ExtractConsumption {

    public static final String PATH = "seb_processed_data_time_shifted.csv";

    public static void main(String[] args) {

        Map<String, Integer> indexTableName = new HashMap<>();

        try (CSVReader csvReader = new CSVReader(new FileReader(PATH));
             CSVWriter consumption = new CSVWriter(new FileWriter("consumption.csv"));) {

            // get headers
            String[] line = csvReader.readNext();

            for(int i = 0; i < line.length; i ++){

                if(line[i].equals("cooling_consumption")){
                    indexTableName.put("cooling", i);
                }else if(line[i].equals("heating_consumption")){
                    indexTableName.put("heating", i);
                }
            }


            // write headers
            consumption.writeNext(new String[]{"type","value", "timeStamp"});

            while ((line = csvReader.readNext()) != null) {


                String[] row1 = new String[3];
                row1[0] = "cooling";
                row1[1] = line[indexTableName.get("cooling")];
                row1[2] = line[line.length - 1];

                String[] row2 = new String[3];
                row2[0] = "heating";
                row2[1]= line[indexTableName.get("heating")];
                row2[2] = line[line.length - 1];

                consumption.writeNext(row1);
                consumption.writeNext(row2);
            }
        }
        catch (IOException e) {
            e.printStackTrace();
        }


    }
}
