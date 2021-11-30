package org.learning.com;

import org.openqa.selenium.WebElement;

import java.util.Hashtable;
import java.util.Iterator;
import java.util.Set;

public class TableHash {

    public static void main(String[] args) {
        Hashtable<Integer,Integer> htable = new Hashtable<>();
        htable.put(1,100);
        htable.put(2,200);
        htable.put(3,300);
        htable.put(4,400);

        System.out.println(htable);

        Set entries = htable.keySet();
        Iterator iterator = entries.iterator();
        while (iterator.hasNext())
        {
            Integer next = (Integer)iterator.next();// key value
           // System.out.println(htable.get(next)+" "+next);
            System.out.println(next+"  "+htable.get(next));
        }
    }
}
