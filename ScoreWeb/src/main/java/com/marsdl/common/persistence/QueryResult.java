package com.marsdl.common.persistence;

import java.util.List;
import java.util.Map;

/**
 * @Description
 * @Author chenrui
 * @since 2017/12/31
 */
public class QueryResult<T> {

    private List<T> queryResult;
    private List<Map<String, Object>> queryResultMap;
    private long count;

    public List<T> getQueryResult() {
        return queryResult;
    }

    public void setQueryResult(List<T> queryResult) {
        this.queryResult = queryResult;
    }

    public List<Map<String, Object>> getQueryResultMap() {
        return queryResultMap;
    }

    public void setQueryResultMap(List<Map<String, Object>> queryResultMap) {
        this.queryResultMap = queryResultMap;
    }

    public long getCount() {
        return count;
    }

    public void setCount(long count) {
        this.count = count;
    }
}
