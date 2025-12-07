package com.gexingw.concurrent;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @author GeXingW
 */
public class ThreadLocalApp {


    public static void main(String[] args) {
        HashMap<String, Object> hashMap = new HashMap<>();
        hashMap.put("key", "value");
        ThreadLocal<Map<String, Object>> threadLocal = new ThreadLocal<>();
        threadLocal.set(hashMap);
        threadLocal.get();

        ThreadLocal<Map<String, Object>> threadLocal2 = ThreadLocal.withInitial(HashMap::new);
        ReentrantLock reentrantLock = new ReentrantLock();
        reentrantLock.tryLock();

        reentrantLock.unlock();
    }

}
