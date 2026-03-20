import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

import java.util.Arrays;
import java.util.List;

public class ShoppingCartAppTest {

    @Test
    void testCalculateItemTotal() {
        double result = ShoppingCartApp.calculateItemTotal(10.0, 2);
        assertEquals(20.0, result);
    }

    @Test
    void testCalculateItemTotalWithZero() {
        double result = ShoppingCartApp.calculateItemTotal(10.0, 0);
        assertEquals(0.0, result);
    }

    @Test
    void testCalculateCartTotal() {
        List<Double> items = Arrays.asList(10.0, 20.0, 30.0);
        double total = ShoppingCartApp.calculateCartTotal(items);
        assertEquals(60.0, total);
    }

    @Test
    void testCalculateCartTotalEmpty() {
        List<Double> items = List.of();
        double total = ShoppingCartApp.calculateCartTotal(items);
        assertEquals(0.0, total);
    }
}