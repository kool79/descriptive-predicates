package org.valid4j.predicates;

import org.junit.Test;

import static org.junit.Assert.*;
import static org.valid4j.predicates.ComparablePredicates.greaterThan;
import static org.valid4j.predicates.CorePredicates.anyOf;
import static org.valid4j.predicates.CorePredicates.equalTo;
import static org.valid4j.predicates.Evaluation.evaluate;

public class AnyOfTest {

    @Test
    public void shouldTestTrue() {
        assertTrue(evaluate("1", anyOf(equalTo("1"))).result());
        assertTrue(evaluate("a", anyOf(equalTo("a"), equalTo("b"))).result());
        assertTrue(evaluate("b", anyOf(equalTo("a"), equalTo("b"))).result());
        assertTrue(evaluate(2, anyOf(equalTo("a"), equalTo(2), equalTo(1.4))).result());
    }

    @Test
    public void shouldTestFalse() {
        assertFalse(evaluate(null, anyOf()).result());
        assertFalse(evaluate(null, anyOf(equalTo(1))).result());
        assertFalse(evaluate(2, anyOf(equalTo(1), equalTo(3))).result());
    }

    @Test
    public void shouldBeDescriptive() {
        assertEquals("any of [equal to 'a', equal to '5']",
                evaluate("abc", anyOf(equalTo("a"), equalTo(5))).expected());
    }

    @Test
    public void shouldDescribeType() {
        assertEquals("3",
                evaluate(3, anyOf(greaterThan(2), greaterThan(5))).actual());
    }

}
