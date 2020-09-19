package org.unofficialFinvizAPI;

import com.opencsv.CSVReader;
import com.opencsv.CSVWriter;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.select.Elements;

import java.io.*;

public class Stock {

    //<editor-fold desc="Variables">
    public String symbol;
    private String companyName;
    private String sector;
    private String industry;
    private String geo;
    private String statement;
    private String index;
    private double pe;
    private double eps;
    private String insiderOwn;
    private String shsOutstand;
    private String perfWeek;
    private String marketCap;
    private double forwardPE;
    private double epsNextY;
    private String insiderTrans;
    private String shsFloat;
    private String perfMonth;
    private String income;
    private double peg;
    private double epsNextQ;
    private String instOwn;
    private String shortFloat;
    private String perfQuarter;
    private String sales;
    private double ps;
    private String epsThisYPercent;
    private String instTrans;
    private double shortRatio;
    private String perfHalfY;
    private double bookSh;
    private double pb;
    private String epsNextYPercent;
    private String roa;
    private double targetPrice;
    private String perfYear;
    private double cashSh;
    private double pc;
    private String epsNext5YPercent;
    private String roe;
    private String w52Range;
    private String perfYTD;
    private double dividend;
    private double pfcf;
    private String epsPast5YPercent;
    private String roi;
    private String w52High;
    private double beta;
    private String dividendPercent;
    private double quickRatio;
    private String salesPast5Y;
    private String grossMargin;
    private String w52Low;
    private double atr;
    private int employees;
    private double currentRatio;
    private String salesQQ;
    private String operMargin;
    private double rsi14;
    private String volatility;
    private String optionable;
    private double debtEq;
    private String epsQQ;
    private String profitMargin;
    private double relVolume;
    private double prevClose;
    private String shortable;
    private double ltDebtEq;
    private String earnings;
    private String payout;
    private String avgVolume;
    private double price;
    private double recom;
    private String sma20;
    private String sma50;
    private String sma200;
    private String volume;
    private String change;
    private String companyInfo;
    //</editor-fold>

    /**
     Retrieves stock symbol information from Finviz.

     @param symbol  Symbol of the company
     */
    public Stock(String symbol) {
        Document doc = getStockInfo(symbol);
        if (doc.getElementById("ticker") != null) {
            Elements elements = doc.select("a.tab-link");
            this.symbol = doc.getElementById("ticker").text();
            this.companyName = elements.get(12).text();
            this.sector = elements.get(13).text();
            this.industry = elements.get(14).text();
            this.geo = elements.get(15).text();
            this.statement = elements.get(16).attr("href");
            elements = doc.getElementsByClass("snapshot-td2");
            this.index = elements.get(0).text();
            this.pe = Double.parseDouble(elements.get(1).text());
            this.eps = Double.parseDouble(elements.get(2).text());
            this.insiderOwn = elements.get(3).text();
            this.shsOutstand = elements.get(4).text();
            this.perfWeek = elements.get(5).text();
            this.marketCap = elements.get(6).text();
            this.forwardPE = Double.parseDouble(elements.get(7).text());
            this.epsNextY = Double.parseDouble(elements.get(8).text());
            this.insiderTrans = elements.get(9).text();
            this.shsFloat = elements.get(10).text();
            this.perfMonth = elements.get(11).text();
            this.income = elements.get(12).text();
            this.peg = Double.parseDouble(elements.get(13).text());
            this.epsNextQ = Double.parseDouble(elements.get(14).text());
            this.instOwn = elements.get(15).text();
            this.shortFloat = elements.get(16).text();
            this.perfQuarter = elements.get(17).text();
            this.sales = elements.get(18).text();
            this.ps = Double.parseDouble(elements.get(19).text());
            this.epsThisYPercent = elements.get(20).text();
            this.instTrans = elements.get(21).text();
            this.shortRatio = Double.parseDouble(elements.get(22).text());
            this.perfHalfY = elements.get(23).text();
            this.bookSh = Double.parseDouble(elements.get(24).text());
            this.pb = Double.parseDouble(elements.get(25).text());
            this.epsNextYPercent = elements.get(26).text();
            this.roa = elements.get(27).text();
            this.targetPrice = Double.parseDouble(elements.get(28).text());
            this.perfYear = elements.get(29).text();
            this.cashSh = Double.parseDouble(elements.get(30).text());
            this.pc = Double.parseDouble(elements.get(31).text());
            this.epsNext5YPercent = elements.get(32).text();
            this.roe = elements.get(33).text();
            this.w52Range = elements.get(34).text();
            this.perfYTD = elements.get(35).text();
            this.dividend = Double.parseDouble(elements.get(36).text());
            this.pfcf = Double.parseDouble(elements.get(37).text());
            this.epsPast5YPercent = elements.get(38).text();
            this.roi = elements.get(39).text();
            this.w52High = elements.get(40).text();
            this.beta = Double.parseDouble(elements.get(41).text());
            this.dividendPercent = elements.get(42).text();
            this.quickRatio = Double.parseDouble(elements.get(43).text());
            this.salesPast5Y = elements.get(44).text();
            this.grossMargin = elements.get(45).text();
            this.w52Low = elements.get(46).text();
            this.atr = Double.parseDouble(elements.get(47).text());
            this.employees = Integer.parseInt(elements.get(48).text());
            this.currentRatio = Double.parseDouble(elements.get(49).text());
            this.salesQQ = elements.get(50).text();
            this.operMargin = elements.get(51).text();
            this.rsi14 = Double.parseDouble(elements.get(52).text());
            this.volatility = elements.get(53).text();
            this.optionable = elements.get(54).text();
            this.debtEq = Double.parseDouble(elements.get(55).text());
            this.epsQQ = elements.get(56).text();
            this.profitMargin = elements.get(57).text();
            this.relVolume = Double.parseDouble(elements.get(58).text());
            this.prevClose = Double.parseDouble(elements.get(59).text());
            this.shortable = elements.get(60).text();
            this.ltDebtEq = Double.parseDouble(elements.get(61).text());
            this.earnings = elements.get(62).text();
            this.payout = elements.get(63).text();
            this.avgVolume = elements.get(64).text();
            this.price = Double.parseDouble(elements.get(65).text());
            this.recom = Double.parseDouble(elements.get(66).text());
            this.sma20 = elements.get(67).text();
            this.sma50 = elements.get(68).text();
            this.sma200 = elements.get(69).text();
            this.volume = elements.get(70).text();
            this.change = elements.get(71).text();
            this.companyInfo = wrapText(doc.select("td.fullview-profile").get(0).text());
        } else {
            throw new IllegalArgumentException("This symbol cannot be found");
        }
    }

