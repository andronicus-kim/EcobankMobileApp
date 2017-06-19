package bignerdranch.com.ecobank.accountcreated;


import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import bignerdranch.com.ecobank.R;

/**
 * A simple {@link Fragment} subclass.
 */
public class AccountCreatedFragment extends Fragment {

    private static final String ARGS_ACCOUNT_NUMBER = "account_number";
    private String mAccountNumber = "";

    TextView mTextView;

    public static AccountCreatedFragment newInstance(String accountNumber) {
        Bundle args = new Bundle();
        args.putString(ARGS_ACCOUNT_NUMBER, accountNumber);
        AccountCreatedFragment fragment = new AccountCreatedFragment();
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mAccountNumber = getArguments().getString(ARGS_ACCOUNT_NUMBER);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_account_created, container, false);
        mTextView = (TextView) view.findViewById(R.id.account_number);
        mTextView.setText(mAccountNumber);
        return view;
    }

}
