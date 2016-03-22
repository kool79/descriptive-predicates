package org.valid4j.predicates;

import org.junit.Test;

import static org.junit.Assert.*;
import static org.valid4j.predicates.CorePredicates.nullValue;
import static org.valid4j.predicates.Evaluation.evaluate;

public class NullValueTest {

  @Test
  public void shouldTestTrue() {
    assertTrue(evaluate(null, nullValue()).result());
  }

  @Test
  public void shouldTestFalse() {
    assertFalse(evaluate(new Object(), nullValue()).result());
    assertFalse(evaluate(false, nullValue()).result());
    assertFalse(evaluate(1, nullValue()).result());
    assertFalse(evaluate(1.2, nullValue()).result());
    assertFalse(evaluate("abc", nullValue()).result());
  }

  @Test
  public void shouldBeDescriptive() {
    assertEquals("null value", evaluate(new Object(), nullValue()).expected());
  }

  @Test
  public void shouldDescribeType() {
    assertEquals("false", evaluate(false, nullValue()).actual());
    assertEquals("1", evaluate(1, nullValue()).actual());
    assertEquals("1.2", evaluate(1.2, nullValue()).actual());
    assertEquals("abc", evaluate("abc", nullValue()).actual());
    assertEquals("null", evaluate(null, nullValue()).actual());
  }
}
