package com.url;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;

/**
 * @name:
 * @author:liangxian.chen@hand-china.com
 * @date: Created in 17:13 2018/02/06
 * @Modified By:
 * @description：
 */
public class TestGet {
    public static void main(String[] args){
        new ReadByGet().start();
    }
}
class ReadByGet extends Thread{
    @Override
    public void run() {
        String urlString="http://weatherapi.market.xiaomi.com/wtr-v2/weather?cityId=101121301";

        try {
            URL url = new URL(urlString);
            URLConnection connection = url.openConnection();
            InputStream is = connection.getInputStream();
            InputStreamReader isr = new InputStreamReader(is,"UTF-8");
            BufferedReader br = new BufferedReader(isr);

            String line;
            StringBuilder builder = new StringBuilder();
            while ((line=br.readLine())!=null){
                builder.append(line);
            }
            br.close();
            isr.close();
            is.close();

            System.out.println(builder.toString());


        } catch (MalformedURLException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
