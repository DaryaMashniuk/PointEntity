package by.mashnyuk.pointentity.service.impl;
import by.mashnyuk.pointentity.entity.Point;
import by.mashnyuk.pointentity.service.PointArithmeticService;

public class PointArithmeticServiceImpl implements PointArithmeticService {

    public Point add(Point p1, Point p2) {
        return new Point(
                p1.getX() + p2.getX(),
                p1.getY() + p2.getY(),
                p1.getZ() + p2.getZ(),
                Math.max(p1.getTime(), p2.getTime()),
                p1.getVx() + p2.getVx(),
                p1.getVy() + p2.getVy(),
                p1.getVz() + p2.getVz(),
                0, 0, 0
        );
    }

    public Point subtract(Point p1, Point p2) {
        return new Point(
                p1.getX() - p2.getX(),
                p1.getY() - p2.getY(),
                p1.getZ() - p2.getZ(),
                Math.max(p1.getTime(), p2.getTime()), // Assuming time is the max of both
                p1.getVx() - p2.getVx(),
                p1.getVy() - p2.getVy(),
                p1.getVz() - p2.getVz(),
                0, 0, 0
        );
    }

    public Point multiplyByScalar(Point p, double scalar) {
        return new Point(
                p.getX() * scalar,
                p.getY() * scalar,
                p.getZ() * scalar,
                p.getTime(),
                p.getVx() * scalar,
                p.getVy() * scalar,
                p.getVz() * scalar,
                p.getAx(),
                p.getAy(),
                p.getAz()
        );
    }

    public Point divideByScalar(Point p, double scalar) {
        if (scalar == 0) {
            throw new IllegalArgumentException("Cannot divide by zero");
        }
        return new Point(
                p.getX() / scalar,
                p.getY() / scalar,
                p.getZ() / scalar,
                p.getTime(),
                p.getVx() / scalar,
                p.getVy() / scalar,
                p.getVz() / scalar,
                p.getAx(),
                p.getAy(),
                p.getAz()
        );
    }
}