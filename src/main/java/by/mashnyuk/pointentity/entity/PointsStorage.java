package by.mashnyuk.pointentity.entity;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.HashSet;
import java.util.Set;
import java.util.ArrayList;
import java.util.Collections;

public class PointsStorage {
    private static final Logger logger = LogManager.getLogger();
    private Set<Point> points = new HashSet<>();

    public boolean add(Point point) {
        return points.add(point);
    }

    public Set<Point> getPoints() {
        return Collections.unmodifiableSet(new HashSet<>(points));
    }
}