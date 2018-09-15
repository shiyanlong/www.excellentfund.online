package springmvc.controller;

import com.alibaba.fastjson.JSON;
import mybatis.domain.EntityFundBaseData;
import mybatis.service.DataServiceImp;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.servlet.http.HttpServletResponse;
import java.util.List;

@org.springframework.stereotype.Controller
public class ComponentFundValueNavController {

    @Autowired
    @Qualifier("DataServiceImpObj")
    private DataServiceImp dateService;

    /**
     * 搜索框实时查询功能
     *
     * @param searchStr
     * @param response 响应对象
     * @throws Exception
     */
    @RequestMapping(value = "FundValueNavSearchResultShow.do", method = RequestMethod.POST)
    public void FundValueNavSearchResultShow(@RequestBody String searchStr, HttpServletResponse response) {
        if(searchStr.equals("")){
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
            responseErr.printStackTrace();
            System.out.println("SearchResultShow响应异常" + responseErr.getMessage());
        }
    }

}
