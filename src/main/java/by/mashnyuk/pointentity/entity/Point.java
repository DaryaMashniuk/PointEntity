package by.mashnyuk.pointentity.entity;

public class Point {
    private double x;
    private double y;
    private double z;
    private double time;
    private double velocityX, velocityY, velocityZ;  // Скорость
    private double accelerationX, accelerationY, accelerationZ;

    public Point(double x, double y, double z, double time, double velocityX, double vy, double velocityZ, double accelerationX, double accelerationY, double accelerationZ) {
        this.x = x;
        this.y = y;
        this.z = z;
        this.time = time;
        this.velocityX = velocityX;
        this.velocityY = vy;
        this.velocityZ = velocityZ;
        this.accelerationX = accelerationX;
        this.accelerationY = accelerationY;
        this.accelerationZ = accelerationZ;
    }
    public Point(double x, double y, double time, double velocityX, double vy, double accelerationX, double accelerationY) {
        this.x = x;
        this.y = y;
        this.time = time;
        this.velocityX = velocityX;
        this.velocityY = vy;
        this.accelerationX = accelerationX;
        this.accelerationY = accelerationY;
    }

    public double getX() {
        return x;
    }

    public double getY() {
        return y;
    }

    public double getZ() {
        return z;
    }

    public void setX(double x) {
        this.x = x;
    }

    public void setY(double y) {
        this.y = y;
    }

    public void setZ(double z) {
        this.z = z;
    }

    public double getTime() {
        return time;
    }

    public void setTime(double time) {
        this.time = time;
    }

    public double getVelocityX() {
        return velocityX;
    }

    public double getVelocityY() {
        return velocityY;
    }

    public double getVelocityZ() {
        return velocityZ;
    }

    public double getAccelerationX() {
        return accelerationX;
    }

    public double getAccelerationY() {
        return accelerationY;
    }

    public double getAccelerationZ() {
        return accelerationZ;
    }

    public void setVelocityX(double velocityX) {
        this.velocityX = velocityX;
    }

    public void setVelocityY(double velocityY) {
        this.velocityY = velocityY;
    }

    public void setVelocityZ(double velocityZ) {
        this.velocityZ = velocityZ;
    }

    public void setAccelerationX(double accelerationX) {
        this.accelerationX = accelerationX;
    }

    public void setAccelerationY(double accelerationY) {
        this.accelerationY = accelerationY;
    }

    public void setAccelerationZ(double accelerationZ) {
        this.accelerationZ = accelerationZ;
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        Point point = (Point) o;
        return x == point.x && y == point.y && z == point.z && time == point.time &&
                velocityX == point.velocityX && velocityY == point.velocityY && velocityZ == point.velocityZ && accelerationX == point.accelerationX &&
                accelerationY == point.accelerationY && accelerationZ == point.accelerationZ;
    }

    @Override
    public int hashCode() {
        int result = 0;
        long longX = Double.doubleToLongBits(x);
        long longY = Double.doubleToLongBits(y);
        long longZ = Double.doubleToLongBits(z);
        long longTime = Double.doubleToLongBits(time);
        long longVx = Double.doubleToLongBits(velocityX);
        long longVy = Double.doubleToLongBits(velocityY);
        long longVz = Double.doubleToLongBits(velocityZ);
        long longAx = Double.doubleToLongBits(accelerationX);
        long longAy = Double.doubleToLongBits(accelerationY);
        long longAz = Double.doubleToLongBits(accelerationZ);
        result = 31 * result + Long.hashCode(longX);
        result = 31 * result + Long.hashCode(longY);
        result = 31 * result + Long.hashCode(longZ);
        result = 31 * result + Long.hashCode(longTime);
        result = 31 * result + Long.hashCode(longVx);
        result = 31 * result + Long.hashCode(longVy);
        result = 31 * result + Long.hashCode(longVz);
        result = 31 * result + Long.hashCode(longAx);
        result = 31 * result + Long.hashCode(longAy);
        result = 31 * result + Long.hashCode(longAz);
        return result;
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("Point{");
        sb.append("x=").append(x);
        sb.append(", y=").append(y);
        sb.append(", z=").append(z);
        sb.append(", time=").append(time);
        sb.append(", vx=").append(velocityX);
        sb.append(", vy=").append(velocityY);
        sb.append(", vz=").append(velocityZ);
        sb.append(", ax=").append(accelerationX);
        sb.append(", ay=").append(accelerationY);
        sb.append(", az=").append(accelerationZ);
        sb.append('}');
        return sb.toString();
    }

}
