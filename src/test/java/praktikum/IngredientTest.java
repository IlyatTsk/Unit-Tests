package praktikum;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class IngredientTest {
    private Ingredient ingredient;

    @Test
    public void getNameTest() {
        ingredient = new Ingredient(IngredientType.SAUCE, "Ketchup", 10.0f);
        String result = ingredient.getName();
        assertEquals("Ketchup", result);
    }

    @Test
    public void getPriceTest() {
        ingredient = new Ingredient(IngredientType.SAUCE, "Ketchup", 10.0f);
        float result = ingredient.getPrice();
        assertEquals(10.0f, result, 0);
    }
}