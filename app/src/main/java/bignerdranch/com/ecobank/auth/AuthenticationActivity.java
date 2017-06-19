package bignerdranch.com.ecobank.auth;

import android.support.v4.app.Fragment;

import bignerdranch.com.ecobank.SingleFragmentActivity;

public class AuthenticationActivity extends SingleFragmentActivity {



    @Override
    protected Fragment createFragment() {
        return AuthenticationFragment.newInstance();
    }

}
