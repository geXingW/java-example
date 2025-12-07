package com.gexingw.concurrent;

import java.util.HashSet;

/**
 * @author GeXingW
 */
public class StringBuilderApp  {

    public static void main(String[] args) {
        StringBuffer sb = new StringBuffer();
        sb.append("hello");
        sb.append("world");
        System.out.println(sb.toString());

        HashSet<String> hashSet = new HashSet<>();
        hashSet.add("a");
    }

}
