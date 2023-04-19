package com.example.miercolestp.ui.slideshow;

import android.app.Application;

import androidx.annotation.NonNull;
import androidx.fragment.app.FragmentActivity;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.example.miercolestp.R;
import com.google.android.gms.maps.CameraUpdate;
import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.MapFragment;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.CameraPosition;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;

public class SlideshowViewModel extends AndroidViewModel {

    private LatLng aiello=new LatLng(-33.28771,-66.316073 );

    private LatLng vea=new LatLng(-33.278717,-66.316411 );

    private SupportMapFragment mapFragment;

    public SlideshowViewModel(@NonNull Application application) {
        super(application);
    }

    public void crear(SupportMapFragment smf){
        mapFragment = smf;
        mapFragment.getMapAsync(new MapaActual());
    }
    private class MapaActual implements OnMapReadyCallback {

        @Override
        public void onMapReady(@NonNull GoogleMap googleMap) {
            googleMap.setMapType(GoogleMap.MAP_TYPE_SATELLITE);
            googleMap.addMarker(new MarkerOptions().position(aiello).title("Aiello"));
            googleMap.addMarker(new MarkerOptions().position(vea).title("Vea Riobamba"));
            CameraPosition cam=new CameraPosition.Builder()
                    .target(vea)
                    .zoom(17)
                    .bearing(45)
                    .tilt(70)
                    .build();
            CameraUpdate update= CameraUpdateFactory.newCameraPosition(cam);
            googleMap.animateCamera(update);

        }
    }

}