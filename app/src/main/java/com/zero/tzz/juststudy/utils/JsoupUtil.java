package com.zero.tzz.juststudy.utils;

import org.jsoup.Jsoup;

/**
 * @author lucy
 * @date 2018-09-29 13:54
 * @description //TODO
 */

public class JsoupUtil {
    public static String stripHtml(String html) {
        return Jsoup.parse(html).text();
    }
}
