package org.valid4j.predicates;

import org.junit.Test;

import static org.junit.Assert.*;
import static org.valid4j.predicates.ComparablePredicates.greaterThan;

public class GreaterThanTest {

  @Test
  public void shouldTestTrueInteger() {
    assertTrue(greaterThan(4).test(5));
  }

  @Test
  public void shouldTestFalseInteger() {
    assertFalse(greaterThan(4).test(4));
    assertFalse(greaterThan(4).test(3));
    assertFalse(greaterThan(4).test(null));
  }

  @Test
  public void shouldDescribeTypeInteger() {
    assertEquals("3", greaterThan(4).describe(3));
    assertEquals("5", greaterThan(4).describe(5));
  }

  @Test
  public void shouldBeDescriptiveInteger() {
    assertEquals("greater than '4'", greaterThan(4).toString());
  }

  @Test
  public void shouldTestTrueCharacter() {
    assertTrue(greaterThan('b').test('c'));
  }

  @Test
  public void shouldTestFalseCharacter() {
    assertFalse(greaterThan('b').test('a'));
    assertFalse(greaterThan('b').test(null));
  }

  @Test
  public void shouldDescribeTypeCharacter() {
    assertEquals("a", greaterThan('b').describe('a'));
    assertEquals("c", greaterThan('b').describe('c'));
  }

  @Test
  public void shouldBeDescriptiveCharacter() {
    assertEquals("greater than 'b'", greaterThan('b').toString());
  }

}
