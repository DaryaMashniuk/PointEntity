package by.mashnyuk.pointentity.entity;

public class Point {
    private double x;
    private double y;
    private double z;
    private double time;
    private double vx, vy, vz;  // Скорость
    private double ax, ay, az;

    public Point(double x, double y, double z, double time, double vx, double vy, double vz, double ax, double ay, double az) {
        this.x = x;
        this.y = y;
        this.z = z;
        this.time = time;
        this.vx = vx;
        this.vy = vy;
        this.vz = vz;
        this.ax = ax;
        this.ay = ay;
        this.az = az;
    }
    public Point(double x, double y, double time, double vx, double vy,double ax, double ay) {
        this.x = x;
        this.y = y;
        this.time = time;
        this.vx = vx;
        this.vy = vy;
        this.ax = ax;
        this.ay = ay;
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

    public double getVx() {
        return vx;
    }

    public double getVy() {
        return vy;
    }

    public double getVz() {
        return vz;
    }

    public double getAx() {
        return ax;
    }

    public double getAy() {
        return ay;
    }

    public double getAz() {
        return az;
    }

    public void setVx(double vx) {
        this.vx = vx;
    }

    public void setVy(double vy) {
        this.vy = vy;
    }

    public void setVz(double vz) {
        this.vz = vz;
    }

    public void setAx(double ax) {
        this.ax = ax;
    }

    public void setAy(double ay) {
        this.ay = ay;
    }

    public void setAz(double az) {
        this.az = az;
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        Point point = (Point) o;
        return x == point.x && y == point.y && z == point.z && time == point.time &&
                vx == point.vx && vy == point.vy && vz == point.vz && ax == point.ax &&
                ay == point.ay && az == point.az;
    }

    @Override
    public int hashCode() {
        int result = 0;
        long longX = Double.doubleToLongBits(x);
        long longY = Double.doubleToLongBits(y);
        long longZ = Double.doubleToLongBits(z);
        long longTime = Double.doubleToLongBits(time);
        long longVx = Double.doubleToLongBits(vx);
        long longVy = Double.doubleToLongBits(vy);
        long longVz = Double.doubleToLongBits(vz);
        long longAx = Double.doubleToLongBits(ax);
        long longAy = Double.doubleToLongBits(ay);
        long longAz = Double.doubleToLongBits(az);
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
        sb.append(", vx=").append(vx);
        sb.append(", vy=").append(vy);
        sb.append(", vz=").append(vz);
        sb.append(", ax=").append(ax);
        sb.append(", ay=").append(ay);
        sb.append(", az=").append(az);
        sb.append('}');
        return sb.toString();
    }

}
