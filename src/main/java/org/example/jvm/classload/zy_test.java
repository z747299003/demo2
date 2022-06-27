package org.example.jvm.classload;

public class zy_test {
    public static void main(String[] args) {
        String[] names={"ABC","XYZ"};
        String s=names[1];
        names[1]="cat";
        System.out.println(s);
    }
}
