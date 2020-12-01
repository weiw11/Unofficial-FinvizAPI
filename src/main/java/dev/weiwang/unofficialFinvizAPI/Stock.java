package dev.weiwang.unofficialFinvizAPI;

import com.opencsv.CSVReader;
import com.opencsv.CSVWriter;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.select.Elements;

import java.io.*;

public class Stock {

    //<editor-fold desc="Variables">
    private String symbol;
    private String companyName;
    private String sector;
    private String industry;
    private String geo;
    private String index;
    private String pe;
    private String eps;
    private String insiderOwn;
    private String shsOutstand;
    private String perfWeek;
    private String marketCap;
    private String forwardPE;
    private String epsNextY;
    private String insiderTrans;
    private String shsFloat;
    private String perfMonth;
    private String income;
    private String peg;
    private String epsNextQ;
    private String instOwn;
    private String shortFloat;
    private String perfQuarter;
    private String sales;
    private String ps;
    private String epsThisYPercent;
    private String instTrans;
    private String shortRatio;
    private String perfHalfY;
    private String bookSh;
    private String pb;
    private String epsNextYPercent;
    private String roa;
    private String targetPrice;
    private String perfYear;
    private String cashSh;
    private String pc;
    private String epsNext5YPercent;
    private String roe;
    private String w52Range;
    private String perfYTD;
    private String dividend;
    private String pfcf;
    private String epsPast5YPercent;
    private String roi;
    private String w52High;
    private String beta;
    private String dividendPercent;
    private String quickRatio;
    private String salesPast5Y;
    private String grossMargin;
    private String w52Low;
    private String atr;
    private String employees;
    private String currentRatio;
    private String salesQQ;
    private String operMargin;
    private String rsi14;
    private String volatility;
    private String optionable;
    private String debtEq;
    private String epsQQ;
    private String profitMargin;
    private String relVolume;
    private String prevClose;
    private String shortable;
    private String ltDebtEq;
    private String earnings;
    private String payout;
    private String avgVolume;
    private String price;
    private String recom;
    private String sma20;
    private String sma50;
    private String sma200;
    private String volume;
    private String change;
    private String companyInfo;
    //</editor-fold>

