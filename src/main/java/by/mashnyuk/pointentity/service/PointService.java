package by.mashnyuk.pointentity.service;

import by.mashnyuk.pointentity.entity.Point;
import by.mashnyuk.pointentity.entity.PointsStorage;

public interface PointService {
    double calculateVelocity(Point point);
    double calculateAcceleration(Point point);
}
