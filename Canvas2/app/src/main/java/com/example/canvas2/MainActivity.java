package com.example.canvas2;

import android.os.Bundle;
import android.app.Activity;

public class MainActivity extends Activity {
    @Override
    protected void onCreate (Bundle b){
        super.onCreate(b);
        Lienzo l = new Lienzo(this);
        setContentView(l);
    }


}
