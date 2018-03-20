package com.tonny.sort;

/**
 * Created by tonny on 2016/4/17.
 */
public class MergeSort {


    static int[] x = {10,4,6,3,5,2,8,5,23,6,576,90,78,1};

    public static void main(String[] args) {
        merge_sort(x,0,x.length-1);
        for (int i : x) {
            System.out.println(i);
        }
    }

     static void merge_sort(int[] arr,int a,int b){

        int center = (a+b)/2;
        if(a<b){
            merge_sort(arr,a,center);
            merge_sort(arr,center+1,b);
            merge(arr,a,center,b);
        }

    }
    static void merge(int[] a,int p,int q,int r){

        int n1 = q-p+1;
        int n2 = r-q;
        int[] L = new int[n1+1];
        int [] R = new int[n2+1];
        for (int i = 0; i < L.length-1; i++) {
            L[i] = a[p+i];
        }
        for (int i = 0; i < R.length-1 ; i++) {
            R[i] = a[q+i+1];
        }
        L[L.length-1] = Integer.MAX_VALUE;
        R[R.length-1] = Integer.MAX_VALUE;
        int lflag = 0;
        int rflag = 0;
        int all = p;
        while(all<r+1) {
            if (L[lflag] > R[rflag]) {
                a[all] = R[rflag];
                rflag++;
            } else {
                a[all] = L[lflag];
                lflag++;
            }
            all++;
        }
    }
}
