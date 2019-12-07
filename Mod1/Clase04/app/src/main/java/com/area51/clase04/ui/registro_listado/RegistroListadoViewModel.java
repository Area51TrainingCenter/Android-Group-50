package com.area51.clase04.ui.registro_listado;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

public class RegistroListadoViewModel extends ViewModel {

    private MutableLiveData<String> mText;

    public RegistroListadoViewModel() {
        mText = new MutableLiveData<>();
        mText.setValue("This is slideshow fragment");
    }

    public LiveData<String> getText() {
        return mText;
    }
}