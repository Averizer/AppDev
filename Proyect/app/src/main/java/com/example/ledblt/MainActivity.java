package com.example.ledblt;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.bluetooth.BluetoothAdapter;
import android.bluetooth.BluetoothDevice;
import android.bluetooth.BluetoothSocket;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.widget.ImageView;
import android.widget.Toast;
import android.widget.ToggleButton;
import android.widget.Toolbar;

import java.io.IOException;
import java.io.OutputStream;
import java.util.Set;
import java.util.UUID;

import javax.net.ssl.HandshakeCompletedEvent;

public class MainActivity extends AppCompatActivity {
    ToggleButton jtb1,jtbConectar;
    OutputStream mOutputStream;
    ImageView apagado, encendido;
    BluetoothAdapter mBlueAdapter;
    BluetoothSocket mSocket;
    BluetoothDevice mDevice;
    Handler blueIn;
    @Override
    public void onCreate(Bundle b) {
        super.onCreate(b);
        setContentView(R.layout.activity_main);
        final int handlerState = 0;
        apagado = (ImageView)findViewById(R.id.imgApagado);
        encendido = (ImageView)findViewById(R.id.imgEncendido);
        jtb1 = (ToggleButton)findViewById(R.id.xtb1);
        jtbConectar = (ToggleButton) findViewById(R.id.btnConectar);
        final StringBuilder recDataString = new StringBuilder();
        encendido.setVisibility(View.INVISIBLE);

        jtb1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (jtb1.isChecked()){
                    showToastMessage("Led encendido");
                    encendido.setVisibility(View.VISIBLE);
                    apagado.setVisibility(View.INVISIBLE);

                }
                else {
                    showToastMessage("Led apagado");
                    encendido.setVisibility(View.INVISIBLE);
                    apagado.setVisibility(View.VISIBLE);

                }
            }
        });

        jtbConectar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (mSocket != null && mSocket.isConnected()) {
                    ((ToggleButton) v).setText("Conectar BT");
                    try {
                        endBT();
                    } catch (IOException e) {
                        showToastMessage("Error al conectar");
                    }
                } else {
                    ((ToggleButton) v).setText("Desconectar BT");
                    try {
                        startBT();
                    } catch (IOException e) {
                        showToastMessage("Error al desconectar");
                    }
                }
            }
        });

        blueIn = new Handler() {

            public void handleMessage(android.os.Message msg) {
                if (msg.what == handlerState) {          //if message is what we want
                    String readMessage = (String) msg.obj;                                                                // msg.arg1 = bytes from connect thread
                    recDataString.append(readMessage);              //keep appending to string until ~
                    int endOfLineIndex = recDataString.indexOf("~");                    // determine the end-of-line
                    if (endOfLineIndex > 0) {                                           // make sure there data before ~
                        String dataInPrint = recDataString.substring(0, endOfLineIndex);    // extract string
                        int dataLength = dataInPrint.length();       //get length of data received
                        if (recDataString.charAt(0) == '#')        //if it starts with # we know it is what we are looking for
                        {
                            String ev = recDataString.substring(1,1);             //get sensor value from string between indices 1-5

                            if(ev.equals("1")) {
                                showToastMessage("Led encendido");
                                encendido.setVisibility(View.VISIBLE);
                                apagado.setVisibility(View.INVISIBLE);
                            }else if (ev.equals("0")){
                                showToastMessage("Led apagado");
                                encendido.setVisibility(View.INVISIBLE);
                                apagado.setVisibility(View.VISIBLE);
                            }
                            //sensorView3.setText(" Sensor 3 Voltage = " + sensor3 + "V");
                        }
                        recDataString.delete(0, recDataString.length());      //clear all string data
                       
                    }
                }
            }
        };
    }

    //Busca el dispositivo Bluetooth e inicia la conexión
    void startBT() throws IOException{
        //Buscar el dispositivo
        mBlueAdapter = BluetoothAdapter.getDefaultAdapter();
        if(mBlueAdapter==null){
            showToastMessage ("No existe adaptador bluetooth disponible");
            return;
        }
        if (!mBlueAdapter.isEnabled()){
            Intent enableBluetooth = new Intent(BluetoothAdapter.ACTION_REQUEST_ENABLE);
            startActivityForResult(enableBluetooth, 0);
        }
        Set<BluetoothDevice> pairedDevices = mBlueAdapter.getBondedDevices();

        boolean deviceFound = false;
        for (BluetoothDevice device : pairedDevices){
            if (device.getName().equals("linvor")){
                showToastMessage ("Bluetooth disponible: "+ device.getName());
                mDevice = device;
                deviceFound = true;
                break;
            }
        }
        //Si se encuentra, abrir la conexión
        //Si no, mostrar mensaje
        if (deviceFound){
            openBT();
        }else{
            showToastMessage("No se ha encontrado el dispositivo indicado");
        }

    }

    //Inicia conexión Bluetooth
    void openBT() throws IOException{
        //ID estándar
        UUID uuid = UUID.fromString("00001101-0000-1000-8000-00805f9b34fb");
        mSocket = mDevice.createRfcommSocketToServiceRecord(uuid);
        mSocket.connect();
        mOutputStream = mSocket.getOutputStream();
        //enableButtons (mSocket.isConnected());
        showToastMessage ("Bluetooth conectado");
    }

    void endBT() throws IOException{
        mOutputStream.close();
        mSocket.close();
        //enableButtons (mSocket.isConnected());
    }

    private void sendBT(int i, boolean isOn){
        try{
            String msg = Integer.toString(i)+ (isOn ? "H" : "L");//ESTA ES LA VARIABLE QUE TIENES QUE CAMBIAR XD
            msg += "\n";
            mOutputStream.write(msg.getBytes());
            showToastMessage("Datos enviados");
        }catch (Exception e){
            showToastMessage("Error en el envío");
        }
    }

    private void showToastMessage(String s){
        Toast t = Toast.makeText(this, s, Toast.LENGTH_SHORT);
        t.show();
    }



}
