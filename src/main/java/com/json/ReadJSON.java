package com.json;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import java.io.FileReader;
import java.io.IOException;

/**
 * @name:
 * @author:liangxian.chen@hand-china.com
 * @date: Created in 16:01 2018/02/06
 * @Modified By:
 * @description：
 */
public class ReadJSON {
    public static void main(String[] args){

        try {
            JSONParser parser = new JSONParser();
            JSONObject object = (JSONObject) parser.parse(new FileReader("json.txt"));
            System.out.println("cat="+object.get("cat"));
            System.out.println("pop="+object.get("pop"));

            JSONArray array = (JSONArray) object.get("languages");
            for (int i = 0; i <array.size() ; i++) {
                System.out.println("-----------------");
                JSONObject subObject = (JSONObject) array.get(i);
                System.out.println("id="+subObject.get("id"));
                System.out.println("name="+subObject.get("name"));
                System.out.println("IDE="+subObject.get("IDE"));
            }

        } catch (IOException e) {
            e.printStackTrace();
        } catch (ParseException e) {
            e.printStackTrace();
        }
    }
}
