package org.example.concurrent.abc;

import java.util.concurrent.Exchanger;

public class ExchangeTest {
    public static void main(String[] args) {
        char[] numbers = "123456".toCharArray();
        char[] uppers = "ABCDEF".toCharArray();
        Exchanger<Character> exchanger=new Exchanger<>();

        new Thread(()->{
            for (int i = 0; i < numbers.length; i++) {
                try {
                    Character exchange = exchanger.exchange(numbers[i]);
                    System.out.println(exchange);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            }

        }).start();

        new Thread(()->{
            for (int i = 0; i < uppers.length; i++) {
                try {
                    Character exchange = exchanger.exchange(uppers[i]);
                    System.out.println(exchange);

                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }

            }
        }).start();
    }
}
