package com.area51.clase04.ui.registro_tipo;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

public class RegistroTipoViewModel extends ViewModel {

    private MutableLiveData<String> mText;

    public RegistroTipoViewModel() {
        mText = new MutableLiveData<>();
        mText.setValue("This is share fragment");
    }

    public LiveData<String> getText() {
        return mText;
    }
}