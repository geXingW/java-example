package com.gexingw.leetcode.thread;

/**
 * @author GeXingW
 */
public class JoinPrint {

    public static void main(String[] args) {
        Thread t1 = new Thread(() -> System.out.println("A"));

        Thread t2 = new Thread(() -> System.out.println("B"));

        Thread t3 = new Thread(() -> System.out.println("C"));

        try {
            t1.start();
            t1.join();

            t2.start();
            t2.join();

            t3.start();
            t3.join();
        }catch (InterruptedException e){
            e.printStackTrace();
        }

        System.out.println("D");
    }

}
