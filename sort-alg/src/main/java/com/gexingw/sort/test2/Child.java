package com.gexingw.sort.test2;

/**
 * @author GeXingW
 */
public class Child extends Parent {

    @Override
    public String test(String name) {
        return "ok";
    }

    protected String test2(String name) {
        return "Child test2";
    }

    private Object test2(Integer name) {
        return "";
    }

}
