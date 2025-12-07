package com.gexingw.leetcode.thread;

/**
 * @author GeXingW
 */
public class TakeTurnPrint {

    private static int flag = 0;

    private static int num = 1;

    public static void main(String[] args) {
        Printer printer = new Printer();

        new Thread(() -> {
            try {
                printer.print1();
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }).start();

        new Thread(() -> {
            try {
                printer.print2();
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }).start();
    }

    public static class Printer {
        private int count = 1;

        private int flag = 0;

        public synchronized void print1() throws InterruptedException {
            for (int i = 0; i < 50; i++) {
                while (flag != 0) {
                    wait();
                }

                System.out.println(num++);
                flag = 1;
                notifyAll();
            }
        }

        public synchronized void print2() throws InterruptedException {
            for (int i = 0; i < 50; i++) {
                while (flag == 0) {
                    wait();
                }

                System.out.println(num++);
                flag = 0;
                notifyAll();
            }
        }

    }

}
