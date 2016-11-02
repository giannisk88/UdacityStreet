package com.example.udacitystreet;

import android.support.v4.app.FragmentActivity;
import android.os.Bundle;

import com.google.android.gms.maps.OnStreetViewPanoramaReadyCallback;
import com.google.android.gms.maps.StreetViewPanorama;
import com.google.android.gms.maps.StreetViewPanoramaFragment;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.StreetViewPanoramaCamera;

public class MainActivity extends FragmentActivity
        implements OnStreetViewPanoramaReadyCallback
        {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //Create a streetview panorama fragment object
        StreetViewPanoramaFragment streetviewpanoramafragment = (StreetViewPanoramaFragment) getFragmentManager().findFragmentById(R.id.streetviewpanorama);
        streetviewpanoramafragment.getStreetViewPanoramaAsync(this);

    }

    @Override
    public void onStreetViewPanoramaReady(StreetViewPanorama streetViewPanorama) {


        LatLng home= new LatLng(35.3089959,25.1472875);
        streetViewPanorama.setPosition(home);
        streetViewPanorama.setStreetNamesEnabled(true);
        streetViewPanorama.setZoomGesturesEnabled(true);
        streetViewPanorama.setUserNavigationEnabled(true);


        StreetViewPanoramaCamera panoramaCamera = new StreetViewPanoramaCamera.Builder()
                .bearing(180)
                .build();
        streetViewPanorama.animateTo(panoramaCamera,1000);
        int i = 1 + 1;

    }
}
