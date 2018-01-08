package com.example.rabin.jokeys.Game;

import android.content.Context;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonArrayRequest;
import com.android.volley.toolbox.Volley;
import com.example.rabin.jokeys.R;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

public class MobileLegendsActivity extends AppCompatActivity {

    RecyclerView mRecyclerView;
    RecyclerView.Adapter mAdapter;
    RecyclerView.LayoutManager mManager;
    RequestQueue mRequest;
    List<ModelJoki> mListItemJoki;

    private final String url = "http://misterbaong.com/PostJoki2.php";


    private static final String TAG ="MobileLegendsActivity";
    private Context mContext;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mobile_legends);
        //recycle joki
        mRecyclerView = (RecyclerView)findViewById(R.id.RecyclerML);
        mRequest = Volley.newRequestQueue(getApplicationContext());
        mListItemJoki =  new ArrayList<>();

        request();

        mManager = new LinearLayoutManager(this,LinearLayoutManager.VERTICAL,false);
        mRecyclerView.setLayoutManager(mManager);
        mAdapter = new AdapterJoki(mListItemJoki,MobileLegendsActivity.this);
        mRecyclerView.setAdapter(mAdapter);



        mContext = MobileLegendsActivity.this;
        Log.d(TAG, "onCreate: started");
        //buat kembali
        ImageView backArrow =(ImageView) findViewById(R.id.backArrow);
        backArrow.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Log.d(TAG, "onClick: kembali ke 'GameActivity'");
                finish();
            }
        });

    }
    private void request(){
        JsonArrayRequest requestDompet = new JsonArrayRequest(Request.Method.POST, url, null,
                new Response.Listener<JSONArray>() {
                    @Override
                    public void onResponse(JSONArray response) {
                        Log.d("JSONResponse",response.toString());

                        for (int i = 0; i<response.length(); i++){
                            try {
                                JSONObject data = response.getJSONObject(i);
                                ModelJoki model = new ModelJoki();
                                model.setNama_Joki(data.getString("Nama_Joki"));
                                model.setNo_HP(data.getString("No_HP"));

                                mListItemJoki.add(model);
                            } catch (JSONException e) {
                                e.printStackTrace();
                            }
                            mAdapter.notifyDataSetChanged();
                        }

                    }
                },
                new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {
                        Log.d("ERRORRequest", "ERROR" + error.getMessage());
                    }
                });

        mRequest.add(requestDompet);
    }
}
