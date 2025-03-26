package by.mashnyuk.pointentity.main;

import by.mashnyuk.pointentity.exception.PointEntityException;
import by.mashnyuk.pointentity.facade.Facade;
import by.mashnyuk.pointentity.entity.Point;
import by.mashnyuk.pointentity.entity.PointsStorage;
import by.mashnyuk.pointentity.service.impl.PointArithmeticServiceImpl;
import by.mashnyuk.pointentity.service.impl.PointServiceImpl;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class Main {
    private static final Logger logger = LogManager.getLogger();

    public static void main(String[] args) throws PointEntityException {
        Facade facade = new Facade();
        PointsStorage storage = facade.loadPoints("src/main/resources/test_data.txt");

        if (!storage.getPoints().isEmpty()) {
            PointServiceImpl pointService = new PointServiceImpl();
            PointArithmeticServiceImpl arithmeticService = new PointArithmeticServiceImpl();

            Point[] points = storage.getPoints().toArray(new Point[0]);
            if (points.length >= 2) {
                Point p1 = points[0];
                Point p2 = points[1];

                logger.info("Point 1: " + p1);

                logger.info("Point 2: " + p2);
                logger.info("\nVelocity of point 1: " + pointService.calculateVelocity(p1));
                logger.info("Acceleration of point 2: " + pointService.calculateAcceleration(p2));

                Point sum = arithmeticService.add(p1, p2);

                logger.info("\nSum of points: " + sum);
                double distance = PointServiceImpl.distance(p1, p2);
                logger.info("Distance between points: " + distance);

                boolean intersect = PointServiceImpl.checkIntersection(p1, p2, 10);
                logger.info("Points intersect: " + intersect);
            }
        } else {
            logger.info("No points loaded from file!");
        }
    }
}