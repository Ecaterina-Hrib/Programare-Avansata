package org.example.databases;
import java.io.FileReader;
import java.util.List;
import com.opencsv.*;
import org.example.controller.MoviesController;

public class Dataset {
    public Dataset() {
    }

    public void readDataLineByLine(String file)
    {

        try {

            FileReader filereader = new FileReader(file);
            CSVReader csvReader = new CSVReader(filereader);
            String[] nextRecord;
            nextRecord = csvReader.readNext();
            int id;
            String name;
            String original_name;
            String country;
            String language;
            int duration;
            int score;
            while ((nextRecord = csvReader.readNext()) != null) {
               /* id = Integer.parseInt(nextRecord[0].replaceAll("\\D+",""));
                name = nextRecord[1];
                original_name = nextRecord[3];
                country= nextRecord[7];
                language = nextRecord[8];
                duration = Integer.parseInt(nextRecord[6]);
                score = (int) Float.parseFloat(nextRecord[14]);
                */
                 //new GenreController(Integer.parseInt(nextRecord[0].replaceAll("\\D+","")),nextRecord[6]);
                new MoviesController(Integer.parseInt(nextRecord[0].replaceAll("\\D+","")),nextRecord[1],nextRecord[2],nextRecord[3],nextRecord[7],nextRecord[8],Integer.parseInt(nextRecord[6]), (int) Float.parseFloat(nextRecord[14]));
           // new DirectorController(Integer.parseInt(nextRecord[0].replaceAll("\\D+","")),nextRecord[10]);
          //  new ActorController(Integer.parseInt(nextRecord[0].replaceAll("\\D+","")),nextRecord[13]);
            }
        }
        catch (Exception e) {
            e.printStackTrace();
        }
    }
    public void readAllDataAtOnce(String file)
    {
        try {

            FileReader filereader = new FileReader(file);
            CSVReader csvReader = new CSVReaderBuilder(filereader)
                    .withSkipLines(1)
                    .build();
            List<String[]> allData = csvReader.readAll();

            for (String[] row : allData) {
                for (String cell : row) {
                    System.out.print(cell + "\t");
                }
                System.out.println();
            }
        }
        catch (Exception e) {
            e.printStackTrace();
        }
    }
    public  void readDataFromCustomSeperator(String file)
    {
        try {

            FileReader filereader = new FileReader(file);

            CSVParser parser = new CSVParserBuilder().withSeparator(';').build();

            CSVReader csvReader = new CSVReaderBuilder(filereader)
                    .withCSVParser(parser)
                    .build();

            // Read all data at once
            List<String[]> allData = csvReader.readAll();

            // print Data
            for (String[] row : allData) {
                for (String cell : row) {
                    System.out.print(cell + "\t");
                }
                System.out.println();
            }
        }
        catch (Exception e) {
            e.printStackTrace();
        }
    }
}
