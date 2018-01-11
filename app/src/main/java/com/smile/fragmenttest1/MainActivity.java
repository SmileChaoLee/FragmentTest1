package com.smile.fragmenttest1;

import android.app.Activity;
import android.app.Fragment;
import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.os.Bundle;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;

public class MainActivity extends Activity {

    private FragmentOne frOne = null;
    private FragmentTwo frTwo = null;
    private int layoutID;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        /*
        frOne = (FragmentOne) fm.findFragmentById(R.id.fragmentOne);
        frTwo = (FragmentTwo) fm.findFragmentById(R.id.fragmentTwo);
        */
        frOne = new FragmentOne();
        frTwo = new FragmentTwo();

        layoutID = R.id.mainLayout;
    }

    public void select_Fragment1(View v) {

        FragmentManager fm = getFragmentManager();
        FragmentTransaction ft = fm.beginTransaction();

        Fragment currentFragment = fm.findFragmentById(layoutID);
        if (currentFragment != null) {
            System.out.println("Replacing fragment No1's button");
            ft.replace(layoutID, frOne);
        } else {
            System.out.println("Adding fragment No1's button");
            ft.add(layoutID,frOne);
        }

        ft.commit();
    }

    public void select_Fragment2(View v) {

        FragmentManager fm = getFragmentManager();
        FragmentTransaction ft = fm.beginTransaction();

        Fragment currentFragment = fm.findFragmentById(layoutID);
        if (currentFragment != null) {
            System.out.println("Replacing fragment No2's button");
            ft.replace(layoutID,frTwo);
        } else {
            System.out.println("Adding fragment No2's button");
            ft.add(layoutID, frTwo);
        }

        ft.commit();
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
