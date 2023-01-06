package praktikum;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;

import java.util.List;

import static org.junit.Assert.assertEquals;

@RunWith(MockitoJUnitRunner.Silent.class)
public class BurgerTest {
    @Mock
    private Bun bun;
    @Mock
    private Ingredient sauce;
    @Mock
    private Ingredient filling;
    private Burger burger;

    @Before
    public void init() {
        burger = new Burger();
    }

    @Test
    public void setBunsTest() {
        burger.setBuns(bun);
        Bun result = burger.bun;
        assertEquals(bun, result);
    }

    @Test
    public void addIngredientTest() {
        burger.addIngredient(sauce);
        burger.addIngredient(filling);
        List<Ingredient> result = burger.ingredients;
        assertEquals(List.of(sauce, filling), result);
    }

    @Test
    public void removeIngredientTest() {
        burger.addIngredient(sauce);
        burger.addIngredient(filling);
        burger.removeIngredient(0);
        List<Ingredient> result = burger.ingredients;
        assertEquals(List.of(filling), result);
    }

    @Test
    public void moveIngredientTest() {
        burger.addIngredient(filling);
        burger.addIngredient(sauce);
        burger.moveIngredient(0, 1);
        Ingredient result = burger.ingredients.get(0);
        assertEquals(sauce, result);
    }

    @Test
    public void getReceiptTest() {
        Mockito.when(bun.getName()).thenReturn("Special");
        Mockito.when(bun.getPrice()).thenReturn(50.0f);
        burger.setBuns(bun);
        Mockito.when(sauce.getType()).thenReturn(IngredientType.SAUCE);
        Mockito.when(sauce.getName()).thenReturn("Ketchup");
        Mockito.when(sauce.getPrice()).thenReturn(10.0f);
        burger.addIngredient(sauce);
        Mockito.when(filling.getType()).thenReturn(IngredientType.FILLING);
        Mockito.when(filling.getName()).thenReturn("Bacon");
        Mockito.when(filling.getPrice()).thenReturn(50.0f);
        burger.addIngredient(filling);
        StringBuilder receipt = new StringBuilder(String.format("(==== %s ====)%n", bun.getName()));
        List<Ingredient> ingredients = burger.ingredients;
        for (Ingredient ingredient : ingredients) {
            receipt.append(String.format("= %s %s =%n", ingredient.getType().name().toLowerCase(),
                    ingredient.getName()));
        }
        receipt.append(String.format("(==== %s ====)%n", bun.getName()));
        receipt.append(String.format("%nPrice: %f%n", burger.getPrice()));
        String result = burger.getReceipt();
        assertEquals(receipt.toString(), result);
    }

    @Test
    public void getPriceTest() {
        Mockito.when(bun.getName()).thenReturn("Special");
        Mockito.when(bun.getPrice()).thenReturn(50.0f);
        burger.setBuns(bun);
        Mockito.when(sauce.getType()).thenReturn(IngredientType.SAUCE);
        Mockito.when(sauce.getName()).thenReturn("Ketchup");
        Mockito.when(sauce.getPrice()).thenReturn(10.0f);
        burger.addIngredient(sauce);
        Mockito.when(filling.getType()).thenReturn(IngredientType.FILLING);
        Mockito.when(filling.getName()).thenReturn("Bacon");
        Mockito.when(filling.getPrice()).thenReturn(50.0f);
        burger.addIngredient(filling);
        float expectedPrice = bun.getPrice() * 2 + sauce.getPrice() + filling.getPrice();
        float actualPrice = burger.getPrice();
        assertEquals(expectedPrice, actualPrice, 0);
    }
}