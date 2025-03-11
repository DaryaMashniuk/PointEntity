package by.mashnyuk.pointentity.validator.impl;

import by.mashnyuk.pointentity.entity.Point;
import by.mashnyuk.pointentity.validator.PointValidator;

public class PointValidatorImpl implements PointValidator {

    public static boolean isValid(Point point) {
        PointValidatorImpl validator = new PointValidatorImpl();
        return validator.validate(point);
    }

    @Override
    public boolean validate(Point point) {
        if(point == null){
            return false;
        }
        return  validateX(point.getX()) &&
                validateY(point.getY()) &&
                validateZ(point.getZ()) &&
                validateTime(point.getTime());
    }

    @Override
    public boolean validateX(double x) {
        return true;
    }

    @Override
    public boolean validateY(double y) {
        return true;
    }

    @Override
    public boolean validateZ(double z) {
        return true;
    }

    @Override
    public boolean validateTime(double time) {
        return time >= 0;
    }
}
