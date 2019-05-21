package com.example.fragment01;

import android.os.Debug;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    ViewPager pager;
    Button btn_first, btn_second;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        pager = (ViewPager) findViewById(R.id.pager);
        btn_first = (Button)findViewById(R.id.btn_first);
        btn_second = (Button)findViewById(R.id.btn_second);

        pager.setAdapter(new pagerAdapter(getSupportFragmentManager()));
        pager.setCurrentItem(0);

        View.OnClickListener movePageListener = new View.OnClickListener(){

            @Override
            public void onClick(View v) {
                int tag = (int)v.getTag();
                pager.setCurrentItem(tag);
            }
        };

        btn_first.setOnClickListener(movePageListener);
        btn_first.setTag(0);
        btn_second.setOnClickListener(movePageListener);
        btn_second.setTag(1);

        Log.e("Main2Activity", "HHHHHH");
    }

    private class pagerAdapter extends FragmentStatePagerAdapter {
        public pagerAdapter(FragmentManager fm){
            super(fm);
        }

        @Override
        public Fragment getItem(int i) {
            switch (i){
                case 0:
                    Log.e("e", "Fragment1");
                    return new Fragment1();
                case 1:
                    Log.e("e", "Fragment2");
                    return new Fragment2();
                    default:
                        return null;
            }
        }

        @Override
        public int getCount() {
            return 2;
        }
    }
}
