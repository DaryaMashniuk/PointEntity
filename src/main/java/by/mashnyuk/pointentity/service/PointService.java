package by.mashnyuk.pointentity.service;

import by.mashnyuk.pointentity.entity.Point;

public interface PointService {
    double getVelocity(Point point);
    double getAcceleration(Point point);

}
