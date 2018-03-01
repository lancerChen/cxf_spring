package com.json;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

/**
 * @name:
 * @author:liangxian.chen@hand-china.com
 * @date: Created in 15:11 2018/02/06
 * @Modified By:
 * @description：
 */
public class CreateJSON {
    public static void main(String[] args){
        JSONObject object = new JSONObject();
        object.put("pop",true);

        JSONArray array = new JSONArray();
        JSONObject lan1 = new JSONObject();
        lan1.put("id",1);
        lan1.put("name","Java");
        lan1.put("IDE","Idea");
        array.add(lan1);

        JSONObject lan2 = new JSONObject();
        lan2.put("id",2);
        lan2.put("name","C#");
        lan2.put("IDE","Visual Studio");
        array.add(lan2);

        JSONObject lan3 = new JSONObject();
        lan3.put("id",3);
        lan3.put("name","Python");
        lan3.put("IDE","Pycharm");
        array.add(lan3);

        JSONObject lan4 = new JSONObject();
        lan4.put("id",4);
        lan4.put("name","Swift");
        lan4.put("IDE","XCode");
        array.add(lan4);

        object.put("languages",array);
        object.put("cat","IT");

        System.out.println(object.toJSONString());
    }
}
