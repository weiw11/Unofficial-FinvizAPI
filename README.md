# FinvizAPI
This API uses gsoup to pull stock data from Finviz

### Usage
You can pull all of the data from the table using the methods from the Stock class.

Example:

```
// Using MSFT data: https://finviz.com/quote.ashx?t=msft
Stock stock = new Stock("MSFT");

stock.getPrice(); // for price
stock.getDividend(); // dividend yield

stock.getStringArr(); // Returns all data as string array. Usefull for exporting

stock.toString(); // Outputs all data as string
```


```
// Output of stock.toString():
Symbol: MSFT
Company Name: Microsoft Corporation
Sector: Technology
Industry: Software - Infrastructure
Geo: USA
Index: DJIA S&P500
P/E: 34.92
EPS: 5.77
Insider Ownership: 0.10%
Shares Outstanding: 7.60B
Perf Week: -0.78%
Market Cap: 1535.95B
Forward P/E: 27.44
EPS Next Y: 7.34
Insider Trans: -4.28%
Shares Float: 7.49B
Perf Month: 1.75%
Income: 44.28B
PEG: 2.33
EPS Next Quarter: 1.53
Institutional Ownership: 73.30%
Short Float: 0.53%
Perf Quarter: 15.33%
Sales: 143.02B
PS: 10.74
EPS This Year %: 22.20%
Institutional Trans: -0.05%
Short Ratio: 1.12
Perf Half Y: 21.97%
Book/Share: 15.06
P/B: 13.37
EPS Next Y %: 13.97%
ROA: 15.60%
Target Price: 227.65
Perf Year: 43.59%
Cash/Share: 18.04
P/C: 11.16
EPS Next 5 Year %: 15.00%
ROE: 40.90%
52 Week Range: 130.78 - 216.38
Perf YTD: 27.65%
Dividend: 2.04
P/FCF: 58.77
EPS Past 5 Y %: 12.50%
ROI: 19.90%
52 Week High: -6.97%
Beta: 0.91
Dividend %: 1.01%
Quick Ratio: 2.9
Sales Past 5 Y: 7.70%
Gross Margin: 67.80%
52 Week Low: 53.92%
ATR (14): 5.66
Employees: 144000
Current Ratio: 2.9
Sales Q/Q: 14.60%
Operating Margin: 34.50%
RSI (14): 48.18
Volatility: 3.27% 2.68%
Optionable: Yes
Debt/Eq: 0.66
EPS Q/Q: 23.20%
Profit Margin: 31.00%
Rel Volume: 1.11
Previous Close: 202.54
Shortable: Yes
LT Debt/Eq: 0.62
Earnings: Jul 22 AMC
Payout: 32.60%
Avg Volume: 35.59M
Price: 201.3
Recome: 1.7
SMA20: -2.62%
SMA50: 3.04%
SMA200: 19.51%
Volume: 39,630,722
Change: -0.61%

Company Info: 
Microsoft Corporation develops, licenses, and supports software, services, devices, and solutions
worldwide. Its Productivity and Business Processes segment offers Office, Exchange, SharePoint,
Microsoft Teams, Office 365 Security and Compliance, and Skype for Business, as well as related
Client Access Licenses (CAL); Skype, Outlook.com, and OneDrive; LinkedIn that includes Talent and
marketing solutions, and subscriptions; and Dynamics 365, a set of cloud-based and on-premises
business solutions for small and medium businesses, large organizations, and divisions of
enterprises. Its Intelligent Cloud segment licenses SQL and Windows Servers, Visual Studio, System
Center, and related CALs; GitHub that provides a collaboration platform and code hosting service
for developers; and Azure, a cloud platform. It also provides support services and Microsoft
consulting services to assist customers in developing, deploying, and managing Microsoft server and
desktop solutions; and training and certification to developers and IT professionals on various
Microsoft products. Its More Personal Computing segment offers Windows OEM licensing and other
non-volume licensing of the Windows operating system; Windows Commercial, such as volume licensing
of the Windows operating system, Windows cloud services, and other Windows commercial offerings;
patent licensing; Windows Internet of Things; and MSN advertising. It also provides Microsoft
Surface, PC accessories, and other devices; Gaming, including Xbox hardware, and Xbox software and
services; video games and third-party video game royalties; and Search, including Bing and
Microsoft advertising. It sells its products through distributors and resellers; and directly
through digital marketplaces, online stores, and retail stores. It has strategic partnerships with
Humana Inc., Nokia, Telkomsel, Swiss Re, Kubota Corporation, FedEx Corp., and Hitachi. The company
was founded in 1975 and is headquartered in Redmond, Washington.

```