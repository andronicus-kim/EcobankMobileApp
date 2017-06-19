package bignerdranch.com.ecobank.main;


import android.app.Activity;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.content.pm.ResolveInfo;
import android.graphics.Bitmap;
import android.net.Uri;
import android.os.Bundle;
import android.provider.MediaStore;
import android.support.annotation.Nullable;
import android.support.design.widget.TextInputLayout;
import android.support.v4.app.Fragment;
import android.support.v4.content.FileProvider;
import android.support.v4.widget.ContentLoadingProgressBar;
import android.util.Base64;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RadioButton;
import android.widget.Toast;

import java.io.ByteArrayOutputStream;
import java.io.File;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import bignerdranch.com.ecobank.R;
import bignerdranch.com.ecobank.accountcreated.AccountCreatedActivity;
import bignerdranch.com.ecobank.data.AccountData;
import bignerdranch.com.ecobank.data.AccountService;
import bignerdranch.com.ecobank.request.Account;
import bignerdranch.com.ecobank.request.Example;
import bignerdranch.com.ecobank.request.Holder;
import bignerdranch.com.ecobank.request.Merchant;
import bignerdranch.com.ecobank.response.ResponseData;
import bignerdranch.com.ecobank.utils.BitmapHelper;
import bignerdranch.com.ecobank.utils.ImageBase64;
import bignerdranch.com.ecobank.utils.RetrofitClient;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;


/**
 * A simple {@link Fragment} subclass.
 */
public class MainFragment extends Fragment {

    public static final String TAG = MainFragment.class.getSimpleName();

    private static final int REQUEST_PHOTO = 2;

    public boolean valid = false;

//    private TextInputLayout mIdInput;
//    private TextInputLayout mUserPassword;
    private TextInputLayout mFirstNameInput;
    private TextInputLayout mMiddleNameInput;
    private TextInputLayout mSurnameInput;
    private TextInputLayout mPhoneNumberInput;

    private RadioButton mEmployedRadioButton;
    private RadioButton mUnemployedRadioButton;
    private RadioButton mSelfEmployedRadioButton;

    private RadioButton mJointRadioButton;
    private RadioButton mIndividualRadioButton;

    private RadioButton mMarriedRadioButton;
    private RadioButton mSingleRadioButton;

//    private RadioButton mTransactionRadioButton;
    private RadioButton mCurrentRadioButton;
    private RadioButton mSavingsRadioButton;

    private TextInputLayout mNOKFirstNameInput;
    private TextInputLayout mNOKLastNameInput;
    private TextInputLayout mNOKPhoneNumberInput;

    private CheckBox mJointCheckBox;
    private TextInputLayout mJointFirstNameInput;
    private TextInputLayout mJointLastNameInput;
    private TextInputLayout mJointPhoneNumberInput;
    private TextInputLayout mJointIdInput;
    private LinearLayout mJointLayout;

    private CheckBox mJointAccountYes;
    private CheckBox mJointAccountNo;

    private ImageView mImageView;
    private ImageButton mButton;

    private ContentLoadingProgressBar mProgressBar;
    private LinearLayout mLinearLayout;

    private File mPhotoFile;
    
    private AccountData mAccountData;

    private Holder mHolder;

    private Account mAccount;

    private Merchant mMerchant;

    private Example mExample;

//    private static final Random generator = new Random();

    public static MainFragment newInstance() {

        Bundle args = new Bundle();

        MainFragment fragment = new MainFragment();
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setHasOptionsMenu(true);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_main, container, false);
        mAccountData = new AccountData();
        mHolder = new Holder();
        mAccount = new Account();
        mExample = new Example();
        mMerchant = new Merchant();

        mProgressBar = (ContentLoadingProgressBar) view.findViewById(R.id.progress_bar);
        mLinearLayout = (LinearLayout) view.findViewById(R.id.linear_layout);

//        mIdInput = (TextInputLayout) view.findViewById(R.id.user_id_input);
//        mUserPassword = (TextInputLayout)view.findViewById(R.id.user_password);
        mFirstNameInput = (TextInputLayout) view.findViewById(R.id.first_name_input);
        mMiddleNameInput = (TextInputLayout) view.findViewById(R.id.middle_name_input);
        mSurnameInput = (TextInputLayout) view.findViewById(R.id.surname_input);
        mPhoneNumberInput = (TextInputLayout) view.findViewById(R.id.phone_number_input);

        mEmployedRadioButton = (RadioButton) view.findViewById(R.id.employed_radio_button);
        mUnemployedRadioButton = (RadioButton)view.findViewById(R.id.unemployed_radio_button);
        mSelfEmployedRadioButton = (RadioButton)view.findViewById(R.id.self_employed_radio_button);

