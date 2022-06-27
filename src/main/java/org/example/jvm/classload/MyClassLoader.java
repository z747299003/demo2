package org.example.jvm.classload;

import java.io.*;

public class MyClassLoader extends ClassLoader {
    @Override
    protected Class<?> findClass(String name) {
        try {
            File f = new File("d:/workspace/demo2/", name.replace(".", "/").concat(".class"));
            FileInputStream fileInputStream = new FileInputStream(f);
            ByteArrayOutputStream baos = new ByteArrayOutputStream();
            int b = 0;
            while (true) {
                if (!((b = fileInputStream.read()) != 0)) break;
                baos.write(b);
            }
            byte[] bytes = baos.toByteArray();
            return this.defineClass(name, bytes, 0, bytes.length);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public static void main(String[] args) throws ClassNotFoundException {
        MyClassLoader myClassLoader=new MyClassLoader();
        Class<?> aClass = myClassLoader.loadClass("org.example.algorithm.BSExist");
        System.out.println(aClass.getName());
    }
}
