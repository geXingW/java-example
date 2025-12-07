package com.gexingw.leetcode;

import java.util.HashMap;
import java.util.Map;

/**
 * @author GeXingW
 */
public class LeeCode13 {

    public static void main(String[] args) {
        String s = "IVI";

        System.out.println(romanToInt(s));
    }

    private static int romanToInt(String s) {
        Map<Character, Integer> hashMap = new HashMap<>();
        hashMap.put('I', 1);
        hashMap.put('V', 5);
        hashMap.put('X', 10);
        hashMap.put('L', 50);
        hashMap.put('C', 100);

        int num = 0;
        for (int i = 0; i < s.length(); i++) {
            if (i < s.length() - 1 && s.charAt(i) < s.charAt(i + 1)) {
                num -= hashMap.getOrDefault(s.charAt(i), 0);
            } else {
                num += hashMap.getOrDefault(s.charAt(i), 0);
            }
        }

        return num;
    }

}
