package com.pahanez.familytask;

import android.app.Activity;
import android.app.Fragment;
import android.app.FragmentTransaction;
import android.os.Bundle;
import android.view.MenuItem;

import com.pahanez.familytask.com.pahanez.familytask.fragments.Register;
import com.pahanez.familytask.com.pahanez.familytask.fragments.Signup;


public class FamilyMain extends Activity implements Signup.FragmentInteractionListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_family_main);
        getFragmentManager().beginTransaction().add(R.id.act_container, Signup.newInstance()).commit();
    }

//    @Override
//    public boolean onCreateOptionsMenu(Menu menu) {
//        // Inflate the menu; this adds items to the action bar if it is present.
//        getMenuInflater().inflate(R.menu.family_main, menu);
//        return true;
//    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();
        if (id == R.id.action_settings) {
            return true;
        }
        return super.onOptionsItemSelected(item);
    }

    private void initFragment(Fragment fragment , boolean backstack) {
        FragmentTransaction ft = getFragmentManager().beginTransaction();
        ft.replace(R.id.act_container, fragment);

        if(backstack)
            ft.addToBackStack(null);

        ft.commit();
    }

    private void initFragment(Fragment fragment){
        initFragment(fragment,false);
    }

    @Override
    public void onViewClicked(int id) {
        switch (id){
            case R.id.signin:
                    initFragment(null);
                break;
            case R.id.register:
                    initFragment(Register.newInstance(),true);
                break;
        }
    }
}
