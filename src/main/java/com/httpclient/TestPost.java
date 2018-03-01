package com.httpclient;

import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.message.BasicNameValuePair;
import org.apache.http.util.EntityUtils;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * @name:
 * @author:liangxian.chen@hand-china.com
 * @date: Created in 14:08 2018/02/07
 * @Modified By:
 * @description：
 * 城市天气数据获取接口 http://blog.csdn.net/u011331731/article/details/72765410
 */
public class TestPost {
    public static void main(String[] args){
        new Post().start();
    }
}

class Post extends Thread{
    HttpClient client = HttpClients.createDefault();
    @Override
    public void run() {
        String uri="http://wthrcdn.etouch.cn/WeatherApi";
        HttpPost post = new HttpPost(uri);
        try {

            List<BasicNameValuePair> pairs = new ArrayList<BasicNameValuePair>();
            BasicNameValuePair pair = new BasicNameValuePair("citykey","101010100");
            pairs.add(pair);


            post.setEntity(new UrlEncodedFormEntity(pairs,"UTF-8"));
            HttpResponse response = client.execute(post);
            HttpEntity entity = response.getEntity();
            String result = EntityUtils.toString(entity,"UTF-8");
            System.out.println(result);

        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
