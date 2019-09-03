package com.talkingdata.tds.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.talkingdata.tds.base.service.BaseService;
import com.talkingdata.tds.dao.TagDicDao;
import com.talkingdata.tds.entity.TagDic;


/**
 *
 * <br>
 * <b>功能：</b>tag_dic TagDicService<br>
 * <b>作者：</b>code generator<br>
 * <b>日期：</b> 2019-08-29 <br>
 * <b>版权所有：<b>Copyright(C) 2015, Beijing TendCloud Science & Technology Co., Ltd.<br>
 */
@Service("tagDicService")
@Transactional(value = "transactionManager", readOnly = false, propagation = Propagation.REQUIRED, rollbackFor = Throwable.class)
public class TagDicService extends BaseService<TagDic, Integer> {

    private static final Logger logger = LoggerFactory.getLogger(TagDicService.class);

    @Autowired
    private TagDicDao dao;

    public TagDicDao getDao() {
        return dao;
    }

}
