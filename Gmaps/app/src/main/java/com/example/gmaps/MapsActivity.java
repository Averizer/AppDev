package com.example.gmaps;

import androidx.fragment.app.FragmentActivity;

import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Point;
import android.hardware.camera2.CameraAccessException;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.google.android.gms.maps.CameraUpdate;
import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.Projection;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;

public class MapsActivity extends FragmentActivity implements OnMapReadyCallback {

    private GoogleMap mMap;
    private Button btnSatelite;
    private Button btnAnimar;
    private Button btnCentrar;
    private Button btnMover;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_maps);
        btnSatelite = (Button)findViewById(R.id.btnSatetile);
        btnAnimar = (Button)findViewById(R.id.btnAnimar);
        btnCentrar = (Button)findViewById(R.id.btnCentrar);
        btnMover = (Button)findViewById(R.id.btnMover);
        // Obtain the SupportMapFragment and get notified when the map is ready to be used.
        SupportMapFragment mapFragment = (SupportMapFragment) getSupportFragmentManager()
                .findFragmentById(R.id.map);
        mapFragment.getMapAsync(this);
    }

    /**
     * Manipulates the map once available.
     * This callback is triggered when the map is ready to be used.
     * This is where we can add markers or lines, add listeners or move the camera. In this case,
     * we just add a marker near Sydney, Australia.
     * If Google Play services is not installed on the device, the user will be prompted to install
     * it inside the SupportMapFragment. This method will only be triggered once the user has
     * installed Google Play services and returned to the app.
     */

    @Override
    public void onMapReady(GoogleMap googleMap) {
        mMap = googleMap;

        LatLng geoPoint = new LatLng(540,1130);
        Projection projection = mMap.getProjection();
        projection.toScreenLocation(geoPoint);
        Paint p = new Paint();
        p.setColor(Color.BLUE);


        btnSatelite.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(mMap.getMapType() == GoogleMap.MAP_TYPE_SATELLITE)
                    mMap.setMapType(GoogleMap.MAP_TYPE_NORMAL);
                else
                    mMap.setMapType(GoogleMap.MAP_TYPE_SATELLITE);
            }

        });

        btnCentrar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Double latitud = 37.40*1E6;
                Double longitud = -5.99*1E6;
                LatLng centerTo = new LatLng(latitud.intValue(), longitud.intValue());
                mMap.addMarker(new MarkerOptions().position(centerTo).title("Centrado"));
                mMap.moveCamera(CameraUpdateFactory.newLatLng(centerTo));
                mMap.moveCamera(CameraUpdateFactory.zoomTo(20));


            }
        });

        btnAnimar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Double latitud = 19.608415;
                Double longitud = -99.2502285;
                LatLng location = new LatLng(latitud, longitud);
                mMap.moveCamera(CameraUpdateFactory.newLatLngZoom(location, 20));
                String msg = "Lat: " + latitud  + "-" + "Lon: "+ longitud;
                Toast toast = Toast.makeText(MapsActivity.this, msg, Toast.LENGTH_SHORT);
                toast.show();


            }
        });

        btnMover.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Double latitud = 19.608415;
                Double longitud = -99.2502285;
                LatLng location = new LatLng(latitud, longitud);
                mMap.moveCamera(CameraUpdateFactory.scrollBy(40,40));

            }
        });
        /*
        // Add a marker in Sydney and move the camera
        Double latitud = 37.40*1E6;
        Double longitud = -5.99*1E6;
        LatLng location = new LatLng(latitud.intValue(), longitud.intValue());
        mMap.moveCamera(CameraUpdateFactory.newLatLng(location));*/
    }
}