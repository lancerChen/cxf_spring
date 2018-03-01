package com.collection;

import java.util.HashSet;
import java.util.Set;
import java.util.TreeSet;

public class SetDemo {
    public static void main(String[] args){
        Set<String> set = new TreeSet<String>();
        set.add("A");set.add("D");set.add("E");set.add("F");set.add("B");set.add("C");
        for (String str :set){
            System.out.println(str);
        }
    }
}
