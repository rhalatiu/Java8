package school.siit;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class App {
    public boolean readAndWrite(String inputFileName, int month, String outputFileName){
        try {
            BufferedReader br = Files.newBufferedReader(Paths.get("input.txt"));
            Stream<String> lines = br.lines();
            lines.forEach(System.out::println);
            List<String> listOfLines = Files.newBufferedReader(Paths.get("input.txt")).lines()
                    .filter(line -> Integer.parseInt(line.split(" ")[2].split("-")[1]) == month)
                    .map(line -> line.split(" ")[0] + " " + line.split(" ")[1])
                    .sorted()
                    .collect(Collectors.toList());

            try (PrintWriter pw = new PrintWriter(Files.newBufferedWriter(Paths.get("output.txt")))){
                Stream.of(listOfLines.toString()).forEach(pw::println);
                return true;
            }
        } catch (IOException exception) {
            exception.printStackTrace();
        }
        return false;
    }
}
