package by.mashnyuk.pointentity.service.impl;

import by.mashnyuk.pointentity.entity.Point;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import static org.testng.Assert.*;

public class PointServiceImplTest {
    private PointServiceImpl pointService;
    private SoftAssert softAssert;
    private Point testPoint;

    @BeforeClass
    public void setUp() {
        pointService = new PointServiceImpl();
        softAssert = new SoftAssert();
        testPoint = new Point(3.0, 4.0, 0.0, 0.0, 3.0, 4.0, 0.0, 0.0, 0.0, 0.0);
    }

    @Test
    public void testCalculateVelocity() {
        double velocity = pointService.calculateVelocity(testPoint);
        assertEquals(velocity, 5.0, 0.001, "Velocity calculation failed");
    }

    @Test
    public void testCalculateAcceleration() {
        Point accelPoint = new Point(0, 0, 0, 0, 0, 0, 0, 3.0, 4.0, 0.0);
        double acceleration = pointService.calculateAcceleration(accelPoint);
        assertEquals(acceleration, 5.0, 0.001, "Acceleration calculation failed");
    }

    @Test
    public void testMove() {
        Point movingPoint = new Point(0, 0, 0, 0, 1, 1, 0, 0.5, 0.5, 0);
        var result = PointServiceImpl.move(movingPoint, 2);
        assertTrue(result.isPresent(), "Move should return a point");
        Point moved = result.get();
        softAssert.assertEquals(moved.getX(), 3.0, 0.001, "X after move");
        softAssert.assertEquals(moved.getY(), 3.0, 0.001, "Y after move");
        softAssert.assertAll();
    }

    @Test
    public void testDistance() {
        Point p1 = new Point(1, 2, 3, 0, 0, 0, 0, 0, 0, 0);
        Point p2 = new Point(4, 6, 8, 0, 0, 0, 0, 0, 0, 0);
        double distance = PointServiceImpl.distance(p1, p2);
        assertEquals(distance, Math.sqrt(9 + 16 + 25), 0.001, "Distance calculation failed");
    }

    @Test
    public void testCheckIntersection() {
        Point p1 = new Point(0, 0, 0, 0, 1, 0, 0, 0, 0, 0);
        Point p2 = new Point(5, 0, 0, 0, -1, 0, 0, 0, 0, 0);
        assertTrue(PointServiceImpl.checkIntersection(p1, p2, 10), "Points should intersect");
    }
}