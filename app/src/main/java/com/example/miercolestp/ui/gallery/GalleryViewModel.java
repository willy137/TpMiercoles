package com.example.miercolestp.ui.gallery;



import android.Manifest;
import android.app.Activity;
import android.app.Application;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

public class GalleryViewModel extends AndroidViewModel {

    private  MutableLiveData<Boolean> mutable;

    public GalleryViewModel(@NonNull Application application) {
        super(application);
    }


    public void llamar(String numero){
        if(numero!=numero || !numero.equals("")){
            Intent intent = new Intent(Intent.ACTION_CALL);
            intent.setData(Uri.parse("tel:" + numero));
            intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
            getApplication().startActivity(intent);
        }else{
            mutable.setValue(true);
        }

    }

    public LiveData<Boolean> getMutable() {
        if(mutable==null){
            this.mutable=new MutableLiveData<>();
        }
        return mutable;
    }

    public void mostrarError(){
        Toast.makeText(getApplication(),"ERROR, Debe Ingresar un numero",Toast.LENGTH_LONG).show();
    }
}