        mIndividualRadioButton = (RadioButton) view.findViewById(R.id.individual_radio_button);
        mJointRadioButton = (RadioButton)view.findViewById(R.id.joint_radio_button);

//        mMarriedRadioButton = (RadioButton) view.findViewById(R.id.married_radio_button);
//        mSingleRadioButton = (RadioButton) view.findViewById(R.id.sigle_radio_button);

//        mTransactionRadioButton = (RadioButton) view.findViewById(R.id.transaction_radio_button);
        mCurrentRadioButton = (RadioButton) view.findViewById(R.id.current_radio_button);
        mSavingsRadioButton = (RadioButton) view.findViewById(R.id.savings_radio_button);

        mNOKFirstNameInput = (TextInputLayout) view.findViewById(R.id.next_first_name_input);
//        mNOKLastNameInput = (TextInputLayout) view.findViewById(R.id.next_last_name_input);
        mNOKPhoneNumberInput = (TextInputLayout) view.findViewById(R.id.next_phone_number_input);
//
//        mJointCheckBox = (CheckBox) view.findViewById(R.id.joint_account_check_box);
//        mJointLayout = (LinearLayout) view.findViewById(R.id.joint_layout);
//        mJointCheckBox.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                mJointLayout.setVisibility(mJointCheckBox.isChecked() ? View.VISIBLE : View.GONE);
//            }
//        });
//        mJointFirstNameInput = (TextInputLayout) view.findViewById(R.id.joint_first_name_input);
//        mJointLastNameInput = (TextInputLayout) view.findViewById(R.id.joint_last_name_input);
//        mJointPhoneNumberInput = (TextInputLayout) view.findViewById(R.id.joint_phone_number_input);
//        mJointIdInput = (TextInputLayout) view.findViewById(R.id.joint_id_input);
//
//        mJointAccountYes = (CheckBox) view.findViewById(R.id.joint_account_yes_check_box);
//        mJointAccountNo = (CheckBox) view.findViewById(R.id.joint_account_no_check_box);


        mPhotoFile = getPhotoFile();
        mImageView = (ImageView) view.findViewById(R.id.photo);
        final Intent captureImage = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
        //boolean canTakePhoto = mPhotoFile != null && captureImage.resolveActivity(packageManager) != null;
        mButton = (ImageButton) view.findViewById(R.id.camera);
        mButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                 Uri uri = FileProvider.getUriForFile(getActivity(),
                        "com.bignerdranch.android.ecobank.fileprovider", mPhotoFile);

