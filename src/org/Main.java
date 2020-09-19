package org;

import org.unofficialFinvizAPI.Stock;

public class Main {

    public static void main(String[] args) {
        Stock stock = new Stock("MSFT");

        stock.getPrice(); // for price
        stock.getDividend(); // dividend yield

        stock.getStringArr(); // Returns all data as string array

        stock.toString(); // Outputs all data as string
    }
}