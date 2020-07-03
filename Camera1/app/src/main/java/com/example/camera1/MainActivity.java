package com.example.camera1;

import java.io.*;
import java.util.Date;
import java.text.SimpleDateFormat;

import android.media.MediaScannerConnection;
import android.os.*;
import android.app.Activity;
import android.content.Intent;
import android.net.Uri;
import android.provider.MediaStore;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import androidx.core.content.FileProvider;

public class MainActivity extends Activity {
    private final String ruta =
            Environment.getExternalStoragePublicDirectory(Environment.DIRECTORY_PICTURES) +
                    "/misfotos/";
    private File f = new File(ruta);
    private Button jbn;

    @Override
    protected void onCreate(final Bundle b) {
        super.onCreate(b);
        setContentView(R.layout.activity_main);
        jbn = (Button) findViewById(R.id.xbn);
        f.mkdirs();
        jbn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String s = ruta + getCode() + ".jpg";
                File f1 = new File(s);

                try {
                    f1.createNewFile();
                    Toast.makeText(MainActivity.this, "Archivo creado", Toast.LENGTH_LONG);
                } catch (IOException ex) {
                    Log.e("Error", "Error:" + ex);
                }


                //Permisos para crear la imagen
                Uri u = Uri.fromFile(f1);
                Uri u2 = FileProvider.getUriForFile(MainActivity.this,
                        "com.example.Camera1.provider",
                        f1);
                //Este codigo es el que toma la foto
                Intent in = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
                in.putExtra(MediaStore.EXTRA_OUTPUT, u2);
                startActivityForResult(in, 0);
            }
        });
    }

    private String getCode() {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyymmddhhmmss");
        String n = "pic_" + sdf.format(new Date());
        ;
        return n;
    }

}