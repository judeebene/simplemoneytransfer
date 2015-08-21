package com.shareqube.judeben.mmt;


import android.app.NotificationManager;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.CollapsingToolbarLayout;
import android.support.v4.app.NotificationCompat;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Spinner;

public class RecieveMoney extends AppCompatActivity {
    CollapsingToolbarLayout mcolapsingtoolbar ;
    Toolbar mToolBar ;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_recieve_money);

        mcolapsingtoolbar = ((CollapsingToolbarLayout)findViewById(R.id.collapsingtoolbar));
        mcolapsingtoolbar.setTitle(getResources().getString(R.string.title_activity_recieve_money));
        mToolBar = (Toolbar)findViewById(R.id.toolbar);

        NotificationCompat.Builder mBuilder =
                new NotificationCompat.Builder(this)
                        .setSmallIcon(R.mipmap.ic_launcher)
                        .setContentTitle("Received 10000 in your Account")
                        .setContentText("mobile money Transfer App");

        NotificationManager mNotificationManager =
                (NotificationManager) getSystemService(Context.NOTIFICATION_SERVICE);
// mId allows you to update the notification later on.
        mNotificationManager.notify(2, mBuilder.build());


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
