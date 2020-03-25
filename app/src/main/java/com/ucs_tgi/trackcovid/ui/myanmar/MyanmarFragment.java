package com.ucs_tgi.trackcovid.ui.myanmar;

import androidx.lifecycle.ViewModelProviders;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ProgressBar;
import android.widget.TextView;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.ucs_tgi.trackcovid.R;

import org.json.JSONException;
import org.json.JSONObject;

public class MyanmarFragment extends Fragment {
    private TextView mmConfirmedCase,mmDeaths,mmRecover,mmTodayCases;
    private ProgressBar progressBar;
    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {

        View root = inflater.inflate(R.layout.myanmar_fragment, container, false);
        //call view
        mmConfirmedCase=root.findViewById(R.id.myanmar_confirm_cases);
        mmDeaths=root.findViewById(R.id.myanmar_total_death);
        mmRecover=root.findViewById(R.id.mmRecover);
        mmTodayCases=root.findViewById(R.id.mmTodayCases);
        progressBar=root.findViewById(R.id.progress_circular_myanmar);

        //get Data of Myanmar
        getData_Myanmar();

        return root;
    }

    private void getData_Myanmar() {
        RequestQueue queue= Volley.newRequestQueue(getActivity());

        String url1="https://corona.lmao.ninja/countries/myanmar";
        StringRequest stringRequest=new StringRequest(Request.Method.GET, url1, new Response.Listener<String>() {
            @Override
            public void onResponse(String responses) {
                progressBar.setVisibility(View.GONE);
                try {
                    JSONObject jsonObject = new JSONObject(responses);
                    mmConfirmedCase.setText(jsonObject.getString("cases"));
                    mmDeaths.setText(jsonObject.getString("deaths"));
                    mmTodayCases.setText(jsonObject.getString("todayCases"));
                    mmRecover.setText(jsonObject.getString("recovered"));

                } catch (JSONException e) {
                    e.printStackTrace();
                }
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                progressBar.setVisibility(View.GONE);
                Log.d("Error Response",error.toString());
            }

        });
        queue.add(stringRequest);
    }
    }



