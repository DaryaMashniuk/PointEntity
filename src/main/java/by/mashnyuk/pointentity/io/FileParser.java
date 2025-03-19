package by.mashnyuk.pointentity.io;

import by.mashnyuk.pointentity.entity.Point;
import by.mashnyuk.pointentity.entity.PointsStorage;
import by.mashnyuk.pointentity.validator.PointValidator;
import by.mashnyuk.pointentity.creator.impl.PointFactoryImpl;

import java.util.List;
import java.util.Optional;

public class FileParser {

    private final PointValidator validator;

    private static final int DIMENSION_3D = 10;
    private static final int DIMENSION_2D = 7;

    public FileParser(PointValidator validator) {
        this.validator = validator;
    }

    public PointsStorage parseLines(List<String> lines) {
        PointsStorage points = new PointsStorage();
        for (String line : lines) {
            Optional<Point> point = parseLine(line);
            point.ifPresent(p -> {
                if (validator.validate(p)) {
                    points.addPoint(p);
                }
            });
        }
        return points;
    }

    private Optional<Point> parseLine(String line) {
        String[] data = line.split(",");
        if (data.length == DIMENSION_3D) {
            return create3DPoint(data);
        } else if (data.length == DIMENSION_2D) {
            return create2DPoint(data);
        }
        return Optional.empty();
    }

    private Optional<Point> create3DPoint(String[] data) {
        double x = Double.parseDouble(data[0]);
        double y = Double.parseDouble(data[1]);
        double z = Double.parseDouble(data[2]);
        double time = Double.parseDouble(data[3]);
        double velocityX = Double.parseDouble(data[4]);
        double velocityY = Double.parseDouble(data[5]);
        double velocityZ = Double.parseDouble(data[6]);
        double accelerationX = Double.parseDouble(data[7]);
        double accelerationY = Double.parseDouble(data[8]);
        double accelerationZ = Double.parseDouble(data[9]);

        return PointFactoryImpl.create3DPoint(x, y, z, time, velocityX, velocityY, velocityZ, accelerationX, accelerationY, accelerationZ);
    }

    private Optional<Point> create2DPoint(String[] data) {
        double x = Double.parseDouble(data[0]);
        double y = Double.parseDouble(data[1]);
        double time = Double.parseDouble(data[2]);
        double velocityX = Double.parseDouble(data[3]);
        double velocityY = Double.parseDouble(data[4]);
        double accelerationX = Double.parseDouble(data[5]);
        double accelerationY = Double.parseDouble(data[6]);

        return PointFactoryImpl.create2DPoint(x, y, time, velocityX, velocityY, accelerationX, accelerationY);
    }
}