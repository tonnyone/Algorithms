package com.tonny.sort.test_1_1;

import edu.princeton.cs.algs4.StdOut;

/**
 * Created by tonny on 2016/8/11.
 */
public class Test_1_1_22 {

    public static void main(String[] args) {

        int[] arr = {2,3,5,7,9,11,445,67,88,999,10000};
        int a = rank(arr,3);
        StdOut.println(a);
    }
    public static int rank(int[] arr,int key){
        return rankiter(arr,key,0,arr.length-1,0);
    }

    public  static int rankiter(int[] arr,int key,int start,int end,int deep){

        deep+=1;
        StdOut.printf("%"+deep+"s,%d",start,end);
        StdOut.println();
        int mid = (end-start)/2+start;
        while(end > start){
            if(key < arr[mid]){
                end = mid;
                return rankiter(arr,key,start,end,deep);
            }else if (key > arr[mid]){
                start = mid;
                return rankiter(arr,key,start,end,deep);
            }else {
                return mid;
            }
        }
        return -1;
    }
}

