package org.example.algorithm.class08;

public class MergeSort {
    public static void main(String[] args) {
        int[] arr = {5, 7, 1, 3, 9, 34, 56, 21};
        process(arr, 0, arr.length - 1);
        for (int i = 0; i < arr.length; i++) {
            System.out.println(arr[i]);
        }
    }

    public static void process(int[] arr, int L, int R) {
        if (L == R) {
            return;
        }
        //这里注意
        int mid = L + ((R - L) >> 1);
        process(arr, L, mid);
        process(arr, mid + 1, R);

        int[] res = new int[R - L + 1];
        int lPoint = L;
        int rPoint = mid + 1;
        int resPoint = 0;
        while (lPoint <= mid && rPoint <= R) {
            /*if (arrL[lPoint] <= arrR[rPoint]) {
                res[resPoint++] = arrL[lPoint++];
            } else {
                res[resPoint++] = arrR[rPoint++];
            }*/
            res[resPoint++] = arr[lPoint] <= arr[rPoint] ? arr[lPoint++] : arr[rPoint++];
        }

        while (rPoint <= R) {
            res[resPoint++] = arr[rPoint++];
        }


        while (lPoint <= mid) {
            res[resPoint++] = arr[lPoint++];
        }

        for (int i = 0; i < res.length; i++) {
            arr[L + i] = res[i];
        }
    }
}
