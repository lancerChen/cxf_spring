package com.collection;

import java.util.List;
import java.util.Vector;

public class ListDemo01 {
    public static void main(String[] args){
        List<String> vector = new Vector<String>();
        vector.add("J");
        vector.add("A");
        vector.add("V");
        vector.add("A");
        for (String ve :vector){
            System.out.print(ve);
        }
    }
}
