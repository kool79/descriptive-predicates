package org.valid4j.predicates.example;

import java.util.LinkedList;
import java.util.List;

/**
 * Example class, to demonstrate the use of descriptive predicates
 */
public class Basket {
    public final List<Fruit> fruits = new LinkedList<>();

    @Override
    public String toString() {
        throw new AssertionError("Unusable toString()");
    }
}
