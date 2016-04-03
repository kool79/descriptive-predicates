package org.valid4j.predicates;

import org.junit.Test;

import java.util.IllegalFormatException;

import static org.junit.Assert.*;
import static org.valid4j.predicates.CorePredicates.*;
import static org.valid4j.predicates.Evaluation.evaluate;

public class DescribedAsTest {

    @Test
    public void shouldTestTrueViaDelegation() {
        assertTrue(evaluate(4, describedAs("example", equalTo(4))).result());
        assertTrue(evaluate(3, describedAs("example", equalTo(3))).result());
        assertTrue(evaluate(null, describedAs("example", nullValue())).result());
    }

    @Test
    public void shouldTestFalseViaDelegation() {
        assertFalse(evaluate(3, describedAs("example", equalTo(4))).result());
        assertFalse(evaluate(4, describedAs("example", equalTo(3))).result());
        assertFalse(evaluate(null, describedAs("example", not(nullValue()))).result());
    }

    @Test
    public void shouldBeDescriptiveWithNoValues() {
        assertEquals("example", describedAs("example", equalTo(4)).toString());
    }

    @Test
    public void shouldBeDescriptiveWithSingleArgument() {
        assertEquals("is four", describedAs("is %s", equalTo(4), "four").toString());
    }

    @Test
    public void shouldBeDescriptiveWithMultipleArguments() {
        assertEquals("as good as 4", describedAs("as %s as %d", equalTo(4), "good", 4).toString());
    }

    @Test
    public void shouldBeDescriptiveWithNullArguments() {
        assertEquals("as good as null", describedAs("as %s as %d", equalTo(4), "good", null).toString());
    }

    @Test(expected = IllegalFormatException.class)
    public void shouldFailWithMissingArguments() {
        describedAs("as %s as %d", equalTo(4), "good").toString();
    }

    @Test
    public void shouldDescribeTypeViaDelegation() {
        assertEquals("5", evaluate(5, describedAs("as %s as %d", equalTo(4), "good", 4)).actual());
    }
}
