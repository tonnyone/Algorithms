package com.tonny.jvm;

import sun.misc.Unsafe;

import javax.sound.midi.Soundbank;

/**
 * <p>Description: </p>
 *
 * @author liushaoqing
 * @version 1.0
 * @date 2018-03-02
 */
public class INTERN {

    public static void main(String[] args) {
        ccc();
    }

    public static void bbb() {
        String s = new String("1");
        s.intern();
        String s2 = "1";
        System.out.println(s == s2);
        String s3 = new String("1") + new String("1");
        s3.intern();
        String s4 = "11";
        System.out.println(s3 == s4);
    }

    public static void ccc(){
        String s1 = new StringBuilder("why").append("true").toString();
        System.out.println(s1==s1.intern());
        String s2 = new StringBuilder("why").append("true").toString();
        System.out.println(s2==s2.intern());
    }

    private static void test1(){
        String c = "qwe";   // string literal qwe goes into runtime cache
        String d = c.substring(1); // runtime string "we" is created
        d.intern();         // intern "we"; it has not been seen
        // yet so this version goes into the cache
        String e = "we";    // now we see the string literal, but
        // a value is already in the cache and so
        // the same instance as d is returned
        // (see ref below)
        System.out.println( e == d );  // returns true jdk1.6(false)
    }

    public static void test2() {
        String c = "qwe";   // string literal qwe goes into runtime cache
        String d = c.substring(1); // runtime string "we" is created
        String e = "we";    // now we see the string literal, this time
        // a value is NOT already in the cache and so
        // the string literal creates an object and
        // places it into the cache
        d.intern();         // has no effect - a value already exists
        // in the cache, and so it will return e
        System.out.println( e == d );  // returns false jdk1.6 false
        System.out.println( e == d.intern() );  // returns true jdk1.6 true
        System.out.println( e == d );  // still returns false jdk1.6 false
    }

    public static void test3(){

        String c = "qwe";   // string literal qwe goes into runtime cache
        String d = new String("qwe"); // runtime string "we" is created
//        d.intern();
        System.out.printf(String.valueOf(c == d));

    }
}
