package com.gexingw.concurrent;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.CyclicBarrier;

/**
 * @author GeXingW
 */
public class CyclicBarrierApp {

    public static void main(String[] args) {
//        CyclicBarrier cyclicBarrier = new CyclicBarrier(10, () -> {
//            System.out.println("准备完毕！");
//        });
//
//        cyclicBarrier.await();

        HashMap<String, String> hashMap = new HashMap<>();
        Set<Map.Entry<String, String>> entries = hashMap.entrySet();
        for (Map.Entry<String, String> entry : entries) {
            String key = entry.getKey();
            String value = entry.getValue();
        }
    }

}
