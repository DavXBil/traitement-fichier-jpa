package bll;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;

public class FileManager {


    public static List<String[]> readCsv(Path path) throws IOException {

        List<String> lines = Files.readAllLines(path, StandardCharsets.UTF_8);

        List<String[]> arrayLines = new ArrayList<>();

        for (String e: lines) {

            String[] line = e.split("\\|");

            arrayLines.add(line);

        }

        //Retrait de la ligne
        arrayLines.remove(0);


        return arrayLines;

    }

}
