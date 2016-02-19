package org.valid4j.predicates;

import org.junit.Test;

import static org.junit.Assert.*;
import static org.valid4j.predicates.CorePredicates.nullValue;

public class NullValueTest {

  @Test
  public void shouldTestTrue() {
    assertTrue(nullValue().test(null));
  }

  @Test
  public void shouldTestFalse() {
    assertFalse(nullValue().test(new Object()));
    assertFalse(nullValue().test(false));
    assertFalse(nullValue().test(1));
    assertFalse(nullValue().test(1.2));
    assertFalse(nullValue().test("abc"));
  }

  @Test
  public void shouldDescribeType() {
    assertEquals("false", nullValue().describe(false));
    assertEquals("1", nullValue().describe(1));
    assertEquals("1.2", nullValue().describe(1.2));
    assertEquals("abc", nullValue().describe("abc"));
    assertEquals("null", nullValue().describe(null));
  }

  @Test
  public void shouldBeDescriptive() {
    assertEquals("null value", nullValue().toString());
  }

}
