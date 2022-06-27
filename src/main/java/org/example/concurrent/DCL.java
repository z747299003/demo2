package org.example.concurrent;

import com.sun.org.apache.bcel.internal.generic.INSTANCEOF;
import sun.security.jca.GetInstance;

public class DCL {
    private static /*volatile*/ DCL INSTANCE = null;

    private DCL() {
    }

    public static DCL getInstance() {
        if (INSTANCE == null) {
            synchronized (DCL.class) {
                if (INSTANCE == null) {
                    INSTANCE = new DCL();
                }
            }
        }
        return INSTANCE;
    }
}
