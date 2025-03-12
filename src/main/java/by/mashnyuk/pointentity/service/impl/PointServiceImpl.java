package by.mashnyuk.pointentity.service.impl;

import by.mashnyuk.pointentity.creator.PointFactory;
import by.mashnyuk.pointentity.entity.Point;
import by.mashnyuk.pointentity.entity.PointsStorage;
import by.mashnyuk.pointentity.io.FileParser;
import by.mashnyuk.pointentity.io.FileReader;
import by.mashnyuk.pointentity.service.PointService;
import by.mashnyuk.pointentity.validator.impl.PointValidatorImpl;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.List;
import java.util.Optional;

public class PointServiceImpl implements PointService {
    private static final Logger logger = LogManager.getLogger();

    @Override
    public PointsStorage loadPoints(String filename) {
        FileReader fileReader = new FileReader();
        PointValidatorImpl validator = new PointValidatorImpl();
        FileParser parser = new FileParser(validator);
        List<String> lines = fileReader.readLinesFromClasspath(filename);
        return parser.parseLines(lines);
    }

    @Override
    public double getVelocity(Point point) {
        return Math.sqrt(point.getVx() * point.getVx() + point.getVy() * point.getVy() + point.getVz() * point.getVz());
    }

    @Override
    public double getAcceleration(Point point) {
        return Math.sqrt(point.getAx() * point.getAx() + point.getAy() * point.getAy() + point.getAz() * point.getAz());
    }

    public static Optional<Point> move(Point point, double deltaTime) {
        if (deltaTime <= 0) {
            return Optional.empty();
        }

        double newX = point.getX() + point.getVx() * deltaTime + 0.5 * point.getAx() * deltaTime * deltaTime;
        double newY = point.getY() + point.getVy() * deltaTime + 0.5 * point.getAy() * deltaTime * deltaTime;
        double newZ = point.getZ() + point.getVz() * deltaTime + 0.5 * point.getAz() * deltaTime * deltaTime;

        double newVx = point.getVx() + point.getAx() * deltaTime;
        double newVy = point.getVy() + point.getAy() * deltaTime;
        double newVz = point.getVz() + point.getAz() * deltaTime;

        return PointFactory.create3DPoint(newX, newY, newZ, point.getTime() + deltaTime, newVx, newVy, newVz, point.getAx(), point.getAy(), point.getAz());
    }

    public static boolean checkIntersection(Point p1, Point p2, double timeLimit) {
        for (double t = 0; t <= timeLimit; t += 0.1) {
            Optional<Point> movedP1 = move(p1, 0.1);
            Optional<Point> movedP2 = move(p2, 0.1);

            if (movedP1.isPresent() && movedP2.isPresent()) {
                p1 = movedP1.get();
                p2 = movedP2.get();
                if (Math.abs(p1.getX() - p2.getX()) < 0.01 &&
                        Math.abs(p1.getY() - p2.getY()) < 0.01 &&
                        Math.abs(p1.getZ() - p2.getZ()) < 0.01) {
                    return true;
                }
            } else {
                return false;
            }
        }
        return false;
    }

    public static double distance(Point p1, Point p2) {
        return Math.sqrt(Math.pow(p1.getX() - p2.getX(), 2) +
                Math.pow(p1.getY() - p2.getY(), 2) +
                Math.pow(p1.getZ() - p2.getZ(), 2));
    }
}