                captureImage.putExtra(MediaStore.EXTRA_OUTPUT, uri);
                List<ResolveInfo> cameraActivities = getActivity()
                        .getPackageManager().queryIntentActivities(captureImage, PackageManager.MATCH_DEFAULT_ONLY);
                for(ResolveInfo activity: cameraActivities){
                    getActivity().grantUriPermission(activity.activityInfo.packageName, uri, Intent.FLAG_GRANT_WRITE_URI_PERMISSION);
                }
                startActivityForResult(captureImage, REQUEST_PHOTO);
            }
        });

        return view;
    }

    public void getAccountCreationData() {


//        boolean valid2 = false;

        if(
                isEmpty(mFirstNameInput.getEditText())
                || isEmpty(mMiddleNameInput.getEditText())
                || isEmpty(mSurnameInput.getEditText())
                || isEmpty(mPhoneNumberInput.getEditText())
                || isEmpty(mNOKFirstNameInput.getEditText())
//                || isEmpty(mNOKLastNameInput.getEditText())
                || isEmpty(mNOKPhoneNumberInput.getEditText())

                ){
            valid = false;

        } else {

//            mAccountData.setId(Long.valueOf(mIdInput.getEditText().getText().toString()));
//            mAccountData.setFirstName(mFirstNameInput.getEditText().getText().toString());
//            mAccountData.setMiddleName(mMiddleNameInput.getEditText().getText().toString());
//            mAccountData.setSurname(mSurnameInput.getEditText().getText().toString());
//            mAccountData.setPhoneNumber(Long.valueOf(mPhoneNumberInput.getEditText().getText().toString()));
//
//            mAccountData.setNextOfKinFirstName(mNOKFirstNameInput.getEditText().getText().toString());
//            mAccountData.setNextOfKinLastName(mNOKLastNameInput.getEditText().getText().toString());
//            mAccountData.setNextOfKinPhoneNumber(mNOKPhoneNumberInput.getEditText().getText().toString());

            mHolder.setFirstName(mFirstNameInput.getEditText().getText().toString());
            mHolder.setMiddleName(mMiddleNameInput.getEditText().getText().toString());
            mHolder.setLastName(mSurnameInput.getEditText().getText().toString());
//            mHolder.setEmployment(mEmployedRadioButton.isChecked() ? true : false));
            mHolder.setNextOfKin(mNOKFirstNameInput.getEditText().getText().toString());
            mHolder.setNextOfKinPhone(mNOKPhoneNumberInput.getEditText().getText().toString());
            mHolder.setPhone(mPhoneNumberInput.getEditText().getText().toString());

            mMerchant.setId("254106111628410881");
            mMerchant.setPassword("abcd");

            valid = true;

        }

        
//        mAccountData.setEmployed(mEmployedRadioButton.isChecked() ? true : false);
//
//        mAccountData.setMarried(mMarriedRadioButton.isChecked() ? true : false);

//        if(mTransactionRadioButton.isChecked()){
//            mAccountData.setAccountType("Transaction");
//        } else if(mCurrentRadioButton.isChecked()){
//            mAccountData.setAccountType("Current");
//        } else if (mSavingsRadioButton.isChecked()){
//            mAccountData.setAccountType("Savings");
//        }

        if(mEmployedRadioButton.isChecked()){
//            mAccountData.setAccountType("Transaction");
            mHolder.setEmployment("employed");
        } else if(mUnemployedRadioButton.isChecked()){
//            mAccountData.setAccountType("Current");
            mHolder.setEmployment("unemployed");
        }else if (mSelfEmployedRadioButton.isChecked()){
            mHolder.setEmployment("self-employed");
        }

        if(mJointRadioButton.isChecked()){
//            mAccountData.setAccountType("Transaction");
            mAccount.setHolding("joint");
        } else if(mIndividualRadioButton.isChecked()){
//            mAccountData.setAccountType("Current");
            mAccount.setHolding("individual");
        }

        if(mCurrentRadioButton.isChecked()){
//            mAccountData.setAccountType("Transaction");
            mAccount.setType("current");
        } else if(mSavingsRadioButton.isChecked()){
//            mAccountData.setAccountType("Current");
            mAccount.setType("savings");
        }
        List<Holder> mHolders = new ArrayList<>();
        mHolders.add(mHolder);
        mAccount.setHolders(mHolders);

        mExample.setAccount(mAccount);
        mExample.setMerchant(mMerchant);


//        mAccountData.setJoint(mJointCheckBox.isChecked());
//        if(mJointAccountYes.isChecked()){


//            if(
//                    isEmpty(mJointFirstNameInput.getEditText())
//                            || isEmpty(mJointLastNameInput.getEditText())
//                            || isEmpty(mJointIdInput.getEditText())
//                            || isEmpty(mJointPhoneNumberInput.getEditText())
//
//                    ){
//
//                valid2 = false;
//            } else {
//                mAccountData.setJointFirstName(mJointFirstNameInput.getEditText().getText().toString());
//                mAccountData.setJointLastName(mJointLastNameInput.getEditText().getText().toString());
//                mAccountData.setJointIdNumber(Long.valueOf(mJointIdInput.getEditText().getText().toString()));
//                mAccountData.setJointPhoneNumber(Long.valueOf(mJointPhoneNumberInput.getEditText().getText().toString()));
//                valid2 = true;
//            }


//        } else {
//           valid2 = true;
//        }

//        mAccountData.setCredit(mCreditCardCheckBox.isChecked());
//        mAccountData.setDebit(mDebitCardCheckBox.isChecked());

//        mAccountData.setDate(new Date().getTime());

        if(valid){
//            sendData(new Gson().toJson(mAccountData));
            sendData();
        } else {
            Toast.makeText(getActivity(), "Please make sure all fields are filled", Toast.LENGTH_SHORT).show();
        }

    }

    private boolean isEmpty(EditText etText) {
        return etText.getText().toString().trim().length() == 0;
    }

//    public static int generatePin() {
//        return 100000 + generator.nextInt(900000);
//    }

