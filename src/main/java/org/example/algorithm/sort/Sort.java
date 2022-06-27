package org.example.algorithm.sort;

import org.example.algorithm.BSExist;


/**
 * Hello world!
 */
public class Sort {
    private static void swap(int[] ints, int i, int j) {
        int temp = ints[i];
        ints[i] = ints[j];
        ints[j] = temp;
    }

    public static void main(String[] args) {
        int[] ints = {7, 4, 3, 6, 2, 9, 20, 45, 33, 44, 67, 23, 22, 21, 29, 10, 61};
//        selectionSort2(ints);
//        bubbleSort2(ints);
        insertSort(ints);
//        selectionSort3(ints);
    }


    public static void selectionSort(int[] ints) {
        for (int i = 0; i < ints.length; i++) {
            for (int j = i + 1; j < ints.length; j++) {
                if (ints[i] > ints[j]) {
                    int temp = ints[j];
                    ints[j] = ints[i];
                    ints[i] = temp;
                }
            }
        }
        BSExist.printRes(ints);
    }

    public static void selectionSort2(int[] ints) {
        if (null == ints || ints.length < 2) {
            return;

        }

        /*
        0  ...N-1
        1  ...N-1
        ...
        N-2  N-1;
         */
        for (int i = 0; i < ints.length; i++) {

            int minValueIndex = i;
            for (int j = i + 1; j < ints.length; j++) {
                minValueIndex = ints[i] > ints[j] ? j : minValueIndex;
            }
            swap(ints, i, minValueIndex);
        }
        BSExist.printRes(ints);
    }

    public static void bubbleSort(int[] ints) {
        /*
        0   n-1
        0   n-2
        0   n-3
        0   n-(n-1)
         */
        for (int i = ints.length - 2; i >= 1; i--) {
            for (int j = 0; j <= i; j++) {
                if (ints[j] > ints[j + 1]) {
                    swap(ints, j, j + 1);
                }
            }
        }
        BSExist.printRes(ints);
    }

    public static void bubbleSort2(int[] ints) {
        /*
        0   n-1
        0   n-2
        0   n-3
        0   n-(n-1)
         */
        for (int end = ints.length - 1; end >= 1; end--) {
            for (int first = 0; first < end; first++) {
                if (ints[first] > ints[first + 1]) {
                    swap(ints, first, first + 1);
                }
            }
        }
        BSExist.printRes(ints);
    }

    public static void insertSort(int[] ints) {
        /**
         * 0  1
         * 0  2
         * 0  n-1
         */
        for (int i = 1; i < ints.length; i++) {
            for (int j = i - 1; j >= 0; j--) {
                if (ints[j + 1] < ints[j]) {
                    swap(ints, j + 1, j);
                } else {
                    break;
                }
            }
        }
        BSExist.printRes(ints);

    }

    public static void selectionSort3(int[] ints) {
        for (int i = 0; i < ints.length; i++) {
            int minValueIndex = i;
            for (int j = i + 1; j < ints.length; j++) {
                if (ints[minValueIndex] > ints[j]) {
                    minValueIndex = j;
                }
            }
            swap(ints, i, minValueIndex);
        }
        BSExist.printRes(ints);

    }
}
