package com.collection;

import java.util.ArrayList;
import java.util.List;

public class ListDemo {
    public static void main(String[] args){
        List<String> lists =new ArrayList<String>();
        lists.add("I");
        lists.add("LOVE");
        lists.add("JAVA");
        for (String str: lists){
            System.out.println(str);
        }
        System.out.println("-----After delete-----");
        lists.remove(1);
        for (String str: lists){
            System.out.println(str);
        }

        System.out.println("集合是否为空： "+lists.isEmpty());

        System.out.println("集合中某元素所在的索引值： "+lists.indexOf("JAVA"));

    }
}
