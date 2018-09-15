package mybatis.domain;

public class EntityFundValueData {

    /*
    private Integer ID;
    private String fundCode;    基金代码
    private String valueDate;   基金单位净值日期
    private String NAV;         基金单位净值
    private String cumulativeNAV;   基金累计净值
    private String dailyGrowthRate; 基金净值日增长率
    private String subscribeStatus; 基金申购状态
    private String redemptionStatus;    基金赎回状态
    private String melonCutting;    分红配送
     */

    private Integer ID;
    private String fundCode;
    private String valueDate;
    private String NAV;
    private String cumulativeNAV;
    private String dailyGrowthRate;
    private String subscribeStatus;
    private String redemptionStatus;
    private String melonCutting;

    public EntityFundValueData() {
    }

    public EntityFundValueData(String fundCode, String valueDate, String NAV, String cumulativeNAV, String dailyGrowthRate, String subscribeStatus, String redemptionStatus, String melonCutting) {
        this.fundCode = fundCode;
        this.valueDate = valueDate;
        this.NAV = NAV;
        this.cumulativeNAV = cumulativeNAV;
        this.dailyGrowthRate = dailyGrowthRate;
        this.subscribeStatus = subscribeStatus;
        this.redemptionStatus = redemptionStatus;
        this.melonCutting = melonCutting;
    }

    public Integer getID() {
        return ID;
    }

    public void setID(Integer ID) {
        this.ID = ID;
    }

    public String getFundCode() {
        return fundCode;
    }

    public void setFundCode(String fundCode) {
        this.fundCode = fundCode;
    }

    public String getValueDate() {
        return valueDate;
    }

    public void setValueDate(String valueDate) {
        this.valueDate = valueDate;
    }

    public String getNAV() {
        return NAV;
    }

    public void setNAV(String NAV) {
        this.NAV = NAV;
    }

    public String getCumulativeNAV() {
        return cumulativeNAV;
    }

    public void setCumulativeNAV(String cumulativeNAV) {
        this.cumulativeNAV = cumulativeNAV;
    }

    public String getDailyGrowthRate() {
        return dailyGrowthRate;
    }

    public void setDailyGrowthRate(String dailyGrowthRate) {
        this.dailyGrowthRate = dailyGrowthRate;
    }

    public String getSubscribeStatus() {
        return subscribeStatus;
    }

    public void setSubscribeStatus(String subscribeStatus) {
        this.subscribeStatus = subscribeStatus;
    }

    public String getRedemptionStatus() {
        return redemptionStatus;
    }

    public void setRedemptionStatus(String redemptionStatus) {
        this.redemptionStatus = redemptionStatus;
    }

    public String getMelonCutting() {
        return melonCutting;
    }

    public void setMelonCutting(String melonCutting) {
        this.melonCutting = melonCutting;
    }

    @Override
    public String toString() {
        return "EntityFundValueData{" +
                "fundCode='" + fundCode + '\'' +
                ", valueDate='" + valueDate + '\'' +
                ", NAV='" + NAV + '\'' +
                ", cumulativeNAV='" + cumulativeNAV + '\'' +
                ", dailyGrowthRate='" + dailyGrowthRate + '\'' +
                ", subscribeStatus='" + subscribeStatus + '\'' +
                ", redemptionStatus='" + redemptionStatus + '\'' +
                ", melonCutting='" + melonCutting + '\'' +
                '}';
    }
}