    //<editor-fold desc="Getters">
    public String getSymbol() {
        return symbol;
    }

    public String getCompanyName() {
        return companyName;
    }

    public String getSector() {
        return sector;
    }

    public String getIndustry() {
        return industry;
    }

    public String getGeo() {
        return geo;
    }

    public String getStatement() {
        return statement;
    }

    public String getIndex() {
        return index;
    }

    public double getPe() {
        return pe;
    }

    public double getEps() {
        return eps;
    }

    public String getInsiderOwn() {
        return insiderOwn;
    }

    public String getShsOutstand() {
        return shsOutstand;
    }

    public String getPerfWeek() {
        return perfWeek;
    }

    public String getMarketCap() {
        return marketCap;
    }

    public double getForwardPE() {
        return forwardPE;
    }

    public double getEpsNextY() {
        return epsNextY;
    }

    public String getInsiderTrans() {
        return insiderTrans;
    }

    public String getShsFloat() {
        return shsFloat;
    }

    public String getPerfMonth() {
        return perfMonth;
    }

    public String getIncome() {
        return income;
    }

    public double getPeg() {
        return peg;
    }

    public double getEpsNextQ() {
        return epsNextQ;
    }

    public String getInstOwn() {
        return instOwn;
    }

    public String getShortFloat() {
        return shortFloat;
    }

    public String getPerfQuarter() {
        return perfQuarter;
    }

    public String getSales() {
        return sales;
    }

    public double getPs() {
        return ps;
    }

    public String getEpsThisYPercent() {
        return epsThisYPercent;
    }

    public String getInstTrans() {
        return instTrans;
    }

    public double getShortRatio() {
        return shortRatio;
    }

    public String getPerfHalfY() {
        return perfHalfY;
    }

    public double getBookSh() {
        return bookSh;
    }

    public double getPb() {
        return pb;
    }

    public String getEpsNextYPercent() {
        return epsNextYPercent;
    }

    public String getRoa() {
        return roa;
    }

    public double getTargetPrice() {
        return targetPrice;
    }

    public String getPerfYear() {
        return perfYear;
    }

    public double getCashSh() {
        return cashSh;
    }

    public double getPc() {
        return pc;
    }

    public String getEpsNext5YPercent() {
        return epsNext5YPercent;
    }

    public String getRoe() {
        return roe;
    }

    public String getW52Range() {
        return w52Range;
    }

    public String getPerfYTD() {
        return perfYTD;
    }

    public double getDividend() {
        return dividend;
    }

    public double getPfcf() {
        return pfcf;
    }

    public String getEpsPast5YPercent() {
        return epsPast5YPercent;
    }

    public String getRoi() {
        return roi;
    }

    public String getW52High() {
        return w52High;
    }

    public double getBeta() {
        return beta;
    }

    public String getDividendPercent() {
        return dividendPercent;
    }

