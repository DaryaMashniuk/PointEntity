package by.mashnyuk.pointentity.io;

import by.mashnyuk.pointentity.exception.PointEntityException;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;

public class CustomFileReader {
    private static final Logger logger = LogManager.getLogger();

    public List<String> readLinesFromFile(String filename) throws PointEntityException {
        Path path = Paths.get(filename);

        try (var streamLines = Files.lines(path, StandardCharsets.UTF_8)) {
            return streamLines
                    .map(String::trim)
                    .toList();
        } catch (NullPointerException | IOException e) {
            throw new PointEntityException(
                    PointEntityException.ErrorType.FILE_OPERATION,
                    "Failed to read file: " + filename,
                    e
            );
        }
    }
}