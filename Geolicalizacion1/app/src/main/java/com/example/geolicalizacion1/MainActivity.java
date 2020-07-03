package com.example.geolicalizacion1;

import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.core.app.ActivityCompat;

import android.annotation.SuppressLint;
import android.location.Criteria;
import android.location.Location;
import android.location.LocationListener;
import android.location.LocationManager;
import android.location.LocationProvider;
import android.os.Build;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.TextView;


import com.google.android.gms.maps.model.LatLng;

public class MainActivity extends AppCompatActivity {
    boolean altitud;
    int consumoRecursos;
    /* access modifiers changed from: private */
    public LatLng currentLocation = new LatLng(16.504507d, -99.146911d);
    private float distanceUpateLocation = 0.0f;
    Location location;
    LocationListener locationListener;
    private LocationManager locationManager = null;
    int precision;
    LocationProvider provider;
    String provider1;
    int status;
    private int timeUpdateLocation = 10000;
    TextView txtLatitud;
    TextView txtLongitud;
    TextView txtPrecision;
    TextView txtStatus;

    /* access modifiers changed from: protected */
    @RequiresApi(api = Build.VERSION_CODES.M)
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView((int) R.layout.activity_main);
        //setSupportActionBar((Toolbar) findViewById(R.id.tool));
        //getSupportActionBar().setDisplayHomeAsUpEnabled(false);
        this.txtLatitud = (TextView) findViewById(R.id.txtLatitud);
        this.txtLongitud = (TextView) findViewById(R.id.txtLongitud);
        this.txtPrecision = (TextView) findViewById(R.id.txtPrecision);
        this.txtStatus = (TextView) findViewById(R.id.txtStatus);
        iniciarUbicacion();
    }

    @SuppressLint("WrongConstant")
    @RequiresApi(api = Build.VERSION_CODES.M)
    public void iniciarUbicacion() {
        this.locationManager = (LocationManager) getSystemService("location");
        if (Build.VERSION.SDK_INT < 23) {
            return;
        }
        if (ActivityCompat.checkSelfPermission(this, "android.permission.ACCESS_FINE_LOCATION") == 0 || ActivityCompat.checkSelfPermission(this, "android.permission.ACCESS_COARSE_LOCATION") == 0) {
            try {
                Criteria criteria = new Criteria();
                criteria.setAccuracy(1);
                criteria.setAltitudeRequired(true);
                this.provider1 = this.locationManager.getBestProvider(criteria, false);
                if (this.locationManager.isProviderEnabled(this.provider1)) {
                    this.provider = this.locationManager.getProvider(this.provider1);
                    this.precision = this.provider.getAccuracy();
                    this.altitud = this.provider.supportsAltitude();
                    this.consumoRecursos = this.provider.getPowerRequirement();
                    this.status = 1;
                    this.location = this.locationManager.getLastKnownLocation(this.provider1);
                    if (this.location != null) {
                        Log.d("iniciarUbicacion:", "Location NO es nulo");
                        this.currentLocation = new LatLng(this.location.getLatitude(), this.location.getLongitude());
                        return;
                    }
                    Log.d("iniciarUbicacion:", "Location es nulo");
                    return;
                }
                Log.d("iniciarUbicacion", "No encontre el mejor proveedor");
            } catch (Exception e) {
                Log.d("iniciarUbicacion:", "Error en el try");
                e.printStackTrace();
            }
        } else {
            Log.d("initLocationService", "No hay permiso de algo");
            requestPermissions(new String[]{"android.permission.ACCESS_FINE_LOCATION", "android.permission.ACCESS_COARSE_LOCATION", "android.permission.INTERNET"}, 10);
        }
    }

    @RequiresApi(api = Build.VERSION_CODES.M)
    public void onRequestPermissionsResult(int requestCode, String[] permissions, int[] grantResults) {
        if (requestCode == 10 && grantResults.length > 0 && grantResults[0] == 0) {
            iniciarUbicacion();
        }
    }

    @RequiresApi(api = Build.VERSION_CODES.M)
    public void activar(View view) {
        Log.d("ServicioUbicación:", "Activado");
        mostrarUbicacion();
        this.locationListener = new LocationListener() {
            public void onLocationChanged(Location location) {
                StringBuilder sb = new StringBuilder();
                sb.append("Nueva ubicación: lat:");
                sb.append(location.getLatitude());
                sb.append(" lon:");
                sb.append(location.getLongitude());
                Log.d("onLocationChanged:", sb.toString());
                MainActivity.this.currentLocation = new LatLng(location.getLatitude(), location.getLongitude());
                MainActivity.this.mostrarUbicacion();
            }

            public void onStatusChanged(String provider, int status2, Bundle extras) {
                StringBuilder sb = new StringBuilder();
                sb.append("Nueva status: ");
                sb.append(MainActivity.this.status);
                Log.d("onLocationChanged:", sb.toString());
                MainActivity mainActivity = MainActivity.this;
                mainActivity.status = status2;
                TextView textView = mainActivity.txtStatus;
                StringBuilder sb2 = new StringBuilder();
                sb2.append("Status: ");
                sb2.append(MainActivity.this.status);
                textView.setText(sb2.toString());
            }

            public void onProviderEnabled(String provider) {
            }

            public void onProviderDisabled(String provider) {
            }
        };
        try {
            this.locationManager.requestLocationUpdates(this.provider1, (long) this.timeUpdateLocation, this.distanceUpateLocation, this.locationListener);
        } catch (SecurityException e) {
            e.printStackTrace();
            iniciarUbicacion();
        }
    }

    public void mostrarUbicacion() {
        TextView textView = this.txtPrecision;
        StringBuilder sb = new StringBuilder();
        sb.append("Precisión: ");
        sb.append(this.precision);
        textView.setText(sb.toString());
        TextView textView2 = this.txtLatitud;
        StringBuilder sb2 = new StringBuilder();
        sb2.append("Latitud: ");
        sb2.append(this.currentLocation.latitude);
        textView2.setText(sb2.toString());
        TextView textView3 = this.txtLongitud;
        StringBuilder sb3 = new StringBuilder();
        sb3.append("Longitud: ");
        sb3.append(this.currentLocation.longitude);
        textView3.setText(sb3.toString());
        TextView textView4 = this.txtStatus;
        StringBuilder sb4 = new StringBuilder();
        sb4.append("Status: ");
        sb4.append(this.status);
        textView4.setText(sb4.toString());
    }

    public void desactivar(View view) {
        Log.d("ServicioUbicación:", "Desactivado");
        this.locationManager.removeUpdates(this.locationListener);
    }
}
