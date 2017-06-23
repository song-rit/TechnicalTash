package com.example.awidcha.technicaltask.ui;

import android.app.AlarmManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.ListView;
import android.widget.Toast;

import com.example.awidcha.technicaltask.R;
import com.example.awidcha.technicaltask.adapter.ListViewUserAdapter;
import com.example.awidcha.technicaltask.model.UserModel;
import com.example.awidcha.technicaltask.utils.DBHelper;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;
import java.util.TimerTask;

public class MainActivity extends AppCompatActivity {

    private ListView mListView;
    private Toolbar mToolbar;
    private ImageButton mButtonAdd;
    private DBHelper mHelper;
    private List<UserModel> userModels;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mToolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(mToolbar);
        mHelper = new DBHelper(this);

        clearDataBase();
        initDataBase();

        infixView();

        mButtonAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, FormActivity.class);
                startActivity(intent);
            }
        });


    }

    @Override
    protected void onResume() {
        super.onResume();

        displayListView();
    }

    private void displayListView() {

        userModels = new ArrayList<>(mHelper.getAllUser());
        ListViewUserAdapter adapter = new ListViewUserAdapter(this, userModels);
        mListView.setAdapter(adapter);
    }

    private void clearDataBase() {
        mHelper.deleteAllUser();
    }

    private void initDataBase() {
        UserModel user = new UserModel();
        user.setFullName("Songrit Maleerat");
        user.setNickName("Jame");
        mHelper.addUser(user);
    }

    private void infixView() {
        mButtonAdd = (ImageButton) mToolbar.findViewById(R.id.button_add);
        mListView = (ListView) findViewById(R.id.list_view);

    }

}
