package by.mashnyuk.pointentity.creator;

import by.mashnyuk.pointentity.entity.Point;
import by.mashnyuk.pointentity.validator.impl.PointValidatorImpl;

import java.util.Optional;

public class PointFactory {
    public static Optional<Point> create3DPoint(double x, double y, double z, double time, double vx, double vy, double vz, double ax, double ay, double az) {
        Point point = new Point(x, y, z, time, vx, vy, vz, ax, ay, az);
        return PointValidatorImpl.isValid(point) ? Optional.of(point) : Optional.empty();
    }

    public static Optional<Point> create2DPoint(double x, double y, double time, double vx, double vy, double ax, double ay) {
        Point point = new Point(x, y, time, vx, vy, ax, ay);
        return PointValidatorImpl.isValid(point) ? Optional.of(point) : Optional.empty();
    }
}
