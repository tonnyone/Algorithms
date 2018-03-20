package com.tonny.sort;

/**
 * Created by tonny on 2016/4/8.
 */
public class SelectSort {

    public static void main(String[] args) {
        int[] a = { 1,9,3,4,6,99,12,68,23,1};
        a = sort(a);
        for (int i : a) {
            System.out.println(i);
        }
    }

    public static int[] sort(int[] a){

        for (int i = 0; i <a.length-1 ; i++) {
            int lowest = a[i];
            for (int j = i+1; j <a.length ; j++) {
                if(lowest>a[j]){
                    int temp = lowest;
                    lowest=a[j];
                    a[j]=temp;
                }
            }
            a[i] = lowest;
        }
        return a;
    }
}
