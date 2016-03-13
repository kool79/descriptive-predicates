package org.valid4j.predicates;

import org.junit.Test;

import static org.junit.Assert.*;
import static org.valid4j.predicates.CorePredicates.equalTo;
import static org.valid4j.predicates.helper.TestingPredicates.otherPred;

public class NegateTest {

  @Test
  public void shouldTestTrue() {
    assertTrue(equalTo(4).negate().test(3));
    assertTrue(equalTo((Number) 4).negate().test(3));
    assertTrue(equalTo((Number) 4).negate().test(2.3));
    assertTrue(equalTo(4).negate().test(null));
  }

  @Test
  public void shouldTestFalse() {
    assertFalse(equalTo(4).negate().test(4));
  }

  @Test
  public void shouldBeDescriptive() {
    assertEquals("not (equal to '4')", equalTo(4).negate().toString());
  }

  @Test
  public void shouldDescribeType() {
    assertEquals("describing(4)", otherPred("describing").negate().describe(4));
  }
}
