package com.pity.punto_de_venta_test.db;

import android.os.StrictMode;

public class AndroidHelper {

    protected static void AddStrictMode(){
        if (android.os.Build.VERSION.SDK_INT > 9) {
            StrictMode.ThreadPolicy policy = new StrictMode.ThreadPolicy.Builder().permitAll().build();
            StrictMode.setThreadPolicy(policy);
        }
    }

}
