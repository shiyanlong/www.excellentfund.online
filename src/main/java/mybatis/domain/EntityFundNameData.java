package mybatis.domain;

public class EntityFundNameData {

    /*
    private Integer ID;
    private String fundCode;    基金代码
    private String fundName;    基金名称
    private String fundShortName;   基金拼音简称
    private String fundType;    基金类型
     */

    private Integer ID;
    private String fundCode;
    private String fundName;
    private String fundShortName;
    private String fundType;

    public EntityFundNameData() {
    }

    public EntityFundNameData(String fundCode, String fundName, String fundShortName, String fundType) {
        this.fundCode = fundCode;
        this.fundName = fundName;
        this.fundShortName = fundShortName;
        this.fundType = fundType;
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

    @Override
    public String toString() {
        return "EntityFundNameData{" +
                "fundCode='" + fundCode + '\'' +
                ", fundName='" + fundName + '\'' +
                ", fundShortName='" + fundShortName + '\'' +
                ", fundType='" + fundType + '\'' +
                '}';
    }
}
