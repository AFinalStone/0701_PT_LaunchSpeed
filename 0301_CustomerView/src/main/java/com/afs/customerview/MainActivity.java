package com.afs.customerview;

import android.os.Bundle;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        test01();
    }

    private void test01() {
        int widthMeasureSpec = View.MeasureSpec.makeMeasureSpec(500, View.MeasureSpec.AT_MOST);
        System.out.println("widthMeasureSpec=======" + widthMeasureSpec);
    }
}