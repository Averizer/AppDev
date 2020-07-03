package com.example.sql2;

import android.os.Bundle;
import android.app.Activity;
import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.*;
public class MainActivity extends Activity {
    EditText        jetI, jetN,jetI2, jetN2;
    Button          jbnA, jbnL,jbnU,jbnD;
    TextView        jtvL;
    SQLiteDatabase  sqld;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        jetI = (EditText)   findViewById(R.id.xetI);
        jetN = (EditText)   findViewById(R.id.xetN);
        jetI2 = (EditText)   findViewById(R.id.xetI2);
        jetN2 = (EditText)   findViewById(R.id.xetN2);
        jbnA = (Button)     findViewById(R.id.xbnA);
        jbnL = (Button)     findViewById(R.id.xbnL);
        jbnU = (Button)     findViewById(R.id.xbnU);
        jbnD = (Button)     findViewById(R.id.xbnD);
        jtvL = (TextView)   findViewById(R.id.xtvL);

        DbmsSQLiteHelper dsqlh = new DbmsSQLiteHelper(this, "DBContactos", null, 1);
        sqld = dsqlh.getWritableDatabase();
        jbnA.setOnClickListener(new OnClickListener() {
            public void onClick(View v) {
                String          id = jetI.getText().toString();
                String          nombre = jetN.getText().toString();
                ContentValues   cv = new ContentValues();
                cv.put("id", id);
                cv.put("nombre", nombre);
                sqld.insert("Contactos", null, cv);
                jetI.setText(""); jetN.setText("");
            }
        });
        jbnL.setOnClickListener(new OnClickListener() {
            public void onClick(View v) {
                String id, nombre;
                Cursor c = sqld.rawQuery("SELECT id,nombre FROM Contactos ORDER BY id asc ", null);
                jtvL.setText("");
                if (c.moveToFirst()) {
                    do {
                        id = c.getString(0);
                        nombre = c.getString(1);
                        jtvL.append(" " + id + "\t" + nombre + "\n");
                    } while(c.moveToNext());
                }
            }
        });

        jbnU.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {

                String arg1 = jetI.getText().toString();
                String arg2 = jetN.getText().toString();
                String[] args = new String[] {arg1,arg2};
                ContentValues   Values = new ContentValues();
                String id = jetI2.getText().toString();
                String nombre = jetN2.getText().toString();
                Values.put("id", id);
                Values.put("nombre", nombre);
                sqld.update("Contactos", Values,"id=? and nombre=?" ,args );

            }
        });

        jbnD.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                String arg1 = jetI.getText().toString();
                String arg2 = jetN.getText().toString();
                String[] args = new String[] {arg1,arg2};
                //String id, nombre;
                sqld.delete("Contactos","id=? and nombre=?" ,args);
            }
        });
    }
}
