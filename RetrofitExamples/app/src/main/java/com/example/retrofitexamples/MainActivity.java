package com.example.retrofitexamples;

import android.annotation.SuppressLint;
import android.app.ProgressDialog;
import android.os.AsyncTask;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

public class MainActivity extends AppCompatActivity {

    private TextView resultsTextView;
    private Button displayData;

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Initialize UI components
        resultsTextView = findViewById(R.id.results);
        displayData = findViewById(R.id.displayData);

        displayData.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // FIXED: Use .execute() NOT .onPostExecute()
                // .execute() triggers the background thread.
                MyAsyncTasks myAsync = new MyAsyncTasks();
                myAsync.execute("https://jsonplaceholder.typicode.com/posts");
            }
        });
    }

    public class MyAsyncTasks extends AsyncTask<String, String, String> {
        ProgressDialog progressDialog;

        @Override
        protected void onPreExecute() {
            super.onPreExecute();
            progressDialog = new ProgressDialog(MainActivity.this);
            progressDialog.setMessage("Processing results...");
            progressDialog.setCancelable(false);
            progressDialog.show();
        }

        @Override
        protected String doInBackground(String... params) {
            StringBuilder result = new StringBuilder();
            HttpURLConnection urlConn = null;
            try {
                URL url = new URL(params[0]);
                urlConn = (HttpURLConnection) url.openConnection();
                InputStream in = urlConn.getInputStream();
                InputStreamReader isw = new InputStreamReader(in);

                int data = isw.read();
                while (data != -1) {
                    result.append((char) data);
                    data = isw.read();
                }
                return result.toString();
            } catch (Exception e) {
                return "Error: " + e.getMessage();
            } finally {
                if (urlConn != null) {
                    urlConn.disconnect();
                }
            }
        }

        @Override
        protected void onPostExecute(String s) {
            if (progressDialog != null && progressDialog.isShowing()) {
                progressDialog.dismiss();
            }

            try {
                // ADJUSTED FOR JSONPLACEHOLDER:
                // That API returns an Array directly [ {...}, {...} ]
                // If your own API uses {"Users": [...]}, keep your original logic.

                JSONArray jArray1 = new JSONArray(s);
                JSONObject jObj1 = jArray1.getJSONObject(0);

                String id = jObj1.getString("id");
                String title = jObj1.getString("title"); // Use "title" for this specific API
                String my_users = "User: " + id + "\n" + "Title: " + title;

                resultsTextView.setVisibility(View.VISIBLE);
                resultsTextView.setText(my_users);

            } catch (JSONException e) {
                e.printStackTrace();
                resultsTextView.setText("JSON Error: " + e.getMessage());
            }
        }
    }
}