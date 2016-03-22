package org.valid4j.predicates;

import org.junit.Test;

import static org.junit.Assert.*;
import static org.valid4j.predicates.ComparablePredicates.greaterThan;
import static org.valid4j.predicates.CorePredicates.allOf;
import static org.valid4j.predicates.Evaluation.evaluate;

public class AllOfTest {

    @Test
    public void shouldTestTrue() {
        assertTrue(evaluate(4, allOf(greaterThan(2), greaterThan(3))).result());
        assertTrue(evaluate(4, allOf()).result());
    }

    @Test
    public void shouldTestFalse() {
        assertFalse(evaluate(0, allOf(greaterThan(2), greaterThan(5))).result());
        assertFalse(evaluate(3, allOf(greaterThan(2), greaterThan(5))).result());
        assertFalse(evaluate(null, allOf(greaterThan(2), greaterThan(5))).result());
    }

    @Test
    public void shouldBeDescriptive() {
        assertEquals("all of [greater than '2', greater than '5']",
                evaluate(7, allOf(greaterThan(2), greaterThan(5))).expected());
    }

    @Test
    public void shouldDescribeType() {
        assertEquals("7", evaluate(7, allOf(greaterThan(2), greaterThan(5))).actual());
    }
}
