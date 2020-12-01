package dev.weiwang.unofficialFinvizAPI;

import dev.weiwang.unofficialFinvizAPI.util.StocksUtilities;
import org.junit.*;

import java.io.IOException;
import java.util.List;

public class StocksTest {
    private Stocks stocks;
    private String inputFileTxt = "src/test/resources/input.txt";
    private String outputFileCSV = "target/test-classes/test-results/output.csv";
    private String desktop = System.getProperty("user.home") + "/Desktop";

    @BeforeClass
    public static void setUpClass() {
    }

    @AfterClass
    public static void tearDownClass() {
    }

    @Before
    public void setUp() throws IOException {
        stocks = new Stocks("AAPL", "MSFT", "TSLA");
    }

    @After
    public void tearDown() {
    }

    @Test
    public void testStocks() throws IOException {
        stocks.addStock(new Stock("WMT"));
        stocks.addStocks(new Stock("WORK"), new Stock("SPY"));
        List<Stock> stocksList = stocks.getStocks();
        stocksList.forEach(stock -> System.out.println(stock.getCompanyName()));
    }

    @Test
    public void testStocksWithFile() throws IOException {
        stocks = new Stocks(inputFileTxt);
        StocksUtilities.outputToCSV(stocks, outputFileCSV);
    }

    @Test
    public void outputTest() {
        StocksUtilities.outputToCSV(stocks, outputFileCSV);
    }
}
