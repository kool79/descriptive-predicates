package org.valid4j.predicates;

import org.junit.Test;

import static org.junit.Assert.*;
import static org.valid4j.predicates.ComparablePredicates.lessThan;
import static org.valid4j.predicates.Evaluation.evaluate;

public class LessThanTest {

    @Test
    public void shouldTestTrue() {
        assertTrue(evaluate(4, lessThan(5)).result());
        assertTrue(evaluate(0.99, lessThan(1.2)).result());
        assertTrue(evaluate('a', lessThan('b')).result());
        assertTrue(evaluate("ABC", lessThan("abc")).result());
    }

    @Test
    public void shouldTestFalse() {
        assertFalse(evaluate(4, lessThan(4)).result());
        assertFalse(evaluate(5, lessThan(4)).result());
        assertFalse(evaluate(0.99, lessThan(0.99)).result());
        assertFalse(evaluate(1.2, lessThan(0.99)).result());
        assertFalse(evaluate('a', lessThan('a')).result());
        assertFalse(evaluate('b', lessThan('a')).result());
        assertFalse(evaluate("abc", lessThan("abc")).result());
        assertFalse(evaluate("abc", lessThan("ABC")).result());

        assertFalse(evaluate(null, lessThan(4)).result());
    }

    @Test
    public void shouldBeDescriptive() {
        assertEquals("less than '4'", lessThan(4).toString());
        assertEquals("less than '0.99'", lessThan(0.99).toString());
        assertEquals("less than 'a'", lessThan('a').toString());
        assertEquals("less than 'abc'", lessThan("abc").toString());
    }

    @Test
    public void shouldDescribeType() {
        assertEquals("3", evaluate(3, lessThan(4)).actual());
        assertEquals("5", evaluate(5, lessThan(4)).actual());
        assertEquals("b", evaluate('b', lessThan('a')).actual());
        assertEquals("ABC", evaluate("ABC", lessThan("abc")).actual());
        assertEquals("1.99", evaluate(1.99, lessThan(1.2)).actual());
    }
}
