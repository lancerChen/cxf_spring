package com.url;


import java.io.*;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

/**
 * @name:
 * @author:liangxian.chen@hand-china.com
 * @date: Created in 17:42 2018/02/06
 * @Modified By:
 * @description：有BUG，报错:405 for URL. at com.url.ReadByPost.run(TestPost.java:43)
 */
public class TestPost {
    public static void main(String[] args){
        new ReadByPost().start();
    }
}

class ReadByPost extends Thread{
    @Override
    public void run() {

        try {
            String urlString ="http://weatherapi.market.xiaomi.com/wtr-v2/weather";
            URL url = new URL(urlString);
            HttpURLConnection connection = (HttpURLConnection) url.openConnection();
            connection.setRequestProperty("encoding", "UTF-8");
            connection.addRequestProperty("Content-Type","application/json");
            connection.setDoInput(true);
            connection.setDoOutput(true);
            connection.setRequestMethod("POST");

            OutputStream os = connection.getOutputStream();
            OutputStreamWriter osw = new OutputStreamWriter(os);
            BufferedWriter bw = new BufferedWriter(osw);
            bw.write("cityId=101121301");
            bw.flush();
            System.out.println(bw.toString());

            InputStream is = connection.getInputStream();
            InputStreamReader isr = new InputStreamReader(is);
            BufferedReader br = new BufferedReader(isr);

            String line;
            StringBuilder builder = new StringBuilder();
            while ((line=br.readLine())!=null){
                builder.append(line);
            }
            br.close();
            isr.close();
            is.close();
            bw.close();
            osw.close();
            os.close();

            System.out.println("thing"+builder.toString());


        } catch (MalformedURLException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
