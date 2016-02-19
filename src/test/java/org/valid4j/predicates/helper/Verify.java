package org.valid4j.predicates.helper;

import org.valid4j.predicates.DescriptivePredicate;

import java.util.function.Predicate;

public class Verify {

  public static <T> void verifyThat(T actual, DescriptivePredicate<? super T> descriptivePredicate) {
    if (!descriptivePredicate.test(actual)) {
      String message = new StringBuilder("\n")
          .append("expected: ").append(descriptivePredicate.toString()).append("\n")
          .append("but was : ")
          .append(descriptivePredicate.describe(actual))
          .toString();
      throw new AssertionError(message);
    }
  }

  public static <T> void verifyThat(T actual, Predicate<? super T> matcher) {
    if (!matcher.test(actual)) {
      String message = new StringBuilder("\n")
          .append("expected: ").append(matcher.toString()).append("\n")
          .append("but was : ").append(actual.toString())
          .toString();
      throw new AssertionError(message);
    }
  }
}
