package by.mashnyuk.pointentity.service.impl;

import by.mashnyuk.pointentity.entity.Point;
import by.mashnyuk.pointentity.entity.PointsStorage;
import by.mashnyuk.pointentity.util.TestFileReader;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import java.util.List;

import static org.testng.Assert.*;

public class PointArithmeticServiceImplTest {

    private PointArithmeticServiceImpl arithmeticService;
    private SoftAssert softAssert;
    private PointsStorage pointsStorage;

    @BeforeClass
    public void initialSetUp() {
        arithmeticService = new PointArithmeticServiceImpl();
        softAssert = new SoftAssert();

        pointsStorage = TestFileReader.readPointsFromFile("src/test/resources/arithmeticTest_data.txt");
    }

    @Test
    public void testAdd() {
        Point p1 = pointsStorage.getPoints().get(0);
        Point p2 = pointsStorage.getPoints().get(1);

        Point result = arithmeticService.add(p1, p2);

        softAssert.assertEquals(result.getX(), 3.0);
        softAssert.assertEquals(result.getY(), 4.0);
        softAssert.assertEquals(result.getZ(), 5.0);
        softAssert.assertEquals(result.getVx(), 2.0);
        softAssert.assertEquals(result.getVy(), 2.0);
        softAssert.assertEquals(result.getVz(), 2.0);
        softAssert.assertAll();
    }

    @Test
    public void testSubtract() {
        Point p1 = pointsStorage.getPoints().get(0);
        Point p2 = pointsStorage.getPoints().get(1);

        Point result = arithmeticService.subtract(p1, p2);

        softAssert.assertEquals(result.getX(), 1.0);
        softAssert.assertEquals(result.getY(), 2.0);
        softAssert.assertEquals(result.getZ(), 3.0);
        softAssert.assertEquals(result.getVx(), 0.0);
        softAssert.assertEquals(result.getVy(), 0.0);
        softAssert.assertEquals(result.getVz(), 0.0);
        softAssert.assertAll();
    }

    @Test
    public void testMultiplyByScalar() {
        Point p = pointsStorage.getPoints().get(0);
        double scalar = 2.0;

        Point result = arithmeticService.multiplyByScalar(p, scalar);

        softAssert.assertEquals(result.getX(), 4.0);
        softAssert.assertEquals(result.getY(), 6.0);
        softAssert.assertEquals(result.getZ(), 8.0);
        softAssert.assertEquals(result.getVx(), 2.0);
        softAssert.assertEquals(result.getVy(), 2.0);
        softAssert.assertEquals(result.getVz(), 2.0);
        softAssert.assertAll();
    }

    @Test(expectedExceptions = IllegalArgumentException.class)
    public void testDivideByScalar_Zero() {
        Point p = pointsStorage.getPoints().get(0);
        arithmeticService.divideByScalar(p, 0);
    }

    @Test
    public void testDivideByScalar() {
        Point p = pointsStorage.getPoints().get(0);
        double scalar = 2.0;

        Point result = arithmeticService.divideByScalar(p, scalar);

        softAssert.assertEquals(result.getX(), 1.0);
        softAssert.assertEquals(result.getY(), 1.5);
        softAssert.assertEquals(result.getZ(), 2.0);
        softAssert.assertEquals(result.getVx(), 0.5);
        softAssert.assertEquals(result.getVy(), 0.5);
        softAssert.assertEquals(result.getVz(), 0.5);
        softAssert.assertAll();
    }
}