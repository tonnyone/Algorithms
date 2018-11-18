package com.tonny.sort.test_1_1;

import edu.princeton.cs.algs4.StdOut;

/**
 * Created by tonny on 2016/8/22.
 */
public class Test_1_1_24 {

    public static void main(String[] args) {
        StdOut.print(gy(1111111,1234567));
    }

    private static int gy(int a,int b){
        StdOut.printf("%d,%d\n",a,b);
        if(a%b !=0){
            return gy(b,a%b);
        }else{
            return b;
        }
    }}