package dev.weiwang.unofficialFinvizAPI;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

public class Stocks {
    private List<Stock> stocksList;

    /**
     * Uses a text file with tickers on a new line
     * @param inputStocksFile text file with stocks
     * @throws IOException if unable to find ticker
     */
    public Stocks(String inputStocksFile) throws IOException {
        if (!inputStocksFile.contains(".")) {
            throw new IOException("For single stock tickers, use the Stock class. Single inputs for Stocks is reserved for file inputs.");
        }
        stocksList = new ArrayList<>();
        String[] input = new String(Files.readAllBytes(Paths.get(inputStocksFile))).split("\n");

        for (String s: input) {
            stocksList.add(new Stock(s));
        }
    }

    /**
     * Adds multiple stocks to list
     * <br>
     * {@code
     *      Stocks stocks = new Stocks("MSFT", "AAPL", "TSLA");
     * }
     * <br>
     * To use a text file instead with tickers separated on each line
     * <br>
     * {@code
     *      Stocks stocks = new Stocks(new File(System.getProperty("user.home") + "/Desktop/input.txt"));
     * }
     * @param tickers tickers of stocks
     * @throws IOException finviz cannot find ticker
     */
    public Stocks(String ... tickers) throws IOException {
        stocksList = new ArrayList<>();
        for (String ticker: tickers) {
            stocksList.add(new Stock(ticker));
        }
    }

    /**
     * @return stocks list
     */
    public List<Stock> getStocks() {
        return this.stocksList;
    }

    /**
     * Adds stock to Stocks list
     * @param stock stock to add
     * @return true if stock is added
     */
    public boolean addStock(Stock stock) {
        if (!stocksList.contains(stock)) {
            this.stocksList.add(stock);
            return true;
        }
        return false;
    }

    /**
     * Adds stock to Stocks list
     * @param stocks stock to add
     */
    public void addStocks(Stock ... stocks) {
        for (Stock stock : stocks) {
            if (!contains(stock)) {
                this.stocksList.add(stock);
            }
        }
    }

    /**
     * @param stock stock to check
     * @return true if stock list contains stock
     */
    public boolean contains(Stock stock) {
        return stocksList.contains(stock);
    }

    /**
     * @param ticker stock to retrieve from Stocks list
     * @return stock that matches param
     */
    public Stock getStock(String ticker) {
        for (Stock stock: stocksList) {
            if (stock.getTicker().equals(ticker)) {
                return stock;
            }
        }
        return null;
    }
}
