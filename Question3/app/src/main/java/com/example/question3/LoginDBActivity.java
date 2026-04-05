package com.example.question3;

import android.database.Cursor;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class LoginDBActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle b) {
        super.onCreate(b);
        setContentView(R.layout.activity_main); // ✅ MATCHES XML

        EditText etUsername = findViewById(R.id.etUsername);
        EditText etPassword = findViewById(R.id.etPassword);
        Button btnLogin = findViewById(R.id.btnLogin);

        DBHelper db = new DBHelper(this);
        db.getWritableDatabase(); // create DB safely

        btnLogin.setOnClickListener(v -> {

            String u = etUsername.getText().toString();
            String p = etPassword.getText().toString();

            Cursor c = db.getReadableDatabase().rawQuery(
                    "SELECT * FROM users WHERE username=? AND password=?",
                    new String[]{u, p}
            );

            if (c.getCount() > 0)
                Toast.makeText(this, "Login Successful", Toast.LENGTH_SHORT).show();
            else
                Toast.makeText(this, "Login Failed", Toast.LENGTH_SHORT).show();

            c.close();
        });
    }
}