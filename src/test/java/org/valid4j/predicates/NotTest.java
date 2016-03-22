package org.valid4j.predicates;

import org.junit.Test;

import static org.junit.Assert.*;
import static org.valid4j.predicates.CorePredicates.*;
import static org.valid4j.predicates.Evaluation.evaluate;
import static org.valid4j.predicates.helper.TestingPredicates.otherPred;

public class NotTest {

  @Test
  public void shouldTestTrue() {
    assertTrue(evaluate(3, not(equalTo(4))).result());
    assertTrue(evaluate(3, not(equalTo((Number) 4))).result());
    assertTrue(evaluate(2.3, not(equalTo((Number) 4))).result());
    assertTrue(evaluate(null, not(equalTo(4))).result());
  }

  @Test
  public void shouldTestFalse() {
    assertFalse(evaluate(4, not(equalTo(4))).result());
  }

  @Test
  public void shouldBeDescriptive() {
    assertEquals("not (equal to '4')", not(equalTo(4)).toString());
    assertEquals("not (instance of java.lang.Integer)", not(instanceOf(Integer.class)).toString());
  }

  @Test
  public void shouldDescribeType() {
    assertEquals("describing(4)", evaluate(4, not(otherPred("describing"))).actual());
  }
}
