package org.valid4j.predicates.helper;

import org.valid4j.predicates.DescriptivePredicate;
import org.valid4j.predicates.StandardPredicate;

/**
 * A set of dummy predicates for testing purposes
 */
public class TestingPredicates {

  /**
   * Represents a reference to any other predicate
   */
  public static <T> DescriptivePredicate<T> otherPred(String msg) {
    return new StandardPredicate<>(
        "other predicate '" + msg + "'",
        o -> false,
        t -> msg + "(" + t + ")"
    );
  }

}
