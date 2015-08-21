package com.shareqube.judeben.mmt;


import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.CollapsingToolbarLayout;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;

public class SendMoney extends AppCompatActivity {
    CollapsingToolbarLayout mcolapsingtoolbar ;
    Toolbar mToolBar ;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_send_money);

        mcolapsingtoolbar = ((CollapsingToolbarLayout)findViewById(R.id.collapsingtoolbar));
        mcolapsingtoolbar.setTitle(getResources().getString(R.string.app_title));
        mToolBar = (Toolbar)findViewById(R.id.toolbar);



    }

    public  void login(View v){
        Intent  mainIntent = new Intent(this , Navigation.class) ;
        mainIntent.putExtra("Username", "Imaobong");
        startActivity(mainIntent);

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
}
