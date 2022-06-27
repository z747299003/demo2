package org.example.collection;

import java.util.Arrays;
import java.util.Iterator;
import java.util.Vector;

/**
 * Hello world!
 */
public class IteratorTest {
    public static void main(String[] args) {
        System.out.println("Hello World!");
        Vector<String> v=new Vector<>();
        v.add("q");
        String s = v.get(1);
        v.addAll(Arrays.asList("1","2"));
        Iterator<String> iterator = v.iterator();
    }
}
