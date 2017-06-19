package bignerdranch.com.ecobank.accountcreated;

import android.content.Context;
import android.content.Intent;
import android.support.v4.app.Fragment;

import bignerdranch.com.ecobank.SingleFragmentActivity;

public class AccountCreatedActivity extends SingleFragmentActivity{

    private static final String EXTRA_ACCOUNT_NUMBER = "account_number";

    public static Intent newIntent(Context context, String accountNumber){
        Intent intent = new Intent(context, AccountCreatedActivity.class);
        intent.putExtra(EXTRA_ACCOUNT_NUMBER, accountNumber);
        return intent;
    }

    @Override
    protected Fragment createFragment() {
        return AccountCreatedFragment.newInstance(getIntent().getStringExtra(EXTRA_ACCOUNT_NUMBER));
    }
}
