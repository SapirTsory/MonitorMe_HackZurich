package hack.myzurich;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.TextView;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;

public class MainActivity extends AppCompatActivity {
    String url ="https://script.google.com/macros/s/AKfycby_J-YAi-S4DdH2WSwMOB3SjOzIqWCYqRC1fEg2ddkNJroOXiF6/exec?";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        postRequest();


    }

    void postRequest()
    {
        final Button post_button = findViewById(R.id.post_id);
        post_button.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                System.out.println("This is a post");

                EditText sleep_input = (EditText)findViewById(R.id.Sleep_Duration);
                EditText pain_intens_input = (EditText)findViewById(R.id.Pain_Intensity);
                EditText stress_input = (EditText)findViewById(R.id.Stress_Level);
                EditText pain_duration_input = (EditText)findViewById(R.id.Pain_Duration);

                String sleep = sleep_input.getText().toString();
                String pain_intens = pain_intens_input.getText().toString();
                String stress = stress_input.getText().toString();
                String pain_dur = pain_duration_input.getText().toString();

                System.out.println("input: " + sleep + pain_intens + stress + pain_dur);

                // Instantiate the RequestQueue.

                url += "&sleep=" + sleep + "&pain_intens=" + pain_intens + "&stress=" + stress + "&pain_dur=" + pain_dur;
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
                System.out.println("Final url: "+url);
                RequestQueue queue = Volley.newRequestQueue(getApplicationContext());
                queue.add(stringRequest);
                System.out.println("done POST");
            }
        });
    }



    public void onCeckboxClicked(View view){
        boolean checked = ((CheckBox) view).isChecked();
        int alcohol = 0;
        int coffee = 0;
        int cheese = 0;
        int chocolate = 0;
        // Check which checkbox was clicked
        switch(view.getId()) {
            case R.id.Alcohol:
                if (checked)
                    alcohol = 1;
                url += "&alcohol=" + alcohol;
                break;
            case R.id.Coffee:
                if (checked)
                    coffee = 1;
                url += "&coffee=" + coffee;
                break;
            case R.id.Chocolate:
                System.out.println("chocoooo");
                if (checked){
                    chocolate = 1;
                    System.out.println("cheched");
                }
                url += "&chocolate=" + chocolate;
                System.out.println("url is" + url);
                break;
            case R.id.Cheese:
                if (checked)
                    cheese = 1;
                url += "&cheese=" + cheese;
                break;
            default:
                break;
        }

    }

//    void getRequest()
//    {
//        final Button post_button = findViewById(R.id.view_id);
//        post_button.setOnClickListener(new View.OnClickListener() {
//            public void onClick(View v) {
//                System.out.println("This is a GET");
//                final TextView mTextView = (TextView) findViewById(R.id.text);
//
//                // Instantiate the RequestQueue.
//                RequestQueue queue = Volley.newRequestQueue(getApplicationContext());
//                String url ="https://script.google.com/macros/s/AKfycby_J-YAi-S4DdH2WSwMOB3SjOzIqWCYqRC1fEg2ddkNJroOXiF6/exec";
//
//                // Request a string response from the provided URL.
//                StringRequest stringRequest = new StringRequest(Request.Method.GET, url,
//                        new Response.Listener<String>()
//                        {
//                            @Override
//                            public void onResponse(String response) {
//                                // Display the first 500 characters of the response string.
//                                System.out.println("response" + response.toString());
//                            }
//                        },
//
//                        new Response.ErrorListener()
//                        {
//                            @Override
//                            public void onErrorResponse(VolleyError error)
//                            {
//                                System.out.println("That didn't work!!!");
//                            }
//                        });
//
//
//                // Add the request to the RequestQueue.
//                queue.add(stringRequest);
//                System.out.println("done GET");
//
//
//            }
//        });
//    }
}



