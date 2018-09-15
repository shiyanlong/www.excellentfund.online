package mybatis.domain;

public class EntityFundPerformance {
    private Integer ID;
    private String fundCode;//基金代码
    private String valueDate;//数据日期
    private String fundIncomeRate30Day;//近30工作日累计净值收益率
    private String fundIncomeRate90Day;//近90工作日累计净值收益率
    private String fundIncomeRate180Day;//近180工作日累计净值收益率
    private String fundIncomeRate360Day;//近360工作日累计净值收益率
    private String fundIncomeRate1080Day;//近1080工作日累计净值收益率
    private String fundIncomeRateCreatedToNow;//成立以来累计净值收益率

    private String fundJensenAlpha90Day;//近90工作日詹森指数
    private String fundJensenAlpha180Day;//近180工作日詹森指数
    private String fundJensenAlpha360Day;//近360工作日詹森指数

    private String fundMaxDown180Day;//近180工作日最大回撤
    private String fundMaxDownTime180Day;//近180工作日最大回撤持续时间

    private String fundMaxDown360Day;//近360工作日最大回撤
    private String fundMaxDownTime360Day;//近360工作日最大回撤持续时间

    private String fundDownStdevp360Day;//近360工作日下行标准差

    public EntityFundPerformance() {
    }

