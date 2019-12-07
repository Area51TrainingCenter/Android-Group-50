package com.area51.clase04.ui.registro_grilla;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

public class RegistroGrillaViewModel extends ViewModel {

    private MutableLiveData<String> mText;

    public RegistroGrillaViewModel() {
        mText = new MutableLiveData<>();
        mText.setValue("This is tools fragment");
    }

    public LiveData<String> getText() {
        return mText;
    }
}