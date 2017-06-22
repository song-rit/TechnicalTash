package com.example.awidcha.technicaltask.ui;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.awidcha.technicaltask.R;
import com.example.awidcha.technicaltask.model.UserModel;
import com.example.awidcha.technicaltask.utils.DBHelper;

public class FormActivity extends AppCompatActivity {

    private Button mButtonSubmit;
    private EditText mEditTextFullName;
    private EditText mEditTextNickName;
    private DBHelper mHelper;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_form);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setDisplayShowTitleEnabled(false);
        mHelper = new DBHelper(this);

        infixView();
        addForm();
    }

    private void infixView() {
        mButtonSubmit = (Button) findViewById(R.id.button_submit);
        mEditTextFullName = (EditText) findViewById(R.id.edit_text_name);
        mEditTextNickName = (EditText) findViewById(R.id.edit_text_nick_name);

    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
    }

    private void addForm() {

        mButtonSubmit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                UserModel user = new UserModel();
                user.setFullName(mEditTextFullName.getText().toString());
                user.setNickName(mEditTextNickName.getText().toString());
                mHelper.addUser(user);

                Toast.makeText(getApplicationContext(), "Success", Toast.LENGTH_SHORT).show();
                finish();
            }
        });

    }

}
