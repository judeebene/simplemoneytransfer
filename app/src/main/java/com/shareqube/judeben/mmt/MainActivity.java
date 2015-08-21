package com.shareqube.judeben.mmt;


import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.support.design.widget.CollapsingToolbarLayout;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    CollapsingToolbarLayout mcolapsingtoolbar ;
    Toolbar mToolBar ;
    public static String USER_PREF = "USER_PREF";

    EditText username;
    EditText password ;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mcolapsingtoolbar = ((CollapsingToolbarLayout)findViewById(R.id.collapsingtoolbar));
        mcolapsingtoolbar.setTitle(getResources().getString(R.string.app_title));
        mToolBar = (Toolbar)findViewById(R.id.toolbar);


        SharedPreferences users = getSharedPreferences(USER_PREF , 1);
        SharedPreferences.Editor editor =  users.edit();
        editor.putString("username","imabong");
        editor.putString("password", "imaobong");

        editor.commit() ;

        username = (EditText) findViewById(R.id.username) ;
        password = (EditText) findViewById(R.id.password);




    }

    public  void login(View v){

        String usernameStr = username.getText().toString() ;
        String passwordStr = password.getText().toString() ;

        if(usernameStr.equals("") || passwordStr.equals("")){
            Toast.makeText(this , "Username or Password is Empty", Toast.LENGTH_LONG).show();
        }else {



            // start Intent to Nav

            String[] users = getCurentUser(this);
            if( users[0].equals(usernameStr) &&  users[1].equals(passwordStr)){
                Intent  mainIntent = new Intent(this , Navigation.class) ;

                startActivity(mainIntent);

            }
            else {
                Toast.makeText(this , "Username or Password is not correct",Toast.LENGTH_LONG).show();
            }




        }





    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
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

    public static String[] getCurentUser(Context context) {

        SharedPreferences preferences = PreferenceManager.getDefaultSharedPreferences(context);

        String username = preferences.getString(context.getString(R.string.username),
                context.getString(R.string.defaultValue));

        String password = preferences.getString(context.getString(R.string.password),
                context.getString(R.string.defaultPassword));

        String[] credential ={ username ,password} ;




        return credential;

    }
}
