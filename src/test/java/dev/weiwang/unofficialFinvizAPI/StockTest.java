package dev.weiwang.unofficialFinvizAPI;

import dev.weiwang.unofficialFinvizAPI.util.StocksUtilities;
import org.junit.*;

import java.io.IOException;

public class StockTest {
    private Stock stock;
    private String outputFileCSV = "target/test-classes/test-results/output.csv";

    @BeforeClass
    public static void setUpClass() {
    }

    @AfterClass
    public static void tearDownClass() {
    }

    @Before
    public void setUp() throws IOException {
        stock = new Stock("MSFT");
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
            "\nStock String Output: " + stock.toString()); // Outputs all data as string
    }

    @Test
    public void outputTest() {
        StocksUtilities.outputToCSV(stock, outputFileCSV);
    }
}
