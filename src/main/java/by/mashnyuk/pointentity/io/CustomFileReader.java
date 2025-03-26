package by.mashnyuk.pointentity.io;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class CustomFileReader {
    private static final Logger logger = LogManager.getLogger();

    public List<String> readLinesFromFile(String filename) {
        Path path = Paths.get(filename);
        try (Stream<String> streamLines = Files.lines(path, StandardCharsets.UTF_8)) {
            return streamLines.map(String::trim)
                    .collect(Collectors.toList());
        } catch (IOException e) {
            logger.error("Error reading file: " + filename, e);
            return List.of();
        }
    }

}