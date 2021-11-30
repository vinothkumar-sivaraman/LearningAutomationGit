package org.learningselenium.com;

import java.util.LinkedList;

public class Problem8 {

    public static void main(String[] args) {
        LinkedList<String> linkedList = new LinkedList<>();
        linkedList.add("linux");
        linkedList.add("apple");
        linkedList.add("android");
        linkedList.add("windows");

        System.out.println(linkedList);

        linkedList.addLast("blackberry");
        linkedList.addFirst("unix");

        System.out.println(linkedList);

        System.out.println(linkedList.get(2));

        System.out.println(linkedList.getFirst());
        System.out.println(linkedList.getLast());

        linkedList.set(3,"OS");
        System.out.println(linkedList);

        linkedList.remove(1);
        System.out.println(linkedList);


        linkedList.removeFirst();
        linkedList.removeLast();

        System.out.println(linkedList);

    }
}
