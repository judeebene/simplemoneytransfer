package com.shareqube.judeben.mmt;




import android.app.Activity;
import android.app.PendingIntent;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.CollapsingToolbarLayout;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.telephony.SmsManager;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Calendar;
import java.util.Locale;

public class ConfirmTransfer extends Fragment {
    String LOG_TAG = ConfirmTransfer.class.getSimpleName() ;
    String phoneNumberStr = "" ;
    CollapsingToolbarLayout mcolapsingtoolbar ;
    Toolbar mToolBar ;
    TextView  confirm_BankName , confirm_message , confirm_accountNumber , confirm_fee , confirm_total ;
    Button transferNowBtn ;
    String message = "transfer message" ;
    String confirm_message1 = "confirm message" ;

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
        final String amountStr = data.getString("amount") ;
        phoneNumberStr  = data.getString("phoneNumber") ;
        String recipientNameStr = data.getString("fullname") ;

        Log.e(LOG_TAG ,"Time" + currentTime() +  " Date" + currentDate()) ;

        int amountbb = Integer.parseInt(amountStr) ;
        String current_balance =  String.valueOf(amountbb + 18000) ;

        message  =  "Imaobong MT Alert:" + amountStr + "NGN" + " has been  transfer to " + recipientNameStr + "Account" + "Account Number: " + accountNumberStr  + " " + bankNameStr + " Arrived at"  +  currentTime() + " On " + currentDate()  + "Current Balance:" + current_balance   ;
        confirm_message1  =  "Imaobong Mobile Transfer Alert:" + amountStr + "NGN" + " will be  transfer to " + recipientNameStr + "Account" + "Account Number: " + accountNumberStr  + " " + bankNameStr + ", now "  +  currentTime() + " On " + currentDate()  + "Current Balance:" + current_balance +  "Thank you for using our service,";

        confirm_BankName = (TextView) rootView.findViewById(R.id.confirm_bankName);
        confirm_BankName.setText(bankNameStr);

        confirm_message = (TextView) rootView.findViewById(R.id.confirm_message);
        confirm_message.setText(confirm_message1);

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







        transferNowBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {


                sendSMSNotification(phoneNumberStr , amountStr);


            }
        });





        return  rootView ;


    }


   public void sendSMSNotification(String phoneNumer , String amount_sent){

      PendingIntent  smsState = PendingIntent.getBroadcast(getActivity(), 0, new Intent("DELIVERED"), 0);
       PendingIntent sendingIntent = PendingIntent.getBroadcast(getActivity(), 0, new Intent("SENDING"), 0);


       getActivity().registerReceiver(new smsSendMonitor(), new IntentFilter("SENDING"));

            Log.e(LOG_TAG , "phone number " + phoneNumer) ;

       try {
           SmsManager smsManager = SmsManager.getDefault();
          // smsManager.sendTextMessage(phoneNumer, null, message, sendingIntent, smsState);
           smsManager.sendTextMessage(phoneNumer, null, message, null, null);

           Toast.makeText(getActivity(), "SMS sent.", Toast.LENGTH_LONG).show();


           ThankYou thankYou = new ThankYou();
           Bundle  bundleAmt = new Bundle();
            bundleAmt.putString("amount_sent",amount_sent);
            thankYou.setArguments(bundleAmt);

           FragmentManager thankyouManager = getFragmentManager() ;

           thankyouManager.beginTransaction().replace(R.id.flContent , thankYou).commit();



       }

       catch (Exception e) {
           Toast.makeText(getActivity(), "SMS failed, please try again.", Toast.LENGTH_LONG).show();
           e.printStackTrace();
       }
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


    public static String currentTime()
    {
        Calendar cal = Calendar.getInstance(new Locale("US"));

        int am_pm = cal.get(Calendar.AM_PM);

        String amORpm = (am_pm==0)? "AM" : "PM";

        int minute = cal.get(Calendar.MINUTE);
        int hour = cal.get(Calendar.HOUR);

        String mytime = hour + ":" + minute + " " + amORpm;

        return mytime;
    }

    public static String currentDate(){

        Calendar cal = Calendar.getInstance(new Locale("US"));

        int day = cal.get(Calendar.DAY_OF_MONTH);
        int month = cal.get(Calendar.MONTH) + 1;
        int year = cal.get(Calendar.YEAR);

        String myDate = day + "/" + month + "/" + year;


        return   myDate ;
    }


    public  static class smsSendMonitor extends BroadcastReceiver
    {

       // TextMessageManager tm = new TextMessageManager();


        @Override
        public void onReceive(Context c, Intent i) {

            Toast.makeText(c, " message sending monitored! ", Toast.LENGTH_LONG).show();
            String smsStatus = "true";

            switch (getResultCode())
            {
                case Activity.RESULT_OK:
                    Toast.makeText(c, "SMS sent", Toast.LENGTH_SHORT).show();
                    smsStatus = "true";
                    break;
                case SmsManager.RESULT_ERROR_GENERIC_FAILURE:
                    Toast.makeText(c, "Generic failure", Toast.LENGTH_SHORT).show();
                    smsStatus = "false";
                    break;
                case SmsManager.RESULT_ERROR_NO_SERVICE:
                    Toast.makeText(c, "No service", Toast.LENGTH_SHORT).show();
                    smsStatus = "false";
                    break;
                case SmsManager.RESULT_ERROR_NULL_PDU:
                    Toast.makeText(c, "Null PDU", Toast.LENGTH_SHORT).show();
                    smsStatus = "false";
                    break;
                case SmsManager.RESULT_ERROR_RADIO_OFF:
                    Toast.makeText(c, "Radio off", Toast.LENGTH_SHORT).show();
                    smsStatus = "false";
                    break;
            }



        }

    }



}
