package org.valid4j.predicates;

public class Evaluation {

    private final boolean result;
    private final String expected;
    private final String actual;

    public Evaluation(boolean result, String expected, String actual) {
        this.result = result;
        this.expected = expected;
        this.actual = actual;
    }

    public static <T> Evaluation evaluate(T object, DescriptivePredicate<T> pred) {
        return new Evaluation(
                pred.test(object),
                pred.toString(),
                pred.describe(object));
    }

    public boolean result() {
        return this.result;
    }

    public String expected() {
        return this.expected;
    }

    public String actual() {
        return this.actual;
    }

    @Override
    public String toString() {
        return this.actual;
    }
}
