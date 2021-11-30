package org.learningselenium.com;

import java.util.HashSet;
import java.util.Iterator;

public class SetHash {

    public static void main(String[] args) {
        HashSet<String> setcollections = new HashSet<>();

        setcollections.add("apple");
        setcollections.add("blackberry");
        setcollections.add("OS");
        setcollections.add("blackberry");
        setcollections.add(null);
        setcollections.add(null);

        setcollections.remove("OS");
        System.out.println(setcollections);

        Iterator<String> iterator = setcollections.iterator();
        while(iterator.hasNext())
        {
            System.out.println(iterator.next());
        }


        System.out.println(setcollections);

    }
}
