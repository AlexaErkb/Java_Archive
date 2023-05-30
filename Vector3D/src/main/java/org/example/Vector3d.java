package org.example;

public class Vector3d {
    public double x, y, z;

    public Vector3d(double x, double y, double z) {
        this.x = x;
        this.y = y;
        this.z = z;
    }

    public double scalar(Vector3d v) {
        return x * v.x + y * v.y + z * v.z;
    }

    public Vector3d vector_add(Vector3d v) {
        return new Vector3d(y * v.z - z * y, z * v.x - x * v.z, x * v.y - y * v.x);
    }

    public Vector3d add(Vector3d v) {
        return new Vector3d(x + v.x, y + v.y, z + v.z);
    }

    public Vector3d sub(Vector3d v) {
        return new Vector3d(x - v.x, y - v.y, z - v.z);
    }

    public double module() {
        return Math.sqrt(Math.pow(x, 2) + Math.pow(y, 2) + Math.pow(z, 2));
    }

    public double angle(Vector3d v) {
        return Math.toDegrees((Math.acos((x * v.x + y * v.y + z * v.z)/(Math.sqrt(Math.pow(x, 2)
                + Math.pow(y, 2) + Math.pow(z, 2)) * Math.sqrt(Math.pow(v.x, 2)
                + Math.pow(v.y, 2) + Math.pow(v.z, 2))))));
    }

    @Override
    public String toString() {
        return ""+x+" "+y+" "+z;
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
}