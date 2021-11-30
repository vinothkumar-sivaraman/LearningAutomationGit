package org.learningselenium.com;

import java.util.LinkedHashSet;

public class SetLinkedHash {

    public static void main(String[] args) {
        LinkedHashSet<String> setcollections = new LinkedHashSet<>();
        setcollections.add("apple");
        setcollections.add("blackberry");
        setcollections.add("OS");
        setcollections.add("blackberry");
        setcollections.add("blueberry");
        setcollections.add("rasberry");
        setcollections.add(null);
        setcollections.add(null);

        System.out.println(setcollections);

        setcollections.remove("OS");
        System.out.println(setcollections);



    }
}
