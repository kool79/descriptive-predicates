package org.valid4j.predicates.example;

import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import static org.valid4j.predicates.Evaluation.evaluate;
import static org.valid4j.predicates.example.ExamplePredicates.containsAnyFruit;
import static org.valid4j.predicates.example.ExamplePredicates.ofColor;
import static org.valid4j.predicates.helper.Verify.verifyThat;

public class UsageTest {

    private static final Fruit APPLE = new Fruit(Fruit.TYPE_APPLE, Color.RED);

    @Test
    public void shouldBeFruitOfGivenColor() {
        verifyThat(APPLE, ofColor(Color.RED));

        assertEquals("of color (RED)",
                evaluate(APPLE, ofColor(Color.RED)).expected());
        assertEquals("color(RED)",
                evaluate(APPLE, ofColor(Color.RED)).actual());
        assertTrue(
                evaluate(APPLE, ofColor(Color.RED)).result());
    }

    @Test
    public void shouldHaveBasketContainingAnyFruitOfColor() {
        Basket basket = new Basket();
        basket.fruits.add(new Fruit(Fruit.TYPE_APPLE, Color.RED));
        basket.fruits.add(new Fruit(Fruit.TYPE_ORANGE, Color.YELLOW));
        basket.fruits.add(new Fruit(Fruit.TYPE_BANANA, Color.YELLOW));

        assertEquals("contains any fruit (of color (RED))",
                evaluate(basket, containsAnyFruit(ofColor(Color.RED))).expected());
        assertEquals("[Apple(color(RED)), Orange(color(YELLOW)), Banana(color(YELLOW))]",
                evaluate(basket, containsAnyFruit(ofColor(Color.RED))).actual());
        assertTrue(
                evaluate(basket, containsAnyFruit(ofColor(Color.RED))).result());
    }

}
