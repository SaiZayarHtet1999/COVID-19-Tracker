package com.ucs_tgi.trackcovid.ui.country;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.squareup.picasso.Picasso;
import com.ucs_tgi.trackcovid.R;


import java.util.ArrayList;

public class CovidCountryAdapter extends RecyclerView.Adapter<CovidCountryAdapter.ViewHolder> {
    ArrayList<covidCountry> covidCountries;

    public CovidCountryAdapter(ArrayList<covidCountry> covidCountries){
        this.covidCountries = covidCountries;
    }

    @NonNull
    @Override
    public CovidCountryAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View  view= LayoutInflater.from(parent.getContext()).inflate(R.layout.item_list_covid_country,parent,false);



        return new ViewHolder( view);
    }

    @Override
    public void onBindViewHolder(@NonNull CovidCountryAdapter.ViewHolder holder, int position) {
        covidCountry covidCountry1= covidCountries.get(position);
    holder.tvTotalCases.setText(covidCountry1.getmCases());
    holder.tvCountryName.setText(covidCountry1.getmCovidCountry() );
    holder.tvCountryDeath.setText(covidCountry1.getmDeaths());
    holder.TvCountryRecover.setText(covidCountry1.getmRecovered());


    //flag for country




    Picasso.get().load("http://i.imgur.com/DvpvklR.png").into(holder.country_flag);
    }

    @Override
    public int getItemCount() {
        return covidCountries.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder{
        TextView tvTotalCases, tvCountryName ,tvCountryDeath,TvCountryRecover;
        ImageView country_flag;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);

            tvTotalCases=itemView.findViewById(R.id.tvTotlaCase);
            tvCountryName=itemView.findViewById(R.id.tvCountryName);
            country_flag=itemView.findViewById(R.id.country_flag);
            tvCountryDeath=itemView.findViewById(R.id.tvCountryDeath);
            TvCountryRecover=itemView.findViewById(R.id.tvCountryRecover);

        }
    }

}


