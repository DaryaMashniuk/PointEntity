package by.mashnyuk.pointentity.service.impl;

import by.mashnyuk.pointentity.creator.impl.PointFactoryImpl;
import by.mashnyuk.pointentity.entity.Point;
import by.mashnyuk.pointentity.entity.PointsStorage;
import by.mashnyuk.pointentity.io.LineParser;
import by.mashnyuk.pointentity.io.CustomFileReader;
import by.mashnyuk.pointentity.service.PointService;
import by.mashnyuk.pointentity.validator.impl.PointValidatorImpl;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.List;
import java.util.Optional;

public class PointServiceImpl implements PointService {
    private static final Logger logger = LogManager.getLogger();

    private static final double TIME_INCREMENT = 0.1;
    private static final double INTERSECTION_THRESHOLD = 0.01;


    @Override
    public double calculateVelocity(Point point) {
        return (Math.sqrt(point.getVelocityX() * point.getVelocityX() +
                point.getVelocityY() * point.getVelocityY() +
                point.getVelocityZ() * point.getVelocityZ()));
    }

    @Override
    public double calculateAcceleration(Point point) {
        return (Math.sqrt(point.getAccelerationX() * point.getAccelerationX() +
                point.getAccelerationY() * point.getAccelerationY() +
                point.getAccelerationZ() * point.getAccelerationZ()));
    }

    public static Optional<Point> move(Point point, double deltaTime) {
        if (deltaTime <= 0) {
            return Optional.empty();
        }

        double newX = point.getX() + point.getVelocityX() * deltaTime +
                0.5 * point.getAccelerationX() * deltaTime * deltaTime;
        double newY = point.getY() + point.getVelocityY() * deltaTime +
                0.5 * point.getAccelerationY() * deltaTime * deltaTime;
        double newZ = point.getZ() + point.getVelocityZ() * deltaTime +
                0.5 * point.getAccelerationZ() * deltaTime * deltaTime;

        double newVx = point.getVelocityX() + point.getAccelerationX() * deltaTime;
        double newVy = point.getVelocityY() + point.getAccelerationY() * deltaTime;
        double newVz = point.getVelocityZ() + point.getAccelerationZ() * deltaTime;

        return PointFactoryImpl.create3DPoint(newX, newY, newZ, point.getTime() + deltaTime, newVx, newVy, newVz, point.getAccelerationX(), point.getAccelerationY(), point.getAccelerationZ());
    }


    public static boolean checkIntersection(Point p1, Point p2, double timeLimit) {
        for (double t = 0; t <= timeLimit; t += TIME_INCREMENT) {
            Optional<Point> movedP1 = move(p1, TIME_INCREMENT);
            Optional<Point> movedP2 = move(p2, TIME_INCREMENT);

            if (movedP1.isPresent() && movedP2.isPresent()) {
                p1 = movedP1.get();
                p2 = movedP2.get();
                if (Math.abs(p1.getX() - p2.getX()) < INTERSECTION_THRESHOLD &&
                        Math.abs(p1.getY() - p2.getY()) < INTERSECTION_THRESHOLD &&
                        Math.abs(p1.getZ() - p2.getZ()) < INTERSECTION_THRESHOLD) {
                    return true;
                }
            } else {
                return false;
            }
        }
        return false;
    }

    public static double distance(Point p1, Point p2) {
        return (Math.sqrt(Math.pow(p1.getX() - p2.getX(), 2) +
                Math.pow(p1.getY() - p2.getY(), 2) +
                Math.pow(p1.getZ() - p2.getZ(), 2)));
    }
}