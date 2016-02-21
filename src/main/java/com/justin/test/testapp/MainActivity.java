package com.justin.test.testapp;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;

import java.util.logging.Handler;

public class MainActivity extends AppCompatActivity {
    private FloatingActionButton scannerButton;
    private SwipeRefreshLayout mSwipeRefreshLayout;
    ArrayAdapter<String> mAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        //getSupportActionBar().setDisplayShowTitleEnabled(false);

        mSwipeRefreshLayout = (SwipeRefreshLayout) findViewById(R.id.swipe_layout);

        String[] deviceList = new String[] {"iPhone 6", "iPhone 5","iPhone 5","iPhone 5","iPhone 5","iPhone 5","iPhone 5","iPhone 5","iPhone 5","iPhone 5","iPhone 5","iPhone 5","iPhone 5","iPhone 5","iPhone 5","iPhone 5","iPhone 5","iPhone 5","iPhone 5","iPhone 5","iPhone 5","iPhone 5","iPhone 5","iPhone 5","iPhone 5","iPhone 5","iPhone 5","iPhone 5","iPhone 5", "iPhone 4"};

        mAdapter = new ArrayAdapter<String>(this,
                R.layout.list_item, R.id.asset_name, deviceList);

        ListView deviceLv = (ListView) findViewById(R.id.device_list);
        deviceLv.setAdapter(mAdapter);

        mSwipeRefreshLayout.setOnRefreshListener(new SwipeRefreshLayout.OnRefreshListener() {
            @Override
            public void onRefresh() {
                refreshContent();
            }
        });

        scannerButton = (FloatingActionButton) findViewById(R.id.scannerButton);
        scannerButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent = new Intent(v.getContext(), BarcodeScanner.class);
                startActivity(intent);

            }
        });

    }

    private void refreshContent() {
        Snackbar.make(findViewById(R.id.swipe_layout), "No new data", Snackbar.LENGTH_SHORT).show();
        mSwipeRefreshLayout.setRefreshing(false);
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
