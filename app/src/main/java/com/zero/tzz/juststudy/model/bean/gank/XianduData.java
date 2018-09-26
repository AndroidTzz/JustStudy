package com.zero.tzz.juststudy.model.bean.gank;

/**
 * @author lucy
 * @date 2018-09-25 16:09
 * @description //TODO
 */

public class XianduData {

    private String _id;
    private String content;
    private String cover;
    private long crawled;
    private String created_at;
    private boolean deleted;
    private String published_at;
    private String raw;
    private SiteBean site;
    private String title;
    private String uid;
    private String url;

    public String get_id() {
        return _id;
    }

    public void set_id(String _id) {
        this._id = _id;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getCover() {
        return cover;
    }

    public void setCover(String cover) {
        this.cover = cover;
    }

    public long getCrawled() {
        return crawled;
    }

    public void setCrawled(long crawled) {
        this.crawled = crawled;
    }

    public String getCreated_at() {
        return created_at;
    }

    public void setCreated_at(String created_at) {
        this.created_at = created_at;
    }

    public boolean isDeleted() {
        return deleted;
    }

    public void setDeleted(boolean deleted) {
        this.deleted = deleted;
    }

    public String getPublished_at() {
        return published_at;
    }

    public void setPublished_at(String published_at) {
        this.published_at = published_at;
    }

    public String getRaw() {
        return raw;
    }

    public void setRaw(String raw) {
        this.raw = raw;
    }

    public SiteBean getSite() {
        return site;
    }

    public void setSite(SiteBean site) {
        this.site = site;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getUid() {
        return uid;
    }

    public void setUid(String uid) {
        this.uid = uid;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public static class SiteBean {
        /**
         * cat_cn : 趣味软件/游戏
         * cat_en : apps
         * desc : 分享免费、小巧、实用、有趣、绿色的软件
         * feed_id : feed/http://feed.appinn.com/
         * icon : http://ww3.sinaimg.cn/large/0066P23Wjw1f7efqelrh4j30300300si.jpg
         * id : appinn
         * name : 小众软件
         * subscribers : 43451
         * type : rss
         * url : http://www.appinn.com
         */

        private String cat_cn;
        private String cat_en;
        private String desc;
        private String feed_id;
        private String icon;
        private String id;
        private String name;
        private int subscribers;
        private String type;
        private String url;

        public String getCat_cn() {
            return cat_cn;
        }

        public void setCat_cn(String cat_cn) {
            this.cat_cn = cat_cn;
        }

        public String getCat_en() {
            return cat_en;
        }

        public void setCat_en(String cat_en) {
            this.cat_en = cat_en;
        }

        public String getDesc() {
            return desc;
        }

        public void setDesc(String desc) {
            this.desc = desc;
        }

        public String getFeed_id() {
            return feed_id;
        }

        public void setFeed_id(String feed_id) {
            this.feed_id = feed_id;
        }

        public String getIcon() {
            return icon;
        }

        public void setIcon(String icon) {
            this.icon = icon;
        }

        public String getId() {
            return id;
        }

        public void setId(String id) {
            this.id = id;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public int getSubscribers() {
            return subscribers;
        }

        public void setSubscribers(int subscribers) {
            this.subscribers = subscribers;
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
    }
}
