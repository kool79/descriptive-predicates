package org.valid4j.predicates.example;

import org.valid4j.predicates.DescriptivePredicate;
import org.valid4j.predicates.StandardPredicate;

import java.util.HashMap;
import java.util.Map;
import java.util.function.Function;

import static java.util.stream.Collectors.joining;

/**
 * Example of descriptive predicates
 */
public class ExamplePredicates {

    public static DescriptivePredicate<? super Basket> containsAnyFruit(DescriptivePredicate<? super Fruit> fruitPred) {
        Map<Integer, String> fruitTypes = new HashMap<>();
        fruitTypes.put(Fruit.TYPE_APPLE, "Apple");
        fruitTypes.put(Fruit.TYPE_BANANA, "Banana");
        fruitTypes.put(Fruit.TYPE_ORANGE, "Orange");
        fruitTypes.put(Fruit.TYPE_MANGO, "Mango");
        Function<? super Fruit, String> fruitType = fruit -> fruitTypes.getOrDefault(fruit.type, "Unknown");
        Function<? super Fruit, String> fruitDescriber = fruit ->
                fruitType.apply(fruit) + "(" + fruitPred.describe(fruit) + ")";

        return new StandardPredicate<>(
                "contains any fruit (" + fruitPred + ")",
                b -> b.fruits.stream().anyMatch(fruitPred),
                b -> b.fruits.stream().map(fruitDescriber).collect(joining(", ", "[", "]")));
    }

    public static DescriptivePredicate<? super Fruit> ofColor(Color color) {
        return new StandardPredicate<>(
                "of color (" + color + ")",
                f -> f.color == color,
                f -> "color(" + f.color.toString() + ")");
    }
}
