package com.example.secondapplication;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.text.TextUtils;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.SearchView;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private String[] mStrs = {"zyr111", "zyr222", "zyr333", "zyr444", "zyr555", "zyr666", "zyr777", "zyr888", "zyr999", "zyr123"
            , "zyr123", "zyr123", "zyr123", "zyr123", "zyr123", "zyr123", "zyr123", "zyr123", "zyr123"
            , "zyr123", "zyr123", "zyr123", "zyr123", "zyr123", "zyr123", "zyr123", "zyr123", "zyr123", "zyr123"
            , "zyr123", "zyr123", "这zyr123", "zyr123", "zyr123", "zyr123", "zyr123", "zyr123", "zyr123", "zyr123"
            , "zyr123", "zyr123", "这zyr123", "zyr123", "zyr123", "zyr123", "zyr123", "zyr123", "zyr123", "zyr123"
            , "zyr123", "zyr123", "这zyr123", "zyr123", "zyr123", "zyr123", "zyr123", "zyr123", "zyr123", "zyr123"

    };
    private SearchView mSearchView;
    private ListView lListView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mSearchView = (SearchView) findViewById(R.id.searchView);
        lListView = (ListView) findViewById(R.id.listView);
        lListView.setAdapter(new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, mStrs));
        lListView.setTextFilterEnabled(true);

        // 设置搜索文本监听
        mSearchView.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
            // 当点击搜索按钮时触发该方法
            @Override
            public boolean onQueryTextSubmit(String query) {
                return false;
            }

            // 当搜索内容改变时触发该方法
            @Override
            public boolean onQueryTextChange(String newText) {
                if (!TextUtils.isEmpty(newText)){
                    lListView.setFilterText(newText);
                }else{
                    lListView.clearTextFilter();
                }
                return false;
            }
        });
    }
}