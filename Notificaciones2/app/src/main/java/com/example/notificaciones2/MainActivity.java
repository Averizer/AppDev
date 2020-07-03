package com.example.notificaciones2;

import android.app.Activity;
import android.app.Notification;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.NotificationCompat;
import android.view.View;
import android.widget.Button;


public class MainActivity extends Activity {
    int id = 1;

    private static final int NOTIF_ALERTA_ID = 1;
    private static final String ACTION_CLOSE = "ACTION_CLOSE";
    String GROUP_KEY_WORK_EMAIL = "com.android.example.Notificaciones2";


    @Override
    protected void onCreate(Bundle b) {
        super.onCreate(b);
        setContentView(R.layout.activity_main);
        final Intent i = new Intent(this, NotificationView.class);
        i.putExtra("notificationID", id);
        final PendingIntent pendingIntent = PendingIntent.getActivity(MainActivity.this, 0, i, 0);
        Button jbnN = (Button) findViewById(R.id.xbn);

        jbnN.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {

                NotificationManager nm = (NotificationManager)
                        getSystemService(NOTIFICATION_SERVICE);

                Notification noti =
                        new NotificationCompat.Builder(MainActivity.this)
                                .setSmallIcon(android.R.drawable.stat_sys_warning)
                                .setContentTitle( "Notificaciones")
                                .setContentText("Curso de Android")
                                .setTicker("Nueva entrada en ESCOM")
                                .addAction(R.mipmap.ic_launcher, "Nueva entrada en ESCOM", pendingIntent)
                                .setAutoCancel(true)
                                .setGroup(GROUP_KEY_WORK_EMAIL)
                                .build();


                Intent in = new Intent(MainActivity.this, MainActivity.class);
                PendingIntent pi = PendingIntent.getActivity(MainActivity.this,0,in,0);

                nm.notify(id, noti);
            }
        });
    }


}
