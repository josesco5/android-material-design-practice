package com.example.applytheme;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    Toolbar toolbar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        toolbar = (Toolbar) findViewById(R.id.toolbar);
        toolbar.setTitle("Welcome!");
        toolbar.setSubtitle("Folks!");

        toolbar.inflateMenu(R.menu.menu_main);
        toolbar.setOnMenuItemClickListener(new Toolbar.OnMenuItemClickListener() {
            @Override
            public boolean onMenuItemClick(MenuItem item) {
                int id = item.getItemId();
                String msg = "";

                switch (id) {

                    case R.id.action_discard:
                        msg = "Delete";
                        break;

                    case R.id.action_search:
                        msg = "Search";
                        break;

                    case R.id.action_settings:
                        msg = "Settings";
                        break;

                    case R.id.action_edit:
                        msg = "Edit";
                        break;

                    case R.id.action_exit:
                        msg = "Exit";
                        break;
                }

                Toast.makeText(MainActivity.this, msg + " clicked!", Toast.LENGTH_SHORT).show();

                return true;
            }
        });
    }
}
