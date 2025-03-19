package by.mashnyuk.pointentity.creator.impl;

import by.mashnyuk.pointentity.entity.Point;
import by.mashnyuk.pointentity.validator.impl.PointValidatorImpl;

import java.util.Optional;

public class PointFactoryImpl {
    public static Optional<Point> create3DPoint(double x, double y, double z, double time, double velocityX, double velocityY, double velocityZ, double accelerationX, double accelerationY, double accelerationZ) {
        Point point = new Point(x, y, z, time, velocityX, velocityY, velocityZ, accelerationX, accelerationY, accelerationZ);
        return PointValidatorImpl.isValid(point) ? Optional.of(point) : Optional.empty();
    }

    public static Optional<Point> create2DPoint(double x, double y, double time, double velocityX, double velocityY, double accelerationX, double accelerationY) {
        Point point = new Point(x, y, time, velocityX, velocityY, accelerationX, accelerationY);
        return PointValidatorImpl.isValid(point) ? Optional.of(point) : Optional.empty();
    }
}
