package com.gexingw.sort;

import java.util.Arrays;
import java.util.OptionalInt;
import java.util.stream.IntStream;

/**
 * @author GeXingW
 */
public class StreamTest {

    public static void main(String[] args) {
        int[] unSort = new int[]{5, 3, 1, 2, 4, 6, 9, 10, 8, 7};

//        IntStream stream = Arrays.stream(unSort).;
//
//        Arrays.stream()

        String str = new String("123");
        System.out.println(new StringBuffer("acd").insert(1, "b").toString());

        OptionalInt first = Arrays.stream(unSort).filter(num -> num == 5).findFirst();
        if (first.isPresent()) {
            System.out.println(first.getAsInt());
        } else {
            System.out.println("未找到！");
        }
    }

}
