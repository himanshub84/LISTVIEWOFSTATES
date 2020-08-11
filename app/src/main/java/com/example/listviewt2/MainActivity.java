package com.example.listviewt2;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;
import android.view.ViewGroup;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {
    ListView TenStates;
    String[] states = new String[]
            {
                    "Rajasthan",
                    "Madhya Pradesh",
                    "Maharashtra",
                    "Uttar Pradesh",
                    "Gujarat",
                    "Karnataka",
                    "Andhra Pradesh",
                    "Odisha",
                    "Chhattisgarh",
                    "Tamil Nadu"
            };

    List<String> DiffStates;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        TenStates = (ListView) findViewById(R.id.states);

        DiffStates = new ArrayList<String>(Arrays.asList(states));

        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_2, android.R.id.text1, DiffStates) {

            @Override
            public View getView(int position, View convertView, ViewGroup parent) {

                View view = super.getView(position, convertView, parent);

                TextView ListItemShow = (TextView) view.findViewById(android.R.id.text1);


                return view;
            }
        };

        TenStates.setAdapter(adapter);
        TenStates.setOnItemClickListener(new AdapterView.OnItemClickListener()
        {

            @Override
            public void onItemClick(AdapterView<?> parent, View view,
                                    int position, long id) {
                Toast.makeText(MainActivity.this, "clicked item is " +states[position], Toast.LENGTH_SHORT).show();
            }
        });
    }
}