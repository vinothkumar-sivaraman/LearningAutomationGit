package org.learning.com;

import java.util.*;

public class MapLinkedHash {

    public static void main(String[] args) {
/*
        LinkedHashMap<String,Integer> linkedHashMap = new LinkedHashMap<>();
        linkedHashMap.put("centenial",80123);
        linkedHashMap.put("lonetree",80124);
        linkedHashMap.put("denver",901234);
        linkedHashMap.put(null,90234);
        linkedHashMap.put("springs",null);
        linkedHashMap.put("aurora",null);

        System.out.println(linkedHashMap);

       Set entries =  linkedHashMap.entrySet();
        Iterator iterator = entries.iterator();
        while (iterator.hasNext())
        {
            Map.Entry next = (Map.Entry) iterator.next();
            System.out.println(next.getKey()+"  "+next.getValue());
        }
*/

        TreeMap<String,String> treeMap = new TreeMap<>();
        treeMap.put("zee","television");
        treeMap.put("vijay","shows");
        treeMap.put("sun",",movies");
        treeMap.put("sunmusic","series");
        //treeMap.put(null,"music");
        treeMap.put("sun","news");

        System.out.println(treeMap);


    }
}
