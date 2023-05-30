package org.example;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class Vector3dTests {
    @Test
    @DisplayName("Scalar product tests")
    void  scalarProduct()
    {
        Vector3d vec=new Vector3d(1,0,0);
        Vector3d vec2=new Vector3d(0,1,0);
        double expected=0;
        assertTrue(vec.scalar(vec2)==expected);
        assertEquals(expected,vec.scalar(vec2));
    }

    @Test
    @DisplayName("Module test")
    void moduleTest() {
        Vector3d vec=new Vector3d(1,0,0);
        double exp = 1;
        assertTrue(vec.module()==exp);
        assertEquals(exp, vec.module());
    }

    @Test
    @DisplayName("Angle test")
    void angleTest() {
        Vector3d vec=new Vector3d(1,1,0);
        Vector3d vec2=new Vector3d(0,1,1);
        double exp = Math.toDegrees(Math.acos(0.5));
        assertEquals(exp, vec.angle(vec2));
    }

    @Test
    @DisplayName("Sum test")
    void sumTest() {
        Vector3d vec=new Vector3d(1,1,0);
        Vector3d vec2=new Vector3d(0,1,1);
        Vector3d exp = new Vector3d(1.0,2.0, 1.0);
        Vector3d res = vec.add(vec2);
        assertTrue(res.getX()==exp.getX()&&res.getY()==exp.getY()&&res.getZ()==exp.getZ());
    }
    @Test
    @DisplayName("Sub test")
    void subTest() {
        Vector3d vec=new Vector3d(1,1,0);
        Vector3d vec2=new Vector3d(0,1,1);
        Vector3d exp = new Vector3d(-1.0,0.0, -1.0);
        Vector3d res = vec.sub(vec2);
        assertTrue(res.getX()==exp.getX()&&res.getY()==exp.getY()&&res.getZ()==exp.getZ());
    }

}
