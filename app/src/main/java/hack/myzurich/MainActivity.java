package hack.myzurich;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;

public class MainActivity extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        postRequest();
        getRequest();

    }

    void postRequest()
    {
        final Button post_button = findViewById(R.id.post_id);
        post_button.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                System.out.println("This is a post");

                EditText sleep_input = (EditText)findViewById(R.id.sleep);
                EditText pain_input = (EditText)findViewById(R.id.pain);
                EditText water_input = (EditText)findViewById(R.id.water);

                String sleep = sleep_input.getText().toString();
                String pain = pain_input.getText().toString();
                String water = water_input.getText().toString();

                System.out.println("input: " + sleep + pain + water);

                // Instantiate the RequestQueue.
                RequestQueue queue = Volley.newRequestQueue(getApplicationContext());
                String url ="https://script.google.com/macros/s/AKfycby_J-YAi-S4DdH2WSwMOB3SjOzIqWCYqRC1fEg2ddkNJroOXiF6/exec?";

                url = url + "sleep=" + sleep + "&pain=" + pain + "&water=" + water;

                // Request a string response from the provided URL.
                StringRequest stringRequest = new StringRequest(Request.Method.POST, url,
                        new Response.Listener<String>()
                        {
                            @Override
                            public void onResponse(String response) {
                                // Display the first 500 characters of the response string.
                                System.out.println("response" + response.toString());
                            }
                        },

                        new Response.ErrorListener()
                        {
                            @Override
                            public void onErrorResponse(VolleyError error)
                            {
                                System.out.println("That didn't work!!!");
                            }
                        });


                // Add the request to the RequestQueue.
                queue.add(stringRequest);
                System.out.println("done POST");


            }
        });
    }

    void getRequest()
    {
        final Button post_button = findViewById(R.id.view_id);
        post_button.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                System.out.println("This is a GET");
                final TextView mTextView = (TextView) findViewById(R.id.text);

                // Instantiate the RequestQueue.
                RequestQueue queue = Volley.newRequestQueue(getApplicationContext());
                String url ="https://script.google.com/macros/s/AKfycby_J-YAi-S4DdH2WSwMOB3SjOzIqWCYqRC1fEg2ddkNJroOXiF6/exec";

                // Request a string response from the provided URL.
                StringRequest stringRequest = new StringRequest(Request.Method.GET, url,
                        new Response.Listener<String>()
                        {
                            @Override
                            public void onResponse(String response) {
                                // Display the first 500 characters of the response string.
                                System.out.println("response" + response.toString());
                            }
                        },

                        new Response.ErrorListener()
                        {
                            @Override
                            public void onErrorResponse(VolleyError error)
                            {
                                System.out.println("That didn't work!!!");
                            }
                        });


                // Add the request to the RequestQueue.
                queue.add(stringRequest);
                System.out.println("done GET");


            }
        });
    }

}



