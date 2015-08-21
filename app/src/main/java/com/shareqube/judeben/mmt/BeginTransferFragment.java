package com.shareqube.judeben.mmt;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;

import android.support.design.widget.CollapsingToolbarLayout;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;


public class BeginTransferFragment extends Fragment {


    CollapsingToolbarLayout mcolapsingtoolbar ;
    EditText email , fullname , phoneNumber ;
    Button sendMoney ;



    // TODO: Rename and change types and number of parameters
    public static BeginTransferFragment newInstance() {
        BeginTransferFragment fragment = new BeginTransferFragment();
        Bundle args = new Bundle();

        fragment.setArguments(args);
        return fragment;
    }

    public BeginTransferFragment() {
        // Required empty public constructor
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
      View rootView =  inflater.inflate(R.layout.fragment_begin_transfer, container, false);

        mcolapsingtoolbar = ((CollapsingToolbarLayout)rootView.findViewById(R.id.collapsingtoolbar));
        mcolapsingtoolbar.setTitle(getResources().getString(R.string.app_title));

        email = (EditText) rootView.findViewById(R.id.email) ;
        fullname  =  (EditText) rootView.findViewById(R.id.fullname);
        phoneNumber = (EditText) rootView.findViewById(R.id.phoneNumber);
        sendMoney = (Button) rootView.findViewById(R.id.sendMoney) ;

        sendMoney.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

              continueMoney();
            }
        });


        return rootView ;
    }

    public void continueMoney(){
        String emailStr =  email.getText().toString() ;
        String fullnameStr = fullname.getText().toString();
        String phoneNumberStr = phoneNumber.getText().toString();

        if(emailStr.equals("") || fullnameStr.equals("") || phoneNumberStr.equals("")){
            Toast.makeText(getActivity() , " One of your field is empty, try it again" , Toast.LENGTH_LONG).show();
        }
        else {



            // use fragment instead

           Account account = new Account();
            Bundle arg = new Bundle();

            arg.putString("email" , emailStr);
            arg.putString("fullname" , fullnameStr);
            arg.putString("phoneNumber" ,phoneNumberStr);

            account.setArguments(arg);


            FragmentManager fragmentManager = getFragmentManager();
            fragmentManager.beginTransaction().replace(R.id.flContent, account).commit();

        }
    }



    @Override
    public void onAttach(Activity activity) {
        super.onAttach(activity);

    }

    @Override
    public void onDetach() {
        super.onDetach();

    }



}
