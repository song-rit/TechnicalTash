package com.example.awidcha.technicaltask.ui;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.ImageButton;
import android.widget.ListView;
import android.widget.Toast;

import com.example.awidcha.technicaltask.R;
import com.example.awidcha.technicaltask.adapter.ListViewUserAdapter;
import com.example.awidcha.technicaltask.model.UserModel;
import com.example.awidcha.technicaltask.utils.DBHelper;

import java.util.ArrayList;
import java.util.List;

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

        infixView();

        mButtonAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(getApplicationContext(), "Hello World", Toast.LENGTH_SHORT).show();
            }
        });


        UserModel a = new UserModel();
        a.setFullName("Songrit Maleerat");
//
//        userModels.add(a);
//        userModels.add(a);
//        userModels.add(a);
        mHelper = new DBHelper(this);
        mHelper.addUser(a);

        userModels = new ArrayList<>(mHelper.getAllUser());

        ListViewUserAdapter adapter = new ListViewUserAdapter(this, userModels);
        mListView.setAdapter(adapter);

        }

    private void infixView() {
        mButtonAdd = (ImageButton) mToolbar.findViewById(R.id.button_add);
        mListView = (ListView) findViewById(R.id.list_view);
    }
}
