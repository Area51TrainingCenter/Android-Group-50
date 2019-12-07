package com.area51.clase04.ui.registro_grilla;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;

import com.area51.clase04.R;

public class RegistroGrillaFragment extends Fragment {

    private RegistroGrillaViewModel registroGrillaViewModel;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        registroGrillaViewModel =
                ViewModelProviders.of(this).get(RegistroGrillaViewModel.class);
        View root = inflater.inflate(R.layout.fragment_registor_grilla, container, false);
        final TextView textView = root.findViewById(R.id.text_tools);
        registroGrillaViewModel.getText().observe(this, new Observer<String>() {
            @Override
            public void onChanged(@Nullable String s) {
                textView.setText(s);
            }
        });
        return root;
    }
}