package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;

import com.github.barteksc.pdfviewer.PDFView;

public class ViewActivity extends AppCompatActivity {

    PDFView myPDFViewer;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view);

        myPDFViewer=(PDFView)findViewById(R.id.pdfViewer);

        Intent intent = getIntent();
        Bundle extras = intent.getExtras();
        String getItem = extras.getString("pdfFileName");

        Log.wtf("getItem: ", getItem);
        myPDFViewer.fromAsset(getItem).load();

    }
}
