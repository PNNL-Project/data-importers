import com.opencsv.CSVReader;
import com.opencsv.CSVWriter;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.*;

public class Split {


    public static final String PATH = "seb_processed_data_time_shifted.csv";

//    public static final String PATH = "sliced.csv";

    public static void main(String[] args) {

        Map<Integer, List<String>> tableInfo = new HashMap<>();
        Set<String> fileNamesForDevice = new HashSet<>();

        Map<Integer, String> nonDeviceInfo = new HashMap<>();

        try (CSVReader csvReader = new CSVReader(new FileReader(PATH))) {

            // get headers
            String[] line = csvReader.readNext();

            for(int i = 0; i < line.length - 1; i ++){

                if(line[i].equals("raw_id")){
                    continue;
                }

                if(!line[i].contains("AHU")) {
                    nonDeviceInfo.put(i, line[i]);
                    continue;
                }

                List<String> infos = new ArrayList<>();
                tableInfo.put(i, infos);

                //measurement name
                String[] parts = line[i].split("_");

                String mName = parts[parts.length - 2];
                String dName = Arrays.stream(parts).filter(s -> s.contains("AHU")).findAny().get() +
                        Arrays.stream(parts).filter(s -> s.contains("VAV")).findAny().orElse("") +
                        Arrays.stream(parts).filter(s -> s.contains("THR")).findAny().orElse("") +
                        Arrays.stream(parts).filter(s -> s.contains("POINT")).findAny().orElse("");

                infos.add(mName);
                infos.add(dName);

                fileNamesForDevice.add(mName);
            }


            Map<String, CSVWriter> writers = new HashMap<>();
            fileNamesForDevice.stream().forEach(f -> {
                try {
                    writers.put(f, new CSVWriter(new FileWriter(f + ".csv")));

                    List<String> headers = new ArrayList<>();
                    headers.add("measurement");
                    headers.add("device");
                    headers.add("value");
                    headers.add("timeStamp");

                    for(int idx: nonDeviceInfo.keySet()){
                        headers.add(nonDeviceInfo.get(idx));
                    }

                    writers.get(f).writeNext(headers.toArray(new String[0]));

                } catch (IOException e) {
                    e.printStackTrace();
                }
            });


            while ((line = csvReader.readNext()) != null) {

                for(int i = 0; i < line.length - 1; i ++){

                    if(!tableInfo.containsKey(i)){
                        continue;
                    }

                    List<String> infos = tableInfo.get(i);

                    String mName = infos.get(0);
                    String dName = infos.get(1);
                    String ts = line[line.length - 1];
                    CSVWriter w = writers.get(mName);

                    List<String> myValues = new ArrayList<>();
                    myValues.add(mName);
                    myValues.add(dName);
                    myValues.add(line[i]);
                    myValues.add(ts);

                    for(int idx: nonDeviceInfo.keySet()){
                        myValues.add(line[idx]);
                    }
                    w.writeNext(myValues.toArray(new String[0]));
                }
            }

            writers.values().forEach(w -> {
                try {
                    w.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            });

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
