package org.sversh.algorithms.binarytree;

import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import java.util.TreeSet;

import org.apache.commons.lang3.RandomStringUtils;

public class SortingManyStrings {

    public static void main(String[] args) {
        // TODO Auto-generated method stub
        SortingManyStrings test = new SortingManyStrings();
        List<String> strings = test.createManyStrings(5000000);
        Date start = new Date();
        System.out.println("start time for tree set: " + start);
        TreeSet<String> ts = new TreeSet<String>(strings);
        Date end = new Date();
        System.out.println("end time for tree set: " + end);
        System.out.println("duration: " + (end.getTime() - start.getTime())/1000 + " sec.");
        printFirst(ts, 10);
    }

    private static void printFirst(TreeSet<String> ts, int count) {
        int i = 0;
        Iterator<String> it = ts.iterator();
        while (i < 10) {
            System.out.println(i + it.next());
            i++;
        }
    }

    private List<String> createManyStrings(int count) {
        Date start = new Date();
        System.out.println("start time: " + start);
        List<String> result = new ArrayList<>();
        for (int i = 0; i < count; i++) {
            String str = createString(40);
            result.add(str);
        }
        Date end = new Date();
        System.out.println("end time: " + end);
        System.out.println("duration: " + (end.getTime() - start.getTime())/1000 + " sec.");
        return result;
    }

    private String createString(int strLength) {
        return RandomStringUtils.randomAlphanumeric(strLength);
    }

}
