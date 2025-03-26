package by.mashnyuk.pointentity.facade;

import by.mashnyuk.pointentity.entity.PointsStorage;
import by.mashnyuk.pointentity.exception.PointEntityException;
import by.mashnyuk.pointentity.io.CustomFileReader;
import by.mashnyuk.pointentity.parser.LineParser;
import by.mashnyuk.pointentity.validator.impl.PointValidatorImpl;

import java.util.List;

public class Facade {

    public PointsStorage loadPoints(String filename) throws PointEntityException {
        CustomFileReader fileReader = new CustomFileReader();
        PointValidatorImpl validator = new PointValidatorImpl();
        LineParser parser = new LineParser(validator);
        List<String> lines = fileReader.readLinesFromFile(filename);
        return parser.parseLines(lines);
    }

}
