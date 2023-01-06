package praktikum;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import static org.junit.Assert.assertEquals;

@RunWith(Parameterized.class)
public class IngredientTypeParametrizedTest {
    private final IngredientType ingredientType;
    private final String ingredientName;

    public IngredientTypeParametrizedTest(IngredientType ingredientType, String ingredientName) {
        this.ingredientType = ingredientType;
        this.ingredientName = ingredientName;
    }

    @Parameterized.Parameters(name = "{index} : name = {0}")
    public static Object[][] getIngredientTypeData() {
        return new Object[][]{
                {IngredientType.SAUCE, "SAUCE"},
                {IngredientType.FILLING, "FILLING"}
        };
    }

    @Test
    public void checkIngredientTypeName() {
        assertEquals(ingredientName, ingredientType.name());
    }
}