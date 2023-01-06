package praktikum;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import static org.junit.Assert.assertEquals;

@RunWith(Parameterized.class)
public class BurgerParametrizedTest {
    private final String name;
    private final float price;
    private Burger burger;
    private Ingredient sauce;
    private Ingredient filling;

    public BurgerParametrizedTest(String name, float price) {
        this.name = name;
        this.price = price;
    }

    @Parameterized.Parameters(name = "{index} : price = {0}")
    public static Object[][] getBunData() {
        return new Object[][]{
                {"Original", 20.0f},
                {"Special", 50.0f}
        };
    }

    @Before
    public void init() {
        sauce = new Ingredient(IngredientType.SAUCE, "Ketchup", 10.0f);
        filling = new Ingredient(IngredientType.FILLING, "Bacon", 50.0f);
        burger = new Burger();
    }

    @Test
    public void getPriceTest() {
        Bun bun = new Bun(name, price);
        burger.setBuns(bun);
        burger.addIngredient(sauce);
        burger.addIngredient(filling);
        float expectedPrice = bun.price * 2 + sauce.price + filling.price;
        float actualPrice = burger.getPrice();
        assertEquals(expectedPrice, actualPrice, 0);
    }
}
