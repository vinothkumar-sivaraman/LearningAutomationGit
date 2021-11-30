package org.learningselenium.com;

import java.util.Iterator;
import java.util.ListIterator;
import java.util.Vector;

public class ListVector {

    public static void main(String[] args) {
        Vector<Integer> vectorlist = new Vector<>(4);
        vectorlist.add(2);
        vectorlist.add(3);
        vectorlist.add(4);
        vectorlist.add(5);

        System.out.println(vectorlist.size());
        System.out.println("intial capacity"+vectorlist.capacity());

        vectorlist.add(6);
        System.out.println("added element to check the capacity"+vectorlist.capacity());

        vectorlist.add(2);
        vectorlist.add(3);
        vectorlist.add(4);
        vectorlist.add(5);

        vectorlist.remove(2);
        System.out.println("after removing second index"+vectorlist);

        System.out.println(vectorlist.capacity());

        vectorlist.set(0,23423432);
        System.out.println("after modifiying the vector list"+vectorlist);


        Integer integer = vectorlist.get(0);
        System.out.println(integer);

        Iterator<Integer> iterator = vectorlist.iterator();
        while (iterator.hasNext())
        {
            System.out.println(iterator.next());
        }

        System.out.println("***********************************************");

        ListIterator<Integer> integerListIterator = vectorlist.listIterator();
        while(integerListIterator.hasNext())
        {
            System.out.println(integerListIterator.next());
        }

        System.out.println("***********************************************");
        while (integerListIterator.hasPrevious())
        {
            System.out.println(integerListIterator.previous());
        }

    }
}
