package com.magtecconsulting.timothylott.herome.Activities;

import android.net.Uri;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.magtecconsulting.timothylott.herome.Fragments.BackstoryScreen;
import com.magtecconsulting.timothylott.herome.Fragments.PickPowerFragment;
import com.magtecconsulting.timothylott.herome.Fragments.mainFragment;
import com.magtecconsulting.timothylott.herome.R;


public class MainActivity extends AppCompatActivity implements mainFragment.MainFragmentInteractionListener, PickPowerFragment.PickPowerInteractionListener, BackstoryScreen.BackstoryInteractionListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        FragmentManager manager = getSupportFragmentManager();
        Fragment fragment = manager.findFragmentById(R.id.fragment_container);

        if (fragment == null) {
            fragment = new mainFragment();
            manager.beginTransaction().add(R.id.fragment_container, fragment).commit();

        }

    }
    public void loadPickPowerScreen() {

        PickPowerFragment pickPowerFragment = new PickPowerFragment();
        this.getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container, pickPowerFragment).addToBackStack(null).commit();

    }

    public void  loadBackstoryScreen () {
        BackstoryScreen pickBackstoryScreen = new BackstoryScreen();
        this.getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container, pickBackstoryScreen).addToBackStack(null).commit();
    }




    public void onMainFragmentInteration(Uri uri) {
    }


    @Override
    public void onPickPowerFragmentInteraction(Uri uri) {

    }

    @Override
    public void onBackstoryFragmentInteraction(Uri uri) {

    }
}
