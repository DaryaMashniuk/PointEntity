package by.mashnyuk.pointentity.service.impl;

import by.mashnyuk.pointentity.entity.Point;
import by.mashnyuk.pointentity.entity.PointsStorage;
import by.mashnyuk.pointentity.io.FileReader;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import java.util.List;

import static org.testng.Assert.*;

public class PointServiceImplTest {

    private PointServiceImpl pointServiceImpl;
    private SoftAssert softAssert;
    private PointsStorage pointsStorage;

    @BeforeClass
    public void initialSetUp() {
        softAssert = new SoftAssert();
        pointServiceImpl = new PointServiceImpl();
        // Adjust the file path according to your project structure
        pointsStorage = pointServiceImpl.loadPoints("/test_data.txt");
    }

    @Test
    public void testGetVelocity() {
        Point point = pointsStorage.getPoints().get(0);
        double velocity = pointServiceImpl.getVelocity(point);
        softAssert.assertEquals(velocity, 5.0, 0.001);
    }

    @Test
    public void testGetAcceleration() {
        Point point = pointsStorage.getPoints().get(1);
        double acceleration = pointServiceImpl.getAcceleration(point);
        softAssert.assertEquals(acceleration, 5.0, 0.001);
    }

    @Test
    public void testMove() {
        Point point = pointsStorage.getPoints().get(2);
        Point movedPoint = PointServiceImpl.move(point, 2).orElseThrow();
        softAssert.assertEquals(movedPoint.getX(), 6.0, 0.001);
        softAssert.assertEquals(movedPoint.getY(), 8.0, 0.001);
        softAssert.assertEquals(movedPoint.getZ(), 10.0, 0.001);
        softAssert.assertAll();
    }

    @Test
    public void testDistance() {
        Point p1 = pointsStorage.getPoints().get(3);
        Point p2 = pointsStorage.getPoints().get(4);
        double distance = PointServiceImpl.distance(p1, p2);
        softAssert.assertEquals(distance, 5.0, 0.001);
    }

    @Test
    public void testCheckIntersection() {
        Point p1 = pointsStorage.getPoints().get(5);
        Point p2 = pointsStorage.getPoints().get(6);
        boolean intersects = PointServiceImpl.checkIntersection(p1, p2, 5);
        assertFalse(intersects);
    }
}