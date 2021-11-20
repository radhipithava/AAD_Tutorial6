package com.example.tutorial6_rp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {


    EditText edxemail , edxpass;
    Button btnlogin;
    SharedPreferences sharedPreferences;

    private static  final String SHARED_PREF_NAME="mypref";
    private static final String KEY_EMAIL="email";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        edxemail = findViewById(R.id.edxemail);
        edxpass = findViewById(R.id.edxpass);
        btnlogin = findViewById(R.id.btnlogin);

        sharedPreferences = getSharedPreferences(SHARED_PREF_NAME,MODE_PRIVATE);
        String name = sharedPreferences.getString(KEY_EMAIL,null);

        if (name != null){
            // if data is avelable so directly call on Homeactivity
            Intent intent =new Intent(MainActivity.this,welcome.class);
            startActivity(intent);
        }

        btnlogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if (edxemail.getText().toString().equals("admin@gmail.com")&& edxpass.getText().toString().equals("admin"))
                {
                    Intent intent  = new Intent(MainActivity.this,welcome.class);
                    startActivity(intent);
                    finish();
                }
                else if (edxpass.getText().toString().equals(""))
                {
                    Toast.makeText(MainActivity.this, "Enter Password...", Toast.LENGTH_SHORT).show();
                    edxpass.requestFocus();
                }
                else if(edxpass.getText().toString().equals(""))
                {
                    Toast.makeText(MainActivity.this, "Enter Valid MailAddredss", Toast.LENGTH_SHORT).show();
                    edxemail.requestFocus();
                }
            }
        });
    }
}