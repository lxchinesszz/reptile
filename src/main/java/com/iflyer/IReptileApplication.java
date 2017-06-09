package com.iflyer;

import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.io.*;

/**
 * @Package: com.iflyer
 * @Description: 项目入口
 * @Url:http://blog.csdn.net/championhengyi/article/category/6731201
 * @URL:dom解析工具jsoup:https://try.jsoup.org/
 * @author: liuxin
 * @date: 17/6/9 上午10:39
 */
public class IReptileApplication {
    //自动补全返回值类型 command+ait+v
    public static void main(String[] args) throws Exception {
//        CloseableHttpClient closeableHttpClient = HttpClients.createDefault();
//        //创建请求Get实例
//        HttpGet httpGet = new HttpGet("https://www.baidu.com");
//
//        //设置头部信息进行浏览器模拟行为
//        httpGet.setHeader("Accept", "text/html,application/xhtml+xml," +
//                "application/xml;q=0.9,image/webp,*/*;q=0.8");
//        httpGet.setHeader("Accept-Encoding", "gzip, deflate, sdch, br");
//        httpGet.setHeader("Accept-Language", "zh-CN,zh;q=0.8");
//        //httpGet.setHeader("Cookie", "......");
//        httpGet.setHeader("User-Agent", "Mozilla/5.0 (X11; Linux x86_64) AppleWebKit/537.36" +
//                " (KHTML, like Gecko) Chrome/55.0.2883.87 Safari/537.36");
//        String entity = "";
//        try {
//            //客户端执行httpGet方法，返回响应
//            CloseableHttpResponse closeableHttpResponse = closeableHttpClient.execute(httpGet);
//            //得到服务响应状态码
//            if (closeableHttpResponse.getStatusLine().getStatusCode() == 200) {
//                //得到响应实体
//                entity = EntityUtils.toString(closeableHttpResponse.getEntity(), "utf-8");
//            } else {
//                //如果是其他状态码则做其他处理，这部分知识博主也还没有系统的学习，以后给大家补上
//                //对于服务器返回的各个状态码的含义希望大家能了解一下
//            }
//        } catch (ClientProtocolException e) {
//            e.printStackTrace();
//        } catch (IOException e) {
//            e.printStackTrace();
//        }


    }


}