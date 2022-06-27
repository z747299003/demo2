package org.example.algorithm;

import org.example.algorithm.BSExist;

/**
 * 等概率问题
 */
public class EqualsP {
    public static void main(String[] args) {
        int[] count = {0, 0, 0, 0, 0, 0,0,0,0,0};
        for (int i = 0; i < 1000000; i++) {
            int f = zeroToEight();
            count[f]++;
        }
        BSExist.printRes(count);
    }

    /**
     * 等概率返回 1 2 3 4 5 数字
     *
     * @return
     */
    public static int f() {
        int v = (int) (Math.random() * 5) + 1;
        return v;
    }

    /**
     * 等概率返回 0 1
     *
     * @return
     */
    public static int zeroOne() {
        int f = f();
        while (f == 3) {
            f = f();
        }
        if (f == 1 ||f==2) {
            return 0;
        }else  {
            return 1;
        }

    }

    public static int zeroToEight() {
        int f = ((zeroOne() << 2) + (zeroOne() << 1) + zeroOne());
        while(f==0){
            f = ((zeroOne() << 2) + (zeroOne() << 1) + zeroOne());
        }
        return f;
    }
}
