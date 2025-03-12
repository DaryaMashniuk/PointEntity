package by.mashnyuk.pointentity.io;

import java.io.IOException;
import java.io.InputStream;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.List;

public class FileReader {

    public List<String> readLinesFromClasspath(String filename) {
        List<String> lines = new ArrayList<>();
        try (InputStream inputStream = getClass().getResourceAsStream(filename)) {
            try {
                if (inputStream != null) {
                    String content = new String(inputStream.readAllBytes(), StandardCharsets.UTF_8);
                    String[] splitLines = content.split("\n");
                    for (String line : splitLines) {
                        lines.add(line.trim());
                    }
                } else {
                    System.err.println("File not found: " + filename);
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        return lines;
    }
}