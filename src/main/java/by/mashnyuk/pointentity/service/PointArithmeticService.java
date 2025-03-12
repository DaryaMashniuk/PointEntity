package by.mashnyuk.pointentity.service;

import by.mashnyuk.pointentity.entity.Point;

public interface PointArithmeticService {
    Point add(Point p1, Point p2);
    Point subtract(Point p1, Point p2);
    Point multiplyByScalar(Point p, double scalar);
    Point divideByScalar(Point p, double scalar);

}
