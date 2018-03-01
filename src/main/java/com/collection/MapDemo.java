package com.collection;

import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

public class MapDemo {
    public static void main(String[] args){
        Map<Integer,String> map = new HashMap<Integer, String>();
        map.put(0,"hand");
        map.put(1,"HAP");
        map.put(2,"Java");
        map.put(3,"Idea");
        map.put(4,"javascript");
        //print the key
        Collection<Integer> i = map.keySet();
        Iterator<Integer> iterator = i.iterator();
        while (iterator.hasNext()){
            System.out.println(iterator.next());
        }
        //print the value
        Collection<String> s=map.values();
        Iterator<String> iter = s.iterator();
        while (iter.hasNext()){
            System.out.println(iter.next());
        }
    }
}
