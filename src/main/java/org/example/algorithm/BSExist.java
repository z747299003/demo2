package org.example.algorithm;

import org.example.algorithm.sort.Sort;

import java.util.Arrays;

public class BSExist {
    public static void main(String[] args) {
        int[] ints = generateRandomArray(100,100);
        printRes(ints);
        Sort.bubbleSort2(ints);
        printRes(ints);
        System.out.println(mostLeftNoLessNumberIndex(ints,8));
    }
    public static boolean  find(int[] arr,int num){
        if(arr==null ||arr.length==0){
            return false;
        }
        int min=0;
        int max=arr.length-1;

        while(min<=max) {
            int mid= (max+min)/2;
            if (arr[mid] == num) {
                return true;
            } else if (arr[mid] > num) {
                max = mid-1;
            } else {
                min = mid+1;
            }
        }
        return false;
    }

    /**
     * 返回 arr数组中 >=num的最左的位置
     * @param arr
     * @param num
     * @return
     */
    public static int mostLeftNoLessNumberIndex(int[] arr,int num){
        if(null==arr||arr.length==0){
            return -1;
        }
        int L=0;
        int R=arr.length-1;
        int ans=-1;
        while(L<=R){
            int mid=(L+R)/2;
            if(arr[mid]>=num){
                ans=mid;
                R=mid-1;
            } else{
                L=mid+1;
            }
        }
        return ans;
    }

    /**
     *
     * @param arr
     * @param num
     */
    public static  int mostRightIndexByNumberLE(int[] arr,int num){
        if(null==arr || arr.length==0){
            return -1;
        }
        int min=0;
        int max= arr.length-1;
        int ans=-1;
        while(min<=max){
            int mid=(min+max)/2;
            if(arr[mid]<=num){
                ans=mid;
                max=mid-1;
            }else {

            }
        }
        return ans;
    }
    /**
     * 返回随机数组
     * @param maxSize 数组的最大长度
     * @param maxValue 数组的最大值
     * @return
     */
    public static int[] generateRandomArray(int maxSize,int maxValue){
        int size = (int)(Math.random() * maxSize) + 1;
        int[] array=new int[size];
        for (int i = 0; i < size; i++) {
            int value = (int)(Math.random() * maxValue) + 1;
            array[i]=value;
        }
        return array;
    }

    public static void printRes(int[] arr){
        Arrays.stream(arr).forEach(item ->System.out.print(item+" "));
        System.out.println("");
    }

    /**
     *
     * @param arr 无序 相邻不相等
     */
    public static void localMinimum(int[] arr){

    }
}
