package by.mashnyuk.pointentity.creator;

import by.mashnyuk.pointentity.entity.Point;

import java.util.Optional;

public interface PointFactory {

    Optional<Point> create3DPoint(double x, double y, double z, double time, double velocityX, double velocityY, double velocityZ, double accelerationX, double accelerationY, double accelerationZ) ;
    Optional<Point> create2DPoint(double x, double y, double time, double velocityX, double velocityY, double accelerationX, double accelerationY);
}
