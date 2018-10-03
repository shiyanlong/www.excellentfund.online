package mybatis.service;

import mybatis.domain.*;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface DataService {

    //一、基金类操作
    List<EntityFundNameData> GetFundNameData();

    List<EntityFundValueData> GetFundValueDataByCode(@Param("tableName") String tableName, @Param("fundCode") String fundCode);

    List<EntityFundValueData> GetFundValueDataLimit(@Param("tableName") String tableName, @Param("fundCode") String fundCode, @Param("startDate") String startDate, @Param("endDate") String endDate);

//    List<EntityFundShowFirstPage> GetFundPerformance(String fundType);

    List<EntityFundBaseData> GetFundBaseDataLimit(@Param("fundType") String fundType, @Param("startIndex") Integer startIndex, @Param("dataNum") Integer dataNum);

    //根据基金代码，查询数据库，返回该基金的业绩数据
    List<EntityFundPerformance> GetFundPerformanceByCode(String fundCode);

    //获取分页查询的查询结果总记录数
    //需要提供参数：表名、字段名、模糊查询条件
    Integer GetAllResultCountForPaging(@Param("fundType") String fundType);

    //查询基金代码、基金名称、基金拼音简称
    //根据查询字符串对基金代码、基金名称、基金拼音进行模糊查询，返回符合条件的结果
    List<EntityFundBaseData> GetFundBaseDataBySearchStr(String searchStr);

    //根据基金代码和指定时间（传入净值最新时间），查询基金目前现任的所有基金经理
    List<EntityFundManagerData> GetFundManagerDataByCodeAndDate(@Param("fundCode") String fundCode, @Param("fundLastNAVDate") String fundLastNAVDate);

    //二、股票类操作
    List<EntityStockData> GetStockData(String stockCode);

    List<EntityStockData> GetStockDataLimit(@Param("stockCode") String stockCode, @Param("startDate") String startDate, @Param("endDate") String endDate);

}
