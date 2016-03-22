package org.valid4j.predicates;

public class ComparablePredicates {

    public static <T extends Comparable<? super T>> DescriptivePredicate<T> greaterThan(T limit) {
        return new StandardPredicate<>(
                "greater than '" + limit + "'",
                c -> c == null ? false : c.compareTo(limit) > 0);
    }

    public static <T extends Comparable<? super T>> DescriptivePredicate<T> lessThan(T limit) {
        return new StandardPredicate<>(
                "less than '" + limit + "'",
                c -> c == null ? false : c.compareTo(limit) < 0);
    }

}
