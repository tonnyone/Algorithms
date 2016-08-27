package com.tonny.sort.test_1_1;

/**
 * Created by tonny on 2016/8/11.
 */
public class Test_1_1_20 {

    public static void main(String[] args) {
        long result = test(30);
        System.out.println(result);
    }
    private static long test(long i){

        System.out.println(i);
        if(i==2L){
            return 1;
        }else{
            return test(i-1L) * i;
        }
    }
}
