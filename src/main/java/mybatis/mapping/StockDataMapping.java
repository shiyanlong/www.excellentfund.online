package mybatis.mapping;

import mybatis.domain.EntityStockData;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface StockDataMapping {

    List<EntityStockData> GetStockData(String stockCode);

    List<EntityStockData> GetStockDataLimit(@Param("stockCode") String stockCode, @Param("startDate") String startDate, @Param("endDate") String endDate);

}
