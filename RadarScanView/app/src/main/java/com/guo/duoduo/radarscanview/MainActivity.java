package com.guo.duoduo.radarscanview;


import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import androidx.appcompat.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;

import com.guo.duoduo.library.RadarScanView;
import com.guo.duoduo.randomtextview.RandomTextView;


public class MainActivity extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        final RandomTextView randomTextView = (RandomTextView) findViewById(
            R.id.random_textview);

        final RadarScanView scanView = findViewById(R.id.scan_view);
        final Button mBtnScan = findViewById(R.id.button_scan);
        randomTextView.setOnRippleViewClickListener(
            new RandomTextView.OnRippleViewClickListener()
            {
                @Override
                public void onRippleViewClicked(View view)
                {
                    MainActivity.this.startActivity(
                        new Intent(MainActivity.this, RefreshProgressActivity.class));
                }
            });

        mBtnScan.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                scanView.toggle();
            }
        });

        new Handler().postDelayed(new Runnable()
        {
            @Override
            public void run()
            {
                randomTextView.addKeyWord("彭丽媛");
                randomTextView.addKeyWord("习近平");
                randomTextView.show();
            }
        }, 2 * 1000);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu)
    {
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item)
    {
        int id = item.getItemId();
        if (id == R.id.action_settings)
        {
            return true;
        }
        return super.onOptionsItemSelected(item);
    }
}
