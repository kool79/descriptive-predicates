package org.valid4j.predicates;

import org.junit.Test;

import static org.junit.Assert.*;
import static org.valid4j.predicates.CorePredicates.equalTo;

public class EqualToTest {

  @Test
  public void shouldTestTrueInteger() {
    assertTrue(equalTo(4).test(4));
  }

  @Test
  public void shouldTestFalseInteger() {
    assertFalse(equalTo(4).test(3));
    assertFalse(equalTo((Number) 4).test(3));
    assertFalse(equalTo((Number) 4).test(2.3));
    assertFalse(equalTo(4).test(null));
  }

  @Test
  public void shouldDescribeTypeInteger() {
    assertEquals("5", equalTo(4).describe(5));
  }

  @Test
  public void shouldBeDescriptiveInteger() {
    assertEquals("equal to '4'", equalTo(4).toString());
  }

  @Test
  public void shouldTestTrueString() {
    assertTrue(equalTo("abc").test("abc"));
  }

  @Test
  public void shouldTestFalseString() {
    assertFalse(equalTo("abc").test("def"));
    assertFalse(equalTo("abc").test(null));
  }

  @Test
  public void shouldDescribeTypeString() {
    assertEquals("def", equalTo("abc").describe("def"));
  }

  @Test
  public void shouldBeDescriptiveString() {
    assertEquals("equal to 'abc'", equalTo("abc").toString());
  }

  @Test
  public void shouldTestTrueBoolean() {
    assertTrue(equalTo(true).test(true));
  }

  @Test
  public void shouldTestFalseBoolean() {
    assertFalse(equalTo(true).test(false));
    assertFalse(equalTo(true).test(null));
  }

  @Test
  public void shouldDescribeTypeBoolean() {
    assertEquals("false", equalTo(true).describe(false));
  }

  @Test
  public void shouldBeDescriptiveBoolean() {
    assertEquals("equal to 'true'", equalTo(true).toString());
  }

  @Test
  public void shouldTestTrueNull() {
    assertTrue(equalTo(null).test(null));
  }

  @Test
  public void shouldTestFalseNull() {
    assertFalse(equalTo(null).test(new Object()));
    assertFalse(equalTo(null).test(1));
    assertFalse(equalTo(null).test("abc"));
    assertFalse(equalTo(null).test(false));
  }

  @Test
  public void shouldDescribeTypeNull() {
    assertEquals("1", equalTo(null).describe(1));
    assertEquals("abc", equalTo(null).describe("abc"));
    assertEquals("false", equalTo(null).describe(false));
    assertEquals("null", equalTo(null).describe(null));
  }

  @Test
  public void shouldBeDescriptiveNull() {
    assertEquals("equal to 'null'", equalTo(null).toString());
  }

}
