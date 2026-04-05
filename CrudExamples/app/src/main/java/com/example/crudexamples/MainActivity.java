package com.example.crudexamples;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;
import android.database.Cursor;
import androidx.appcompat.app.AppCompatActivity;

import java.text.BreakIterator;

public class MainActivity extends AppCompatActivity {
    private EditText cName, cTrack, cDuration, cDes;
    private TextView txt;
    private Button addBtn, update, delete, show;
    private DBHandler dbHandler;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        cName = findViewById(R.id.CourseName);
        cTrack = findViewById(R.id.CourseTracks);
        cDuration = findViewById(R.id.CourseDuration);
        cDes = findViewById(R.id.CourseDescription);
        addBtn = findViewById(R.id.BtnAdd);
        update = findViewById(R.id.Btnupdate);
        delete = findViewById(R.id.Btndelete);
        show = findViewById(R.id.Btnshow);
        txt = findViewById(R.id.txt);

        // FIXED: Removed "DBHandler" prefix to use the class-level variable
        dbHandler = new DBHandler(MainActivity.this);

        addBtn.setOnClickListener(v -> {
            String cN = cName.getText().toString();
            String cD = cDuration.getText().toString();
            String cDescr = cDes.getText().toString();
            String cT = cTrack.getText().toString();

            if (cN.isEmpty() || cT.isEmpty() || cD.isEmpty() || cDescr.isEmpty()) {
                Toast.makeText(MainActivity.this, "Please enter all the data..", Toast.LENGTH_SHORT).show();
                return;
            }

            dbHandler.addNewCourse(cN, cD, cDescr, cT);
            Toast.makeText(MainActivity.this, "Course has been added.", Toast.LENGTH_SHORT).show();

            cName.setText("");
            cDuration.setText("");
            cTrack.setText("");
            cDes.setText("");
        });

        show.setOnClickListener(v -> {
            Cursor cursor = dbHandler.readCourses();
            if (cursor.getCount() == 0) {
                txt.setText("No data found");
            } else {
                StringBuilder builder = new StringBuilder();
                while (cursor.moveToNext()) {
                    // Use getColumnIndexOrThrow for safer data retrieval
                    String name = cursor.getString(cursor.getColumnIndexOrThrow("name"));
                    String duration = cursor.getString(cursor.getColumnIndexOrThrow("duration"));
                    builder.append("Course: ").append(name).append("\nDuration: ").append(duration).append("\n\n");
                }
                txt.setText(builder.toString());
            }
            cursor.close();
        });

        update.setOnClickListener(v -> {
            boolean isUpdated = dbHandler.updateCourse(
                    cName.getText().toString(),
                    cDuration.getText().toString(),
                    cDes.getText().toString(),
                    cTrack.getText().toString()
            );

            if (isUpdated) {
                Toast.makeText(MainActivity.this, "Course updated", Toast.LENGTH_SHORT).show();
            } else {
                Toast.makeText(MainActivity.this, "Update failed (Ensure name matches)", Toast.LENGTH_SHORT).show();
            }
        });

        delete.setOnClickListener(v -> {
            boolean isDeleted = dbHandler.deleteCourse(cName.getText().toString());
            if (isDeleted) {
                Toast.makeText(MainActivity.this, "Course deleted", Toast.LENGTH_SHORT).show();
                cName.setText("");
            } else {
                Toast.makeText(MainActivity.this, "Delete failed", Toast.LENGTH_SHORT).show();
            }
        });
    }
}