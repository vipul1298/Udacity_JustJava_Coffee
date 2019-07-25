package android.example.weatherforecast;

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
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    EditText city;
    TextView desc,tv1,tv2;
    Button sear;
    String str;
    RequestQueue requestQueue;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        city=findViewById(R.id.city);
        desc=findViewById(R.id.result);
        tv1=findViewById(R.id.tempmax);
        tv2=findViewById(R.id.tempmin);
        sear=findViewById(R.id.search);
        sear.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String locate = city.getText().toString();
                loadurl(locate);
            }
        });
    }
    public void loadurl(String locate){
        String URL="https://api.openweathermap.org/data/2.5/weather?q="+locate+"&appid=966a21a57c0dae6398c932017b93f807";
        JsonObjectRequest request=new JsonObjectRequest(Request.Method.GET, URL, null,
                new Response.Listener<JSONObject>() {
                    @Override
                    public void onResponse(JSONObject response) {
                        try {
                            JSONObject jsonObject=response.getJSONObject("main");
                            Double temp=jsonObject.getDouble("temp_max");
                            int tMax = (int) (temp-273.15);
                            Double temp1=jsonObject.getDouble("temp_min");
                            int tMin = (int) (temp1-273.15);
                            tv1.setText(tMax+"");
                            tv2.setText(tMin+"");
                            JSONArray data = response.getJSONArray("weather");
                                JSONObject st = data.getJSONObject(0);
                                str=st.getString("description");
                                desc.setText(str);

                        } catch (JSONException e) {
                            e.printStackTrace();
                        }

                    }
                }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                error.printStackTrace();
            }
        });
        requestQueue = Volley.newRequestQueue(MainActivity.this);
        requestQueue.add(request);
    }

}
