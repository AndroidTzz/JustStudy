package com.zero.tzz.juststudy.model.http.api;

import com.zero.tzz.juststudy.model.bean.gank.BaseBean;
import com.zero.tzz.juststudy.model.bean.gank.Ganhuo;
import com.zero.tzz.juststudy.model.bean.gank.Search;
import com.zero.tzz.juststudy.model.bean.gank.Today;
import com.zero.tzz.juststudy.model.bean.gank.XianduChild;
import com.zero.tzz.juststudy.model.bean.gank.XianduData;
import com.zero.tzz.juststudy.model.bean.gank.XianduMain;

import io.reactivex.Observable;
import retrofit2.http.GET;
import retrofit2.http.Path;

/**
 * @author lucy
 * @date 2018-09-25 15:36
 * @description //TODO
 */

public interface GankApi {
    String BASE_URL = "http://gank.io";

    /**
     * "/api/data/数据类型/请求个数/第几页"
     * 数据类型： 福利 | Android | iOS | 休息视频 | 拓展资源 | 前端 | all
     * 请求个数： 数字，大于0
     * 第几页：数字，大于0
     */
    @GET("/api/data/{type}/{count}/{page}")
    Observable<BaseBean<Ganhuo>> ganhuo(@Path("type") String type, @Path("count") int count, @Path("page") int page);

    /**
     * 获取最新一天的干货
     */
    @GET("/api/today")
    Observable<BaseBean<Today>> today();

    /**
     * 获取闲读的主分类
     */
    @GET("/api/xiandu/categories")
    Observable<BaseBean<XianduMain>> xianduMain();

    /**
     * 获取闲读的子分类
     *
     * @param en_name category 后面可接受参数为主分类返回的en_name,例如【apps， wow， android，iOS】
     */
    @GET("/api/xiandu/category/{name}")
    Observable<BaseBean<XianduChild>> xianduChild(@Path("name") String en_name);

    /**
     * 获取闲读数据
     *
     * @param id    后面可接受参数为子分类返回的id
     * @param page  第几页，从1开始
     * @param count 每页的个数
     */
    @GET("/api/xiandu/data/id/{id}/count/{count}/page/{page}")
    Observable<BaseBean<XianduData>> xianduData(@Path("id") String id, @Path("count") int count, @Path("page") int page);


    /**
     * 搜索 API
     * category 后面可接受参数 all | Android | iOS | 休息视频 | 福利 | 拓展资源 | 前端 | 瞎推荐 | App
     * count 最大 50
     *
     * @param name  可接受参数 all | Android | iOS | 休息视频 | 福利 | 拓展资源 | 前端 | 瞎推荐 | App
     * @param page  第几页，从1开始
     * @param count 每页的个数
     */
    @GET("/api/search/query/listview/category/{name}/count/{count}/page/{page}")
    Observable<BaseBean<Search>> search(@Path("name") String name, @Path("count") int count, @Path("page") int page);
}
