package com.example.rishavz_sagar.application;

import android.database.Cursor;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuItem;

import java.io.IOException;
import java.util.ArrayList;

public class MainActivity extends AppCompatActivity implements Navigation_drawer.NavigationDrawerCallbacks{

    private Navigation_drawer mNavigationDrawerFragment;
    public static ArrayList<Message> messages;
    SQLiteDatabase mydb;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.content_main);

        ActionBar actionBar;
        actionBar = getSupportActionBar();
        ColorDrawable colorDrawable = new ColorDrawable(Color.parseColor("#5C6BC0"));
        actionBar.setBackgroundDrawable(colorDrawable);

        getSupportFragmentManager().beginTransaction().add(R.id.frame1,new Reminder(),"Reminder").commit();
        mNavigationDrawerFragment = (Navigation_drawer)
                getSupportFragmentManager().findFragmentById(R.id.navigation_drawer);

        // Set up the drawer.
        mNavigationDrawerFragment.setUp(
                R.id.navigation_drawer,
                (DrawerLayout) findViewById(R.id.drawer_layout));


        Sqlite_Helper db=new Sqlite_Helper(this);

        try {
            db.createDataBase();
        } catch (IOException e) {
            e.printStackTrace();
        }

        try
        {
            mydb=db.openDataBase();
        }
        catch (SQLException e)
        {
            e.printStackTrace();
        }


        /*
        Reading the content of table chats stored in messages.sqlite database in asset folder
        for Chat fragment.
        The Content of the fragment is updated in onActivityCreated

         */

        String query="SELECT * FROM chats";
        Cursor c = mydb.rawQuery(query, null);
        messages=new ArrayList<Message>();
        if(c.moveToFirst())
        {
            do {
                String message=c.getString(1),other=c.getString(2);
                int type=Integer.valueOf(c.getString(3));
                messages.add(new Message(message,other,type));
            }while (c.moveToNext());
        }
    }

    public void restoreActionBar() {
        ActionBar actionBar = getSupportActionBar();
        actionBar.setNavigationMode(ActionBar.NAVIGATION_MODE_STANDARD);
        actionBar.setDisplayShowTitleEnabled(true);
        actionBar.setHomeAsUpIndicator(R.drawable.ic_drawer);
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        restoreActionBar();
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
    public void clo()
    {
        finish();
    }

    @Override
    public void onNavigationDrawerItemSelected(int position) {
        switch (position) {
            case 0:
                getSupportFragmentManager().beginTransaction().replace(R.id.frame1,new Reminder(),"Reminder").commit();
                break;
            case 1:
                getSupportFragmentManager().beginTransaction().replace(R.id.frame1,new Image_downloader(),"Downloader").commit();
                break;
            case 2:
                getSupportFragmentManager().beginTransaction().replace(R.id.frame1,new ChatFragment(),"Chatting").commit();
                break;
        }
    }
}
