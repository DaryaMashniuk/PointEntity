package by.mashnyuk.pointentity.entity;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class PointsStorage {
    private static final Logger logger = LogManager.getLogger();
    private List<Point> points = new ArrayList<>();

    public boolean addPoint(Point point) {
        if (point == null || points.contains(point)) {
            logger.error("Attempted to add a null point.");
            return false;
        }
        logger.info("Point added: {} {}", point.getX(), point.getY(), point.getZ(),point.getVelocityX(), point.getVelocityY(), point.getVelocityZ());
        return points.add(point);
    }

    public List<Point> getPoints() {
        List<Point> pointCopy = new ArrayList<>(points.size());
        Collections.copy(points, pointCopy);
        return pointCopy;
    }
}
