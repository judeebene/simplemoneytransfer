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
import android.widget.Toast;

public class AccountContinue extends Fragment {

    String LOG_TAG =  AccountContinue.class.getSimpleName() ;

    CollapsingToolbarLayout mcolapsingtoolbar ;
    Toolbar mToolBar ;
    EditText amountToSend ;
    Button confirmBtn;;
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);



    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        View rootView =  inflater.inflate(R.layout.activity_account_continue, container, false);

        Bundle info = getArguments();

       final String bankName =  info.getString("bankName");
        final String phoneNumber = info.getString("phoneNumber");
        final String acountNumber = info.getString("account");
        final String recipientName =  info.getString("fullname") ;


        mcolapsingtoolbar = ((CollapsingToolbarLayout)rootView.findViewById(R.id.collapsingtoolbar));
        mcolapsingtoolbar.setTitle(getResources().getString(R.string.amount));
        mToolBar = (Toolbar)rootView.findViewById(R.id.toolbar);

        amountToSend = (EditText) rootView.findViewById(R.id.amountToSend) ;

        confirmBtn = (Button) rootView.findViewById(R.id.go_confirm_btn);

        confirmBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if( ! amountToSend.getText().toString().equals("")) {

                    Log.e(LOG_TAG , "check the class Name");

                    String amount = amountToSend.getText().toString();

                    Bundle args =  new  Bundle();

                    args.putString("account" ,acountNumber);
                    args.putString("bankName" , bankName);
                    args.putString("amount" , amount);
                    args.putString("phoneNumber" , phoneNumber);
                    args.putString("fullname",recipientName);

                    ConfirmTransfer confirmTransfer = new ConfirmTransfer();

                    confirmTransfer.setArguments(args);

                    FragmentManager fragmentManager = getFragmentManager() ;

                    fragmentManager.beginTransaction().replace(R.id.flContent , confirmTransfer ).commit();
                }
                else {
                    Toast.makeText(getActivity() , " Amount Empty, Input Amount" , Toast.LENGTH_LONG).show();

                }




            }
        });










       return  rootView;
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
