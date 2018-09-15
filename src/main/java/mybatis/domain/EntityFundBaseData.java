package mybatis.domain;

public class EntityFundBaseData {

    private Integer ID;//ID
    private String fundCode;//基金代码
    private String fundName;//基金名称
    private String fundShortName;//基金拼音简称
    private String fundType;//基金类型
    private String fundLastNAVDate;//最新单位净值日期
    private String fundLastNAV;//最新单位净值日期对应的单位净值
    private String fundCumulativeNAV;//累计净值
    private String fundNAVGrowthRate;//单位净值日增长率
    private String fundIncomeRateOneWeek;//单位净值近1周增长率
    private String fundIncomeRateOneMonth;//单位净值近1月增长率
    private String fundIncomeRateThreeMonth;//单位净值近3月增长率
    private String fundIncomeRateSixMonth;//单位净值近6月增长率
    private String fundIncomeRateOneYear;//单位净值近1年增长率
    private String fundIncomeRateTwoYear;//单位净值近2年增长率
    private String fundIncomeRateThreeYear;//单位净值近3年增长率
    private String fundIncomeRateCurrentYear;//单位净值今年以来增长率
    private String fundIncomeRateCreatedToNow;//成立以来增长率
    private String fundCreatedDate;//成立日期



    public EntityFundBaseData() {
    }

