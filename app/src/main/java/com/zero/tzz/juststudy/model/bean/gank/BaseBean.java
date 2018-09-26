package com.zero.tzz.juststudy.model.bean.gank;

import java.util.List;

/**
 * @author lucy
 * @date 2018-09-26 16:44
 * @description //TODO
 */

public class BaseBean<T> {
    private boolean error;
    private List<T> results;

    public boolean isError() {
        return error;
    }

    public void setError(boolean error) {
        this.error = error;
    }

    public List<T> getData() {
        return results;
    }

    public void setData(List<T> results) {
        this.results = results;
    }
}
