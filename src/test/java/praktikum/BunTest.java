package praktikum;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.junit.MockitoJUnitRunner;

import static org.junit.Assert.assertEquals;

@RunWith(MockitoJUnitRunner.class)
public class BunTest {
    private Bun bun;

    @Test
    public void getNameTest() {
        bun = new Bun("Special", 350.0f);
        String result = bun.getName();
        assertEquals("Special", result);
    }

    @Test
    public void getPriceTest() {
        bun = new Bun("Special", 350.0f);
        float result = bun.getPrice();
        assertEquals(350.0f, result, 0);
    }
}