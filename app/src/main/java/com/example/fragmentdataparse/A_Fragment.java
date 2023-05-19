package com.example.fragmentdataparse;

import android.annotation.SuppressLint;
import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

public class A_Fragment extends Fragment {

    private FragmnetAListner listner;
    EditText edttext;
    Button btntransfer;


    public interface FragmnetAListner {
        void onInputBsent(CharSequence inpunt);
    }

    @SuppressLint("MissingInflatedId")
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.a_fragment, container, false);

        edttext = view.findViewById(R.id.Aedttext);
        btntransfer = view.findViewById(R.id.Abtntransfer);

        btntransfer.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                CharSequence input = edttext.getText();
                listner.onInputBsent(input);
            }
        });
        return view;
    }

    public void updateEdittext(CharSequence newtext) {
        edttext.setText(newtext);
    }

    @Override
    public void onAttach(@NonNull Context context) {
        super.onAttach(context);
        if (context instanceof FragmnetAListner) {
            listner = (FragmnetAListner) context;

        } else {
            throw new RuntimeException(context.toString() + "must implement FragmnetAListner");

        }
    }

    @Override
    public void onDetach() {
        super.onDetach();

        listner = null;
    }
}
