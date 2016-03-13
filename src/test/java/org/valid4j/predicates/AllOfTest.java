package org.valid4j.predicates;

import org.junit.Test;

import static org.junit.Assert.*;
import static org.valid4j.predicates.ComparablePredicates.greaterThan;
import static org.valid4j.predicates.CorePredicates.allOf;

public class AllOfTest {

  @Test
  public void shouldTestTrue() {
    assertTrue(allOf(greaterThan(2), greaterThan(3)).test(4));
  }

  @Test
  public void shouldTestFalse() {
    assertFalse(allOf(greaterThan(2), greaterThan(5)).test(0));
    assertFalse(allOf(greaterThan(2), greaterThan(5)).test(3));
    assertFalse(allOf(greaterThan(2), greaterThan(5)).test(null));
  }

  @Test
  public void shouldBeDescriptive() {
    assertEquals("all of [greater than '2', greater than '5']",
        allOf(greaterThan(2), greaterThan(5)).toString());
  }

  @Test
  public void shouldDescribeType() {
    assertEquals("3", allOf(greaterThan(2), greaterThan(5)).describe(3));
  }
}
