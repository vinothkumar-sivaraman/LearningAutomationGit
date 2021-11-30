package org.learningselenium.com;

import org.apache.commons.compress.harmony.unpack200.bytecode.forms.NarrowClassRefForm;

import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

public class Problem7 {

    public static void main(String[] args) {

        ArrayList<String> arrayList = new ArrayList<>();
        arrayList.add("linux");
        arrayList.add("android");
        arrayList.add("apple");

        Collections.sort(arrayList);
        System.out.println("after sort"+arrayList);

        System.out.println(arrayList);

        arrayList.set(0,"windows");

        System.out.println("after modification"+ arrayList);

        arrayList.remove(0);

        System.out.println("after deletion"+arrayList);




        System.out.println(arrayList.get(1));

        for(String value: arrayList)
        {
            System.out.println(value);
        }


    }
}
