package by.mashnyuk.pointentity.util;

import by.mashnyuk.pointentity.creator.PointFactory;
import by.mashnyuk.pointentity.entity.Point;
import by.mashnyuk.pointentity.entity.PointsStorage;
import by.mashnyuk.pointentity.validator.impl.PointValidatorImpl;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Optional;

public class TestFileReader {

    private static PointsStorage points = new PointsStorage();
    private static final PointValidatorImpl validator = new PointValidatorImpl();

    public static PointsStorage readPointsFromFile(String filePath) {
        try (BufferedReader br = new BufferedReader(new FileReader(filePath))) {
            String line;
            while ((line = br.readLine()) != null) {
                String[] data = line.split(",");
                Optional<Point> point;

                if (data.length == 10) {  // 3D point
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

                    point = PointFactory.create3DPoint(x, y, z, time, vx, vy, vz, ax, ay, az);
                } else if (data.length == 7) { // 2D point
                    double x = Double.parseDouble(data[0]);
                    double y = Double.parseDouble(data[1]);
                    double time = Double.parseDouble(data[2]);
                    double vx = Double.parseDouble(data[3]);
                    double vy = Double.parseDouble(data[4]);
                    double ax = Double.parseDouble(data[5]);
                    double ay = Double.parseDouble(data[6]);

                    point = PointFactory.create2DPoint(x, y, time, vx, vy, ax, ay);
                } else {
                    point = Optional.empty(); // Initialize to empty if the format is incorrect
                }

                if (point.isPresent() && validator.isValid(point.get())) {
                    points.addPoint(point.get());
                }
            }
        } catch (IOException | NumberFormatException e) {
            e.printStackTrace();
        }
        return points;
    }
}