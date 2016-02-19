package org.valid4j.predicates;

import java.util.Collection;

public class CollectionPredicates {

  public static <T> DescriptivePredicate<Collection<? super T>> containsAnyElement(T value) {
    return new StandardPredicate<>(
        "contains any element " + value,
        collection -> collection.contains(value));
  }

  public static <T> DescriptivePredicate<Collection<? extends T>> containsAnyElement(
      final DescriptivePredicate<? super T> matching) {
    return new StandardPredicate<>(
        "contains any element " + matching,
        collection -> collection.stream().anyMatch(matching));
  }
}
