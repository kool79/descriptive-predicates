package org.valid4j.predicates;

import org.junit.Test;

import static org.junit.Assert.*;
import static org.valid4j.predicates.CorePredicates.instanceOf;
import static org.valid4j.predicates.Evaluation.evaluate;

public class InstanceOfTest {

    @Test
    public void shouldTestTrue() {
        assertTrue(evaluate(4, instanceOf(Object.class)).result());
        assertTrue(evaluate(4, instanceOf(Number.class)).result());
        assertTrue(evaluate(4, instanceOf(Integer.class)).result());
        assertTrue(evaluate(0.99, instanceOf(Number.class)).result());
        assertTrue(evaluate(0.99, instanceOf(Double.class)).result());
        assertTrue(evaluate("s", instanceOf(String.class)).result());
    }

    @Test
    public void shouldTestFalse() {
        assertFalse(evaluate(4, instanceOf(Double.class)).result());
        assertFalse(evaluate(0.99, instanceOf(Integer.class)).result());
        assertFalse(evaluate('a', instanceOf(Number.class)).result());
        assertFalse(evaluate(null, instanceOf(Object.class)).result());
    }

    @Test
    public void shouldBeDescriptive() {
        assertEquals("instance of java.lang.Integer", instanceOf(Integer.class).toString());
    }

    @Test
    public void shouldDescribeType() {
        assertEquals("3(java.lang.Integer)", evaluate(3, instanceOf(Double.class)).actual());
        assertEquals("a(java.lang.Character)", evaluate('a', instanceOf(Double.class)).actual());
    }
}
