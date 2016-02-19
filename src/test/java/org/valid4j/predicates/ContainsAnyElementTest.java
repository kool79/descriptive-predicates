package org.valid4j.predicates;

import org.junit.Test;

import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.*;
import static org.valid4j.predicates.CollectionPredicates.containsAnyElement;
import static org.valid4j.predicates.ComparablePredicates.greaterThan;
import static org.valid4j.predicates.helper.Verify.verifyThat;

public class ContainsAnyElementTest {

  @Test
  public void shouldVerify() {
    verifyThat(3, greaterThan(2));
  }

  @Test
  public void shouldTestContainingElement() {
    List<Integer> list = Arrays.asList(3, 4, 7, 2);
    assertTrue(containsAnyElement(4).test(list));
    assertFalse(containsAnyElement(5).test(list));
    assertEquals("contains any element 5", containsAnyElement(5).toString());
    assertEquals("[3, 4, 7, 2]", containsAnyElement(4).describe(list));
  }

  @Test
  public void shouldTestContainingElementWithPred() {
    List<Integer> list = Arrays.asList(3, 4, 7, 2);
    assertTrue(containsAnyElement(greaterThan(6)).test(list));
    assertFalse(containsAnyElement(greaterThan(8)).test(list));
    assertEquals(
        "must be descriptive",
        "contains any element greater than '7'",
        containsAnyElement(greaterThan(7)).toString());
    assertEquals(
        "must describe the list",
        "[3, 4, 7, 2]",
        containsAnyElement(greaterThan(9)).describe(list));
  }

}
