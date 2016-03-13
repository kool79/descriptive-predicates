package org.valid4j.predicates;

import org.junit.Test;

import static org.junit.Assert.*;
import static org.valid4j.predicates.CorePredicates.equalTo;
import static org.valid4j.predicates.CorePredicates.not;
import static org.valid4j.predicates.helper.TestingPredicates.otherPred;

public class NotTest {

  @Test
  public void shouldTestTrue() {
    assertTrue(not(equalTo(4)).test(3));
    assertTrue(not(equalTo((Number) 4)).test(3));
    assertTrue(not(equalTo((Number) 4)).test(2.3));
    assertTrue(not(equalTo(4)).test(null));
  }

  @Test
  public void shouldTestFalse() {
    assertFalse(not(equalTo(4)).test(4));
  }

  @Test
  public void shouldBeDescriptive() {
    assertEquals("not (equal to '4')", not(equalTo(4)).toString());
  }

  @Test
  public void shouldDescribeType() {
    assertEquals("describing(4)", not(otherPred("describing")).describe(4));
  }
}
