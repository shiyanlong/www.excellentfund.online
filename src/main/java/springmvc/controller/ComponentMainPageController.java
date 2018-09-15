package springmvc.controller;

import com.alibaba.fastjson.JSON;
import mybatis.domain.EntityStockData;
import mybatis.service.DataServiceImp;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.servlet.http.HttpServletResponse;
import java.util.List;

@org.springframework.stereotype.Controller
public class ComponentMainPageController {

    @Autowired
    @Qualifier("DataServiceImpObj")
    private DataServiceImp dateService;

    /**
     * 首页显示主要指数图表，根据传入股票代码返回数据到前端
     *
     * @param jsonstr  股票代码
     * @param response 响应对象
     * @throws Exception
     */
    @RequestMapping(value = "MainIndexChartShow.do", method = RequestMethod.POST)
    public void MainIndexChartShow(@RequestBody String jsonstr, HttpServletResponse response) {
        //查找股票指数数据
        List<EntityStockData> stockValueList = dateService.GetStockData(jsonstr);
        //将结果转为json字符串返回
        String jsonlist = JSON.toJSONString(stockValueList);
        //返回查询数据
        response.setContentType("text/html;charset=UTF-8");
        try {
            response.getWriter().write(jsonlist);
        } catch (Exception responseErr) {
            System.out.println("MainIndexChartShow响应异常" + responseErr.getMessage());
        }
    }
}
