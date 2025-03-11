package by.mashnyuk.pointentity.validator;

import by.mashnyuk.pointentity.entity.Point;

public interface PointValidator {
    boolean validate(Point point);
    boolean validateX(double x);
    boolean validateY(double y);
    boolean validateZ(double z);
    boolean validateTime(double time);
}