    public double getQuickRatio() {
        return quickRatio;
    }

    public String getSalesPast5Y() {
        return salesPast5Y;
    }

    public String getGrossMargin() {
        return grossMargin;
    }

    public String getW52Low() {
        return w52Low;
    }

    public double getAtr() {
        return atr;
    }

    public int getEmployees() {
        return employees;
    }

    public double getCurrentRatio() {
        return currentRatio;
    }

    public String getSalesQQ() {
        return salesQQ;
    }

    public String getOperMargin() {
        return operMargin;
    }

    public double getRsi14() {
        return rsi14;
    }

    public String getVolatility() {
        return volatility;
    }

    public String getOptionable() {
        return optionable;
    }

    public double getDebtEq() {
        return debtEq;
    }

    public String getEpsQQ() {
        return epsQQ;
    }

    public String getProfitMargin() {
        return profitMargin;
    }

    public double getRelVolume() {
        return relVolume;
    }

    public double getPrevClose() {
        return prevClose;
    }

    public String getShortable() {
        return shortable;
    }

    public double getLtDebtEq() {
        return ltDebtEq;
    }

    public String getEarnings() {
        return earnings;
    }

    public String getPayout() {
        return payout;
    }

    public String getAvgVolume() {
        return avgVolume;
    }

    public double getPrice() {
        return price;
    }

    public double getRecom() {
        return recom;
    }

    public String getSma20() {
        return sma20;
    }

    public String getSma50() {
        return sma50;
    }

    public String getSma200() {
        return sma200;
    }

    public String getVolume() {
        return volume;
    }

    public String getChange() {
        return change;
    }

    public String getCompanyInfo() {
        return companyInfo;
    }
    //</editor-fold>

    private String wrapText(String input) {
        StringBuilder sb = new StringBuilder(input);
        int i = 0;
        while (i + 100 < sb.length() && (i = sb.lastIndexOf(" ", i + 100)) != -1) {
            sb.replace(i, i + 1, "\n");
        }
        return sb.toString();
    }

    private Document getStockInfo(String symbol) {
        try {
            return Jsoup.connect("https://finviz.com/quote.ashx?t=" + symbol).get();
        } catch (IOException e) {
            e.printStackTrace();
            return null;
        }
    }

    public String[] getStringArr() {
        return new String[] {this.symbol, this.companyName, this.sector, this.industry, this.geo, this.statement, this.index, String.valueOf(this.pe), String.valueOf(this.eps), this.insiderOwn, this.shsOutstand, this.perfWeek, this.marketCap, String.valueOf(this.forwardPE), String.valueOf(this.epsNextY), this.insiderTrans, this.shsFloat, this.perfMonth, this.income, String.valueOf(this.peg), String.valueOf(this.epsNextQ), this.instOwn, this.shortFloat, this.perfQuarter, this.sales, String.valueOf(this.ps), this.epsThisYPercent, this.instTrans, String.valueOf(this.shortRatio), this.perfHalfY, String.valueOf(this.bookSh), String.valueOf(this.pb), this.epsNextYPercent, this.roa, String.valueOf(this.targetPrice), this.perfYear, String.valueOf(this.cashSh), String.valueOf(this.pc), this.epsNext5YPercent, this.roe, this.w52Range, this.perfYTD, String.valueOf(this.dividend), String.valueOf(this.pfcf), this.epsPast5YPercent, this.roi, this.w52High, String.valueOf(this.beta), this.dividendPercent, String.valueOf(this.quickRatio), this.salesPast5Y, this.grossMargin, this.w52Low, String.valueOf(this.atr), String.valueOf(this.employees), String.valueOf(this.currentRatio), this.salesQQ, this.operMargin, String.valueOf(this.rsi14), this.volatility, this.optionable, String.valueOf(this.debtEq), String.valueOf(this.epsQQ), this.profitMargin, String.valueOf(this.relVolume), String.valueOf(this.prevClose), this.shortable, String.valueOf(this.ltDebtEq), this.earnings, this.payout, this.avgVolume, String.valueOf(this.price), String.valueOf(this.recom), this.sma20, this.sma50, this.sma200, this.volume, this.change};
    }

