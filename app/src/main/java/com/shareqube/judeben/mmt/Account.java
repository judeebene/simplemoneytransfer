package com.shareqube.judeben.mmt;



import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.CollapsingToolbarLayout;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

public class Account extends Fragment {

    String  LOG_TAG = Account.class.getSimpleName();
    CollapsingToolbarLayout mcolapsingtoolbar ;
    Toolbar mToolBar ;

    Button account_continue ;
    EditText acc_number ;
    Spinner bankName ;
    TextView recipientAccountDetailView ;



    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);





    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {


        View rootView = inflater.inflate(R.layout.activity_account , container , false);


        mcolapsingtoolbar = ((CollapsingToolbarLayout)rootView.findViewById(R.id.collapsingtoolbar));
        mcolapsingtoolbar.setTitle(getResources().getString(R.string.account_detail));
        mToolBar = (Toolbar)rootView.findViewById(R.id.toolbar);

        bankName = (Spinner)rootView.findViewById(R.id.bankName);
        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(getActivity(),
                R.array.bank_array, android.R.layout.simple_spinner_item);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
// Apply the adapter to the spinner
        bankName.setAdapter(adapter);

        acc_number = (EditText) rootView.findViewById(R.id.acc_no);

        account_continue = (Button) rootView.findViewById(R.id.accountContinueId);
        Bundle recipientInfo = getArguments();

        String recipientEmail = recipientInfo.getString("email");
        String recipientName = recipientInfo.getString("fullname");
        final String recipientPhone = recipientInfo.getString("phoneNumber");



        account_continue.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Bundle args = new Bundle() ;
                 args.putString("account" , acc_number.toString());

                args.putString("bankName" , bankName.toString());
                args.putString("phoneNumber" , recipientPhone);

                AccountContinue accountContinue = new AccountContinue();

                accountContinue.setArguments(args);

                FragmentManager fragmentManager = getFragmentManager();
                fragmentManager.beginTransaction().replace(R.id.flContent, accountContinue).commit();

            }
        });


       recipientAccountDetailView = (TextView)rootView.findViewById(R.id.recipientAccountTextView);


        recipientAccountDetailView.setText(recipientName + "Account Details");

        Log.e(LOG_TAG , "email "+  recipientEmail);
        Log.e(LOG_TAG , "Name "+  recipientName);
        Log.e(LOG_TAG , "Phone Number "+  recipientPhone);





                return rootView ;
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
