package by.mashnyuk.pointentity.service.impl;

import by.mashnyuk.pointentity.entity.Point;
import by.mashnyuk.pointentity.exception.PointEntityException;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

public class PointArithmeticServiceImplTest {
    private PointArithmeticServiceImpl arithmeticService;
    private SoftAssert softAssert;
    private Point p1;
    private Point p2;

    @BeforeClass
    public void setUp() {
        arithmeticService = new PointArithmeticServiceImpl();
        softAssert = new SoftAssert();

        p1 = new Point(2.0, 3.0, 4.0, 0.0, 1.0, 1.0, 1.0, 0.0, 0.0, 0.0);
        p2 = new Point(1.0, 1.0, 1.0, 0.0, 1.0, 1.0, 1.0, 0.0, 0.0, 0.0);
    }

    @Test
    public void testAdd() {
        Point result = arithmeticService.add(p1, p2);
        softAssert.assertEquals(result.getX(), 3.0, "X coordinate addition failed");
        softAssert.assertEquals(result.getY(), 4.0, "Y coordinate addition failed");
        softAssert.assertEquals(result.getZ(), 5.0, "Z coordinate addition failed");
        softAssert.assertEquals(result.getVelocityX(), 2.0, "Vx addition failed");
        softAssert.assertAll();
    }

    @Test
    public void testSubtract() {
        Point result = arithmeticService.subtract(p1, p2);
        softAssert.assertEquals(result.getX(), 1.0, "X coordinate subtraction failed");
        softAssert.assertEquals(result.getY(), 2.0, "Y coordinate subtraction failed");
        softAssert.assertEquals(result.getZ(), 3.0, "Z coordinate subtraction failed");
        softAssert.assertAll();
    }

    @Test
    public void testMultiplyByScalar() {
        Point result = arithmeticService.multiplyByScalar(p1, 2.0);
        softAssert.assertEquals(result.getX(), 4.0, "X coordinate multiplication failed");
        softAssert.assertEquals(result.getY(), 6.0, "Y coordinate multiplication failed");
        softAssert.assertEquals(result.getZ(), 8.0, "Z coordinate multiplication failed");
        softAssert.assertAll();
    }

    @Test(expectedExceptions = IllegalArgumentException.class)
    public void testDivideByZero() throws PointEntityException {
        arithmeticService.divideByScalar(p1, 0);
    }

    @Test
    public void testDivideByScalar() throws PointEntityException {
        Point result = arithmeticService.divideByScalar(p1, 2.0);
        softAssert.assertEquals(result.getX(), 1.0, "X coordinate division failed");
        softAssert.assertEquals(result.getY(), 1.5, "Y coordinate division failed");
        softAssert.assertEquals(result.getZ(), 2.0, "Z coordinate division failed");
        softAssert.assertAll();
    }
}