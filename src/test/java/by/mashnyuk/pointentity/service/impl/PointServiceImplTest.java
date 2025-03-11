package by.mashnyuk.pointentity.service.impl;

import by.mashnyuk.pointentity.entity.Point;
import org.testng.annotations.Test;

import static org.testng.Assert.*;

public class PointServiceImplTest {

    @Test
    public void testGetVelocity() {
        Point point = new Point(0, 0, 0, 0, 3, 4, 0, 0, 0, 0);
        double velocity = new PointServiceImpl().getVelocity(point);
        assertEquals(5.0, velocity, 0.001);
    }

    @Test
    public void testGetAcceleration() {
        Point point = new Point(0, 0, 0, 0, 0, 0, 0, 3, 4, 0);
        double acceleration = new PointServiceImpl().getAcceleration(point);
        assertEquals(5.0, acceleration, 0.001);
    }

    @Test
    public void testMove() {
        Point point = new Point(0, 0, 0, 0, 2, 3, 4, 1, 1, 1);
        Point movedPoint = PointServiceImpl.move(point, 2).orElseThrow();
        assertEquals(6.0, movedPoint.getX(), 0.001);
        assertEquals(8.0, movedPoint.getY(), 0.001);
        assertEquals(10.0, movedPoint.getZ(), 0.001);
    }

    @Test
    public void testDistance() {
        Point p1 = new Point(0, 0, 0, 0, 0, 0, 0, 0, 0, 0);
        Point p2 = new Point(3, 4, 0, 0, 0, 0, 0, 0, 0, 0);
        double distance = PointServiceImpl.distance(p1, p2);
        assertEquals(5.0, distance, 0.001);
    }

    @Test
    public void testCheckIntersection() {
        Point p1 = new Point(0, 0, 0, 0, 1, 1, 0, 0, 0, 0);
        Point p2 = new Point(2, 2, 0, 0, -1, -1, 0, 0, 0, 0);
        boolean intersects = PointServiceImpl.checkIntersection(p1, p2, 5);
        assertTrue(intersects);
    }
}