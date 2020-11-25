package com.example.fragmenttofragmentcommunication;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.os.Bundle;
import android.view.View;

public class MainActivity extends AppCompatActivity implements Frag1.sendCustomListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void changeFragment(View view) {
        //same onclick method for both button not a problem cause view
        //can find out from which button the trigger has been pressed

        Fragment fragment = null;
        switch (view.getId()){ //used switch so that we don't have to write the same code twice
            case R.id.btn1:

                fragment = new Frag1();
                break;
            case R.id.btn2:
                fragment = new Frag3();
                break;
        }

        FragmentManager fm = getSupportFragmentManager();
        FragmentTransaction ft = fm.beginTransaction();
        ft.replace(R.id.container,fragment);
        ft.commit();
    }

    @Override
    public void sendMessage(String text) {

        Bundle bundle = new Bundle();
        FragmentManager fm = getSupportFragmentManager();
        FragmentTransaction ft = fm.beginTransaction();
        Frag2 frag3 =new Frag2();
        bundle.putString("MSG",text);
        frag3.setArguments(bundle);
        ft.replace(R.id.container,frag3);
        ft.commit();
    }
}
