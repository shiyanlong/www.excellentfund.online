package mybatis.service;

import mybatis.domain.*;
import mybatis.mapping.FundDataMapping;
import mybatis.mapping.StockDataMapping;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service("DataServiceImpObj")
public class DataServiceImp implements DataService {

    @Autowired
    private FundDataMapping fundDataMapping;

    @Autowired
    private StockDataMapping stockDataMapping;

    /**
     * 获取所有基金的：基金代码、名称、拼音简称、类型
     *
     * @return
     */
    @Override
    public List<EntityFundNameData> GetFundNameData() {
        return null;
    }

    /**
     * 获取基金所有净值类数据
     *
     * @param fundCode
     * @return
     */
    @Override
    public List<EntityFundValueData> GetFundValueDataByCode(String fundCode) {
        return fundDataMapping.GetFundValueDataByCode(fundCode);
    }

    /**
     * 获取指定日期范围内的基金净值类数据
     *
     * @param fundCode
     * @param startDate
     * @param endDate
     * @return
     */
    @Override
    public List<EntityFundValueData> GetFundValueDataLimit(String fundCode, String startDate, String endDate) {
        return fundDataMapping.GetFundValueDataLimit(fundCode, startDate, endDate);
    }

    /**
     * 获取股票数据
     *
     * @param stockCode
     * @return
     */
    @Override
    public List<EntityStockData> GetStockData(String stockCode) {
        return stockDataMapping.GetStockData(stockCode);
    }

    @Override
    public List<EntityStockData> GetStockDataLimit(String stockCode, String startDate, String endDate) {
        return stockDataMapping.GetStockDataLimit(stockCode, startDate, endDate);
    }

    /**
     * @param startIndex
     * @param dataNum
     * @return
     */
    @Override
    public List<EntityFundBaseData> GetFundBaseDataLimit(String fundType, Integer startIndex, Integer dataNum) {
        return fundDataMapping.GetFundBaseDataLimit(fundType, startIndex, dataNum);
    }

    /**
     * 获取分页查询的查询结果总记录数
     *
     * @param fundType
     * @return
     */
    @Override
    public Integer GetAllResultCountForPaging(String fundType) {
        return fundDataMapping.GetAllResultCountForPaging(fundType);
    }

    @Override
    public List<EntityFundPerformance> GetFundPerformanceByCode(String fundCode) {
        return fundDataMapping.GetFundPerformanceByCode(fundCode);
    }

    /**
     * 查询基金代码、基金名称、基金拼音简称
     * 根据查询字符串对基金代码、基金名称、基金拼音进行模糊查询，返回符合条件的结果
     *
     * @param searchStr
     * @return
     */
    @Override
    public List<EntityFundBaseData> GetFundBaseDataBySearchStr(String searchStr) {
        return fundDataMapping.GetFundBaseDataBySearchStr(searchStr);
    }

    /**
     * 根据基金代码和指定时间（传入净值最新时间），查询基金目前现任的所有基金经理
     *
     * @param fundCode        基金代码
     * @param fundLastNAVDate 指定时间（传入净值最新时间）
     * @return
     */
    @Override
    public List<EntityFundManagerData> GetFundManagerDataByCodeAndDate(String fundCode, String fundLastNAVDate) {
        return fundDataMapping.GetFundManagerDataByCodeAndDate(fundCode, fundLastNAVDate);
    }
}
