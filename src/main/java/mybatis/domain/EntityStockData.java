package mybatis.domain;

public class EntityStockData {

    /*
    private Integer ID;
    private String stockCode; 股票代码
    private String valueDate;   股票日期
    private String openingPrice;    开盘价
    private String topPrice;    最高价
    private String closingPrice;    收盘价
    private String dailyGrowthRate;  收盘价日增长率
    private String lowestPrice; 最低价
    private String turnoverValue;   成交量
    private String moneyValue;  成交金额
     */

    private Integer ID;
    private String stockCode;
    private String valueDate;
    private String openingPrice;
    private String topPrice;
    private String closingPrice;
    private String dailyGrowthRate;
    private String lowestPrice;
    private String turnoverValue;
    private String moneyValue;

    public EntityStockData() {

    }

    public EntityStockData(String stockCode, String valueDate, String openingPrice, String topPrice, String closingPrice, String dailyGrowthRate, String lowestPrice, String turnoverValue, String moneyValue) {
        this.stockCode = stockCode;
        this.valueDate = valueDate;
        this.openingPrice = openingPrice;
        this.topPrice = topPrice;
        this.closingPrice = closingPrice;
        this.dailyGrowthRate = dailyGrowthRate;
        this.lowestPrice = lowestPrice;
        this.turnoverValue = turnoverValue;
        this.moneyValue = moneyValue;
    }

    public Integer getID() {
        return ID;
    }

    public void setID(Integer ID) {
        this.ID = ID;
    }

    public String getStockCode() {
        return stockCode;
    }

    public void setStockCode(String stockCode) {
        this.stockCode = stockCode;
    }

    public String getValueDate() {
        return valueDate;
    }

    public void setValueDate(String valueDate) {
        this.valueDate = valueDate;
    }

    public String getOpeningPrice() {
        return openingPrice;
    }

    public void setOpeningPrice(String openingPrice) {
        this.openingPrice = openingPrice;
    }

    public String getTopPrice() {
        return topPrice;
    }

    public void setTopPrice(String topPrice) {
        this.topPrice = topPrice;
    }

    public String getClosingPrice() {
        return closingPrice;
    }

    public void setClosingPrice(String closingPrice) {
        this.closingPrice = closingPrice;
    }

    public String getDailyGrowthRate() {
        return dailyGrowthRate;
    }

    public void setDailyGrowthRate(String dailyGrowthRate) {
        this.dailyGrowthRate = dailyGrowthRate;
    }

    public String getLowestPrice() {
        return lowestPrice;
    }

    public void setLowestPrice(String lowestPrice) {
        this.lowestPrice = lowestPrice;
    }

    public String getTurnoverValue() {
        return turnoverValue;
    }

    public void setTurnoverValue(String turnoverValue) {
        this.turnoverValue = turnoverValue;
    }

    public String getMoneyValue() {
        return moneyValue;
    }

    public void setMoneyValue(String moneyValue) {
        this.moneyValue = moneyValue;
    }

    @Override
    public String toString() {
        return "EntityStockData{" +
                "stockCode='" + stockCode + '\'' +
                ", valueDate='" + valueDate + '\'' +
                ", openingPrice='" + openingPrice + '\'' +
                ", topPrice='" + topPrice + '\'' +
                ", closingPrice='" + closingPrice + '\'' +
                ", dailyGrowthRate='" + dailyGrowthRate + '\'' +
                ", lowestPrice='" + lowestPrice + '\'' +
                ", turnoverValue='" + turnoverValue + '\'' +
                ", moneyValue='" + moneyValue + '\'' +
                '}';
    }
}