//    private void sendData(String accountCreationData) {
    private void sendData() {

    SimpleDateFormat simpleDateFormat =
                new SimpleDateFormat();
        String dateAsString = simpleDateFormat.format(new Date());

//
//        Data data = new Data();
//        data.setAccountCreationData(mAccountData);


//        long traceNumber = new Long(generatePin());

//        data.setSystemsTraceNumber(traceNumber);

//        String julianDateString = new SimpleDateFormat("'0'yyD").format(new Date());
//
//        // get hour
//        Calendar rightNow = Calendar.getInstance();
//        int hour = rightNow.get(Calendar.HOUR_OF_DAY);

//        String retrievalReferenceNumber = julianDateString.substring(julianDateString.length() - 4)
//                + String.valueOf(hour) + String.valueOf(traceNumber);



//        data.setRetrievalReferenceNumber(retrievalReferenceNumber);

//        simpleDateFormat =
//                new SimpleDateFormat("MMddhhmmss");
//        dateAsString = simpleDateFormat.format(new Date());
//        data.setTransmissionDateAndTime(Long.valueOf(dateAsString));
//
//        simpleDateFormat =
//                new SimpleDateFormat("hhmmss");
//        dateAsString = simpleDateFormat.format(new Date());
//        data.setTimeLocalTransaction(Long.valueOf(dateAsString));
//
//        simpleDateFormat =
//                new SimpleDateFormat("MMDD");
//        dateAsString = simpleDateFormat.format(new Date());
//        data.setDateLocalTransaction(Long.valueOf(dateAsString));

//        showAccountNumber(String.valueOf(1000000 + generator.nextInt(9000000)));

//        // TODO: 4/12/2017 send data
        AccountService accountService = RetrofitClient.getRetrofit().create(AccountService.class);
        Call<ResponseData> call = accountService.postData(mExample);

        showProgressbar(true);
        call.enqueue(new Callback<ResponseData>() {
            @Override
            public void onResponse(Call<ResponseData> call, Response<ResponseData> response) {
                if(response.isSuccessful()){
                    showProgressbar(false);
                    Toast.makeText(getActivity(), "Account Created", Toast.LENGTH_SHORT).show();
//                    showAccountNumber(String.valueOf(1000000 + generator.nextInt(9000000)));
                    showAccountNumber(response.body().getResponseBodyContents().getAccountNo());
                    Log.d(TAG, "Account Number: " + response.body().toString());
                } else {
                   //Toast.makeText(getActivity(), "Account Not Created", Toast.LENGTH_SHORT).show();
                }
                showProgressbar(false);
                // testing
//                showAccountNumber(String.valueOf(1000000 + generator.nextInt(9000000)));
                Log.i(TAG, "onResponse: code " + Integer.toString(response.code()) + " message: " + response.message());
            }

            @Override
            public void onFailure(Call<ResponseData> call, Throwable t) {
                showProgressbar(false);
                Toast.makeText(getActivity(), "Error try again", Toast.LENGTH_SHORT).show();
                Log.e(TAG, "onFailure: ", t);
            }
        });
    }

    private void showProgressbar(boolean b) {
        mProgressBar.setVisibility(b ? View.VISIBLE : View.GONE);
        mLinearLayout.setVisibility(b ? View.GONE : View.VISIBLE);
    }

    private void showAccountNumber(String s) {
        startActivity(AccountCreatedActivity.newIntent(getActivity(), s));
    }

    public File getPhotoFile(){
        File filesDir = getActivity().getFilesDir();
        return new File(filesDir, getPhotoFileName());
    }

    public String getPhotoFileName(){
        return "IMG_" + mFirstNameInput.getEditText().getText().toString() + ".jpg";
    }

    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        if(resultCode != Activity.RESULT_OK){
            return;
        }

        if (requestCode == REQUEST_PHOTO){
            Uri uri = FileProvider.getUriForFile(getActivity(), "com.bignerdranch.android.ecobank.fileprovider", mPhotoFile);
            getActivity().revokeUriPermission(uri, Intent.FLAG_GRANT_WRITE_URI_PERMISSION);
            updatePhotoView();
        }
    }

    private void updatePhotoView(){
        if(mPhotoFile == null || !mPhotoFile.exists()){
            mImageView.setImageDrawable(null);
            mImageView.setContentDescription(getString(R.string.crime_photo_no_image_description));
        } else {
            //Bitmap bitmap = PictureUtils.getScaledBitmap(mPhotoFile.getPath(), getActivity());
            Bitmap bitmap = BitmapHelper.decodeFile(mPhotoFile.getPath(), 200, 200, true);
//            mAccountData.setImage(ImageBase64.encodeTobase64(bitmap));
            mHolder.setPhoto(ImageBase64.encodeTobase64(bitmap));
            mImageView.setImageBitmap(bitmap);
            mImageView.setContentDescription(getString(R.string.crime_photo_image_description));
        }
    }

    private String convertToBase64String(Bitmap bitmap) {
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        bitmap.compress(Bitmap.CompressFormat.PNG, 100, byteArrayOutputStream);
        byte[] byteArray = byteArrayOutputStream .toByteArray();

        String encoded = Base64.encodeToString(byteArray, Base64.DEFAULT);

        return encoded;
    }


    @Override
    public void onCreateOptionsMenu(Menu menu, MenuInflater inflater) {
        super.onCreateOptionsMenu(menu, inflater);
        inflater.inflate(R.menu.fragment_main, menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()){
            case R.id.action_save:
                //todo create and save data
                getAccountCreationData();
                return true;
            default:return super.onOptionsItemSelected(item);
        }
    }

}
