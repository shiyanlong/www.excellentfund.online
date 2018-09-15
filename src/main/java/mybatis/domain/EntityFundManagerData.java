package mybatis.domain;

public class EntityFundManagerData {

    /*
    private Integer ID;
    private String dataDate;    数据录入时间
    private String managerCode; 基金经理代码
    private String managerName; 基金经理名称
    private String companyCode; 所属公司代码
    private String companyName; 所属公司名称
    private String currentFundCodeList; 现任基金代码列表
    private String currentFundNameList; 现任基金名称列表
    private String managerWorkTime; 累计任职时间
    private String currentFundMaxIncome;    现任最佳基金回报
    private String currentFundMaxIncomeCode;    现任最佳基金代码
    private String currentFundMaxIncomeName;    现任最佳基金名称
    private String currentAssets;   现任基金资产总规模
    private String managerWorkTimeMaxIncome;    任职期间最佳基金回报
     */

    private Integer ID;
    private String dataDate;
    private String managerCode;
    private String managerName;
    private String companyCode;
    private String companyName;
    private String currentFundCodeList;
    private String currentFundNameList;
    private String managerWorkTime;
    private String currentFundMaxIncome;
    private String currentFundMaxIncomeCode;
    private String currentFundMaxIncomeName;
    private String currentAssets;
    private String managerWorkTimeMaxIncome;

    public EntityFundManagerData() {
    }

    public EntityFundManagerData(String dataDate, String managerCode, String managerName, String companyCode, String companyName, String currentFundCodeList, String currentFundNameList, String managerWorkTime, String currentFundMaxIncome, String currentFundMaxIncomeCode, String currentFundMaxIncomeName, String currentAssets, String managerWorkTimeMaxIncome) {
        this.dataDate = dataDate;
        this.managerCode = managerCode;
        this.managerName = managerName;
        this.companyCode = companyCode;
        this.companyName = companyName;
        this.currentFundCodeList = currentFundCodeList;
        this.currentFundNameList = currentFundNameList;
        this.managerWorkTime = managerWorkTime;
        this.currentFundMaxIncome = currentFundMaxIncome;
        this.currentFundMaxIncomeCode = currentFundMaxIncomeCode;
        this.currentFundMaxIncomeName = currentFundMaxIncomeName;
        this.currentAssets = currentAssets;
        this.managerWorkTimeMaxIncome = managerWorkTimeMaxIncome;
    }

    public Integer getID() {
        return ID;
    }

    public void setID(Integer ID) {
        this.ID = ID;
    }

    public String getDataDate() {
        return dataDate;
    }

    public void setDataDate(String dataDate) {
        this.dataDate = dataDate;
    }

    public String getManagerCode() {
        return managerCode;
    }

    public void setManagerCode(String managerCode) {
        this.managerCode = managerCode;
    }

    public String getManagerName() {
        return managerName;
    }

    public void setManagerName(String managerName) {
        this.managerName = managerName;
    }

    public String getCompanyCode() {
        return companyCode;
    }

    public void setCompanyCode(String companyCode) {
        this.companyCode = companyCode;
    }

    public String getCompanyName() {
        return companyName;
    }

    public void setCompanyName(String companyName) {
        this.companyName = companyName;
    }

    public String getCurrentFundCodeList() {
        return currentFundCodeList;
    }

    public void setCurrentFundCodeList(String currentFundCodeList) {
        this.currentFundCodeList = currentFundCodeList;
    }

    public String getCurrentFundNameList() {
        return currentFundNameList;
    }

    public void setCurrentFundNameList(String currentFundNameList) {
        this.currentFundNameList = currentFundNameList;
    }

    public String getManagerWorkTime() {
        return managerWorkTime;
    }

    public void setManagerWorkTime(String managerWorkTime) {
        this.managerWorkTime = managerWorkTime;
    }

    public String getCurrentFundMaxIncome() {
        return currentFundMaxIncome;
    }

    public void setCurrentFundMaxIncome(String currentFundMaxIncome) {
        this.currentFundMaxIncome = currentFundMaxIncome;
    }

    public String getCurrentFundMaxIncomeCode() {
        return currentFundMaxIncomeCode;
    }

    public void setCurrentFundMaxIncomeCode(String currentFundMaxIncomeCode) {
        this.currentFundMaxIncomeCode = currentFundMaxIncomeCode;
    }

    public String getCurrentFundMaxIncomeName() {
        return currentFundMaxIncomeName;
    }

    public void setCurrentFundMaxIncomeName(String currentFundMaxIncomeName) {
        this.currentFundMaxIncomeName = currentFundMaxIncomeName;
    }

    public String getCurrentAssets() {
        return currentAssets;
    }

    public void setCurrentAssets(String currentAssets) {
        this.currentAssets = currentAssets;
    }

    public String getManagerWorkTimeMaxIncome() {
        return managerWorkTimeMaxIncome;
    }

    public void setManagerWorkTimeMaxIncome(String managerWorkTimeMaxIncome) {
        this.managerWorkTimeMaxIncome = managerWorkTimeMaxIncome;
    }

    @Override
    public String toString() {
        return "EntityFundManagerData{" +
                "dataDate='" + dataDate + '\'' +
                ", managerCode='" + managerCode + '\'' +
                ", managerName='" + managerName + '\'' +
                ", companyCode='" + companyCode + '\'' +
                ", companyName='" + companyName + '\'' +
                ", currentFundCodeList='" + currentFundCodeList + '\'' +
                ", currentFundNameList='" + currentFundNameList + '\'' +
                ", managerWorkTime='" + managerWorkTime + '\'' +
                ", currentFundMaxIncome='" + currentFundMaxIncome + '\'' +
                ", currentFundMaxIncomeCode='" + currentFundMaxIncomeCode + '\'' +
                ", currentFundMaxIncomeName='" + currentFundMaxIncomeName + '\'' +
                ", currentAssets='" + currentAssets + '\'' +
                ", managerWorkTimeMaxIncome='" + managerWorkTimeMaxIncome + '\'' +
                '}';
    }
}
