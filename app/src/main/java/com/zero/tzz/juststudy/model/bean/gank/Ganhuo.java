package com.zero.tzz.juststudy.model.bean.gank;

import java.util.List;

/**
 * @author lucy
 * @date 2018-09-26 17:21
 * @description //TODO
 */

public class Ganhuo {
    /**
     * _id : 5b977a759d212206c1b383d3
     * createdAt : 2018-09-11T08:19:01.268Z
     * desc : 手把手教你实现抖音视频特效
     * publishedAt : 2018-09-19T00:00:00.0Z
     * source : web
     * type : Android
     * url : https://www.jianshu.com/p/5bb7f2a0da90
     * used : true
     * who : xue5455
     * images : ["https://ww1.sinaimg.cn/large/0073sXn7ly1fvexchbaadj30u01hcta5","https://ww1.sinaimg.cn/large/0073sXn7ly1fvexchjeypj30u01hc0y3","https://ww1.sinaimg.cn/large/0073sXn7ly1fvexchpj7bj30tv1h9q5y","https://ww1.sinaimg.cn/large/0073sXn7ly1fvexchw320j30u01hcgow"]
     */

    private String _id;
    private String createdAt;
    private String desc;
    private String publishedAt;
    private String source;
    private String type;
    private String url;
    private boolean used;
    private String who;
    private List<String> images;

    public String get_id() {
        return _id;
    }

    public void set_id(String _id) {
        this._id = _id;
    }

    public String getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(String createdAt) {
        this.createdAt = createdAt;
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }

    public String getPublishedAt() {
        return publishedAt;
    }

    public void setPublishedAt(String publishedAt) {
        this.publishedAt = publishedAt;
    }

    public String getSource() {
        return source;
    }

    public void setSource(String source) {
        this.source = source;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public boolean isUsed() {
        return used;
    }

    public void setUsed(boolean used) {
        this.used = used;
    }

    public String getWho() {
        return who;
    }

    public void setWho(String who) {
        this.who = who;
    }

    public List<String> getImages() {
        return images;
    }

    public void setImages(List<String> images) {
        this.images = images;
    }
}
