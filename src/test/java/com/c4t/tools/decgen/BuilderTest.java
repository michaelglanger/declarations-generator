package com.c4t.tools.decgen;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class BuilderTest {

    @Test
    void calculateMass() {
        Builder builder = new Builder();
        int mass = builder.calculateMass(100, 100, 10);
        assertEquals(100, mass);

        mass = builder.calculateMass(100, 10, 10);
        assertEquals(100, mass);

        mass = builder.calculateMass(10, 100, 10);
        assertTrue(((mass-10) % 10) == 0 );

        mass = builder.calculateMass(1, 333, 3);
        System.out.println(mass);
        assertTrue(((mass-1) % 3) == 0 );
    }
}