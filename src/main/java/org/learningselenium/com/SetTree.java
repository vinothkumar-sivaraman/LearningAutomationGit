package org.learningselenium.com;

import java.util.Iterator;
import java.util.TreeSet;

public class SetTree {

    public static void main(String[] args) {
        TreeSet<String> setcollections = new TreeSet<>();
        setcollections.add("zeee");
        setcollections.add("blackberry");
        setcollections.add("os");
        setcollections.add("blackberry");
        setcollections.add("blueberry");
        setcollections.add("rasberry");
        setcollections.add("apple");

        System.out.println(setcollections);

        setcollections.remove("apple");
        System.out.println(setcollections);


        Iterator<String> iterator = setcollections.iterator();
        while (iterator.hasNext())
        {
            System.out.println(iterator.next());
        }
    }
}
