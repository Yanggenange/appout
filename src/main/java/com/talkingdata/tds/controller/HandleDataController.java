package com.talkingdata.tds.controller;

import static org.springframework.http.MediaType.APPLICATION_JSON_UTF8_VALUE;
import static org.springframework.web.bind.annotation.RequestMethod.DELETE;
import static org.springframework.web.bind.annotation.RequestMethod.GET;
import static org.springframework.web.bind.annotation.RequestMethod.POST;
import static org.springframework.web.bind.annotation.RequestMethod.PUT;

import java.util.List;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import com.talkingdata.tds.base.web.BaseController;
import com.talkingdata.tds.entity.HandleData;
import com.talkingdata.tds.page.HandleDataPage;
import com.talkingdata.tds.service.HandleDataService;

@Controller
@RequestMapping("/app")
public class HandleDataController extends BaseController{

    private static final Logger logger = LoggerFactory.getLogger(HandleDataController.class);

    @Autowired
    private HandleDataService handleDataService;

    @RequestMapping(value = "/handleDatas", method = GET)
    @ResponseBody
    public List<HandleData> query(HandleDataPage page) throws Exception {
        page.setOrderBy(HandleData.fieldToColumn(page.getOrderBy()));
        return handleDataService.queryByList(page);
    }

    @RequestMapping(value = "/handleDatas/rows", method = GET)
    @ResponseBody
    public Map<String, Object> queryRows(HandleDataPage page) throws Exception {
        page.setOrderBy(HandleData.fieldToColumn(page.getOrderBy()));

        String keyword = page.getKeyword();
        if(keyword!=null){
            if(!keyword.equals("")){
                String[] split = keyword.split("=");
                String key = split[0];
                if("appName".equals(key)){
                    page.setAppName(split[1]);
                }else if("packageName".equals(key)){
                    page.setPackageName(split[1]);
                }else if("packageHash".equals(key)){
                    page.setPackageHash(split[1]);
                }else if("appTag".equals(key)){
                    page.setTypeName(split[1]);
                }
            }
        }

        List<HandleData> rows = handleDataService.queryByList(page);
        return getGridData(page.getPager().getRowCount(), rows);
    }

    @RequestMapping(value = "/handleDatas/{id}", method = GET)
    @ResponseBody
    public HandleData find(@PathVariable Integer id) throws Exception {
        return handleDataService.selectByPrimaryKey(id);
    }

    @RequestMapping(value = "/handleDatas", method = POST, consumes = APPLICATION_JSON_UTF8_VALUE)
    @ResponseBody
    public HandleData create(@RequestBody HandleData handleData) throws Exception {
        handleDataService.insert(handleData);
        return handleData;
    }

    @RequestMapping(value = "/handleDatas", method = PUT, consumes = APPLICATION_JSON_UTF8_VALUE)
    @ResponseBody
    public void update(@RequestBody HandleData handleData) throws Exception {
        handleDataService.updateByPrimaryKeySelective(handleData);
    }

    @RequestMapping(value = "/handleDatas/{id}", method = DELETE)
    @ResponseBody
    public void delete(@PathVariable Integer id) throws Exception {
        handleDataService.deleteByPrimaryKey(id);
        logger.info("delete from handle_data where id = {}", id);
    }


    @RequestMapping(value = "/handleDatas/batchCreate", method = POST, consumes = APPLICATION_JSON_UTF8_VALUE)
    @ResponseBody
    public void batchCreate(@RequestBody List<HandleData> handleDatas) throws Exception {
        handleDataService.batchInsert(handleDatas);
    }



    @RequestMapping(value = "/handleDatas/batch/{ids}", method = DELETE)
    @ResponseBody
    public void batchDelete(@PathVariable List<Integer> ids) throws Exception {
    handleDataService.batchDelete(ids);
}



}
