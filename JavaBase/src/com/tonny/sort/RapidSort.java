package com.tonny.sort;

/**
 * <p>Description: </p>
 *
 * @author liushaoqing
 * @version 1.0
 * @date 2017-09-19
 */
public class RapidSort {

    public static void main(String[] args) {
        int[] arr = new int[]{8,2,3,5,4,6,7,9,1};
        print(sort(arr,0,arr.length-1));
    }

    public static int[] sort(int[] arr,int start,int end){

        if(start>=end)
            return arr;
        int i = start;
        int j = end;
        int flag = arr[end];
        while(i<j){
            while(i<j && arr[i]<=flag ) {
                i++;
            }
            arr[j] = arr[i];
            while(i<j && arr[j]>=flag ){
                j--;
            }
            arr[i] = arr[j];
        }
        print(arr);
        System.out.println("i:"+i);
        System.out.println("j:"+j);
        arr[i] = flag;

        sort(arr,start,i-1);
        sort(arr,i+1,end);
        return arr;
    }

    public static void print(int[] arr){
        for (int i : arr) {
            System.out.print(i);
        }
        System.out.println();
    }
}
