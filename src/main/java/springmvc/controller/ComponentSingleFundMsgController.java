package springmvc.controller;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import mybatis.domain.EntityFundManagerData;
import mybatis.domain.EntityFundPerformance;
import mybatis.domain.EntityFundValueData;
import mybatis.service.DataServiceImp;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.servlet.http.HttpServletResponse;
import java.util.List;

@org.springframework.stereotype.Controller
public class ComponentSingleFundMsgController {

    @Autowired
    @Qualifier("DataServiceImpObj")
    private DataServiceImp dateService;

    @RequestMapping(value = "SingleFundNAVChartAndTableShow.do", method = RequestMethod.POST)
    public void SingleFundNAVChartAndTableShow(@RequestBody String jsonstr, HttpServletResponse response) {
        //将json字符串转成json对象
        JSONObject jsonObject = JSONObject.parseObject(jsonstr);
        //获取json对象属性
        //基金代码
        String fundCode = (String) jsonObject.get("fundCode");
        //获取查询结果
        List<EntityFundValueData> fundNameList = dateService.GetFundValueDataByCode(fundCode);
        //将查询结果转为json字符串
        String resultJson = JSON.toJSONString(fundNameList);
        //返回查询数据
        response.setContentType("text/html;charset=UTF-8");
        try {
            response.getWriter().write(resultJson);
        } catch (Exception responseErr) {
            System.out.println("SingleFundNAVChartAndTableShow响应异常：" + responseErr.getMessage());
        }
    }

    @RequestMapping(value = "GetFundPerformanceData.do", method = RequestMethod.POST)
    public void GetFundPerformanceData(@RequestBody String paramJsonStr, HttpServletResponse response) {
        //将json字符串转成json对象
        JSONObject jsonObject = JSONObject.parseObject(paramJsonStr);
        //获取json对象属性
        //基金代码
        String fundCode = (String) jsonObject.get("fundCode");
        //获取查询结果
        List<EntityFundPerformance> fundPerformanceDataList = dateService.GetFundPerformanceByCode(fundCode);
        //将查询结果转为json字符串
        String resultJson = JSON.toJSONString(fundPerformanceDataList);
        //返回查询数据
        response.setContentType("text/html;charset=UTF-8");
        try {
            response.getWriter().write(resultJson);
        } catch (Exception responseErr) {
            System.out.println("GetFundPerformanceData响应异常：" + responseErr.getMessage());
        }
    }

    @RequestMapping(value = "GetFundManagerData.do", method = RequestMethod.POST)
    public void GetFundManagerData(@RequestBody String jsonstr, HttpServletResponse response) {
        //将json字符串转成json对象
        JSONObject jsonObject = JSONObject.parseObject(jsonstr);
        //获取json对象属性
        //基金代码
        String fundCode = (String) jsonObject.get("fundCode");
        //净值最新日期
        String fundLastNAVDate = (String) jsonObject.get("fundLastNAVDate");
        //获取查询结果
        List<EntityFundManagerData> fundManagerDataList = dateService.GetFundManagerDataByCodeAndDate(fundCode, fundLastNAVDate);
        //将查询结果转为json字符串
        String resultJson = JSON.toJSONString(fundManagerDataList);
        //返回查询数据
        response.setContentType("text/html;charset=UTF-8");
        try {
            response.getWriter().write(resultJson);
        } catch (Exception responseErr) {
            System.out.println("GetFundManagerData响应异常：" + responseErr.getMessage());
        }
    }

}
