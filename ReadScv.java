package io;

import app.City;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class ReadScv {
    public static void main(String[] args) throws IOException {
        String file = "src\\main\\java\\app\\Bulgarian Roads.csv";
        BufferedReader reader = null;

        try {
            reader = new BufferedReader(new FileReader(file));
            List<City> cities = new ArrayList<>();

            String line = reader.readLine(); //

            while ((line = reader.readLine()) != null) {
                String[] attribute = line.split(",");

//                for (String index : row) {
//                    System.out.printf("%-15s", index);
//                }
//                System.out.println();

                City city = createCity(attribute);
                cities.add(city);
                for (City c : cities) {
                    System.out.println(c);
                }

            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            reader.close();
        }
    }

    private static City createCity(String[] metadata) {
        String name = metadata[0];
        String dataInformation = metadata[1];
        String[] dataSepareted = dataInformation.split("\\|");
        int time = Integer.parseInt(dataSepareted[0]);
        int distance = Integer.parseInt(dataSepareted[1]);
        int airLine = Integer.parseInt(dataSepareted[2]);

        //create and return city of this metadata
        return new City(name, time, distance, airLine);
    }
}

