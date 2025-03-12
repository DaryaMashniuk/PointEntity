package by.mashnyuk.pointentity.service.impl;

import by.mashnyuk.pointentity.entity.Point;
import by.mashnyuk.pointentity.entity.PointsStorage;
import by.mashnyuk.pointentity.io.FileReader;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

public class PointArithmeticServiceImplTest {

    private PointArithmeticServiceImpl arithmeticService;
    private SoftAssert softAssert;
    private PointsStorage pointsStorage;

    @BeforeClass
    public void initialSetUp() {
        arithmeticService = new PointArithmeticServiceImpl();
        softAssert = new SoftAssert();

        PointServiceImpl pointService = new PointServiceImpl();
        pointsStorage = pointService.loadPoints("/arithmeticTest_data.txt");
    }

    @Test
    public void testAdd() {
        Point p1 = pointsStorage.getPoints().get(0);
        Point p2 = pointsStorage.getPoints().get(1);

        Point result = arithmeticService.add(p1, p2);

        softAssert.assertEquals(result.getX(), 3.0, "X coordinate addition failed");
        softAssert.assertEquals(result.getY(), 4.0, "Y coordinate addition failed");
        softAssert.assertEquals(result.getZ(), 5.0, "Z coordinate addition failed");
        softAssert.assertEquals(result.getVx(), 2.0, "Vx addition failed");
        softAssert.assertEquals(result.getVy(), 2.0, "Vy addition failed");
        softAssert.assertEquals(result.getVz(), 2.0, "Vz addition failed");
        softAssert.assertAll();
    }

    @Test
    public void testSubtract() {
        Point p1 = pointsStorage.getPoints().get(0);
        Point p2 = pointsStorage.getPoints().get(1);

        Point result = arithmeticService.subtract(p1, p2);

        softAssert.assertEquals(result.getX(), 1.0, "X coordinate subtraction failed");
        softAssert.assertEquals(result.getY(), 2.0, "Y coordinate subtraction failed");
        softAssert.assertEquals(result.getZ(), 3.0, "Z coordinate subtraction failed");
        softAssert.assertEquals(result.getVx(), 0.0, "Vx subtraction failed");
        softAssert.assertEquals(result.getVy(), 0.0, "Vy subtraction failed");
        softAssert.assertEquals(result.getVz(), 0.0, "Vz subtraction failed");
        softAssert.assertAll();
    }

    @Test
    public void testMultiplyByScalar() {
        Point p = pointsStorage.getPoints().get(0);
        double scalar = 2.0;

        Point result = arithmeticService.multiplyByScalar(p, scalar);

        softAssert.assertEquals(result.getX(), 4.0, "X coordinate multiplication failed");
        softAssert.assertEquals(result.getY(), 6.0, "Y coordinate multiplication failed");
        softAssert.assertEquals(result.getZ(), 8.0, "Z coordinate multiplication failed");
        softAssert.assertEquals(result.getVx(), 2.0, "Vx multiplication failed");
        softAssert.assertEquals(result.getVy(), 2.0, "Vy multiplication failed");
        softAssert.assertEquals(result.getVz(), 2.0, "Vz multiplication failed");
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

        softAssert.assertEquals(result.getX(), 1.0, "X coordinate division failed");
        softAssert.assertEquals(result.getY(), 1.5, "Y coordinate division failed");
        softAssert.assertEquals(result.getZ(), 2.0, "Z coordinate division failed");
        softAssert.assertEquals(result.getVx(), 0.5, "Vx division failed");
        softAssert.assertEquals(result.getVy(), 0.5, "Vy division failed");
        softAssert.assertEquals(result.getVz(), 0.5, "Vz division failed");
        softAssert.assertAll();
    }
}