package com.example.chieh.imagetrial;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    ArrayList<Tag> tagList = new ArrayList<>();
    int imageList[] = new int[6];


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        tagList = new ArrayList<>();
        createTAG();
        populateListView();
        registerClickCallBack();



    }




    public void createTAG(){
        tagList.add(new Tag("baseball",R.drawable.baseball));
//        tagList.add(new Tag("cricket",R.drawable.cricket));
        tagList.add(new Tag("rugby",R.drawable.rugby));
        tagList.add(new Tag("volleyball",R.drawable.volleyball));
        tagList.add(new Tag("swimming",R.drawable.swimming));
        tagList.add(new Tag("basketball", R.drawable.basketball));



    }

    private void populateListView() {
        ArrayAdapter<Tag> adapter = new MyListAdapter();
        ListView list = (ListView) findViewById(R.id.tagListView);
        list.setAdapter(adapter);
    }

    private class MyListAdapter extends ArrayAdapter<Tag>{

        public MyListAdapter(){
            super(MainActivity.this,R.layout.item_view,tagList);
        }

        @Override
        public View getView(int position, View convertView, ViewGroup parent) {
            //Make sure we have a view to get with(may have been given null)
            View itemView = convertView;
            if (itemView == null)
                itemView = getLayoutInflater().inflate(R.layout.item_view,parent,false);

            //Find the tag to work with
            Tag currentTag = tagList.get(position);

            //Fill the view
            ImageView imageView = (ImageView) itemView.findViewById(R.id.item_icon);
            imageView.setImageResource(currentTag.getIconId());

            //make
            TextView makeText = (TextView) itemView.findViewById(R.id.item_txtMake);
            makeText.setText(currentTag.tagName);

            //year
            int counter = 2000;
            TextView yearText = (TextView) itemView.findViewById(R.id.item_txtYear);
            yearText.setText(Integer.toString(counter++));

            //condition
            TextView conditionText = (TextView) itemView.findViewById(R.id.txtCondition);
            conditionText.setText(currentTag.toString());

            return itemView;

        }


    }
    private void registerClickCallBack() {
        ListView list = (ListView) findViewById(R.id.tagListView);
        list.setOnItemClickListener(new AdapterView.OnItemClickListener(){
            @Override
            public void onItemClick(AdapterView<?> parent, View viewClicked, int position, long id) {
                Tag clickedCar = tagList.get(position);
                String message = "Which is tag is clicked: " +
                        clickedCar.tagName;
                Toast.makeText(MainActivity.this,message,Toast.LENGTH_LONG).show();
            }
        });


    }



}
