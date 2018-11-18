package com.tonny.sort;

/**
 * Created by tonny on 2016/4/8.
 */
public class AddTest {

    public static void main(String[] args) {
        int[] a  = {1,1,1,0,1,0,1,1,1};
        int[] b  = {1,1,1,0,1,0,1,1,0};
        int[] c = add(a,b);
        for (int i : c) {
            System.out.print(i);
        }
    }

    public static int[] add(int[] a,int[] b ){

        int[] c = new int[a.length+1];
        for (int i = a.length-1; i >=0 ; i--) {
            int value = a[i]+b[i]+c[i+1];
            if(value>1){
                c[i]=value/2;
            }
            c[i+1] = (value)%2;
        }
        return c;
    }
}
