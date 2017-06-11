package com.iflyer;

import us.codecraft.webmagic.Spider;

/**
 * Created by mac on 2017/6/11.
 * 跌掉网
 */
public class MovieReptile {
    public static void main(String[] args) {
        Spider.create(new MoviePageProcessor()).addUrl("http://www.kb20.cc/").thread(50).run();
    }
}
