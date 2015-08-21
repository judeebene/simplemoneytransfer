package com.shareqube.judeben.mmt;



import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.CollapsingToolbarLayout;
import android.support.v4.app.Fragment;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;
import android.widget.TextView;

public class ConfirmTransfer extends Fragment {
    CollapsingToolbarLayout mcolapsingtoolbar ;
    Toolbar mToolBar ;
    TextView  confirm_BankName , confirm_message , confirm_accountNumber , confirm_fee , confirm_total ;
    Button transferNowBtn ;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        View rootView = inflater.inflate(R.layout.activity_confirm_transfer, container, false) ;
        mcolapsingtoolbar = ((CollapsingToolbarLayout) rootView.findViewById(R.id.collapsingtoolbar));
        mcolapsingtoolbar.setTitle(getResources().getString(R.string.title_activity_confirm_transfer));
        mToolBar = (Toolbar)rootView.findViewById(R.id.toolbar);

        Bundle data = getArguments() ;
        String accountNumberStr = data.getString("account") ;
        String bankNameStr = data.getString("bankName");
        String amountStr = data.getString("amount") ;
        String phoneNumberStr = data.getString("phoneNumber") ;

        confirm_BankName = (TextView) rootView.findViewById(R.id.confirm_bankName);
        confirm_BankName.setText(bankNameStr);

        confirm_message = (TextView) rootView.findViewById(R.id.confirm_message);

        confirm_accountNumber = (TextView) rootView.findViewById(R.id.confirm_accountNumber);
        confirm_accountNumber.setText(accountNumberStr);

        int amount = Integer.parseInt(amountStr) ;

        int process_fee = (amount/100) * 4 ;

        String feeStr = String.valueOf(process_fee) ;

        confirm_fee = (TextView) rootView.findViewById(R.id.confirm_fee);
        confirm_fee.setText(feeStr);

        int total  = amount + process_fee ;
        String totalStr = String.valueOf(total);

        confirm_total = (TextView) rootView.findViewById(R.id.confirm_total);
        confirm_total.setText(totalStr);
        transferNowBtn = (Button) rootView.findViewById(R.id.transferNowBtn) ;

        // get the data from previous fragment





        transferNowBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                String message = " " ;

            }
        });



       

        return  rootView ;


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
