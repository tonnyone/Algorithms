package com.tonny.sort;

/**
 * <p>Description: </p>
 *
 * @author liushaoqing
 * @version 1.0
 * @date 2017-09-18
 */
public class BanInsertSort {

    public static void main(String[] args) {
        int[] arr = new int[]{10,2,9,34,3,4,8,5,6,6,2341};
        print(sort(arr));
    }

    public static int[] sort(int[] arr){
        for (int i=1;i<arr.length;i++){
            int start = 0;
            int end = i-1;
            while (start <= end){
                int mid = (start+end)/2;
                if(arr[i]<arr[mid]){
                    end = mid-1;
                }else{
                    start = mid+1;
                }
            }
            for (int j=i-1;j>=start;j--){
                int temp = arr[j];
                arr[j]=arr[j+1];
                arr[j+1]= temp;
            }
        }
        return arr;
    }

    public static void print(int[] arr){
        for (int i : arr) {
            System.out.println(i);
        }
    }
}
