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


public class ThankYou extends Fragment {

    String  LOG_TAG = Account.class.getSimpleName();
    CollapsingToolbarLayout mcolapsingtoolbar ;
    Toolbar mToolBar ;

    Button account_continue ;
    EditText acc_number ;
    Spinner bankName ;
    TextView recipientAccountDetailView ;
    TextView newBalance ;



    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);





    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {


        View rootView = inflater.inflate(R.layout.activity_thankyou , container , false);

        mcolapsingtoolbar = ((CollapsingToolbarLayout)rootView.findViewById(R.id.collapsingtoolbar));
        mcolapsingtoolbar.setTitle(getResources().getString(R.string.account_detail));
        mToolBar = (Toolbar)rootView.findViewById(R.id.toolbar);


        Bundle bundle = getArguments();

        String amount_sent =  bundle.getString("amount_sent") ;

        int amount = Integer.parseInt(amount_sent) ;

        int main_balance =  70000 ;

        int current_balance = main_balance - amount ;

        newBalance = (TextView)rootView.findViewById(R.id.new_balanced) ;
        String curent_balanceStr = String.valueOf(current_balance);

        newBalance.setText(" Your Current Balance:" + curent_balanceStr);



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
