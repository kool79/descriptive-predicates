package org.valid4j.predicates;

import java.util.Objects;
import java.util.function.Function;
import java.util.function.Predicate;

public class StandardPredicate<T> implements DescriptivePredicate<T> {
  private final String description;
  private final Predicate<T> delegate;
  private final Function<T, String> describer;

  public StandardPredicate(String description, Predicate<T> delegate) {
    this(description, delegate, Objects::toString);
  }

  public StandardPredicate(String description, Predicate<T> delegate, Function<T, String> describer) {
    this.description = description;
    this.delegate = delegate;
    this.describer = describer;
  }

  @Override
  public boolean test(T actual) {
    return this.delegate.test(actual);
  }

  @Override
  public String describe(T actual) {
    return this.describer.apply(actual);
  }

  @Override
  public String toString() {
    return this.description;
  }

  @Override
  public DescriptivePredicate<T> negate() {
    return new StandardPredicate<>(
        "not (" + this.description + ")",
        (t) -> !test(t),
        this.describer);
  }

  @Override
  public DescriptivePredicate<T> and(Predicate<? super T> other) {
    return new StandardPredicate<>(
        "(" + this.description + " and " + other.toString() + ")",
        (t) -> test(t) && other.test(t),
        this.describer);
  }

  @Override
  public DescriptivePredicate<T> or(Predicate<? super T> other) {
    Objects.requireNonNull(other);
    return new StandardPredicate<>(
        "(" + this.description + " or " + other.toString() + ")",
        (t) -> test(t) || other.test(t),
        this.describer);
  }
}
