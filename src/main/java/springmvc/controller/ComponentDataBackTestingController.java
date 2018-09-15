package springmvc.controller;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import mybatis.domain.EntityFundBaseData;
import mybatis.domain.EntityFundValueData;
import mybatis.domain.EntityStockData;
import mybatis.service.DataServiceImp;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.servlet.http.HttpServletResponse;
import java.util.ArrayList;
import java.util.List;

@org.springframework.stereotype.Controller
public class ComponentDataBackTestingController {

    @Autowired
    @Qualifier("DataServiceImpObj")
    private DataServiceImp dateService;

    /**
     * 搜索框实时查询功能
     *
     * @param searchStr
     * @param response  响应对象
     * @throws Exception
     */
    @RequestMapping(value = "DataBackTestingSearchResultShow.do", method = RequestMethod.POST)
    public void DataBackTestingSearchResultShow(@RequestBody String searchStr, HttpServletResponse response) {
        if (searchStr.equals("")) {
            return;
        }
        //获取模糊查找结果
        List<EntityFundBaseData> searchSResultList = dateService.GetFundBaseDataBySearchStr(searchStr);
        //将数据转为json字符串
        String resultJson = JSON.toJSONString(searchSResultList);
        //返回查询数据
        response.setContentType("text/html;charset=UTF-8");
        try {
            response.getWriter().write(resultJson);
        } catch (Exception responseErr) {
            System.out.println("SearchResultShow响应异常" + responseErr.getMessage());
        }
    }

    @RequestMapping(value = "GetFundValueGrowthRateData.do", method = RequestMethod.POST)
    public void GetFundValueGrowthRateData(@RequestBody String jsonstr, HttpServletResponse response) {
        //将json字符串转成json对象
        JSONObject jsonObject = JSONObject.parseObject(jsonstr);
        //获取json对象属性
        //基金代码
        String fundCode = (String) jsonObject.get("fundCode");
        //起始查询日期
        String startDate = (String) jsonObject.get("startDate");
        //终止查询日期
        String endDate = (String) jsonObject.get("endDate");
        //查询类型标志
        String dataFlag = (String) jsonObject.get("dataFlag");
        //获取查询结果
        List<EntityFundValueData> fundNameList = new ArrayList<>();
        List<EntityStockData> stockNameList = new ArrayList<>();
        String resultJson = "";
        if (dataFlag.equals("fundFlag")) {
            fundNameList = dateService.GetFundValueDataLimit(fundCode, startDate, endDate);
            //将查询结果转为json字符串
            resultJson = JSON.toJSONString(fundNameList);
        }
        if (dataFlag.equals("stockFlag")) {
            stockNameList = dateService.GetStockDataLimit(fundCode, startDate, endDate);
            //将查询结果转为json字符串
            resultJson = JSON.toJSONString(stockNameList);
        }
        //返回查询数据
        response.setContentType("text/html;charset=UTF-8");
        try {
            response.getWriter().write(resultJson);
        } catch (Exception responseErr) {
            System.out.println("GetFundValueGrowthRateData响应异常" + responseErr.getMessage());
        }
    }

}
