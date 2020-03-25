package com.ucs_tgi.trackcovid.ui.home;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.WebView;
import android.widget.ProgressBar;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.fragment.app.Fragment;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.ucs_tgi.trackcovid.R;
import com.ucs_tgi.trackcovid.WebNews;

import org.json.JSONException;
import org.json.JSONObject;


public class HomeFragment extends Fragment {

    private TextView tvTotalConfirmed, tvTotalDeaths, tvTotalRecover;
    CardView cardViewNews;
    private ProgressBar progressBar;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {

        View root = inflater.inflate(R.layout.fragment_home, container, false);

        //call view
        tvTotalConfirmed = root.findViewById(R.id.tvTotalConfirmed);
        tvTotalDeaths = root.findViewById(R.id.tvTotalDeath);
        tvTotalRecover = root.findViewById(R.id.tvTotalRecover);
        cardViewNews = root.findViewById(R.id.covid_news);
        progressBar = root.findViewById(R.id.progress_circular_home);
        //call Volley
        getData();
        cardViewNews.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
               GotoWebsiteOfNews();
            }
        });
        return root;
    }

    private void GotoWebsiteOfNews() {
        Intent intent = new Intent(getActivity(), WebNews.class);
        startActivity(intent);
    }

    private void getData() {
        RequestQueue queue = Volley.newRequestQueue(getActivity());

        String url1 = "https://corona.lmao.ninja/all";
        StringRequest stringRequest = new StringRequest(Request.Method.GET, url1, new Response.Listener<String>() {
            @Override
            public void onResponse(String responses) {
                progressBar.setVisibility(View.GONE);
                try {
                    JSONObject jsonObject = new JSONObject(responses);
                    tvTotalConfirmed.setText(jsonObject.getString("cases"));
                    tvTotalDeaths.setText(jsonObject.getString("deaths"));
                    tvTotalRecover.setText(jsonObject.getString("recovered"));
                } catch (JSONException e) {
                    e.printStackTrace();
                }
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                progressBar.setVisibility(View.GONE);
                Log.d("Error Response", error.toString());
            }

        });
        queue.add(stringRequest);
    }
}