    /**
     Saves stock information to CSV file

     @param filePath Absolute file path of CSV file
     */
    public void exportStockAsCSV(String filePath) {
        File file = new File(filePath);
        String[] header = new String[] {"Symbol", "Companyname", "Sector", "Industry", "Geo", "Statement", "Index", "Pe", "Eps", "Insiderown", "Shsoutstand", "Perfweek", "Marketcap", "Forwardpe", "Epsnexty", "Insidertrans", "Shsfloat", "Perfmonth", "Income", "Peg", "Epsnextq", "Instown", "Shortfloat", "Perfquarter", "Sales", "Ps", "Epsthisypercent", "Insttrans", "Shortratio", "Perfhalfy", "Booksh", "Pb", "Epsnextypercent", "Roa", "Targetprice", "Perfyear", "Cashsh", "Pc", "Epsnext5ypercent", "Roe", "52WRange", "Perfytd", "Dividend", "Pfcf", "Epspast5ypercent", "Roi", "52WHigh", "Beta", "Dividendpercent", "Quickratio", "Salespast5y", "Grossmargin", "52WLow", "Atr", "Employees", "Currentratio", "Salesqq", "Opermargin", "Rsi14", "Volatility", "Optionable", "Debteq", "Epsqq", "Profitmargin", "Relvolume", "Prevclose", "Shortable", "Ltdebteq", "Earnings", "Payout", "Avgvolume", "Price", "Recom", "Sma20", "Sma50", "Sma200", "Volume", "Change"};
        try {
            FileWriter outputFile = null;
            CSVWriter writer = null;
            if (file.exists()) {
                outputFile = new FileWriter(file, true);
                writer = new CSVWriter(outputFile);
                FileReader readFile = new FileReader(file);
                CSVReader reader = new CSVReader(readFile);
                if (reader.readNext().length == 0) {
                    writer.writeNext(header);
                }
                writer.writeNext(getStringArr());
                readFile.close();
                reader.close();
            } else {
                outputFile = new FileWriter(file);
                writer = new CSVWriter(outputFile);
                writer.writeNext(header);
                writer.writeNext(getStringArr());
            }
            writer.close();
            outputFile.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     Returns stock's information as string.

     @return String
     */
    @Override
    public String toString() {
        return "Symbol: " + symbol + "\nCompany Name: " + companyName + "\nSector: " + sector + "\nIndustry: " + industry + "\nGeo: " + geo + "\nIndex: " + index + "\nP/E: " + pe + "\nEPS: " + eps + "\nInsider Ownership: " + insiderOwn + "\nShares Outstanding: " + shsOutstand + "\nPerf Week: " + perfWeek + "\nMarket Cap: " + marketCap + "\nForward P/E: " + forwardPE + "\nEPS Next Y: " + epsNextY + "\nInsider Trans: " + insiderTrans + "\nShares Float: " + shsFloat + "\nPerf Month: " + perfMonth + "\nIncome: " + income + "\nPEG: " + peg + "\nEPS Next Quarter: " + epsNextQ + "\nInstitutional Ownership: " + instOwn + "\nShort Float: " + shortFloat + "\nPerf Quarter: " + perfQuarter + "\nSales: " + sales + "\nPS: " + ps + "\nEPS This Year %: " + epsThisYPercent + "\nInstitutional Trans: " + instTrans + "\nShort Ratio: " + shortRatio + "\nPerf Half Y: " + perfHalfY + "\nBook/Share: " + bookSh + "\nP/B: " + pb + "\nEPS Next Y %: " + epsNextYPercent + "\nROA: " + roa + "\nTarget Price: " + targetPrice + "\nPerf Year: " + perfYear + "\nCash/Share: " + cashSh + "\nP/C: " + pc + "\nEPS Next 5 Year %: " + epsNext5YPercent + "\nROE: " + roe + "\n52 Week Range: " + w52Range + "\nPerf YTD: " + perfYTD + "\nDividend: " + dividend + "\nP/FCF: " + pfcf + "\nEPS Past 5 Y %: " + epsPast5YPercent + "\nROI: " + roi + "\n52 Week High: " + w52High + "\nBeta: " + beta + "\nDividend %: " + dividendPercent + "\nQuick Ratio: " + quickRatio + "\nSales Past 5 Y: " + salesPast5Y + "\nGross Margin: " + grossMargin + "\n52 Week Low: " + w52Low + "\nATR (14): " + atr + "\nEmployees: " + employees + "\nCurrent Ratio: " + currentRatio + "\nSales Q/Q: " + salesQQ + "\nOperating Margin: " + operMargin + "\nRSI (14): " + rsi14 + "\nVolatility: " + volatility + "\nOptionable: " + optionable + "\nDebt/Eq: " + debtEq + "\nEPS Q/Q: " + epsQQ + "\nProfit Margin: " + profitMargin + "\nRel Volume: " + relVolume + "\nPrevious Close: " + prevClose + "\nShortable: " + shortable + "\nLT Debt/Eq: " + ltDebtEq + "\nEarnings: " + earnings + "\nPayout: " + payout + "\nAvg Volume: " + avgVolume + "\nPrice: " + price + "\nRecome: " + recom + "\nSMA20: " + sma20 + "\nSMA50: " + sma50 + "\nSMA200: " + sma200 + "\nVolume: " + volume + "\nChange: " + change + "\n\nCompany Info: \n" + companyInfo;
    }
}
