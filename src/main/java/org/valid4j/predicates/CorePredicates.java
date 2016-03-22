package org.valid4j.predicates;

import java.util.Arrays;
import java.util.function.Predicate;

public class CorePredicates {

  public static <T> DescriptivePredicate<T> equalTo(T value) {
    return new StandardPredicate<>(
        "equal to '" + value + "'",
        Predicate.isEqual(value));
  }

  public static <T> DescriptivePredicate<T> not(DescriptivePredicate<T> pred) {
    return pred.negate();
  }

  public static <T> DescriptivePredicate<T> nullValue() {
    return new StandardPredicate<>(
        "null value",
        o -> o == null);

  }

  public static <T> DescriptivePredicate<T> allOf(final DescriptivePredicate<T>... predicates) {
    return new StandardPredicate<T>(
        "all of " + Arrays.toString(predicates),
        o -> Arrays.stream(predicates)
            .map(p -> p.test(o))
                .reduce(true, Boolean::logicalAnd));
  }

  public static <T> DescriptivePredicate<T> anyOf(final DescriptivePredicate<T>... predicates) {
    return new StandardPredicate<>(
            "any of " + Arrays.toString(predicates),
            o -> Arrays.stream(predicates)
                    .map(p -> p.test(o))
                    .reduce(false, Boolean::logicalOr));
  }

}
