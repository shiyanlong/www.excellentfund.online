package mybatis.mapping;

import mybatis.domain.*;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface FundDataMapping {


    List<EntityFundNameData> GetFundNameData();

    List<EntityFundValueData> GetFundValueDataByCode(String fundCode);

    List<EntityFundValueData> GetFundValueDataLimit(@Param("fundCode") String fundCode, @Param("startDate") String startDate, @Param("endDate") String endDate);

    //根据基金代码，查询数据库，返回该基金的业绩数据
    List<EntityFundPerformance> GetFundPerformanceByCode(String fundCode);

    //根据基金类型，查询数据库，返回该类型下每支基金的17条基本数据：1基金代码，2基金名称，3拼音简称，4净值日期，5净值日期对应单位净值，6累计净值，7单位净值日增长率，8近1周增长率，9近1月增长率，10近3月增长率，11近6月增长率，12近1年增长率，13近2年增长率，14近3年增长率，15今年来增长率，16成立以来收益率，17成立日期
    //可通过startIndex、dataNum，指定从起始下标startIndex起，取dataNum条数据。例如：startIndex=0，dataNum=10，则取下标为0-9的共10条数据
    //该查询是配合页面切换到“净值数据”选项卡时，给mint-ui的InfiniteScroll组件使用，延迟加载数据，每次获取dataNum条数据，例子：
    //第一次：startIndex1=0，dataNum=10，endIndex1=9
    //第一次：startIndex2=10，dataNum=10，endIndex2=19
    //第三次：startIndex2=20，dataNum=10，endIndex2=29
    //第n次：startIndexN=dataNum+startIndex（N-1），dataNum=10，endIndexN=dataNum+startIndexN-1
    List<EntityFundBaseData> GetFundBaseDataLimit(@Param("fundType") String fundType, @Param("startIndex") Integer startIndex, @Param("dataNum") Integer dataNum);

    //获取分页查询的查询结果总记录数
    //需要提供模糊查询条件
    Integer GetAllResultCountForPaging(@Param("fundType") String fundType);

    //查询基金代码、基金名称、基金拼音简称
    //根据查询字符串对基金代码、基金名称、基金拼音进行模糊查询，返回符合条件的结果
    List<EntityFundBaseData> GetFundBaseDataBySearchStr(@Param("searchStr") String searchStr);

    //根据基金代码和指定时间（传入净值最新时间），查询基金目前现任的所有基金经理
    List<EntityFundManagerData> GetFundManagerDataByCodeAndDate(@Param("fundCode") String fundCode,@Param("fundLastNAVDate") String fundLastNAVDate);
}
