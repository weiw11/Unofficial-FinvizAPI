package dev.weiwang.unofficialFinvizAPI.util;

import com.opencsv.CSVReader;
import com.opencsv.CSVWriter;
import dev.weiwang.unofficialFinvizAPI.Stock;
import dev.weiwang.unofficialFinvizAPI.Stocks;

import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class StocksUtilities {

    private static final String CONSOLE_CREATE_OUTPUT_MSG = "Unable to create required directories for output file.";
    private static final String[] CSV_HEADER = {
            "Ticker", "Companyname", "Sector", "Industry", "Geo", "Index", "Pe", "Eps", "Insiderown", "Shsoutstand",
            "Perfweek", "Marketcap", "Forwardpe", "Epsnexty", "Insidertrans", "Shsfloat", "Perfmonth", "Income", "Peg",
            "Epsnextq", "Instown", "Shortfloat", "Perfquarter", "Sales", "Ps", "Epsthisypercent", "Insttrans",
            "Shortratio", "Perfhalfy", "Booksh", "Pb", "Epsnextypercent", "Roa", "Targetprice", "Perfyear", "Cashsh",
            "Pc", "Epsnext5ypercent", "Roe", "52WRange", "Perfytd", "Dividend", "Pfcf", "Epspast5ypercent", "Roi",
            "52WHigh", "Beta", "Dividendpercent", "Quickratio", "Salespast5y", "Grossmargin", "52WLow", "Atr",
            "Employees", "Currentratio", "Salesqq", "Opermargin", "Rsi14", "Volatility", "Optionable", "Debteq",
            "Epsqq", "Profitmargin", "Relvolume", "Prevclose", "Shortable", "Ltdebteq", "Earnings", "Payout",
            "Avgvolume", "Price", "Recom", "Sma20", "Sma50", "Sma200", "Volume", "Change"};

    /**
     * Outputs Stocks to CSV file
     *
     * <br/>Ex:
     * {@code
     *     Export.outputToCSV(stocks, System.getProperty("user.home") + "/Desktop/output.csv");
     * }
     *
     * @param stocks Stocks to output
     * @param absoluteFilePath Absolute file path of CSV file
     */
    public static void outputToCSV(Stocks stocks, String absoluteFilePath) {
        File file = new File(absoluteFilePath);
        if (file.getParentFile().mkdirs()){
            try {
                FileWriter outputFile;
                CSVWriter writer;
                // If file exists already, we append the data
                if (file.exists()) {
                    outputFile = new FileWriter(file, true);
                    FileReader readFile = new FileReader(file);
                    CSVReader reader = new CSVReader(readFile);
                    writer = new CSVWriter(outputFile);
                    // If file exist but is empty, we add the header first
                    if (reader.readNext().length == 0) {
                        writer.writeNext(CSV_HEADER);
                    }
                    readFile.close();
                    reader.close();
                } else {
                    outputFile = new FileWriter(file);

                    writer = new CSVWriter(outputFile);
                    writer.writeNext(CSV_HEADER);
                }
                for (Stock stock : stocks.getStocks()) {
                    writer.writeNext(stock.getStringArr());
                }
                writer.close();
                outputFile.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        } else {
            System.out.println(CONSOLE_CREATE_OUTPUT_MSG);
        }
    }

    /**
     * Outputs Stock to CSV file
     *
     * <br/>Ex:
     * {@code
     *     Export.outputToCSV(stocks, System.getProperty("user.home") + "/Desktop/output.csv");
     * }
     *
     * @param stock Stock to output
     * @param absoluteFilePath Absolute file path of CSV file
     */
    public static void outputToCSV(Stock stock, String absoluteFilePath) {
        File file = new File(absoluteFilePath);
        if (file.getParentFile().mkdirs()){
            try {
                FileWriter outputFile;
                CSVWriter writer;
                // If file exists already, we append the data
                if (file.exists()) {
                    outputFile = new FileWriter(file, true);
                    FileReader readFile = new FileReader(file);
                    CSVReader reader = new CSVReader(readFile);
                    writer = new CSVWriter(outputFile);
                    // If file exist but is empty, we add the header first
                    if (reader.readNext().length == 0) {
                        writer.writeNext(CSV_HEADER);
                    }
                    readFile.close();
                    reader.close();
                } else {
                    outputFile = new FileWriter(file);
                    writer = new CSVWriter(outputFile);
                    writer.writeNext(CSV_HEADER);
                }
                writer.writeNext(stock.getStringArr());
                writer.close();
                outputFile.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        } else {
            System.out.println(CONSOLE_CREATE_OUTPUT_MSG);
        }
    }
}
