package com.talkingdata.tds.controller;

import static org.springframework.http.MediaType.APPLICATION_JSON_UTF8_VALUE;
import static org.springframework.web.bind.annotation.RequestMethod.DELETE;
import static org.springframework.web.bind.annotation.RequestMethod.GET;
import static org.springframework.web.bind.annotation.RequestMethod.POST;
import static org.springframework.web.bind.annotation.RequestMethod.PUT;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import com.talkingdata.tds.base.web.BaseController;
import com.talkingdata.tds.entity.TagDic;
import com.talkingdata.tds.page.TagDicPage;
import com.talkingdata.tds.service.TagDicService;

@Controller
@RequestMapping("/app")
public class TagDicController extends BaseController{

    private static final Logger logger = LoggerFactory.getLogger(TagDicController.class);

    @Autowired
    private TagDicService tagDicService;

    @RequestMapping(value = "/tagDics", method = GET)
    @ResponseBody
    public List<TagDic> query(TagDicPage page) throws Exception {
        page.setOrderBy(TagDic.fieldToColumn(page.getOrderBy()));
        return tagDicService.queryByList(page);
    }

    @RequestMapping(value = "/tagDics/rows", method = GET)
    @ResponseBody
    public Map<String, Object> queryRows(TagDicPage page) throws Exception {
        page.setOrderBy(TagDic.fieldToColumn(page.getOrderBy()));
        page.setPageSize(Integer.MAX_VALUE);
        List<TagDic> rows = tagDicService.queryByList(page);
        rows = toTree(rows);
        return getGridData(page.getPager().getRowCount(), rows);
    }

    @RequestMapping(value = "/tagDics/{id}", method = GET)
    @ResponseBody
    public TagDic find(@PathVariable Integer id) throws Exception {
        return tagDicService.selectByPrimaryKey(id);
    }

    @RequestMapping(value = "/tagDics", method = POST, consumes = APPLICATION_JSON_UTF8_VALUE)
    @ResponseBody
    public TagDic create(@RequestBody TagDic tagDic) throws Exception {
        tagDicService.insert(tagDic);
        return tagDic;
    }

    @RequestMapping(value = "/tagDics", method = PUT, consumes = APPLICATION_JSON_UTF8_VALUE)
    @ResponseBody
    public void update(@RequestBody TagDic tagDic) throws Exception {
        tagDicService.updateByPrimaryKeySelective(tagDic);
    }

    @RequestMapping(value = "/tagDics/{id}", method = DELETE)
    @ResponseBody
    public void delete(@PathVariable Integer id) throws Exception {
        tagDicService.deleteByPrimaryKey(id);
        logger.info("delete from tag_dic where id = {}", id);
    }


    @RequestMapping(value = "/tagDics/batchCreate", method = POST, consumes = APPLICATION_JSON_UTF8_VALUE)
    @ResponseBody
    public void batchCreate(@RequestBody List<TagDic> tagDics) throws Exception {
        tagDicService.batchInsert(tagDics);
    }



    @RequestMapping(value = "/tagDics/batch/{ids}", method = DELETE)
    @ResponseBody
    public void batchDelete(@PathVariable List<Integer> ids) throws Exception {
    tagDicService.batchDelete(ids);
}

    /**
     * 构建树状结构
     * @param tags
     * @return
     */
    public List<TagDic> toTree(List<TagDic> tags) {
        Map<String , TagDic> temp = new HashMap<String, TagDic>();
        for (TagDic r : tags) {
            temp.put(r.getCode(), r);
        }
        List<TagDic> result = new ArrayList<TagDic>();
        for (TagDic child : tags) {
            String parentCode = child.getParentCode();
            if (parentCode == null)  {
                result.add(child);
                continue;
            }
            if ("".equals(parentCode)) {
                result.add(child);
                continue;
            }
            TagDic parent = temp.get(parentCode);
            if (parent != null){
                parent.getChildren().add(child);
            }
            if (parent == null)
                result.add(child);
        }
        return result;
    }

}
