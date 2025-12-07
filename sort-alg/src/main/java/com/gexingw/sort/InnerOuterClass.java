package com.gexingw.sort;

/**
 * @author GeXingW
 */
public class InnerOuterClass {

    private String outerName;

    public static void main(String[] args) {

    }

    public void testInner() {
        class Inner {
            private String innerName;

            public void setName(String name) {
                outerName = "a";
                this.innerName = name;
                outerMethod();
            }
        }

        Inner inner = new Inner();
        inner.setName("a");
    }

    public void outerMethod() {
        System.out.println("outer method.");
    }

}