    public EntityFundBaseData(String fundCode, String fundName, String fundShortName, String fundType, String fundLastNAVDate, String fundLastNAV, String fundCumulativeNAV, String fundNAVGrowthRate, String fundIncomeRateOneWeek, String fundIncomeRateOneMonth, String fundIncomeRateThreeMonth, String fundIncomeRateSixMonth, String fundIncomeRateOneYear, String fundIncomeRateTwoYear, String fundIncomeRateThreeYear, String fundIncomeRateCurrentYear, String fundIncomeRateCreatedToNow, String fundCreatedDate) {
        this.fundCode = fundCode;
        this.fundName = fundName;
        this.fundShortName = fundShortName;
        this.fundType = fundType;
        this.fundLastNAVDate = fundLastNAVDate;
        this.fundLastNAV = fundLastNAV;
        this.fundCumulativeNAV = fundCumulativeNAV;
        this.fundNAVGrowthRate = fundNAVGrowthRate;
        this.fundIncomeRateOneWeek = fundIncomeRateOneWeek;
        this.fundIncomeRateOneMonth = fundIncomeRateOneMonth;
        this.fundIncomeRateThreeMonth = fundIncomeRateThreeMonth;
        this.fundIncomeRateSixMonth = fundIncomeRateSixMonth;
        this.fundIncomeRateOneYear = fundIncomeRateOneYear;
        this.fundIncomeRateTwoYear = fundIncomeRateTwoYear;
        this.fundIncomeRateThreeYear = fundIncomeRateThreeYear;
        this.fundIncomeRateCurrentYear = fundIncomeRateCurrentYear;
        this.fundIncomeRateCreatedToNow = fundIncomeRateCreatedToNow;
        this.fundCreatedDate = fundCreatedDate;
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

    public String getFundName() {
        return fundName;
    }

    public void setFundName(String fundName) {
        this.fundName = fundName;
    }

    public String getFundShortName() {
        return fundShortName;
    }

    public void setFundShortName(String fundShortName) {
        this.fundShortName = fundShortName;
    }

    public String getFundType() {
        return fundType;
    }

    public void setFundType(String fundType) {
        this.fundType = fundType;
    }

    public String getFundLastNAVDate() {
        return fundLastNAVDate;
    }

    public void setFundLastNAVDate(String fundLastNAVDate) {
        this.fundLastNAVDate = fundLastNAVDate;
    }

    public String getFundLastNAV() {
        return fundLastNAV;
    }

    public void setFundLastNAV(String fundLastNAV) {
        this.fundLastNAV = fundLastNAV;
    }

    public String getFundCumulativeNAV() {
        return fundCumulativeNAV;
    }

    public void setFundCumulativeNAV(String fundCumulativeNAV) {
        this.fundCumulativeNAV = fundCumulativeNAV;
    }

    public String getFundNAVGrowthRate() {
        return fundNAVGrowthRate;
    }

    public void setFundNAVGrowthRate(String fundNAVGrowthRate) {
        this.fundNAVGrowthRate = fundNAVGrowthRate;
    }

    public String getFundIncomeRateOneWeek() {
        return fundIncomeRateOneWeek;
    }

    public void setFundIncomeRateOneWeek(String fundIncomeRateOneWeek) {
        this.fundIncomeRateOneWeek = fundIncomeRateOneWeek;
    }

    public String getFundIncomeRateOneMonth() {
        return fundIncomeRateOneMonth;
    }

    public void setFundIncomeRateOneMonth(String fundIncomeRateOneMonth) {
        this.fundIncomeRateOneMonth = fundIncomeRateOneMonth;
    }

    public String getFundIncomeRateThreeMonth() {
        return fundIncomeRateThreeMonth;
    }

    public void setFundIncomeRateThreeMonth(String fundIncomeRateThreeMonth) {
        this.fundIncomeRateThreeMonth = fundIncomeRateThreeMonth;
    }

    public String getFundIncomeRateSixMonth() {
        return fundIncomeRateSixMonth;
    }

    public void setFundIncomeRateSixMonth(String fundIncomeRateSixMonth) {
        this.fundIncomeRateSixMonth = fundIncomeRateSixMonth;
    }

    public String getFundIncomeRateOneYear() {
        return fundIncomeRateOneYear;
    }

    public void setFundIncomeRateOneYear(String fundIncomeRateOneYear) {
        this.fundIncomeRateOneYear = fundIncomeRateOneYear;
    }

    public String getFundIncomeRateTwoYear() {
        return fundIncomeRateTwoYear;
    }

    public void setFundIncomeRateTwoYear(String fundIncomeRateTwoYear) {
        this.fundIncomeRateTwoYear = fundIncomeRateTwoYear;
    }

    public String getFundIncomeRateThreeYear() {
        return fundIncomeRateThreeYear;
    }

    public void setFundIncomeRateThreeYear(String fundIncomeRateThreeYear) {
        this.fundIncomeRateThreeYear = fundIncomeRateThreeYear;
    }

    public String getFundIncomeRateCurrentYear() {
        return fundIncomeRateCurrentYear;
    }

    public void setFundIncomeRateCurrentYear(String fundIncomeRateCurrentYear) {
        this.fundIncomeRateCurrentYear = fundIncomeRateCurrentYear;
    }

    public String getFundIncomeRateCreatedToNow() {
        return fundIncomeRateCreatedToNow;
    }

    public void setFundIncomeRateCreatedToNow(String fundIncomeRateCreatedToNow) {
        this.fundIncomeRateCreatedToNow = fundIncomeRateCreatedToNow;
    }

    public String getFundCreatedDate() {
        return fundCreatedDate;
    }

    public void setFundCreatedDate(String fundCreatedDate) {
        this.fundCreatedDate = fundCreatedDate;
    }

    @Override
    public String toString() {
        return "EntityFundBaseData{" +
                "fundCode='" + fundCode + '\'' +
                ", fundName='" + fundName + '\'' +
                ", fundShortName='" + fundShortName + '\'' +
                ", fundType='" + fundType + '\'' +
                ", fundLastNAVDate='" + fundLastNAVDate + '\'' +
                ", fundLastNAV='" + fundLastNAV + '\'' +
                ", fundCumulativeNAV='" + fundCumulativeNAV + '\'' +
                ", fundNAVGrowthRate='" + fundNAVGrowthRate + '\'' +
                ", fundIncomeRateOneWeek='" + fundIncomeRateOneWeek + '\'' +
                ", fundIncomeRateOneMonth='" + fundIncomeRateOneMonth + '\'' +
                ", fundIncomeRateThreeMonth='" + fundIncomeRateThreeMonth + '\'' +
                ", fundIncomeRateSixMonth='" + fundIncomeRateSixMonth + '\'' +
                ", fundIncomeRateOneYear='" + fundIncomeRateOneYear + '\'' +
                ", fundIncomeRateTwoYear='" + fundIncomeRateTwoYear + '\'' +
                ", fundIncomeRateThreeYear='" + fundIncomeRateThreeYear + '\'' +
                ", fundIncomeRateCurrentYear='" + fundIncomeRateCurrentYear + '\'' +
                ", fundIncomeRateCreatedToNow='" + fundIncomeRateCreatedToNow + '\'' +
                ", fundCreatedDate='" + fundCreatedDate + '\'' +
                '}';
    }
}
