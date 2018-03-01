package com.collection;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class IteratorDemo {
    public static void main(String[] args){
        List<Integer> list = new ArrayList<Integer>();
        for (int i=0;i<10;i++){
            list.add(i);
        }
        System.out.print(list);
        Iterator<Integer> iterator = list.iterator();
        while (iterator.hasNext()){
            Integer num3=3;
            Integer num = iterator.next();
            if (num3.equals(num)){
                iterator.remove();

            }else{
                System.out.println(num);

            }
        }
    }
}
