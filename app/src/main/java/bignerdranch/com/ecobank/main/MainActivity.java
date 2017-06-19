package bignerdranch.com.ecobank.main;

import android.content.Context;
import android.content.Intent;
import android.support.v4.app.Fragment;

import bignerdranch.com.ecobank.SingleFragmentActivity;

public class MainActivity extends SingleFragmentActivity {

    public static Intent newIntent(Context context){
        Intent intent = new Intent(context, MainActivity.class);

        return intent;
    }

    @Override
    protected Fragment createFragment() {
        return MainFragment.newInstance();
    }
}
