package com.talkingdata.tds.base.service;





import com.talkingdata.tds.base.dao.BaseDao;
import com.talkingdata.tds.base.entity.BaseEntity;
import com.talkingdata.tds.base.page.BasePage;

import java.util.ArrayList;
import java.util.List;

/**
 * 2016-12-28 copy from dmp
 */
public abstract class BaseService<T extends BaseEntity, K> {

    public abstract BaseDao<T> getDao();

    public int insert(T t) throws Exception {

        return getDao().insert(t);
    }

    public int updateByPrimaryKey(T t) throws Exception {
        return getDao().updateByPrimaryKey(t);
    }

    public int updateByPrimaryKeySelective(T t) throws Exception {
        return getDao().updateByPrimaryKeySelective(t);
    }

    public T selectByPrimaryKey(K value) throws Exception {
        return getDao().selectByPrimaryKey(value);
    }

    public void deleteByPrimaryKey(K value) throws Exception {
        getDao().deleteByPrimaryKey(value);
    }

    public int queryByCount(BasePage page) throws Exception {
        return getDao().queryByCount(page);
    }

    public List<T> queryByList(BasePage page) throws Exception {
        Integer rowCount = queryByCount(page);
        page.getPager().setRowCount(rowCount);
        return getDao().queryByList(page);
    }

    public T queryBySingle(BasePage page) throws Exception {
        page.setPageSize(1);
        List<T> results = getDao().queryByList(page);
        return null == results || results.size() == 0 ? null : results.get(0);
    }

    public int batchInsert(List<T> ts) throws Exception {
        return getDao().batchInsert(ts);
    }

    public int batchDelete(List<K> values) throws Exception {
        return getDao().batchDeleteByKeys((List<Object>) values);
    }


    /**
     * 批量删除
     * @param integers
     */
    public void deleteBatch(ArrayList<Integer> integers) {
        getDao().deleteBatch(integers);
    }



}
