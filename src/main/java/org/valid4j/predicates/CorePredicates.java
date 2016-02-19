package org.valid4j.predicates;

import java.util.function.Predicate;

public class CorePredicates {

  public static <T> DescriptivePredicate<T> equalTo(T value) {
    return new StandardPredicate<>(
        "equal to '" + value + "'",
        Predicate.isEqual(value));
  }

  public static <T> DescriptivePredicate<T> nullValue() {
    return new StandardPredicate<>(
        "null value",
        o -> o == null);
  }

}
