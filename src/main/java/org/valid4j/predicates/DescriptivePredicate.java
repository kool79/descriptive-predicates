package org.valid4j.predicates;

import java.util.function.Predicate;

/**
 * Core interface for descriptive predicates.
 * <p/>
 * Descriptive predicates has three properties;
 * it acts as a predicate for a type <pre>T</pre>,
 * it acts as a describer of a type <pre>T</pre>, and
 * it provides a descriptive message of a predicate.
 *
 * @param <T>
 */
public interface DescriptivePredicate<T> extends Predicate<T> {

  @Override
  boolean test(T actual);

  String describe(T actual);

  @Override
  String toString();

}
