package com.example.ayush.contextmenuxmlapplication;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.ContextMenu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    private ListView listView;
    private ArrayAdapter mAdapter;
    private ArrayList names;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        listView = (ListView) findViewById(R.id.myListView);
        names = new ArrayList();
        //for opions, I have created this listview
        names.add("Click here!!");

        mAdapter = new ArrayAdapter(MainActivity.this, android.R.layout.simple_list_item_1,names);
        //the adapter is then attached to the listview
        listView.setAdapter(mAdapter);
        //connects the listview to the context menu
        registerForContextMenu(listView);
    }

    @Override
    public void onCreateContextMenu(ContextMenu menu, View v, ContextMenu.ContextMenuInfo menuInfo) {
        super.onCreateContextMenu(menu, v, menuInfo);
        //from here on the context menu gets inflated
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.context_menu, menu);
    }

    @Override
    public boolean onContextItemSelected(MenuItem item) {
        switch (item.getItemId()){
            //When a specific context is chosen, the respective toast is displayed
            case R.id.context1:
                Toast.makeText(MainActivity.this, "Context 1 chosen", Toast.LENGTH_SHORT).show();
            case R.id.context2:
                Toast.makeText(MainActivity.this, "Context 2 chosen", Toast.LENGTH_SHORT).show();
            case R.id.context3:
                Toast.makeText(MainActivity.this, "Context 3 chosen", Toast.LENGTH_SHORT).show();
        }
        return super.onContextItemSelected(item);
    }
}