    public EntityFundPerformance(String fundCode, String valueDate, String fundIncomeRate30Day, String fundIncomeRate90Day, String fundIncomeRate180Day, String fundIncomeRate360Day, String fundIncomeRate1080Day, String fundIncomeRateCreatedToNow, String fundJensenAlpha90Day, String fundJensenAlpha180Day, String fundJensenAlpha360Day, String fundMaxDown180Day, String fundMaxDownTime180Day, String fundMaxDown360Day, String fundMaxDownTime360Day, String fundDownStdevp360Day) {
        this.fundCode = fundCode;
        this.valueDate = valueDate;
        this.fundIncomeRate30Day = fundIncomeRate30Day;
        this.fundIncomeRate90Day = fundIncomeRate90Day;
        this.fundIncomeRate180Day = fundIncomeRate180Day;
        this.fundIncomeRate360Day = fundIncomeRate360Day;
        this.fundIncomeRate1080Day = fundIncomeRate1080Day;
        this.fundIncomeRateCreatedToNow = fundIncomeRateCreatedToNow;
        this.fundJensenAlpha90Day = fundJensenAlpha90Day;
        this.fundJensenAlpha180Day = fundJensenAlpha180Day;
        this.fundJensenAlpha360Day = fundJensenAlpha360Day;
        this.fundMaxDown180Day = fundMaxDown180Day;
        this.fundMaxDownTime180Day = fundMaxDownTime180Day;
        this.fundMaxDown360Day = fundMaxDown360Day;
        this.fundMaxDownTime360Day = fundMaxDownTime360Day;
        this.fundDownStdevp360Day = fundDownStdevp360Day;
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

    public String getFundIncomeRate30Day() {
        return fundIncomeRate30Day;
    }

    public void setFundIncomeRate30Day(String fundIncomeRate30Day) {
        this.fundIncomeRate30Day = fundIncomeRate30Day;
    }

    public String getFundIncomeRate90Day() {
        return fundIncomeRate90Day;
    }

    public void setFundIncomeRate90Day(String fundIncomeRate90Day) {
        this.fundIncomeRate90Day = fundIncomeRate90Day;
    }

    public String getFundIncomeRate180Day() {
        return fundIncomeRate180Day;
    }

    public void setFundIncomeRate180Day(String fundIncomeRate180Day) {
        this.fundIncomeRate180Day = fundIncomeRate180Day;
    }

    public String getFundIncomeRate360Day() {
        return fundIncomeRate360Day;
    }

    public void setFundIncomeRate360Day(String fundIncomeRate360Day) {
        this.fundIncomeRate360Day = fundIncomeRate360Day;
    }

    public String getFundIncomeRate1080Day() {
        return fundIncomeRate1080Day;
    }

    public void setFundIncomeRate1080Day(String fundIncomeRate1080Day) {
        this.fundIncomeRate1080Day = fundIncomeRate1080Day;
    }

    public String getFundIncomeRateCreatedToNow() {
        return fundIncomeRateCreatedToNow;
    }

    public void setFundIncomeRateCreatedToNow(String fundIncomeRateCreatedToNow) {
        this.fundIncomeRateCreatedToNow = fundIncomeRateCreatedToNow;
    }

    public String getFundJensenAlpha90Day() {
        return fundJensenAlpha90Day;
    }

    public void setFundJensenAlpha90Day(String fundJensenAlpha90Day) {
        this.fundJensenAlpha90Day = fundJensenAlpha90Day;
    }

    public String getFundJensenAlpha180Day() {
        return fundJensenAlpha180Day;
    }

    public void setFundJensenAlpha180Day(String fundJensenAlpha180Day) {
        this.fundJensenAlpha180Day = fundJensenAlpha180Day;
    }

    public String getFundJensenAlpha360Day() {
        return fundJensenAlpha360Day;
    }

    public void setFundJensenAlpha360Day(String fundJensenAlpha360Day) {
        this.fundJensenAlpha360Day = fundJensenAlpha360Day;
    }

    public String getFundMaxDown180Day() {
        return fundMaxDown180Day;
    }

    public void setFundMaxDown180Day(String fundMaxDown180Day) {
        this.fundMaxDown180Day = fundMaxDown180Day;
    }

    public String getFundMaxDownTime180Day() {
        return fundMaxDownTime180Day;
    }

    public void setFundMaxDownTime180Day(String fundMaxDownTime180Day) {
        this.fundMaxDownTime180Day = fundMaxDownTime180Day;
    }

    public String getFundMaxDown360Day() {
        return fundMaxDown360Day;
    }

    public void setFundMaxDown360Day(String fundMaxDown360Day) {
        this.fundMaxDown360Day = fundMaxDown360Day;
    }


    public String getFundMaxDownTime360Day() {
        return fundMaxDownTime360Day;
    }

    public void setFundMaxDownTime360Day(String fundMaxDownTime360Day) {
        this.fundMaxDownTime360Day = fundMaxDownTime360Day;
    }

    public String getFundDownStdevp360Day() {
        return fundDownStdevp360Day;
    }

    public void setFundDownStdevp360Day(String fundDownStdevp360Day) {
        this.fundDownStdevp360Day = fundDownStdevp360Day;
    }

    @Override
    public String toString() {
        return "EntityFundPerformance{" +
                "fundCode='" + fundCode + '\'' +
                ", valueDate='" + valueDate + '\'' +
                ", fundIncomeRate30Day='" + fundIncomeRate30Day + '\'' +
                ", fundIncomeRate90Day='" + fundIncomeRate90Day + '\'' +
                ", fundIncomeRate180Day='" + fundIncomeRate180Day + '\'' +
                ", fundIncomeRate360Day='" + fundIncomeRate360Day + '\'' +
                ", fundIncomeRate1080Day='" + fundIncomeRate1080Day + '\'' +
                ", fundIncomeRateCreatedToNow='" + fundIncomeRateCreatedToNow + '\'' +
                ", fundJensenAlpha90Day='" + fundJensenAlpha90Day + '\'' +
                ", fundJensenAlpha180Day='" + fundJensenAlpha180Day + '\'' +
                ", fundJensenAlpha360Day='" + fundJensenAlpha360Day + '\'' +
                ", fundMaxDown180Day='" + fundMaxDown180Day + '\'' +
                ", fundMaxDownTime180Day='" + fundMaxDownTime180Day + '\'' +
                ", fundMaxDown360Day='" + fundMaxDown360Day + '\'' +
                ", fundMaxDownTime360Day='" + fundMaxDownTime360Day + '\'' +
                ", fundDownStdevp360Day='" + fundDownStdevp360Day + '\'' +
                '}';
    }
}
