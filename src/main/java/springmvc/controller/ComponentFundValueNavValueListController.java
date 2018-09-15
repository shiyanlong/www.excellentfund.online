package springmvc.controller;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import mybatis.domain.EntityFundBaseData;
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
public class ComponentFundValueNavValueListController {

    @Autowired
    @Qualifier("DataServiceImpObj")
    private DataServiceImp dateService;

    /**
     * 查询数据库每支基金的12条基本数据：1基金代码，2基金名称，3拼音简称，4净值日期，5净值日期对应单位净值，6累计净值，7单位净值日增长率，8近1周增长率，9近1月增长率，10近3月增长率，11近6月增长率，12近1年增长率
     *
     * @param paramJsonStr 参数json字符串
     * @param response
     */
    @RequestMapping(value = "GetFundBaseData.do", method = RequestMethod.POST)
    public void GetFundBaseData(@RequestBody String paramJsonStr, HttpServletResponse response) {
        //将json字符串转成json对象
        JSONObject jsonObject = JSONObject.parseObject(paramJsonStr);
        //获取json对象属性
        String fundType = (String) jsonObject.get("fundType");
        String startIndex = (String) jsonObject.get("startIndex");
        String dataNum = (String) jsonObject.get("dataNum");
        //获得总记录数，则下标范围：0-（resultAllCount-1），即下标最大值为resultAllCount-1
        Integer resultAllCount = dateService.GetAllResultCountForPaging(fundType);
        //保存查询结果List转化后的json字符串
        String resultJson = "";
        //若起始下标大于下标最大值，则不进行查询，resultJson为空对象
        if (Integer.valueOf(startIndex) > (resultAllCount - 1)) {
            List<EntityFundBaseData> fundBaseDataList = new ArrayList<>();
        }
        //若起始下标加上预计返回数据行，大于下标最大值，则修改预计返回的数据行dataNum，作为最后一组数据返回：dataNum=下标最大值-起始下标+1
        if (Integer.valueOf(startIndex) + Integer.valueOf(dataNum) - 1 > (resultAllCount - 1)) {
            dataNum = String.valueOf((resultAllCount - 1) - Integer.valueOf(startIndex) + 1);
            //获取查询结果List
            List<EntityFundBaseData> fundBaseDataList = dateService.GetFundBaseDataLimit(fundType, Integer.valueOf(startIndex), Integer.valueOf(dataNum));
            //查询结果List转为json字符串
            resultJson = JSON.toJSONString(fundBaseDataList);
        }
        if (Integer.valueOf(startIndex) + Integer.valueOf(dataNum) - 1 <= (resultAllCount - 1)) {
            //若起始下标加上预计返回数据行，小于等于下标最大值，按预计返回数据行查询
            //获取查询结果List
            List<EntityFundBaseData> fundBaseDataList = dateService.GetFundBaseDataLimit(fundType, Integer.valueOf(startIndex), Integer.valueOf(dataNum));
            //查询结果List转为json字符串
            resultJson = JSON.toJSONString(fundBaseDataList);
        }
        //返回查询数据
        response.setContentType("text/html;charset=UTF-8");
        try {
            response.getWriter().write(resultJson);
        } catch (Exception responseErr) {
            System.out.println("GetFundBaseData响应异常：" + responseErr.getMessage());
        }
    }

}
