package bignerdranch.com.ecobank.auth;


import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.TextInputLayout;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.Toast;

import bignerdranch.com.ecobank.R;
import bignerdranch.com.ecobank.main.MainActivity;

/**
 * A simple {@link Fragment} subclass.
 */
public class AuthenticationFragment extends Fragment {

    private static final String TAG = AuthenticationFragment.class.getSimpleName();

    private TextInputLayout mUserIdLayout;
    private TextInputLayout mUserPinLayout;
    private Button mButtonLogin;


    public static AuthenticationFragment newInstance() {
        Bundle args = new Bundle();
        AuthenticationFragment fragment = new AuthenticationFragment();
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view =  inflater.inflate(R.layout.fragment_authentication, container, false);

        mUserIdLayout = (TextInputLayout) view.findViewById(R.id.user_id);
        mUserPinLayout = (TextInputLayout) view.findViewById(R.id.user_pin);

        //for testing purposes
        // TODO: 4/11/2017 remove when done
        startActivity(MainActivity.newIntent(getActivity()));

        mButtonLogin = (Button) view.findViewById(R.id.button_login);
        mButtonLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                final String userId = mUserIdLayout.getEditText().getText().toString();
                final String mPin = mUserPinLayout.getEditText().getText().toString();
                if(userId.equals("28511994") && mPin.equals("4315")){
                    startActivity(MainActivity.newIntent(getActivity()));
                } else {
                    Log.i(TAG, "onClick: " + userId  + " " + mPin);
                    Toast.makeText(getActivity(), R.string.login_failure, Toast.LENGTH_SHORT).show();
                }
            }
        });

        return view;
    }


}
