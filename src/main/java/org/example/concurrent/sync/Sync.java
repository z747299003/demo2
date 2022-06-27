package org.example.concurrent.sync;

import org.openjdk.jol.info.ClassLayout;

/**
 * Hello world!
 */
public class Sync {
    public static void main(String[] args) {
        System.out.println("Hello World!");
        Object o = new Object();
        //System.out.println(ClassLayout.parseInstance(o).toPrintable());
        //o.hashCode();
        //注意查看一下生成的字节码有什么不同
        synchronized (o){
            System.out.println(ClassLayout.parseInstance(o).toPrintable());
        }
    }
}
