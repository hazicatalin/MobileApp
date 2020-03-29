package com.example.myapplication;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

import com.example.myapplication.R;

public class MainActivity extends AppCompatActivity {

    ListView pdfListView;

    Button preview_doc;
    String[] description = {"description", "description", "description", "description", "description", "description", "description", "description", "description", "description", "description", "description", "description", "description"};
    String[] title ={"agr1.pdf", "agr2.pdf", "agr3.pdf", "agr4.pdf", "agr5.pdf", "agr6.pdf", "agr7.pdf", "agr8.pdf", "agr9.pdf", "agr10.pdf", "agr11.pdf", "agr12.pdf", "agr13.pdf", "TEST PDF.pdf"};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        pdfListView = (ListView) findViewById(R.id.myPDFList);



        class MyAdapter extends ArrayAdapter<String> {
            Context context;
            String[] rTitle;
            String[] rDescription;

            MyAdapter(Context c, String title[], String[] description) {
                super(c, R.layout.custom_list, R.id.textView1, title);
                this.context = c;
                this.rTitle = title;
                this.rDescription = description;
            }

            @NonNull
            @Override
            public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
                LayoutInflater layoutInflater = (LayoutInflater) getApplicationContext().getSystemService(Context.LAYOUT_INFLATER_SERVICE);
                View view = super.getView(position, convertView, parent);
                TextView myDescription = view.findViewById(R.id.textView2);
                TextView myTitle = (TextView) view.findViewById(R.id.textView1);

                myTitle.setText(rTitle[position]);
                myDescription.setText(rDescription[position]);

                return view;
            }
        }
        MyAdapter adapter = new MyAdapter(this, title, description);
        pdfListView.setAdapter(adapter);
        pdfListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                 String item = (String) pdfListView.getItemAtPosition(position);
                 Intent start = new Intent(getApplicationContext(), ViewActivity.class);
                 start.putExtra("pdfFileName", title[position]);
                 Log.wtf("title:", title[position]);
                 Log.wtf("position:", " "+position);
                 startActivity(start);
            }
        });
    }
}