    /**
     * Retrieves stock symbol information from Finviz.
     * <br>
     * {@code
     * Stock stock = new Stock("MSFT");
     * }
     *
     * @param symbol Symbol of the company
     * @exception IOException When symbol cannot be found on Finviz
     */
    public Stock(String symbol) throws IOException {
        Document doc = getStockInfo(symbol);
        if (doc.getElementById("ticker") != null) {
            Elements elements = doc.select("a.tab-link");
            this.symbol = doc.getElementById("ticker").text();
            this.companyName = elements.get(12).text();
            this.sector = elements.get(13).text();
            this.industry = elements.get(14).text();
            this.geo = elements.get(15).text();
            elements = doc.getElementsByClass("snapshot-td2");
            this.index = elements.get(0).text();
            this.pe = elements.get(1).text();
            this.eps = elements.get(2).text();
            this.insiderOwn = elements.get(3).text();
            this.shsOutstand = elements.get(4).text();
            this.perfWeek = elements.get(5).text();
            this.marketCap = elements.get(6).text();
            this.forwardPE = elements.get(7).text();
            this.epsNextY = elements.get(8).text();
            this.insiderTrans = elements.get(9).text();
            this.shsFloat = elements.get(10).text();
            this.perfMonth = elements.get(11).text();
            this.income = elements.get(12).text();
            this.peg = elements.get(13).text();
            this.epsNextQ = elements.get(14).text();
            this.instOwn = elements.get(15).text();
            this.shortFloat = elements.get(16).text();
            this.perfQuarter = elements.get(17).text();
            this.sales = elements.get(18).text();
            this.ps = elements.get(19).text();
            this.epsThisYPercent = elements.get(20).text();
            this.instTrans = elements.get(21).text();
            this.shortRatio = elements.get(22).text();
            this.perfHalfY = elements.get(23).text();
            this.bookSh = elements.get(24).text();
            this.pb = elements.get(25).text();
            this.epsNextYPercent = elements.get(26).text();
            this.roa = elements.get(27).text();
            this.targetPrice = elements.get(28).text();
            this.perfYear = elements.get(29).text();
            this.cashSh = elements.get(30).text();
            this.pc = elements.get(31).text();
            this.epsNext5YPercent = elements.get(32).text();
            this.roe = elements.get(33).text();
            this.w52Range = elements.get(34).text();
            this.perfYTD = elements.get(35).text();
            this.dividend = elements.get(36).text();
            this.pfcf = elements.get(37).text();
            this.epsPast5YPercent = elements.get(38).text();
            this.roi = elements.get(39).text();
            this.w52High = elements.get(40).text();
            this.beta = elements.get(41).text();
            this.dividendPercent = elements.get(42).text();
            this.quickRatio = elements.get(43).text();
            this.salesPast5Y = elements.get(44).text();
            this.grossMargin = elements.get(45).text();
            this.w52Low = elements.get(46).text();
            this.atr = elements.get(47).text();
            this.employees = elements.get(48).text();
            this.currentRatio = elements.get(49).text();
            this.salesQQ = elements.get(50).text();
            this.operMargin = elements.get(51).text();
            this.rsi14 = elements.get(52).text();
            this.volatility = elements.get(53).text();
            this.optionable = elements.get(54).text();
            this.debtEq = elements.get(55).text();
            this.epsQQ = elements.get(56).text();
            this.profitMargin = elements.get(57).text();
            this.relVolume = elements.get(58).text();
            this.prevClose = elements.get(59).text();
            this.shortable = elements.get(60).text();
            this.ltDebtEq = elements.get(61).text();
            this.earnings = elements.get(62).text();
            this.payout = elements.get(63).text();
            this.avgVolume = elements.get(64).text();
            this.price = elements.get(65).text();
            this.recom = elements.get(66).text();
            this.sma20 = elements.get(67).text();
            this.sma50 = elements.get(68).text();
            this.sma200 = elements.get(69).text();
            this.volume = elements.get(70).text();
            this.change = elements.get(71).text();
            this.companyInfo = wrapText(doc.select("td.fullview-profile").get(0).text());
        } else {
            throw new Error("This symbol cannot be found");
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

    public String getIndex() {
        return index;
    }

    public String getPe() {
        return pe;
    }

    public String getEps() {
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

    public String getForwardPE() {
        return forwardPE;
    }

    public String getEpsNextY() {
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

    public String getPeg() {
        return peg;
    }

    public String getEpsNextQ() {
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

    public String getPs() {
        return ps;
    }

    public String getEpsThisYPercent() {
        return epsThisYPercent;
    }

    public String getInstTrans() {
        return instTrans;
    }

    public String getShortRatio() {
        return shortRatio;
    }

    public String getPerfHalfY() {
        return perfHalfY;
    }

    public String getBookSh() {
        return bookSh;
    }

    public String getPb() {
        return pb;
    }

    public String getEpsNextYPercent() {
        return epsNextYPercent;
    }

    public String getRoa() {
        return roa;
    }

    public String getTargetPrice() {
        return targetPrice;
    }

    public String getPerfYear() {
        return perfYear;
    }

    public String getCashSh() {
        return cashSh;
    }

    public String getPc() {
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

    public String getDividend() {
        return dividend;
    }

    public String getPfcf() {
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

    public String getBeta() {
        return beta;
    }

    public String getDividendPercent() {
        return dividendPercent;
    }

    public String getQuickRatio() {
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

    public String getAtr() {
        return atr;
    }

    public String getEmployees() {
        return employees;
    }

    public String getCurrentRatio() {
        return currentRatio;
    }

    public String getSalesQQ() {
        return salesQQ;
    }

    public String getOperMargin() {
        return operMargin;
    }

    public String getRsi14() {
        return rsi14;
    }

    public String getVolatility() {
        return volatility;
    }

    public String getOptionable() {
        return optionable;
    }

    public String getDebtEq() {
        return debtEq;
    }

    public String getEpsQQ() {
        return epsQQ;
    }

    public String getProfitMargin() {
        return profitMargin;
    }

    public String getRelVolume() {
        return relVolume;
    }

    public String getPrevClose() {
        return prevClose;
    }

    public String getShortable() {
        return shortable;
    }

    public String getLtDebtEq() {
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

    public String getPrice() {
        return price;
    }

    public String getRecom() {
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

    private Document getStockInfo(String symbol) throws IOException {
        return Jsoup.connect("https://finviz.com/quote.ashx?t=" + symbol).get();
    }

    /**
     * @return All stock variables
     */
    public String[] getStringArr() {
        return new String[] {
            this.symbol, this.companyName, this.sector, this.industry, this.geo, this.index, this.pe, this.eps,
            this.insiderOwn, this.shsOutstand, this.perfWeek, this.marketCap, this.forwardPE, this.epsNextY,
            this.insiderTrans, this.shsFloat, this.perfMonth, this.income, this.peg, this.epsNextQ, this.instOwn,
            this.shortFloat, this.perfQuarter, this.sales, this.ps, this.epsThisYPercent, this.instTrans,
            this.shortRatio, this.perfHalfY, this.bookSh, this.pb, this.epsNextYPercent, this.roa, this.targetPrice,
            this.perfYear, this.cashSh, this.pc, this.epsNext5YPercent, this.roe, this.w52Range, this.perfYTD,
            this.dividend, this.pfcf, this.epsPast5YPercent, this.roi, this.w52High, this.beta, this.dividendPercent,
            this.quickRatio, this.salesPast5Y, this.grossMargin, this.w52Low, this.atr, this.employees,
            this.currentRatio, this.salesQQ, this.operMargin, this.rsi14, this.volatility, this.optionable, this.debtEq,
            this.epsQQ, this.profitMargin, this.relVolume, this.prevClose, this.shortable, this.ltDebtEq, this.earnings,
            this.payout, this.avgVolume, this.price, this.recom, this.sma20, this.sma50, this.sma200, this.volume,
            this.change};
    }


    /**
     *  Saves stock information to CSV file
     *
     *  @param filePath Absolute file path of CSV file
     */
    public void exportStockAsCSV(String filePath) {
        File file = new File(filePath);
        String[] header = new String[] {
            "Symbol", "Companyname", "Sector", "Industry", "Geo", "Index", "Pe", "Eps", "Insiderown", "Shsoutstand",
            "Perfweek", "Marketcap", "Forwardpe", "Epsnexty", "Insidertrans", "Shsfloat", "Perfmonth", "Income", "Peg",
            "Epsnextq", "Instown", "Shortfloat", "Perfquarter", "Sales", "Ps", "Epsthisypercent", "Insttrans",
            "Shortratio", "Perfhalfy", "Booksh", "Pb", "Epsnextypercent", "Roa", "Targetprice", "Perfyear", "Cashsh",
            "Pc", "Epsnext5ypercent", "Roe", "52WRange", "Perfytd", "Dividend", "Pfcf", "Epspast5ypercent", "Roi",
            "52WHigh", "Beta", "Dividendpercent", "Quickratio", "Salespast5y", "Grossmargin", "52WLow", "Atr",
            "Employees", "Currentratio", "Salesqq", "Opermargin", "Rsi14", "Volatility", "Optionable", "Debteq",
            "Epsqq", "Profitmargin", "Relvolume", "Prevclose", "Shortable", "Ltdebteq", "Earnings", "Payout",
            "Avgvolume", "Price", "Recom", "Sma20", "Sma50", "Sma200", "Volume", "Change"
        };
        try {
            FileWriter outputFile;
            CSVWriter writer;
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
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     *  @return All stock variables
     */
    @Override
    public String toString() {
        return "\nSymbol: " + symbol +
                "\nCompany Name: " + companyName +
                "\nSector: " + sector +
                "\nIndustry: " + industry +
                "\nGeo: " + geo +
                "\nIndex: " + index +
                "\nP/E: " + pe +
                "\nEPS: " + eps +
                "\nInsider Ownership: " + insiderOwn +
                "\nShares Outstanding: " + shsOutstand +
                "\nPerf Week: " + perfWeek +
                "\nMarket Cap: " + marketCap +
                "\nForward P/E: " + forwardPE +
                "\nEPS Next Y: " + epsNextY +
                "\nInsider Trans: " + insiderTrans +
                "\nShares Float: " + shsFloat +
                "\nPerf Month: " + perfMonth +
                "\nIncome: " + income +
                "\nPEG: " + peg +
                "\nEPS Next Quarter: " + epsNextQ +
                "\nInstitutional Ownership: " + instOwn +
                "\nShort Float: " + shortFloat +
                "\nPerf Quarter: " + perfQuarter +
                "\nSales: " + sales +
                "\nPS: " + ps +
                "\nEPS This Year %: " + epsThisYPercent +
                "\nInstitutional Trans: " + instTrans +
                "\nShort Ratio: " + shortRatio +
                "\nPerf Half Y: " + perfHalfY +
                "\nBook/Share: " + bookSh +
                "\nP/B: " + pb +
                "\nEPS Next Y %: " + epsNextYPercent +
                "\nROA: " + roa +
                "\nTarget Price: " + targetPrice +
                "\nPerf Year: " + perfYear +
                "\nCash/Share: " + cashSh +
                "\nP/C: " + pc +
                "\nEPS Next 5 Year %: " + epsNext5YPercent +
                "\nROE: " + roe +
                "\n52 Week Range: " + w52Range +
                "\nPerf YTD: " + perfYTD +
                "\nDividend: " + dividend +
                "\nP/FCF: " + pfcf +
                "\nEPS Past 5 Y %: " + epsPast5YPercent +
                "\nROI: " + roi +
                "\n52 Week High: " + w52High +
                "\nBeta: " + beta +
                "\nDividend %: " + dividendPercent +
                "\nQuick Ratio: " + quickRatio +
                "\nSales Past 5 Y: " + salesPast5Y +
                "\nGross Margin: " + grossMargin +
                "\n52 Week Low: " + w52Low +
                "\nATR (14): " + atr +
                "\nEmployees: " + employees +
                "\nCurrent Ratio: " + currentRatio +
                "\nSales Q/Q: " + salesQQ +
                "\nOperating Margin: " + operMargin +
                "\nRSI (14): " + rsi14 +
                "\nVolatility: " + volatility +
                "\nOptionable: " + optionable +
                "\nDebt/Eq: " + debtEq +
                "\nEPS Q/Q: " + epsQQ +
                "\nProfit Margin: " + profitMargin +
                "\nRel Volume: " + relVolume +
                "\nPrevious Close: " + prevClose +
                "\nShortable: " + shortable +
                "\nLT Debt/Eq: " + ltDebtEq +
                "\nEarnings: " + earnings +
                "\nPayout: " + payout +
                "\nAvg Volume: " + avgVolume +
                "\nPrice: " + price +
                "\nRecome: " + recom +
                "\nSMA20: " + sma20 +
                "\nSMA50: " + sma50 +
                "\nSMA200: " + sma200 +
                "\nVolume: " + volume +
                "\nChange: " + change +
                "\n\nCompany Info: \n" + companyInfo;
    }
}
