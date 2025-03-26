package by.mashnyuk.pointentity.conroller;

import by.mashnyuk.pointentity.entity.PointsStorage;
import by.mashnyuk.pointentity.io.CustomFileReader;
import by.mashnyuk.pointentity.io.LineParser;
import by.mashnyuk.pointentity.validator.impl.PointValidatorImpl;

import java.util.List;

public class Facade {

    public PointsStorage loadPoints(String filename) {
        CustomFileReader fileReader = new CustomFileReader();
        PointValidatorImpl validator = new PointValidatorImpl();
        LineParser parser = new LineParser(validator);
        List<String> lines = fileReader.readLinesFromFile(filename);
        return parser.parseLines(lines);
    }

}
