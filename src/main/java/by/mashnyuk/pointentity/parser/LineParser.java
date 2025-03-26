package by.mashnyuk.pointentity.parser;

import by.mashnyuk.pointentity.entity.Point;
import by.mashnyuk.pointentity.entity.PointsStorage;
import by.mashnyuk.pointentity.exception.PointEntityException;
import by.mashnyuk.pointentity.validator.PointValidator;
import by.mashnyuk.pointentity.creator.impl.PointFactoryImpl;

import java.util.List;
import java.util.Optional;

public class LineParser {

    private final PointValidator validator;

    private static final int DIMENSION_3D_COORDINATES_VELOCITY_ACCELERATION = 10;
    private static final int DIMENSION_2D_COORDINATES_VELOCITY_ACCELERATION = 7;

    public LineParser(PointValidator validator) {
        this.validator = validator;
    }

    public PointsStorage parseLines(List<String> lines) throws PointEntityException {
        PointsStorage points = new PointsStorage();

        try {
            lines.stream()
                    .map(this::parseLine)
                    .filter(Optional::isPresent)
                    .map(Optional::get)
                    .filter(validator::validate)
                    .forEach(points::add);
        } catch (Exception e) {
            throw new PointEntityException(
                    PointEntityException.ErrorType.PARSING_ERROR,
                    "Failed to parse lines: " + e.getMessage(),
                    e
            );
        }
        return points;
    }
    private Optional<Point> parseLine(String line) {
        String[] data = line.split(",");
        return switch (data.length) {
            case DIMENSION_3D_COORDINATES_VELOCITY_ACCELERATION -> create3DPointFromData(data);
            case DIMENSION_2D_COORDINATES_VELOCITY_ACCELERATION -> create2DPointFromData(data);
            default -> Optional.empty();
        };
    }

    private Optional<Point> create3DPointFromData(String[] data) {
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

    private Optional<Point> create2DPointFromData(String[] data) {
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