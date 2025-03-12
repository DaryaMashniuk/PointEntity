package by.mashnyuk.pointentity.io;

import by.mashnyuk.pointentity.entity.Point;
import by.mashnyuk.pointentity.entity.PointsStorage;
import by.mashnyuk.pointentity.validator.PointValidator;
import by.mashnyuk.pointentity.creator.PointFactory;

import java.util.List;
import java.util.Optional;

public class FileParser {

    private final PointValidator validator;

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
        if (data.length == 10) {  // 3D point
            return create3DPoint(data);
        } else if (data.length == 7) { // 2D point
            return create2DPoint(data);
        }
        return Optional.empty(); // Invalid format
    }

    private Optional<Point> create3DPoint(String[] data) {
        double x = Double.parseDouble(data[0]);
        double y = Double.parseDouble(data[1]);
        double z = Double.parseDouble(data[2]);
        double time = Double.parseDouble(data[3]);
        double vx = Double.parseDouble(data[4]);
        double vy = Double.parseDouble(data[5]);
        double vz = Double.parseDouble(data[6]);
        double ax = Double.parseDouble(data[7]);
        double ay = Double.parseDouble(data[8]);
        double az = Double.parseDouble(data[9]);

        return PointFactory.create3DPoint(x, y, z, time, vx, vy, vz, ax, ay, az);
    }

    private Optional<Point> create2DPoint(String[] data) {
        double x = Double.parseDouble(data[0]);
        double y = Double.parseDouble(data[1]);
        double time = Double.parseDouble(data[2]);
        double vx = Double.parseDouble(data[3]);
        double vy = Double.parseDouble(data[4]);
        double ax = Double.parseDouble(data[5]);
        double ay = Double.parseDouble(data[6]);

        return PointFactory.create2DPoint(x, y, time, vx, vy, ax, ay);
    }
}