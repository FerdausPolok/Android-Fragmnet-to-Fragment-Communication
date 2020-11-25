package com.example.fragmenttofragmentcommunication;


import android.content.Context;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;


/**
 * A simple {@link Fragment} subclass.
 */
public class Frag1 extends Fragment {

    Button send;
    EditText editText;
    String input;
    sendCustomListener listener;
    Context context;


    public Frag1() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View v= inflater.inflate(R.layout.fragment_frag1, container, false);

        send=v.findViewById(R.id.sendbtn1);
        editText=v.findViewById(R.id.edt1);


        send.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                input = editText.getText().toString();
                listener = (sendCustomListener) context;
                listener.sendMessage(input);


            }
        });

        return v;
    }

    @Override
    public void onAttach(Context context) {
        this.context=context;
        super.onAttach(context);
    }

    interface sendCustomListener{
        void sendMessage (String text);
    }

}
