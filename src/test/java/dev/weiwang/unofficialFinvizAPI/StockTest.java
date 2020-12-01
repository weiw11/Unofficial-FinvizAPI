package dev.weiwang.unofficialFinvizAPI;

import org.junit.*;
import dev.weiwang.unofficialFinvizAPI.Stock;

import java.io.IOException;

public class StockTest {
    Stock stock;

    @BeforeClass
    public static void setUpClass() {
    }

    @AfterClass
    public static void tearDownClass() {
    }

    @Before
    public void setUp() throws IOException {
        stock = new Stock("AAPL");
    }

    @After
    public void tearDown() {
    }

    @Test
    public void testStock() {
        stock.getStringArr(); // Returns all data as string array. Useful for exporting
        System.out.println(
            "Stock Price: " + stock.getPrice() + "\n" + // Stock price
            "Stock Dividend: " + stock.getDividend() + "\n" + // Stock dividend yield
            "Stock String Output: " + stock.toString()); // Outputs all data as string
    }
}
