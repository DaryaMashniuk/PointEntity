package by.mashnyuk.pointentity.service;

import by.mashnyuk.pointentity.entity.Point;
import by.mashnyuk.pointentity.entity.PointsStorage;

public interface PointService {
    double getVelocity(Point point);
    double getAcceleration(Point point);
    PointsStorage loadPoints(String filename);
}
