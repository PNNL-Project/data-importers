package xyz.drshu.cs6510.dataProcessor.controller;

import java.io.BufferedReader;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class DataProcessorApp {

    public static Parser parser = new Parser();

    public static void main(String[] args) {
        // FIXME Avoid hard code style
//        Path path = Paths.get("src/main/resources/seb_processed_data.csv");
        Path path = Paths.get("src/main/resources/seb_processed_data_sample.csv");
        Examination.start();
        try(BufferedReader br = Files.newBufferedReader(path, StandardCharsets.UTF_8)){
            String line = br.readLine();
            String[] attributes = line.split(",");
            parser.parseAttributes(attributes);
            line = br.readLine();

            while(line!= null){
                String[] records = line.split(",");
                parser.parseRecords(records);
                line = br.readLine();
            }
        }catch (IOException e){
            e.printStackTrace();
        }
        Examination.end();
        System.out.print(path.toString());
    }

}

class Examination {
    public static long c1,c2;

    public static void start(){
        c1 = System.nanoTime();
        Runtime runtime = Runtime.getRuntime();
    }
    public static void end(){
        c2 = System.nanoTime();
        Runtime runtime = Runtime.getRuntime();

        String time = String.valueOf((double) (c2 - c1) / 1000000);
        System.out.println("Time consumed: " + time.substring(0,time.equals("0,0") ? 1 : (time.indexOf(".")+3)) + "ms");

    }

}

