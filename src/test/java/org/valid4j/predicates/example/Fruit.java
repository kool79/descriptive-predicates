package org.valid4j.predicates.example;

/**
 * Example class, to demonstrate the use of descriptive predicates
 */
public class Fruit {
    public static int TYPE_APPLE = 1;
    public static int TYPE_BANANA = 2;
    public static int TYPE_ORANGE = 3;
    public static int TYPE_MANGO = 4;

    public final int type;
    public final Color color;

    public Fruit(int type, Color color) {
        this.type = type;
        this.color = color;
    }

    @Override
    public String toString() {
        throw new AssertionError("Unusable toString()");
    }
}
