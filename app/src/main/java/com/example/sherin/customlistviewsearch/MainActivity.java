package com.example.sherin.customlistviewsearch;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.SearchView;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    ListView listView;
    private SearchView searchView;
    private int[]picture={R.drawable.bangladesh,R.drawable.india,R.drawable.pakistan,R.drawable.afghanistan_flag,R.drawable.china};
    private  String[]title={"Bangladesh","India","Pakistan","Afghanistan","China"};
    private CountryAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initView();
    }

    private void initView() {// View related
        listView=findViewById(R.id.listViewId);
        searchView=findViewById(R.id.searchId);
        adapter= new CountryAdapter(this,title,picture) ;
        listView.setAdapter(adapter);

        //Click
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                Toast.makeText(MainActivity.this, ""+title[i], Toast.LENGTH_SHORT).show();

            }
        });
        //Search
        searchView.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
            @Override
            public boolean onQueryTextSubmit(String s) {// text submit
                return false;
            }

            @Override
            public boolean onQueryTextChange(String s) {
                filter(s);//main activity

                return false;
            }
        });
    }

    private void filter(String netText) {
        ArrayList<String> filterTitle = new ArrayList<>();//title
        ArrayList<Integer>filterImage = new ArrayList<>();

        for(int i=0; i<title.length;i++)
        {
            if(title[i].toLowerCase().contains(netText.toLowerCase()))
            {
                filterImage.add(picture[i]);
                filterTitle.add((title[i]));
            }
        }
        String[] name=new String[filterTitle.size()];
        int[]pic=new int [filterImage.size()];
        for(int i=0;i<name.length;i++)
        {
            name[i]=filterTitle.get(i);
            pic[i]=filterImage.get(i);
        }
        adapter.filter(name,pic);
    }
}