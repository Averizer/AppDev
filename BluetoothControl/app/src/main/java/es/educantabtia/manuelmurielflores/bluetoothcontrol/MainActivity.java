package es.educantabtia.manuelmurielflores.bluetoothcontrol;

import android.bluetooth.BluetoothAdapter;
import android.bluetooth.BluetoothDevice;
import android.bluetooth.BluetoothSocket;
import android.content.Intent;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.CompoundButton;
import android.widget.Toast;
import android.widget.ToggleButton;

import java.io.IOException;
import java.io.OutputStream;
import java.util.Set;
import java.util.UUID;


public class MainActivity extends ActionBarActivity {

    BluetoothAdapter mBluetoothAdapter;
    BluetoothSocket mSocket;
    BluetoothDevice mDevice;
    OutputStream mOutputStream;
    ToggleButton mBtn0 = null;
    ToggleButton mBtn1 = null;
    ToggleButton mBtn2 = null;
    ToggleButton b = null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //Botón-Led0
        mBtn0 = (ToggleButton) findViewById(R.id.toggleButton2);
        mBtn0.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (isChecked) {
                    sendBT(0, true);
                } else {
                    sendBT(0, false);
                }
            }
        });

        //Botón-Led 1
        mBtn1 = (ToggleButton) findViewById(R.id.toggleButton3);
        mBtn1.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                //Es la misma sentencia que en el botón-led 0
                sendBT(1, isChecked);
            }
        });
        //Botón-Led 2
        mBtn2 = (ToggleButton) findViewById(R.id.toggleButton4);
        mBtn2.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                //Es la misma sentencia que en el botón-led 0
                sendBT(2, isChecked);
            }
        });

        //Conexión/desconexión al Bluetooth
        b = (ToggleButton) findViewById(R.id.toggleButton);
        b.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (mSocket != null && mSocket.isConnected()) {
                    ((Button) v).setText("Conectar BT");
                    try {
                        endBT();
                    } catch (IOException e) {
                        showMessage("Error al conectar", Toast.LENGTH_SHORT);
                    }
                } else {
                    ((Button) v).setText("Desconectar BT");
                    try {
                        startBT();
                    } catch (IOException e) {
                        showMessage("Error al desconectar", Toast.LENGTH_SHORT);
                    }
                }
            }
        });
    }
        //Busca el dispositivo Bluetooth e inicia la conexión
        void startBT() throws IOException{
        //Buscar el dispositivo
        mBluetoothAdapter = BluetoothAdapter.getDefaultAdapter();
        if(mBluetoothAdapter==null){
            showMessage ("No existe adaptador bluetooth disponible", Toast.LENGTH_LONG);
            return;
        }
        if (!mBluetoothAdapter.isEnabled()){
            Intent enableBluetooth = new Intent(BluetoothAdapter.ACTION_REQUEST_ENABLE);
            startActivityForResult(enableBluetooth, 0);
        }
        Set<BluetoothDevice> pairedDevices = mBluetoothAdapter.getBondedDevices();

        boolean deviceFound = false;
        for (BluetoothDevice device : pairedDevices){
            if (device.getName().equals("linvor")){
                showMessage ("Bluetooth disponible: "+ device.getName(), Toast.LENGTH_LONG);
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
            showMessage("No se ha encontrado el dispositivo indicado", Toast.LENGTH_LONG);
        }

    }
    //Inicia conexión Bluetooth
    void openBT() throws IOException{
        //ID estándar
        UUID uuid = UUID.fromString("00001101-0000-1000-8000-00805f9b34fb");
        mSocket = mDevice.createRfcommSocketToServiceRecord(uuid);
        mSocket.connect();
        mOutputStream = mSocket.getOutputStream();
        enableButtons (mSocket.isConnected());
        showMessage ("Bluetooth conectado", Toast.LENGTH_SHORT);
    }
    //Finaliza la conexión Bluetooth
    void endBT() throws IOException{
        mOutputStream.close();
        mSocket.close();
        enableButtons (mSocket.isConnected());
    }
    //Muestra mensajes en pantalla
    private void showMessage(String msg, int time){
        Toast toast = Toast.makeText(MainActivity.this, msg, time);
        toast.show();
    }
    //Envío del estado deseado
    private void sendBT(int i, boolean isOn){
        try{
            String msg = Integer.toString(i)+ (isOn ? "H" : "L");
            msg += "\n";
            mOutputStream.write(msg.getBytes());
            showMessage("Datos enviados", Toast.LENGTH_SHORT);
        }catch (Exception e){
            showMessage("Error en el envío", Toast.LENGTH_SHORT);
        }
    }
    //Habilita o deshabilita los botones de los LEDS
    private void enableButtons (boolean isEnabled){
        mBtn0.setEnabled(isEnabled);
        mBtn1.setEnabled(isEnabled);
        mBtn2.setEnabled(isEnabled);
    }

}
