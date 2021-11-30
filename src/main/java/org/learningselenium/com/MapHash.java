package org.learningselenium.com;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

public class MapHash {

    public static void main(String[] args) {
        HashMap<Integer,String> hmap = new HashMap<>();
        hmap.put(80124,"Lonetree");
        hmap.put(80110,"centennial");
        hmap.put(80123,"aurora");
        hmap.put(8013,"highlands");
        hmap.put(8013,"denver");
        hmap.put(null,"colaradosprings");
        hmap.put(null,"colaradosp");
        hmap.put(90909,null);
        hmap.put(89923,null);

        System.out.println(hmap);

        String s = hmap.get(80110);
        System.out.println("retrive method "+s);

        hmap.remove(80123);
        System.out.println(hmap);

        Set entries = hmap.entrySet();
        Iterator iterator = entries.iterator();
        while (iterator.hasNext())
        {
            Map.Entry next =(Map.Entry) iterator.next();
            System.out.println(next.getKey()+" "+next.getValue());
        }

    }
}
