package com.talkingdata.tds.base.dao;



import com.talkingdata.tds.base.entity.BaseEntity;
import com.talkingdata.tds.base.page.BasePage;

import java.util.ArrayList;
import java.util.List;

/**
 * 2016-12-28 copy from dmp
 */
public interface BaseDao<T extends BaseEntity> {

    int insert(T record);

    int updateByPrimaryKey(T record);

    int updateByPrimaryKeySelective(T record);

    T selectByPrimaryKey(Object id);

    int deleteByPrimaryKey(Object id);

    public int queryByCount(BasePage page);

    public List<T> queryByList(BasePage page);

    int batchInsert(List<T> records);

    int batchDeleteByKeys(List<Object> ids);

    int deleteBatch(ArrayList<Integer> integers);

}
